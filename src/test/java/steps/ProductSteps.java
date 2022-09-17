package steps;

import io.qameta.allure.Step;
import models.Product;
import org.testng.Assert;
import screens.ProductRibbonScreen;
import screens.ProductScreen;

public class ProductSteps extends BaseStep {

    @Step("Verify product price with discount")
    public static void verifyProductPriceWithDiscount() {
        Product firstItemWithDiscount = tapFirstItemWithDiscount();
        verifyThatProductPriceOnMainScreenAndProductScreenTheSame(firstItemWithDiscount);
        verifyDiscountCalculation(firstItemWithDiscount);
    }

    @Step("Tap first item with discount")
    public static Product tapFirstItemWithDiscount() {
        ProductRibbonScreen ribbonScreen = new ProductRibbonScreen();
        Product productWithDiscount = ribbonScreen.getFirstProductWithDiscount();
        ProductScreen productScreen = ribbonScreen.tapOnBanner(productWithDiscount);
        Assert.assertTrue(productScreen.state().isDisplayed(),
                "Product screen is opened");
        return productWithDiscount;
    }

    @Step("Verify that Product Price on main screen and product screen the same")
    public static void verifyThatProductPriceOnMainScreenAndProductScreenTheSame(Product product) {
        ProductScreen productScreen = new ProductScreen();
        Assert.assertEquals(product, productScreen.getProductModel(),
                String.format("Product from main screen %s, product from product screen %s", product, productScreen));
    }

    @Step("Verify discount calculation")
    public static void verifyDiscountCalculation(Product product) {
        int fullPrice = product.getOriginalPrice();
        int discount = product.getDiscountPercentValue();
        int result = fullPrice - (int) Math.ceil((double) fullPrice * discount / 100);
        Assert.assertEquals(product.getFinalPrice(), result,
                "discount calculation is correct");
    }
}
