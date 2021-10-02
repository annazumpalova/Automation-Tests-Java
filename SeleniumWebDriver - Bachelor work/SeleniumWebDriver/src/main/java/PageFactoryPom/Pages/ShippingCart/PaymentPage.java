package PageFactoryPom.Pages.ShippingCart;


import PageFactoryPom.Utilities.ItemDetails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By itemName = By.xpath("//table[@id = 'cart_summary']//td[@class='cart_description']/p[@class ='product-name']/a");
    By itemprice = By.xpath("//table[@id = 'cart_summary']//td[@class='cart_unit']/span/span");
    By totalprice = By.id("total_price");
    //By bankwire =  By.partialLinkText("Pay by bank wire"); bankwire
    By bankwire = By.xpath("//a[@title = 'Pay by bank wire' and @class ='bankwire']");


    public PaymentPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void  checkItemName (String name){
        WebElement itemNameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        Assert.assertEquals(name,itemNameEl.getText());
    }

    public void  checkItemPrice (String price){
        WebElement itemPriceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(itemprice));
        String newPrice = itemPriceEl.getText().replace("$","");
        Assert.assertEquals(Double.parseDouble(price),Double.parseDouble(newPrice),0.1);
    }

    public BankWirePayment checkTotalPriceAndPayBankWire(ItemDetails item) {
        WebElement itemPriceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(totalprice));
        String totalPriceFromSite = itemPriceEl.getText().replace("$","");
        double total = Double.parseDouble(item.quant)*Double.parseDouble(item.price)+2;
        Assert.assertEquals(total,Double.parseDouble(totalPriceFromSite),0.1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankwire)).click();
        return  new BankWirePayment(driver);

    }

    public void pay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankwire)).click();

    }
}
