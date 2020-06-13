package com.selenium.marionette.common.page;

import com.selenium.marionette.common.SeleniumMarionetteDSL;
import org.openqa.selenium.WebDriver;

public class SeleniumMarionetteCommonPage {

    private WebDriver driver;
    private SeleniumMarionetteDSL seleniumMarionetteDSL;

    public SeleniumMarionetteCommonPage(WebDriver driver){
        this.driver = driver;
    }
}
