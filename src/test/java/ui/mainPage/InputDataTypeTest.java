package ui.mainPage;

import com.org.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.base.BaseTest;

import static ui.utils.MainPageChecker.incorrectInputErrorCheck;

public class InputDataTypeTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    private void init() {
        mainPage = new MainPage();
        mainPage.goToMainPage();
    }

    @DataProvider
    public Object[] dataTypes() {
        return new Object[][]{
                {"Not int values with dot", "1.1"},
                {"Not int values with coma", "1,1"},
                {"Not int values with arithmetic sign", "1+1"},
                {"Not int values with alphabet sign", "1e"},
                {"Negative values with minus", "-1"},
        };
    }

    @Test(dataProvider = "dataTypes")
    private void inputDataTypeValidation(String description, String num) {
        mainPage.getInputField().sendKeys(num);
        Assert.assertTrue(mainPage.clickCalculationButtonAndWaitResult(), "Calculation result is not displayed");
        incorrectInputErrorCheck(mainPage);
    }
}
