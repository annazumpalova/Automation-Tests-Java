package PageFactoryPom.Pages.ShippingCart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {

    WebDriver driver;
    WebDriverWait wait;

    //describe all elements

    By proceedToCheckout = By.xpath("//div[@id ='center_column']//a[@title='Proceed to checkout']");

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    // methods to check details
    // methods to remove/add more items

    public AddressPage proceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
       return new AddressPage(driver);
    }

    public void doAllChecks() {
        // verifications
    }
}
