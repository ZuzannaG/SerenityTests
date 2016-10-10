package features.steps.serenity;

import net.thucydides.core.annotations.Step;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BuyerSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void searches_for_keyword(String keyword) {
        homePage.searchFor(keyword);
    }

    @Step
    public void should_see_results_summary_containing(String keyword) {
        List<String> resultTitles = searchResultsPage.getResultsTitles();
        resultTitles.stream().forEach(title -> assertThat(title.contains(keyword)));
    }
}
