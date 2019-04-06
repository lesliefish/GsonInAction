package com.lesliefish.gson.t05treemodel;

import com.google.gson.*;

public class TreeModelTester {
    public static void test() {
        String jsonString =
                "{\"name\":\"leslie fish\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonElement nameNode = jsonObject.get("name");
            System.out.println("Name: " + nameNode.getAsString());

            JsonElement ageNode = jsonObject.get("age");
            System.out.println("Age: " + ageNode.getAsInt());

            JsonElement verifiedNode = jsonObject.get("verified");
            System.out.println("Verified: " + (verifiedNode.getAsBoolean() ? "Yes" : "No"));

            JsonArray marks = jsonObject.getAsJsonArray("marks");
            for (int i = 0; i < marks.size(); i++) {
                JsonPrimitive value = marks.get(i).getAsJsonPrimitive();
                System.out.print(value.getAsInt() + " ");
            }
        }
    }
}
