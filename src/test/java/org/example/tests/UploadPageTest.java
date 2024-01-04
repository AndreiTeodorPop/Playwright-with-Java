package org.example.tests;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.Hook;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 1/4/2024, Thursday
 **/
public class UploadPageTest extends Hook {

    @Test
    public void uploadFileDemo() {
        page.navigate("https://demo.automationtesting.in/Index.html");
        page.locator("//img[@id='enterimg']").click();
        page.locator("(//p[@class='fc-button-label'])[1]").getByText("Consent").click();
        Locator moreList = page.locator("//a[@class='dropdown-toggle']").getByText("More");
        moreList.click();
        Locator fileUpload = page.locator("ul.dropdown-menu li", new Page.LocatorOptions().setHasText("File Upload"));
        fileUpload.click();
        assertThat(page).hasTitle("File input - Multi select");
        page.setInputFiles("//input[@id='input-4']", Paths.get("src/main/resources/SamplePicture.jpg"));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/UploadPage.png")).setFullPage(true));
        page.click("//a[contains(@href,'Index.html')]");
    }
}
