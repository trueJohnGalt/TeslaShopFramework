package tesla.automation.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;
import tesla.automation.info.ArrowType;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class BestSellersCarousel {

    public void clickOnArrow(ArrowType type) {
        getArrow(type).click();
    }

    public List<String> getVisibleProductNames() {
        return getVisibleCarouselProducts()
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    public void openProductByIndex(int index) {
        getVisibleCarouselProducts().get(index).click();
    }

    public String getProductNameByIndex(int index) {
        return getVisibleCarouselProducts().get(index).getText();
    }

    private SelenideElement getArrow(ArrowType type) {
        return $(String.format("button[class*='slick-%s']", type.value));
    }

    private ElementsCollection getVisibleCarouselProducts() {
        return $$("#category-endless-carousel div.product-tile__item.slick-active");
    }
}
