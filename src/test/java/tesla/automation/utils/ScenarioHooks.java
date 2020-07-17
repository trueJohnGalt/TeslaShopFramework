package tesla.automation.utils;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import tesla.automation.pageobjects.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class ScenarioHooks {

    private static Logger log = Logger.getLogger(ScenarioHooks.class);

    @Before(order = 1)
    public void maximizeScreen() {
        Configuration.startMaximized = true;
    }

    @Before(order = 2)
    public void openHomePage() {
        open("https://shop.tesla.com");
        log.info("Home Page is opened");
    }
}
