# Selenium
@autor: Eberson Ramos
## Testes Automatizados. 
- Selenium
- Gradle
- JDK 11
- TestNG

# Execução da suite de testes com grupos e dataProvider.
$ gradle clean test -PtestngRun

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
marionette.firefox-webdriver = webdriver.gecko.driver
## Configuração default é para Linux. Para Windowns basta fazer o download do mesmo driver, mas com a extenção *.exe e colocar na pasta desta propriedade ${marionette.path-webdriver}
marionette.firefox-geckodriver-filename = geckodriver

## Usado para carregar o driver pelo System.setProperty()
marionette.chrome-webdriver  = webdriver.chrome.driver
## Configuração default é para Linux. Para Windowns basta fazer o download do mesmo driver, mas com a extenção *.exe e colocar na pasta desta propriedade ${marionette.path-webdriver}
marionette.chrome-chromedriver-filename = chromedriver

# Path default para os files dos webdrivers
marionette.path-webdriver = src/test/resources/webdrivers/

# Execução dos Testes
A cada teste executado é criada a pasta target com outras pastas contendo as screenshots dos testes executados por data
e hora.
