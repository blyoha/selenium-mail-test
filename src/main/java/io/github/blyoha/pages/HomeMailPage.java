package io.github.blyoha.pages;

import io.github.blyoha.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeMailPage extends TestBase {
    @FindBy(xpath = "//a[contains(span, 'Войти')]")
    WebElement signIn;

    public HomeMailPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage redirectToLoginPage() {
        signIn.click();
        return new LoginPage();
    }

    public String validateHomeMailPageTitle() {
        return driver.getTitle();
    }

}
