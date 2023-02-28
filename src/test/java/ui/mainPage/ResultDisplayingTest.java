package ui.mainPage;

import com.org.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.base.BaseTest;

import static utils.FactorialCalculation.factorialCalculation;

public class ResultDisplayingTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    private void init() {
        mainPage = new MainPage();
        mainPage.goToMainPage();
    }

//    add hardcode  for expectation
    @DataProvider
    public Object[] inputData() {
        return new Object[][]{
                {(int) (Math.random() * 8 + 1)},
                {(int) (Math.random() * 8 + 13)},
                {(int) (Math.random() * 51 + 250)},
                {(int) (Math.random() * 501 + 1500)},
        };
    }
    @Test(dataProvider = "inputData")
    private void resultDisplayingFormat(int value) {
        String calculatedValue = String.valueOf(factorialCalculation(value));
        mainPage.getInputField().sendKeys(String.valueOf(value));
        Assert.assertTrue(mainPage.clickCalculationButtonAndWaitResult(), "Calculation result is not displayed");
        String expected = String.format("The factorial of %d is: %s", value, calculatedValue);
        Assert.assertEquals(mainPage.getResultField().getText(), expected);
    }
}
