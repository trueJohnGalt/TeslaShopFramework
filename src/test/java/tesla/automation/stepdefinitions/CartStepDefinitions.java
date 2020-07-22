package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import tesla.automation.fragments.Cart;

public class CartStepDefinitions {

    private Cart cart = new Cart();

    @Then("^cart is empty$")
    public void verifyCartIsEmpty() {
        Assertions.assertThat(cart.isCartEmpty())
                .withFailMessage("Basket should be empty")
                .isTrue();
    }
}
