package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import tesla.automation.pageobjects.HomePage;

public class HomePageStepDefinitions {

    private HomePage homePage = new HomePage();

    @Given("^Guest searches ([\\w]+) from header$")
    public void searchProductFromHomePage(String query) {
        homePage.searchProduct(query);
    }
}
