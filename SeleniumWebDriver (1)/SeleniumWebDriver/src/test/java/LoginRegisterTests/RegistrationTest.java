package LoginRegisterTests;

import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.LoginRegister.RegisterPage;
import PageFactoryPom.Utilities.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class RegistrationTest {
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
        driver.quit();
    }

    @Test
    public void successfulRegistration() throws IOException {
        Log.info("registration test started!");

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        LoginPage loginPage = homePageDir.openLoginPage();
        RegisterPage registerPage = loginPage.fillEmailRegister("anna.zumpalova@abv.bg");
        registerPage.fillAllInformation("Anna", "Zumpalova", "AB1234", "Anna",
                "Zumpalova", "TU-SOFIA", "Vasil Levski 20", "Vasil Levski 22",
                "Sofia", "80008", "055878985", "+3598875656560", "Nikola Gabrovski 22");
        registerPage.checkSuccessfulRegistration();
    }
    @Test
    public void unsuccessfulRegistration(){
        Log.info("registration test - unsuccessful - started!");

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        LoginPage loginPage = homePageDir.openLoginPage();
        RegisterPage registPage = new RegisterPage(driver);
        registPage.fillNotAllInformation();
    }
}
