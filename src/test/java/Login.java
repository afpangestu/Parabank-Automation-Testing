import config.EnvTarget;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends EnvTarget {
    @Test
    public void initLogin() {
        // set driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // maximize browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // get url
        driver.get(baseUrl);
        // init WebDriverWait
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        // wait until the logo loaded and then continue
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='ParaBank']"))
        );
        loginAction();
    }

    public void loginAction() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hahahatest");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("hahahapassword");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        // init WebDriverWait
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        // wait until the logo loaded and then continue
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']"))
        );
        // finish and quit
        driver.quit();
    }
}
