package org.playwright.ui.tests;

import org.playwright.ui.helper.Hooks;
import org.playwright.ui.pages.HomePage;
import org.playwright.ui.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class RegisterPageTest extends Hooks {
    @Test
    public void registerDemo() {
        HomePage homepage = new HomePage(page);
        homepage.navigateToHomePage();
        homepage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(page);
//        registerPage.acceptCookies();
        registerPage.addUserInfo();
        registerPage.refreshPage();
        registerPage.makeScreenShotOfRefreshButton();
    }

}