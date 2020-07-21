package tesla.automation.pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import tesla.automation.fragments.BestSellersCarousel;
import tesla.automation.utils.SessionStorage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static Logger log = Logger.getLogger(HomePage.class);

    private BestSellersCarousel bestSellersCarousel = new BestSellersCarousel();

    public void searchProduct(String searchQuery) {
        log.info("Performing search for query: " + searchQuery);
        getLoopElement().shouldBe(enabled).click();
        getSearchField().setValue(searchQuery).pressEnter();
    }

    public BestSellersCarousel getBestSellersCarousel() {
        return bestSellersCarousel;
    }

    private SelenideElement getLoopElement() {
        return getSearchForm().$("i");
    }

    private SelenideElement getSearchField() {
        return getSearchForm().$("input");
    }

    private SelenideElement getSearchForm() {
        return $("form#searchform");
    }
}
