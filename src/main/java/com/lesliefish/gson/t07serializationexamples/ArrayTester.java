package com.lesliefish.gson.t07serializationexamples;

import com.google.gson.Gson;

import java.util.Arrays;

public class ArrayTester {
    public static void test() {
        Gson gson = new Gson();
        int[] marks = {100, 90, 85};
        String[] names = {"Ram", "Sha", "Chane"};

        //序列化
        System.out.print("{");
        System.out.print("marks:" + gson.toJson(marks) + ",");
        System.out.print("names:" + gson.toJson(names));
        System.out.println("}");

        //反序列化
        marks = gson.fromJson("[100,89,80]", int[].class);
        names = gson.fromJson("[\"Ram\",\"Sha\",\"Chane\"]", String[].class);

        System.out.println("marks:" + Arrays.toString(marks));
        System.out.println("names:" + Arrays.toString(names));
    }

}
