package com.example.nasa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T toJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }

    public static void print(Object obj) {
        try {
            System.out.println(mapper.writeValueAsString(obj));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
