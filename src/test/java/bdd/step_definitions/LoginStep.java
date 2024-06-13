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

public class LoginStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private final String baseUrl = System.getenv("BASE_URL");

    @Before  // every before creates a webdrver at the start of the test run (cucumber @Before is different from JUnit @Before)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am a registered user")
    public void i_am_a_registered_user() {
        
        System.out.println("Empty step: I am a registered user");
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(baseUrl);
    }

    @When("I try to login with {string} {string}")
    public void i_try_to_login_with_username_password(String username, String password) {
        loginPage.handleLogin(username, password);
        System.out.println("Type in the username and the password");
    }

    @Then("I see the logout button")
    public void i_see_the_logout_buttonText() {
        String actualText = homePage.getChooseLogoutButtonText();
        if (buttonText.equals(actualText)) {
            System.out.println("Test passed: The actual text matches the expected text.");
        } else {
            System.out.println("Test failed: The actual text does not match the expected text.");
            System.out.println("Expected: " + buttonText);
            System.out.println("Actual: " + actualText);
        }
        assertTrue(homePage.isLogoutButtonVisible());
    }

    @Then("I see an error message about the unsuccessful login")
    public void i_see_an_error_message_about_the_unsuccessful_login() {
        assertTrue(loginPage.isErrorMessageVisible());
    }

    @After  // TODO: how is this annotation different from JUnit AfterAll / AfterEach?
    public void tearDown() {
        driver.quit();
    }
}