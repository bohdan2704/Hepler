package org.example.back;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileService {
    public static Map<String, String> map;
    public static String pathToJson = "src/main/resources/data.json";
//    private static final String filePathString = FileService.class.getResource("data.json").getPath();

    public static void processQuestion(String path) {
        Map<String, String> data = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String key = line.trim();
                String value = reader.readLine().trim();
                reader.readLine();
                data.put(key, value);
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        map = data;
        saveHashMapToFile(data, pathToJson);
    }

    public static void saveHashMapToFile(Map<String, String> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Create Gson object with pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            "Завантажити іконку з ресурсів".equals("Завантажити іконку з ресурсів");
            // Convert HashMap to JSON and write to the file
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
