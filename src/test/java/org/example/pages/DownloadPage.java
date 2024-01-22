package org.example.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import org.example.Hook;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

import static org.example.tests.Helper.verifyDownloadedFile;

public class DownloadPage extends Hook {

    final String expectedFileName = "SampleFile.pdf";
    final String location = System.getProperty("user.dir") + File.separator + "src/main/resources/";

    String downloadButton = "//a[@class='btn btn-primary']";


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
