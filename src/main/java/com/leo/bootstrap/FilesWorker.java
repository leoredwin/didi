package com.leo.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Leo on 2016/8/24.
 */
@Service
public class FilesWorker<P> {

    private static final Logger logger = LoggerFactory.getLogger(FilesWorker.class);

    private String fileName;    //文件名称
    private TransLineFunction<P> transLineFunction;     //将文件的一行, 变成一个PO的方法
    private WorkDetail<P> workDetail; //具体的操作

    public FilesWorker(String fileName, TransLineFunction<P> transLineFunction, WorkDetail<P> workDetail) {
        this.fileName = fileName;
        this.transLineFunction = transLineFunction;
        this.workDetail = workDetail;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                P reduce = transLineFunction.deal(str);
                if (reduce != null) {
                    workDetail.work(reduce);
                }
            }

        } catch (IOException e) {
            logger.error("fileName:{},文件传出IO异常", fileName, e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error("fileName:{},bufferedReader关闭异常", fileName, e);
                }
            }
        }
    }
}
