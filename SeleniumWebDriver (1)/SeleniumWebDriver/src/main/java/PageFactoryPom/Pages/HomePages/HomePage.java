package PageFactoryPom.Pages.HomePages;

import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.Products.ProductDetailsPage;
import PageFactoryPom.Pages.Products.QuickViewPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    By login = By.className("login");
    By contactUs = By.xpath("//div[@id = 'contact-link']/a[text()='Contact us']");
    By userInfo = By.xpath("//div[@class='header_user_info']/a[@class='account']/span");
    By checkerLoginPage = By.xpath("//span[@class='navigation_page' and contains(text(),'Authentication')]");
    By searchBar = By.id("search_query_top");
    By searchedItem = By.xpath(".//ul[@class = 'product_list grid row']//div[@class ='product-container']");
    By viewDetailsBtn = By.xpath("//li[1]//div[@class ='button-container']//a[@class='button lnk_view btn btn-default' and @title='View']"); //div button-container class  a -Add to cart
    By itemName = By.xpath("//div[@class='product-container']/div[@class='right-block']//a[@class ='product-name']");
    By quickViewBtn = By.xpath(".//div[@class='quick-view-wrapper-mobile']/a[@class='quick-view-mobile']");
    By quickViewDetailsBtn = By.xpath(".//a[@class='quick-view'][1]");
    private String url = "http://automationpractice.com/index.php";


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public HomePage(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public void loadPage() {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public LoginPage openLoginPage() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkerLoginPage));
        return new LoginPage(driver);
    }
    public ContactUsPage openContactUs(){
        WebElement contactUsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
        contactUsBtn.click();
        return new ContactUsPage(driver);
    }

    private void searchItem(String itemName) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        Actions actions = new Actions(driver);
        actions.sendKeys(search, itemName).perform();
        actions.sendKeys(search, Keys.ENTER).perform();
    }

    public ProductDetailsPage openProductDetailsPage(String itemName){
        searchItem(itemName);
        waitItemTobePresented(itemName);
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(searchedItem));
        Actions a = new Actions(driver);
        a.moveToElement(item).perform();
        WebElement itemBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewDetailsBtn));
        a.click(itemBtn).perform();
        return new ProductDetailsPage(driver);

    }

    public QuickViewPage openQuickViewPage(String itemName){
        searchItem(itemName);
        waitItemTobePresented(itemName);
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(searchedItem));
        Actions a = new Actions(driver);
        a.moveToElement(item).perform();
        WebElement quickViewEl = wait.until(ExpectedConditions.presenceOfElementLocated(quickViewDetailsBtn));
        a.click(quickViewEl).perform();
        return new QuickViewPage(driver);
    }

    public void waitItemTobePresented(String itemNameStr){
        WebElement itemNameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(this.itemName));
        Assert.assertEquals(itemNameStr,itemNameEl.getText());
    }


    public String getUserInfo() {
        WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(userInfo));
        return info.getText();
    }

    public void closePage() {
        driver.close();
    }
}
