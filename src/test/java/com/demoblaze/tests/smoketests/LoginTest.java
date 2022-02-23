package com.demoblaze.tests.smoketests;

import com.demoblaze.base.Base;
import com.demoblaze.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends Base {

    private HomePage homePage;

    @Test
    public void loginWithValidAccount() throws InterruptedException {
        homePage = new HomePage();
        homePage.login("geek", "geek");
        boolean result = homePage.isLoggedIn();
        Assert.assertTrue(result);
    }

}
