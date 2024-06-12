package com.codecool.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuizPage extends BasePage {

    WebDriverWait wait;


    public QuizPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @FindBy(xpath = "/html//div[@id='root']/div/div[2]//button[.='Add Quiz']")
    private WebElement addQuizButton;
    @FindBy(id = "name")
    private WebElement quizTitleField;
    @FindBy(css = ".bg-green-800.font-bold.h-fit.mb-4.p-4.text-white")
    private WebElement addQuestionButton;
    @FindBy(id = "-1question")
    private WebElement questionTitleField;
    @FindBy(id = "answer-1")
    private WebElement firstAnswerField;
    @FindBy(id = "answer-2")
    private WebElement secondAnswerField;
    @FindBy(id = "answer-3")
    private WebElement thirdAnswerField;
    @FindBy(css = ".bg-zinc-700.border-2.border-zinc-500.left-1.mt-2.p-1.px-3.relative.text-white")
    private WebElement addMoreQuestionButton;
    @FindBy(id = "checkbox-1")
    private WebElement firstAnswerCheckbox;
    @FindBy(id = "checkbox-2")
    private WebElement secondAnswerCheckbox;
    @FindBy(id = "checkbox-3")
    private WebElement thirdAnswerCheckbox;
    @FindBy(css = ".bg-green-800.font-bold.m-4.mb-2.p-2.text-white.w-24")
    private WebElement saveQuestionButton;
    @FindBy(xpath = "/html//div[@id='root']/div/div[2]//button[.='Save quiz']")
    private WebElement saveQuizButton;
    @FindBy(css = "[class='grow flex align-middle text-lg pl-2 items-center']")
    private WebElement checkQuizTitle;

    private void clickAddQuiz() throws InterruptedException {
        Thread.sleep(344);
        wait.until(ExpectedConditions.visibilityOf(addQuizButton)).click();
    }
    private void enterQuizTitle(String quizTitle){
        //quizTitleField.clear();
        wait.until(ExpectedConditions.visibilityOf(quizTitleField)).sendKeys(quizTitle);
    }
    private void clickAddQuestionButton(){
        wait.until(ExpectedConditions.visibilityOf(addQuestionButton)).click();
    }
    private void enterQuestionTitle(String questionTitle){
        //questionTitleField.clear();
        wait.until(ExpectedConditions.visibilityOf(questionTitleField)).sendKeys(questionTitle);
    }
    private void addAnswerToFirstField(String answer){
        //firstAnswerField.clear();
        wait.until(ExpectedConditions.visibilityOf(firstAnswerField)).sendKeys(answer);
    }
    private void addAnswerToSecondField(String answer){
        //secondAnswerField.clear();
        wait.until(ExpectedConditions.visibilityOf(secondAnswerField)).sendKeys(answer);
    }
    private void addAnswerToThirdField(String answer){
        addMoreQuestionButton.click();
        //thirdAnswerField.clear();
        wait.until(ExpectedConditions.visibilityOf(thirdAnswerField)).sendKeys(answer);
    }
    private void clickFirstAnswerCheckbox(){
        firstAnswerCheckbox.click();
    }
    private void clickSecondAnswerCheckbox(){
        secondAnswerCheckbox.click();
    }
    private void clickThirdAnswerCheckbox(){
        thirdAnswerCheckbox.click();
    }
    private void clickSaveQuestionButton(){
        saveQuestionButton.click();
    }
    private void clickSaveQuizButton(){
        saveQuizButton.click();
    }
    public void addQuizWithFirstAnswerIsCorrect(String quizTitle, String questionTitle, String answer1, String answer2) throws InterruptedException {
        clickAddQuiz();
        enterQuizTitle(quizTitle);
        clickAddQuestionButton();
        enterQuestionTitle(questionTitle);
        addAnswerToFirstField(answer1);
        addAnswerToSecondField(answer2);
        clickFirstAnswerCheckbox();
        clickSaveQuestionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertSaveQuestion = driver.switchTo().alert();
        alertSaveQuestion.accept();
        Thread.sleep(500);
        clickSaveQuizButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertSaveQuiz = driver.switchTo().alert();
        alertSaveQuiz.accept();
    }
    public String getCreatedQuizTitleText(){
        return wait.until(ExpectedConditions.visibilityOf(checkQuizTitle)).getText();
    }
}
