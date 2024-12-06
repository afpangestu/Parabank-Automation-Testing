package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By btn_link_register = By.xpath("//a[contains(@href,'register')]");
    By txt_firstname_loc = By.xpath("//input[@id='customer.firstName']");
    By txt_lastname_loc = By.xpath("//input[@id='customer.lastName']");
    By txt_address_loc = By.xpath("//input[@id='customer.address.street']");
    By txt_city_loc = By.xpath("//input[@id='customer.address.city']");
    By txt_state_loc = By.xpath("//input[@id='customer.address.state']");
    By txt_zipcode_loc = By.xpath("//input[@id='customer.address.zipCode']");
    By txt_phone_loc = By.xpath("//input[@id='customer.phoneNumber']");
    By txt_ssn_loc = By.xpath("//input[@id='customer.ssn']");
    By txt_username_loc = By.xpath("//input[@id='customer.username']");
    By txt_password_loc = By.xpath("//input[@id='customer.password']");
    By txt_passconfirm_loc = By.xpath("//input[@id='repeatedPassword']");
    By btn_register_loc = By.xpath("//input[@value='Register']");
    By alert_success_register = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    By alert_username_error = By.xpath("//span[@id='customer.username.errors']");
    By alert_password_error = By.xpath("//span[@id='repeatedPassword.errors']");

    // actions
    public void clickLinkRegister() {
        driver.findElement(btn_link_register).click();
    }

    public void userOnRegisterPage() {
        driver.findElement(By.xpath("//h1[normalize-space()='Signing up is easy!']"));
    }

    public void setFirstNameAndLastName(String firstName, String lastName) {
        driver.findElement(txt_firstname_loc).sendKeys(firstName);
        driver.findElement(txt_lastname_loc).sendKeys(lastName);
    }

    public void userFillAddressDetail(String address,
                                      String city,
                                      String state,
                                      String zipcode,
                                      String phone,
                                      String ssn) {
        driver.findElement(txt_address_loc).sendKeys(address);
        driver.findElement(txt_city_loc).sendKeys(city);
        driver.findElement(txt_state_loc).sendKeys(state);
        driver.findElement(txt_zipcode_loc).sendKeys(zipcode);
        driver.findElement(txt_phone_loc).sendKeys(phone);
        driver.findElement(txt_ssn_loc).sendKeys(ssn);
    }

    public void fillUsernameAndPassword(String username, String password) {
        driver.findElement(txt_username_loc).sendKeys(username);
        driver.findElement(txt_password_loc).sendKeys(password);
    }

    public void userFillPasswordConfirmation(String passConfirm) {
        driver.findElement(txt_passconfirm_loc).sendKeys(passConfirm);
    }

    public void userClickRegisterButton() {
        driver.findElement(btn_register_loc).click();
    }

    public void userVerifyRegister(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        switch (result) {
            case "passed" -> wait.until(
                    ExpectedConditions.visibilityOfElementLocated(alert_success_register)
            );
            case "failed", "user exists" -> wait.until(
                    ExpectedConditions.visibilityOfElementLocated(alert_username_error)
            );
            case "pass missmatch" -> wait.until(
                    ExpectedConditions.visibilityOfElementLocated(alert_password_error)
            );
        }
        driver.quit();
    }
}
