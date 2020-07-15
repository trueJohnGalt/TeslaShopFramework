package tesla.automation.pageobjects;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public void searchProduct(String searchQuery) {
        getLoopElement().shouldBe(enabled).click();
        getSearchField().setValue(searchQuery).pressEnter();
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
