package tesla.automation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class ProductDetailsPage {

    public String getProductName() {
        return getProductNameElement().getText();
    }

    public void selectSize(String size) {
        getSizeElement(size).click();
    }

    public void addProductToCart() {
        getAddToCartButton().click();
    }

    public boolean isSizeNotSelectedErrorDisplayed() {
        return getSizeNotSelectedErrorElement().isDisplayed();
    }

    public boolean isCartOpened() {
        return getCartElement().isDisplayed();
    }

    private SelenideElement getProductNameElement() {
        return $("h1.product-title");
    }

    private SelenideElement getAddToCartButton() {
        return $("input[value='Add To Cart']").shouldBe(visible);
    }

    private SelenideElement getSizeNotSelectedErrorElement() {
        return $("label.selection-error");
    }

    private SelenideElement getSizeElement(String size) {
        return getAvailableSizeElements()
            .stream()
            .filter(element -> element.getValue().equals(size))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Selected size is out of stock"));
    }

    private ElementsCollection getAvailableSizeElements() {
        return $$("div.desktop-view div.active fieldset.product-size input")
                .excludeWith(attribute("class", "outOfStock"));
    }

    private SelenideElement getCartElement() {
        return $("div.shopcart-modal__overlay");
    }
}
