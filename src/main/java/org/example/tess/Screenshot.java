package org.example.tess;

import org.example.back.Timing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    public String captureScreenshot() {
        try {
            // Create a Robot object
            Robot robot = new Robot();

            // Capture the screen excluding the upper 100 pixels
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            screenRect.y = 200;  // Exclude the upper 100 pixels
            screenRect.height -= 800;  // Adjust the height accordingly
            BufferedImage screenshot = robot.createScreenCapture(screenRect);
            String timingValue = Timing.start();
            // Save the screenshot to a file
            File outputfile = new File("logs/screenshot" + timingValue + ".png");
            ImageIO.write(screenshot, "png", outputfile);

            System.out.println("Screenshot captured successfully.");
            return timingValue;

        } catch (AWTException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
