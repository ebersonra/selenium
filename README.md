# Selenium
@autor: Eberson Ramos
## Testes Automatizados. 
- Selenium
- Gradle
- JDK 11
- TestNG

# Inicia a execução de uma suite de testes usando um arquivo xml com as configurações da suite, dos testes, dos grupos e da classe de testes. Esse comando irá executar todos os testes contidos na classe de testes.
$ gradle clean test -PtestngRun

## -Ptestn/gRun define o valor da variavel "runSuite" criada no arquivo build.gradle, que indica a execução dos testes usando o arquivo xml configurado com a suite de testes.

ext {
 .....
 .....
 .....
 runSuite = project.hasProperty("testngRun")
}

# Anotação Customizada SeleniumTest

## Instância do WebDriver default
Class<?> driver() default FirefoxDriver.class;

## Url da applicação.
String url() default "https://localhost:8090";

## Driver do browser default.
<ul>
 <li>firefox = webdriver.gecko.driver</li>
 <li>chrome = webdriver.chrome.driver</li>
</ul>
String browser() default "firefox";

## Ambiente para execução dos testes.
String env() default "dev";

# Arquvivo marionette_dev.properties
## Usado para carregar o driver pelo System.setProperty()
- marionette.firefox-webdriver = webdriver.gecko.driver

## Propriedades do geckodriver linux/windows
- marionette.firefox-linux-geckodriver-filename = geckodriver
- marionette.firefox-windows-geckodriver-filename = geckodriver.exe

## Usado para carregar o driver pelo System.setProperty()
- marionette.chrome-webdriver  = webdriver.chrome.driver

## Propriedades do chromedriver linux/windows
- marionette.chrome-linux-chromedriver-filename = chromedriver
- marionette.chrome-windows-chromedriver-filename = chromedriver.exe

# Path default para os files dos webdrivers
- marionette.path-webdriver = src/test/resources/webdrivers/

# Execução dos Testes
A cada teste executado é criada a pasta target com outras pastas contendo as screenshots dos testes executados por data
e hora.
