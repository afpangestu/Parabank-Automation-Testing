package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.LoginPage;
import util.BaseUtil;

import java.time.Duration;
import java.util.Random;


public class LoginStep extends BaseUtil {
    private static final Logger log = LoggerFactory.getLogger(LoginStep.class);
    WebDriver driver;

    @Given("User already on login page")
    public void userAlreadyOnLoginPage() {
        // set driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // maximize browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // get url
        driver.get(baseUrl);

        // wait until
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Customer Login']"))
        );
    }

    @When("User input username and password")
    public void userInputUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("daftar12");
        loginPage.setPassword("user123");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }

    @Then("User redirected to Account Overview")
    public void userRedirectedToAccountOverview() {
        // wait until
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Accounts Overview']"))
        );
        driver.quit();
    }

    @When("User input invalid username and password")
    public void userInputInvalidUsernameAndPassword() {
        // intiate random number
        Random random = new Random();
        int userRandom = random.nextInt(1000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("user"+userRandom);
        loginPage.setPassword("passR"+userRandom);
    }

    @Then("User failed login and show message error")
    public void userFailedLoginAndShowMessageError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.failedLogin();
    }
}
