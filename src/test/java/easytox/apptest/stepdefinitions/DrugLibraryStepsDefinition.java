package easytox.apptest.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.*;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DrugLibraryStepsDefinition {
    private WebDriver driver = null;
    private LoginPage loginpage;
    private WebConnector connector = new WebConnector();
    private CaseListPage caseList;
    private CompoundListPage compoundListPage;
    private DrugListPage drugListPage;
    private CompoundTestGroupPage compoundTestGroupPage;
    private ValidityTestGroupPage validityTestGroupPage;
    private TestingProfilePage testingProfilePage;

    @Given("^the easytox url for drug library$")
    public void theEasyToxUrl() {
        System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        loginpage.navigateToWebApp();
        caseList = new CaseListPage(driver);
        compoundListPage = new CompoundListPage(driver);
        drugListPage = new DrugListPage(driver);
        compoundTestGroupPage = new CompoundTestGroupPage(driver);
        validityTestGroupPage = new ValidityTestGroupPage(driver);
        testingProfilePage = new TestingProfilePage(driver);
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

    /**
     * Scenario 1 Create a Compound with Type as 'Test Screen'
     **/

    @When("^Go to Libraries -> Compound Library for drug library scenario 1$")
    public void gotToCompoundLibrary() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundLibraryIcon();
    }

    @Then("^Compound page should be open for drug library scenario 1$")
    public void compoundPageShouldBeOpen() {
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

    /**
     * Scenario 2 Create a Compound with Type as 'Validity Testing'
     **/

    @When("^Go to Libraries -> Compound Library for drug library scenario 2$")
    public void gotToCompoundLibraryVCompound() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundLibraryIcon();
    }

    @Then("^Compound page should be open for drug library scenario 2$")
    public void compoundPageShouldBeOpenVCompound() {
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

    /**
     * Scenario 3 While creating a Drug, verify that the Compounds List doesn’t contain Validity Testing Compunds
     **/
    @When("^Go to Libraries -> Drug Library 'for drug library scenario 3'$")
    public void goToDrugLibraryPage() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnDrugLibraryIcon();
    }

    @Then("^Drug page should be open 'for drug library scenario 3'$")
    public void checkDrugLibraryPage() {
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

    /**
     * Scenario 4,5 Create a Drug 'Drug'
     **/

    @When("^Go to Libraries -> Drug Library 'for drug library scenario 4'$")
    public void goToDrugLibrary() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnDrugLibraryIcon();
    }

    @Then("^Drug' page should be open 'for drug library scenario 4'$")
    public void checkDrugLibrary() throws Throwable {
        String urlShouldBe = DrugListPage.URL_SHOULD_BE;
        assertTrue(urlShouldBe.equals(driver.getCurrentUrl()));
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
    public void createNewDrug(String name, String value) {
        drugListPage.inputName(name);
        drugListPage.selectAccessionPrefix();
        drugListPage.selectCompound(value);
        drugListPage.submitCreationOfDrug();
    }

    @Then("^A new Drug \"([^\"]*)\" should be created successfully 'for drug library scenario 4'.$")
    public void newDrugCreatedSuccessfully(String drug) throws Throwable {
        drugListPage.checkMessageAfterCreatingDrug(drug);
        driver.close();
    }

    /**
     * Scenario 5 Validating Compound Test Group
     **/

    @When("^Go to Libraries -> Compound Test Group 'for drug library scenario 5'$")
    public void goToCompoundTestGroup() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundTestGroup();
    }

    @Then("^Test Code' page should be open 'for drug library scenario 5'$")
    public void checkIsThatCompoundTestGroupPage() {
        final String urlShouldBe = CompoundTestGroupPage.URL_SHOULD_BE;
        assertTrue(urlShouldBe.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Test Code' icon 'for drug library scenario 5'.$")
    public void clickOnAddTestCode() throws Throwable {
        compoundTestGroupPage.clickOnAddTestCodeIcon();
    }

    @Then("^Add Test Code screen should be displayed 'for drug library scenario 5'.$")
    public void isWindowAddTestCodeShowed() throws Throwable {
        assertTrue(compoundTestGroupPage.isAddTestCodeWindowShowed());
    }

    @When("^Verify the values displayed in 'Compounds' drop down 'for drug library scenario 5'.$")
    public void verifyTheValuesInCompounds() {
        compoundTestGroupPage.clickOnCompounds();
    }

    @Then("^Following values should be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 5'$")
    public void compareValuesThatWeShouldHave(String compound1, String compound2) {
        boolean isContainValidValues = compoundTestGroupPage.isCompoundsContainValidValues(compound1, compound2);
        assertTrue(isContainValidValues);
    }

    @When("Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 5'.")
    public void verifyTheValuesNotDisplayedInCompound() {
        compoundTestGroupPage.clickOnCompounds();
    }

    @Then("^Following values should NOT be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 5'$")
    public void compareValuesThatWeShouldNotHave(String vcompound1, String vcompound2) {
        boolean isContainInvalidValues = compoundTestGroupPage.isCompoundsContainValidValues(vcompound1, vcompound2);
        assertFalse(isContainInvalidValues);
        driver.close();
    }

    /**
     * Scenario 6 Create a Compound Test Group
     **/

    @When("^Go to Libraries -> Compound Test Group 'for drug library scenario 6'$")
    public void goToCompoundTestGroupPage() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnCompoundTestGroup();
    }

    @Then("^Test Code' page should be open 'for drug library scenario 6'$")
    public void compoundTestGroupPageShouldBeOpened() {
        final String urlShouldBe = CompoundTestGroupPage.URL_SHOULD_BE;
        assertTrue(urlShouldBe.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Test Code' icon 'for drug library scenario 6'.$")
    public void clickAddTestGroupCodeAgain() throws Throwable {
        compoundTestGroupPage.clickOnAddTestCodeIcon();
    }

    @Then("^Add Test Code screen should be displayed 'for drug library scenario 6'.$")
    public void addTestGroupCodeWindowShouldBeOpened() throws Throwable {
        assertTrue(compoundTestGroupPage.isAddTestCodeWindowShowed());
    }

    @When("^Enter 'Test Code' as \"([^\"]*)\" 'for drug library scenario 6',$")
    public void inputTestCode(String testCode) {
        compoundTestGroupPage.inputTestCode(testCode);
    }

    @And("^Select \"([^\"]*)\" and \"([^\"]*)\" from the Compounds drop down and 'for drug library scenario 6'$")
    public void selectCompoundValues(String value1, String value2) throws Throwable {
        compoundTestGroupPage.selectCompounds(value1, value2);
    }

    @And("^enter all the other data and click Submit 'for drug library scenario 6'.$")
    public void inputAllOtherNeededData() {
        compoundTestGroupPage.inputDescription();
        compoundTestGroupPage.clickOnSubmit();
    }

    @Then("^A new Compound \"([^\"]*)\" should be created successfully 'for drug library scenario 6'.$")
    public void checkTheResultOfCreationNewTestGroupCode(String newTestGroupCode) throws Throwable {
        assertTrue(compoundTestGroupPage.checkMessageAfterCreatingTestGroupCode(newTestGroupCode));
        driver.close();
    }

    /**
     * Scenario 7 Validating ValidityTest Group
     **/

    @When("^Go to Libraries -> Validity Test Group 'for drug library scenario 7'$")
    public void gotToValidityTestGroup() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnValidityTestGroup();
    }

    @Then("^Validity Test Code page should be open 'for drug library scenario 7'$")
    public void checkCurrentPage() {
        assertTrue(ValidityTestGroupPage.URL_SHOULD_BE.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Validity Test Code' icon 'for drug library scenario 7'.$")
    public void clickOnAddValidityTestCodeIcon() throws Throwable {
        validityTestGroupPage.clickOnAddValidityGroup();
    }

    @Then("^Add Validity Test Code screen should be displayed 'for drug library scenario 7'.$")
    public void modalWindowAddTestCodeShouldBeShowed() throws Throwable {
        assertTrue(validityTestGroupPage.isAddValidityGroupWindowShowed());
    }

    @When("^Verify the values displayed in 'Compounds' drop down 'for drug library scenario 7'.$")
    public void checkValuesInCompound() throws Throwable {
        validityTestGroupPage.clickOnSelectCompound();
    }

    @Then("^Following values should be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 7'$")
    public void checkValuesThatShouldBeDisplayed(String value1, String value2) throws Throwable {
        boolean isPresent = validityTestGroupPage.checkValuesThatPresentInCompound(value1, value2);
        assertTrue(isPresent);
    }

    @When("^Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 7'.$")
    public void verifyValuesInCompound() throws Throwable {
        validityTestGroupPage.clickOnSelectCompound();
    }

    @Then("Following values should NOT be displayed in 'Compounds' dropdown: \"([^\"]*)\" and \"([^\"]*)\" 'for drug library scenario 7'")
    public void checkValuesThatShouldNotBeDisplayed(String value1, String value2) throws Throwable {
        boolean isNotPresent = validityTestGroupPage.checkValuesThatPresentInCompound(value1, value2);
        assertFalse(isNotPresent);
        driver.close();
    }

    /**
     * Scenario 8 Create a Validity Test Group
     **/

    @When("^Go to Libraries -> Validity Test Group 'for drug library scenario 8'$")
    public void goToValidityTestGroup() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnValidityTestGroup();
    }

    @Then("^Validity Test Code' page should be open 'for drug library scenario 8'$")
    public void currentPageShouldBeValidityTestCode() {
        assertTrue(ValidityTestGroupPage.URL_SHOULD_BE.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Validity Test Code' icon 'for drug library scenario 8'.$")
    public void clickOnAddValidityTestGroup() throws Throwable {
        validityTestGroupPage.clickOnAddValidityGroup();
    }

    @Then("^Add Validity Test Code screen should be displayed 'for drug library scenario 8'.$")
    public void addValidityTestCodeWindowShouldBeShowed() throws Throwable {
        assertTrue(validityTestGroupPage.isAddValidityGroupWindowShowed());
    }

    @When("^Enter 'ValidityTest Code' as \"([^\"]*)\" 'for drug library scenario 8',$")
    public void inputValidityTestCode(String testCode) {
        validityTestGroupPage.inputTestCode(testCode);
    }

    @And("^Select \"([^\"]*)\" and \"([^\"]*)\" from the Compounds drop down and 'for drug library scenario 8'$")
    public void selectCompounds(String value1, String value2) {
        validityTestGroupPage.chooseCompounds(value1, value2);
    }

    @And("enter all the other data and click Submit 'for drug library scenario 8'.")
    public void enterOtherData() {
        final String description = "description";
        validityTestGroupPage.inputDescription(description);
    }

    @Then("^A new Compound \"([^\"]*)\" should be created successfully 'for drug library scenario 8'.$")
    public void newCompoundShouldBeCreated(String newCompound) throws Throwable {
        validityTestGroupPage.submitNewValidityTestCode();
        validityTestGroupPage.checkMessage(newCompound);
        driver.close();
    }

    /**
     * Scenario 9 Validating Testing Profile
     **/

    @When("^Go to Libraries -> Testing Profile 'for drug library scenario 9'$")
    public void goToTestingProfilePage() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnTestingProfile();
    }

    @Then("^Profile page should be open 'for drug library scenario 9'$")
    public void checkProfilePage() throws Throwable {
        caseList.waitTime(2000);
        assertTrue(TestingProfilePage.URL_SHOULD_BE.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Profile' icon 'for drug library scenario 9'.$")
    public void clickOnAddProfile() throws Throwable {
        testingProfilePage.clickAddTestingButton();
    }

    @Then("^Add Profile screen should be displayed 'for drug library scenario 9'.$")
    public void isAddProfileScreenShowed() throws Throwable {
        assertTrue(testingProfilePage.isAddProfileWindowShowed());
    }

    @When("^Verify the values displayed in 'TestScreen Group' drop down 'for drug library scenario 9'.$")
    public void verifyValuesShouldBeInTestScreenGroup() {
        testingProfilePage.clickOnTestScreenGroupField();
    }

    @Then("^Following values should be displayed in 'TestScreen Group' dropdown: \"([^\"]*)\" 'for drug library scenario 9'$")
    public void checkValueShouldBeInDropdown(String value) throws Throwable {
        testingProfilePage.inputValueForSearchingTestScreenGroup(value);
        String resultOfSearching = testingProfilePage.getResultOfSearchingTestScreenGroup();

        assertTrue(resultOfSearching.equals(value));
    }

    @When("^Verify the values NOT displayed in 'TestScreen Group' drop down 'for drug library scenario 9'.$")
    public void verifyValuesShouldNotBeInTestScreenGroup() {
        testingProfilePage.clearFieldSearchingTestScreenGroup();
    }

    @Then("^Following values should NOT be displayed in 'TestScreen Group' dropdown: \"([^\"]*)\" 'for drug library scenario 9'$")
    public void checkValueShouldNotBeInDropdown(String value) throws Throwable {
        testingProfilePage.inputValueForSearchingTestScreenGroup(value);
        String resultOfSearching = testingProfilePage.getResultOfSearchingTestScreenGroup();
        testingProfilePage.clickOnTestScreenGroupField();
        assertFalse(resultOfSearching.equals(value));
    }

    @When("^Verify the values displayed in 'Validity Test Group' drop down 'for drug library scenario 9'.$")
    public void verifyValueShouldBeInValidityTestGroup() throws Throwable {
        testingProfilePage.clickOnValidityTestGroupField();
    }

    @Then("^Following values should be displayed in 'Validity Test  Group' dropdown: \"([^\"]*)\" 'for drug library scenario 9'$")
    public void checkValueShouldBeInValidityTestGroup(String value) throws Throwable {
        testingProfilePage.inputValueForSearchingValidityTestGroup(value);
        String resultOfSearching = testingProfilePage.getResultOfSearchingValidityTestGroup();

        assertTrue(resultOfSearching.equals(value));
    }

    @When("^Verify the values NOT displayed in 'Validity Test  Group' drop down 'for drug library scenario 9'.$")
    public void verifyValueShouldNotBeInValidityTestGroup() throws Throwable {
        testingProfilePage.clearFieldSearchingValidityTestGroup();
    }

    @Then("^Following values should NOT be displayed in 'Validity TestScreen Group' dropdown: \"([^\"]*)\" 'for drug library scenario 9'$")
    public void checkValueShouldNotBeInValidityTestGroup(String value) throws Throwable {
        testingProfilePage.inputValueForSearchingValidityTestGroup(value);
        String resultOfSearching = testingProfilePage.getResultOfSearchingValidityTestGroup();

        assertFalse(resultOfSearching.equals(value));
        driver.close();
    }

    /**
     * Scenario 10 Create a Testing Profile
     **/

    @When("^Go to Libraries -> Testing Profile for drug library scenario 10'$")
    public void goToTestingProfile() throws Throwable {
        caseList.clickOnLibraryIcon();
        caseList.clickOnTestingProfile();
    }

    @Then("^Profile' page should be open for drug library scenario 10'$")
    public void checkTestingProfilePage() {
        assertTrue(TestingProfilePage.URL_SHOULD_BE.equals(driver.getCurrentUrl()));
    }

    @When("^Click 'Add Profile' icon for drug library scenario 10'.$")
    public void clickAddProfile() throws Throwable {
        testingProfilePage.clickAddTestingButton();
    }

    @Then("^Add Profile screen should be displayed for drug library scenario 10'.$")
    public void checkAddProfileWindow() throws Throwable {
        assertTrue(testingProfilePage.isAddProfileWindowShowed());
    }

    @When("^Enter 'Name' as \"([^\"]*)\" for drug library scenario 10'$")
    public void inputName(String name) {
        testingProfilePage.inputName(name);
    }

    @And("^'Test Screen Group' as \"([^\"]*)\" for drug library scenario 10',$")
    public void chooseTestGroup(String testGroup) throws Throwable {
        testingProfilePage.clickOnTestScreenGroupField();
        testingProfilePage.inputValueForSearchingTestScreenGroup(testGroup);
        testingProfilePage.selectResultOfSearchTestScreenGroup();
        testingProfilePage.clickOnTestScreenGroupField();
    }

    @And("^'Validity Test Group' as \"([^\"]*)\" for drug library scenario 10',$")
    public void chooseValidityGroup(String validityTestGroup) throws Throwable {
        testingProfilePage.clickOnValidityTestGroupField();
        testingProfilePage.inputValueForSearchingValidityTestGroup(validityTestGroup);
        testingProfilePage.selectResultOfSearchValidityTestGroup();
        testingProfilePage.clickOnValidityTestGroupField();
    }

    @And("^click Submit for drug library scenario 10'.$")
    public void clickSubmit() {
        testingProfilePage.clickSubmitButton();
    }

    @Then("^A new Test Profile \"([^\"]*)\" should be created successfully for drug library scenario 10'.$")
    public void checkResultOfCreationNewTestProfile(String testingProfileName) throws Throwable {
        testingProfilePage.checkMessageAfterCreatingTestingProfile(testingProfileName);
        driver.close();
    }
}
