package io.github.blyoha.testcases;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.HomeMailPage;
import io.github.blyoha.pages.LoginPage;
import io.github.blyoha.pages.MailPage;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class LoginPageTest extends TestBase {
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
    }

    @Test
    public void testLoginPageTitle() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Авторизация");
    }

    @Test (priority = 1)
    public void testLogin() {
        String  email = properties.getProperty("email"),
                password = properties.getProperty("password");

        mailPage = loginPage.login(email, password);
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}
