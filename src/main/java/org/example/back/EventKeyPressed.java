package org.example.back;


import org.example.parser.HtmlParser;
import org.example.tess.ImageWorking;
import org.example.tess.Screenshot;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;


public class EventKeyPressed implements NativeKeyListener {
    private final HtmlParser htmlParser = new HtmlParser();

    public EventKeyPressed() {
//        String questionsFilePath2 = "src/main/resources/db.txt";
//        FileService.processQuestion(questionsFilePath2);
//        FileService.pathToJson = "src/main/resources/info.json";
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
//        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//        System.out.println("Key Pressed: " + e.getKeyCode());
        if (e.getKeyCode() == NativeKeyEvent.VC_P) {
            Screenshot screenshot = new Screenshot();
            String partOfScrName = screenshot.captureScreenshot();
            String s = ImageWorking.performOCR(partOfScrName);
            System.out.println(htmlParser.execute(s));
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
//        if (e.getKeyCode() == 'p' || e.getKeyCode() == 'P') {
//            ImageWorking imageWorking = new ImageWorking();
//            Screenshot screenshot = new Screenshot();
//            screenshot.captureScreenshot();
//        }

    }

    public static void main(String[] args) {
        // Suppress JNativeHook logs by setting the logging level to WARNING
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        try {
            // Sleep for 100 milliseconds
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        GlobalScreen.addNativeKeyListener(new EventKeyPressed());
    }
}