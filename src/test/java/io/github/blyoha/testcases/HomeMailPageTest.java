package io.github.blyoha.testcases;

import io.github.blyoha.base.TestBase;
import io.github.blyoha.pages.HomeMailPage;
import io.github.blyoha.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class HomeMailPageTest extends TestBase {
    HomeMailPage homeMailPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        initialize();
        homeMailPage = new HomeMailPage();
        loginPage = new LoginPage();
    }

    @Test
    public void testHomeMailPageTitle() {
        String title = homeMailPage.validateHomeMailPageTitle();
        Assert.assertEquals(title, "Яндекс.Почта — бесплатная и надежная электронная почта");
    }

    @Test (priority = 1)
    public void testLoginLink() {
        loginPage = homeMailPage.redirectToLoginPage();
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}
