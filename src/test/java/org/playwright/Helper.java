package org.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class Helper extends Hook {

    private static final String buttonScreenshotFolder = "target/demo-screenshots/buttons/";
    private static final String pageScreenshotFolder = "target/demo-screenshots/pages/";
    private static final String demoVideoFolder = "target/demo-videos";
    private static final String pathProject = System.getProperty("user.dir");


    public static boolean verifyDownloadedFile(String expectedFileName, String location) throws InterruptedException {
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

    public static void takeScreenShotOfPage(String pageName) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(pageScreenshotFolder + pageName + ".png")).setFullPage(true));
    }

    public static void takeScreenShotOfButton(String locator, String buttonName) {
        page.locator(locator).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(buttonScreenshotFolder + buttonName + ".png")));
    }

    public static void renameVideoBasedOnTestName(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Path videoName = page.video().path().getFileName();
        File file1 = new File(pathProject + File.separator + demoVideoFolder + File.separator + videoName);
        File file2 = new File(pathProject + File.separator + demoVideoFolder + File.separator + testName + ".webm");
        boolean status = file1.renameTo(file2);
        System.out.println("Video renamed to " + testName + ".webm - " + status);
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContent = directoryToBeDeleted.listFiles();
        if(allContent != null) {
            for (File file: allContent) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
