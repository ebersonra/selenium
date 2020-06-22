package com.selenium.marionette.common;

public enum SeleniumMarionetteBrowser {

    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browserName;

    private SeleniumMarionetteBrowser(String browserName){
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    @Override
    public String toString() {
        return this.browserName;
    }
}
