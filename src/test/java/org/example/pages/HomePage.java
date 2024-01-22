package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.Hook;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.example.tests.Helper.makeScreenShotOfPage;

public class HomePage extends Hook {

    String url = "https://demo.automationtesting.in/Index.html";
    String registerPageRedirect = "//img[@id='enterimg']";
    String acceptCookiesButton = "(//p[@class='fc-button-label'])[1]";


    public HomePage(Page page) {
        this.page = page;
    }

    public HomePage navigateToHomePage() {
        page.navigate(url);
        makeScreenShotOfPage("IndexPage");
        return this;
    }

    public RegisterPage navigateToRegisterPageAndAcceptCookies() {
        page.locator(registerPageRedirect).click();
        page.locator(acceptCookiesButton).getByText("Consent").click();
        assertThat(page).hasTitle("Register");
        makeScreenShotOfPage("RegisterPage");
        return new RegisterPage(page);
    }

}
