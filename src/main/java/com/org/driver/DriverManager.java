package com.org.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.util.concurrent.TimeUnit.SECONDS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriverContainer = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriverContainer.get() == null) {
            initDriver();
        }
        return webDriverContainer.get();
    }

    public static void quitDriver() {
        if (webDriverContainer.get() != null) {
            webDriverContainer.get().quit();
        }
    }

//    add configuration and add run for several browsers
    private static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1920,1200");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(4, SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(20, SECONDS);
        webDriverContainer.set(webDriver);
    }
}
