package com.leo.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuanxx on 2016/10/21.
 */
public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
    public static  JSONArray readExcel(String fileName, byte []fileData,List<String> titleList) {
        JSONArray singleFileDataArr=new JSONArray();
        if(titleList==null) {
            titleList=new ArrayList<>();
        }
        Workbook workbook = null;
        InputStream in = null;
        try {
            if(fileName.endsWith("xlsx")){//2007
                workbook =  new XSSFWorkbook(new ByteArrayInputStream(fileData));
            }else if(fileName.endsWith("xls")){
                workbook = new HSSFWorkbook(new ByteArrayInputStream(fileData));
            }else {
                return null;
            }
            int end = workbook.getNumberOfSheets();
            JSONObject rowJson;
            Sheet shSetData;
            for (int i =0 ; i <end; i++) {
                shSetData= workbook.getSheetAt(i);
                if (shSetData != null) {
                    getInfoFromSheet(shSetData,singleFileDataArr,titleList);
                }
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
        }
        return  singleFileDataArr;
    }


    private static void getInfoFromSheet(Sheet shSetData,JSONArray allRowInSheets,List<String> titleList)
            throws IOException {
        int i =0;//
        Row row = null;
        JSONObject cellData = null;
        Iterator<Cell> cellIterator;
        Cell cell;
        while ((row =shSetData.getRow(i)) != null) {

            if(i==0){//新的sheet页
                if(titleList.size()>0){//每个sheet页都有title行，当下个sheet进来的时候就不处理title行了
                    i++;
                    continue;
                }
                cellIterator=row.cellIterator();
                while (cellIterator.hasNext()){
                    cell=cellIterator.next();
                    if(cell!=null){
                        titleList.add(getCellValue(cell));
                    }
                }
            }else{
                cellData=new JSONObject();
                for(int j=0;j<titleList.size();j++){
                    cellData.put(j,getCellValue(getCell(row,j)));
                }
                allRowInSheets.add(cellData);
            }
            i++;
        }
    }

    private static Cell getCell(Row row,int columnIndex) {
        if (row == null)
            return null;
        Cell cell = row.getCell(columnIndex);
        if (cell == null)
            return null;
        return cell;
    }

    // 获取单元格数据内容为字符串类型的数据
    private static String getCellValue(Cell cell) {
        String value = "";
        if(cell == null){
            return "";
        }
        switch (cell.getCellTypeEnum()) {
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue()?"true":"false";
                break;
            case ERROR:
                value = ErrorEval.getText(cell.getErrorCellValue());
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            // 如果当前Cell的Type为NUMERIC
            case NUMERIC:
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，取得该Cell的Date值
                    DateFormat df ;
                    Calendar calendar =Calendar.getInstance();
                    calendar.setTime(cell.getDateCellValue());
//                    if(calendar.get(Calendar.HOUR)!=0||calendar.get(Calendar.MINUTE)!=0){
                        df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    }else{
//                        df= new SimpleDateFormat("yyyy-MM-dd");
//                    }
                    value = df.format(cell.getDateCellValue());
                } else {
                    cell.setCellType(CellType.STRING);

                    value = cell.getStringCellValue();
                }
                break;
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
        }
        return value;
    }

    public static byte[] writeExcel(String outFileType, JSONArray contentArr,List<String> titleList){
        Workbook writeWorkbook=null;
        Sheet targetSheet=null;
        if("xlsx".equals(outFileType)){//2007
            writeWorkbook =  new XSSFWorkbook();
        }else if("xls".equals(outFileType)){
            writeWorkbook = new HSSFWorkbook();
        }else {
            return null;
        }
        Row targetRow;
        Cell targetCell;
        int rowIndex = 0;
        int columIndex=0;
        JSONObject rowData;
        boolean createTitle=true;
        int sheetIndex=0;
        for (int j=0;j<contentArr.size();) {  //读取
            if(j%500==0&&createTitle) {
                targetSheet = writeWorkbook.createSheet("datas"+sheetIndex++);
                rowIndex=0;
                createTitle=false;
            }
            targetRow = targetSheet.createRow(rowIndex);  //创建新行
            columIndex=0;//重置列号
            if(rowIndex==0) {//表头
                for(String title:titleList) {
                    targetCell = targetRow.createCell(columIndex++);  //创建新列
                    targetCell.setCellValue(title);  //赋值
                }
            }else {//内容

                rowData=contentArr.getJSONObject(j);//准备行数据
                for (int k = 0; k < titleList.size(); k++) {
                    targetCell = targetRow.createCell(columIndex++);  //创建新列
                    targetCell.setCellValue(rowData.getString(String.valueOf(k)));  //赋值
                }
                j++;
                createTitle=true;//允许下次设置表头
            }
            rowIndex ++;
        }
        try {//目标文件
            ByteArrayOutputStream outputExcel = new ByteArrayOutputStream();
            writeWorkbook.write(outputExcel);
            outputExcel.flush();  //清空缓冲区数据
            outputExcel.close();
            logger.info("-------------- create excel success：{}");
            return outputExcel.toByteArray();
        } catch (Exception e) {
            logger.error("-------------- create excel   Exception：{}",e.getMessage());
            return  null;
        }finally {

        }
    }


}
