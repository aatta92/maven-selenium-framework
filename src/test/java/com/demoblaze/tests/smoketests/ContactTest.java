package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends Base {

    @FindBy(css = "[data-target='#exampleModal']")
    WebElement contact_headerLink;

    @FindBy(css = "#recipient-email")
    WebElement recipientEmail_textField;

    @FindBy(css = "#recipient-name")
    WebElement recipientName_textField;

    @FindBy(css = "#message-text")
    WebElement message_textField;

    @FindBy(css = "[onclick='send()']")
    WebElement sendMessage_btn;


    @Test
    public void submittingEmptyContactForm() throws InterruptedException {
        PageFactory.initElements(driver, this);
        contact_headerLink.click();
        Thread.sleep(1000);
        recipientEmail_textField.clear();
        recipientName_textField.clear();
        message_textField.clear();
        sendMessage_btn.click();
        Thread.sleep(1000);
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "Form can't be empty";
        Assert.assertEquals(actualText, expectedText);
    }


}
