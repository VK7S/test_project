package pages.pages;

import com.codeborne.selenide.Condition;
import lombok.Getter;
import pages.elements.DocumentFrame;
import pages.elements.SearchField;


public class HomePage extends TestBasePage<HomePage> {

    @Getter
    private String documentId = null;

    @Getter
    private SearchField searchField;
    @Getter
    private DocumentFrame documentFrame;

    public HomePage(String documentId) {
        this.documentId = documentId;
        this.searchField = new SearchField("//*[starts-with(@class, 'statementPanelContainer')]");
        this.documentFrame = new DocumentFrame(documentId);
        searchField.getSearchInput().shouldBe(Condition.visible);
    }


    @Override
    public HomePage getThis() {
        return this;
    }


}
