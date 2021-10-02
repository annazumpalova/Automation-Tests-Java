package LoginRegisterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.LoginRegister.RegisterPage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends MainSetUp {
    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        String driverExecutablePath = "C://Users//ASUS//Web driver//chromedriver_win32//chromedriver.exe";
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
    public void successfulRegistration() throws IOException {
        try {
            Log.info("registration test started!");

            HomePage homePageDir = new HomePage(driver, url);
            homePageDir.loadPage();

            LoginPage loginPage = homePageDir.openLoginPage();
            RegisterPage registerPage = loginPage.fillEmailRegister("azumpalova05@abv.bg");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            registerPage.fillAllInformation("Anna", "Zumpalova", "AB1234", "Anna",
                    "Zumpalova", "TU-SOFIA", "Vasil Levski 20", "Vasil Levski 22",
                    "Sofia", "80008", "055878985", "+3598875656560", "Nikola Gabrovski 22");
            registerPage.checkSuccessfulRegistration();
        }catch (RuntimeException e) {
            Log.error("Successful registration is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Registration");
            throw e;
        }
    }
    @Test
    public void unsuccessfulRegistration() throws IOException {
        try {
            Log.info("registration test - unsuccessful - started!");

            HomePage homePageDir = new HomePage(driver, url);
            homePageDir.loadPage();

            LoginPage loginPage = homePageDir.openLoginPage();
            loginPage.fillEmailRegister("azumpalovaa05@abv.bg");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            RegisterPage registPage = new RegisterPage(driver);
            registPage.fillNotAllInformation();
        }catch (RuntimeException e) {
            Log.error("Registration unsuccessful is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "UnsuccessfulRegistration");
            throw e;
        }
    }
}
