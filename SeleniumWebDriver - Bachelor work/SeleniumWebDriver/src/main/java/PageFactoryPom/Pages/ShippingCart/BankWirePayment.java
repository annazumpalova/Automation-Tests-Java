package PageFactoryPom.Pages.ShippingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BankWirePayment {
    private WebDriver driver;
    private WebDriverWait wait;

    By submitButton = By.xpath("//button[@class = 'button btn btn-default button-medium' and @type ='submit']");

    public BankWirePayment(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void completePayment(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }
}
