package io.github.blyoha.pages;

import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage extends TestBase {
    WebElement compose;

    public void compose() {
        // code
    }

    public boolean validateMailPageTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Яндекс.Почта"));
    }
}
