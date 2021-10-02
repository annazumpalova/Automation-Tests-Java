package ProductsSearchTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

public class SearchUnexistingItem extends MainSetUp {

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
    public void searchUnexistingItem() throws IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();
            homePage.searchUnexistingItem("noo such product");
        }catch (RuntimeException e) {
            Log.error("Search not existing file is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Search not existing file");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
