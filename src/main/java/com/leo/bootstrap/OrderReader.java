package com.leo.bootstrap;

import com.leo.dal.HFCompensatoryInfoObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * Created by di on 4/6/2016.
 */
public class OrderReader {
    private static final Logger logger = LoggerFactory.getLogger(OrderReader.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    public static void main(String[] args) {

        HFCompensatoryInfoObjectMapper hfCompensatoryInfoObjectMapper = (HFCompensatoryInfoObjectMapper) applicationContext
                .getBean("hfCompensatoryInfoObjectMapper");

        BootStrap.getOrderDataFilePath().forEach(path -> {
            new OrderWorker(hfCompensatoryInfoObjectMapper, path).run();
        });
    }
}

class OrderWorker implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(OrderWorker.class);

    private HFCompensatoryInfoObjectMapper hfCompensatoryInfoObjectMapper;
    private String path;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public OrderWorker(HFCompensatoryInfoObjectMapper hfCompensatoryInfoObjectMapper, String path) {
        this.hfCompensatoryInfoObjectMapper = hfCompensatoryInfoObjectMapper;
        this.path = path;
    }

    public OrderWorker() {

    }

    @Override
    public void run() {

    }
}

