package io.github.blyoha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.github.blyoha.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage extends TestBase {
    WebElement compose;
    WebElement mailSearch;
    WebElement searchResults;
    WebElement send;
    WebElement to;
    WebElement text;
    WebElement subject;
    WebElement filter;

    String letterQty;
    final String letterTheme= "Simbirsoft Тестовое задание";
    final String surname = "Фамилия";

    public MailPage compose() {
        filter = driver.findElement(By.xpath("//a[@href='#sent']"));
        filter.click();
        mailSearch = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.className("textinput__control")));
        mailSearch.sendKeys(letterTheme, Keys.ENTER);

        countUnread();

        compose = driver.findElement(By.xpath("//a[@href='#compose']"));
        compose.click();

        to = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.className("composeYabbles")));
        to.sendKeys(properties.getProperty("email"), Keys.ENTER);

        subject = driver.findElement(By.name("subject"));
        subject.sendKeys(letterTheme + ". " + surname);

        text = driver.findElement(By.xpath("//div[@role='textbox']"));
        text.sendKeys(letterQty);

        return this;
    }

    public MailPage send() {
        send = driver.findElement(By.xpath("//span[contains(text(), 'Отправить')]" +
                "/ancestor::button[contains(@span, Button2-Text)]"));
        send.click();

        return this;
    }

    public void countUnread() {
        try {
            searchResults = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            By.className("mail-MessagesSearchInfo-Title_misc")));
            String[] qty = searchResults.getText().split(" ");
            letterQty = qty[0];
        }
        catch (NoSuchElementException e) {
            letterQty = "0";
        }
    }

    public boolean validateMailPageTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Яндекс.Почта"));
    }
}
