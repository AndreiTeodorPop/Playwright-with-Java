package org.playwright.tests;

import org.playwright.Hooks;
import org.playwright.pages.DownloadPage;
import org.playwright.pages.HomePage;
import org.playwright.pages.RegisterPage;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class DownloadPageTest extends Hooks {

    @Test
    public void downloadFileDemo() throws InterruptedException, IOException {
        HomePage homepage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        DownloadPage downloadPage = new DownloadPage(page);
        homepage.navigateToHomePage();
        homepage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToDownloadPage();
        downloadPage.clearDownloadFolder();
        downloadPage.downloadFile();
        downloadPage.verifyDownloadFile();
    }

}
