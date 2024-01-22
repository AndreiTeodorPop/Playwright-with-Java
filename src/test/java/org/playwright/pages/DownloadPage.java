package org.playwright.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import org.playwright.Hook;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

import static org.playwright.Helper.verifyDownloadedFile;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class DownloadPage extends Hook {

    private final String expectedFileName = "SampleFile.pdf";
    private final String location = System.getProperty("user.dir") + File.separator + "src/main/resources/";
    private static final String downloadButton = "//a[@class='btn btn-primary']";


    public DownloadPage(Page page) {
        this.page = page;
    }

    public void downloadFile() throws InterruptedException {
        Download download = page.waitForDownload(() -> {
            page.locator(downloadButton).click();
        });
        download.saveAs(Paths.get(location + "SampleFile.pdf"));
        Assert.assertTrue(verifyDownloadedFile(expectedFileName, location));
    }
}
