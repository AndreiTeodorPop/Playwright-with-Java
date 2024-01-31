package org.playwright.ui.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import org.playwright.ui.helper.Constants;
import org.playwright.ui.helper.Helper;
import org.playwright.ui.elements.WebTablePageElements;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class DownloadPage extends AbstractPage {
    Helper helper = new Helper(page);

    public DownloadPage(Page page) {
        super(page);
    }

    public void clearDownloadFolder() {
        helper.deleteDirectory(Constants.PATH_DOWNLOAD_LOCATION.toFile());
    }

    public void downloadFile() {
        page.locator(WebTablePageElements.textBox).pressSequentially("This is my generated file");
        page.locator(WebTablePageElements.createFileButton).click();
        Download download = page.waitForDownload(() -> {
            page.locator(WebTablePageElements.downloadFile).click();
        });
        download.saveAs(Paths.get(Constants.DOWNLOAD_LOCATION + "info.txt"));
    }

    public void verifyDownloadFile() throws IOException {
        Assert.assertTrue(Helper.verifyDownloadedFile(Constants.INFO_TXT, Constants.DOWNLOAD_LOCATION));
        System.out.println("File " + Constants.INFO_TXT + " downloaded successfully");
    }
}
