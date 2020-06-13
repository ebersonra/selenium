package com.selenium.marionette.config;

import com.selenium.marionette.common.SeleniumMarionetteBrowser;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumMarionetteWebDriver {

    private WebDriver webDriver;
    private URL url;
    private Properties props;

    private String nextEnv;

    public String getNextEnv() {
        return nextEnv;
    }

    public void setNextEnv(String nextEnv) {
        this.nextEnv = nextEnv;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @SuppressWarnings(value = {"unchecked","rawtypes"})
    public WebDriver webDriverValues(Class clazz) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        if(clazz.isAnnotationPresent(SeleniumTest.class)){

            Annotation annotation = clazz.getAnnotation(SeleniumTest.class);
            SeleniumTest seleniumTest = (SeleniumTest) annotation;
            String browser = seleniumTest.browser();
            String baseUrl = seleniumTest.url();
            setNextEnv(seleniumTest.env());

            getProps();
            this.url = new URL(baseUrl);

            if (browser.equalsIgnoreCase(SeleniumMarionetteBrowser.FIREFOX.getBrowserName())) {

                System.setProperty(this.props.getProperty("marionette.firefox-webdriver"),
                        findFile(this.props.getProperty("marionette.firefox-geckodriver-filename")));
            } else if (browser.equalsIgnoreCase(SeleniumMarionetteBrowser.CHROME.getBrowserName())) {

                System.setProperty(this.props.getProperty("marionette.chrome-webdriver"),
                        findFile(this.props.getProperty("marionette.chrome-chromedriver-filename")));
            }

            setWebDriver((WebDriver) seleniumTest.driver().getDeclaredConstructor().newInstance());
            getWebDriver().get(this.url.toString());
            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getWebDriver().manage().window().maximize();
        }
        return getWebDriver();
    }

    private Properties getProps() throws IOException {

        String fileConfig = "marionette_".concat(getNextEnv()).concat(".properties");

        this.props = new Properties();
        InputStream inputStream = null;

        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(fileConfig);
            this.props.load(inputStream);
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
        return this.props;
    }

    private String findFile(String filename) throws IOException {

        if(new File(this.props.getProperty("marionette.path-webdriver").concat(filename)).exists()){
            return this.props.getProperty("marionette.path-webdriver").concat(filename);
        }

        return "";
    }
}
