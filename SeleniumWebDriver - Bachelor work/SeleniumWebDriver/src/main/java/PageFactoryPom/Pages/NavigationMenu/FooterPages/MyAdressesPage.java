package PageFactoryPom.Pages.NavigationMenu.FooterPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAdressesPage {
    WebDriver driver;
    WebDriverWait wait;
    By pageTitle = By.xpath(".//div[@id='center_column']//h1[@class='page-heading']");

    public MyAdressesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public void checkMyAdresses() {
        WebElement pageTitleEl = wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
        Assert.assertEquals("MY ADDRESSES", pageTitleEl.getText());
    }
}
