package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuElements {
	
	WebDriver driver; //chrome driver
	

	
	/*********Elements**********/
	
	By BankManagement = By.linkText("Banks Management");
	By Banks = By.id("IndexBanks");
	By MerchantManagement = By.linkText("Merchants Management");
	By Merchants = By.id("IndexMerchants");
	By TerminalsManagement = By.linkText("Terminal Management");
	By Terminals = By.id("IndexTerminals");
	By ManageUsers = By.id("ViewUsersUser");
	By userRoleButton = By.xpath("/html/body/div[1]/div/div/div[1]/div[3]/ul/li/a");
	By logOut = By.xpath("/html/body/div[1]/div/div/div[1]/div[3]/ul/li/ul/li[2]/a");
	By dateTime = By.id("LoginDateTimeValue");	  
	By ApprovalPipline = By.id("IndexApprovalPipeline");
	By ValueAddedServices = By.id("ValueAddedServicesMerchant");
	By transactionReports = By.id("IndexTransactions");
	By SupportTickets = By.linkText("Support Tickets");
	By bulkMerchants = By.id("BulkMerchantMasterSearchMerchants");
	
	/********Constructor*****/
	
	public SideMenuElements(WebDriver myDriver) {
		
		this.driver = myDriver;
	}//end constructor	
	
	/*************Methods*************/
	
	public void clkBankManagement() {
		
		driver.findElement(BankManagement).click();
		
	}//clkBankManagement
	
	//----------------------------------
	
	public void clkBulkMerchants() {
		
		driver.findElement(bulkMerchants).click();
		
	}//clkBulkMerchants
	
	//----------------------------------
	
	public void clkBanks() {
		
		driver.findElement(Banks).click();
		
	}//end clkBanks
	
	//-----------------------------------
	
	public void clkMerchantsManagement() {
		
		driver.findElement(MerchantManagement).click();
		
	}//clkBankManagement
	
	//----------------------------------
	
	public void clkMerchants() {
		
		driver.findElement(Merchants).click();
		
	}//end clkBanks
	
	//-----------------------------------
	
	public void clkTerminalsManagement() {
		
		driver.findElement(TerminalsManagement).click();
		
	}//clkBankManagement
	
	//----------------------------------
	
	public void clkTerminals() {
		
		driver.findElement(Terminals).click();
		
	}//end clkBanks
	
	
	//----------------------------------
	
	public void clkManageUsers() {
		
		driver.findElement(ManageUsers).click();
		
	}//end clkBanks
	
	//---------------------------------
	
	public void openBankList() throws InterruptedException {
		
		clkBankManagement();
		Thread.sleep(1000);
		clkBanks();
		
	}//end openBankList
	
	
	//-------------------------------
	
	public void clkUserRoleButton() {
		
		driver.findElement(userRoleButton).click();
		
	}//end clkBanks
	
	//-------------------------------
	
	public void clkLogOutButton() {
		
		driver.findElement(logOut).click();
		
	}//end clkBanks
	
	//------------------------------
	
	public void clkApprovalPipline() {
		
		driver.findElement(ApprovalPipline).click();
		
	}//end clkBanks
	
	//-------------------------------
	
	public String getDateTime() {
		
	return driver.findElement(dateTime).getText();
	
	}//getMerchantName

	//-------------------------------
	
	public void signOut() throws InterruptedException {
		
		clkUserRoleButton();
		Thread.sleep(2000);
		clkLogOutButton();
		
	}//end clkBanks
	
	//-------------------------------ValueAddedServices
	
	public void clkValueAddedServices() {
		
		driver.findElement(ValueAddedServices).click();
		
	}//end clkBanks
	
	//-------------------------------ValueAddedServices
	
	public void clkTransactionReport() {
		
		driver.findElement(transactionReports).click();
		
	}//end clkTransactionReport
		
	//-------------------------------SupportTickets
	
	public void clkSupportTickets() {
		
		driver.findElement(SupportTickets).click();
		
	}//end clkTransactionReport	


}//end sysAdminDashboard
