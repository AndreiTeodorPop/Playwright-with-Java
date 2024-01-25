package org.playwright.tests;

import org.playwright.Hooks;
import org.playwright.pages.HomePage;
import org.playwright.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class RegisterPageTest extends Hooks {
    @Test
    public void registerDemo() {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        homepage.navigateToHomePage();
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.addUserInfo();
        registerPage.refreshPageAndScreenShot();
    }

}