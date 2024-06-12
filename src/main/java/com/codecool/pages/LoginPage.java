package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(css = "[class='flex items-center gap-x-1'] [href='\\/login'] .lg\\:block")
    private WebElement chooseLoginButton;

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = ".bg-green-800.font-bold.mr-4.mt-6.p-4.text-white.w-full")
    private WebElement loginButton;


    private void enterUserName(String userName) {
        //userNameField.clear();
        wait.until(ExpectedConditions.visibilityOf(userNameField)).sendKeys(userName);
    }

    private void enterPassword(String password) {
        //passwordField.clear();
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    private void clickChooseLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(chooseLoginButton)).click();
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public void handleLogin(String username, String password){
        clickChooseLoginButton();
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }
}