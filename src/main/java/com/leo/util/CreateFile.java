package com.leo.util;


import com.leo.bootstrap.model.OrderAnnotation;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author  leo
 * @version $ID: CreateFile.java, v 0.1 2016-10-11 14:39
 * @ Email: tanlw@fenqi.im
 * @ Copyright (C), 上海秦苍信息科技有限公司
 */
public class CreateFile {

    public static final String JD_SEPARATOR = "|+|";
    public final static String NEW_LINE_WINDOWS = "\r\n";


    public static <T> String createFile(List<T> list, Class clazz, BigDecimal totalAmount) {

        StringBuilder content = new StringBuilder();
        StringBuilder firstLine = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.sort(fields, (o1, o2) -> {
            OrderAnnotation annotationO1 = o1.getAnnotation(OrderAnnotation.class);
            OrderAnnotation annotationO2 = o2.getAnnotation(OrderAnnotation.class);
            return annotationO1.id() - annotationO2.id();
        });
        //起始行
        firstLine.append("version" + JD_SEPARATOR + "1" + JD_SEPARATOR
                + "总笔数" + JD_SEPARATOR + list.size() + JD_SEPARATOR
                + "总金额" + JD_SEPARATOR + totalAmount.setScale(2, BigDecimal.ROUND_DOWN));
        firstLine.append(NEW_LINE_WINDOWS);
        content.append(firstLine);
        //表头
        content.append(columns(JD_SEPARATOR, fields));
        //数据内容
        content.append(listToSubContent(list, JD_SEPARATOR, fields));
        return content.toString();
    }

    public static <T> String createFile(List<T> list,Class clazz){
        StringBuilder content = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.sort(fields, (o1, o2) -> {
            OrderAnnotation annotationO1 = o1.getAnnotation(OrderAnnotation.class);
            OrderAnnotation annotationO2 = o2.getAnnotation(OrderAnnotation.class);
            return annotationO1.id() - annotationO2.id();
        });
        //数据内容
        content.append(listToSubContent(list, JD_SEPARATOR, fields));
        return content.toString();
    }

    public static <T> String createFile(List<T> list,Class clazz,String separator){
        StringBuilder content = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.sort(fields, (o1, o2) -> {
            OrderAnnotation annotationO1 = o1.getAnnotation(OrderAnnotation.class);
            OrderAnnotation annotationO2 = o2.getAnnotation(OrderAnnotation.class);
            return annotationO1.id() - annotationO2.id();
        });
        //数据内容
        content.append(listToSubContent(list, separator, fields));
        return content.toString();
    }

    private static StringBuilder columns(String sepeartor, Field[] fields) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            OrderAnnotation annotation = fields[i].getAnnotation(OrderAnnotation.class);
            line.append(annotation.name());
            if (i < fields.length - 1) {
                line.append(sepeartor);
            }
        }
        line.append(NEW_LINE_WINDOWS);
        return line;
    }

    private static <T> StringBuilder listToSubContent(List<T> list, String sepeartor, Field[] fields) {
        StringBuilder subContent = new StringBuilder();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
        }
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            line.setLength(0);

            for (int j = 0; j < fields.length; j++) {
                try {
                    Object itemObject = fields[j].get(item);
                    line.append(itemObject == null ? "" : itemObject);
                    if (j < fields.length - 1) {
                        line.append(sepeartor);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            subContent.append(line);
            subContent.append(NEW_LINE_WINDOWS);
        }
        return subContent;
    }
}
