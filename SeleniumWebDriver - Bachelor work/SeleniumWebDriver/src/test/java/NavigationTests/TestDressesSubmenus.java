package NavigationTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomeMenu;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.Dresses.CasualDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.EveningDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.SummerDresses;
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

public class TestDressesSubmenus extends MainSetUp {

    @Parameterized.Parameters
    public static Collection inputs() throws IOException {
        return ReadFromExcel.readExcel(MainSetUp.getItemFilePath());
    }

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
        verifyResourceLimit();
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Test
    public void testDressesCasual() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverDressesMenu();
        homeMenus.clickOnCasualDresses();

        CasualDresses casualDresses = new CasualDresses(driver);
        casualDresses.checkDressesCasual();
        }catch (RuntimeException e){
            Log.error("Dresses casual failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Dresses");
            throw e;
        }
    }

    @Test
    public void testDressesEvening() throws IOException, InterruptedException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        Thread.sleep(3000);
        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverDressesMenu();
        homeMenus.clickOnEveningDresses();

        EveningDresses eveningDresses = new EveningDresses(driver);
        eveningDresses.checkDressesEvening();
        }catch (RuntimeException e){
            Log.error("Dresses evening failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Dresses");
            throw e;
        }
    }

    @Test
    public void testDressesSummer() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverDressesMenu();
        homeMenus.clickOnSummerDresses();

        SummerDresses summerDresses = new SummerDresses(driver);
        summerDresses.checkDressesSummer();
        }catch (RuntimeException e){
            Log.error("Dresses summer failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Dresses");
            throw e;
        }
    }
}
