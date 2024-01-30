package org.playwright.ui.pages;

import com.microsoft.playwright.Page;
import org.playwright.ui.helper.Constants;
import org.playwright.ui.helper.Helper;
import org.playwright.ui.elements.WebTablePageElements;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class HomePage extends AbstractPage {

    Helper helper = new Helper(page);

    public HomePage(Page page) {
        super(page);
    }

    public HomePage navigateToHomePage() {
        page.navigate(Constants.APP_URL);
        assertThat(page).hasTitle("Index");
        helper.takeScreenShotOfPage("IndexPage");
        return this;
    }

    public RegisterPage navigateToRegisterPageAndAcceptCookies() {
        page.locator(WebTablePageElements.registerPageRedirect).click();
        page.locator(WebTablePageElements.acceptCookiesButton).getByText("Consent").click();
        assertThat(page).hasTitle("Register");
        helper.takeScreenShotOfPage("RegisterPage");
        return new RegisterPage(page);
    }

}
