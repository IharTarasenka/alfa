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

    //    add hardcode for expectation
    @DataProvider
    public Object[] dataTypes() {
        return new Object[][]{
                {"1.1"},
                {"1,1"},
                {"1+1"},
                {"1e"},
                {"-1"},
        };
    }

    @Test(dataProvider = "dataTypes")
    private void inputDataTypeValidation(String num) {
        mainPage.getInputField().sendKeys(num);
        Assert.assertTrue(mainPage.clickCalculationButtonAndWaitResult(), "Calculation result is not displayed");
        incorrectInputErrorCheck(mainPage);
    }
}
