package ui.mainPage;

import com.org.page.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;

import static ui.utils.MainPageChecker.incorrectInputErrorCheck;

public class ErrorDisplayingTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    private void init() {
        mainPage = new MainPage();
        mainPage.goToMainPage();
    }

    @Test
    private void errorDisplaying() {
        mainPage.getInputField().sendKeys("test");
        mainPage.getCalculateButton().click();
        incorrectInputErrorCheck(mainPage);
    }
}
