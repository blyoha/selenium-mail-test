package io.github.blyoha.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.MailPage;
import io.github.blyoha.pages.LoginPage;
import io.github.blyoha.pages.HomeMailPage;

public class mailTest extends TestBase {
    HomeMailPage homeMailPage;
    MailPage mailPage;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        initialize();
    }

    @Test
    public void main() {
        homeMailPage = new HomeMailPage();

        loginPage = homeMailPage.redirectToLoginPage();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Авторизация",
                "Login page URL not matched");

        String  email = properties.getProperty("email"),
                password = properties.getProperty("password");

        mailPage = loginPage.login(email, password);
        Assert.assertTrue(mailPage.validateMailPageTitle(), "Mail page URL not matched");

        mailPage = mailPage.compose();
        mailPage = mailPage.send();

        homeMailPage = mailPage.logout();
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }

}
