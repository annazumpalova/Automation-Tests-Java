package LoginRegisterTests;

import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.ForgotPasswordPage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Utilities.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ForgotPassTest {
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
    public void forgotPassTestSuccessfully() throws IOException {
        String email = "anni97.test@gmail.com";
        Log.info(" ForgotPassword tests started!");

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        LoginPage loginPage = homePageDir.openLoginPage();
        loginPage.forgotPassword();
        ForgotPasswordPage forgotPassTestPage = new ForgotPasswordPage(driver);
        forgotPassTestPage.forgotPass(email);
        forgotPassTestPage.checkSuccessfulSendEmail(email);
    }

    @Test
    public void forgotPassTestUnsuccessfully() throws IOException {
        String email = "aaaaa@aaammm##%";

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        LoginPage loginPage = homePageDir.openLoginPage();
        loginPage.forgotPassword();
        ForgotPasswordPage forgotPassTestPage = new ForgotPasswordPage(driver);
        forgotPassTestPage.forgotPass(email);
        forgotPassTestPage.checkUnsuccessfulSendEmail();
    }
}

