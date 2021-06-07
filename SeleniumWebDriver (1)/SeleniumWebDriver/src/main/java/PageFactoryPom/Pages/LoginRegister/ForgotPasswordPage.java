package PageFactoryPom.Pages.LoginRegister;

import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class ForgotPasswordPage {

    WebDriver driver;
    WebDriverWait wait;

    By emailRecovery = By.xpath(".//form[@class='std']/fieldset/div[@class='form-group']/input[@id='email']");
    By buttonSubmitForgotPass = By.xpath(".//button[@class='btn btn-default button button-medium']");
    By messageSuccessfulSendEmail = By.xpath(".div[@id='center_column']//p[@class='alert alert-success']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void forgotPass(String emailRecoveryForgotPass) throws IOException {
        WebElement emailFieldEl = wait.until(ExpectedConditions.presenceOfElementLocated(emailRecovery));
        WebElement buttonSubmiEmail = wait.until(ExpectedConditions.presenceOfElementLocated(buttonSubmitForgotPass));

        if (emailFieldEl.isEnabled()) {
            emailFieldEl.sendKeys(emailRecoveryForgotPass);
            buttonSubmiEmail.click();
        } else {
            ScreenShoots.takeElementScreenShoot(emailFieldEl, "emailField-ForgotPasswordFailed");
            Log.error("email field is not enabled");
            throw new IllegalArgumentException("Email field - forgot pass is not enabled!");
        }
    }

    public void checkSuccessfulSendEmail(String email) throws IOException {
        try{
            WebElement checkMessageEmail = wait.until(ExpectedConditions.presenceOfElementLocated(messageSuccessfulSendEmail));
            Assert.assertEquals(checkMessageEmail.getText(), "A confirmation email has been sent to your address: " + email);
        }catch (RuntimeException e){
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Forgot password successful test - failed");
            throw e;
        }
    }

    public void checkUnsuccessfulSendEmail(){
        String alertMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='alert alert-danger']/p"))).getText();
        Assert.assertEquals(alertMessage, "There is 1 error");
        String alertMessageError = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='alert alert-danger']/ol/li"))).getText();
        Assert.assertEquals(alertMessageError, "Invalid email address.");
    }
}

