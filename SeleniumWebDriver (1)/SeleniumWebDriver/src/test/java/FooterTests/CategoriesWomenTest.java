package FooterTests;

import PageFactoryPom.Pages.FooterSections.WomenSection;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.NavigationMenu.Women.WomenPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoriesWomenTest {
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
    public void checkWomenFooter(){
        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        WomenSection womenSection = new WomenSection(driver);
        WomenPage womenPage = womenSection.checkWomen();
        womenPage.checkWomen();
    }
}
