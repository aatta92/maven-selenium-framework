package com.demoblaze.pageobjects;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PageObject {

    @FindBy(css = "[data-target='#orderModal']")
    WebElement placeOrderBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnPlaceOrder() throws InterruptedException {
        placeOrderBtn.click();
        Thread.sleep(1000);
    }

}
