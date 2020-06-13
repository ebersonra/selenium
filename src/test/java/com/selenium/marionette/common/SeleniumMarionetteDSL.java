package com.selenium.marionette.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMarionetteDSL {

    private WebDriver driver;

    public SeleniumMarionetteDSL(WebDriver driver){
          this.driver = driver;
    }

    public void findElementByIdAndSendKeys(String idValue, String textValue){
        WebElement element = findElementById(idValue);
        element.clear();
        element.sendKeys(textValue);
    }

    public void onClickElementById(String idValue){
        WebElement element = findElementById(idValue);
        element.click();
    }

    public boolean isEnabledElementById(String idValue){
        WebElement element = findElementById(idValue);
        return element.isEnabled();
    }

    public String getTextElementById(String idValue){
        WebElement element = findElementById(idValue);
        return element.getText();
    }

    public String getTextElementByXpath(String xpathValue){
        WebElement element = findElementByXpath(xpathValue);
        return element.getText();
    }

    public String getValueElementByIdAndAttribute(String idValue, String attribute){
        WebElement element = findElementById(idValue);
        return element.getAttribute(attribute);
    }

    public String getValueElementByXpathAndAttribute(String xpathValue, String attribute){
        WebElement element = findElementByXpath(xpathValue);
        return element.getAttribute(attribute);
    }

    public void onClickElementByLinkText(String linkText){
       WebElement element = findElementByLinkText(linkText);
       element.click();
    }

    public String getTextByLinkText(String linkText){
        WebElement element = findElementByLinkText(linkText);
        return element.getText();
    }

    public String getValueByTagNameAndAttribute(String tagName, String attribute){
        WebElement element = findElementByTagName(tagName);
        return element.getAttribute(attribute);
    }

    public void onClickElementByXpath(String idValue){
        WebElement element = findElementByXpath(idValue);
        element.click();
    }

    private WebElement findElementByTagName(String tagName){
        WebElement element = getDriver().findElement(By.tagName(tagName));
        return element;
    }

    private WebElement findElementByLinkText(String linkValue){
        WebElement element = getDriver().findElement(By.linkText(linkValue));
        return element;
    }

    private WebElement findElementById(String idValue){
        WebElement element = getDriver().findElement(By.id(idValue));
        return element;
    }

    private WebElement findElementByXpath(String xpathValue){
        WebElement element = getDriver().findElement(By.xpath(xpathValue));
        return element;
    }

    private WebDriver getDriver() {
        return driver;
    }
}
