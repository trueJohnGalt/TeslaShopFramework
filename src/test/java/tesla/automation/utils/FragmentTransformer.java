package tesla.automation.utils;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FragmentTransformer {

    private final ApplicationContext context;

    @Autowired
    public FragmentTransformer(ApplicationContext context) {
        this.context = context;
    }

    public <T> T getFragment(Class<T> type, SelenideElement element) {
        return getBean(type, element);
    }

    public <T> List<T> getFragments(Class<T> type, List<SelenideElement> elements) {
        return elements.stream().map(argument -> getBean(type, argument)).collect(toList());
    }

    private <T> T getBean(Class<T> type, SelenideElement element) {
        return context.getBean(type, element);
    }
}
