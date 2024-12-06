package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // contructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By txt_username_loc = By.xpath("//input[@name='username']");
    By txt_password_loc = By.xpath("//input[@name='password']");
    By btn_login_loc = By.xpath("//input[@value='Log In']");
    By errorLoginMsg = By.xpath("//p[@class='error']");

    // actions
    public void setUsername(String username) {
        driver.findElement(txt_username_loc).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(txt_password_loc).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login_loc).click();
    }

    public void failedLogin() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorLoginMsg)
        );
        driver.quit();
    }
}
