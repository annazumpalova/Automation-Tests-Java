package LoginRegisterTests;

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

public class LoginTest {

    WebDriver driver;
    String url;
    String excelFile;

    @Before
    public void setUp() {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();
        excelFile = "C:\\WebDriver\\inits\\init.xlsx";
        DOMConfigurator.configure("log4j.xml");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void readXml() throws IOException {

        Log.startTestDetails("readXml");
        Log.info("test started!");

        File file = new File("C:\\WebDriver\\inits\\init.xlsx");
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
    }

    @Test
    public void loadHomePageAndLogin() throws InterruptedException, IOException {
        Log.startTestDetails("loadHomePageAndLogin");
        Log.info("test started!");

        HomePage homePageDir = new HomePage(driver, url);
        homePageDir.loadPage();

        LoginPage loginPage = homePageDir.openLoginPage();
        loginPage.login("anni97.test@gmail.com", "Anna1234");
        Log.info("Username= anni97.test@gmail.com, pass= Anna1234");
        Assert.assertEquals("Anna Zumpalova", homePageDir.getUserInfo());
        homePageDir.closePage();
        Log.endTestDetails();
    }
}
