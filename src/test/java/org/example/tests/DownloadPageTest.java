package org.example.tests;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.Hook;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class DownloadPageTest extends Hook {

    @Test
    public void downloadFileDemo() {
        Locator moreList = page.locator("//a[@class='dropdown-toggle']").getByText("More");
        moreList.click();
        Locator fileDownload = page.locator("ul.dropdown-menu li", new Page.LocatorOptions().setHasText("File Download"));
        fileDownload.click();
        assertThat(page).hasTitle("File input - Multi select");
        Download download = page.waitForDownload(() -> {
            page.locator("//a[@class='btn btn-primary']").click();
        });
        System.out.println(download.path());
        String path = System.getProperty("user.dir");
        download.saveAs(Paths.get(path + File.separator + "src/main/resources/" + "SampleFile.pdf"));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/demo-screenshots/DownloadPage.png")).setFullPage(true));
        page.click("//a[contains(@href,'Index.html')]");
    }

}
