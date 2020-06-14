package com.selenium.marionette.system.page;

import com.selenium.marionette.common.SeleniumMarionetteDSL;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumSystemPage {

    private SeleniumMarionetteDSL seleniumMarionetteDSL;
    private WebDriver driver;

    public SeleniumSystemPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchByText(String searchText){
        getSeleniumMarionetteDSL()
                .findElementByNameAndSendKeys("q", searchText);

        getSeleniumMarionetteDSL().onClickElementByName("btnK");

        Assertions.assertThat("https://www.selenium.dev/").
                isEqualToIgnoringCase(getSeleniumMarionetteDSL().getValueElementByXpathAndAttribute("//*[@id=\"rso\"]/div[1]/link", "href"));
    }

    private SeleniumMarionetteDSL getSeleniumMarionetteDSL() {
        seleniumMarionetteDSL = PageFactory.initElements(this.driver, SeleniumMarionetteDSL.class);
        return seleniumMarionetteDSL;
    }

}
