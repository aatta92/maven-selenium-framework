package com.demoblaze.tests.smoke;

import com.demoblaze.base.BaseClass;
import com.demoblaze.modals.LoginModal;
import com.demoblaze.pageobjects.HomePage;
import com.demoblaze.pageobjects.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    private HomePage homePage;
    private LoginModal loginModal;
    private Navigation navigation;

    public LoginTest() {
        homePage = new HomePage(driver);
        loginModal = new LoginModal(driver);
        navigation = new Navigation(driver);
    }

    @Test
    public void loginWithValidAccount() throws InterruptedException {
        navigation.openLoginModal(); // this is clicking the login header link
        loginModal.enterUsernameAndPassword("geek", "geek");
        boolean result = homePage.isLoggedIn(); // returns boolean
        Assert.assertTrue(result);
    }

    @Test
    public void loginWithInvalidAccount() throws InterruptedException {
        navigation.openLoginModal();
        loginModal.enterUsernameAndPassword("sjdfjdsjfds", "kdfkdkfd");
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("does not exist"));
    }

}
