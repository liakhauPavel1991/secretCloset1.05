package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.MainScreenSteps;
import steps.ProductSteps;
import steps.SellerSteps;

@Epic("Regression Tests")
@Feature("Dashboard Tests")
public class DashboardTest extends BaseTest {

    @Test(description = "Verify discount and seller info")
    public void verifyDiscountAndSellerInfo() {
        MainScreenSteps.selectRandomCity();
        ProductSteps.verifyProductPriceWithDiscount();
        SellerSteps.verifySellerInfo();
    }

    @Test(description = "This test to check allure report")
    public void testAllureReport() {
        Assert.assertTrue(false, "Too see it in allure report");
    }

}
