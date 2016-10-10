package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by testuser on 07/10/16.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(xpath = "//h2[@class='prodtitle']/a")
    List<WebElementFacade> results;

    public List<String> getResultsTitles() {
        return results.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
