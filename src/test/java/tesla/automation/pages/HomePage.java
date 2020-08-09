package tesla.automation.pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tesla.automation.fragments.BestSellersCarousel;

@Component
public class HomePage {

    @Autowired
    private BestSellersCarousel bestSellersCarousel;

    public BestSellersCarousel getBestSellersCarousel() {
        return bestSellersCarousel;
    }

}
