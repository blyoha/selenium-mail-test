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

public class MailPageTest extends TestBase {
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
        mailPage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Step("Testing mail page title...")
    @Description("Checking if page title is correct")
    @Test
    public void testMailPageTitle() {
        boolean title = mailPage.validateMailPageTitle();
        Assert.assertTrue(title);
    }

    @Step("Testing composing...")
    @Description("Composing mail")
    @Test(priority = 1)
    public void testComposing() {
        mailPage = mailPage.compose();
    }

    @Step("Testing sending...")
    @Description("Sending composed mail")
    @Test(priority = 2)
    public void testSending() {
        mailPage = mailPage.send();
    }

    @Step("Testing logging out...")
    @Description("Logging out")
    @Test(priority = 3)
    public void testLogout() {
        homeMailPage = mailPage.logout();
    }

    @Step("Quitting browser...")
    @Description("Shouting down web driver and quitting")
    @AfterClass
    public void finish() {
        driver.quit();
    }
}
