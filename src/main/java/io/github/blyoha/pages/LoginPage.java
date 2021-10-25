package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends TestBase {
    WebElement emailField;
    WebElement passwordField;

    public MailPage login(String username, String password) {
        emailField = driver.findElement(By.name("login"));
        emailField.sendKeys(username, Keys.ENTER);
        // Assert.assertEquals(validateLoginField(), "false", "Incorrect email");

        passwordField = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.name("passwd")));

        passwordField.sendKeys(password, Keys.ENTER);

        return new MailPage();
    }

    public String validateLoginField() {
        return emailField.getAttribute("aria-invalid");
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
}
