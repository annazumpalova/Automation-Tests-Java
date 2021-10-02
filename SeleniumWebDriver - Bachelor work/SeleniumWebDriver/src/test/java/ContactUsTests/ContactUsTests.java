package ContactUsTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Collection;

public class ContactUsTests extends MainSetUp {
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
    public void contactUsSuccessful() throws IOException {
        try {
            String email = "anni97.test@gmail.com";
            String idOrder = "HP8972MP";
            String message = "We test the message field - Automation Testing Selenium";

            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            ContactUsPage contactUs = homePage.openContactUs();
            contactUs.fillAllInformation(email, idOrder, message);
        }catch (RuntimeException e) {
            Log.error("Contact us successfully is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "ContactUsTest1");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void contactUsErrorMessage() throws IOException {
        try {
            String email = "anni97.test@gmail.com";
            String idOrder = "HP8972MP";

            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            ContactUsPage contactUs = homePage.openContactUs();
            contactUs.notSuccessfulContactUs(email, idOrder);
        }catch (RuntimeException e) {
            Log.error("ContactUsUnsuccessfully is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "ContactUsTest2");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
