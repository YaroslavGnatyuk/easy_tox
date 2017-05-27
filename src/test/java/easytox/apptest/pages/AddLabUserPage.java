package easytox.apptest.pages;

import easytox.apptest.utils.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class AddLabUserPage extends AbstractPage{

    private static final WebConnector webConnector;
    public static final String URL;

    static {
        webConnector = new WebConnector();
        URL = webConnector.getString(WebConnector.myUrl.URL_SIT, "addLabUsersPageUrl");
    }

    public AddLabUserPage(WebDriver driver) {
        super(driver);
    }


    public void inputUsernameAndPasswordForNewLabUser(String username, String password) throws Throwable {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputUsername")).sendKeys(username);
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPassword")).sendKeys(password);
    }

    public void inputAllValuesAndRoleForNewLabUser(String role) throws Throwable {
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputFirstName")).sendKeys("FirstName");
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputLastName")).sendKeys("LastName");
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputEmail")).sendKeys("gmail@gmail.com");
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "inputPhone")).sendKeys("1111111111111");
        new Select(connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "selectRoleForLabUser"))).selectByVisibleText(role);
    }

    public void clickAddUserButton(){
        connector.getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "submitAdd")).click();
    }

    public boolean isNewUserCreated(String username) throws Throwable {
        waitTime(1000);
        final String firstWord = "User";
        final String secondWord = username;
        final String thirdWord = "Created";
        final String forthWord = "Sucessfully";

        String message = connector
                .getWebElement(driver, WebConnector.Identifier.css, webConnector.getString(WebConnector.myUrl.URL_OR, "messageAfterAddingLab"))
                .getText();

        List<String> allWords = Arrays.asList(message.split(" "));

        return allWords.contains(firstWord) &&
                allWords.contains(secondWord) &&
                allWords.contains(thirdWord) &&
                allWords.contains(forthWord);

    }
}
