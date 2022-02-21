package com.demoblaze.tests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    Library lib = new Library(driver);

    @Test
    public void loginWithValidAccount_Test() throws InterruptedException {
        lib.click(By.cssSelector("#login2"));
        Thread.sleep(1000);
        login("geek", "geek");
    }

    @Test
    public void loginWithInvalidAccount_Test() throws InterruptedException {
        lib.click(By.cssSelector("#login2"));
        Thread.sleep(1000);
        login("hsgdhgfhgdsf", "dhsfhdsgfd");
    }

    private void login(String username, String password) {
        lib.enterText(By.cssSelector("#loginusername"), username);
        lib.enterText(By.cssSelector("#loginpassword"), password);
        lib.click(By.cssSelector("[onclick='logIn()']"));
    }
}