import config.EnvTarget;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login extends EnvTarget {
    @Test
    public void main() {
        // set driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // maximize browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // get url
        driver.get(baseUrl);
    }
}
