package easytox.apptest.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import easytox.apptest.utils.WebConnector;

public class AbstractPage {
	
	protected WebDriver driver;
	WebConnector connector = new WebConnector();
	
	public AbstractPage(WebDriver driver){
		this.driver=driver;
	}
	
	public LoginPage navigatetowebApp(){
		
		driver.navigate().to(connector.getstring(WebConnector.myUrl.URL_SIT,"LoginURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new LoginPage(driver);
	}
	
	public void closeDriver(){
		driver.quit();
	}

	public void waittime() throws Throwable{
		Thread.sleep(5000);
	}
}
