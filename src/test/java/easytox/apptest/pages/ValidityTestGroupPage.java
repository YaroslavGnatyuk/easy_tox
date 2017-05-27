package easytox.apptest.pages;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidityTestGroupPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL_SHOULD_BE;

    static {
        webConnector = new WebConnector();
        URL_SHOULD_BE = webConnector.getString(WebConnector.myUrl.URL_SIT, "validityTestGroupUrl");
    }


    public ValidityTestGroupPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddValidityGroup() throws Throwable {
        waitTime(2000);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addValidityTestCodeIcon"))
                .click();
    }

    public boolean isAddValidityGroupWindowShowed() throws Throwable {
        waitTime(2000);
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addValidityTestCodeWindow"))
                .isDisplayed();
    }

    public void clickOnSelectCompound() throws Throwable {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompoundField")).click();
    }

    public boolean checkValuesThatPresentInCompound(String value1, String value2) throws Throwable {
        waitTime(1000);
        List<String> values = new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompoundAtValidityTestCode")))
                .getOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        return (values.contains(value1) && values.contains(value2));
    }

    public void inputTestCode(String testCode) {
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputValidityTestCode"))
                .sendKeys(testCode);
    }

    public void inputDescription(String description) {
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputDescriptionValidityTestCode"))
                .sendKeys(description);
    }

    public void chooseCompounds(String value1, String value2) {
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompoundAtValidityTestCode")))
                .selectByVisibleText(value1);

        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompoundAtValidityTestCode")))
                .selectByVisibleText(value2);
    }

    public void submitNewValidityTestCode() {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitValidityTestCodeButton")).click();
    }

    public boolean checkMessage(String newValidityTestCode) throws Throwable {
        waitTime(2000);
        List<String> allMessage = Arrays.asList(connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageAfterCreatingNewValidityTestCode"))
                .getText()
                .trim()
                .split(" "));

        return allMessage.contains(newValidityTestCode);
    }
}
