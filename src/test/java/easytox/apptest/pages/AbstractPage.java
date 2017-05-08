package easytox.apptest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import easytox.apptest.utils.WebConnector;

public class AbstractPage {
	
	protected WebDriver driver;
	WebConnector connector = new WebConnector();
	
	public AbstractPage(WebDriver driver){
		this.driver=driver;
	}
	
	public LoginPage navigateToWebApp(){
		
		driver.navigate().to(connector.getString(WebConnector.myUrl.URL_SIT,"LoginURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new LoginPage(driver);
	}
	
	public void closeDriver(){
		driver.quit();
	}

	public void waitTime(int period) throws Throwable{
		Thread.sleep(period);
	}

	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
}
