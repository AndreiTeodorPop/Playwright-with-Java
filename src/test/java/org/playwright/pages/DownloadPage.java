package org.playwright.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import org.playwright.Constants;
import org.playwright.Helper;
import org.playwright.elements.WebTablePageElements;
import org.testng.Assert;

import java.nio.file.Paths;

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

    public void downloadFile() throws InterruptedException {
        Download download = page.waitForDownload(() -> {
            page.locator(WebTablePageElements.downloadButton).click();
        });
        download.saveAs(Paths.get(Constants.DOWNLOAD_LOCATION + "SampleFile.pdf"));
        Assert.assertTrue(helper.verifyDownloadedFile(Constants.SAMPLE_FILE_PDF, Constants.DOWNLOAD_LOCATION));
    }
}
