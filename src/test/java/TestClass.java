import api.models.Search.SearchResponse;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.pages.HomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class TestClass extends TestsBase {

    String page = "PR-386ea743f2a90399fb0e4300ddf37d0697abc743";

    @Test
    @Description("Try to search in document")
    @Tag("UI")
    public void test() {
        HomePage hp = new HomePage(page);
        open(getConfig().uri + "/doc/" + page);
        List<String> results = hp.getSearchField().searchAndGetResults("'AlphaSense'");
        Assertions.assertEquals(17, results.size(), "Check results count");
        hp.getSearchField().clickOnItem(17);
        String text = hp.getDocumentFrame().getHLText();
        Assertions.assertEquals("Logo - https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg ", text, "Text highlighted in document");
    }


    @Test
    @Description("Check results in search")
    @Tag("API")
    public void searchViaAPI() {
        SearchResponse response = getApi().getPublicDocuments().searchForKeyword("'AlphaSense'", "PR-386ea743f2a90399fb0e4300ddf37d0697abc743");
        Assertions.assertEquals(17, response.getSearchResults().getOriginalStatementCount(), "Check results count");
    }

    @Test
    @Description("Check failed test")
    @Tag("API")
    public void searchViaAPI_fail() {
        SearchResponse response = getApi().getPublicDocuments().searchForKeyword("ᛁᛁalphasenseᛁᛁ", "PR-386ea743f2a90399fb0e4300ddf37d0697abc743");
        Assertions.assertEquals(17, response.getSearchResults().getOriginalStatementCount(), "Check results count");
    }
}
