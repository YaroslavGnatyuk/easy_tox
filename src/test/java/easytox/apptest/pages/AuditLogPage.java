package easytox.apptest.pages;

import easytox.apptest.utils.AmountOfRecordsInTable;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class AuditLogPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "auditLogUrl");
    }

    public AuditLogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPresentedLabClientDropdown() {
        return connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectLabClient")).isDisplayed();
    }

    public List<String> getOptionsFromLabClientDropdown() throws Throwable {
        final String valueByDefault = "Select Lab Client";
        waitTime(1000);
        return new Select(
                connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectLabClient")))
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .filter(e -> !e.equals(valueByDefault))
                .collect(Collectors.toList());
    }

    public boolean isPresentedUserDropdown() {
        return connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUser")).isDisplayed();
    }

    public List<String> getOptionsFromUserDropdown() throws Throwable {
        waitTime(1000);
        final String valueByDefault = "Select User";

        return new Select(
                connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUser")))
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .filter(e -> !e.equals(valueByDefault))
                .collect(Collectors.toList());
    }

    public boolean isPresentedRowWithTitle() {
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "titleOfAuditLogTable"))
                .isDisplayed();
    }

    public List<String> getAllTitlesFromAuditLogTAble() {
        final String ipAddress = "IP Address";
        return connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "titleOfAuditLogTable"))
                .findElements(By.cssSelector("th"))
                .stream()
                .map(WebElement::getText)
                .filter(e -> !e.equals(ipAddress))
                .collect(Collectors.toList());
    }

    public boolean isPresentModifiedByColumn(){
        final String titleShouldBe= "Modified By";
        String title = connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "titleOfModifiedByColumn")).getText();

        return title.equals(titleShouldBe);
    }

    public Set<String> getAllDifferentValuesInModifiedByRColumn() throws Throwable {
        waitTime(1000);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        return connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR,"allRawWithDataInAuditLogTable"))
                .findElements(By.cssSelector("tr"))
                .stream()
                .map(e->(e.findElements(By.cssSelector("td"))).get(0).getText())
                .collect(Collectors.toSet());
    }
}
