package easytox.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import easytox.apptest.utils.WebConnector;

public class LoginPage extends AbstractPage  {
	
		
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
		
	public LoginPage EnterUserName(String username){
		driver.findElement(By.name(connector.getString(WebConnector.myUrl.URL_OR,"LoginUsername"))).sendKeys(username);
		return new LoginPage(driver);
	}
	
	public LoginPage EnterPassword(String password){
		driver.findElement(By.name(connector.getString(WebConnector.myUrl.URL_OR,"LoginPassword"))).sendKeys(password);
		return new LoginPage(driver);
	}
	
	public void Loginbuttonclick(){
		driver.findElement(By.xpath(connector.getString(WebConnector.myUrl.URL_OR,"LoginButton"))).click();
		
	}

}
