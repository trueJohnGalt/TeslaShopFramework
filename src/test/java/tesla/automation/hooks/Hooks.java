package tesla.automation.hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import tesla.automation.configs.SpringConfig;

import static com.codeborne.selenide.Selenide.open;

@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class Hooks {

    private static Logger log = Logger.getLogger(Hooks.class);

    @Before(order = 0)
    public void setReportsFolder() {
        Configuration.reportsFolder = "target/selenide-reports";
    }

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
