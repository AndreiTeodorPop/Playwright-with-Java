package org.playwright.pages;

import com.microsoft.playwright.Page;
import org.playwright.Hook;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.playwright.Helper.takeScreenShotOfPage;

/**
 * @author : andrei
 * @created : 1/22/2024, Monday
 **/
public class HomePage extends Hook {

    private static final String url = "https://demo.automationtesting.in/Index.html";
    private static final String registerPageRedirect = "//img[@id='enterimg']";
    private static final String acceptCookiesButton = "(//p[@class='fc-button-label'])[1]";


    public HomePage(Page page) {
        this.page = page;
    }

    public HomePage navigateToHomePage() {
        page.navigate(url);
        assertThat(page).hasTitle("Index");
        takeScreenShotOfPage("IndexPage");
        return this;
    }

    public RegisterPage navigateToRegisterPageAndAcceptCookies() {
        page.locator(registerPageRedirect).click();
        page.locator(acceptCookiesButton).getByText("Consent").click();
        assertThat(page).hasTitle("Register");
        takeScreenShotOfPage("RegisterPage");
        return new RegisterPage(page);
    }

}
