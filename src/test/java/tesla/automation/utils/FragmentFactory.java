package tesla.automation.utils;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FragmentFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public FragmentFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T getFragment(Class<T> requiredType, SelenideElement constructorArgument) {
        return getBean(requiredType, constructorArgument);
    }

    public <T> List<T> getFragments(Class<T> requiredType, List<SelenideElement> constructorArguments) {
        return constructorArguments
                .stream()
                .map(argument -> getBean(requiredType, argument))
                .collect(toList());
    }

    private <T> T getBean(Class<T> requiredType, SelenideElement constructorArgument) {
        return applicationContext.getBean(requiredType, constructorArgument);
    }
}
