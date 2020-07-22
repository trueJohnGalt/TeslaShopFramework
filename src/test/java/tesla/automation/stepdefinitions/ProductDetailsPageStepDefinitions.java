package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import tesla.automation.pageobjects.ProductDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsPageStepDefinitions extends CucumberStepDefinitions {

    private ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("^product details page with correct product name is opened$")
    public void verifyProductNameOnPDP() {
        String expectedName = sessionStorage.getObject("productName", String.class);
        String actualName = productDetailsPage.getProductName();

        assertThat(expectedName.equalsIgnoreCase(actualName))
                .withFailMessage("Incorrect product name is displayed on PDP")
                .isTrue();
    }
}
