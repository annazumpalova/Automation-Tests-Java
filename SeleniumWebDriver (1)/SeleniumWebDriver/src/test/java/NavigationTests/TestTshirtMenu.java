package NavigationTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomeMenu;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.Dresses.CasualDresses;
import PageFactoryPom.Pages.NavigationMenu.Tshirt.TshirtPage;
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

import java.io.IOException;
import java.util.Collection;


public class TestTshirtMenu extends MainSetUp {

    @Parameterized.Parameters
    public static Collection inputs() throws IOException {
        return ReadFromExcel.readExcel(MainSetUp.getItemFilePath());
    }

    @Before
    public void setUp() throws IOException {
        this.setUpMain();
    }

    @After
    public void tearDown() {
        this.closeWebPage();
    }

    @Test
    public void clickOnTshirtMenu() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver, this.getMainURL());
        homePage.loadPage();
        homePage.openLoginPage();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(this.getUsername(), this.getPassword());
        Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());
        Thread.sleep(5000);

        HomeMenu homeMenus = new HomeMenu(driver);
        homeMenus.clickOnTshirtPage();

        TshirtPage tshirtPage = new TshirtPage(driver);

        try{
            tshirtPage.checkTshirts();
        }catch (IllegalAccessError e){
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Navigation test - T-shirts");
            throw e;
        }
    }
}
