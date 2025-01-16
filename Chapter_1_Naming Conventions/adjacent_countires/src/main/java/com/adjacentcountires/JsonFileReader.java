package com.adjacentcountires;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonFileReader {
    public static JsonObject readJsonFile(String path) {
        Gson gson = new Gson();
        JsonObject result = null;

        try (FileReader reader = new FileReader(Paths.get(path).toString())) {
            result = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
