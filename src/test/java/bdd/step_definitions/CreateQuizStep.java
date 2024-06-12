package bdd.step_definitions;

import com.codecool.pages.HomePage;
import com.codecool.pages.LoginPage;
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
    private HomePage homePage;
    private final String baseUrl = System.getenv("BASE_URL");
    private final String allQuizUrl = System.getenv("BASE_URL") + "quiz/all";
    private final String userName = System.getenv("userName");
    private final String password = System.getenv("password");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am logged in as quiz master")
    public void i_logged_in_registered_user() {
        driver.get(baseUrl);
        loginPage.handleLogin(userName, password);
        System.out.println("Logged in as a quiz master");
    }

    @When("I create a quiz with {string} {string} {string} {string}")
    public void i_create_a_quiz_with_quizTitle_questionTitle_answer1_answer2(String username, String password) {
        loginPage.handleLogin(username, password);
        System.out.println("Type in the username and the password");
    }

    @Then("I see the logout {string}")
    public void i_see_the_logout_buttonText(String buttonText) {
        String actualText = homePage.getChooseLogoutButtonText();
        if (buttonText.equals(actualText)) {
            System.out.println("Test passed: The actual text matches the expected text.");
        } else {
            System.out.println("Test failed: The actual text does not match the expected text.");
            System.out.println("Expected: " + buttonText);
            System.out.println("Actual: " + actualText);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}