package easytox.apptest.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.*;
import easytox.apptest.utils.AmountOfRecordsInTable;
import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void checkCurrentPage_5(){
        final String urlShouldBe = LabPaymentPage.URL;
        assertTrue(driver.getCurrentUrl().equals(urlShouldBe));
    }

    @When("^Select Libraries -> Physician. 'for audit and user log 5'.$")
    public void selectLabPhysician(){

    }
    @Then("^Physician List screen should be displayed 'for audit and user log 5'.$")
    public void labPhysicianListShouldBeDisplayed(){

    }

    @When("^Click on 'plus' icon beside Search box 'for audit and user log 5'.$")
    public void clickOnPlusIconPhysician(){

    }

    @Then("^Add Physician screen should be displayed 'for audit and user log 5'.$")
    public void addLabPhysicianPageShouldBeDisplayed(){

    }

    @When("^Enter username and password as \"([^\"]*)\" and \"([^\"]*)\" 'for audit and user log 5'$")
    public void inputUsernameAndPassword_5(String username, String password){

    }

    @And("^Enter all the other required information 'for audit and user log 5'$")
    public void inputAllOtherDataForPhysician(){

    }

    @And("^Click Submit 'for audit and user log 5'.$")
    public void clickOnSubmitAddLabPhysicianButton(){

    }

    @Then("^\"([^\"]*)\" should be added to the LabClient list 'for audit and user log 5'.$")
    public void checkResultAfterAddPhysician(String labPhysician){

    }
}
