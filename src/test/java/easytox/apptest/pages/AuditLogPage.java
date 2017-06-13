package easytox.apptest.pages;

import easytox.apptest.utils.AmountOfRecordsInTable;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


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
        waitTime(100);
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
        waitTime(100);
        final String valueByDefault = "Select User";

        return new Select(
                connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUser")))
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .filter(e -> !e.equals(valueByDefault))
                .collect(Collectors.toList());
    }

    public boolean isPresentedRowWithTitle() throws Throwable {
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

    public boolean isPresentModifiedByColumn() {
        final String titleShouldBe = "Modified By";
        String title = connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "titleOfModifiedByColumn")).getText();

        return title.equals(titleShouldBe);
    }

    public Set<String> getAllDifferentValuesInModifiedByRColumn() throws Throwable {
        waitTime(100);
        int modifiedByColumn = 0;
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));

        return allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(modifiedByColumn).getText()).collect(Collectors.toSet());
    }

    public Set<String> getAllDifferentValuesInLabClientRColumn() throws Throwable {
        int labClientColumn = 1;
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));

        return allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(labClientColumn).getText()).collect(Collectors.toSet());
    }

    public List<String> getAllValuesInDateTimeRColumn() throws Throwable {
        int labDateTimeColumn = 2;
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));

        return allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(labDateTimeColumn).getText()).collect(Collectors.toList());
    }

    public void clickOnSearchButton() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "auditLogSearchButton")).click();
    }

    public void selectLabClient(String labClint) {
        new Select(connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectLabClient")))
                .selectByVisibleText(labClint);
    }

    public void selectUser(String user) {
        new Select(connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectUser")))
                .selectByVisibleText(user);
    }

    public void refreshPage() {
        driver.navigate().to(AuditLogPage.URL);
    }

    public void inputDateFrom(String date) throws Throwable {
        waitTime(100);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputDateFrom")).sendKeys(date);
    }

    public void inputDateTo(String date) {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputDateTo")).sendKeys(date);
    }

    public boolean isAllDatesEqualsToSearchingDate(String date) throws Throwable {
        waitTime(100);
        SimpleDateFormat dateFormatWeInput = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dateFormatFromTable = new SimpleDateFormat("dd/MMM/yyyy");

        Date searchingDate = dateFormatWeInput.parse(date);

        int labDateTimeColumn = 2;
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));
        //We get all dates from table, split them and take first part. After that we add first part to the set.
        Set allDates = allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(labDateTimeColumn).getText().split(" ")[0]).collect(Collectors.toSet());
        //If Set has only one element and this element equals to searching element return true
        return allDates.size() == 1 && searchingDate.equals(dateFormatFromTable.parse((String) allDates.toArray()[0]));
    }

    public void inputTableName(String tableName) throws Throwable {
        waitTime(100);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputTableName"))
                .sendKeys(tableName);
    }

    public Set getAllUniqueValueFromTableAfterSortingByTableName() throws Throwable {
        int tableNameColumn = 3;
        waitTime(100);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));

        return allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(tableNameColumn).getText()).collect(Collectors.toSet());
    }

    public void selectEventType(String eventType) throws Throwable {
        waitTime(100);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectEventType"))
                .sendKeys(eventType);
    }

    public Set getAllUniqueValueFromTableAfterSortingByEventType() throws Throwable {
        int tableNameColumn = 7;
        waitTime(500);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRawPerOnePage")))
                .selectByVisibleText(AmountOfRecordsInTable.getValue(AmountOfRecordsInTable.TWO_HUNDRED));

        List<WebElement> allRows = connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "allRowsWithDataInAuditLogTable"));

        return allRows.stream().map(e -> e.findElements(By.cssSelector("td")).get(tableNameColumn).getText()).collect(Collectors.toSet());
    }

    private List<WebElement> getAllHeadsColumns() {
        return connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "oneOfHeadOfColumn"));
    }

    private void clickOnColumnTitleForSorting(WebElement column) {
        column.click();
    }

    private List<String> getAllValueFromOneColumn(int columnNumber) {
        return connector.getWebElements(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "firstRow"))
                .stream()
                .parallel()
                .map(e -> e.findElements(By.cssSelector("td")).get(columnNumber).getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public void checkBothTypeOfSorting() {
        int columnDateTime = 2;
        int columnWithIPAddress = 8;
        List<WebElement> headsColumns = getAllHeadsColumns();
        for (int i = 0; i < headsColumns.size(); i++) {
            if (i == columnDateTime || i == columnWithIPAddress) continue;

            clickOnColumnTitleForSorting(headsColumns.get(i));

            List<String> columnFromTable = getAllValueFromOneColumn(i);
            List<String> copyColumnFromTable = new ArrayList<>(columnFromTable);
            copyColumnFromTable.sort(Comparator.naturalOrder());

            System.out.println(columnFromTable);
            System.out.println(copyColumnFromTable);

            assertTrue(columnFromTable.equals(copyColumnFromTable));

            clickOnColumnTitleForSorting(headsColumns.get(i));
            columnFromTable = getAllValueFromOneColumn(i);
            copyColumnFromTable = new ArrayList<>(columnFromTable);
            copyColumnFromTable.sort(Comparator.reverseOrder());
            System.out.println(columnFromTable);
            System.out.println(copyColumnFromTable);

            assertTrue(columnFromTable.equals(copyColumnFromTable));
        }
//        headsColumns.forEach(this::clickOnColumnTitleForSorting);
    }


}
