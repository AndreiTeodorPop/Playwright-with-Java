package org.playwright.pages;

import com.microsoft.playwright.Page;
import org.playwright.Hook;

import java.nio.file.Paths;

import static org.playwright.Helper.makeScreenShotOfButton;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class UploadPage extends Hook {

    private static final String uploadButton = "//input[@id='input-4']";
    private static final String uploadButtonScreenShot = "//div[@class='btn btn-primary btn-file']";
    private static final String uploadFilePath = "src/main/resources/SamplePicture.jpg";

    public UploadPage(Page page) {
        this.page = page;
    }

    public void uploadFile() {
        page.setInputFiles(uploadButton, Paths.get(uploadFilePath));
    }

    public void makeScreenShotOfUploadButton() {
        makeScreenShotOfButton(uploadButtonScreenShot, "UploadButton");
    }
}
