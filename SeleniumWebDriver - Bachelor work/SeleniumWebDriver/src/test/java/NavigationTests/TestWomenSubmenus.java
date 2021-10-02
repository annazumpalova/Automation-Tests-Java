package NavigationTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomeMenu;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.Dresses.CasualDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.EveningDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.SummerDresses;
import PageFactoryPom.Pages.NavigationMenu.Women.*;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.applet.Main;

import java.io.IOException;
import java.util.Collection;


public class TestWomenSubmenus extends MainSetUp {

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
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Test
    public void womenDressesCasual() throws IOException, InterruptedException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();
        Thread.sleep(5000);

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());
        Thread.sleep(5000);

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverWomenMenu();
        homeMenus.clickOnCasualWomen();

        DressesCasual casualDresses = new DressesCasual(driver);
        casualDresses.checkDressesCasual();

        }catch (IllegalAccessError e){
            Log.error("Women - Dresses casual failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Women");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void womenDressesEvening() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverWomenMenu();
        homeMenus.clickOnEveningWomen();

        DressesEvening eveningDresses = new DressesEvening(driver);
        eveningDresses.checkDressesEvening();
        }catch (IllegalAccessError e){
            Log.error("Women - Dresses evening failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Women");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void womenDressesSummer() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverWomenMenu();
        homeMenus.clickOnSummerWomen();

        DressesSummer summerDresses = new DressesSummer(driver);

        summerDresses.checkDressesSummer();
        }catch (IllegalAccessError e){
            Log.error("Women - Dresses summer failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Women");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void womenTopBlouses() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverWomenMenu();
        homeMenus.clickOnTopBlouses();

        TopsBlouses topsBlouses = new TopsBlouses(driver);

        topsBlouses.checkDressesBlouses();
        }catch (IllegalAccessError e){
            Log.error("Women - Top blouses failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Women");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void womenTopTshirt() throws IOException {
        try{
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.hoverWomenMenu();
        homeMenus.clickOnTopTshirts();

        TopsTshirts topsTshirts = new TopsTshirts(driver);
        topsTshirts.checkDressesTshirts();
        }catch (IllegalAccessError e){
            Log.error("Women Top - T-shirts failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - Women");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
