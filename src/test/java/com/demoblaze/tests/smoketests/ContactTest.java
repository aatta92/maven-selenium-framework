package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends Base {

    @FindBy(css = "[data-target='#exampleModal']")
    WebElement contact_headerLink;


    @Test
    public void submittingEmptyContactForm() throws InterruptedException {
        PageFactory.initElements(driver, this);

        contact_headerLink.click();

        Thread.sleep(1000);
        // clearing the text fields
        driver.findElement(By.cssSelector("#recipient-email")).clear();
        driver.findElement(By.cssSelector("#recipient-name")).clear();
        driver.findElement(By.cssSelector("#message-text")).clear();


        Thread.sleep(1000);

        String actualText = driver.switchTo().alert().getText();
        System.out.println(actualText);

        String expectedText = "Form can't be empty";

        // TestNG assertion
        Assert.assertEquals(actualText, expectedText);

    }


}
