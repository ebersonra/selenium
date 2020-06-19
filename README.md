# Selenium
```java
/**
 * @since 19-06-2020
 * @autor: Eberson Ramos
 */
```
## 1- Requisitos. 
- Selenium 3.141.59
- Gradle 6.2.1
- JDK 11
- TestNG 7.1.0

## 2- Iniciar a execução de uma suite de testes usando um arquivo xml com as configurações da suite, dos testes, dos grupos e da classe de testes. Esse comando irá executar todos os testes contidos na classe de testes.

```
$ gradle test -PtestngRun
```

## 3- testngRun define o valor da variavel "runSuite" criada no arquivo build.gradle, que indica a execução dos testes usando o arquivo xml configurado com a suite de testes.

```
ext {
 .....
 .....
 .....
 runSuite = project.hasProperty("testngRun")
}
```

## 4- Anotação Customizada SeleniumTest.

```java
public @interface SeleniumTest {
    
    /**
     * Instância do WebDriver default
     */
    Class<?> driver() default FirefoxDriver.class;

    /**
     * Url da applicação.
     */    
    String url() default "https://localhost:8090";

    /**
     * Driver do browser default.
     */
    String browser() default "firefox";
   
    /**
     * Ambiente para execução dos testes.
     */ 
    String env() default "dev";

}
```

## 5- Arquvivo marionette_dev.properties.
### Usado para carregar o webdriver pelo System.setProperty().

```properties
marionette.firefox-webdriver = webdriver.gecko.driver

# Propriedades do geckodriver linux/windows
marionette.firefox-linux-geckodriver-filename = geckodriver
marionette.firefox-windows-geckodriver-filename = geckodriver.exe

# Usado para carregar o driver pelo System.setProperty()
marionette.chrome-webdriver  = webdriver.chrome.driver

# Propriedades do chromedriver linux/windows
marionette.chrome-linux-chromedriver-filename = chromedriver
marionette.chrome-windows-chromedriver-filename = chromedriver.exe

# Path default para os files dos webdrivers
marionette.path-webdriver = src/test/resources/webdrivers/
```
## 5- Execução dos Testes
### A cada teste executado é criada a pasta target com outras pastas contendo as screenshots dos testes executados por nome da classe de testes, data e hora.
```
target/
    --- screenshot/
        --- SeleniumSystemTests/
            --- Day_Month_Year_Hour_Minutes_PM_or_AM/
                --- screenshot_file.jpg
    --- testng-output/
```
