package com.demoblaze.modals;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PlaceOrderModal extends PageObject {

    @FindBy(css = "#name")
    WebElement nameTextField;

    @FindBy(css = "#country")
    WebElement countryTextField;

    @FindBy(css = "#city")
    WebElement cityTextField;

    @FindBy(css = "#card")
    WebElement cardTextField;

    @FindBy(css = "#month")
    WebElement monthTextField;

    @FindBy(css = "#year")
    WebElement yearTextField;

    @FindBy(css = "[onclick='purchaseOrder()']")
    WebElement purchaseBtn;

    public PlaceOrderModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillOutPlaceOrderFormThenPurchase(HashMap<String, String> data) throws InterruptedException {
        nameTextField.sendKeys(data.get("name"));
        countryTextField.sendKeys(data.get("country"));
        cityTextField.sendKeys(data.get("city"));
        cardTextField.sendKeys(data.get("card"));
        monthTextField.sendKeys(data.get("month"));
        yearTextField.sendKeys(data.get("year"));
        purchaseBtn.click();
        Thread.sleep(1000);
    }

}
