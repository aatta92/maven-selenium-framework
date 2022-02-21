package com.demoblaze.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Library {

    private WebDriver driver;

    public Library(WebDriver theDriver) {
        driver = theDriver;
    }

    public void enterText(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

}
