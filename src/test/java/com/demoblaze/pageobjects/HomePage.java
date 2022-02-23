package com.demoblaze.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoblaze.base.Base.driver;

public class HomePage {

    @FindBy(css = "#login2")
    WebElement login_headerLink;

    @FindBy(css = "#loginusername")
    WebElement username_textField;

    @FindBy(css = "#loginpassword")
    WebElement password_textField;

    @FindBy(css = "[onclick='logIn()']")
    WebElement login_btn;

    @FindBy(css = "#nameofuser")
    WebElement nameOfUser_headerLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password) throws InterruptedException {
        login_headerLink.click();
        Thread.sleep(1000);
        username_textField.sendKeys(username);
        password_textField.sendKeys(password);
        login_btn.click();
        Thread.sleep(1000);
        return this;
    }

    public boolean isLoggedIn() {
        return nameOfUser_headerLink.getText().contains("Welcome");
    }


}
