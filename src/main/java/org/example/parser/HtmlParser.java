package org.example.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.back.FileService.pathToJson;

public class HtmlParser {

    public final Map<String, String> map;

    public HtmlParser() {
        this.map = loadQuestionFromJson(pathToJson);
    }

    public String execute(String trimFitAndFindAnswer) {
        trimFitAndFindAnswer = extractText(trimFitAndFindAnswer);
        System.out.println(trimFitAndFindAnswer);
        return map.get(trimFitAndFindAnswer);
    }

    public String extractText(String input) {
        // Define a regular expression pattern
        String regex = "\\d+\\.\\s*(.*?)\\s*:";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern matches
        if (matcher.find()) {
            // Extract the matched text
            return matcher.group(1).trim();
        } else {
            throw new RuntimeException("Pattern not found in the input string.");
        }
    }

    public Map<String, String> loadQuestionFromJson(String filePath) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            // Define the type of the map using TypeToken
            Type type = new TypeToken<HashMap<String, String>>() {}.getType();
            // Load the map from the JSON file
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Loading from JSON failed", e);
        }
    }
}
