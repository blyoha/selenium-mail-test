package io.github.blyoha.testcases.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.GmailPage;
import io.github.blyoha.pages.GooglePage;
import io.github.blyoha.pages.LoginPage;

public class gmailTest extends TestBase {
    GooglePage googlePage;
    GmailPage gmailPage;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        initialize();
    }

    @Test
    public void main() {
        googlePage = new GooglePage();

        gmailPage = googlePage.redirectToGmail();
        Assert.assertTrue(gmailPage.getGmailPageUrl().contains("/gmail/about/#"),
                "Gmail page URL not matched");

        loginPage = gmailPage.redirectToLogin();

        String  email = "leha354107@gmail.com",
                password = "test";

        loginPage.login(email, password);
    }

    @Test
    public void verifyLoginPageTitle() {
        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(loginPageTitle, "Gmail", "Login page title not matched");
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }

}
