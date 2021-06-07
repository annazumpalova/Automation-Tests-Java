package PageFactoryPom.Pages.HomePages;

import PageFactoryPom.Pages.Products.ProductDetailsPage;
import PageFactoryPom.Pages.Products.QuickViewPage;
import PageFactoryPom.Pages.Products.SuccessfulAddedToCartPage;
import PageFactoryPom.Utilities.ItemDetails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularSection {
    WebDriver driver;
    WebDriverWait wait;
    By pageLogo = By.xpath(".//div[@id='header_logo']");
    By popularSection = By.xpath(".//ul[@id='home-page-tabs']/li[@class='active']/a");
    String iteamEl = ".//ul[@id='homefeatured']//h5[@itemprop='name']/a[contains(text(),'";
    By quickViewDetailsBtn = By.xpath(".//li[2]//a[@class='quick-view'][1]");
    By moreBtn = By.xpath(".//li[2]//a[@class='button lnk_view btn btn-default']");
    By addToCardBtn = By.xpath(".//li[2]//a[@class='button ajax_add_to_cart_button btn btn-default']");
    private String url = "http://automationpractice.com/index.php";

    public PopularSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public PopularSection(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public QuickViewPage addToCardFromPopularSection(ItemDetails details){
        WebElement pageLogoEl = wait.until(ExpectedConditions.presenceOfElementLocated(pageLogo));
        pageLogoEl.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");

        String pathName = iteamEl + details.itemName + "')]";
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathName)));
        Assert.assertEquals(details.itemName,item.getText());

        Actions a = new Actions(driver);
        a.moveToElement(item).perform();
        WebElement itemBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(quickViewDetailsBtn));
        itemBtn.click();
        return new QuickViewPage(driver);
    }

    public ProductDetailsPage addToCardMorePopularSection(ItemDetails details){
        WebElement pageLogoEl = wait.until(ExpectedConditions.presenceOfElementLocated(pageLogo));
        pageLogoEl.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");

        String pathName = iteamEl + details.itemName + "')]";
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathName)));
        Assert.assertEquals(details.itemName,item.getText());

        Actions a = new Actions(driver);
        a.moveToElement(item).perform();
        WebElement viewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtn));
        viewBtn.click();
        return new ProductDetailsPage(driver);
    }

    public SuccessfulAddedToCartPage addToCardPopular(ItemDetails details){
        WebElement pageLogoEl = wait.until(ExpectedConditions.presenceOfElementLocated(pageLogo));
        pageLogoEl.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");

        String pathName = iteamEl + details.itemName + "')]";
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathName)));
        Assert.assertEquals(details.itemName,item.getText());

        Actions a = new Actions(driver);
        a.moveToElement(item).perform();
        WebElement addToCardBtnEl = wait.until(ExpectedConditions.presenceOfElementLocated(addToCardBtn));
        addToCardBtnEl.click();
        return new SuccessfulAddedToCartPage(driver);
    }
}
