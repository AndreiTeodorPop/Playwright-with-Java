package org.playwright.ui.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.playwright.ui.helper.Helper;
import org.playwright.ui.elements.WebTablePageElements;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class RegisterPage extends AbstractPage {

    Helper helper = new Helper(page);


    public RegisterPage(Page page) {
        super(page);
    }

    public void addUserInfo() {
        page.locator(WebTablePageElements.firstNameBox).fill("Andrei");
        page.locator(WebTablePageElements.lastNameBox).fill("Pop");
        page.locator(WebTablePageElements.emailBox).fill("automation@test.com");
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Male")).nth(0).click();
        page.check("[value='Movies']");
        page.check("[value='Hockey']");
        page.locator("#country").selectOption("United States of America");
    }

    public void refreshPageAndScreenShot() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refresh")).click();
        helper.takeScreenShotOfButton(WebTablePageElements.refreshButton, "RefreshButton");
    }

    public DownloadPage navigateToDownloadPage() {
        page.locator(WebTablePageElements.dropDownToggle).getByText("More").click();
        page.locator(WebTablePageElements.fileDownloadPage, new Page.LocatorOptions().setHasText("File Download")).click();
        assertThat(page).hasTitle("File input - Multi select");
        helper.takeScreenShotOfPage("DownloadPage");
        return new DownloadPage(page);
    }

    public UploadPage navigateToUploadPage() {
        page.locator(WebTablePageElements.dropDownToggle).getByText("More").click();
        page.locator(WebTablePageElements.fileDownloadPage, new Page.LocatorOptions().setHasText("File Upload")).click();
        assertThat(page).hasTitle("File input - Multi select");
        helper.takeScreenShotOfPage("UploadPage");
        return new UploadPage(page);
    }
}
