package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TestingProfilePage extends AbstractPage{
    private static final WebConnector webConnector;
    public static final String URL_SHOULD_BE;

    static {
        webConnector = new WebConnector();
        URL_SHOULD_BE = webConnector.getString(WebConnector.myUrl.URL_SIT, "testingProfileUrl");
    }


    public TestingProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddTestingButton() throws Throwable {
        waitTime(1000);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addTestingProfileButton"))
                .click();
    }

    public boolean isAddProfileWindowShowed() throws Throwable {
        waitTime(2000);

        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addProfileWindow"))
                .isDisplayed();
    }

    public void clickOnTestScreenGroupField(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "testScreenGroupButton"))
                .click();
    }

    public void inputValueForSearchingTestScreenGroup(String value) throws Throwable {
        waitTime(500);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "testScreenGroupSearch"))
                .sendKeys(value);
    }

    public String getResultOfSearchingTestScreenGroup(){
        String[] result = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "testScreenGroupResultSearch"))
                .getText().split(",");

        String testScreenGroupName = result[0].trim();
        return testScreenGroupName;
    }

    public void selectResultOfSearchTestScreenGroup(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "testScreenGroupResultSearch"))
                .click();
    }

    public void clearFieldSearchingTestScreenGroup(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "testScreenGroupClearSearch"))
                .click();
    }

    public void clickOnValidityTestGroupField() throws Throwable {
        waitTime(1000);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupButton"))
                .click();
    }

    public void inputValueForSearchingValidityTestGroup(String value) throws Throwable {
        waitTime(500);
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupSearch"))
                .sendKeys(value);
    }

    public String getResultOfSearchingValidityTestGroup(){
        String[] result = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupResultSearch"))
                .getText().split(",");

        String testScreenGroupName = result[0].trim();
        return testScreenGroupName;
    }

    public void selectResultOfSearchValidityTestGroup(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupResultSearch"))
                .click();
    }

    public void clearFieldSearchingValidityTestGroup(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupClearSearch"))
                .click();
    }

    public void inputName(String name){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "profileName"))
                .sendKeys(name);
    }

    public void clickSubmitButton(){
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitCreationOfNewTestingProfile"))
                .click();
    }

    public boolean checkMessageAfterCreatingTestingProfile(String drug) throws Throwable {
        waitTime(2000);

        final String message = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageAfterCreatingTestingProfile"))
                .getText();
        List<String> wordsFromMessage = Arrays.asList(message.trim().split(" "));
        return wordsFromMessage.contains(drug);
    }
}
