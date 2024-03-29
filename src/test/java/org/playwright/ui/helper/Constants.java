package org.playwright.ui.helper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
public final class Constants {

    public static final String DOWNLOAD_LOCATION = System.getProperty("user.dir") + File.separator + "src/main/resources/download/";
    public static final String APP_URL = "https://demo.automationtesting.in/Index.html";
    public static final String PAGE_SCREENSHOT_FOLDER = "target/demo-screenshots/pages/";
    public static final String ELEMENT_SCREENSHOT_FOLDER = "target/demo-screenshots/elements/";
    public static final String INFO_TXT = "info.txt";
    public static final String UPLOAD_FILE = "src/main/resources/upload/SamplePicture.jpg";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final Path DEMO_VIDEOS_SAVE_LOCATION = Paths.get("target/demo-videos/");
    public static final Path PATH_DOWNLOAD_LOCATION = Paths.get(DOWNLOAD_LOCATION);


    private Constants() {

    }
}