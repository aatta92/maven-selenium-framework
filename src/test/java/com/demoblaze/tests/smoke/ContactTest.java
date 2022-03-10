package com.demoblaze.tests.smoke;

import com.demoblaze.base.BaseClass;
import com.demoblaze.modals.ContactModal;
import com.demoblaze.pageobjects.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseClass {

    /**
     * Test case: contact form
     * Test step:
     * 1) user is on home page
     * 2) click on contact header link
     * 3) fill out contact form with valid data
     * 4) click send message button
     * 5) verify form is submitted
     */

    Navigation navigation = new Navigation(driver);
    ContactModal contactModal = new ContactModal(driver);

    @Test
    public void submitContactForm() throws InterruptedException {
        navigation.clickContactHeaderLink();
        contactModal.fillOutForm("hello@gmail.com", "ilzat", "hello everyone");
        contactModal.clickSendMessageButton();
        String successMsg = contactModal.switchToAlert().getText();
        Assert.assertTrue(successMsg.contains("Thanks"));
    }


}
