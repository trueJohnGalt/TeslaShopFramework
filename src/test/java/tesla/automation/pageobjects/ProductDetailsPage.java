package tesla.automation.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {

    public String getProductName() {
        return getProductNameElement().getText();
    }

    private SelenideElement getProductNameElement() {
        return $("h1.product-title");
    }
}
