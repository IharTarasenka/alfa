package ui.mainPage;

import com.org.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;

public class ContentTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    private void init() {
        mainPage = new MainPage();
        mainPage.goToMainPage();
    }

//    add constants for expectation
    @Test
    private void headerTitle() {
        Assert.assertTrue(mainPage.getHeader().isDisplayed(), "Page header is not displayed");
        Assert.assertEquals(mainPage.getHeaderText(), "The greatest factorial calculator!");
    }

    @Test
    private void inputField() {
        Assert.assertTrue(mainPage.getInputField().isDisplayed(), "Page input is not displayed");
        Assert.assertTrue(mainPage.getInputField().isEnabled(), "Page input is not enabled");
        Assert.assertEquals(mainPage.getInputField().getAttribute("placeholder"), "Enter an integer");
    }

    @Test
    private void calculateButton() {
        Assert.assertTrue(mainPage.getCalculateButton().isDisplayed(), "Calculate button is not displayed");
        Assert.assertTrue(mainPage.getCalculateButton().isEnabled(), "Calculate button is not enabled");
    }
}
