package com.demoblaze.base;

import org.openqa.selenium.WebDriver;

public class PageObject {

    protected WebDriver driver;

    protected PageObject(WebDriver driver) {
        this.driver = driver;
    }

}
