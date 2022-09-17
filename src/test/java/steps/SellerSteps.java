package steps;

import models.Seller;
import org.testng.Assert;
import screens.ProductScreen;
import screens.SellerScreen;

public class SellerSteps extends BaseStep {

    public static void verifySellerInfo() {
        ProductScreen productScreen = new ProductScreen();
        Seller sellerOnProductScreen = productScreen.getSellerModel();
        SellerScreen sellerScreen = clickOnSeller();
        Seller sellerOnSellerScreen = sellerScreen.getSeller();
        Assert.assertEquals(sellerOnProductScreen, sellerOnSellerScreen,
                String.format("Seller info on product screen: [%s], seller screen: [%s]",
                        sellerOnSellerScreen.comparableInfo(), sellerOnSellerScreen.comparableInfo()));
    }

    public static SellerScreen clickOnSeller() {
        ProductScreen productScreen = new ProductScreen();
        SellerScreen sellerScreen = productScreen.clickOnSellerAvatar();
        Assert.assertTrue(sellerScreen.state().isDisplayed(),
                "Seller screen is opened");
        return sellerScreen;
    }
}
