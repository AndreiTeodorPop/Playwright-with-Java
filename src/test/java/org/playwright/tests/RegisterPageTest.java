package org.playwright.tests;

import org.playwright.Hook;
import org.playwright.pages.HomePage;
import org.playwright.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class RegisterPageTest extends Hook {

    @Test
    public void registerDemo() {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.addUserCredentials();
        registerPage.refreshPageAndScreenShot();
    }

}