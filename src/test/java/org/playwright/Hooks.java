package org.playwright;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


/**
 * @author : andrei
 * @created : 12/19/2023, Tuesday
 **/
public class Hooks extends BrowserService {

    Helper helper = new Helper(page);

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName) {
        initPlaywright(browserName);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        closeBrowser();
        closePlaywright();
//        helper.renameVideoBasedOnTestName(result);
    }
}
