package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.Hook;

import java.nio.file.Paths;

import static org.example.tests.Helper.makeScreenShotOfButton;

public class UploadPage extends Hook {

    String uploadButton = "//input[@id='input-4']";

    String uploadButtonScreenShot = "//div[@class='btn btn-primary btn-file']";
    String uploadFilePath = "src/main/resources/SamplePicture.jpg";

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
