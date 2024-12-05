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
import pageobject.LoginPage;
import java.time.Duration;


public class LoginStep {
    WebDriver driver;

    @Given("User already on login page")
    public void userAlreadyOnLoginPage() {
        // set driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // maximize browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // get url
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // wait until
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Customer Login']"))
        );
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("usertest123");
        loginPage.setPassword("testpassword");
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
}
