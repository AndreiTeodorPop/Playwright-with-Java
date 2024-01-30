package org.playwright.ui.pages;

import com.microsoft.playwright.Page;

public abstract class AbstractPage {

    protected Page page;
    public AbstractPage(Page page) {
        this.page = page;
    }
}
