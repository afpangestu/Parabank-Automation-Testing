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
import pageobject.RegisterPage;
import util.BaseUtil;

import java.time.Duration;

public class RegisterStep extends BaseUtil {
    WebDriver driver;

    @Given("User is on parabank homepage")
    public void userIsOnParabankHomepage() {
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Register']"))
        );
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLinkRegister();
    }

    @Then("User on register page")
    public void userOnRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userOnRegisterPage();
    }

    @When("User fill first name and last name")
    public void userFillFirstNameAndLastName() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstNameAndLastName("You", "K");
    }

    @And("User fill address detail")
    public void userFillAddressDetail() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userFillAddressDetail(
                "jalan nomor",
                "tjilacap",
                "Central Java",
                "27477",
                "514515",
                "123");
    }

    @And("^User fill (.*) and (.*)$")
    public void userFillUsernameAndPassword(String username, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUsernameAndPassword(username, password);
    }

    @And("User fill password confirmation")
    public void userFillPasswordConfirmation() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userFillPasswordConfirmation("youk456");
    }

    @When("User click register button")
    public void userClickRegisterButton() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userClickRegisterButton();
    }

    @Then("^User verify register (.*)$")
    public void userVerifyRegister(String result) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userVerifyRegister(result);
    }
}
