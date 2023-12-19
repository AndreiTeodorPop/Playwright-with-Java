package org.example;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightWithJavaTest {

    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    private Playwright playwright;

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
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("target/demo-videos/"))
                .setRecordVideoSize(1280, 720)
                .setViewportSize(width, height));
        page = browserContext.newPage();
    }


    @Test
    public void registerDemo() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/Register.html");
        assertThat(page).hasTitle("Register");
        page.locator("(//p[@class='fc-button-label'])[1]").getByText("Consent").click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/RegisterPage.png")).setFullPage(true));
        page.locator("//input[@ng-model='FirstName']").fill("Andrei");
        page.locator("//input[@ng-model='LastName']").fill("Pop");
        page.locator("//button[@id='Button1']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/RefreshButton.png")));
        page.click("//button[@id='Button1']");
        page.click("//a[contains(@href,'Index.html')]");
//        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == 1) {
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/IndexPage.png")));
        }
        String pathProject = System.getProperty("user.dir");
        String testName = result.getMethod().getMethodName();
        System.out.println(testName);
        Path videoName = page.video().path().getFileName();
        System.out.println(videoName);
        browser.close();
        page.close();
        playwright.close();
        File file1 = new File(pathProject + File.separator + "target/demo-videos" + File.separator + videoName);
        File file2 = new File(pathProject + File.separator + "target/demo-videos" + File.separator + testName + ".webm");
        boolean status = file1.renameTo(file2);
        System.out.println(status);
    }
}