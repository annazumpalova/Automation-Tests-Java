package FooterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.FooterSections.InformationSection;
import PageFactoryPom.Pages.FooterSections.MyAccountSection;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.FooterPages.*;
import PageFactoryPom.Utilities.ItemDetails;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Collection;


public class CategoriesMyAccount extends MainSetUp{

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
    public void checkMyOrders() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            MyAccountSection myAccountSection = new MyAccountSection(driver);
            MyOrdersPage ordersPage = myAccountSection.checkMyOrders();
            ordersPage.checkMyOrders();
        }catch (RuntimeException e) {
            Log.error("Footer my Account - my orders is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterMyOrders");
            throw e;
        }
    }

    @Test
    public void checkCreditSlips() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            MyAccountSection myAccountSection = new MyAccountSection(driver);
            CreditsSlips creditsSlipsPage = myAccountSection.checkCreditSlips();
            creditsSlipsPage.checkCreditSlips();
        }catch (RuntimeException e) {
            Log.error("Footer my Account - credit slips is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterCreditSlips");
            throw e;
        }
    }

    @Test
    public void checkAddresses() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            MyAccountSection myAccountSection = new MyAccountSection(driver);
            MyAdressesPage addressesPage = myAccountSection.checkMyAddresses();
            addressesPage.checkMyAdresses();
        }catch (RuntimeException e) {
            Log.error("Footer my Account - my addresses is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterMyAddresses");
            throw e;
        }
    }

    @Test
    public void myPersonalInfo() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            MyAccountSection myAccountSection = new MyAccountSection(driver);
            PersonalInformationPage personalInformationPage = myAccountSection.checkMyPersonalInf();
            personalInformationPage.checkMyPersonalInf();
        }catch (RuntimeException e) {
            Log.error("Footer my Account - my orders is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterPersonalInfo");
            throw e;
        }
    }

    @Test
    public void signOut() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            MyAccountSection myAccountSection = new MyAccountSection(driver);
            myAccountSection.signOut();
        }catch (RuntimeException e) {
            Log.error("Footer my Account - my signOut is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterSignOut");
            throw e;
        }
    }
}
