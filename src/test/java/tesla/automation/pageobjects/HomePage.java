package tesla.automation.pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tesla.automation.fragments.BestSellersCarousel;
import tesla.automation.utils.SessionStorage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class HomePage {

    private static Logger log = Logger.getLogger(HomePage.class);

    @Autowired
    private BestSellersCarousel bestSellersCarousel;

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
