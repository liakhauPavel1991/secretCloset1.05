package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.FailedSteps;
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

    @Test(description = "This is test to check allure report")
    public void testAllureReport() {
        FailedSteps.failedStep();
    }

}
