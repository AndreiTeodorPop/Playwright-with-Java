package org.playwright.tests;

import org.playwright.Hooks;
import org.playwright.pages.HomePage;
import org.playwright.pages.RegisterPage;
import org.playwright.pages.UploadPage;
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
