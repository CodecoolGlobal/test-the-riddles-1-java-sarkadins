package com.codecool.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyQuizPage extends BasePage{

    WebDriverWait wait;

    public MyQuizPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @FindBy(css = "[class='flex flex-row border-2 m-2 p-1 rounded-md'] button:nth-child(2)")
    private WebElement deleteQuizButton;

    @FindBy(css = ".bg-inherit.flex-grow span")
    private WebElement checkEmptyQuizAlert;

    public void clickDeleteQuizButton(){
        wait.until(ExpectedConditions.visibilityOf(deleteQuizButton)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertDeleteQuiz = driver.switchTo().alert();
        alertDeleteQuiz.accept();
    }

    public String getCheckEmptyQuizAlertText()
    {
        return wait.until(ExpectedConditions.visibilityOf(checkEmptyQuizAlert)).getText();
    }
}
