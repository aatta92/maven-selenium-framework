package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.utils.Library;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends Base {

    /**
     * Test case: Submitting empty contact form
     * Test steps:
     * 1) Go to app
     * 2) Click on Contact link on the header
     * 3) Ensure all fields are empty
     * 4) Click on Send Message button
     * 5) Verify that the empty form cannot be submitted
     */

    @Test
    public void submittingEmptyContactForm() throws InterruptedException {
        Library lib = new Library(driver);

        lib.click(By.cssSelector("[data-target='#exampleModal']"));

        Thread.sleep(1000);
        // clearing the text fields
        driver.findElement(By.cssSelector("#recipient-email")).clear();
        driver.findElement(By.cssSelector("#recipient-name")).clear();
        driver.findElement(By.cssSelector("#message-text")).clear();


        lib.click(By.cssSelector("[onclick='send()']"));

        Thread.sleep(1000);

        String actualText = driver.switchTo().alert().getText();
        System.out.println(actualText);

        String expectedText = "Form can't be empty";

        // TestNG assertion
        Assert.assertEquals(actualText, expectedText);

    }

    /**
     * Test case: Submit form with data
     * Test steps:
     * 1) Go to app
     * 2) Click on Contact link on the header
     * 3) Fill up the form
     * 4) Click on Send Message button
     * 5) Verify that the form is sent successfully
     */


}
