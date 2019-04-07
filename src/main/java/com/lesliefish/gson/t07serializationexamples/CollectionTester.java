package com.lesliefish.gson.t07serializationexamples;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionTester {

    public static void test() {
        Gson gson = new Gson();
        Collection<Integer> marks = new ArrayList<Integer>();
        marks.add(100);
        marks.add(90);
        marks.add(85);

        // 序列化
        System.out.print("{");
        System.out.print("marks:" + gson.toJson(marks));
        System.out.println("}");

        // 反序列化
        Type listType = new TypeToken<Collection<Integer>>(){}.getType();
        marks = gson.fromJson("[100,90,85]", listType);
        System.out.println("marks:" + marks);
    }
}
