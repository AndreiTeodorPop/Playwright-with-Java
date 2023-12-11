package org.example;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ParallelTest extends Thread {

    Browser browser;
    String browserName;
    BrowserContext browserContext;
    Page page;

    public ParallelTest(String browserName) {
        this.browserName = browserName;
    }

    public void run() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println("Thread running...");
        Playwright playwright = Playwright.create();
        browser = getBrowser(playwright, browserName).launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(1280, 720)
                .setViewportSize(width, height));
        page = browserContext.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
//        page.navigate("https://demoqa.com");
        assertThat(page).hasTitle("Register");
        page.locator("(//p[@class='fc-button-label'])[1]").getByText("Consent").click();
        page.locator("//input[@ng-model='FirstName']").fill("Andrei");
        page.locator("//input[@ng-model='LastName']").fill("Pop");
        page.click("//button[@id='Button1']");
        page.click("//a[contains(@href,'Index.html')]");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.close();
        browser.close();
        playwright.close();
    }

    public static void main(String[] args) {
        Thread thread1 = new ParallelTest("Chrome");
        Thread thread2 = new ParallelTest("Firefox");
        Thread thread3 = new ParallelTest("Edge");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static BrowserType getBrowser(Playwright playwright, String browserName) {
        BrowserType browserType;
        switch (browserName) {
            case "Chrome":
                browserType = playwright.chromium();
                break;
            case "Firefox":
                browserType = playwright.firefox();
                break;
            case "Edge":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Provide a valid browser name");
        }
        return browserType;
    }

}
