package org.example.tess;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageWorking {

    public static void main(String[] args) {
//        // Step 1: Capture a screenshot
//        captureScreenshot();
//
//        // Step 2: Perform OCR on the screenshot
//        String extractedText = performOCR();
//        performOCR();
        // Step 3: Print the extracted text
//        System.out.println(extractedText);
    }
//
//    private static void captureScreenshot() {
//        try {
//            Robot robot = new Robot();
//
//            // Capture the entire screen
//            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//            BufferedImage screenshot = robot.createScreenCapture(screenRect);
//
//            // Save the screenshot to a file
//            ImageIOHelper.writeImage(screenshot, new File("screenshot.png"));
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }

    public static String performOCR(String timingValue) {

        ITesseract tesseract = new Tesseract();

        try {

            // the path of your tess data folder inside the extracted file
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
            // Set the language to Ukrainian
            tesseract.setLanguage("ukr");

            // path of your image file
            String text = tesseract.doOCR(new File("logs/screenshot" + timingValue + ".png"));
            System.out.print(text);

            // Create a FileWriter with the specified file path
            FileWriter fileWriter = new FileWriter("src/main/resources/test/script" + timingValue + ".txt");

            // Wrap FileWriter in BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the text to the file
            bufferedWriter.write(text);

            // Close the BufferedWriter to flush and release resources
            bufferedWriter.close();
//            System.out.println("Text has been written to the file successfully.");
            return text;
        } catch (TesseractException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
