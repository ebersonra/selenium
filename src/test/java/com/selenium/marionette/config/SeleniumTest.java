package com.selenium.marionette.config;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SeleniumTest {

    /**
     * Instância do WebDriver default
     * */
    Class<?> driver() default FirefoxDriver.class;

    /**
     * Classe de testes. <b>value = MyTests.class</b>
     * */
    Class<?> value() default Class.class;

    /**
     * Url da applicação.
     * */
    String url() default "https://localhost:8090";

    /**
     * O driver do browser.
     * <ul>
     *     <li>webdriver.gecko.driver</li>
     *     <li>webdriver.chrome.driver</li>
     * </ul>
     * */
    String browser() default "firefox";

    /**
     * Ambiente para execução dos testes.
     * */
    String env() default "dev";
}
