package io.github.blyoha.testcases;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.HomeMailPage;
import io.github.blyoha.pages.LoginPage;
import io.github.blyoha.pages.MailPage;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class MailPageTest extends TestBase {
    HomeMailPage homeMailPage;
    LoginPage loginPage;
    MailPage mailPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        initialize();

        homeMailPage = new HomeMailPage();
        loginPage = new LoginPage();
        mailPage = new MailPage();

        loginPage = homeMailPage.redirectToLoginPage();
        mailPage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Test
    public void testMailPageTitle() {
        boolean title = mailPage.validateMailPageTitle();
        Assert.assertTrue(title);
    }

    @Test (priority = 1)
    public void testComposing() {
        mailPage = mailPage.compose();
    }

    @Test (priority = 2)
    public void testSending() {
        mailPage = mailPage.send();
    }

    @Test (priority = 3)
    public void testLogout() {
        homeMailPage = mailPage.logout();
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}
