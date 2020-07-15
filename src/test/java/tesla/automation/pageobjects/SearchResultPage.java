package tesla.automation.pageobjects;

import com.codeborne.selenide.SelenideElement;
import tesla.automation.fragments.ListingProduct;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class SearchResultPage {

    public String getSearchQueryFromSearchResultPage() {
        return getSearchQueryElement().shouldBe(visible).getText();
    }

    public List<ListingProduct> getProducts() {
        return $$("ul.product-tile__list li.product-tile__item")
                .stream()
                .map(ListingProduct::new)
                .collect(toList());
    }

    public List<String> getProductNames() {
        return getProducts().stream().map(product -> product.getProductInfo().productName).collect(toList());
    }

    private SelenideElement getSearchQueryElement() {
        return $(".page h2 span");
    }

}
