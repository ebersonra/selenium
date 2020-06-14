package com.selenium.marionette.system.test;

import com.selenium.marionette.config.SeleniumMarionetteConfig;
import com.selenium.marionette.config.SeleniumTest;
import com.selenium.marionette.system.page.SeleniumSystemPage;
import com.selenium.marionette.system.test.util.SeleniumDataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


@SeleniumTest(
        browser = "chrome",
        driver = ChromeDriver.class,
        url = "https://www.google.com"
)
public class SeleniumSystemTests extends SeleniumMarionetteConfig {

    private SeleniumSystemPage seleniumSystemPage;

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "searchGoogle"
    )
    public void accessSearchGoogle(String... arguments) {

        getSeleniumSystemPage().searchByText(arguments[0]);
    }

    public SeleniumSystemPage getSeleniumSystemPage() {
        seleniumSystemPage = PageFactory.initElements(getWebDriver(), SeleniumSystemPage.class);
        return seleniumSystemPage;
    }
}