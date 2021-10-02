package PageFactoryPom.Pages.FooterSections;

import PageFactoryPom.Pages.NavigationMenu.Women.WomenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenSection {
    WebDriver driver;
    WebDriverWait wait;
    By womenFooter = By.xpath(".//footer[@id='footer']//div[@class='category_footer toggle-footer']//a[contains(text(),'Women')]");

    public WomenSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }
    public WomenPage checkWomen(){
        WebElement womenEl = wait.until(ExpectedConditions.presenceOfElementLocated(womenFooter));
        womenEl.click();
        return new WomenPage(driver);
    }
}
