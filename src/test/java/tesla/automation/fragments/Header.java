package tesla.automation.fragments;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class Header {

    private static Logger log = Logger.getLogger(Header.class);

    public void openCart() {
        getCartIcon().click();
    }

    public void clickTeslaLogo() {
        getTeslaLogo().click();
    }

    public void clickShopLogo() {
        getShopLogo().click();
    }

    public void clickCategory(String categoryName) {
        getCategoryElement(categoryName).click();
    }

    public void hoverCategory(String categoryName) {
        getCategoryElement(categoryName).hover();
    }

    public void clickSubcategory(String subcategoryName) {
        getSubcategoryElement(subcategoryName).click();
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    public void searchProduct(String searchQuery) {
        log.info("Performing search for query: " + searchQuery);
        clickSearchLoop();
        getSearchField().setValue(searchQuery).pressEnter();
    }

    public void clickSearchLoop() {
        getLoopElement().shouldBe(enabled).click();
    }

    public boolean isSearchInputVisible() {
        return getSearchField().is(visible);
    }

    private SelenideElement getCartIcon() {
        return $("label.nav-cart");
    }

    private SelenideElement getTeslaLogo() {
        return $("#tesla-logo");
    }

    private SelenideElement getShopLogo() {
        return $(".tds-header-main--app_title");
    }

    private SelenideElement getCategoryElement(String categoryName) {
        return $$(".tds-header-nav--list_item").findBy(text(categoryName));
    }

    private SelenideElement getSubcategoryElement(String subcategoryName) {
        return $$("h4.sub-nav-title").findBy(text(subcategoryName)).$("a");
    }

    private SelenideElement getSignInButton() {
        return $("a.tds-link_for-login");
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
