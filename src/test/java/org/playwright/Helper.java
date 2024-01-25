package org.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.playwright.pages.BasePage;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class Helper extends BasePage {

    public Helper(Page page) {
        super(page);
    }


    public boolean verifyDownloadedFile(String expectedFileName, String location) throws InterruptedException {
        Thread.sleep(10000);
        File folder = new File(location);
        File[] fileList = folder.listFiles();
        boolean isFilePresent = false;
        assert fileList != null;
        for (File file : fileList) {
            if (file.isFile()) {
                String fileName = file.getName();
                System.out.println(fileName);
                if (fileName.matches(expectedFileName)) {
                    isFilePresent = true;
                }
            }
        }
        return isFilePresent;
    }

    public void takeScreenShotOfPage(String pageName) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Constants.PAGE_SCREENSHOT_FOLDER + pageName + ".png")).setFullPage(true));
    }

    public void takeScreenShotOfButton(String locator, String buttonName) {
        page.locator(locator).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(Constants.ELEMENT_SCREENSHOT_FOLDER + buttonName + ".png")));
    }

    public boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContent = directoryToBeDeleted.listFiles();
        if (allContent != null) {
            for (File file : allContent) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
