package org.playwright.pages;

import com.microsoft.playwright.Page;
import org.playwright.Helper;
import org.playwright.elements.WebTablePageElements;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class RegisterPage extends BasePage {

    Helper helper = new Helper(page);


    public RegisterPage(Page page) {
        super(page);
    }

    public void addUserName() {
        page.locator(WebTablePageElements.firstNameBox).fill("Andrei");
        page.locator(WebTablePageElements.lastNameBox).fill("Pop");
    }

    public void refreshPageAndScreenShot() {
        page.locator(WebTablePageElements.refreshButton).click();
        helper.takeScreenShotOfButton(WebTablePageElements.refreshButton, "RefreshButton");
    }

    public DownloadPage navigateToDownloadPage() {
        page.locator(WebTablePageElements.moreList).getByText("More").click();
        page.locator(WebTablePageElements.fileDownloadPage, new Page.LocatorOptions().setHasText("File Download")).click();
        assertThat(page).hasTitle("File input - Multi select");
        helper.takeScreenShotOfPage("DownloadPage");
        return new DownloadPage(page);
    }

    public UploadPage navigateToUploadPage() {
        page.locator(WebTablePageElements.moreList).getByText("More").click();
        page.locator(WebTablePageElements.fileDownloadPage, new Page.LocatorOptions().setHasText("File Upload")).click();
        assertThat(page).hasTitle("File input - Multi select");
        helper.takeScreenShotOfPage("UploadPage");
        return new UploadPage(page);
    }
}
