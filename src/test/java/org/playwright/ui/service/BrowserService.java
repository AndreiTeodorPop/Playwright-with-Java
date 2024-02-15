package org.playwright.ui.service;

import com.microsoft.playwright.*;
import org.playwright.ui.helper.Helper;

import java.awt.*;

import static org.playwright.ui.helper.Constants.DEMO_VIDEOS_SAVE_LOCATION;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
public class BrowserService {
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected Playwright playwright;


    public void initPlaywright(String browserName) {
        Helper helper = new Helper(page);
        helper.deleteDirectory(DEMO_VIDEOS_SAVE_LOCATION.toFile());
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
                .LaunchOptions().setHeadless(true));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(DEMO_VIDEOS_SAVE_LOCATION)
                .setRecordVideoSize(1280, 720)
                .setViewportSize(width, height));
        page = browserContext.newPage();
    }

    public void closeBrowser() {
        browser.close();
        page.close();
    }

    public void closePlaywright() {
        playwright.close();
    }

}
