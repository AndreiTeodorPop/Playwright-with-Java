package org.playwright.ui.tests;

import org.playwright.ui.helper.Hooks;
import org.playwright.ui.pages.DownloadPage;
import org.playwright.ui.pages.HomePage;
import org.playwright.ui.pages.RegisterPage;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class DownloadPageTest extends Hooks {

    @Test
    public void downloadFileDemo() throws IOException {
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
