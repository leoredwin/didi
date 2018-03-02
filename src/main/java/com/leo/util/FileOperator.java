package com.leo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanlw
 * @version $ID: FileOperator.java, v 0.1 2016-08-03 17:39
 * @ Email: tanlw@fenqi.im
 * @ Copyright (C), 上海秦苍信息科技有限公司
 */
public class FileOperator {

    private final static Logger logger = LoggerFactory.getLogger(FileOperator.class);

    public static void StringToFile(String data, String dirName, String filename) throws IOException {

        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(dirName + "/" + filename, false);
        try {
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            logger.error("生成文件失败", e);
        }

    }

    public static void inputStreamToFile(InputStream inputStream, String dirName, String filename) throws IOException {

        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream os = new FileOutputStream(new File(dirName + "/" + filename));
        try {
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        } catch (Exception e) {
            logger.error("生成文件失败", e);
        } finally {
            os.close();
            inputStream.close();
        }
    }

    public static List<String> getFiles(String path) {
        List<String> filelist = new ArrayList<>();
        File root = new File(path);
        if (!root.exists()) {
            return filelist;
        }
        File[] files = root.listFiles();
        for (File file : files) {
            filelist.add(file.getAbsolutePath());
        }
        return filelist;
    }

    public static List<String> getRelativeNameFiles(String path) {
        List<String> filelist = new ArrayList<>();
        File root = new File(path);
        File[] files = root.listFiles();
        for (File file : files) {
            filelist.add(file.getName());
        }
        return filelist;
    }

    //	1.多层路径一次创建
    public static File createDirs(String path) {
        File dirs = new File(path);
        if (!dirs.exists()) {
            dirs.mkdirs();
        }
        return dirs;
    }

    //	1.创建单层文件夹
    public static File createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    //2.创建新文件
    public static File createFile(String path, String filename) throws Exception {
        File file = null;
        file = new File(path + "/" + filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    //删除文件和目录
    public static void clearFiles(String workspaceRootPath) {
        File file = new File(workspaceRootPath);
        if (file.exists()) {
            deleteFile(new File(file.getAbsolutePath()));
        }
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFile(files[i]);
            }
        }
        file.delete();

    }

    /**
     * 文件后缀
     *
     * @return
     */
    public static String getFileExt(String fileName) {
        String ext = null;
        int i = fileName.lastIndexOf('.');
        if (i > 0 && i < fileName.length() - 1) {
            ext = fileName.substring(i + 1).toLowerCase();
        }
        return ext;
    }


    /**
     * 复制整个文件夹内容
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copyFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {

            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }

        } else if (src.isFile()) {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }

    }

    /**
     * @param base64    图片Base64数据
     * @param path      图片路径
     * @param imageName 图片名称
     * @return
     * @Descriptionmap 对字节数组字符串进行Base64解码并生成图片
     */
    public static boolean base64ToImage(String base64, String path, String imageName, String imageType) {// 对字节数组字符串进行Base64解码并生成图片
        if (base64 == null) { // 图像数据为空
            return false;
        }
        OutputStream out = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpg图片
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = path + "/" + imageName + imageType;
            out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "G:\\fenqi\\hawking\\fund-base\\fund-base-server\\jd_compliance";
        clearFiles(path);
//        File file = new File("e:/sftp.properties");
//        InputStream is = new FileInputStream(file);
//        FileOperator.inputStreamToFile(is,"e:/a.txt");
    }
}
