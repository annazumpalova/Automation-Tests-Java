package LoginRegisterTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class LoginTest extends MainSetUp {

    WebDriver driver;
    String url;
    String excelFile;

    @Before
    public void setUp() {
        String driverExecutablePath = "C://Users//ASUS//Web driver//chromedriver_win32//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();
        excelFile = "C:\\WebDriver\\inits\\init.xlsx";
        DOMConfigurator.configure("log4j.xml");
    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Test
    public void readXml() throws IOException {
        try {
            Log.startTestDetails("readXml");
            Log.info("test started!");

            File file = new File("C://Users//ASUS//Desktop//DiplomnaQA//The Project - source files//init.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);

            Log.debug("File name is " + file.getAbsolutePath());
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();

            while (rows.hasNext()) {
                Row row = rows.next();
                String firstCell = row.getCell(0).getStringCellValue();
                Log.info("First cell is: " + firstCell);
                String secondCell = row.getCell(1).getStringCellValue();
                String thirdCell = row.getCell(2).getStringCellValue();
                String forthCell = row.getCell(3).getStringCellValue();
            }
            Log.endTestDetails();
        }catch (RuntimeException e) {
            Log.error("read xml file is failed.");
            Log.error(e.getMessage());
            throw e;
        }
    }

    @Test
    public void loadHomePageAndLogin() throws InterruptedException, IOException {
        try {
            Log.startTestDetails("loadHomePageAndLogin");
            Log.info("test started!");

            HomePage homePageDir = new HomePage(driver, url);
            homePageDir.loadPage();

            LoginPage loginPage = homePageDir.openLoginPage();
            loginPage.login("anni97.test@gmail.com", "Anna1234");
            loginPage.successfulLogin();
            Log.info("Username= anni97.test@gmail.com, pass= Anna1234");
            Assert.assertEquals("Anna Zumpalova", homePageDir.getUserInfo());
            homePageDir.closePage();
            Log.endTestDetails();
        }catch (RuntimeException e) {
            Log.error("Load Home page and login is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "LoginTest");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void loginNotExistingAccount() throws IOException {
        try {
            HomePage homePageDir = new HomePage(driver, url);
            homePageDir.loadPage();

            LoginPage loginPage = homePageDir.openLoginPage();
            loginPage.login("aaazumpalova@abv.bg", "Anna1234");
            loginPage.unsuccessfulLogin();
        }catch (RuntimeException e) {
            Log.error("Login with not existing account is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "LoginUnsuccessful");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
