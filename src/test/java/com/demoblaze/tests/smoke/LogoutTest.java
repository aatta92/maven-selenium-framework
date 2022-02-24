package com.demoblaze.tests.smoke;

import com.demoblaze.base.BaseClass;
import com.demoblaze.modals.LoginModal;
import com.demoblaze.pageobjects.HomePage;
import com.demoblaze.pageobjects.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseClass {

    private HomePage homePage;
    private LoginModal loginModal;
    private Navigation navigation;


    public LogoutTest() {
        homePage = new HomePage(driver);
        loginModal = new LoginModal(driver);
        navigation = new Navigation(driver);
    }

    @Test
    public void logOut() throws InterruptedException {
        navigation.openLoginModal();
        loginModal.enterUsernameAndPassword("geek", "geek");
        homePage.logOut();
        boolean result = homePage.isLoggedIn();
        Assert.assertFalse(result);
    }
}
