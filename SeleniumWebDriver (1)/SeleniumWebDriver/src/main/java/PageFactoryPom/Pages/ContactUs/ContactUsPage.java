package PageFactoryPom.Pages.ContactUs;

import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ContactUsPage {
    WebDriver driver;
    WebDriverWait wait;
    By emailField = By.xpath(".//p[@class='form-group']/input[@id='email']");
    By idOrderField = By.xpath(".//div[@class='form-group selector1']/input[@id='id_order']");
    By messageField = By.xpath(".//div[@class='form-group']/textarea[@id='message']");
    By submitBtn = By.xpath(".//button[@id='submitMessage']");
    By selectType = By.xpath(".//div[@class='selector']/select[@id='id_contact']/option[@value='2']");
    By verifyMessage = By.xpath(".//div[@id='center_column']/p[@class='alert alert-success']");
    By errorMessage = By.xpath(".//div[@id='center_column']/div[@class='alert alert-danger']/ol/li");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public void fillAllInformation(String email, String idOrder, String message) throws IOException {
        WebElement emailFieldEl = wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        WebElement idOrderEl = wait.until(ExpectedConditions.presenceOfElementLocated(idOrderField));
        WebElement messageEl = wait.until(ExpectedConditions.presenceOfElementLocated(messageField));
        WebElement selectTypeEl = wait.until(ExpectedConditions.presenceOfElementLocated(selectType));
        WebElement submitButtonEl = wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
        WebElement checkMessage = wait.until(ExpectedConditions.presenceOfElementLocated(verifyMessage));

        emailFieldEl.sendKeys(email);
        idOrderEl.sendKeys(idOrder);
        messageEl.sendKeys(message);
        selectTypeEl.click();

        if (submitButtonEl.isEnabled()) {
            submitButtonEl.click();
        } else {
            ScreenShoots.takeElementScreenShoot(submitButtonEl, "submit button contact us failed!");
            Log.error("submit button (contact us) is not enabled");
            throw new IllegalArgumentException("submit button (contact us) is not enabled");
        }

        try{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertEquals(checkMessage.getText(), "Your message has been successfully sent to our team.");
        }catch (IllegalAccessError e){
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Unsuccessful contact us");
            throw e;
        }
    }

    public void notSuccessfulContactUs(String email, String idOrder) throws IOException {
        WebElement emailFieldEl = wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        WebElement idOrderEl = wait.until(ExpectedConditions.presenceOfElementLocated(idOrderField));
        WebElement selectTypeEl = wait.until(ExpectedConditions.presenceOfElementLocated(selectType));
        WebElement submitButtonEl = wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
        WebElement errorMessageEl = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));

        emailFieldEl.sendKeys(email);
        idOrderEl.sendKeys(idOrder);
        selectTypeEl.click();

        if (submitButtonEl.isEnabled()) {
            submitButtonEl.click();
        } else {
            ScreenShoots.takeElementScreenShoot(submitButtonEl, "submit button contact us failed!");
            Log.error("submit button (contact us) is not enabled");
            throw new IllegalArgumentException("submit button (contact us) is not enabled");
        }

        try{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertEquals(errorMessageEl.getText(), "The message cannot be blank.");
        }catch (IllegalAccessError e){
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Unsuccessful error message contact us");
            throw e;
        }
    }
}
