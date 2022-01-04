package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsMessagesPage {

	
		WebDriver driver;
		WebDriverWait wait;	

		By messageHeader = By.xpath("//*[@id=\"accordion\"]/div/div[1]/h4/a");
		By replyHeader = By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4");
		By messageContent = By.xpath("//*[@id=\"collapse0\"]/div");
		By replyElement = By.xpath("//*[@id=\"collapse0\"]/div");	
		By newMessageContent = By.id("MessageDetails");
		By replyBtn = By.id("btnReply");
		By closeBtn = By.id("btnSave");
		
		public TicketsMessagesPage (WebDriverWait wait, WebDriver driver) {
			
			this.driver = driver;
			this.wait = wait;
			
		}//end constructor
		
		//-------------------
		
		public void clkMessageHeader() {
			
			
			driver.findElement(messageHeader).click();
			
			
		}//clkMessageHeader
		
		//-------------------
		
		public String getMessageDate() {
			
			return driver.findElement(messageHeader).getText();
			
		}//getMessageDate
		
		//------------------ 
		
		public boolean getMessageTextVisabilityState() {
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(messageContent));
			return driver.findElement(messageContent).isDisplayed();
			
		}//getMessageTextVisabilityState
		
	//------------------ 
		
		public String getMessageText() {
			
			return driver.findElement(messageContent).getText();
			
		}//getMessageText
		
	//------------------ 
		
		public void insertNewMessage( String newMessageText) {
			
			 driver.findElement(newMessageContent).sendKeys(newMessageText);;
			
		}//insertNewMessage
		
	//------------------ 
		
		public void clkReply() {
			
			 driver.findElement(replyBtn).click();
			
		}//clkReply
		
		
	//------------------ 
		
		public String getReplyText() {
			clkMessageHeader();
			return driver.findElement(replyElement).getText();
			
		}//getReplyText
		
	//------------------ 
		
		public void clkClose() {
			
			 driver.findElement(closeBtn).click();
			
		}//clkCloseRequest
		
		
		
		
		
}//end TicketsMessagesPage
