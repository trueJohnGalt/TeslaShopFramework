package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class ScenarioHooks {

    @Before(order = 1)
    public void maximizeScreen() {
        Configuration.startMaximized = true;
    }

    @Before(order = 2)
    public void openHomePage() {
        open("https://shop.tesla.com");
    }
}
