package easytox.apptest.pages;

import easytox.apptest.utils.AmountOfRecordsInTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import easytox.apptest.utils.WebConnector;

import java.util.ArrayList;
import java.util.List;

public class LabListPage extends AbstractPage {
    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "labListUrl");
    }

    public LabListPage(WebDriver driver) {
        super(driver);
    }

    public LabListPage NameColumnClick() {
        connector.getWebElement(driver, WebConnector.Identifier.linktext, connector.getString(WebConnector.myUrl.URL_OR, "Namecol")).click();
        return new LabListPage(driver);
    }

    public LabListPage ClickOnPositiveIcon() throws Throwable {

        Thread.sleep(4000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath, connector.getString(WebConnector.myUrl.URL_OR, "PlusIcon")).click();
        Thread.sleep(4000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath, connector.getString(WebConnector.myUrl.URL_OR, "CloseIconInAddLabFrame")).click();
        return new LabListPage(driver);
    }

    public LabListPage EnterSearchCriteria() {
        WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
                connector.getString(WebConnector.myUrl.URL_OR, "SearchButton"));

        WbElm.sendKeys(connector.getString(WebConnector.myUrl.URL_OR, "SearchCriteria"));
        return new LabListPage(driver);
    }

    public void ChangingNumberOfRecordsDisplayedOnPage() {
        driver.findElement(By.name("lablist_length")).click();
        connector.getWebElement(driver, WebConnector.Identifier.name, connector.getString(WebConnector.myUrl.URL_OR, "NoofRecords")).click();
        Select dropdown = new Select(connector.getWebElement(driver,
                WebConnector.Identifier.name,
                connector.getString(WebConnector.myUrl.URL_OR, "NoofRecords")));
        dropdown.selectByVisibleText(connector.getString(WebConnector.myUrl.URL_OR, "RequiredNoofRecords"));
        connector.getWebElement(driver, WebConnector.Identifier.name, connector.getString(WebConnector.myUrl.URL_OR, "NoofRecords")).click();

    }

    public void SortingColumns() throws Throwable {
        connector.getWebElement(driver, WebConnector.Identifier.xpath,
                connector.getString(WebConnector.myUrl.URL_OR, "Sortingarrowhead")).click();
    }

    public void clickOnAddNewLab() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath, connector.getString(WebConnector.myUrl.URL_OR, "PlusIcon")).click();
    }

    public boolean isAddNewLabModalWindowShowed() throws Throwable {
        waitTime(1000);
        return connector.getWebElement(driver, WebConnector.Identifier.css, connector.getString(WebConnector.myUrl.URL_OR, "addLabModalWindow")).isDisplayed();
    }

    public void createNewLab(String labName) throws Throwable {
        waitTime(1000);

        String labDescription = "lab description";
        String labEmail = "gmail@gmail.com";
        String address1 = "address1";
        String address2 = "address2";
        String zipCodeLab = "12345";
        String cityLab =  "city";
        String stateLab = "state";
        String countryLab = "country";

        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputLabName")).sendKeys(labName);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputLabDescription")).sendKeys(labDescription);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputEmailLab")).sendKeys(labEmail);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputAddress1Lab")).sendKeys(address1);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputAddress2Lab")).sendKeys(address2);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputZipCodeLab")).sendKeys(zipCodeLab);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputCityLab")).sendKeys(cityLab);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputStateLab")).sendKeys(stateLab);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "inputCountryLab")).sendKeys(countryLab);
    }

    public void closeAddLabModalWindow(){
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "closeAddLabModalWindow")).click();
    }

    public void submitNewLab(){
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "submitAddNewLab")).click();
    }

    public void inputLabNameIntoSearchField(String labName) throws Throwable {
        waitTime(2000);
        connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "searchFieldForLab")).sendKeys(labName);
    }

    public boolean compareResultOfSearch(String labNameShouldBe){
        String labNameWeHave = connector.getWebElement(driver, WebConnector.Identifier.css,
                connector.getString(WebConnector.myUrl.URL_OR, "searchResultInTableLabsName")).getText();

        return labNameWeHave.equals(labNameShouldBe);
    }

    public void selectAmountOfRecordsInTable(AmountOfRecordsInTable amountOfRecords){
        String value = AmountOfRecordsInTable.getValue(amountOfRecords);
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, connector.getString(WebConnector.myUrl.URL_OR, "selectAmountOfRecordsInTable")))
                .selectByVisibleText(value);
    }

    public void sortDataInTableByDataCreation() throws Throwable {
        waitTime(1000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath,
                connector.getString(WebConnector.myUrl.URL_OR, "sortTableByName")).click();
    }

    public boolean isExistThisLab() throws Throwable {
        waitTime(1000);
        String notExistLabMessage = "No matching records found";
        String currentMessage = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "noMatchingRecordsMessage"))
                .getText();

        return !currentMessage.equals(notExistLabMessage);
    }

    public boolean clickIfWeHaveExactMatchOfTheName(String lab){
        final int columnWithName = 1;
        List<WebElement> labsNamesColumn = connector.getWebElements(driver, WebConnector.Identifier.css,"tr");

        for (int i = 1; i < labsNamesColumn.size(); i++) {
            if (labsNamesColumn.get(i).findElements(By.cssSelector("td")).get(columnWithName).getText().equals(lab)){
                labsNamesColumn.get(i).findElement(By.cssSelector("#editlink")).click();
                return true;
            }
        }

        return false;
    }
}
