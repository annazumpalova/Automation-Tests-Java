package PageFactoryPom.Pages.ShippingCart;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    private WebDriver driver;
    private WebDriverWait wait;


    By name = By.xpath("//ul[@id = 'address_delivery']/li[@class = 'address_firstname address_lastname']");
    By addressTextArea = By.xpath("//div[@id = 'ordermsg']/textarea[@name = 'message']");
    By proccedButton = By.xpath("//button[@class = 'button btn btn-default button-medium' and @name = 'processAddress']");


    public AddressPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }

    public String getTextFromNameFiled(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(name)).getText();
    }

    public void setOrderAddress(String address){
        WebElement area =
                wait.until(ExpectedConditions.visibilityOfElementLocated(addressTextArea));
        area.sendKeys(address);
        String actualres = area.getAttribute("value");
        Assert.assertEquals(address,actualres);
    }

    public ShippingPage clickProceedButton (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proccedButton)).click();
        return  new ShippingPage(driver);
    }
}
