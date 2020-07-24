package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.fragments.BestSellersCarousel;
import tesla.automation.info.ArrowType;
import tesla.automation.pageobjects.HomePage;
import tesla.automation.utils.SessionStorage;

import static org.assertj.core.api.Assertions.*;

public class HomePageStepDefinitions extends CucumberStepDefinitions {

    @Autowired
    private HomePage homePage;

    @Given("^Guest searches ([\\w]+) from header$")
    public void searchProductFromHomePage(String query) {
        homePage.searchProduct(query);
    }

    @Given("^Best Sellers Carousel is displayed on Home Page$")
    public void saveInitialProductsInCarousel() {
        sessionStorage.storeObject("initialProducts", homePage.getBestSellersCarousel().getVisibleProductNames());
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

        sessionStorage.storeObject("productName", productName);
    }

    @Then("^new products are displayed in Best Sellers Carousel$")
    public void verifyNewProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("New products aren't displayed after click on arrow")
                .isNotEqualTo(sessionStorage.getListOfObjects("initialProducts", String.class));
    }

    @Then("^initial products are displayed in Best Sellers Carousel$")
    public void verifyInitialProductsAreDisplayedInCarousel() {
        assertThat(homePage.getBestSellersCarousel().getVisibleProductNames())
                .withFailMessage("Initial products aren't displayed after click on arrow")
                .isEqualTo(sessionStorage.getListOfObjects("initialProducts", String.class));
    }
}
