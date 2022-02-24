package com.demoblaze.pageobjects;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends PageObject {

    @FindBy(css = "#tbodyid img")
    List<WebElement> productsCard;

    Navigation navigation;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        navigation = new Navigation(driver);
    }

    public void logOut() throws InterruptedException {
        navigation.logOut_link.click();
        Thread.sleep(1000);
    }

    public boolean isLoggedIn() {
        return navigation.nameOfUser_link.getText().contains("Welcome");
    }

    public void chooseProductByIndex(int i) throws InterruptedException {
        productsCard.get(i).click();
        Thread.sleep(1000);
    }
}
