package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;

public class CaseListPage extends AbstractPage{
    public CaseListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLibraryIcon() throws Throwable {
        Thread.sleep(3000);
        connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getString(WebConnector.myUrl.URL_OR,"libraryIcon_xpath")).click();
    }

    public void clickOnCompoundLibraryIcon() throws InterruptedException {
        Thread.sleep(2000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR,"compoundLibraryPage_text")).click();
    }

    public void clickOnDrugLibraryIcon() throws InterruptedException {
        Thread.sleep(2000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR,"drugLibraryText")).click();
    }

    public void clickOnCompoundTestGroup() throws InterruptedException {
        Thread.sleep(2000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR, "compoundTestGroup")).click();
    }

    public void clickOnValidityTestGroup() throws InterruptedException {
        Thread.sleep(2000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR, "validityTestGroupIcon")).click();
    }

    public void clickOnTestingProfile() throws InterruptedException {
        Thread.sleep(2000);
        connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR, "testingProfileIcon")).click();
    }
}
