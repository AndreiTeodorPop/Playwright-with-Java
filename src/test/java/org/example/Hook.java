package org.example;

import com.microsoft.playwright.*;
import org.example.pages.HomePage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.tests.Helper.deleteDirectory;
import static org.example.tests.Helper.makeVideoOfTest;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class Hook {

    protected Browser browser;
    protected BrowserContext browserContext;
    protected static Page page;
    protected Playwright playwright;
    Path videoDirectory = Paths.get("target/demo-videos/");

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        playwright = Playwright.create();
        BrowserType browserType;
        switch (browserName) {
            case "Chrome":
                browserType = playwright.chromium();
                break;
            case "FireFox":
                browserType = playwright.firefox();
                break;
            case "WebKit":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Provide a valid browser name");
        }

        browser = browserType.launch(new BrowserType
                .LaunchOptions().setHeadless(false));
        deleteDirectory(videoDirectory.toFile());
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(videoDirectory)
                .setRecordVideoSize(1280, 720)
                .setViewportSize(width, height));
        page = browserContext.newPage();
        HomePage homePage = new HomePage(page);
        homePage.navigateToHomePage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        browser.close();
        page.close();
        playwright.close();
        makeVideoOfTest(result);
    }
}
