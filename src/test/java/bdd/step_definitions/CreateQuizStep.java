package bdd.step_definitions;

import com.codecool.pages.HomePage;
import com.codecool.pages.LoginPage;
import com.codecool.pages.QuizPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateQuizStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private QuizPage quizPage;
    private final String baseUrl = System.getenv("BASE_URL");
    private final String allQuizUrl = System.getenv("BASE_URL") + "quiz/all";
    private final String userName = System.getenv("userName");
    private final String password = System.getenv("password");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        quizPage = new QuizPage(driver);
    }

    @Given("I am logged in as quiz master")
    public void i_logged_in_registered_user() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(399);
        loginPage.handleLogin(userName, password);
        Thread.sleep(399);

        System.out.println("Logged in as a quiz master");
    }

    @When("I create a quiz with {string} {string} {string} {string}")
    public void i_create_a_quiz_with_quizTitle_questionTitle_answer1_answer2(String quizTitle, String questionTitle, String answer1, String answer2) throws InterruptedException {
        driver.get(allQuizUrl);
        quizPage.addQuizWithFirstAnswerIsCorrect(quizTitle, questionTitle, answer1, answer2);
        System.out.println("Create a quiz with first answer correct");
    }

    @Then("I see the {string}")
    public void i_see_the_quizTitle(String expectedQuizTitle) {
        String actualQuizTitle = quizPage.getCreatedQuizTitleText();
        if (expectedQuizTitle.equals(actualQuizTitle)) {
            System.out.println("Test passed: The actual quiz title matches the expected quiz title.");
        } else {
            System.out.println("Test failed: The actual quiz title does not match the expected quiz title.");
            System.out.println("Expected: " + expectedQuizTitle);
            System.out.println("Actual: " + actualQuizTitle);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}