package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/Register.feature",
        glue = "stepdef",
        tags = "@register",
        plugin = {"io.qase.cucumber7.QaseEventListener", "pretty", "html:src/test/resources/report/register_report.html"}
//        plugin = {"pretty", "html:src/test/resources/report/register_report.html"}
)

public class RegisterRunner extends AbstractTestNGCucumberTests { }
