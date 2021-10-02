package ProductsSearchTests;

import MainSetUpFile.MainSetUp;
import PageFactoryPom.Pages.HomePages.HomePage;
import PageFactoryPom.Pages.LoginRegister.LoginPage;
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
public class BuyItemQuickViewTest extends MainSetUp{
    ItemDetails itemDetails;

    public BuyItemQuickViewTest(String item, String price, String quant, String size, String col, String num1, String num2) {
        itemDetails = new ItemDetails(item, price, quant, size, col, num1, num2);
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
    public void testQuickViewAndBuy() throws IOException, InterruptedException {
        try {
            HomePage homePage = new HomePage(driver, this.getMainURL());
            homePage.loadPage();

            LoginPage loginPage = homePage.openLoginPage();
            loginPage.login(this.getUsername(), this.getPassword());
            Assert.assertEquals(this.getUsernameLoggedInInfo(), homePage.getUserInfo());

            QuickViewPage quickViewPage = homePage.openQuickViewPage(itemDetails.itemName);
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
            Log.error("Buy item Quick View Test is failed.");
            Log.error(e.getMessage());
            ScreenShoots.takePageScreenshot(driver, "QuickView - Buy Item");
            if(verifyResourceLimit()){
                System.out.println("Resource limit is reached!");
            }
            throw e;
        }
    }
}
