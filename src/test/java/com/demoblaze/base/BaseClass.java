package com.demoblaze.base;

import com.demoblaze.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {

    public static WebDriver driver;

    public BaseClass() {
        driver = DriverFactory.openBrowser("chrome");
    }

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.demoblaze.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
