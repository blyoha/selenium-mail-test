package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;

public class GmailPage extends TestBase {
    WebElement signIn;

    public LoginPage redirectToLogin() {
        signIn = driver.findElement(By.xpath("//*[@data-action='sign in']"));
        signIn.click();
        return new LoginPage();
    }

    public String getGmailPageUrl() {
        return driver.getCurrentUrl();
    }
}
