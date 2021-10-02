package PageFactoryPom.Pages.HomePages;

import PageFactoryPom.Pages.NavigationMenu.Dresses.CasualDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.EveningDresses;
import PageFactoryPom.Pages.NavigationMenu.Dresses.SummerDresses;
import PageFactoryPom.Pages.NavigationMenu.Tshirt.TshirtPage;
import PageFactoryPom.Pages.NavigationMenu.Women.TopsBlouses;
import PageFactoryPom.Pages.NavigationMenu.Women.TopsTshirts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomeMenu {
    WebDriver driver;
    WebDriverWait wait;

    // Women elements
    By womenMenu = By.xpath(".//div[@id='block_top_menu']//a[contains(text(),'Women')]");
    By womenEveningDresses = By.xpath(".//a[contains(text(),'Evening Dresses')]");
    By womenCasualDresses = By.xpath(".//a[contains(text(),'Casual Dresses')]");
    By womenSummerDresses = By.xpath(".//a[contains(text(),'Summer Dresses')]");
    By womenTshirts = By.xpath(".//a[contains(text(),'T-shirts')]");
    By womenBlouses = By.xpath(".//a[contains(text(),'Blouses')]");

    // Dresses elements
    By dressesMenu = By.xpath(".//div[@id='block_top_menu']//a[contains(text(),'Dresses')]");
    By dressesEveningDresses = By.xpath(".//a[contains(text(),'Evening Dresses')]");
    By dressesCasualDresses = By.xpath(".//a[contains(text(),'Casual Dresses')]");
    By dressesSummerDresses = By.xpath(".//a[contains(text(),'Summer Dresses')]");

    By tshirtMenu = By.xpath(".//div[@id='block_top_menu']//li[3]");
    //a[contains(text(),'T-shirts')]

    public HomeMenu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public void hoverDressesMenu(){
        Actions actions = new Actions(driver);
        WebElement dressesMenuEl = wait.until(ExpectedConditions.presenceOfElementLocated(dressesMenu));
        actions.moveToElement(dressesMenuEl).perform();
    }
    public void hoverWomenMenu(){
        Actions actions = new Actions(driver);
        WebElement womenMenuEl = wait.until(ExpectedConditions.presenceOfElementLocated(womenMenu));
        actions.moveToElement(womenMenuEl).perform();
    }

    // Dresses Menu
    public CasualDresses clickOnCasualDresses(){
        Actions actions = new Actions(driver);
        WebElement subMenuCasualDress = wait.until(ExpectedConditions.presenceOfElementLocated(dressesCasualDresses));
        actions.click(subMenuCasualDress).perform();
        return new CasualDresses(driver);
    }
    public EveningDresses clickOnEveningDresses(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(dressesEveningDresses));
        actions.click(subMenuEveningDress).perform();
        return new EveningDresses(driver);
    }
    public SummerDresses clickOnSummerDresses(){
        Actions actions = new Actions(driver);
        WebElement subMenuSummerDress = wait.until(ExpectedConditions.presenceOfElementLocated(dressesSummerDresses));
        actions.click(subMenuSummerDress).perform();
        return new SummerDresses(driver);
    }

    // Women Menu
    public CasualDresses clickOnCasualWomen(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(womenCasualDresses));
        actions.click(subMenuEveningDress).perform();
        return new CasualDresses(driver);
    }
    public EveningDresses clickOnEveningWomen(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(womenEveningDresses));
        actions.click(subMenuEveningDress).perform();
        return new EveningDresses(driver);
    }
    public SummerDresses clickOnSummerWomen(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(womenSummerDresses));
        actions.click(subMenuEveningDress).perform();
        return new SummerDresses(driver);
    }
    public TopsBlouses clickOnTopBlouses(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(womenBlouses));
        actions.click(subMenuEveningDress).perform();
        return new TopsBlouses(driver);
    }
    public TopsTshirts clickOnTopTshirts(){
        Actions actions = new Actions(driver);
        WebElement subMenuEveningDress = wait.until(ExpectedConditions.presenceOfElementLocated(womenTshirts));
        actions.click(subMenuEveningDress).perform();
        return new TopsTshirts(driver);
    }

    // T-shirt Menu
    public TshirtPage clickOnTshirtPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        WebElement mainTshirtMenu = wait.until(ExpectedConditions.elementToBeClickable(tshirtMenu));
        mainTshirtMenu.submit();
        return new TshirtPage(driver);
    }
}
