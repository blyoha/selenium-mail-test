package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;
import org.testng.Assert;

public class LoginPage extends TestBase {
    WebElement emailField;
    WebElement passwordField;

    public void login(String username, String password) {
        emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys(username, Keys.ENTER);
        Assert.assertEquals(validateLoginField(), "false", "Incorrect email");

        passwordField = driver.findElement(By.name("//input[@type='password']"));


        passwordField.sendKeys(password, Keys.ENTER);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public String validateLoginField() {
        return emailField.getAttribute("aria-invalid");
    }
}
