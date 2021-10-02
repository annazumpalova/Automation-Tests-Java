package PageFactoryPom.Pages.FooterSections;

import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.NavigationMenu.FooterPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountSection {
    WebDriver driver;
    WebDriverWait wait;

    By myOrders = By.xpath(".//footer[@id='footer']//div[@class='block_content toggle-footer']//a[@title='My orders']");
    By creditSlips = By.xpath(".//footer[@id='footer']//div[@class='block_content toggle-footer']//a[@title='My credit slips']");
    By myAddresses = By.xpath(".//footer[@id='footer']//div[@class='block_content toggle-footer']//a[@title='My addresses']");
    By myPersonalInf = By.xpath(".//footer[@id='footer']//div[@class='block_content toggle-footer']//a[@title='Manage my personal information']");
    By signOut = By.xpath(".//footer[@id='footer']//div[@class='block_content toggle-footer']//a[@title='Sign out']");

    public MyAccountSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public MyOrdersPage checkMyOrders(){
        WebElement myOrdersEl = wait.until(ExpectedConditions.presenceOfElementLocated(myOrders));
        myOrdersEl.click();
        return new MyOrdersPage(driver);
    }

    public CreditsSlips checkCreditSlips(){
        WebElement creditSlipsEl = wait.until(ExpectedConditions.presenceOfElementLocated(creditSlips));
        creditSlipsEl.click();
        return new CreditsSlips(driver);
    }

    public MyAdressesPage checkMyAddresses(){
        WebElement myAddressesEl = wait.until(ExpectedConditions.presenceOfElementLocated(myAddresses));
        myAddressesEl.click();
        return new MyAdressesPage(driver);
    }

    public PersonalInformationPage checkMyPersonalInf(){
        WebElement myInfoEl = wait.until(ExpectedConditions.presenceOfElementLocated(myPersonalInf));
        myInfoEl.click();
        return new PersonalInformationPage(driver);
    }

    public LoginPage signOut(){
        WebElement signOutEl = wait.until(ExpectedConditions.presenceOfElementLocated(signOut));
        signOutEl.click();
        return new LoginPage(driver);
    }

}
