package com.leo.bootstrap;

import com.leo.bootstrap.model.*;
import com.leo.util.CreateFile;
import com.leo.util.ExcelUtil;
import com.leo.util.JSONUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by niushw on 2016/12/8.
 */
public class BuildWithholding {
    private static final String head = "curl -l -H \"Content-type: application/json\" -X POST -d '";
    private static final String withhold_url = "' http://localhost:8120/accounting/batch-charge";
    private static final String payment_url = "' http://localhost:8199//fund/payment";
    private static final String credit_url = "' http://localhost:8082/CreditAccount/creditFundCancel";
    private static final String sing_url = "' http://localhost:8120/accounting/sign";
    private static final String SELF_JD = "2CFA6C89-901A-4AB5-BB01-4B5E3B28922F";
    private static final String JD = "AE1EEB3E-4A3C-451A-93D5-A261EB4CCC75";
    private static final String HF = "51C4B39C-AD3D-4FFF-BAF5-B5E1A7625EB8";
    private static final String dingding_robot_url = "https://oapi.dingtalk.com/robot/send?access_token=a27ab5e7e4eea94def01fa97bd1411496b686c8d503b5190c5059c8cd93efe67";
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");


    private static final List<BatchChargeRequest> batchChargeRequestList = new ArrayList<>();
    private static final List<SignRequest> signRequestList = new ArrayList<>();
    private static List<ACCTFundCancelReq> acctFundCancelReqs = new ArrayList<>();
    private static List<ACCTFundCancelResp> acctFundCancelResps = new ArrayList<>();
    private static List<PaymentModel> paymentModels = new ArrayList<>();
    private static List<String> acctFundCancelResps1 = new ArrayList<>();
    private static List<ChargeSuccessModel> chargeSuccessModels = new ArrayList<>();
    private static final List<String> list1 = new ArrayList<>();
    private static final List<String> list2 = new ArrayList<>();
    private static final List<String> list3 = new ArrayList<>();
    private static final Set<String> set = new HashSet<>();
    private static final List<String> credit_files = new ArrayList<>(Arrays.asList(
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\1.15",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\1.16",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\1.17",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\1.18",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.2",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.3",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.4",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.5",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.6",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.7",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.8",
            "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\2.9"
    ));

    public static void main(String[] args) {
        //代扣脚本 注意fundid 需要appid userid
//        withholdCreate();

        //签约脚本
//        sign();
        //对比文件
//        getDuplicaList();

        //抹账脚本
//        creditAccount();
        //对比文件
//        compareFile();
//        System.out.println(line);

//        payment();

        chargeSuccess();
    }

    private static void getDuplicaList() {
        getOrderDataFilePath().stream().forEach(path -> {
            compater(path);
            result(list1, list2);
            String file1 = "C:\\Users\\niushw\\Desktop\\result_not_withhold.txt";
            writeFile(file1, list3, null);
            String file2 = "C:\\Users\\niushw\\Desktop\\result_withhold.txt";
            writeFile(file2, null, set);
        });
    }

    private static void writeFile(String file1, List<String> list3, Set<String> set) {
        String n = file1;
        File file = new File(n);
        List<String> list = new ArrayList();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            if (list3 != null) {
                list.addAll(list3);
            } else if (set != null) {
                list.addAll(set);
            }
            for (String s : list) {
                bufferedWriter.write(s + "\t\n");
                bufferedWriter.flush();

            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void withholdCreate() {
        getOrderDataFilePath().stream().forEach(path -> new WithholdWork(path, SELF_JD).run());
        String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-14\\repayment_batch_76_self_jd.sh";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            List<BatchChargeRequest> batchChargeRequests = new ArrayList<>();
            int line = 0;
            for (BatchChargeRequest batchChargeRequest : batchChargeRequestList) {
                batchChargeRequests.add(batchChargeRequest);
                if (batchChargeRequests.size() == 100) {
                    line++;
                    String jason = head + batchChargeRequests.toString() + withhold_url + "\r\n";
                    bufferedWriter.write(jason);
                    batchChargeRequests = new ArrayList<>();
                }
                if (line == 5) {
                    bufferedWriter.write("sleep 1" + "\r\n");
                    line = 0;
                }
            }
            String jason = head + batchChargeRequests.toString() + withhold_url + "\r\n";
            bufferedWriter.write(jason);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void payment() {
        getOrderDataFilePath().stream().forEach(path -> new Payment(path).run());
        String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-20\\payment_batch_10_jd.sh";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            for (PaymentModel paymentModel : paymentModels) {
                String jason = head + paymentModel.toString() + payment_url + "\r\n";
                bufferedWriter.write(jason);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void chargeSuccess() {
        getOrderDataFilePath().stream().forEach(path -> new ChargeSuccessUtil(path).run());
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (ChargeSuccessModel chargeSuccessModel:chargeSuccessModels){
            totalAmount = totalAmount.add(chargeSuccessModel.getRealBuckleAmount());
        }
        String data = CreateFile.createFile(chargeSuccessModels, ChargeSuccessModel.class, totalAmount);
        String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-22\\chargeSuccess.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sign() {
        getOrderDataFilePath().stream().forEach(path -> new Sign(path).run());
        String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\sign_self_jd_5_weekend.sh";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            final int[] line = {0};
            signRequestList.stream().forEach(signRequest -> {
                String jason = head + signRequest.toString() + sing_url + "\r\n";
                line[0]++;
                try {
                    bufferedWriter.write(jason);
                    if (line[0] == 5) {
                        bufferedWriter.write("sleep 1" + "\r\n");
                        line[0] = 0;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void creditAccount() {
        List<String> patList = getOrderDataFilePath();

        for (String path1 : patList) {
            File filePath = new File(path1);
            String fileName = filePath.getName();
            fileName = fileName.replace(".", "-");
            new CreditAccount(path1).run();
            String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_" + fileName + ".sh";
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWritter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
                final int[] line = {0};
                acctFundCancelReqs.stream().forEach(acctFundCancelReq -> {
                    String jason = head + acctFundCancelReq.toString() + credit_url + "\r\n";
                    line[0]++;
                    try {
                        bufferedWriter.write(jason);
                        if (line[0] == 5) {
                            bufferedWriter.write("sleep 1" + "\r\n");
                            line[0] = 0;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            acctFundCancelReqs = new ArrayList<>();
        }
    }

    private static void compareFile() {
        getOrderDataFilePath().stream().forEach(path -> new CompareFile(path).run());
        getOrderDataFilesPath().stream().forEach(path -> new getFiles(path).run());
        creditResult(acctFundCancelReqs, acctFundCancelResps);
        String path = "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_resp.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            acctFundCancelResps1.stream().forEach(data -> {
                data = data + "\r\n";
                try {
                    bufferedWriter.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getOrderDataFilePath() {
        return new ArrayList<>(Arrays.asList(
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-22\\20170222-代偿后还款第一批数据截止0220.xlsx"
        ));
    }

    public static List<String> getOrderDataFilesPath() {
        return new ArrayList<>(Arrays.asList(
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-13.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-14.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-15.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-16.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-17.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_1-18.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-2.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-3.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-4.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-5.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-6.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-7.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-8.sh",
                "C:\\Users\\niushw\\Desktop\\work\\2017-02-10\\credit_account_2-9.sh"
        ));
    }

    public static void result(List<String> list1, List<String> list2) {
        boolean n = false;
        for (String s : list1) {
            for (String k : list2) {
                if (s.equals(k)) {
                    set.add(s);
                    n = true;
                }
            }
            if (!n) {
                list3.add(s);
            }
            n = false;
        }
    }

    public static void creditResult(List<ACCTFundCancelReq> list1, List<ACCTFundCancelResp> list2) {
        boolean n = false;
        for (ACCTFundCancelReq s : list1) {
            for (ACCTFundCancelResp k : list2) {
                if (k.getRequestId() != null) {
                    if (s.getRequestId().equals(k.getRequestId())) {
                        n = true;
                    }
                }
            }
            if (!n) {
                acctFundCancelResps1.add(s.getOriginRequestId());
            }
            n = false;
        }
    }

    public static void compater(String path) {
        new FilesWorker<BatchChargeRequest>(
                path,
                new TransLineFunction<BatchChargeRequest>() {
                    @Override
                    BatchChargeRequest deal(String line) {
                        String[] split = cutData(line);
                        if (split != null) {
                            list1.add(split[0]);
                            if (split.length > 1 && !split[1].equals("k\t")) {
                                list2.add(split[1]);
                            }
                            return new BatchChargeRequest();
                        } else {
                            return null;
                        }
                    }
                },
                new WorkDetail<BatchChargeRequest>() {
                    @Override
                    void work(BatchChargeRequest batchChargeRequest) {
                    }
                }
        ) {
        }.run();
    }

    static class WithholdWork implements Runnable {

        private String path;

        private String fundSource;

        public WithholdWork(String path, String fundSource) {
            this.path = path;
            this.fundSource = fundSource;
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
            new FilesWorker<BatchChargeRequest>(
                    localFileName,
                    new TransLineFunction<BatchChargeRequest>() {
                        @Override
                        BatchChargeRequest deal(String line) {
                            String[] split = cutData(line);
                            if (split != null) {
                                BatchChargeRequest batchChargeRequest = new BatchChargeRequest();
                                batchChargeRequest.setAppId(split[0]);
                                batchChargeRequest.setUserId(split[1]);
                                batchChargeRequest.setFundId(fundSource);
                                batchChargeRequest.setOperator("fund");
                                batchChargeRequest.setAppType(10);
                                return batchChargeRequest;
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<BatchChargeRequest>() {
                        @Override
                        void work(BatchChargeRequest batchChargeRequest) {
                            batchChargeRequestList.add(batchChargeRequest);
                        }
                    }
            ) {
            }.run();
        }
    }

    static class Payment implements Runnable {

        private String path;

        public Payment(String path) {
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
            new FilesWorker<PaymentModel>(
                    localFileName,
                    new TransLineFunction<PaymentModel>() {
                        @Override
                        PaymentModel deal(String line) {
                            String[] split = cutData(line);
                            if (split != null) {
                                PaymentModel paymentModel = new PaymentModel();
                                paymentModel.setAppId(split[1]);
                                paymentModel.setUserId(split[2]);
                                paymentModel.setAmount(new BigDecimal(split[9]));
                                paymentModel.setRepayments(Byte.parseByte(split[10]));
                                paymentModel.setPhone(split[5]);
                                paymentModel.setPaymentFundId(JD);
                                paymentModel.setUserName(split[3]);
                                paymentModel.setIdCard(split[4]);
                                paymentModel.setBankCode(split[8]);
                                paymentModel.setBankName(split[7]);
                                paymentModel.setBankAccount(split[6]);
                                paymentModel.setPayDate(new Date());
                                return paymentModel;
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<PaymentModel>() {
                        @Override
                        void work(PaymentModel batchChargeRequest) {
                            paymentModels.add(batchChargeRequest);
                        }
                    }
            ) {
            }.run();
        }
    }

    static class ChargeSuccessUtil implements Runnable {

        private String path;

        public ChargeSuccessUtil(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            try {
                File file = new File(path);
                JSONArray singleFileDataArr = ExcelUtil.readExcel(file.getName(), FileUtils.readFileToByteArray(file), null);
                JSONObject rowData;
                Integer j = 0;
                for (int i = 0; i < singleFileDataArr.size(); i++) {
                    rowData = singleFileDataArr.getJSONObject(i);
                    j = 0;
                    ChargeSuccessModel chargeSuccessModel = new ChargeSuccessModel();
                    chargeSuccessModel.setOrgCode(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setContractNo(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setChargeMethod(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setChargeType(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setDerateFlag(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setName(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setIdNo(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setCardId(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setCurrentStatus(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setCurrentInstallmentNum(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setRealBuckleAmount(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBucklePrincipal(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBuckleInterest(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBucklePenaltyInsterest(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBuckleDedit(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBuckleHandFee(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBuckleGuaranteeFee(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setRealBuckleServiceFee(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setOverdueDays(rowData.getString(String.valueOf(j)));
                    j++;
                    chargeSuccessModel.setChargeDate(ymd.format(ymd.parse(rowData.getString(String.valueOf(j)))));
                    j++;
                    chargeSuccessModel.setFee1(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setFee2(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setFee3(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setReliefPrincipalInterest(new BigDecimal(rowData.getString(String.valueOf(j))));
                    j++;
                    chargeSuccessModel.setFee5(new BigDecimal(rowData.getString(String.valueOf(j))));
                    chargeSuccessModels.add(chargeSuccessModel);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class Sign implements Runnable {

        private String path;

        public Sign(String path) {
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
            new FilesWorker<SignRequest>(
                    localFileName,
                    new TransLineFunction<SignRequest>() {
                        @Override
                        SignRequest deal(String line) {
                            String[] split = cutData(line);
                            if (split != null) {
                                SignRequest signRequest = new SignRequest();
                                signRequest.setUserId(split[0]);
                                signRequest.setAccessor("Fund");
                                signRequest.setChannelCode("");
                                signRequest.setIdName(split[1]);
                                signRequest.setIdCard(split[2]);
                                signRequest.setPhone(split[3]);
                                signRequest.setBankAccount(split[4]);
                                signRequest.setBankName(split[5]);
                                signRequest.setBankCode(split[6]);
                                signRequest.setMemo("fund-Base");
                                signRequest.setExtensionInfo("");
                                signRequest.setOperatorId("resign20170210");
                                signRequest.setFundId(SELF_JD);
                                return signRequest;
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<SignRequest>() {
                        @Override
                        void work(SignRequest signRequest) {
                            signRequestList.add(signRequest);
                        }
                    }
            ) {
            }.run();
        }
    }

    static class CreditAccount implements Runnable {

        private String path;

        public CreditAccount(String path) {
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
            new FilesWorker<ACCTFundCancelReq>(
                    localFileName,
                    new TransLineFunction<ACCTFundCancelReq>() {
                        @Override
                        ACCTFundCancelReq deal(String line) {
                            if (line != null) {
                                ACCTFundCancelReq acctFundCancelReq = new ACCTFundCancelReq();
                                acctFundCancelReq.setOriginRequestId(line);
                                acctFundCancelReq.setRequestId(UUID.randomUUID().toString());
                                acctFundCancelReq.setAccessor("fund-repair");
                                acctFundCancelReq.setSignature("88888");
                                return acctFundCancelReq;
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<ACCTFundCancelReq>() {
                        @Override
                        void work(ACCTFundCancelReq acctFundCancelReq) {
                            acctFundCancelReqs.add(acctFundCancelReq);
                        }
                    }
            ) {
            }.run();
        }
    }

    static class CompareFile implements Runnable {

        private String path;

        public CompareFile(String path) {
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
            new FilesWorker<ACCTFundCancelResp>(
                    localFileName,
                    new TransLineFunction<ACCTFundCancelResp>() {
                        @Override
                        ACCTFundCancelResp deal(String line) {
                            if (line != null) {
                                return JSONUtil.jsonToObject(line, ACCTFundCancelResp.class);
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<ACCTFundCancelResp>() {
                        @Override
                        void work(ACCTFundCancelResp acctFundCancelReq) {
                            acctFundCancelResps.add(acctFundCancelReq);
                        }
                    }
            ) {
            }.run();
        }
    }

    static class getFiles implements Runnable {

        private String path;

        public getFiles(String path) {
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
            new FilesWorker<ACCTFundCancelReq>(
                    localFileName,
                    new TransLineFunction<ACCTFundCancelReq>() {
                        @Override
                        ACCTFundCancelReq deal(String line) {
                            if (line != null && !line.equalsIgnoreCase("sleep 1")) {
                                line = line.substring(head.length(), line.indexOf("}") + 1);
                                return JSONUtil.jsonToObject(line, ACCTFundCancelReq.class);
                            } else {
                                return null;
                            }
                        }
                    },
                    new WorkDetail<ACCTFundCancelReq>() {
                        @Override
                        void work(ACCTFundCancelReq acctFundCancelReq) {
                            if (!acctFundCancelReq.getOriginRequestId().equals("ad62cfbf-8b76-4137-ba4c-a2d19759729d")) {
                                acctFundCancelReqs.add(acctFundCancelReq);
                            }
                        }
                    }
            ) {
            }.run();
        }
    }

    //截取文件中数据行
    public static String[] cutData(String line) {
        return line.split("\\|");
    }
}
