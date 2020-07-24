package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.fragments.BestSellersCarousel;
import tesla.automation.data.enums.ArrowType;
import tesla.automation.pages.HomePage;

import static org.assertj.core.api.Assertions.*;

public class HomePageStepDefinitions extends CucumberStepDefinitions {

    @Autowired
    private HomePage homePage;

    @Given("^Guest searches ([\\w]+) via header$")
    public void searchProductFromHomePage(String query) {
        homePage.searchProduct(query);
    }

    @Given("^Best Sellers Carousel is displayed on Home Page$")
    public void saveInitialProductsInCarousel() {
        storage.saveObject("initialProducts", homePage.getBestSellersCarousel().getVisibleProductNames());
    }

    @When("^Guest clicks on ([\\w]+) arrow in Best Sellers Carousel$")
    public void clickOnArrowInBestSellersCarousel(String type) {
        homePage.getBestSellersCarousel().clickOnArrow(ArrowType.valueOf(type.toUpperCase()));
    }

    @When("^Guest opens ([\\d]+) product from Best Sellers Carousel$")
    public void openProductFromBestSellersCarousel(int number) {
        int index = number - 1;
        BestSellersCarousel carousel = homePage.getBestSellersCarousel();
        String productName = carousel.getProductNameByIndex(index);
        carousel.openProductByIndex(index);

        storage.saveObject("productName", productName);
    }

    @Then("^new products are displayed in Best Sellers Carousel$")
    public void verifyNewProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("New products aren't displayed after click on arrow")
                .isNotEqualTo(storage.getObjects("initialProducts"));
    }

    @Then("^initial products are displayed in Best Sellers Carousel$")
    public void verifyInitialProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("Initial products aren't displayed after click on arrow")
                .isEqualTo(storage.getObjects("initialProducts"));
    }
}
