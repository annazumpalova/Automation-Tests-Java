package PopularBestsellersTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.HomePages.PopularSection;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
import PageFactoryPom.Pages.Products.ProductDetailsPage;
import PageFactoryPom.Pages.Products.QuickViewPage;
import PageFactoryPom.Pages.Products.SuccessfulAddedToCartPage;
import PageFactoryPom.Pages.ShippingCart.*;
import PageFactoryPom.Utilities.ItemDetails;
import PageFactoryPom.Utilities.Log;
import PageFactoryPom.Utilities.ReadFromExcel;
import PageFactoryPom.Utilities.ScreenShoots;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PopularTests extends MainSetUp{
    ItemDetails itemDetails;

    public PopularTests(String item, String price, String quant, String size, String col, String num, String numTwo) {
        itemDetails = new ItemDetails(item, price, quant, size, col, num, numTwo);
    }

    @Parameterized.Parameters
    public static Collection inputs() throws IOException {
        return ReadFromExcel.readExcel(MainSetUp.getItemFilePath());
    }

    @Before
    public void setUp() {
        try {
            this.setUpMain();
        } catch (IOException e) {
            Log.error(e.getMessage());
            try {
                ScreenShoots.takePageScreenshot(this.driver, "MainSetUp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.quit();
    }

    @Test
    public void popularSectionQuickView() throws IOException, InterruptedException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            PopularSection popularSection = new PopularSection(driver);
            QuickViewPage quickViewPage = popularSection.addToCardQuickViewPopularSection(itemDetails);
            Thread.sleep(5000);
            quickViewPage.fillAndAddProductDetails(itemDetails);

            SuccessfulAddedToCartPage successfulAddedToCartPage = new SuccessfulAddedToCartPage(driver);
            SummaryPage summaryPage = successfulAddedToCartPage.proceedToCheckout(itemDetails);
            AddressPage addressPage = summaryPage.proceedToCheckout();

            addressPage.setOrderAddress("Sofia, Mladost order addresssss");
            Assert.assertEquals("AnnaAnna ZumpalovaZumpalova", addressPage.getTextFromNameFiled());
            ShippingPage shippingPage = addressPage.clickProceedButton();
            shippingPage.proceed();
            shippingPage.checkAndCloseTancCDialog();

            PaymentPage paymentPage = shippingPage.acceptAndProceed();
            paymentPage.checkItemName(itemDetails.itemName);
            paymentPage.checkItemPrice(itemDetails.price);
            BankWirePayment bankWirePayment = paymentPage.checkTotalPriceAndPayBankWire(itemDetails);
            bankWirePayment.completePayment();
            Thread.sleep(5000);
        }catch (RuntimeException e) {
            Log.error("Popular test - QuickView is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "QuickViewPopular");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void popularSectionMore() throws InterruptedException, IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            PopularSection popularSection = new PopularSection(driver);
            ProductDetailsPage productDetailsPage = popularSection.addToCardMorePopularSection(itemDetails);
            productDetailsPage.fillAndAddProductDetails(itemDetails);

            SuccessfulAddedToCartPage successfulAddedToCartPage = new SuccessfulAddedToCartPage(driver);
            SummaryPage summaryPage = successfulAddedToCartPage.proceedToCheckout(itemDetails);
            AddressPage addressPage = summaryPage.proceedToCheckout();

            addressPage.setOrderAddress("Sofia, Mladost order addresssss");
            Assert.assertEquals("AnnaAnna ZumpalovaZumpalova", addressPage.getTextFromNameFiled());
            ShippingPage shippingPage = addressPage.clickProceedButton();
            shippingPage.proceed();
            shippingPage.checkAndCloseTancCDialog();

            PaymentPage paymentPage = shippingPage.acceptAndProceed();
            paymentPage.checkItemName(itemDetails.itemName);
            paymentPage.checkItemPrice(itemDetails.price);
            BankWirePayment bankWirePayment = paymentPage.checkTotalPriceAndPayBankWire(itemDetails);
            bankWirePayment.completePayment();
            Thread.sleep(5000);
        }catch (RuntimeException e) {
            Log.error("Popular test - moreBtn is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "MorePopular");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }

    @Test
    public void popularAddToCard() throws InterruptedException, IOException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            PopularSection popularSection = new PopularSection(driver);
            SuccessfulAddedToCartPage successfulAddedToCartPage = popularSection.addToCardPopular(itemDetails);
            SummaryPage summaryPage = successfulAddedToCartPage.clickCheckOut();
            AddressPage addressPage = summaryPage.proceedToCheckout();

            addressPage.setOrderAddress("Sofia, Mladost order addresssss");
            Assert.assertEquals("AnnaAnna ZumpalovaZumpalova", addressPage.getTextFromNameFiled());
            ShippingPage shippingPage = addressPage.clickProceedButton();
            shippingPage.proceed();
            shippingPage.checkAndCloseTancCDialog();

            PaymentPage paymentPage = shippingPage.acceptAndProceed();
            paymentPage.checkItemName(itemDetails.itemName);
            paymentPage.checkItemPrice(itemDetails.price);
            BankWirePayment bankWirePayment = paymentPage.checkTotalPriceAndPayBankWire(itemDetails);
            bankWirePayment.completePayment();
            Thread.sleep(5000);
        }catch (RuntimeException e) {
            Log.error("Popular test - addToCard is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "AddToCardPopular");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
