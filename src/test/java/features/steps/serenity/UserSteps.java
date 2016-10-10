package features.steps.serenity;

import net.thucydides.core.annotations.Step;
import pageObjects.SelectablePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by testuser on 07/10/16.
 */
public class UserSteps {

    SelectablePage selectablePage;

    @Step
    public void opens_selectable_page() {
        selectablePage.open();
    }

    @Step
    public void selects(String item) {
        selectablePage.select(item);
    }

    @Step
    public void should_see_selected(String item) {
        String selectedItem = selectablePage.getSelectedItemName();
        assertThat(selectedItem.equals(item));
    }

}
