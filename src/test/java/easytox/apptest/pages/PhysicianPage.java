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
}
