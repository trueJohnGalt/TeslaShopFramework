package tesla.automation.stepdefinitions;

import io.cucumber.java.en.When;
import tesla.automation.fragments.Header;

public class HeaderStepDefinitions {

    private Header header = new Header();

    @When("^Guest opens cart from header$")
    public void openCart() {
        header.openCart();
    }
}
