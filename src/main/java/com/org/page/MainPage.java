package com.org.page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement header;

    @FindBy(css = "#number")
    private WebElement inputField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement calculateButton;

    @FindBy(id = "resultDiv")
    private WebElement resultField;


    public void goToMainPage() {
        goToUrl("");
    }

    public String getHeaderText () {
        return header.getText();
    }

    public boolean clickCalculationButtonAndWaitResult() {
        calculateButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        try {
            wait.until(ExpectedConditions.attributeToBeNotEmpty(resultField, "innerText"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
