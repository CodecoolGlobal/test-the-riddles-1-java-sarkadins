package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamesPage extends BasePage{
    WebDriverWait wait;

    private static final String XPATH_JOIN_BUTTON = "//div[contains(@class, 'flex-row') and .//span[text()='my_testQuiz']]//button[contains(text(), 'Join')]";

    @FindBy(xpath = XPATH_JOIN_BUTTON)
    private WebElement joinButton;

    public GamesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickJoinButton() {
        wait.until(ExpectedConditions.elementToBeClickable(joinButton));
        joinButton.click();
    }
}
