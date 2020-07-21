package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tesla.automation.info.ArrowType;
import tesla.automation.pageobjects.HomePage;
import tesla.automation.utils.SessionStorage;

import static org.assertj.core.api.Assertions.*;

public class HomePageStepDefinitions {

    private SessionStorage storage = new SessionStorage();

    private HomePage homePage = new HomePage();

    @Given("^Guest searches ([\\w]+) from header$")
    public void searchProductFromHomePage(String query) {
        homePage.searchProduct(query);
    }

    @Given("^Best Sellers Carousel is displayed on Home Page$")
    public void saveInitialProductsInCarousel() {
        storage.storeObject("initialProducts", homePage.getBestSellersCarousel().getVisibleProductNames());
    }

    @When("^Guest clicks on ([\\w]+) arrow in Best Sellers Carousel$")
    public void clickOnArrowInBestSellersCarousel(String type) {
        homePage.getBestSellersCarousel().clickOnArrow(ArrowType.valueOf(type.toUpperCase()));
    }

    @Then("^new products are displayed in Best Sellers Carousel$")
    public void verifyNewProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("New products aren't displayed after click on arrow")
                .isNotEqualTo(storage.getListOfObjects("initialProducts", String.class));
    }

    @Then("^initial products are displayed in Best Sellers Carousel$")
    public void verifyInitialProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("Initial products aren't displayed after click on arrow")
                .isEqualTo(storage.getListOfObjects("initialProducts", String.class));
    }
}
