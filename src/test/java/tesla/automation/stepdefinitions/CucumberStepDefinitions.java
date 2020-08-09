package tesla.automation.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import tesla.automation.utils.StorageSession;

public class CucumberStepDefinitions {

    @Autowired
    protected StorageSession storageSession;
}
