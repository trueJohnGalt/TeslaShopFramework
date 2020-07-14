package fragments;

import com.codeborne.selenide.SelenideElement;
import info.ProductInfo;
import info.ProductInfoBuilder;
import info.Size;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ListingProduct {

    private SelenideElement root;

    public ListingProduct(SelenideElement element) {
        root = element;
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
                .withAvailableSizes(getAvailableSizeElements())
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

    private List<Size> getAvailableSizeElements() {
        return getSizeElements()
                .stream()
                .map(size -> Size.valueOf(size.getText()))
                .collect(Collectors.toList());
    }
}
