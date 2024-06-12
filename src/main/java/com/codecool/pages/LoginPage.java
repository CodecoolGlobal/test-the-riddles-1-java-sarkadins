package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Login")
    private WebElement chooseLoginButton;

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = ".bg-green-800.font-bold.mr-4.mt-6.p-4.text-white.w-full")
    private WebElement loginButton;


    private void enterUserName(String userName) {
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    private void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void clickChooseLoginButton() {
        chooseLoginButton.click();
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