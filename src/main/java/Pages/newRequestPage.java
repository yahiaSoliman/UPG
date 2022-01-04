package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newRequestPage {
	
	WebDriver driver;
	WebDriverWait wait; 
		By sendBtn = By.id("btnSend");
		By detailsError = By.id("customError");
		By detailsTextBox = By.name("details");
		By terminalList = By.id("terminalNodeId");
		By severityList = By.id("servirityId");
		By requestType = By.id("SelectedRequest");
		By confirmMessage = By.id("saveRequestFrm");
		//By confirmMessage = By.xpath("//*[@id=\"saveRequestFrm\"]/h3");
		
		public newRequestPage(WebDriver driver, WebDriverWait wait ) {
			
			this.driver = driver;

		}//end constructor
		
		//-------------------
		
		public void clkSendBtn() {
			
			driver.findElement(sendBtn).click();
			
		}//clkSendBtn
		
		//-------------------
		
		public String getTextOfDetailsError() {
			
			return driver.findElement(detailsError).getText();
			
		}//getTextOf
		
		//-------------------
		
		public void insertDetails(String detailsValue) {
			
			driver.findElement(detailsTextBox).sendKeys(detailsValue);
			
		}//insertDetails
		
		//------------------
		
		public void selectTerminal(String terminaID) {
			
			Select drop1 = new Select(driver.findElement(terminalList));
			drop1.selectByVisibleText(terminaID);
			
		}//end selectTerminal
		
		//------------------
		
		public void selectSeverity(String severityValue) {
			
			Select drop1 = new Select(driver.findElement(severityList));
			drop1.selectByVisibleText(severityValue);
			
		}//end selectTerminal
		
		//------------------
		
		public void selectRequest(String requestTypeValue) {
			
			Select drop1 = new Select(driver.findElement(requestType));
			drop1.selectByVisibleText(requestTypeValue);
			
		}//end selectRequest
		
		//------------------
		
		public String getTextOfConfirmationMessage() {
			
			return driver.findElement(confirmMessage).getText();
			
		}//end selectRequest
		
}
