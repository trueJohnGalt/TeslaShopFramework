package tesla.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.pageobjects.SearchResultPage;

import static org.assertj.core.api.Assertions.*;

public class SearchResultPageStepDefinitions extends CucumberStepDefinitions {

    @Autowired
    private SearchResultPage searchResultPage;

    @Then("^([\\w]+) is displayed on search result page$")
    public void verifySearchQueryOnSearchResultPage(String query) {
        assertThat(searchResultPage.getSearchQueryFromSearchResultPage())
                .withFailMessage("Search query isn't displayed")
                .isEqualTo(query);
    }

    @Then("^each product contains ([\\w]+) in product name$")
    public void verifyEachProductContainsQuery(String query) {
        SoftAssertions.assertSoftly(softAssertions -> searchResultPage.getProductNames()
                .forEach(name -> softAssertions.assertThat(StringUtils.containsIgnoreCase(name, query))
                        .withFailMessage("Product name doesn't contain query word")
                        .isTrue()));

    }
}
