package PageFactoryPom.Pages.LoginRegister;

import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    By email = By.xpath("By.xpath(\".//div[@class='required form-group']/input[@id='email']");


    // Personal information
    By gender = By.xpath(".//div[@class='radio-inline']/label/div[@id='uniform-id_gender2']/span/input[@id='id_gender2']");
    By customerFirstName = By.xpath(".//div[@class='required form-group']/input[@id='customer_firstname']");
    By customerLastname = By.xpath(".//div[@class='required form-group']/input[@id='customer_lastname']");
    By password = By.xpath(".//div[@class='required password form-group']/input[@id='passwd']");
    By birthdayDay = By.xpath(".//div[@class='selector']/select[@id='days']/option[@value='29']");
    By birthdayMonth = By.xpath(".//div[@class='selector']/select[@id='months']/option[@value='5']");
    By birthdayYear = By.xpath(".//div[@class='selector']/select[@id='years']/option[@value='1997']");
    By firstName = By.xpath(".//p[@class='required form-group']/input[@id='firstname']");
    By lastName = By.xpath(".//p[@class='required form-group']/input[@id='lastname']");
    By companyName = By.xpath(".//p[@class='form-group']/input[@id='company']");
    By address1 = By.xpath(".//p[@class='required form-group']/input[@id='address1']");
    By address2 = By.xpath(".//p[@class='form-group is_customer_param']/input[@id='address2']");
    By city = By.xpath(".//p[@class='required form-group']/input[@id='city']");
    By idState = By.xpath(".//div[@class='selector']/select[@id='id_state']/option[@value='4']");
    By postcode = By.xpath(".//p[@class='required postcode form-group']/input[@id='postcode']");
    By textArea = By.xpath(".//p[@class='textarea form-group']/textarea[@id='other']");
    By phone = By.xpath(".//p[@class='form-group']/input[@id='phone']");
    By phoneMobile = By.xpath(".//p[@class='required form-group']/input[@id='phone_mobile']");
    By alias = By.xpath(".//p[@class='required form-group']/input[@id='alias']");
    By submitAccountBtn = By.xpath(".//button[@id='submitAccount']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void fillAllInformation(String customerFirstNameKInput, String customerLastNameInput, String passInput,
                                   String firstNameInput, String lastNameInput, String companyInput,
                                   String address1Input, String adress2Input, String cityInput, String postcodeInput,
                                   String phoneInput, String mobilePhoneInput, String aliasInput) throws IOException {
        WebElement genderEl = wait.until(ExpectedConditions.presenceOfElementLocated(gender));
        WebElement customerFirstNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(customerFirstName));
        WebElement customerLastNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(customerLastname));
        WebElement passEl = wait.until(ExpectedConditions.presenceOfElementLocated(password));
        WebElement birthdayElDay = wait.until(ExpectedConditions.presenceOfElementLocated(birthdayDay));
        WebElement birthdayElMonth = wait.until(ExpectedConditions.presenceOfElementLocated(birthdayMonth));
        WebElement birthdayElYear = wait.until(ExpectedConditions.presenceOfElementLocated(birthdayYear));
        WebElement firstNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        WebElement lastNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
        WebElement companyNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(companyName));
        WebElement address1El = wait.until(ExpectedConditions.presenceOfElementLocated(address1));
        WebElement address2El = wait.until(ExpectedConditions.presenceOfElementLocated(address2));
        WebElement cityEl = wait.until(ExpectedConditions.presenceOfElementLocated(city));
        WebElement idStateEl = wait.until(ExpectedConditions.presenceOfElementLocated(idState));
        WebElement postcodeEl = wait.until(ExpectedConditions.presenceOfElementLocated(postcode));
        WebElement textareaEl = wait.until(ExpectedConditions.presenceOfElementLocated(textArea));
        WebElement phoneEl = wait.until(ExpectedConditions.presenceOfElementLocated(phone));
        WebElement phoneMobileEl = wait.until(ExpectedConditions.presenceOfElementLocated(phoneMobile));
        WebElement aliasEl = wait.until(ExpectedConditions.presenceOfElementLocated(alias));
        WebElement buttonSubmit = wait.until(ExpectedConditions.presenceOfElementLocated(submitAccountBtn));

        try{
            Assert.assertEquals(driver.findElement(email).getAttribute("value"), "anna.zumpalova@abv.bg");
        }catch (IllegalAccessError e){
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "Email verification - register");
            throw e;
        }

        Actions actions = new Actions(driver);
        actions.click(genderEl);
        actions.sendKeys(customerFirstNameEl, customerFirstNameKInput);
        actions.sendKeys(customerLastNameEl, customerLastNameInput);
        actions.sendKeys(passEl, passInput);
        actions.click(birthdayElDay);
        actions.click(birthdayElMonth);
        actions.click(birthdayElYear);
        actions.sendKeys(firstNameEl, firstNameInput);
        actions.sendKeys(lastNameEl, lastNameInput);
        actions.sendKeys(companyNameEl, companyInput);
        actions.sendKeys(address1El, address1Input);
        actions.sendKeys(address2El, adress2Input);
        actions.sendKeys(cityEl, cityInput);
        actions.click(idStateEl);
        actions.sendKeys(postcodeEl, postcodeInput);
        actions.sendKeys(textareaEl, "My automation tests are running!");
        actions.sendKeys(phoneEl, phoneInput);
        actions.sendKeys(phoneMobileEl, mobilePhoneInput);
        actions.sendKeys(aliasEl, aliasInput);
        Action ac = actions.build();
        ac.perform();

        if (buttonSubmit.isEnabled()) {
            buttonSubmit.click();
        } else {
            ScreenShoots.takeElementScreenShoot(buttonSubmit, "submit button registration form failed!");
            Log.error("submit button (registration) is not enabled");
            throw new IllegalArgumentException("submit button (registration) is not enabled");
        }
    }

    public void checkSuccessfulRegistration(){
        try{
            Assert.assertEquals(driver.findElement(By.xpath(".//div[@class='header_user_info']/a/span")).getText(), "Anna Zumpalova");
        }catch(IllegalAccessError e){
            Log.error("Not successful registration!");
            throw new IllegalArgumentException("Nor successful registration!");
        }
    }

    public void fillNotAllInformation(){
        WebElement buttonSubmit = wait.until(ExpectedConditions.presenceOfElementLocated(submitAccountBtn));
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='alert alert-danger']/p")));
        buttonSubmit.click();
        try {
            Assert.assertEquals("There are 8 errors", errorMessage.getText());
        }catch (IllegalAccessError e){
            Log.error("Error message - registration - does not appear!");
            throw new IllegalArgumentException("Error message - registration - does not appear!");
        }
    }
}
