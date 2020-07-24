package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.pages.ProductDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsPageStepDefinitions extends CucumberStepDefinitions {

    @Autowired
    private ProductDetailsPage productDetailsPage;

    @When("^Guest adds product to cart$")
    public void addProductToCart() {
        productDetailsPage.addProductToCart();
    }

    @When("^Guest selects ([\\w]+) size of product$")
    public void selectProductSize(String size) {
        productDetailsPage.selectSize(size);
    }

    @Then("^product details page with correct product name is opened$")
    public void verifyProductNameOnPDP() {
        String expectedName = storage.getObject("productName", String.class);
        String actualName = productDetailsPage.getProductName();

        assertThat(expectedName.equalsIgnoreCase(actualName))
                .withFailMessage("Incorrect product name is displayed on PDP")
                .isTrue();
    }

    @Then("^size not selected error is displayed$")
    public void verifySelectionErrorIsDisplayed() {
        assertThat(productDetailsPage.isSizeNotSelectedErrorDisplayed())
                .withFailMessage("Selection error should be displayed")
                .isTrue();
    }

    @Then("^cart is opened$")
    public void verifyCartIsOpened() {
        assertThat(productDetailsPage.isCartOpened())
                .withFailMessage("Cart should be open after adding product")
                .isTrue();
    }
}
