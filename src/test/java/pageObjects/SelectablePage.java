package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("http://demoqa.com/selectable/")
public class SelectablePage extends PageObject {

    @FindBy(xpath = "//ol[@id='selectable']/li")
    List<WebElementFacade> selectableItems;

    public void select(String itemName) {
        WebElementFacade item = selectableItems.stream()
                .filter(element -> element.getText().contains(itemName))
                .findFirst()
                .get();

        item.click();
    }

    public String getSelectedItemName() {
        WebElementFacade selectedItem = selectableItems.stream()
                .filter(element -> element.getAttribute("class").contains("ui-selected"))
                .findFirst()
                .get();

        return selectedItem.getText();
    }
}
