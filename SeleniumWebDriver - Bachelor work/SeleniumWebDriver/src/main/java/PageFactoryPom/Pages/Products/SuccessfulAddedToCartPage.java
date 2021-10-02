package PageFactoryPom.Pages.Products;

import PageFactoryPom.Pages.ShippingCart.SummaryPage;
import PageFactoryPom.Utilities.ItemDetails;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SuccessfulAddedToCartPage {

    WebDriver driver;
    WebDriverWait wait;


    By proceedToCheckout = By.xpath("//div[@id ='layer_cart']//div[@class='button-container']//a[@title='Proceed to checkout']");
    By continueShopping = By.xpath("//div[@id ='layer_cart']//div[@class='button-container']//a[@title='Continue shopping']");
    By productTitle = By.id("layer_cart_product_title");
    By layer_cart_product_attributes = By.id("layer_cart_product_attributes");
    By layer_cart_product_quantity = By.id("layer_cart_product_quantity");
    By layer_cart_product_price = By.id("layer_cart_product_price");

    public SuccessfulAddedToCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public SummaryPage proceedToCheckout(ItemDetails itemDetails){
        checkProductDetails(itemDetails);
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
        return new SummaryPage(driver);
    }

    public SummaryPage clickCheckOut(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
        return new SummaryPage(driver);
    }

    public void  continueShopping(ItemDetails itemDetails){
        checkProductDetails(itemDetails);
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).click();
    }

    public void checkProductDetails(ItemDetails itemDetails) {
        try {
            ScreenShoots.takePageScreenshot(driver,"checkProductDetails");
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        Assert.assertEquals(itemDetails.itemName,title.getText());

        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(layer_cart_product_quantity));
        Assert.assertEquals(itemDetails.quant.replace(".0", ""),quantity.getText());

        WebElement product_price = wait.until(ExpectedConditions.visibilityOfElementLocated(layer_cart_product_price));
        String priceStr= product_price.getText().replace("$","");
        Assert.assertEquals(itemDetails.price,priceStr);

       WebElement product_attributes = wait.until(ExpectedConditions.visibilityOfElementLocated(layer_cart_product_attributes));
       String productAttributes =  product_attributes.getText();
        Assert.assertTrue(productAttributes.contains(itemDetails.size));
        Assert.assertTrue(productAttributes.contains(itemDetails.col));
    }
}
