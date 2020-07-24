package tesla.automation.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.utils.SessionStorage;

public class CucumberStepDefinitions {

    @Autowired
    protected SessionStorage sessionStorage;
}
