package com.demoblaze.modals;

import com.demoblaze.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactModal extends PageObject {

    @FindBy(id = "recipient-email")
    WebElement email_textField;

    @FindBy(id = "recipient-name")
    WebElement name_textField;

    @FindBy(id = "message-text")
    WebElement message_textField;

    @FindBy(css = "[onclick='send()']")
    WebElement sendMessage_button;

    public ContactModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillOutForm(String email, String name, String message) {
        email_textField.sendKeys(email);
        name_textField.sendKeys(name);
        message_textField.sendKeys(message);
    }

    public void clickSendMessageButton() throws InterruptedException {
        sendMessage_button.click();
        Thread.sleep(1000);
    }


}
