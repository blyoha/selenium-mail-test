package io.github.blyoha.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static WebDriver driver;
    static DesiredCapabilities capabilities;
    static ChromeOptions chromeOptions;

    public TestBase() {
        // your code
    }

    public static void initialize() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-BR");

        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        URL nodeURL = new URL("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver(nodeURL, capabilities);
        driver.get("https://google.com");
        driver.manage().deleteAllCookies();
    }
}
