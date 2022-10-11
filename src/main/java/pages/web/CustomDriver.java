package pages.web;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.webdriver.DefaultDriverFactory;
import com.codeborne.selenide.webdriver.DriverFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;

public class CustomDriver extends DefaultDriverFactory implements DriverFactory {
    @Override
    public void setupWebdriverBinary() {

    }

    @Nonnull
    @Override
    public MutableCapabilities createCapabilities(Config config, Browser browser, @Nullable Proxy proxy, @Nullable File browserDownloadsFolder) {
        return super.createCapabilities(config, browser, proxy, browserDownloadsFolder);
    }

    @Nonnull
    @Override
    public WebDriver create(Config config, Browser browser, @Nullable Proxy proxy, @Nullable File browserDownloadsFolder) {
        WebDriver driver = super.create(config, browser, proxy, browserDownloadsFolder);
        return null;
    }
}
