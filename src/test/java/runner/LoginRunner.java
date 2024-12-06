package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "stepdef",
        tags = "@login",
        plugin = {"pretty", "html:src/test/resources/report/report.html"}
)

public class LoginRunner {}
