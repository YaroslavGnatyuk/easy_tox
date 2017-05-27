package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

public class PhysicianPage extends AbstractPage{
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "physicianPageUrl");
    }
    public PhysicianPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddPhysician() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath, webConnector.getString(WebConnector.myUrl.URL_OR, "addPhysicianIcon")).click();
        waitTime(1000);
    }
}
