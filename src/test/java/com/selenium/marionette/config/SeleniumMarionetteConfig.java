package com.selenium.marionette.config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static com.selenium.marionette.common.SeleniumMarionetteCaseFormat.toLowerUnderscore;

public class SeleniumMarionetteConfig implements ITest {

    private SeleniumMarionetteWebDriver seleniumMarionetteWebDriver;
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        if(seleniumMarionetteWebDriver == null){
            seleniumMarionetteWebDriver = new SeleniumMarionetteWebDriver();
        }

        setWebDriver(seleniumMarionetteWebDriver.webDriverValues(this.getClass()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(ITestResult result) throws Exception {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
        File screenshot = takesScreenshot != null ? takesScreenshot.getScreenshotAs(OutputType.FILE) : null;

        if(!Objects.isNull(screenshot)){
            String methodName = toLowerUnderscore(result.getMethod().getMethodName());

            FileUtils.copyFile(screenshot, new File("target".concat(File.separator)
                    .concat("screenshot").concat(File.separator)
                    .concat(result.getTestName()).concat(File.separator)
                    .concat(getToday()).concat(File.separator)
                    .concat(File.separator).concat(methodName).concat(".jpg")));
        }

        kill();
    }

    private String getToday(){
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_aa");
        return dateFormat.format(today);
    }

    private void kill(){
        if(getWebDriver() != null){
            getWebDriver().quit();
        }
    }

    @Override
    public String getTestName() {
        return this.getClass().getSimpleName();
    }
}
