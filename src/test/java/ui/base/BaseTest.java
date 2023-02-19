package ui.base;

import org.testng.annotations.AfterClass;
import com.org.driver.DriverManager;

public class BaseTest {

    @AfterClass
    protected void quitDriver() {
        DriverManager.quitDriver();
    }
}
