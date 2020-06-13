package com.selenium.marionette.common.page;

import com.selenium.marionette.common.SeleniumMarionetteDSL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPrivacyErrorPage {

    private WebDriver driver;
    private SeleniumMarionetteDSL seleniumMarionetteDSL;

    public SeleniumPrivacyErrorPage(WebDriver driver){
        this.driver = driver;
        this.seleniumMarionetteDSL = PageFactory.initElements(this.driver, SeleniumMarionetteDSL.class);
    }

    public boolean isEnabledButtonDetails(){
        return this.seleniumMarionetteDSL.isEnabledElementById("details-button");
    }

    public void onClickButtonDetails(){
        this.seleniumMarionetteDSL.onClickElementById("details-button");
    }

    public void onClickProceedLink(){
        this.seleniumMarionetteDSL.onClickElementById("proceed-link");
    }
}
