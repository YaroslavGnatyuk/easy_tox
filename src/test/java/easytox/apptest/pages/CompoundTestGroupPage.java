package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CompoundTestGroupPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL_SHOULD_BE;

    static {
        webConnector = new WebConnector();
        URL_SHOULD_BE = webConnector.getString(WebConnector.myUrl.URL_SIT, "compoundTestGroupPageUrl");
    }

    public CompoundTestGroupPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddTestCodeIcon() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addTestCodeIcon")).click();
    }

    public boolean isAddTestCodeWindowShowed() throws Throwable {
        waitTime(1000);
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "addTestCodeModalWindow"))
                .isDisplayed();
    }

    public void clickOnCompounds() {
        connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "compounds"))
                .click();
    }

    public boolean isCompoundsContainValidValues(String values1, String values2) {
        List<String> values =
                new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "compoundsAllVariants")))
                        .getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        return (values.contains(values1) && values.contains(values2));
    }

    public void inputTestCode(String testCode){
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR,"inputTestCode")).sendKeys(testCode);
    }

    public void selectCompounds(String compound1, String compound2) throws Throwable {
        waitTime(1000);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompound")))
                .selectByVisibleText(compound1);

        waitTime(1000);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectCompound")))
                .selectByVisibleText(compound2);
    }

    public void inputDescription(){
        final String description = "description";
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR,"inputDescription")).sendKeys(description);
    }

    public void clickOnSubmit(){
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR,"submitNewTestCode")).click();
    }

    public boolean checkMessageAfterCreatingTestGroupCode(String testGroupCode) throws Throwable {
        waitTime(2000);

        final String message = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageAfterCreatingNewTestCode"))
                .getText();
        List<String> wordsFromMessage = Arrays.asList(message.trim().split(" "));
        return wordsFromMessage.contains(testGroupCode);
    }
}
