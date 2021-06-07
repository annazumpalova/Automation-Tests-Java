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
    By specialsFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Specials']");
    By newProductsFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'New products']");
    By bestSellersFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Best sellers']");
    By ourStoresFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Our stores']");
    By contactUsFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Contact us']");
    By termsAndConditionsFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Terms and conditions of use']");
    By aboutUsFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'About us']");
    By siteMapFooter = By.xpath(".//section[@id='block_various_links_footer']//a[contains(text(),'Sitemap']");

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

