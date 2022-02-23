package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends Base {


    @FindBy(css = "[src='imgs/Nexus_6.jpg']")
    WebElement product;

    @FindBy(css = "[onclick='addToCart(3)']")
    WebElement addToCart_btn;

    @FindBy(css = "#cartur")
    WebElement cart_headerLink;

    @FindBy(css = "[data-target='#orderModal']")
    WebElement placeOrder_btn;

    @FindBy(css = "#name")
    private WebElement name_textField;

    @FindBy(css = "#country")
    private WebElement country_textField;

    @FindBy(css = "#city")
    private WebElement city_textField;

    @FindBy(css = "#card")
    private WebElement creditCard_textField;

    @FindBy(css = "#month")
    private WebElement month_textField;

    @FindBy(css = "#year")
    private WebElement year_textField;

    @FindBy(css = "[onclick='purchaseOrder()']")
    private WebElement purchase_btn;

    @Test
    public void placeOrder() throws InterruptedException {
        PageFactory.initElements(driver, this);
        Thread.sleep(2000);
        addItemToCart();
        goToCart();
        placeOrder_btn.click();
        Thread.sleep(1000);
        fillOutFormAndSubmit("ilzat", "ET", "Ghulja", "123456", "12", "2000");
        Thread.sleep(1000);
        String actualText = driver.findElement(By.cssSelector(".sweet-alert h2")).getText();
        Assert.assertEquals(actualText, "Thank you for your purchase!");
    }

    public void goToCart() throws InterruptedException {
        cart_headerLink.click();
        Thread.sleep(1000);
    }

    public void addItemToCart() throws InterruptedException {
        product.click();
        Thread.sleep(1000);
        addToCart_btn.click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
    }


    private void fillOutFormAndSubmit(String name, String country, String city, String creditCard, String month, String year) {
        name_textField.sendKeys(name);
        country_textField.sendKeys(country);
        city_textField.sendKeys(city);
        creditCard_textField.sendKeys(creditCard);
        month_textField.sendKeys(month);
        year_textField.sendKeys(year);
        purchase_btn.click();

    }

}
