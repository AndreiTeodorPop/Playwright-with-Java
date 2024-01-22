package org.example.tests;

import org.example.Hook;
import org.example.pages.HomePage;
import org.example.pages.RegisterPage;
import org.example.pages.UploadPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/4/2024, Thursday
 **/
public class UploadPageTest extends Hook {

    @Test
    public void uploadFileDemo() {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        UploadPage uploadPage = new UploadPage(page);
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToUploadPage();
        uploadPage.makeScreenShotOfUploadButton();
        uploadPage.uploadFile();
    }
}
