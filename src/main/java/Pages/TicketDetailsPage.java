package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketDetailsPage {

	WebDriver driver; //chrome driver
	
	By ticketID = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[1]/div/div[2]/label");
	By merchantName = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[2]/div/div[2]/label");
	By requestType = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[3]/div/div[2]/label");
	By requestDate = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[4]/div/div[2]/label");
	By maker = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[5]/div/div[2]/label");
	By severity = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[6]/div/div[2]/label");
	By closeState = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[7]/div/div[2]/label");
	By backBtn = By.id("btnBack");
	/********Constructor*****/
	
	public TicketDetailsPage(WebDriver myDriver) {
		
		this.driver = myDriver;
	}//end constructor	

	//-------------------------------
	
	public String getTicketID() {
		
		return driver.findElement(ticketID).getText();
	
	}//getTicketID
	
	//-------------------------------
	
	public String getMerchantName() {
		
		return driver.findElement(merchantName).getText();
	
	}//getMerchantName
	
	//-------------------------------
	
	public String getRequestType() {
		
		return driver.findElement(requestType).getText();
	
	}//getRequestType
	
	//-------------------------------
	
	public String getRequestDate() {
		
		return driver.findElement(requestDate).getText();
	
	}//getRequestDate
	
	//-------------------------------
	
	public String getMaker() {
		
		return driver.findElement(maker).getText();
	
	}//getMaker
	
	//-------------------------------
	
	public String getSeverity() {
		
		return driver.findElement(severity).getText();
	
	}//getSeverity
	
	//-------------------------------
	
	public String getCloseState() {
		
		return driver.findElement(closeState).getText();
	
	}//getCloseState
	
	//-------------------------------
	
	public void clkBackBtn() {
		
		driver.findElement(backBtn).click();;
	
	}//clkBackBtn
	
	
	
	
	
}// end class
