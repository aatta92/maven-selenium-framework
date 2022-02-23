package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends Base {

    /**
     * Test case: Check out
     * Test steps:
     * 1) Go to app
     * 2) Add an item to cart
     * 3) Go to cart
     * 4) Click place order
     * 5) Fill out the purchase form
     * 6) Click purchase
     * 7) Verify that purchase is successful
     */

    @Test
    public void placeOrder() throws InterruptedException {
        Library lib = new Library(driver);
        Thread.sleep(2000);
        addItemToCart();
        goToCart();
        lib.click(By.cssSelector("[data-target='#orderModal']"));
        Thread.sleep(1000);
        fillOutFormAndSubmit("ilzat", "ET", "Ghulja", "123456", "12", "2000");
        Thread.sleep(1000);
        String actualText = driver.findElement(By.cssSelector(".sweet-alert h2")).getText();
        Assert.assertEquals(actualText, "Thank you for your purchase!");
    }

    public void goToCart() throws InterruptedException {
        Library lib = new Library(driver);
        lib.click(By.cssSelector("#cartur"));
        Thread.sleep(1000);
    }

    public void addItemToCart() throws InterruptedException {
        Library lib = new Library(driver);
        lib.click(By.cssSelector("[src='imgs/Nexus_6.jpg']"));
        Thread.sleep(1000);
        lib.click(By.cssSelector("[onclick='addToCart(3)']"));
        Thread.sleep(500);
        driver.switchTo().alert().accept();
    }


    private void fillOutFormAndSubmit(String name, String country, String city, String creditCard, String month, String year) {
        Library lib = new Library(driver);
        lib.enterText(By.cssSelector("#name"), name);
        lib.enterText(By.cssSelector("#country"), country);
        lib.enterText(By.cssSelector("#city"), city);
        lib.enterText(By.cssSelector("#card"), creditCard);
        lib.enterText(By.cssSelector("#month"), month);
        lib.enterText(By.cssSelector("#year"), year);
        lib.click(By.cssSelector("[onclick='purchaseOrder()']"));
    }

}
