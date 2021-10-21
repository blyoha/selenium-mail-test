package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;

public class HomeMailPage extends TestBase {
    WebElement signIn;

    public LoginPage redirectToLoginPage() {
        signIn = driver.findElement(By.xpath("//a[contains(span, 'Войти')]"));
        signIn.click();
        return new LoginPage();
    }

}
