package tesla.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class CategoryPage {

    public String getCategoryTitle() {
        return getCategoryTitleElement().text();
    }

    private SelenideElement getCategoryTitleElement() {
        return $(".category__heading");
    }
}
