package pages.pages;

import org.brewcode.qa.pages.page.BasePage;

public abstract class TestBasePage<T extends BasePage<T>> extends BasePage<T> {

    abstract T getThis();


}
