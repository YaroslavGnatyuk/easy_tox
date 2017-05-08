package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DrugListPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL_SHOULD_BE;

    static {
        webConnector = new WebConnector();
        URL_SHOULD_BE = webConnector.getString(WebConnector.myUrl.URL_SIT, "drugListPageUrl");
    }

    public DrugListPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddDrug() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addDrugIcon")).click();
    }

    public boolean isAddDrugModalWindowShowed() throws Throwable {
        waitTime(1000);
        return connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addDrugModalWindow")).isDisplayed();
    }

    public void clickOnSelectCompound() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompounds")).click();
    }

    public void selectCompound(String value) {
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectValuesCompound")))
                .selectByVisibleText(value);
    }

    public void inputName(String name) {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputDrugName")).sendKeys(name);
    }

    public void selectAccessionPrefix(){
        final String accessionPrefix = "Urine";
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAccessionPrefix")))
                .selectByVisibleText(accessionPrefix);
    }

    public List<String> getAllValuesInSelectCompound() throws Throwable {
        waitTime(2000);
        List<WebElement> options = new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectValuesCompound"))).getOptions();
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void submitCreationOfDrug(){
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitFormButton")).click();
    }

    public boolean checkMerssageAfterCreatingDrug(String drug) throws Throwable {
        waitTime(2000);

        final String message = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageAfterCreatingDrug"))
                .getText();
        List<String> wordsFromMessage = Arrays.asList(message.trim().split(" "));
        return wordsFromMessage.contains(drug);
    }
}
