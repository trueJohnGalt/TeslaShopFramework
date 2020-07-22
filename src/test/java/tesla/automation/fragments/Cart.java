package tesla.automation.fragments;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class Cart {

    public boolean isCartEmpty() {
        return getProductsFromCart().isEmpty();
    }

    private ElementsCollection getProductsFromCart() {
        return $$("[data-innerhtml='products'] div.shopcart__product");
    }
}
