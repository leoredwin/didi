package com.leo.bootstrap;

import com.leo.bootstrap.model.SiteModel;
import com.leo.dal.BHLoanObjectMapper;
import com.leo.dal.object.BHLoanObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 4/6/2016.
 */
public class OrderReader {
    private static final Logger logger = LoggerFactory.getLogger(OrderReader.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    private static List<SiteModel> siteModelList = new ArrayList<>();

    public static void main(String[] args) {

        BHLoanObjectMapper bhLoanObjectMapper = (BHLoanObjectMapper) applicationContext
                .getBean("BHLoanObjectMapper");

        BootStrap.getOrderDataFilePath().forEach(path ->
                new OrderWorker(bhLoanObjectMapper, path).run());
    }

    static class OrderWorker implements Runnable {

        private String path;

        private BHLoanObjectMapper bhLoanObjectMapper;

        public OrderWorker(BHLoanObjectMapper bhLoanObjectMapper, String path) {
            this.bhLoanObjectMapper = bhLoanObjectMapper;
            this.path = path;
        }

        @Override
        public void run() {
            try {
                List<BHLoanObject> bhLoanObjectArrayList = bhLoanObjectMapper.getAll();
                new HandleFile(path).run();
                bhLoanObjectArrayList.stream().forEach(bhLoanObject -> siteModelList.stream().forEach(siteModel -> {
                    if (bhLoanObject.getAppId().equalsIgnoreCase(siteModel.getAppId())) {
                        bhLoanObject.setProductTypeName(siteModel.getSite());
                    }
                }));
                bhLoanObjectMapper.insertBatch(bhLoanObjectArrayList);
            } catch (Exception e) {
                System.out.println(e);
            }
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
            new FilesWorker<SiteModel>(
                    localFileName,
                    new TransLineFunction<SiteModel>() {
                        @Override
                        SiteModel deal(String line) {
                            String[] split = cutData(line);
                            SiteModel siteModel = new SiteModel();
                            siteModel.setAppId(split[0]);
                            siteModel.setSite(split[1]);
                            return siteModel;
                        }
                    },
                    new WorkDetail<SiteModel>() {
                        @Override
                        void work(SiteModel siteModel) {
                            siteModelList.add(siteModel);
                        }
                    }
            ) {
            }.run();
        }
    }

    //截取文件中数据行
    public static String[] cutData(String line) {
        return line.split(",");
    }
}


