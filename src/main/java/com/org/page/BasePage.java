package com.org.page;

import com.org.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

//    use config files for URI
    protected static final String MAIN_PAGE_URL = "https://qainterview.pythonanywhere.com/";

    protected WebDriver webDriver;

    public BasePage() {
        this.webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    protected void goToUrl(String url) {
        webDriver.get(MAIN_PAGE_URL + url);
    }
}
