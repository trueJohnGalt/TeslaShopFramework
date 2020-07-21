package tesla.automation.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tesla.automation.info.ArrowType;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BestSellersCarousel {

    public void clickOnArrow(ArrowType type) {
        getArrow(type).click();
    }

    public List<String> getVisibleProductNames() {
        return getCarouselProducts()
                .stream()
                .filter(SelenideElement::isDisplayed)
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    public void openProductDetailsPageForProduct(int index) {
        getCarouselProducts().get(index).click();
    }

    private SelenideElement getArrow(ArrowType type) {
        return $(String.format("button[class*='slick-%s']", type.value));
    }

    private ElementsCollection getCarouselProducts() {
        return $$("#category-endless-carousel div.product-tile__item");
    }
}
