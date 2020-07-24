package tesla.automation.fragments;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tesla.automation.data.info.ProductInfo;
import tesla.automation.data.info.ProductInfoBuilder;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class ListingProduct {

    private final SelenideElement root;

    public ListingProduct(SelenideElement root) {
        this.root = root;
    }

    public void navigateToPDP() {
        getProductNameElement().click();
    }

    public void quickProductAdd(String size) {
        getProductNameElement().hover();
        getQuickAddBarElement().hover();
        getSizeElement(size).click();
    }

    public ProductInfo getProductInfo() {
        return ProductInfoBuilder.getInstance()
                .withProductName(getProductNameElement().getText())
                .withProductPrice(getPriceElement().getText())
                .build();
    }

    private SelenideElement getProductNameElement() {
        return root.$("div.product-tile__links");
    }

    private SelenideElement getPriceElement() {
        return root.$(" p.product-tile__price");
    }

    private SelenideElement getQuickAddBarElement() {
        return root.$("div.quickadd__with__size__container");
    }

    private List<SelenideElement> getSizeElements() {
        return root.$$("li.size__details");
    }

    private SelenideElement getSizeElement(String size) {
        return getSizeElements()
                .stream()
                .filter(element -> element.getText().equals(size))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Size %s wasn't found", size)));
    }
}
