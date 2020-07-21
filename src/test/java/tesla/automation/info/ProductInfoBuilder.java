package tesla.automation.info;

public class ProductInfoBuilder {

    private ProductInfo info;

    private ProductInfoBuilder() {
        info = new ProductInfo();
    }

    public static ProductInfoBuilder getInstance() {
        return new ProductInfoBuilder();
    }

    public ProductInfoBuilder withProductName(String productName) {
        info.productName = productName;
        return this;
    }

    public ProductInfoBuilder withProductPrice(String productPrice) {
        info.productPrice = productPrice;
        return this;
    }

    public ProductInfo build() {
        return info;
    }
}
