package pages.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DocumentFrame extends TestElement {

    private String base = null;

    public DocumentFrame(String base) {
        this.base = base;
    }

    public String getHLText() {
        switchToFrame(base);
        String text = getColoredText("#ffbe00");
        switchToFrame(0);
        return text;
    }

    protected void switchToFrame(int id) {
        switchTo().frame(id);
    }

    protected void switchToFrame(String xpath) {
        switchTo().frame($(new By.ByXPath(String.format("//iframe[@data-id,'%s']", xpath))));
    }

    protected String getColoredText(String color) {
        return $(new By.ByXPath(String.format("//*[contains(@style,'background-color:%s;')]", color))).getText();
    }

}
