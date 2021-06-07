package PageFactoryPom.Pages.Products;

import PageFactoryPom.Utilities.ItemDetails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickViewPage {

    WebDriver driver;
    WebDriverWait wait;

    By itemName = By.xpath("//div[@id ='center_column']//div[@class='primary_block row']//h1[@itemprop='name']");
    By quantityWanted = By.id("quantity_wanted");
    By selectSize = By.id("group_1");
    String color = "//ul[@id='color_to_pick_list']//a[@title='%s']";
    By addToCardBtn = By.xpath("//p[@id = 'add_to_cart']/button[@name = 'Submit']");

    public QuickViewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void fillAndAddProductDetails(ItemDetails details){
        driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));

        /*WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(this.itemName));
        Assert.assertEquals(details.itemName,name.getText());*/
        WebElement quantity= wait.until(ExpectedConditions.presenceOfElementLocated(this.quantityWanted));
        quantity.clear();
        quantity.sendKeys(details.quant);
        Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(selectSize)));
        select.selectByVisibleText(details.size);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(color,details.col)))).click();

        wait.until(ExpectedConditions.elementToBeClickable(addToCardBtn)).click();
    }
}
