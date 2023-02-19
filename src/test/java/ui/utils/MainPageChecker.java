package ui.utils;

import com.org.page.MainPage;
import org.testng.Assert;

public class MainPageChecker {

    public static void incorrectInputErrorCheck(MainPage mainPage){
        Assert.assertEquals(mainPage.getInputField().getAttribute("style"), "border: 2px solid red;");
        Assert.assertEquals(mainPage.getResultField().getText(), "Please enter an integer");
        Assert.assertEquals(mainPage.getResultField().getAttribute("style"), "color: rgb(255, 0, 0);");
    }
}
