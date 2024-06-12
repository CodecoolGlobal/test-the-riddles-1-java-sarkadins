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
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @FindBy(css = ".bg-green-400.m-1.p-1.rounded-full.text-black.w-32")
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
    @FindBy(css = ".bg-green-800.font-bold.mr-4.mt-2.p-4.text-white.w-40")
    private WebElement saveQuizButton;
    @FindBy(css = ".align-middle.flex.grow.items-center.pl-2.text-lg")
    private WebElement checkQuizTitle;

    private void clickAddQuiz(){
        wait.until(ExpectedConditions.visibilityOf(addQuizButton)).click();
    }
    private void enterQuizTitle(String quizTitle){
        quizTitleField.clear();
        quizTitleField.sendKeys(quizTitle);
    }
    private void clickAddQuestionButton(){
        wait.until(ExpectedConditions.visibilityOf(addQuestionButton)).click();
    }
    private void enterQuestionTitle(String questionTitle){
        questionTitleField.clear();
        quizTitleField.sendKeys(questionTitle);
    }
    private void addAnswerToFirstField(String answer){
        firstAnswerField.clear();
        firstAnswerField.sendKeys(answer);
    }
    private void addAnswerToSecondField(String answer){
        secondAnswerField.clear();
        secondAnswerField.sendKeys(answer);
    }
    private void addAnswerToThirdField(String answer){
        addMoreQuestionButton.click();
        thirdAnswerField.clear();
        thirdAnswerField.sendKeys(answer);
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
    public void addQuizWithFirstAnswerIsCorrect(String quizTitle, String questionTitle, String answer1, String answer2){
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
        clickSaveQuizButton();
        Alert alertSaveQuiz = driver.switchTo().alert();
        alertSaveQuiz.accept();
    }
    public String getCreatedQuizTitleText(){
        return checkQuizTitle.getText();
    }
}
