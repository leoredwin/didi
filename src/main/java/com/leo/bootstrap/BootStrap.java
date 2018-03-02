package com.leo.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by di on 3/6/2016.
 */
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    public static List<String> getOrderDataFilePath() {
        return new ArrayList<>(Arrays.asList(
                "C:\\Users\\niushw\\Desktop\\bh_loan_site.txt"
        ));
    }
}
