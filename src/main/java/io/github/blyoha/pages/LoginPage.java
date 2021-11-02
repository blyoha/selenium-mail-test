package io.github.blyoha.pages;

import io.github.blyoha.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends TestBase {
    @FindBy(name = "login")
    WebElement emailField;

    WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public MailPage login(String username, String password) {
        emailField.sendKeys(username, Keys.ENTER);

        passwordField = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.name("passwd")));

        passwordField.sendKeys(password, Keys.ENTER);

        return new MailPage();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
}
