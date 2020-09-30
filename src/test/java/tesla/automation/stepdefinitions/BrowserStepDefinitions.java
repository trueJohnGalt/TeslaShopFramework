package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class BrowserStepDefinitions extends CucumberStepDefinitions{

    @Then("^url contains ([\\w\\W]+)")
    public void verifyUrlContainsDomain(String url) {
        assertThat(url().contains(url))
                .withFailMessage("User was redirected to wrong page")
                .isTrue();
    }
}
