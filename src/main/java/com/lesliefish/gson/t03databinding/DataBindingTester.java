package com.lesliefish.gson.t03databinding;

import com.google.gson.Gson;

import java.util.Arrays;

public class DataBindingTester {
    public static void test() {
        Gson gson = new Gson();
        String name = "leslie fish";
        long rollNo = 1;
        boolean verified = false;
        int[] marks = {100, 90, 85};

        //值转为json字串
        System.out.println("{");
        System.out.println("name: " + gson.toJson(name) + ",");
        System.out.println("rollNo: " + gson.toJson(rollNo) + ",");
        System.out.println("verified: " + gson.toJson(verified) + ",");
        System.out.println("marks:" + gson.toJson(marks));
        System.out.println("}");

        // json转为类型的值
        name = gson.fromJson("\"leslie fish\"", String.class);
        rollNo = gson.fromJson("1", Long.class);
        verified = gson.fromJson("false", Boolean.class);
        marks = gson.fromJson("[100,90,85]", int[].class);

        System.out.println("name: " + name);
        System.out.println("rollNo: " + rollNo);
        System.out.println("verified: " + verified);
        System.out.println("marks:" + Arrays.toString(marks));
    }
}
