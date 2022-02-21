package com.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Student {

    WebDriver driver;



    @Test
    public void testMe() {
        driver.findElement(By.cssSelector("#login2")).click();
    }


}
