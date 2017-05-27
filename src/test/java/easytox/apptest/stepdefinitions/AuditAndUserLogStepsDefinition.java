package easytox.apptest.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.*;
import easytox.apptest.utils.AmountOfRecordsInTable;
import easytox.apptest.utils.WebConnector;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuditAndUserLogStepsDefinition {
    private WebDriver driver = null;
    private LoginPage loginpage;
    private WebConnector connector = new WebConnector();

    private LabListPage labListPage;
    private LabEditPage labEditPage;
    private AddLabAdminPage addingLabAdminPage;
    private LabPaymentPage labPaymentPage;
    private LabUsersListPage labUsersListPage;
    private AddLabUserPage addLabUserPage;
    private PhysicianPage physicianPage;
    private AddPhysicianPage addPhysicianPage;
    private AuditLogPage auditLogPage;


    public void theEasyToxUrl() {
        System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        labListPage = new LabListPage(driver);
        labEditPage = new LabEditPage(driver);
        addingLabAdminPage = new AddLabAdminPage(driver);
        labPaymentPage = new LabPaymentPage(driver);
        labUsersListPage = new LabUsersListPage(driver);
        addLabUserPage = new AddLabUserPage(driver);
        physicianPage = new PhysicianPage(driver);
        addPhysicianPage = new AddPhysicianPage(driver);
        auditLogPage = new AuditLogPage(driver);

        loginpage.navigateToWebApp();
    }

    public void inputUsername(String username) {
        String forgotpwd = driver.findElement(By.linkText("Click here")).getText();
        assertEquals("Click here", forgotpwd);
        System.out.println(forgotpwd);
        loginpage.EnterUserName(connector.getString(WebConnector.myUrl.URL_SIT, username));
    }

    public void inputPassword(String password) {
        loginpage.EnterPassword(connector.getString(WebConnector.myUrl.URL_SIT, password));
    }

    public void clickOnLoginButton() {
        loginpage.Loginbuttonclick();
    }

    /**
     * Scenario 1 Create lab
     **/

    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 1'$")
    public void loginToEasyTox_1(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Lab List screen should be displayed 'for audit and user log 1'.$")
    public void checkCurrentPage(){
        String urlShouldBe = LabListPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select 'plus' icon next to search box 'for audit and user log 1'$")
    public void clickOnAddLabIcon() throws Throwable {
        labListPage.clickOnAddNewLab();
    }

    @Then("^Add Lab page should be open 'for audit and user log 1'$")
    public void isAddLabPopupWindowShowed() throws Throwable {
        assertTrue(labListPage.isAddNewLabModalWindowShowed());
    }

    @When("^Enter lab name as \"([^\"]*)\" and enter all the required details and click on 'Submit' 'for audit and user log 1'$")
    public void createNewLab(String labName) throws Throwable {
        labListPage.createNewLab(labName);
        labListPage.submitNewLab();
    }

    @Then("^Added Lab \"([^\"]*)\" should be displayed in the list 'for audit and user log 1'$")
    public void addedLabShouldDisplayedInList(String labName) throws Throwable {
        AmountOfRecordsInTable amount = AmountOfRecordsInTable.ALL;

        labListPage.inputLabNameIntoSearchField(labName);
        labListPage.selectAmountOfRecordsInTable(amount);
        labListPage.sortDataInTableByDataCreation();

        assertTrue(labListPage.compareResultOfSearch(labName));
        labListPage.logout();
    }

    /**
     * Scenario 2 Create Lab Admin
     **/
    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 2'$")
    public void loginToEasyTox_2(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Lab List screen should be displayed 'for audit and user log 2'.$")
    public void currentPageShouldBe_2(){
        String urlShouldBe = LabListPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select \"([^\"]*)\" from the lab list 'for audit and user log 2'.$")
    public void selectCorrectLabFromList(String lab) throws Throwable {
        AmountOfRecordsInTable amount = AmountOfRecordsInTable.ALL;

        labListPage.inputLabNameIntoSearchField(lab);
        if (labListPage.isExistThisLab()) {
            labListPage.selectAmountOfRecordsInTable(amount);
            labListPage.sortDataInTableByDataCreation();

            if (!labListPage.clickIfWeHaveExactMatchOfTheName(lab))
                throw new Exception("lab doesn't exist");
        } else {
            throw new Exception("lab doesn't exist");
        }
    }

    @Then("^Update Lab screen should be displayed 'for audit and user log 2'.$")
    public void updateLabShouldBeShowed() {
        String urlShouldBe = LabEditPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Click 'Add User' icon 'for audit and user log 2'.$")
    public void clickAddUserIcon() throws Throwable {
        labEditPage.clickOnAddLabUser();
    }

    @Then("^Add Lab Admin user screen should be displayed 'for audit and user log 2'.$")
    public void screenAddLAbAdminShouldBeShowed() {
        String urlShouldBe = AddLabAdminPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Enter username and password as \"([^\"]*)\" and \"([^\"]*)\" and all the other required information 'for audit and user log 2'$")
    public void inputUsernameAndPassword(String username, String password) throws Throwable {
        addingLabAdminPage.inputAllValuesForNewLabAdmin(username, password);

    }

    @And("^click 'Add User' 'for audit and user log 2'.$")
    public void clickAddUserButton() {
        addingLabAdminPage.clickAddUserButton();
    }

    @Then("^Lab Admin \"([^\"]*)\" should be created successfully and displayed in User List 'for audit and user log 2'.$")
    public void labAdminShouldBeCreated(String username) throws Throwable {
        assertTrue(addingLabAdminPage.isNewAdminCreated(username));
        addingLabAdminPage.logout();
    }

    /**
     * Scenario 3 Create Lab User
     **/

    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 3'.$")
    public void loginToEasyTox_3(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Case List screen should be displayed 'for audit and user log 3'.$")
    public void checkCurrentPage_3(){
        final String urlShouldBe = LabPaymentPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select Libraries -> User 'for audit and user log 3'.$")
    public void clickOnSettingIcon() throws Throwable {
        labPaymentPage.clickOnSettingIcon();
        labPaymentPage.clickOnUserRef();
    }

    @Then("^User List screen should be displayed 'for audit and user log 3'.$")
    public void shouldBeUsersListPage(){
        final String urlShouldBe = LabUsersListPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Click on 'plus' icon beside Search box 'for audit and user log 3'.$")
    public void clickOnAddLabUserIcon() throws Throwable {
        labUsersListPage.clickOnAddLabUserIcon();
    }

    @Then("^Add a Lab User screen should be displayed 'for audit and user log 3'.$")
    public void addLabUsersPageShouldBe(){
        final String urlShouldBe = AddLabUserPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Enter Username and Password as \"([^\"]*)\" and \"([^\"]*)\" 'for audit and user log 3',$")
    public void inputUsernameAndPasswordForNewUser(String username, String password) throws Throwable {
        addLabUserPage.inputUsernameAndPasswordForNewLabUser(username, password);
    }

    @And("^Role as \"([^\"]*)\" and enter all the other required information 'for audit and user log 3'$")
    public void chooseCorrectRoleAndInputOtherData(String role) throws Throwable {
        addLabUserPage.inputAllValuesAndRoleForNewLabUser(role);
    }

    @And("^click Submit 'for audit and user log 3'.$")
    public void clickAddUser(){
        addLabUserPage.clickAddUserButton();
    }

    @Then("^\"([^\"]*)\" should be added to the user list 'for audit and user log 3'.$")
    public void findNewUserInUsersList(String labUser) throws Throwable {
        assertTrue(addLabUserPage.isNewUserCreated(labUser));
        addLabUserPage.logout();
    }

    /**
     * Scenario 4 Create Lab Client
     **/

    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 4'.$")
    public void loginToEasyTox_4(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Case List screen should be displayed 'for audit and user log 4'.$")
    public void checkCurrentPage_4(){
        final String urlShouldBe = LabPaymentPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select Libraries -> Lab Client 'for audit and user log 4'.$")
    public void selectLabClient(){

    }
    @Then("^LabClient List screen should be displayed 'for audit and user log 4'.$")
    public void labClientListShouldBeDisplayed(){

    }

    @When("^Click on 'plus' icon beside Search box 'for audit and user log 4'.$")
    public void clickOnPlusIcon(){

    }

    @Then("^Add Lab Client screen should be displayed 'for audit and user log 4'.$")
    public void addLabClientPageShouldBeDisplayed(){

    }

    @When("^Enter username and password as \"([^\"]*)\" and \"([^\"]*)\" 'for audit and user log 4'$")
    public void inputUsernameAndPassword_4(String username, String password){

    }

    @And("^Enter all the other required information 'for audit and user log 4'$")
    public void inputAllOtherData(){

    }

    @And("^Click Submit 'for audit and user log 4'.$")
    public void clickOnSubmitAddLabClientButton(){

    }

    @Then("^\"([^\"]*)\" should be added to the LabClient list 'for audit and user log 4'.$")
    public void checkResult(String labClient){

    }

    /**
     * Scenario 5 Create Lab Physician
     **/

    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 5'.$")
    public void loginToEasyTox_5(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Case List screen should be displayed 'for audit and user log 5'.$")
    public void checkCurrentPage_5() throws Throwable {
        labPaymentPage.waitTime(1000);
        final String urlShouldBe = LabPaymentPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select Libraries -> Physician. 'for audit and user log 5'.$")
    public void selectLabPhysician() throws Throwable {
        labPaymentPage.clickOnSettingIcon();
        labPaymentPage.clickOnPhysicianInc();
    }
    @Then("^Physician List screen should be displayed 'for audit and user log 5'.$")
    public void labPhysicianListShouldBeDisplayed(){
        final String urlShouldBe = PhysicianPage.URL;
        assertTrue(physicianPage.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Click on 'plus' icon beside Search box 'for audit and user log 5'.$")
    public void clickOnPlusIconPhysician() throws Throwable {
        physicianPage.clickOnAddPhysician();
    }

    @Then("^Add Physician screen should be displayed 'for audit and user log 5'.$")
    public void addLabPhysicianPageShouldBeDisplayed(){
        String urlShouldBe = AddPhysicianPage.URL;
        assertTrue(addPhysicianPage.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Enter username and password as \"([^\"]*)\" and \"([^\"]*)\" 'for audit and user log 5'$")
    public void inputUsernameAndPasswordForPhysician(String username, String password) throws Throwable {
        addPhysicianPage.inputUsernameAndPassword(username, password);
    }

    @And("^Enter all the other required information 'for audit and user log 5'$")
    public void inputAllOtherDataForPhysician(){
        addPhysicianPage.inputAdditionalData();
    }

    @And("^Click Submit 'for audit and user log 5'.$")
    public void clickOnSubmitAddLabPhysicianButton(){
        addPhysicianPage.clickOnSubmitPhysician();
    }

    @Then("^\"([^\"]*)\" should be added to the LabClient list 'for audit and user log 5'.$")
    public void checkResultAfterAddPhysician(String labPhysician){
        labPaymentPage.logout();
        labPaymentPage.closeDriver();
    }

    /**
     * Scenario 5 Create Lab Physician
     **/

    @When("^Login with \"([^\"]*)\" and \"([^\"]*)\" credentials 'for audit and user log 6'.$")
    public void loginToEasyTox_6(String username, String password){
        theEasyToxUrl();
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Then("^Case List screen should be displayed 'for audit and user log 6'.$")
    public void checkCurrentPage_6() throws Throwable {
        final String urlShouldBe = LabPaymentPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When ("^Select Libraries -> Audit Log 'for audit and user log 6'$")
    public void goToAuditLog() throws Throwable {
        labPaymentPage.clickOnSettingIcon();
        labPaymentPage.clickOnAuditLogIcon();
    }

    @Then("^Audit Log Screen should be displayed 'for audit and user log 6'.$")
    public void auditLogPageShouldBeOpened(){
        String urlShouldBe = AuditLogPage.URL;
        assertTrue(auditLogPage.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Verify the values in \"Lab Client\" drop down 'for audit and user log 6'.$")
    public void clickOnLabClientDropdown(){
        assertTrue(auditLogPage.isPresentedLabClientDropdown());
    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\" values should be displayed 'for audit and user log 6'.$")
    public void checkValueInLabClientDropdown(String value1, String value2) throws Throwable {
        List<String> optionsShouldBe = Arrays.asList(new String[]{value1, value2});
        List<String> optionsWeHave = auditLogPage.getOptionsFromLabClientDropdown();
//        assertTrue(optionsWeHave.containsAll(optionsShouldBe));
        System.out.println(optionsWeHave.toString());
    }

    @When("^Verify for other values in \"lab Client\" drop down 'for audit and user log 6'.$")
    public void clickOnLabClientDropdownAgain(){
        assertTrue(auditLogPage.isPresentedLabClientDropdown());
    }

    @Then("^No other values should be displayed in the Lab Client drop down only \"([^\"]*)\" and \"([^\"]*)\" 'for audit and user log 6'.$")
    public void checkValueInLabClientDropdownShouldNotBe(String value1, String value2) throws Throwable {
        List<String> optionsShouldBe = Arrays.asList(new String[]{value1, value2});
        List<String> optionsWeHave = auditLogPage.getOptionsFromLabClientDropdown();
        optionsWeHave.removeAll(optionsShouldBe);
        assertTrue(optionsWeHave.size() == 0);
        System.out.println(optionsWeHave.toString());
    }

    @When("^Verify the values in \"User\" drop down 'for audit and user log 6'.$")
    public void clickOnUserDropdown(){
        assertTrue(auditLogPage.isPresentedUserDropdown());
    }

    @Then("^\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" values should be displayed in the User drop down 'for audit and user log 6'.$")
    public void checkValueInUserDropdown(String value1,String value2,String value3,String value4) throws Throwable {
        List<String> optionsShouldBe = Arrays.asList(new String[]{value1, value2, value3, value4});
        List<String> optionsWeHave = auditLogPage.getOptionsFromUserDropdown();
//        assertTrue(optionsWeHave.containsAll(optionsShouldBe));
        System.out.println(optionsWeHave.toString());
    }

    @When("^Verify for other values in \"User\" drop down 'for audit and user log 6'.$")
    public void clickOnUserDropdownAgain(){
        assertTrue(auditLogPage.isPresentedUserDropdown());
    }

    @Then("^No other values should be displayed in the User drop down only \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" 'for audit and user log 6'.$")
    public void checkValueInUserDropdownShouldNotBe(String value1,String value2,String value3,String value4) throws Throwable {
        List<String> optionsShouldBe = Arrays.asList(new String[]{value1, value2, value3, value4});
        List<String> optionsWeHave = auditLogPage.getOptionsFromUserDropdown();
        optionsWeHave.removeAll(optionsShouldBe);
//        assertTrue(optionsWeHave.size() == 0);
        System.out.println(optionsWeHave.toString());
    }

    @When("^Verify the columns displayed in the Audit Log 'for audit and user log 6'.$")
    public void verifyAllColumnsDisplayedInTheAuditLog(){
        assertTrue(auditLogPage.isPresentedRowWithTitle());
    }

    @Then("^Following columns should be displayed in Audit Log: \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" 'for audit and user log 6'$")
    public void checkAllTitlesOfTheColumns(String value1,String value2,String value3,String value4,String value5,String value6,String value7,String value8,String value9){
        List<String> titlesShoiuldBe = Arrays.asList(new String[]{value1,value2,value3,value4,value5,value6,value7,value8,value9});
        List<String> titlesWeHave = auditLogPage.getAllTitlesFromAuditLogTAble();
//        assertTrue(titlesWeHave.containsAll(titlesShoiuldBe));
    }

    @When("^Verify the values under \"Modified By\" column 'for audit and user log 6'.$")
    public void verifyValuesUnderModifyBy(){
        assertTrue(auditLogPage.isPresentModifiedByColumn());
    }

    @Then("^Only either of the following values should be displayed under \"Modified By\" column: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\".No other values other than above four should be displayed under \"Modified By\" column 'for audit and user log 6'.$")
    public void underModifyTitleShouldBe(String value1,String value2,String value3,String value4) throws Throwable {
        Set<String> values = auditLogPage.getAllDifferentValuesInModifiedByRColumn();
        System.out.println(values.size());
    }

    @When("^Verify the values under \"Lab\" column 'for audit and user log 6'.$")
    public void verifyValuesUnderLabColumn(){}

    @Then("^Value under \"Lab\" column should be \"([^\"]*)\" always 'for audit and user log 6'.$")
    public void underLabColumnShouldBe(String value){}

    @When("^Verify the values under \"Lab Client\" column 'for audit and user log 6'.$")
    public void verifyValuesUnderLabClientColumn(){}

    @Then("^Value under \"Lab Client\" column should be \"([^\"]*)\" or \"([^\"]*)\" only. No other values should be displayed 'for audit and user log 6'.$")
    public void underLabClientColumnShouldBe(String value1,String value2){}

    @When("^Verify the values under \"Date/Time\" column 'for audit and user log 6'.$")
    public void verifyDateTimeColumn(){}

    @When("^Date and Time of the individual events in the formats \"([^\"]*)\" and \"([^\"]*)\" respectively should be displayed 'for audit and user log 6'.$")
    public void underDateTimeColumnShouldBe(String value1,String value2){
        labPaymentPage.logout();
        labPaymentPage.closeDriver();
    }
}
