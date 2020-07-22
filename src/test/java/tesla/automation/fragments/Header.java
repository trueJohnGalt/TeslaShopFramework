package tesla.automation.fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    public void openCart() {
        getCartIcon().click();
    }

    private SelenideElement getCartIcon() {
        return $("label.nav-cart");
    }
}
