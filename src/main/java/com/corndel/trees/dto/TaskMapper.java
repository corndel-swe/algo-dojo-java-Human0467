package com.corndel.trees.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Task jsonToTask(String fileName) {
        String json = readJsonFromResourcesData(fileName);

        try {
            return objectMapper.readValue(json, Task.class);
        } catch (JsonProcessingException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readJsonFromResourcesData(String fileName) {
        Path path = Paths.get("src", "main", "resources", "data", fileName);

        try {
            return String.join("", Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
