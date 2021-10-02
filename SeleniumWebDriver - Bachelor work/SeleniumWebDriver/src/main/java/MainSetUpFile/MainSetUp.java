package MainSetUpFile;


import PageFactoryPom.Utilities.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class MainSetUp {

    private static final String  CHROME_DRIVER_PARH = "C://Users//ASUS//Web driver//chromedriver_win32//chromedriver.exe";
    private static final String  INIT_PARH = "C://Users//ASUS//Desktop//DiplomnaQA//The Project - source files//init.xlsx";
    private static final String  INIT_ITEM_PARH = "C://Users//ASUS//Desktop//DiplomnaQA//The Project - source files//items.xlsx";
    private static final String  CHROME = "CHROME";
    private static final String  FIREFOX = "FIREFOX";
    public WebDriver driver;
    private String username;
    private String password;
    private String browserName;
    private String mainURL;
    private String usernameLoggedInInfo;
    String errorResourceLimit = ".//h1[text()='Resource Limit Is Reached']";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getItemFilePath(){
        return INIT_ITEM_PARH;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getMainURL() {
        return mainURL;
    }

    public void setMainURL(String mainURL) {
        this.mainURL = mainURL;
    }

    public String getUsernameLoggedInInfo() {
        return usernameLoggedInInfo;
    }

    public void setUsernameLoggedInInfo(String usernameLoggedInInfo) {
        this.usernameLoggedInInfo = usernameLoggedInInfo;
    }

    public MainSetUp(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PARH );
        DOMConfigurator.configure("log4j.xml");
    }

    public void setUpMain() throws IOException {
        readDataFromExcelFile();
        setUpWebDriver();
        driver.manage().window().maximize();
    }

    private void readDataFromExcelFile() throws IOException {
        String testName = this.getClass().getSimpleName();
        File file = new File(INIT_PARH);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            String cel = row.getCell(0).getStringCellValue();
            if (row.getCell(0).getStringCellValue().equals(testName)) {
                this.username = row.getCell(1).getStringCellValue();
                this.password = row.getCell(2).getStringCellValue();
                this.browserName = row.getCell(3).getStringCellValue();
                this.mainURL = row.getCell(4).getStringCellValue();
                this.usernameLoggedInInfo =  row.getCell(5).getStringCellValue();
            }
        }
        if (username == null || password == null || mainURL == null) {
            Log.error("Pass,Username or Url is null");
            throw new InvalidArgumentException("Pass,Username or Url is null");
        }
    }

    public void closeWebPage(){
        driver.close();
    }

    private void setUpWebDriver(){
        if (this.browserName ==null){
            Log.error("browserName ==null");
            throw new RuntimeException("browserName ==null");
        }
        if (this.browserName.toUpperCase().equals(CHROME)){
            this.driver = new ChromeDriver();
        }else if(this.browserName.toUpperCase().equals(FIREFOX)){
            this.driver = new FirefoxDriver();
        }else{
            this.driver = new ChromeDriver();
        }
    }

    public boolean verifyResourceLimit(){
        boolean errorMessageEl= driver.findElement(By.xpath(errorResourceLimit)).isEnabled();
        if(errorMessageEl){
            Log.error("The resource limit is reached!!!");
            return true;
        }
        return false;
    }
}
