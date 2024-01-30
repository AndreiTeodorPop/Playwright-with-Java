package org.playwright.ui.pages;

import com.microsoft.playwright.Page;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
public abstract class AbstractPage {

    protected Page page;
    public AbstractPage(Page page) {
        this.page = page;
    }
}
