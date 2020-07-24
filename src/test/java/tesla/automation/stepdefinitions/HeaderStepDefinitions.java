package tesla.automation.stepdefinitions;

import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.fragments.Header;

public class HeaderStepDefinitions {

    @Autowired
    private Header header;

    @When("^Guest opens cart from header$")
    public void openCart() {
        header.openCart();
    }
}
