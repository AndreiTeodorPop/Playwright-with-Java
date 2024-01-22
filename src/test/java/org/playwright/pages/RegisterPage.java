package org.playwright.pages;

import com.microsoft.playwright.Page;
import org.playwright.Hook;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.playwright.Helper.makeScreenShotOfButton;
import static org.playwright.Helper.makeScreenShotOfPage;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class RegisterPage extends Hook {

    private static final String firstNameBox = "//input[@ng-model='FirstName']";
    private static final String lastNameBox = "//input[@ng-model='LastName']";
    private static final String refreshButton = "//button[@id='Button1']";
    private static final String moreList = "//a[@class='dropdown-toggle']";
    private static final String fileDownloadPage = "ul.dropdown-menu li";


    public RegisterPage(Page page) {
        this.page = page;
    }


    public void addUserCredentials() {
        page.locator(firstNameBox).fill("Andrei");
        page.locator(lastNameBox).fill("Pop");
    }

    public void refreshPageAndScreenShot() {
        page.locator(refreshButton).click();
        makeScreenShotOfButton(refreshButton, "RefreshButton");
    }

    public DownloadPage navigateToDownloadPage() {
        page.locator(moreList).getByText("More").click();
        page.locator(fileDownloadPage, new Page.LocatorOptions().setHasText("File Download")).click();
        assertThat(page).hasTitle("File input - Multi select");
        makeScreenShotOfPage("DownloadPage");
        return new DownloadPage(page);
    }

    public UploadPage navigateToUploadPage() {
        page.locator(moreList).getByText("More").click();
        page.locator(fileDownloadPage, new Page.LocatorOptions().setHasText("File Upload")).click();
        assertThat(page).hasTitle("File input - Multi select");
        makeScreenShotOfPage("UploadPage");
        return new UploadPage(page);
    }
}
