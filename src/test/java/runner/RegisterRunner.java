package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Register.feature",
        glue = "stepdef",
        tags = "@register",
        plugin = {"pretty", "html:src/test/resources/report/report.html"}
)

public class RegisterRunner { }
