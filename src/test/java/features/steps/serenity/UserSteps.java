package features.steps.serenity;

import net.thucydides.core.annotations.Step;
import pageObjects.AutocompletePage;
import pageObjects.DatePickerPage;
import pageObjects.SelectablePage;
import pageObjects.SliderPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by testuser on 07/10/16.
 */
public class UserSteps {

    SelectablePage selectablePage;
    SliderPage sliderPage;
    DatePickerPage datePickerPage;
    AutocompletePage autocompletePage;

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

    @Step
    public void opens_slider_page() {
        sliderPage.open();
    }

    @Step
    public void slides_the_slider_by(int offset) {
        sliderPage.slideBy(offset);
    }

    @Step
    public void should_see_the_amount(int amount) {
        assertEquals(sliderPage.getCurrentAmount(), amount);
    }

    @Step
    public void opens_datepicker_page() {
        datePickerPage.open();
    }

    @Step
    public void clicks_on_the_date_input() {
        datePickerPage.clickDateInput();
    }

    @Step
    public void selects(int day) {
        datePickerPage.select(day);
    }

    @Step
    public void should_see_in_the_date_input(int day) {
        Calendar now = Calendar.getInstance();
        String currentMonth = new SimpleDateFormat("MMMM").format(now.getTime());
        String currentYear = String.valueOf(now.get(Calendar.YEAR));

        String[] splitDate = datePickerPage.getDateFromInput().split(" ");
        String displayedMonth = splitDate[0];
        String displayedDayWithComa = splitDate[1];
        String displayedDay = displayedDayWithComa.substring(0, displayedDayWithComa.length() - 1);
        String displayedYear = splitDate[2];

        assertThat(displayedMonth.equals(currentMonth)
        && displayedDay.equals(String.valueOf(day))
        && displayedYear.equals(currentYear));
    }

    @Step
    public void opens_autocomplete_page() {
        autocompletePage.open();
    }

    @Step
    public void inserts_into_the_input_field(String text) {
        autocompletePage.insertIntoInputField(text);
    }

    @Step
    public void clicks_from_the_autocomplete_list(String value) {
        autocompletePage.selectFromAutocompleteList(value);
    }

    @Step
    public void should_see_in_the_input_field(String value) {
        assertEquals(value, autocompletePage.getInputFieldText());
    }
}
