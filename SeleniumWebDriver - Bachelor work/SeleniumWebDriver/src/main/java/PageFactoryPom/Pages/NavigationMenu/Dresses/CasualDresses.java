package PageFactoryPom.Pages.NavigationMenu.Dresses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasualDresses {

    WebDriver driver;
    WebDriverWait wait;
    By pageTitle = By.xpath(".//div[@id='center_column']/h1[@class='page-heading product-listing']/span[@class='cat-name']");

    public CasualDresses(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public void checkDressesCasual(){
        WebElement pageTitleEl = wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
        Assert.assertEquals("CASUAL DRESSES ", pageTitleEl.getText());
    }
}
