package com.demoblaze.pageobjects;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends PageObject {

    @FindBy(css = "#tbodyid a")
     WebElement addToCartBtn;


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() throws InterruptedException {
        addToCartBtn.click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

}
