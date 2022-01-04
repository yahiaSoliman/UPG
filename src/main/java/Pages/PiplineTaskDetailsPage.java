package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PiplineTaskDetailsPage {
	
WebDriver driver; //chrome driver
	
	By OperationType = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[6]/div/div[2]");
	By ActionType = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[7]/div/div[2]");
	By MerchantName = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[11]/div/div[2]");
	By pipelineID = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/div/div[2]");
	By status = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[5]/div/div[2]");
	By Maker = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[4]/div/div[2]");
	By dateTime = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[3]/div/div[2]");
	
	public PiplineTaskDetailsPage(WebDriver myDriver) {
		
		this.driver = myDriver;
	}//end constructor	

	/*************Methods*************/

	public String getOperationType() {
	
	return driver.findElement(OperationType).getText();
	
	}//getOperationType
	
	/********************************/
	
	public String getActionType() {
		
	return driver.findElement(ActionType).getText();
	
	}//getOperationType
	
	/********************************/
	
	public String getMerchantName() {
		
	return driver.findElement(MerchantName).getText();
	
	}//getMerchantName
	
	/********************************/
	
	public String getpipelineID() {
		
	return driver.findElement(pipelineID).getText();
	
	}//getMerchantName
	
	/********************************/
	
	public String getStatus() {
		
	return driver.findElement(status).getText();
	
	}//getMerchantName
	
	/********************************/
	
	public String getMaker() {
		
	return driver.findElement(Maker).getText();
	
	}//getMerchantName
	
	/********************************/
	
	public String getDateTime() {
		
	return driver.findElement(dateTime).getText();
	
	}//getMerchantName
	
}
