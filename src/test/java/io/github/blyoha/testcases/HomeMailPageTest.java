package io.github.blyoha.testcases;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.HomeMailPage;
import io.github.blyoha.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomeMailPageTest extends TestBase {
    HomeMailPage homeMailPage;
    LoginPage loginPage;

    @Step("Setting up...")
    @Description("Redirecting to mail page")
    @BeforeClass
    public void setUp() throws MalformedURLException {
        initialize();
        homeMailPage = new HomeMailPage();
        loginPage = new LoginPage();
    }

    @Step("Testing home mail page title...")
    @Description("Checking if page title is correct")
    @Test
    public void testHomeMailPageTitle() {
        String title = homeMailPage.validateHomeMailPageTitle();
        Assert.assertEquals(title, "Yandex.Mail — free, reliable email");
    }

    @Step("Testing login link...")
    @Description("Checking if redirecting to login page is valid")
    @Test(priority = 1)
    public void testLoginLink() {
        loginPage = homeMailPage.redirectToLoginPage();
    }

    @Step("Quitting browser...")
    @Description("Shouting down web driver and quitting")
    @AfterClass
    public void finish() {
        driver.quit();
    }
}
