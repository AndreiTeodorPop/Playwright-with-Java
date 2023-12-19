package org.example.tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.Hook;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class RegisterPageTest extends Hook {

    @Test
    public void registerDemo() {
        page.navigate("https://demo.automationtesting.in/Index.html");
        page.locator("//img[@id='enterimg']").click();
        assertThat(page).hasTitle("Register");
        page.locator("(//p[@class='fc-button-label'])[1]").getByText("Consent").click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/RegisterPage.png")).setFullPage(true));
        page.locator("//input[@ng-model='FirstName']").fill("Andrei");
        page.locator("//input[@ng-model='LastName']").fill("Pop");
        page.locator("//button[@id='Button1']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/RefreshButton.png")));
        page.click("//button[@id='Button1']");
        page.click("//a[contains(@href,'Index.html')]");
    }

}