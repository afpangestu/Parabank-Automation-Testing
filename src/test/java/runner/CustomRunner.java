package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@Test
@CucumberOptions(
        features = {"src/test/resources/features/Register.feature", "src/test/resources/features/Login.feature"},
        glue = "stepdef",
        tags = "@register or @login",
        plugin = {"io.qase.cucumber7.QaseEventListener"}
)

public class CustomRunner extends AbstractTestNGCucumberTests { }
