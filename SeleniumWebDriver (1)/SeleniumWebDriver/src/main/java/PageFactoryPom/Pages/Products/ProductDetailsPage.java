package PageFactoryPom.Pages.Products;


import PageFactoryPom.Utilities.ItemDetails;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By quantityWanted = By.id("quantity_wanted");
    By selectSize = By.id("group_1");
    String color = "//ul[@id='color_to_pick_list']//a[@title='%s']";
    By submit = By.xpath("//p[@id = 'add_to_cart']/button[@name = 'Submit']");
    By itemName = By.xpath("//div[@id ='center_column']//div[@class='primary_block row']//h1[@itemprop='name']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void fillAndAddProductDetails(ItemDetails details){
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(this.itemName));
        Assert.assertEquals(details.itemName,name.getText());

        WebElement quantity= wait.until(ExpectedConditions.presenceOfElementLocated(this.quantityWanted));
        quantity.clear();
        quantity.sendKeys(details.quant);
        Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(selectSize)));
        select.selectByVisibleText(details.size);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(color,details.col)))).click();
        try {
            ScreenShoots.takePageScreenshot(driver,"ProductDetailsItem"+details.itemName);
        } catch (IOException e) {
            Log.error(e.getMessage());
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }
}
