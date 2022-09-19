package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public class FailedSteps {

    @Step("This is step for failed test to check allure report")
    public static void failedStep() {
        Assert.assertTrue(false, "Too see it in allure report");
    }
}
