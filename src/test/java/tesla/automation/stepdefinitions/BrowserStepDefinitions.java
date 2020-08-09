package tesla.automation.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;

public class BrowserStepDefinitions extends CucumberStepDefinitions{

    @Then("^url contains ([\\w\\W]+)")
    public void verifyUrlContainsDomain(String url) {
        assertThat(WebDriverRunner.url().contains(url))
                .withFailMessage("User was redirected to wrong page")
                .isTrue();
    }
}
