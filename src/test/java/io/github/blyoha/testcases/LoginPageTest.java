package io.github.blyoha.testcases;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.HomeMailPage;
import io.github.blyoha.pages.LoginPage;
import io.github.blyoha.pages.MailPage;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginPageTest extends TestBase {
    HomeMailPage homeMailPage;
    LoginPage loginPage;
    MailPage mailPage;

    @Step("Setting up...")
    @Description("Redirecting to mail page")
    @BeforeClass
    public void setUp() throws MalformedURLException {
        initialize();
        homeMailPage = new HomeMailPage();
        loginPage = new LoginPage();
        mailPage = new MailPage();

        loginPage = homeMailPage.redirectToLoginPage();
    }

    @Step("Testing login page title...")
    @Description("Checking if page title is correct")
    @Test
    public void testLoginPageTitle() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Authorization");
    }

    @Step("Testing login...")
    @Description("Logging in with email and password")
    @Test(priority = 1)
    public void testLogin() {
        String email = properties.getProperty("email"),
                password = properties.getProperty("password");

        mailPage = loginPage.login(email, password);
    }

    @Step("Quitting browser...")
    @Description("Shouting down web driver and quitting")
    @AfterClass
    public void finish() {
        driver.quit();
    }
}
