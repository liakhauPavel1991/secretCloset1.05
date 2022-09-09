package tests;

import org.junit.jupiter.api.Test;
import steps.MainScreenSteps;
import steps.ProductSteps;
import steps.SellerSteps;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDiscountAndSellerInfo() {
        MainScreenSteps.selectRandomCity();
        ProductSteps.verifyProductPriceWithDiscount();
        SellerSteps.verifySellerInfo();
    }

}
