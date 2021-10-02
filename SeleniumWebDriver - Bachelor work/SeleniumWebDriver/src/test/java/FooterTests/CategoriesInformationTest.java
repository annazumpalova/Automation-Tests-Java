package FooterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.FooterSections.InformationSection;
import PageFactoryPom.Pages.FooterSections.WomenSection;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.FooterPages.*;
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

public class CategoriesInformationTest extends MainSetUp {
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
    public void checkSpecials() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            SpecialsPage specialPage = infSection.checkSpecials();
            specialPage.checkSpecials();
        }catch (RuntimeException e) {
            Log.error("Footer information - specials is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterSpecials");
            throw e;
        }
    }

    @Test
    public void newProducts() throws IOException {
       try {
           HomePage homePage = new HomePage(driver, this.getMainURL());
           homePage.loadPage();

           LoginPage loginPage = homePage.openLoginPage();
           loginPage.login(this.getUsername(), this.getPassword());
           Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,1000)", "");

           InformationSection infSection = new InformationSection(driver);
           NewProductsPage newProductsPage = infSection.checkNewProducts();
           newProductsPage.checkNewProducts();
       }catch (RuntimeException e) {
           Log.error("Footer information - new Product is failed.");
           Log.error(e.getMessage());
           ScreenShoots.takePageScreenshot(driver, "FooterProducts");
           throw e;
       }
    }

    @Test
    public void bestSellers() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            BestSellersPage bestSellersPage = infSection.checkBestSellers();
            bestSellersPage.checkBestSellers();
        }catch (RuntimeException e) {
            Log.error("Footer information - bestSellers is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterBestSellers");
            throw e;
        }
    }

    @Test
    public void ourStores() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            OurStoresPage ourStoresPage = infSection.checkOurStores();
            ourStoresPage.checkOurStores();
        }catch (RuntimeException e) {
            Log.error("Footer information - ourStores is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterOurStores");
            throw e;
        }
    }

    @Test
    public void contactUs() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            ContactUsPage contactUsPage = infSection.checkContactUs();
        }catch (RuntimeException e) {
            Log.error("Footer information - contactUs is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterContactUS");
            throw e;
        }
    }

    @Test
    public void termsAndConditions() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            TermsAndConditions termsAndConditionsPage = infSection.checkTermsAndConditions();
            termsAndConditionsPage.checkTermsAndConditions();
        }catch (RuntimeException e) {
            Log.error("Footer information - terms and conditions is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterTermsAndConditions");
            throw e;
        }
    }

    @Test
    public void aboutUs() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            AboutUs aboutUsPage = infSection.checkAboutUs();
            aboutUsPage.checkAboutUs();
        }catch (RuntimeException e) {
            Log.error("Footer information - aboutUs is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterAboutUs");
            throw e;
        }
    }

    @Test
    public void siteMap() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");

            InformationSection infSection = new InformationSection(driver);
            SiteMap siteMapPage = infSection.checkSitemap();
            siteMapPage.checkSiteMap();
        }catch (RuntimeException e) {
            Log.error("Footer information - siteMap is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "FooterSiteMap");
            throw e;
        }
    }
}
