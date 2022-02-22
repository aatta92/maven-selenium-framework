package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LoginTest extends Base {


    @Test
    public void loginWithValidAccount_Test() {
        Library lib = new Library(driver);
        lib.click(By.cssSelector("#login2"));
        login("geek", "geek");
    }

    @Test
    public void loginWithInvalidAccount_Test() throws InterruptedException {
        Library lib = new Library(driver);
        lib.click(By.cssSelector("#login2"));
        Thread.sleep(1000);
        login("hsgdhgfhgdsf", "dhsfhdsgfd");
    }

    private void login(String username, String password) {
        Library lib = new Library(driver);
        lib.enterText(By.cssSelector("#loginusername"), username);
        lib.enterText(By.cssSelector("#loginpassword"), password);
        lib.click(By.cssSelector("[onclick='logIn()']"));
    }
}
