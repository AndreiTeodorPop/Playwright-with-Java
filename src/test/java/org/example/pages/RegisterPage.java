package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.Hook;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.example.tests.Helper.makeScreenShotOfButton;
import static org.example.tests.Helper.makeScreenShotOfPage;

public class RegisterPage extends Hook {

    String firstNameBox = "//input[@ng-model='FirstName']";
    String lastNameBox = "//input[@ng-model='LastName']";
    String refreshButton = "//button[@id='Button1']";
    String moreList = "//a[@class='dropdown-toggle']";
    String fileDownloadPage = "ul.dropdown-menu li";


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
