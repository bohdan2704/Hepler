package org.example;

import org.example.back.FileService;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s1 = "Завантажити іконку з ресурсів";
        String cyrrylic = "Завантажити iкoнку з ресурсiв";

        try {
            // Convert the string to bytes using Windows-1251 encoding
            byte[] utfBytes = s1.getBytes(StandardCharsets.UTF_8);
            byte[] cyrrylicBytes = cyrrylic.getBytes(StandardCharsets.UTF_8);
            System.out.println(Arrays.equals(utfBytes, cyrrylicBytes));
            System.out.println(Arrays.toString(utfBytes));
            System.out.println(Arrays.toString(cyrrylicBytes));
            // Convert the bytes to a new string using UTF-8 encoding
            String utf8String = new String(utfBytes, "windows-1251");

            System.out.println("Original String (Windows-1251): " + s1);
            System.out.println("Converted String (UTF-8): " + utf8String);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(s1.equals(s2));
//        System.out.println(Normalizer.normalize(s1, Normalizer.Form.NFC).equals(Normalizer.normalize(s2, Normalizer.Form.NFC)));
//
//        // Normalize the strings
//        String normalizedS1 = normalizeString(s1);
//        String normalizedS2 = normalizeString(s2);
//
//        // Case-sensitive comparison after normalization
//        boolean areEqual = normalizedS1.equals(normalizedS2);
//        System.out.println("Case-sensitive comparison after normalization: " + areEqual);
//
//        // Case-insensitive comparison after normalization
//        boolean areEqualIgnoreCase = normalizedS1.equalsIgnoreCase(normalizedS2);
//        System.out.println("Case-insensitive comparison after normalization: " + areEqualIgnoreCase);
        String questionsFilePath1 = "src/main/resources/db.txt";
        FileService.processQuestion(questionsFilePath1);
//        String questionsFilePath2 = "src/main/resources/db.txt";
//        FileService.processQuestion(questionsFilePath2);
//        FileService.pathToJson = "src/main/resources/info.json";
//        HtmlParser htmlParser = new HtmlParser();
//        htmlParser.start();
    }
//
//    public static void main(String[] args) {
//        String originalText = "café";
//
//        // Normalize to NFC (Normalization Form C)
//        String normalizedTextNFC = Normalizer.normalize(originalText, Normalizer.Form.NFC);
//        System.out.println("NFC normalized text: " + normalizedTextNFC);
//        System.out.println(normalizedTextNFC.equals(originalText));
//
//        // Normalize to NFD (Normalization Form D)
//        String normalizedTextNFD = Normalizer.normalize(originalText, Normalizer.Form.NFD);
//        System.out.println("NFD normalized text: " + normalizedTextNFD);
//    }

}