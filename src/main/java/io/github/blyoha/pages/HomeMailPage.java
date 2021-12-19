package io.github.blyoha.pages;

import io.github.blyoha.base.TestBase;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeMailPage extends TestBase {
    @FindBy(xpath = "//a[contains(span, 'Log in')]")
    WebElement signIn;

    public HomeMailPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Redirecting to login page...")
    public LoginPage redirectToLoginPage() {
        signIn.click();
        return new LoginPage();
    }

    @Step("Validating home mail page title...")
    public String validateHomeMailPageTitle() {
        return driver.getTitle();
    }

}
