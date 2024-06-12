package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(linkText = "Logout")
    private WebElement chooseLogoutButton;

    public String getChooseLogoutButtonText() {
        wait.until(ExpectedConditions.visibilityOf(chooseLogoutButton));
        return chooseLogoutButton.getText();
    }
}