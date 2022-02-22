package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends Base {

    /**
     * Test case: Log out
     * Test steps:
     * 1) User is logged in
     * 2) Click the logout link on the header
     * 3) Verify that user is logged out successfully
     */

    @Test
    public void logout() throws InterruptedException {
        LoginTest loginTest = new LoginTest();
        Library lib = new Library(driver);

        lib.click(By.cssSelector("#login2"));
        Thread.sleep(1000);
        loginTest.login("geek", "geek");
        Thread.sleep(2000);

        String actualText = driver.findElement(By.cssSelector("#nameofuser")).getText();
        Assert.assertTrue(actualText.contains("geek"));

        lib.click(By.cssSelector("#logout2"));
        Thread.sleep(2000);

        String text = driver.findElement(By.cssSelector("#login2")).getText();
        Assert.assertEquals(text, "Log in");
    }

}
