package io.github.blyoha.base;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public static ChromeOptions options;
    public static Properties properties;
    public static WebDriver driver;
    static DesiredCapabilities capabilities;

    public TestBase() {
        try {
            properties = new Properties();

            FileInputStream inputProp = new FileInputStream("src/main/java/io/github/blyoha/config/config.properties");
            properties.load(inputProp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Initializing...")
    @Description("Setting up Webdriver")
    public static void initialize() throws MalformedURLException {
        options = new ChromeOptions();
        options.addArguments("--lang=en");

        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        URL nodeURL = new URL("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver(nodeURL, capabilities);
        driver.get(properties.getProperty("url"));
        driver.manage().deleteAllCookies();
    }
}
