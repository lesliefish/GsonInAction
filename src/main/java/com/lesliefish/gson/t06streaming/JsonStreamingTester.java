package com.lesliefish.gson.t06streaming;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.StringReader;

public class JsonStreamingTester {
    public static void test() {
        String jsonString =
                "{\"name\":\"leslie fish\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonReader reader = new JsonReader(new StringReader(jsonString));

        try {
            handleJsonObject(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // handle JsonObject
    private static void handleJsonObject(JsonReader reader) throws Exception {
        reader.beginObject();
        String fieldName = null;

        while (reader.hasNext()) {
            JsonToken token = reader.peek();

            if (token.equals(JsonToken.BEGIN_ARRAY)) {
                System.out.print("Marks [");
                handleJsonArray(reader);
                System.out.print("]");
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else {
                if (token.equals(JsonToken.NAME)) {
                    fieldName = reader.nextName();
                }

                if ("name".equals(fieldName)) {
                    token = reader.peek();
                    System.out.println("Name: " + reader.nextString());
                }

                if ("age".equals(fieldName)) {
                    token = reader.peek();
                    System.out.println("Age: " + reader.nextString());
                }

                if ("verified".equals(fieldName)) {
                    token = reader.peek();
                    System.out.println("Verified:" + reader.nextBoolean());
                }
            }
        }
    }

    // handle JsonArray
    private static void handleJsonArray(JsonReader reader) throws Exception {
        reader.beginArray();
        String fieldName = null;

        while (true) {
            JsonToken token = reader.peek();

            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleJsonObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else {
                System.out.print(reader.nextInt() + " ");
            }
        }
    }
}
