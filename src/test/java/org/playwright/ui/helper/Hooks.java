package org.playwright.ui.helper;

import org.playwright.ui.service.BrowserService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.nio.file.Path;


/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class Hooks extends BrowserService {

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName) {
        initPlaywright(browserName);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//        Path videoName = page.video().path().getFileName();
        closeBrowser();
        closePlaywright();
//        File file1 = new File(Constants.PROJECT_PATH + File.separator + Constants.DEMO_VIDEOS_SAVE_LOCATION + File.separator + videoName);
//        File file2 = new File(Constants.PROJECT_PATH + File.separator + Constants.DEMO_VIDEOS_SAVE_LOCATION + File.separator + testName + ".webm");
//        boolean status = file1.renameTo(file2);
//        System.out.println("Video renamed to " + testName + ".webm - " + status);
    }
}
