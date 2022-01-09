

/*
 * This class verify Create, edit, delete, view terminals, and view details
 * 
 * Preconditions
 * External UPG URL
 * 
 */
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.MerchantsListPage;
import Pages.NewMerchantPage;
import Pages.SideMenuElements;
import Pages.detailsPage;
import Pages.loginPage;
import Pages.terminalsListPage;
import Pages.ApprovalPipleLinePAge;

public class MerchantsList {
	
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	JavascriptExecutor js;
	WebDriverWait wait;
	
	String BankMerchantsAdminUserName = "ysaBMA1";
	String BankMerchantsAdminPasswsord = "P@ssw0rd";
	
	String bankSupervisorUsername = "ysaBAdS";
    String bankSupervisorPassword = "P@ssw0rd";
	
	loginPage lgnPgElmnts; 
	SideMenuElements systemAdminMenu;
	MerchantsListPage mechListPg;
	NewMerchantPage newMerchPgObj; 
	ApprovalPipleLinePAge ApprovalPipleLinePge;
	detailsPage detailsPge;
	terminalsListPage terminalsListPge;
	
	//-------merchant data
	String merchantName = "test50";
	String categoryName = "1520-General Contractors";
	String city = "Alexandria";
	String address = "ABC";
	String mobileNumber = "01097508504";
	String accountType = "SVA";
	
	//----Credentials
	String fullName = "fullNameTest00";
	String userEmail = "masryegyptian92@gmail.com";
	String notMethod = "Email";
	String loginMethod = "UPG Merchant ID";
	
	@BeforeClass
	public void MethodSetup() {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
		wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://41.32.119.56:1004/Portal/Account/Login");
		
		lgnPgElmnts = new loginPage(driver, wait);
		systemAdminMenu = new SideMenuElements(driver);
		mechListPg = new MerchantsListPage(wait,driver);
		js = (JavascriptExecutor) driver;
		newMerchPgObj = new NewMerchantPage(driver, wait);
		ApprovalPipleLinePge = new ApprovalPipleLinePAge(driver, wait);
		detailsPge = new detailsPage(driver);
		terminalsListPge = new terminalsListPage(driver, wait);
		
	}// end setup method

	@AfterMethod
	public void closwWindnow() throws InterruptedException {
		systemAdminMenu.signOut();
		
		
	}// end after method
	
	//-------------------------------------create merchant
	
	@Test(priority = 1, enabled = true)
	public void createMerchant() throws InterruptedException {
		
		
	
		
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
	
		//open merchant list
		openMerchantsList();
		
	
		//open new merchant page
		mechListPg.clkRotateButton(); 
		
		mechListPg.clkAddButton();
		
		//insert merchant data
		
		newMerchPgObj.insertMerchantName(merchantName);
		newMerchPgObj.insertCategoryName(categoryName);
		newMerchPgObj.insertCityName(city);
		newMerchPgObj.insertAddress(address);
		
		
		js.executeScript("window.scrollBy(0,500)"); //scroll down
		

		newMerchPgObj.insertMobile(mobileNumber);
		newMerchPgObj.clkRefundCheckBox();
		newMerchPgObj.clkAccountType();
		newMerchPgObj.selectAccountType(accountType);
		
		js.executeScript("window.scrollBy(0,2200)"); //scroll down
	
		//Configure Credentials

		newMerchPgObj.insertMerchantFullName(fullName);
		newMerchPgObj.insertMerchantUserEmail(userEmail);
		newMerchPgObj.clkloginMethod();
		newMerchPgObj.selectloginMethod(loginMethod);
		newMerchPgObj.clkNotificationMethod();
		newMerchPgObj.selectNotificationMethod(notMethod);
		
		//scroll down
		js.executeScript("window.scrollBy(0,100)");
		
		
		//Click Save button
		newMerchPgObj.clkSave();
		
		//sign out bank merchants admin
		systemAdminMenu.signOut();

		//approve the creation
		approve();
		
		systemAdminMenu.signOut();
		//sign in as bank merchants administrator
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		
		systemAdminMenu.clkMerchantsManagement();
		//Thread.sleep(1000);
		systemAdminMenu.clkMerchants();
		
		//Validate
		String merchantName1stRow =  mechListPg.getmerchantName1stRow();
		System.out.println(merchantName1stRow);
		assertEquals(merchantName1stRow, merchantName);

		
		
	}//end createMerchant
	
	//-------------------------------------edit details
	
	@Test(priority = 2, enabled = true)
	public void viewDetails() throws InterruptedException {
		
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		Thread.sleep(1000);
	
		/****open merchant list****/
		openMerchantsList();
		
		//get the merchant name of the first row
		String merchantName1stRow =  mechListPg.getmerchantName1stRow();
		
		//click details button
		mechListPg.clkDetailsButton();
		//Thread.sleep(2000);
		
		//get the merchant name in the details page
		String merchantNameOfDetailsPage  = detailsPge.getMerchantName();	
		
		assertEquals(merchantName1stRow, merchantNameOfDetailsPage);	
		
	}//viewDetails
	
	//-------------------------------------view Terminals
	
	@Test(priority = 3, enabled = true)
	public void viewTerminals() throws InterruptedException {
		
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		//Thread.sleep(1000);
	
		//open terminals list
		systemAdminMenu.clkTerminalsManagement();;
		//Thread.sleep(1000);
		systemAdminMenu.clkTerminals();
		//Thread.sleep(2000);
		
		//get the merchant ID of the first row
		String merchantID1stRow =  terminalsListPge.getMerchantIDof1stRow();
		
		//get the terminal ID of the first row
		String terminalID1stRowA =  terminalsListPge.getTerminalIDof1stRow();
		
		//open merchant list
		
		openMerchantsList();
		mechListPg.clickSearchHeader();
		//Thread.sleep(1000);
		mechListPg.insertMerchantID(merchantID1stRow);
		//Thread.sleep(1000);
		mechListPg.clkSearchBtn();
		//Thread.sleep(1000);
		mechListPg.clkTerminalsBtn();
		
		String terminalID1stRowB =  terminalsListPge.getTerminalIDof1stRow();
		assertEquals(terminalID1stRowA, terminalID1stRowB);

	
	}//viewDetails
	
	//-------------------------------------edit merchant
	
	@Test(priority = 4, enabled = true)
	
	public void editMerchant() throws InterruptedException {

		
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		//Thread.sleep(1000);
	
		//open merchant list
		openMerchantsList();
		
		//get the merchant name of the first row
		String merchantName1stRowA =  mechListPg.getmerchantName1stRow();
				
		//click on edit button
		mechListPg.clkEditButton();
		//change the name
		newMerchPgObj.clearMerchantName();
		newMerchPgObj.insertMerchantName(merchantName1stRowA+"AA");
		//scroll to the end of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//click save
		newMerchPgObj.clkSave();
		
		//sign out bank merchants admin
		//Thread.sleep(1000);
		systemAdminMenu.signOut();
		//Thread.sleep(1000);
		
		//approve
		approve();
		systemAdminMenu.signOut();
		//sign in as bank merchants admin
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		//Thread.sleep(1000);
		
		systemAdminMenu.clkMerchantsManagement();
		//Thread.sleep(1000);
		systemAdminMenu.clkMerchants();
		//Thread.sleep(2000);
		
		//get the merchant name of the first row
		String merchantName1stRowB =  mechListPg.getmerchantName1stRow();
		assertEquals(merchantName1stRowA+"AA",merchantName1stRowB);
		
		
		
	}//end editMerchant
	
	//-------------------------------------delete merchant
	
	@Test(priority = 5, enabled = true)	
	public void deleteMerchant() throws InterruptedException {
			
		    lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
			
		
			//open merchant list
			openMerchantsList();
			
			//click on delete button of the first row
			mechListPg.clkDelete();
			
			//click on yes button
			mechListPg.clkCnfrm();
	
			//sign out bank merchants admin
			systemAdminMenu.signOut();
			
			//approve
			approve();
			
			systemAdminMenu.signOut();
			
			//sign in as bank merchants admin
		    lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
			//Thread.sleep(1000);
			
			systemAdminMenu.clkMerchantsManagement();
			//Thread.sleep(1000);
			systemAdminMenu.clkMerchants();
			//Thread.sleep(2000);
			
			assertEquals(mechListPg.getStatus(), "Deleted");
			
		}//end delete Merchant
		
	//---------------------------------open merchants list
		public void openMerchantsList() throws InterruptedException {
			
			systemAdminMenu.clkMerchantsManagement();
			systemAdminMenu.clkMerchants();
			
		}//end openMerchantsList
		
	//---------------------------------approve	
		public void approve() throws InterruptedException {
			
			//sign in as supervisor
			lgnPgElmnts.validLogin("ysaBAdS", "P@ssw0rd");
			
			//Approve the merchant creation request
			ApprovalPipleLinePge.clkDetailsofFirsRow();
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //scroll down
			
			ApprovalPipleLinePge.clkApproveBtn();
									  
			
		}//end approve
	
	
	

	}//end class
