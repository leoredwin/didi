/*
 * Package name:com.leo.bootstrap
 * File name:FundChargeRepair.java
 * Date:2017-07-26 17:35
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap;

import com.google.common.collect.Lists;
import com.leo.bootstrap.model.BuildRepaymentModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-07-26 17:35
 */
public class FundChargeRepair {
    private static final String head = "curl -l -H \"Content-type: application/json\" -X POST -d '";
    private static final String url = "' http://localhost:8125/fund/charge/remodel";
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");


    private static final List<BuildRepaymentModel> buildRepaymentModels = new ArrayList<>();

    public static void main(String[] args) {
        //处理文件
        handleFile();
    }

    private static void handleFile() {
        getOrderDataFilePath().stream().forEach(path -> new HandleFile(path).run());
        String path = "C:\\Users\\niushw\\Desktop\\fund_charge_servicefee_negative_repair.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            List<List<BuildRepaymentModel>> parts = Lists.partition(buildRepaymentModels, 80);
            for (List<BuildRepaymentModel> buildRepaymentModels: parts){
                String jason = head + buildRepaymentModels.toString() + url + ";\r\n";
                try {
                    bufferedWriter.write(jason);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleFile implements Runnable {

        private String path;

        public HandleFile(String path) {
            this.path = path;
        }

        @Override
        public void run() {

            try {
                renameFile(path);
            } catch (Exception e) {
                System.out.print(e);
            }
        }

        private void renameFile(String localFileName) {
            new FilesWorker<BuildRepaymentModel>(
                    localFileName,
                    new TransLineFunction<BuildRepaymentModel>() {
                        @Override
                        BuildRepaymentModel deal(String line) {
                            String[] split = cutData(line);
                            if (split != null) {
                                BuildRepaymentModel buildRepaymentModel = new BuildRepaymentModel();
                                buildRepaymentModel.setAppId(split[0]);
                                buildRepaymentModel.setProductId(split[1]);
                                buildRepaymentModel.setFundId(split[2]);
                                buildRepaymentModel.setRepayments(Integer.valueOf(split[3]));
                                buildRepaymentModel.setPrincipal(new BigDecimal(split[4]));
                                return buildRepaymentModel;
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<BuildRepaymentModel>() {
                        @Override
                        void work(BuildRepaymentModel buildRepaymentModel) {
                            buildRepaymentModels.add(buildRepaymentModel);
                        }
                    }
            ) {
            }.run();
        }
    }

    public static List<String> getOrderDataFilePath() {
        return new ArrayList<>(Arrays.asList(
                "C:\\Users\\niushw\\Desktop\\服务费是负值修复.txt"
        ));
    }

    //截取文件中数据行
    public static String[] cutData(String line) {
        return line.split("\\|");
    }
}