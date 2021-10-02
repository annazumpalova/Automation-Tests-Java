package PageFactoryPom.Pages.ShippingCart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {
    private WebDriver driver;
    private WebDriverWait wait;


    By checkBoxAgree = By.id("uniform-cgv");
    By proceedButton = By.xpath("//button [@name = 'processCarrier' and @class ='button btn btn-default standard-checkout button-medium']");

    By closeErrorDialog = By.xpath("//a[@title='Close' and @class='fancybox-item fancybox-close']");
    By messageError = By.xpath("//p[@class='fancybox-error' and text()='You must agree to the terms of service before continuing.']");

    public ShippingPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }

    public PaymentPage acceptAndProceed(){
        WebElement web  = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxAgree));
        web.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedButton)).click();
        return new PaymentPage(driver);
    }

    public PaymentPage proceed(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedButton)).click();
        return new PaymentPage(driver);
    }

    public void checkAndCloseTancCDialog(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageError));
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeErrorDialog)).click();
    }
}
