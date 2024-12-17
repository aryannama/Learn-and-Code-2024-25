package com.adjacentcountires;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonFileReader {
    public static JsonObject readJsonFile(String path) {
        Gson gson = new Gson();

        InputStream inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, JsonObject.class);
    }
}
