package bdd.step_definitions;

import com.codecool.pages.LoginPage;
import com.codecool.pages.MyQuizPage;
import com.codecool.pages.QuizPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteQuizStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private QuizPage quizPage;
    private MyQuizPage myQuizPage;
    private final String baseUrl = System.getenv("BASE_URL");
    private final String allQuizUrl = System.getenv("BASE_URL") + "quiz/all";
    private final String myQuizUrl = System.getenv("BASE_URL") + "quiz/my";
    private final String userName = System.getenv("userName");
    private final String password = System.getenv("password");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        quizPage = new QuizPage(driver);
        myQuizPage = new MyQuizPage(driver);
    }

    @Given("I am logged in as quiz master and i create a new quiz with {string} {string} {string} {string}")
    public void i_logged_in_registered_user(String quizTitle, String questionTitle, String answer1, String answer2) {
        driver.get(baseUrl);
        loginPage.handleLogin(userName, password);
        driver.get(allQuizUrl);
        quizPage.addQuizWithFirstAnswerIsCorrect(quizTitle, questionTitle, answer1, answer2);
        System.out.println("Logged in as a quiz master and i create a new quiz");
    }

    @When("I try to delete it")
    public void i_try_to_delete_it(){
        driver.get(myQuizUrl);
        myQuizPage.clickDeleteQuizButton();
        System.out.println("I delete a created quiz");
    }

    @Then("I should see an empty quiz page {string}")
    public void i_should_see_an_empty_quiz_page(String expectedMessage) {
        driver.get(myQuizUrl);
        String actualMessage = myQuizPage.getCheckEmptyQuizAlertText();
        if (expectedMessage.equals(actualMessage)) {
           System.out.println("Test passed: The actual message matches the expected message.");
        } else {
            System.out.println("Test failed: The actual message does not match the expected message.");
            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + actualMessage);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
