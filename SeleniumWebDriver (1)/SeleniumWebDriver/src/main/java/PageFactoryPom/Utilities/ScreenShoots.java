package PageFactoryPom.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShoots {

    private static final String FOLDER_PATH = "C:\\WebDriver\\screenshots\\";

    public static BufferedImage takePageScreenshot(WebDriver driver, String screenShootName) throws IOException {

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(FOLDER_PATH + getFileNameWithCurrentDate(screenShootName)));
        } catch (IOException e) {
            Log.error(e.getMessage());
            throw e;
        }

        return ImageIO.read(file);
    }

    public static BufferedImage takeElementScreenShoot(WebElement element, String screenShootName) throws IOException {
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(FOLDER_PATH + getFileNameWithCurrentDate(screenShootName)));
        } catch (IOException e) {
            Log.error(e.getMessage());
            throw e;
        }
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    private static String getFileNameWithCurrentDate(String step) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String fileName = step + "_" + formatter.format(date).toString() + ".png";
        return fileName;
    }

    public static boolean compareImages(BufferedImage image1, BufferedImage image2) {

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(image1, image2);
        if (diff.hasDiff() == true) {
            System.out.println("Images are Not Same");
            return false;

        }
        System.out.println("Images are Same");
        return true;
    }
}
