package tesla.automation.utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "tesla.automation",
        features = "src/test/java/tesla/automation/features"
)
public class CucumberRunner {
}
