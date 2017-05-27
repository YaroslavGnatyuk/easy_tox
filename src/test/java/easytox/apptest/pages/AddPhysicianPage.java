package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPhysicianPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "addPhysicianPageUrl");
    }

    public AddPhysicianPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsernameAndPassword(String username, String password) throws Throwable {
        waitTime(1000);
        WebElement checkbox =
                connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "checkboxPortalAccess"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        waitTime(500);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputUsernameForPhysician"))
                .sendKeys(username);

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPasswordForPhysician"))
                .sendKeys(password);
    }

    public void inputAdditionalData(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputFirstNameForPhysician"))
                .sendKeys("first name");

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputMiddleNameForPhysician"))
                .sendKeys("middle name");

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputLastNameForPhysician"))
                .sendKeys("last name");

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputMedicalDegreeForPhysician"))
                .sendKeys("insane dr. House");

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPhoneForPhysician"))
                .sendKeys("1111111111111");

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputEmailForPhysician"))
                .sendKeys("house@gmail.com");

        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectLocationForPhysician"))).selectByIndex(0);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectLabClientForPhysician"))).selectByIndex(0);
    }

    public void clickOnSubmitPhysician(){
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "buttonSubmitPhysician")).click();
    }
}
