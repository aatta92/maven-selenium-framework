package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginTest extends Base {

    @FindBy(css = "#login2")
    WebElement headerLink;

    @FindBy(css = "#loginusername")
    WebElement username_textField;

    @FindBy(css = "#loginpassword")
    WebElement password_textField;

    @FindBy(css = "[onclick='logIn()']")
    WebElement login_btn;

    @Test
    public void loginWithValidAccount_Test() throws InterruptedException {
        PageFactory.initElements(driver,this);
        headerLink.click();
        Thread.sleep(1000);
        login("geek", "geek");
    }

    @Test
    public void loginWithInvalidAccount_Test() throws InterruptedException {
        PageFactory.initElements(driver, this);
        headerLink.click();
        Thread.sleep(1000);
        login("hsgdhgfhgdsf", "dhsfhdsgfd");
    }

    public void login(String username, String password) {
        PageFactory.initElements(driver, this);
        username_textField.sendKeys(username);
        password_textField.sendKeys(password);
        login_btn.click();
    }
}
