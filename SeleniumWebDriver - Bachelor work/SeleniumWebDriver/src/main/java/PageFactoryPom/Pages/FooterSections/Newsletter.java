package PageFactoryPom.Pages.FooterSections;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.ldap.PagedResultsControl;
import java.awt.*;

public class Newsletter {
    WebDriver driver;
    WebDriverWait wait;
    By emailField = By.xpath(".//input[@id='newsletter-input']");
    By btnSubmit = By.xpath(".//div[@id='newsletter_block_left']//button[@class='btn btn-default button button-small']");
    By message = By.xpath(".//div[@id='columns']/p[@class='alert alert-danger']");

    public Newsletter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public void sendEmail(String email){
        WebElement inputEmailField = wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        WebElement btnSubmitEl = wait.until(ExpectedConditions.presenceOfElementLocated(btnSubmit));
        inputEmailField.sendKeys(email);
        btnSubmitEl.click();
    }

    public void checkSuccessfulRegisterEmail(){
        WebElement messageEl = wait.until(ExpectedConditions.presenceOfElementLocated(message));
        Assert.assertEquals("Newsletter : This email address is already registered.", messageEl.getText());
    }
}

