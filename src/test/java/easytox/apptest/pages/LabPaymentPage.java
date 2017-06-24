package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

public class LabPaymentPage extends AbstractPage{
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "labPaymentUrl");
    }

    public LabPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSettingIcon() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath, webConnector.getString(WebConnector.myUrl.URL_OR, "settingIcon")).click();
    }

    public void clickOnUserRef() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext, "User").click();
    }

    public void clickOnPhysicianInc() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext, "Physician").click();
    }

    public void clickOnAuditLogIcon() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext, "Audit Log").click();
    }

    public void clickOnUserLogIcon() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext, "User Log").click();
    }
}
