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

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By email = By.id("email");
    By password = By.id("passwd");
    By loginButton = By.id("SubmitLogin");
    By forgotPassword = By.xpath("//p[@class='lost_password form-group']/a[contains(text(),'Forgot')]");
    By checkerLoginSuccess = By.xpath("//span[@class='navigation_page' and contains(text(),'My account')]");
    By emailRegisterField = By.xpath(".//div[@class='form-group']/input[@class='is_required validate account_input form-control']");
    By createAccountBtn = By.xpath(".//button[@class='btn btn-default button button-medium exclusive']/span/i[@class='icon-user left']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void login(String username, String passwordStr) throws IOException {
        WebElement emailEl = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        ScreenShoots.takeElementScreenShoot(emailEl, "email");
        if (emailEl.isEnabled()) {
            emailEl.sendKeys(username);
        } else {
            Log.error("email field is not enabled");
            throw new IllegalArgumentException("email field is not enabled");
        }
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        if (pass.isEnabled()) {
            pass.sendKeys(passwordStr);
        } else {
            ScreenShoots.takeElementScreenShoot(pass, "passFailed");
            Log.error("password field is not enabled");
            throw new IllegalArgumentException("password field is not enabled");
        }
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkerLoginSuccess));
    }

    public void forgotPassword() throws IOException {
        WebElement fortgotPassButton = wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
        if (fortgotPassButton.isEnabled()) {
            fortgotPassButton.click();
        } else {
            ScreenShoots.takeElementScreenShoot(fortgotPassButton, "forgotPassFailed");
            Log.error("forgot password button is not enabled");
            throw new IllegalArgumentException("forgot password button is not enabled");
        }
    }

    public RegisterPage fillEmailRegister(String email) throws IOException {
        WebElement emailFieldRegister = wait.until(ExpectedConditions.presenceOfElementLocated(emailRegisterField));
        emailFieldRegister.sendKeys(email);
        WebElement btnCreateAccount = wait.until(ExpectedConditions.presenceOfElementLocated(createAccountBtn));
        if (btnCreateAccount.isEnabled()) {
            btnCreateAccount.click();
            return new RegisterPage(driver);
        } else {
            ScreenShoots.takeElementScreenShoot(btnCreateAccount, "createAccount - Failed");
            Log.error("create account button is not enabled");
            throw new IllegalArgumentException("create account button is not enabled");
        }
    }
}
