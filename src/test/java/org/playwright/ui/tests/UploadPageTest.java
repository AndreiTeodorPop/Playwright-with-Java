package org.playwright.ui.tests;

import org.playwright.ui.helper.Hooks;
import org.playwright.ui.pages.HomePage;
import org.playwright.ui.pages.RegisterPage;
import org.playwright.ui.pages.UploadPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/4/2024, Thursday
 **/
public class UploadPageTest extends Hooks {

    @Test
    public void uploadFileDemo() {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        UploadPage uploadPage = new UploadPage(page);
        homepage.navigateToHomePage();
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToUploadPage();
        uploadPage.makeScreenShotOfUploadButton();
        uploadPage.uploadFile();
    }
}
