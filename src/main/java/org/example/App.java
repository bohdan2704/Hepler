package org.example;
import java.io.*;

public class App {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "C:\\Users\\Bohdan\\Desktop\\Hepler\\src\\main\\resources\\Questions.txt";
        String outputFile = "output.txt";

        try {
            // Read the file using Windows-1251 encoding
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "windows-1251"));

            // Write the content to a new file using UTF-8 encoding
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line if needed
                // For now, just write it to the new file
                writer.write(line);
                writer.newLine();
            }

            // Close the readers and writers
            reader.close();
            writer.close();

            System.out.println("Conversion successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
