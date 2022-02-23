package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends Base {

    @FindBy(css = "#login2")
    WebElement login_headerLink;

    @FindBy(css = "#nameofuser")
    WebElement nameOfUser_headerLink;

    @FindBy(css = "#logout2")
    WebElement logOut_headerLink;

    @Test
    public void logout() throws InterruptedException {
        PageFactory.initElements(driver, this);
        LoginTest loginTest = new LoginTest();
        login_headerLink.click();
        Thread.sleep(1000);
        loginTest.login("geek", "geek");
        Thread.sleep(2000);
        String actualText = nameOfUser_headerLink.getText();
        Assert.assertTrue(actualText.contains("geek"));
        logOut_headerLink.click();
        Thread.sleep(2000);
        String text = login_headerLink.getText();
        Assert.assertEquals(text, "Log in");
    }

}
