package easytox.apptest.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.CaseListPage;
import easytox.apptest.pages.CompoundListPage;
import easytox.apptest.pages.DrugListPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DrugLibraryStepsDefentitions {
    WebDriver driver = null;
    LoginPage loginpage;
    WebConnector connector = new WebConnector();
    CaseListPage caseList = null;
    CompoundListPage compoundListPage;
    DrugListPage drugListPage;

    @Given("^the easytox url for drug library$")
    public void theEasyToxUrl() {
        System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        loginpage.navigateToWebApp();
        caseList = new CaseListPage(driver);
        compoundListPage = new CompoundListPage(driver);
        drugListPage = new DrugListPage(driver);
    }

    @And("^I enter username as \"([^\"]*)\" for drug library$")
    public void inputUsername(String username) {
        String forgotpwd = driver.findElement(By.linkText("Click here")).getText();
        assertEquals("Click here", forgotpwd);
        System.out.println(forgotpwd);
        loginpage.EnterUserName(connector.getString(WebConnector.myUrl.URL_SIT, username));
    }

    @And("^I enter password as \"([^\"]*)\" for drug library$")
    public void inputPassword(String password) {
        loginpage.EnterPassword(connector.getString(WebConnector.myUrl.URL_SIT, password));
    }

    @Then("^click on 'Login' button for drug library$")
    public void clickOnLoginButton() {
        loginpage.Loginbuttonclick();

    }

    @When("^Go to Libraries -> Compound Library for drug library scenario 1$")
    public void gotToCompoundLibrary() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundLibraryIcon();
    }

    @Then("^Compound page should be open for drug library scenario 1$")
    public void compoundPageShouldBeOpen(){
        assertTrue(compoundListPage.getCurrentUrl().equals(CompoundListPage.URL_SHOULD_BE));
    }

    @When("^Click 'Create Compound' icon for drug library scenario 1.$")
    public void clickOnCreateCompoundIcon() throws Throwable {
        compoundListPage.createNewCompound();
    }

    @Then("^Add Compound screen should be displayed for drug library scenario 1.$")
    public void checkOpenScreen() throws Throwable {
        assertTrue(compoundListPage.isModalWindowForCreatingNewCompoundShowed());

    }

    @When("^Enter 'Name' as \"([^\"]*)\" for drug library scenario 1,$")
    public void enterName(String name) throws Throwable {
        compoundListPage.inputNameForNewCompound(name);
    }

    @And("^'Type' as \"([^\"]*)\" and for drug library scenario 1$")
    public void enterType(String type) throws Throwable {
        compoundListPage.selectTypeOfCompound(type);
    }

    @And("^enter all the other data and click Submit for drug library scenario 1.$")
    public void enterOtherDataAndSubmit() throws Throwable {
        compoundListPage.inputOtherDataAndSubmitForCompound();
    }

    @Then("^A new Compound 'Compound1' should be created successfully  for drug library scenario 1.$")
    public void newCompoundShouldCreateSuccessfully() throws Throwable {
        assertTrue(compoundListPage.isMessageCreateCompoundShowed());
        driver.close();
    }

    @When("^Go to Libraries -> Compound Library for drug library scenario 2$")
    public void gotToCompoundLibraryVCompound() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundLibraryIcon();
    }

    @Then("^Compound page should be open for drug library scenario 2$")
    public void compoundPageShouldBeOpenVCompound(){
        assertTrue(compoundListPage.getCurrentUrl().equals(CompoundListPage.URL_SHOULD_BE));
    }

    @When("^Click 'Create Compound' icon for drug library scenario 2.$")
    public void clickOnCreateCompoundIconVCompound() throws Throwable {
        compoundListPage.createNewCompound();
    }

    @Then("^Add Compound screen should be displayed for drug library scenario 2.$")
    public void checkOpenScreenVCompound() throws Throwable {
        assertTrue(compoundListPage.isModalWindowForCreatingNewCompoundShowed());

    }

    @When("^Enter 'Name' as \"([^\"]*)\" for drug library scenario 2,$")
    public void enterNameVCompound(String name) throws Throwable {
        compoundListPage.inputNameForNewCompound(name);
    }

    @And("^'Type' as \"([^\"]*)\" and for drug library scenario 2$")
    public void enterTypeVCompound(String type) throws Throwable {
        compoundListPage.selectTypeOfCompound(type);
    }

    @And("^enter all the other data and click Submit for drug library scenario 2.$")
    public void enterOtherDataAndSubmitVCompound() throws Throwable {
        compoundListPage.inputOtherDataAndSubmitForVCompound();
    }

    @Then("^A new Compound 'Compound1' should be created successfully  for drug library scenario 2.$")
    public void newCompoundShouldCreateSuccessfullyVCompound() throws Throwable {
        assertTrue(compoundListPage.isMessageCreateCompoundShowed());
        driver.close();
    }

    @When("^Go to Libraries -> Drug Library 'for drug library scenario 3'$")
    public void goToDrugLibraryPage() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnDrugLibraryIcon();
    }

    @Then("^Drug page should be open 'for drug library scenario 3'$")
    public void checkDrugLibraryPage(){
        String urlShouldBe = DrugListPage.URL_SHOULD_BE;
        assertTrue(urlShouldBe.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Drug' icon 'for drug library scenario 3'.$")
    public void clickAddDrug() throws Throwable {
        drugListPage.clickAddDrug();
    }

    @Then("^Add Drug screen should be displayed for drug library scenario 3.$")
    public void addDrugPopupShouldBeDisplayed() throws Throwable {
        assertTrue(drugListPage.isAddDrugModalWindowShowed());
    }

    @When("^Verify the values displayed in 'Compounds' drop down 'for drug library scenario 3'.$")
    public void verifyValuesInCompounds() throws Throwable {
        drugListPage.clickOnSelectCompound();
    }

    @Then("^Following values should be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 3'$")
    public void checkDisplayedValues(String showedValue1, String showedValue2) throws Throwable {
        List<String> values = drugListPage.getAllValuesInSelectCompound();
        assertTrue(values.contains(showedValue1) && values.contains(showedValue2));
    }

    @When("^Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 3'.$")
    public void checkValuesNotDisplayedInCompounds() throws Throwable {
        drugListPage.clickOnSelectCompound();
    }

    @Then("^Following values should NOT be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 3'$")
    public void checkNotDisplayedValuesInDrugPage(String notshowedValue1, String notShowedValue2) throws Throwable {
        List<String> values = drugListPage.getAllValuesInSelectCompound();
        assertTrue(!values.contains(notshowedValue1) && !values.contains(notShowedValue2));
        driver.close();
    }

    @When("^Go to Libraries -> Drug Library 'for drug library scenario 4'$")
    public void goToDrugLibrary() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnDrugLibraryIcon();
    }

    @Then("^Drug' page should be open 'for drug library scenario 4'$")
    public void checkDrugLibrary() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnDrugLibraryIcon();
    }

    @When("^Click 'Add Drug' icon 'for drug library scenario 4'.$")
    public void clickOnAddNewDrug() throws Throwable {
        drugListPage.clickAddDrug();
    }

    @Then("^Add Drug screen should be displayed 'for drug library scenario 4'.$")
    public void checkPopupAddNewDrug() throws Throwable {
        assertTrue(drugListPage.isAddDrugModalWindowShowed());
    }

    @When("^Enter 'Name' as \"([^\"]*)\", Select \"([^\"]*)\" from the drop down and enter all the other data and click Submit 'for drug library scenario 4'.$")
    public void createNewDrug(String name, String value){
        drugListPage.inputName(name);
        drugListPage.selectAccessionPrefix();
        drugListPage.selectCompound(value);
        drugListPage.submitCreationOfDrug();
    }

    @Then("^A new Drug \"([^\"]*)\" should be created successfully 'for drug library scenario 4'.$")
    public void newDrugCreatedSuccessfully(String drug) throws Throwable {
        drugListPage.checkMerssageAfterCreatingDrug(drug);
    }
}
