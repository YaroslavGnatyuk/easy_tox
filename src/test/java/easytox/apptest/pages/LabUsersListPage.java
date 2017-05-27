package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

public class LabUsersListPage extends AbstractPage{
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "labUsersListPageUrl");
    }
    public LabUsersListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLabUserIcon() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addLabUser")).click();
    }
}
