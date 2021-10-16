package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;

public class GooglePage extends TestBase {
    WebElement gmailLink;

    public GmailPage redirectToGmail() {
        gmailLink = driver.findElement(By.xpath("//*[text()='Gmail']"));
        gmailLink.click();
        return new GmailPage();
    }

}
