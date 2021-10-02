package FooterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.FooterSections.WomenSection;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.Women.WomenPage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Collection;

public class CategoriesWomenTest extends MainSetUp{

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
    public void checkWomenFooter() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            WomenSection womenSection = new WomenSection(driver);
            WomenPage womenPage = womenSection.checkWomen();
            womenPage.checkWomen();
        }catch (RuntimeException e) {
            Log.error("Footer Women is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterWomen");
            throw e;
        }
    }
}
