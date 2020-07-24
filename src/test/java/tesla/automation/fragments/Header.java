package tesla.automation.fragments;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class Header {

    public void openCart() {
        getCartIcon().click();
    }

    private SelenideElement getCartIcon() {
        return $("label.nav-cart");
    }
}
