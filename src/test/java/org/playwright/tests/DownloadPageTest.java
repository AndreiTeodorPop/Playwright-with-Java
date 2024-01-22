package org.playwright.tests;

import org.playwright.Hook;
import org.playwright.pages.DownloadPage;
import org.playwright.pages.HomePage;
import org.playwright.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class DownloadPageTest extends Hook {

    @Test
    public void downloadFileDemo() throws InterruptedException {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        DownloadPage downloadPage = new DownloadPage(page);
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToDownloadPage();
        downloadPage.downloadFile();
    }

}
