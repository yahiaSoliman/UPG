package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ticketsPage {

	
	WebDriver driver;
	WebDriverWait wait;	
	
		By rotateButton = By.className("rotate");
		By addButton = By.xpath("/html/body/div[2]/div[2]/div/div[4]/a[3]/span");
		By ticketIDfirstRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[2]/b");
		By severityFirstRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[3]");
		By terminalFirstRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[4]");
		By requestFirstRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[6]");
		By merchantNameFirstRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[5]");
		By checkBox = By.xpath("//*[@id=\"d\"]");
		By dateTime = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[1]");
		By closedDate = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[8]");
		By detailsBtn = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[10]/b/a");
		By messageBtn = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[11]/b/a");
		
		
		public ticketsPage(WebDriverWait wait, WebDriver driver) {
			
			this.driver = driver;
			this.wait = wait;
		}//end constructor
		
		//-------------------
		
		public void clkRotateButton() {
			
			driver.findElement(rotateButton).click();
			
		}//clkRotateButton
		
		//-------------------
		
		public void clkAddButton() throws InterruptedException {
			System.out.println(driver.findElement(addButton).isEnabled());
			wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			Thread.sleep(1000);
			System.out.println(driver.findElement(addButton).isEnabled());
			driver.findElement(addButton).click();
			
		}//end clkAddButton
		
		//-------------------
		
		public String getTicketIDofFirstRow() {
			
			return driver.findElement(ticketIDfirstRow).getText();
			
		}//end clkAddButton
		//-------------------
		
		public String getSeverityFirstRow() {
			
			return driver.findElement(severityFirstRow).getText();
			
		}//end getSeverityFirstRow
		
		//-------------------
		
		public String getTerminalFirstRow() {
			
			return driver.findElement(terminalFirstRow).getText();
			
		}//end getTerminalFirstRow
		
		//-------------------
		
		public String getRequestFirstRow() {
			
			return driver.findElement(requestFirstRow).getText();
			
		}//end getRequestFirstRow
		
		//-------------------
		
		public String getMerchantNameFirstRow() {
			
			return driver.findElement(merchantNameFirstRow).getText();
			
		}//end getMerchantNameFirstRow
		
		//-----------------
		
		public String getChcekBoxStatusFirstRow() {
			
			return driver.findElement(checkBox).getAttribute("checked");
			
		}//endgetChcekBoxStatusFirstRow
		
		//-------------------------------
		
		public String getDateTime() {
			
		return driver.findElement(dateTime).getText();
		
		}//getMerchantName
		
		//-------------------------------
		
		public String getClosedDate() {
			
		return driver.findElement(closedDate).getText();
		
		}//getClosedDate
		
		//-------------------------------
		
		public void clickDetails() {
			
		 driver.findElement(detailsBtn).click();;
		
		}//clickDetails
		
		//-------------------------------
		
		public void clickMessages() {
			
		 driver.findElement(messageBtn).click();;
		
		}//clickMessages
		
}
