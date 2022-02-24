package com.demoblaze.tests.smoke;

import com.demoblaze.base.BaseClass;
import com.demoblaze.modals.PlaceOrderModal;
import com.demoblaze.pageobjects.CartPage;
import com.demoblaze.pageobjects.HomePage;
import com.demoblaze.pageobjects.Navigation;
import com.demoblaze.pageobjects.ProductsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PlaceOrderTest extends BaseClass {

    HomePage homePage;
    ProductsPage productsPage;
    Navigation navigation;
    CartPage cartPage;
    PlaceOrderModal placeOrderModal;

    public PlaceOrderTest() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        navigation = new Navigation(driver);
        cartPage = new CartPage(driver);
        placeOrderModal = new PlaceOrderModal(driver);
    }

    @Test
    public void placeOrder() throws InterruptedException {
        homePage.chooseProductByIndex(2);
        productsPage.addItemToCart();
        navigation.goToShoppingCartPage();
        cartPage.clickOnPlaceOrder();
        placeOrderModal.fillOutPlaceOrderFormThenPurchase(getData());
        String successMessage = driver.findElement(By.cssSelector(".sweet-alert h2")).getText();
        Assert.assertTrue(successMessage.contains("Thank you"));
    }

    private HashMap<String, String> getData() {
        HashMap<String, String> formData = new HashMap<>();
        formData.put("name", "ilzat");
        formData.put("country", "US");
        formData.put("city", "Fairfax");
        formData.put("card", "8377324234234");
        formData.put("month", "Feb");
        formData.put("year", "2024");
        return formData;
    }


}
