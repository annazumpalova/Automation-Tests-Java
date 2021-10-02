package PageFactoryPom.Pages.FooterSections;

import PageFactoryPom.Pages.ContactUs.ContactUsPage;
import PageFactoryPom.Pages.NavigationMenu.FooterPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationSection {
    WebDriver driver;
    WebDriverWait wait;
    By specialsFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Specials']");
    By newProductsFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='New products']");
    By bestSellersFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Best sellers']");
    By ourStoresFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Our stores']");
    By contactUsFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Contact us']");
    By termsAndConditionsFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Terms and conditions of use']");
    By aboutUsFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='About us']");
    By siteMapFooter = By.xpath(".//footer[@id='footer']//section[@id='block_various_links_footer']//a[@title='Sitemap']");

    public InformationSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public SpecialsPage checkSpecials(){
        WebElement specialsEl = wait.until(ExpectedConditions.presenceOfElementLocated(specialsFooter));
        specialsEl.click();
        return new SpecialsPage(driver);
    }

    public NewProductsPage checkNewProducts(){
        WebElement productsEl = wait.until(ExpectedConditions.presenceOfElementLocated(newProductsFooter));
        productsEl.click();
        return new NewProductsPage(driver);
    }

    public BestSellersPage checkBestSellers(){
        WebElement bestSellersEl = wait.until(ExpectedConditions.presenceOfElementLocated(bestSellersFooter));
        bestSellersEl.click();
        return new BestSellersPage(driver);
    }

    public OurStoresPage checkOurStores(){
        WebElement ourStoresEl = wait.until(ExpectedConditions.presenceOfElementLocated(ourStoresFooter));
        ourStoresEl.click();
        return new OurStoresPage(driver);
    }

    public ContactUsPage checkContactUs(){
        WebElement contactUsEl = wait.until(ExpectedConditions.presenceOfElementLocated(contactUsFooter));
        contactUsEl.click();
        return new ContactUsPage(driver);
    }

    public TermsAndConditions checkTermsAndConditions(){
        WebElement termsAndConditionsEl = wait.until(ExpectedConditions.presenceOfElementLocated(termsAndConditionsFooter));
        termsAndConditionsEl.click();
        return new TermsAndConditions(driver);
    }

    public AboutUs checkAboutUs(){
        WebElement aboutUsEl = wait.until(ExpectedConditions.presenceOfElementLocated(aboutUsFooter));
        aboutUsEl.click();
        return new AboutUs(driver);
    }

    public SiteMap checkSitemap(){
        WebElement siteMapEl = wait.until(ExpectedConditions.presenceOfElementLocated(siteMapFooter));
        siteMapEl.click();
        return new SiteMap(driver);
    }
}

