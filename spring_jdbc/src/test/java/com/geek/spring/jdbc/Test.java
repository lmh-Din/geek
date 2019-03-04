package com.geek.spring.jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName test
 * @Author Liumh
 * @Date 2019/2/19 10:31
 * @Version v1.0
 */
public class Test {

    @org.junit.Test
    public void test1(){

        List<String> list = new ArrayList<>();

        list.forEach(row -> System.out.println(row.toString()) );

        for (String str:list) {
            System.out.println(str.toString());
        }

    }
}
