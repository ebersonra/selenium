package com.selenium.marionette.common;

public enum SeleniumMarionetteBrowser {

    FIREFOX("firefox", "webdrivers/geckodriver.exe"),
    CHROME("chrome", "webdrivers/chromedriver.exe");

    private final String browserName;
    private final String driverName;

    private SeleniumMarionetteBrowser(String browserName, String driverName){
        this.browserName = browserName;
        this.driverName = driverName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return this.browserName.concat("_").concat(this.driverName);
    }
}
