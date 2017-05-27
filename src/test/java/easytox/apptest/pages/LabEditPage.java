package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

public class LabEditPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "labEditPageUrl");
    }

    public LabEditPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLabUser() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addLabUserIcon")).click();
    }
}
