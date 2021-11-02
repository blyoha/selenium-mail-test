package io.github.blyoha.pages;

import io.github.blyoha.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage extends TestBase {
    @FindBy(xpath = "//a[@href='#sent']")
    WebElement mailFilter;

    @FindBy(className = "textinput__control")
    WebElement mailSearch;

    @FindBy(xpath = "//a[@href='#compose']")
    WebElement compose;

    @FindBy(xpath = "//a[@aria-label='Выйти из аккаунта']")
    WebElement logout;

    @FindBy(name = "subject")
    WebElement subject;

    final String letterTheme = "Тестирование Яндекс почты (Java, Selenium, TestNG)";
    final String filterText = "Simbirsoft Тестовое задание";

    public MailPage() {
        PageFactory.initElements(driver, this);
    }

    public MailPage compose() {
        mailFilter.click();
        mailSearch.sendKeys(filterText, Keys.ENTER);

        String unreadQty = countUnreadMail();

        compose.click();

        WebElement receiver = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.className("composeYabbles")));
        receiver.sendKeys(properties.getProperty("email"), Keys.ENTER);

        subject.sendKeys(letterTheme);

        WebElement text = driver.findElement(By.xpath("//div[@role='textbox']"));
        text.sendKeys(unreadQty);

        return this;
    }

    public MailPage send() {
        WebElement send = driver.findElement(By.xpath("//span[contains(text(), 'Отправить')]" +
                "/ancestor::button[contains(@span, Button2-Text)]"));
        send.click();

        return this;
    }

    public HomeMailPage logout() {
        driver.findElement(By.xpath("//a[@href='https://passport.yandex.ru']")).click();
        logout.click();

        return new HomeMailPage();
    }

    public String countUnreadMail() {
        try {
            WebElement searchResults = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            By.className("mail-MessagesSearchInfo-Title_misc")));
            String[] qty = searchResults.getText().split(" ");
            return qty[0];

        } catch (NoSuchElementException e) {
            return "0";
        }
    }

    public boolean validateMailPageTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Яндекс.Почта"));
    }
}
