package com.codecool.pages;

import com.codecool.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    Wait<WebDriver> wait;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(linkText = "Logout")
    private WebElement chooseLogoutButton;

    public void clickLogoutButton() {
        chooseLogoutButton.click();
    }

    public String getChooseLogoutButtonText() {
        return wait.until(ExpectedConditions.visibilityOf(chooseLogoutButton)).getText();
    }
}