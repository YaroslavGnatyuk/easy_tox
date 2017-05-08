package easytox.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import easytox.apptest.utils.WebConnector;

public class LablistPage extends AbstractPage {
	//WebDriver driver;
	
	public LablistPage(WebDriver driver) {
		super(driver);
	}
	
	public LablistPage Name_colu_click(){
		connector.getWebElement(driver, WebConnector.Identifier.linktext,connector.getString(WebConnector.myUrl.URL_OR,"Namecol")).click();
		return new LablistPage(driver);
	}
	
	public LablistPage Clickonpostiveicon() throws Throwable{
		
		Thread.sleep(4000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getString(WebConnector.myUrl.URL_OR,"PlusIcon")).click();
		Thread.sleep(4000);
		//Closing the add lab frame
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getString(WebConnector.myUrl.URL_OR,"CloseIconinAddLabFrame")).click();
		return new LablistPage(driver);
	}
	
	public LablistPage EnterSearchCriteria(){
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getString(WebConnector.myUrl.URL_OR,"SearchButton"));

		WbElm.sendKeys(connector.getString(WebConnector.myUrl.URL_OR,"SearchCriteria"));
		return new LablistPage(driver);
	}
	
	public void ChangingNumberofRecordsDisplayedonPage(){
		driver.findElement(By.name("lablist_length")).click();
		connector.getWebElement(driver, WebConnector.Identifier.name,connector.getString(WebConnector.myUrl.URL_OR,"NoofRecords")).click();
		Select dropdown = new Select(connector.getWebElement(driver, 
								WebConnector.Identifier.name,
								connector.getString(WebConnector.myUrl.URL_OR,"NoofRecords")));
		//RequiredNoofRecords
		dropdown.selectByVisibleText(connector.getString(WebConnector.myUrl.URL_OR,"RequiredNoofRecords"));
		connector.getWebElement(driver, WebConnector.Identifier.name,connector.getString(WebConnector.myUrl.URL_OR,"NoofRecords")).click();
		
	}
	
	public void SortingColumns() throws Throwable{
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getString(WebConnector.myUrl.URL_OR,"Sortingarrowhead")).click();
		
		
	}
	
	
	

}
