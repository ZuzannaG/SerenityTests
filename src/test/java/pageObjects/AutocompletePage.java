package pageObjects;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://demoqa.com/autocomplete/")
public class AutocompletePage extends PageObject {

    @FindBy(css="input[id = 'tagss']")
    WebElementFacade inputField;

    @FindBy(css = "li.ui-menu-item")
    List<WebElementFacade> autocompleteList;

    public void insertIntoInputField(String text) {
        inputField.sendKeys(text);
    }

    public String getInputFieldText() {
        return inputField.getAttribute("value");
    }

    public void selectFromAutocompleteList(String value) {
        WebElementFacade foundValue = autocompleteList.stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .get();

        if(foundValue != null)
            foundValue.click();
        else
            throw new NotFoundException("Value was not found on the list");
    }
}
