package tesla.automation.stepdefinitions;

import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.pages.CategoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryPageStepDefinitions {

    @Autowired
    private CategoryPage categoryPage;

    @When("^title on category page is ([\\w\\s]+)$")
    public void clickCategory(String categoryTitle) {
        assertThat(categoryPage.getCategoryTitle().equalsIgnoreCase(categoryTitle))
                .withFailMessage("Wrong category title is displayed")
                .isTrue();
    }

}
