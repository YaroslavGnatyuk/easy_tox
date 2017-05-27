package easytox.apptest.utils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebConnector {
	
	Properties OR=null;
	Properties CONFIG=null;
	Properties SIT_config=null;
	
	public static enum myUrl {
		URL_OR,
		URL_SIT,
		URL_CONFIG
	}
	
	public static enum Identifier{
		id,
		xpath,
		css,
		classname,
		tagname,
		linktext,
		partiallinktext,
		name
		//buttontext,
		//model
	}
	
	
	public WebConnector(){
		
		if(OR==null){
			//Intialise OR
			try{
				OR = new Properties();
				FileInputStream ORinput = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\easytox\\apptest\\config\\OR.properties");
				OR.load(ORinput);
				
				SIT_config = new Properties();
				FileInputStream SITConfiginput = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\easytox\\apptest\\config\\SIT_config.properties");
				SIT_config.load(SITConfiginput);
				
			}catch(Exception e){
				
			}
			
			}	
		
	}
	public String getString(myUrl x , String value){
		String Str = null;
		switch(x)
		{
		case URL_OR:
			Str = OR.getProperty(value);
			break;
		case URL_SIT:
			Str = SIT_config.getProperty(value);
			break;
		/*case URL_CONFIG:
			Str = config.getProperty(value);*/
		default:
				break;
		}
		return Str;
	}
	
	public WebElement getWebElement(WebDriver driver,Identifier identifier,String Expression){
		
		WebElement Webelement= null;
				
		switch(identifier)
		{
		case id:
			Webelement = driver.findElement(By.id(Expression));//.sendKeys("Lab Test");
			break;
		case xpath:
			Webelement = driver.findElement(By.xpath(Expression));
			break;
		case css:
			Webelement = driver.findElement(By.cssSelector(Expression));
			break;
		case classname:
			Webelement = driver.findElement(By.className(Expression));
			break;
		case tagname:
			Webelement = driver.findElement(By.tagName(Expression));
			break;
		case linktext:
			Webelement = driver.findElement(By.linkText(Expression));
			break;
		case partiallinktext:
			Webelement = driver.findElement(By.partialLinkText(Expression));
			break;
		case name:
			Webelement = driver.findElement(By.name(Expression));
		}
		return Webelement;
		
	}

	public List<WebElement> getWebElements(WebDriver driver,Identifier identifier,String Expression){
		List<WebElement> webElements= null;

		switch(identifier)
		{
			case id:
				webElements = driver.findElements(By.id(Expression));//.sendKeys("Lab Test");
				break;
			case xpath:
				webElements = driver.findElements(By.xpath(Expression));
				break;
			case css:
				webElements = driver.findElements(By.cssSelector(Expression));
				break;
			case classname:
				webElements = driver.findElements(By.className(Expression));
				break;
			case tagname:
				webElements = driver.findElements(By.tagName(Expression));
				break;
			case linktext:
				webElements = driver.findElements(By.linkText(Expression));
				break;
			case partiallinktext:
				webElements = driver.findElements(By.partialLinkText(Expression));
				break;
			case name:
				webElements = driver.findElements(By.name(Expression));
		}
		return webElements;
	}
}
