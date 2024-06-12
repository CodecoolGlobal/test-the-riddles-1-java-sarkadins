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

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am a registered user")
    public void i_am_a_registered_user() {
        driver.get(baseUrl);
        System.out.println("Registered user");
    }

    @When("I try to login with {string} {string}")
    public void i_try_to_login_with_username_password(String username, String password) {
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