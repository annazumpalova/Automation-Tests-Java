package FooterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.FooterSections.Newsletter;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.Collection;

public class NewsletterTest extends MainSetUp {
    @Before
    public void setUp() {
        try {
            this.setUpMain();
        } catch (IOException e) {
            Log.error(e.getMessage());
            try {
                ScreenShoots.takePageScreenshot(this.driver, "MainSetUp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection inputs() throws IOException {
        return ReadFromExcel.readExcel(MainSetUp.getItemFilePath());
    }

    @Test
    public void newsletterTest() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            Newsletter newsletter = new Newsletter(driver);
            newsletter.sendEmail("anni97.test@gmail.com");
            newsletter.checkSuccessfulRegisterEmail();
        }catch (RuntimeException e) {
            Log.error("Footer newsLetter is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterNewsLetter");
            throw e;
        }
    }
}
