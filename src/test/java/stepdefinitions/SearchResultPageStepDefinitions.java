package stepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pageobjects.SearchResultPage;

import static org.assertj.core.api.Assertions.*;

public class SearchResultPageStepDefinitions {

    private SearchResultPage searchResultPage = new SearchResultPage();

    @Then("^([\\w]+) is displayed on search result page$")
    public void verifySearchQueryOnSearchResultPage(String query) {
        assertThat(searchResultPage.getSearchQueryFromSearchResultPage())
                .withFailMessage("Search query isn't displayed")
                .isEqualTo(query);
    }

    @Then("^each product contains ([\\w]+) in product name$")
    public void verifyEachProductContainsQuery(String query) {
        SoftAssertions.assertSoftly(softAssertions -> searchResultPage.getProductNames()
                .forEach(name -> softAssertions.assertThat(name.contains(query))
                        .withFailMessage("Product name doesn't contain query word")
                        .isTrue()));

    }
}
