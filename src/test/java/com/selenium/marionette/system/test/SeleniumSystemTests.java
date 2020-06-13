package com.selenium.marionette.system.test;

import com.selenium.marionette.common.SeleniumMarionetteDSL;
import com.selenium.marionette.config.SeleniumMarionetteConfig;
import com.selenium.marionette.config.SeleniumTest;
import com.selenium.marionette.system.test.util.SeleniumDataProvider;
import org.testng.annotations.Test;


@SeleniumTest(
        url = "https://www.google.com"
)
public class SeleniumSystemTests extends SeleniumMarionetteConfig {

    private SeleniumMarionetteDSL marionetteDSL;

    public SeleniumSystemTests(){
        marionetteDSL = new SeleniumMarionetteDSL(super.getWebDriver());
    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "accessPageLogin_noParameters"
    )
    public void systemAccessPageLogin() {

    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "login_noParameters"
    )
    public void systemAccessPageLoginWithUsernameAndPassword() throws InterruptedException {

    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "accessMenu_noParameters"
    )
    public void systemAccessMenu() throws InterruptedException {

    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "listAll_noParameters"
    )
    public void systemAccessMenuAndListAll() throws InterruptedException {

    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "consultByName"
    )
    public void systemAccessMenuAndConsultByName(String partnerName, String partnerCpf) throws InterruptedException {

    }

    @Test(
            dataProvider = "SeleniumDataProvider",
            dataProviderClass = SeleniumDataProvider.class,
            groups = "editByName"
    )
    public void systemAccessMenuAndListByNameAndClickButtonEdit(String partnerName) throws InterruptedException {

    }
}