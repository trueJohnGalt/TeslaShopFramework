package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.fragments.Cart;

public class CartStepDefinitions {

    @Autowired
    private Cart cart;

    @Then("^cart is empty$")
    public void verifyCartIsEmpty() {
        Assertions.assertThat(cart.isCartEmpty())
                .withFailMessage("Basket should be empty")
                .isTrue();
    }
}
