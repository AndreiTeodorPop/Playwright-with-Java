package org.playwright.pages;

import com.microsoft.playwright.Page;
import org.playwright.Constants;
import org.playwright.Helper;
import org.playwright.elements.WebTablePageElements;

import java.nio.file.Paths;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class UploadPage extends AbstractPage {

    Helper helper = new Helper(page);

    public UploadPage(Page page) {
        super(page);
    }


    public void uploadFile() {
        page.setInputFiles(WebTablePageElements.uploadButton, Paths.get(Constants.UPLOAD_FILE));
    }

    public void makeScreenShotOfUploadButton() {
        helper.takeScreenShotOfButton(WebTablePageElements.uploadButtonScreenShot, "UploadButton");
    }
}
