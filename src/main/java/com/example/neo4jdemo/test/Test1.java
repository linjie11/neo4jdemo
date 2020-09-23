package com.example.neo4jdemo.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test1 {
    @Test
    public void test(){
        String param = "1#系统低压";
        String URLParam = null;
        try {
            URLParam = URLEncoder.encode(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(URLParam);
        String url = "http://192.168.5.120:8181/test?input=" + URLParam;
        System.out.println(url);
    }

}
