package ContactUsTests;

import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.HomePages.HomePage;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ContactUsTests {
    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();
        DOMConfigurator.configure("log4j.xml");
    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Test
    public void contactUsSuccessful() throws IOException {
        String email = "anni97.test@gmail.com";
        String idOrder = "HP8972MP";
        String message = "We test the message field - Automation Testing Selenium";

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();
        ContactUsPage contactUs = homePageDir.openContactUs();

        contactUs.fillAllInformation(email, idOrder, message);
    }

    @Test
    public void contactUsErrorMessage() throws IOException {
        String email = "anni97.test@gmail.com";
        String idOrder = "HP8972MP";

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        ContactUsPage contactUs = homePageDir.openContactUs();
        contactUs.notSuccessfulContactUs(email, idOrder);
    }
}
