package tesla.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tesla.automation.fragments.ListingProduct;
import tesla.automation.utils.FragmentFactory;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

@Component
public class SearchResultPage {

    @Autowired
    private FragmentFactory fragmentFactory;

    public String getSearchQueryFromSearchResultPage() {
        return getSearchQueryElement().shouldBe(visible).getText();
    }

    public List<String> getProductNames() {
        return getProducts().stream().map(product -> product.getProductInfo().productName).collect(toList());
    }

    public String getSearchErrorMessageText() {
        return getSearchErrorMessageElement().getText();
    }

    private List<ListingProduct> getProducts() {
        return fragmentFactory.getFragments(ListingProduct.class, $$("li.product-tile__item"));
    }

    private SelenideElement getSearchQueryElement() {
        return $(".category__container h2>span");
    }

    private SelenideElement getSearchErrorMessageElement() {
        return $("span.product-tile__list");
    }
}
