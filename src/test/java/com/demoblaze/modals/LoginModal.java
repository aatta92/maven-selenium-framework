package com.demoblaze.modals;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModal extends PageObject {

    @FindBy(css = "#loginusername")
    WebElement username_textField;

    @FindBy(css = "#loginpassword")
    WebElement password_textField;

    @FindBy(css = "[onclick='logIn()']")
    WebElement login_btn;

    public LoginModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        username_textField.sendKeys(username);
        password_textField.sendKeys(password);
        login_btn.click();
        Thread.sleep(1000);
    }

}
