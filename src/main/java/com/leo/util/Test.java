/*
 * Package name:com.leo.util
 * File name:Test.java
 * Date:2017-06-20 14:43
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.util;

import com.google.gson.reflect.TypeToken;
import com.omniprimeinc.finance.fund.common.utils.rest.RestClientUtil;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-20 14:43
 */
public class Test {

    public static void main(String[] args) {
        String urla = "http://114.215.200.249:9100/user/C79BF048-142B-E711-B04C-D89D67298EA4";
        Map<String, String> response = RestClientUtil.get(urla, new TypeToken<Map<String, String>>() {
        }.getType());
        String photoUrl = response.get("idFrontPhoto");
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            URL url = new URL(photoUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream("C:\\Users\\niushw\\Desktop\\haha.jpg");
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }

            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
        System.out.println(response);
    }
}