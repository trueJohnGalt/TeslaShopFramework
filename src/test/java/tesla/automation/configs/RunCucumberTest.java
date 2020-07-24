package tesla.automation.configs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "tesla.automation",
        features = "src/test/resources/features",
        plugin = "pretty"
)
public class RunCucumberTest {
}
