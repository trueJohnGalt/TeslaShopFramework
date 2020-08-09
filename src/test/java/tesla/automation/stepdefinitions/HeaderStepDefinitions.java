package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.fragments.Header;

public class HeaderStepDefinitions {

    @Autowired
    private Header header;

    @Given("^Guest searches ([\\w]+) from header$")
    public void searchProductFromHomePage(String query) {
        header.searchProduct(query);
    }

    @When("^Guest opens cart from header$")
    public void openCart() {
        header.openCart();
    }

    @When("^Guest clicks on Tesla logo in header$")
    public void clickTeslaLogo() {
        header.clickTeslaLogo();
    }

    @When("^Guest clicks on Shop logo in header$")
    public void clickShopLogo() {
        header.clickShopLogo();
    }

    @When("^Guest clicks on ([\\w]+) category in header$")
    public void clickCategory(String categoryName) {
        header.clickCategory(categoryName);
    }

    @When("^Guest opens ([\\w\\s]+) subcategory of ([\\w\\s]+) category in header$")
    public void openSubcategory(String subcategoryName, String categoryName) {
        header.hoverCategory(categoryName);
        header.clickSubcategory(subcategoryName);
    }

    @When("^Guest clicks on Sign In button in header$")
    public void clickSignInButton() {
        header.clickSignInButton();
    }

    @When("^Guest clicks on Search Loop in header$")
    public void clickSearchLoop() {
        header.clickSearchLoop();
    }

    @Then("^search input field is visible$")
    public void verifySearchInputFieldVisibility() {
        Assertions.assertThat(header.isSearchInputVisible())
                .withFailMessage("Search input field should be visible")
                .isTrue();
    }
}
