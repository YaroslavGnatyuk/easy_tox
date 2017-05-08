package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompoundListPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL_SHOULD_BE;

    static {
        webConnector = new WebConnector();
        URL_SHOULD_BE = webConnector.getString(WebConnector.myUrl.URL_SIT, "compoundPageUrl");
    }

    public CompoundListPage(WebDriver driver) {
        super(driver);
    }

    public void createNewCompound() throws Throwable {
        waitTime(2000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "createNewCompoundIcon")).click();
    }

    public boolean isModalWindowForCreatingNewCompoundShowed() throws Throwable {
        waitTime(1500);
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "modalWindowForCreatingNewCompound"))
                .isDisplayed();
    }

    public void inputNameForNewCompound(String compoundName) throws Throwable {
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputNameOnAddCompound"))
                .sendKeys(compoundName);
    }

    public void selectTypeOfCompound(String type) throws Throwable {
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectTypeOnAddCompound")))
                .selectByVisibleText(type);
    }

    public void inputOtherDataAndSubmitForCompound() throws Throwable {
        final String classOfCompound = "class";
        final String cutoff = "15";
        final String units = "mg/dL";
        final String result = "NEG";
        final String billingCode = "1234567";
        final String oralDetection = "oral detection";
        final String urineDetection = "urine detection";
        final String negativeComment = "negative comment";
        final String positiveComment = "positive comment";

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputClassOnAddCompound"))
                .sendKeys(classOfCompound);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputCutoffOnAddCompound"))
                .sendKeys(cutoff);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUnitOnAddCompound")))
                .selectByVisibleText(units);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectResultOnAddCompound")))
                .selectByVisibleText(result);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputBillingCodeOnAddCompound"))
                .sendKeys(billingCode);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputOralDetectionOnAddCompound"))
                .sendKeys(oralDetection);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputUrineDetectionOnAddCompound"))
                .sendKeys(urineDetection);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputNegativeCommentsOnAddCompound"))
                .sendKeys(negativeComment);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPositiveCommentsOnAddCompound"))
                .sendKeys(positiveComment);

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitCreationCompoundButton"))
                .click();
        waitTime(3000);
    }

    public void inputOtherDataAndSubmitForVCompound() throws Throwable {
        final String classOfCompound = "class";
        final String range = "between";
        final String result = "NORMAL";
        final String billingCode = "1234567";
        final String oralDetection = "oral detection";
        final String urineDetection = "urine detection";
        final String negativeComment = "negative comment";
        final String positiveComment = "positive comment";
        final String units = "mg/dL";
        final String minRange = "10";
        final String maxRange = "20";

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputClassOnAddCompound"))
                .sendKeys(classOfCompound);

        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectRangeOnAddCompound")))
                .selectByVisibleText(range);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectResultOnAddCompound")))
                .selectByVisibleText(result);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputMinRange"))
                .sendKeys(minRange);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputMaxRange"))
                .sendKeys(maxRange);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUnitOnAddVCompound")))
                .selectByVisibleText(units);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputBillingCodeOnAddCompound"))
                .sendKeys(billingCode);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputOralDetectionOnAddCompound"))
                .sendKeys(oralDetection);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputUrineDetectionOnAddCompound"))
                .sendKeys(urineDetection);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputNegativeCommentsOnAddCompound"))
                .sendKeys(negativeComment);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPositiveCommentsOnAddCompound"))
                .sendKeys(positiveComment);

        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitCreationCompoundButton"))
                .click();
        waitTime(3000);
    }

    public boolean isMessageCreateCompoundShowed() throws Throwable {
        waitTime(2000);
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageCompoundWasCreated"))
                .isDisplayed();
    }
}
