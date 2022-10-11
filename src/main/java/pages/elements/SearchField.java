package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import pages.logging.ReporterNG;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchField extends TestElement {

    @Getter
    private SelenideElement searchInput;
    @Getter
    private ElementsCollection resultElements;

    private String base = null;

    public SearchField(String base) {
        this.base = base;
        searchInput = $(new By.ByCssSelector(".CodeMirror-line"));
        resultElements = $$(new By.ByXPath(base + "//*[contains(@class, 'snippetListContainer')]//*[contains(@class, 'snippetItem__content')]/span"));
    }

    public ElementsCollection getSearchResults() {
        ReporterNG.info(String.format("Found %s items", getResultElements().size()));
        return getResultElements();
    }

    public SearchField search(String text) {
        ReporterNG.info(String.format("Try to find %s", text));
        searchInput.setValue(text);
        searchInput.pressEnter();
        return this;
    }

    public List<String> searchAndGetResults(String text) {
        search(text);
        return getSearchResults().texts();
    }

    public SearchField clickOnItem(int numberInList) {
        getResultElements().get(numberInList).click();
        return this;
    }
}
