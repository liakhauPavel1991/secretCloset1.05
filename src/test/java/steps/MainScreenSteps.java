package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import screens.MainScreen;
import screens.SelectCityScreen;
import screens.alerts.CityAlert;

public class MainScreenSteps extends BaseStep {

    @Step("Select random city")
    public static void selectRandomCity() {
        tapOnCityOnMainPage();
        String randomCity = typeRandomCity();
        tapOnCityInList(randomCity);
    }

    @Step("Tap on city on main page")
    public static void tapOnCityOnMainPage() {
        MainScreen mainPage = new MainScreen();
        CityAlert cityAlert = mainPage.tapCityButton();
        cityAlert.tapOk();
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        Assert.assertTrue(selectCityScreen.state().isDisplayed(),
                "The city selection screen is open");
    }

    @Step("Type random city")
    public static String typeRandomCity() {
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        String randomCityName = selectCityScreen.getRandomCityNameFromList();
        selectCityScreen.typeInCityTextBox(randomCityName);
        Assert.assertEquals(randomCityName, selectCityScreen.getTextFromCityTextBox(),
                "Search city textBox shows entered value");
        return randomCityName;
    }

    @Step("Tap on city in list")
    public static void tapOnCityInList(String city) {
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        MainScreen mainScreen = selectCityScreen.tapOnCity(city);
        mainScreen.waitUntilCityButtonContains(city);
        Assert.assertTrue(mainScreen.state().isDisplayed(),
                "After tap on city main screen");
        Assert.assertEquals(city, mainScreen.getCityButtonText(),
                "Chosen city is displayed on main screen");
    }

}
