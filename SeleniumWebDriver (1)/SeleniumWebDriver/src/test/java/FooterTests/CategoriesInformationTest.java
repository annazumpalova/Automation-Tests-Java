package FooterTests;

import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.FooterSections.InformationSection;
import PageFactoryPom.Pages.FooterSections.WomenSection;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.NavigationMenu.FooterPages.*;
import PageFactoryPom.Pages.NavigationMenu.Women.WomenPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoriesInformationTest {
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
    public void checkSpecials(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        SpecialsPage specialPage = infSection.checkSpecials();
        specialPage.checkSpecials();
    }

    @Test
    public void newProducts(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        NewProductsPage newProductsPage = infSection.checkNewProducts();
        newProductsPage.checkNewProducts();
    }

    @Test
    public void bestSellers(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        BestSellersPage bestSellersPage = infSection.checkBestSellers();
        bestSellersPage.checkBestSellers();
    }

    @Test
    public void ourStores(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        OurStoresPage ourStoresPage = infSection.checkOurStores();
        ourStoresPage.checkOurStores();
    }

    @Test
    public void contactUs(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        ContactUsPage contactUsPage = infSection.checkContactUs();
    }

    @Test
    public void termsAndConditions(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        TermsAndConditions termsAndConditionsPage = infSection.checkTermsAndConditions();
        termsAndConditionsPage.checkTermsAndConditions();
    }

    @Test
    public void aboutUs(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        AboutUs aboutUsPage = infSection.checkAboutUs();
        aboutUsPage.checkAboutUs();
    }

    @Test
    public void siteMap(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        InformationSection infSection = new InformationSection(driver);
        SiteMap siteMapPage = infSection.checkSitemap();
        siteMapPage.checkSiteMap();
    }
}
