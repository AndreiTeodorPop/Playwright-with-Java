package org.playwright.api.helper;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class Hooks {
    protected RequestManager manager;

    @BeforeClass
    public void setup() {
        this.manager = new RequestManager();
        this.manager.createPlaywright();
        final String baseUrl = "https://reqres.in";
        final Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        this.manager.setApiRequestContext(baseUrl, headers);
    }

    @AfterClass
    public void tearDown() {
        this.manager.disposeAPIRequestContext();
        this.manager.closePlaywright();
    }
}
