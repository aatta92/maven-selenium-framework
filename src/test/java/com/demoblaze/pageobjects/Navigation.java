package com.demoblaze.pageobjects;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends PageObject {

    @FindBy(css = "#login2")
    public WebElement login_link;

    @FindBy(css = "#logout2")
    public WebElement logOut_link;

    @FindBy(css = "#nameofuser")
    public WebElement nameOfUser_link;

    @FindBy(css = "#cartur")
    public WebElement cart_link;

    public Navigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginModal() throws InterruptedException {
        login_link.click();
        Thread.sleep(1000);
    }

    public void goToShoppingCartPage() throws InterruptedException {
        cart_link.click();
        Thread.sleep(1000);
    }

}
