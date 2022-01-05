
/*
 * Verify that merchant creation can be approved successfully
 * Verify that merchant Edit can be approved successfully
 * Verify that merchant Delete can be approved successfully
 * Verify that the operation type is valid in all cases
 * Verify that all actions types are displayed correctly
 */

/*precondition
 * 
 * insert new merchant name
 * UPG local External URL
 * bank merchant administrator
 * bank merchant supervisor
 * 
 */

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

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
import Pages.loginPage;
import Pages.ApprovalPipleLinePAge;

public class SupervisorMerchantsManagement {

	WebDriver driver;
	WebDriverWait wait;
	ChromeOptions capability = new ChromeOptions();
	JavascriptExecutor js;
	
	loginPage lgnPgElmnts; 
	SideMenuElements systemAdminMenu;
	MerchantsListPage mechListPg;
	NewMerchantPage newMerchPgObj; 
	ApprovalPipleLinePAge ApprovalPipleLinePge;
	
	//Bank Merchants Administrator Credentials
		String BankMerchantsAdminUserName = "ysaBMA1";
		String BankMerchantsAdminPasswsord = "P@ssw0rd";
		
		//merchants data
		String merchantName = "test016";
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
		
		String pipelineID; 
		String firstPipeLineID;
		String firstActionType;
		String firstOperationType;
		String firstStatus;
		
		//BeforeClass method
		@BeforeClass
		public void MethodSetup() throws InterruptedException, ParseException {
			
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver(capability);
			wait = new WebDriverWait(driver,30); //explicit wait
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
			driver.get("https://41.32.119.56:1004/Portal/Account/Login");
			
			lgnPgElmnts = new loginPage(driver, wait);
			systemAdminMenu = new SideMenuElements(driver);
			mechListPg = new MerchantsListPage(wait,driver);
			js = (JavascriptExecutor) driver;
			newMerchPgObj = new NewMerchantPage(driver, wait);
			ApprovalPipleLinePge = new ApprovalPipleLinePAge(driver, wait);
		}//end @BeforeClass
		
		//After Method
		@AfterMethod
		public void closwWindnow() throws InterruptedException {
			//systemAdminMenu.signOut();

			
		}// end after method
	
		
		
		/*verify that the action type is create
		 *verify that the operation type is merchants management
		 *verify that the action approved successfully
		 */
		@Test(priority = 1, enabled = true)
		public void approveCreateMerchant() throws InterruptedException {
			
			//login with Bank Merchant Administrator
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
			
			js.executeScript("window.scrollBy(0,100)"); //scroll down
			
			//Click Save button
			newMerchPgObj.clkSave();
			
			//sign out
		    systemAdminMenu.signOut();
			
		    //approve the creation
			approve();
			
			//get the values to be asserted
			firstActionType    = ApprovalPipleLinePge.getFirstActionType();
			firstOperationType = ApprovalPipleLinePge.getFirstOperatiopnType();
			firstStatus		   = ApprovalPipleLinePge.getStatusOfFirstRow(); 	
			
			//log out
			systemAdminMenu.signOut();
			
			
			//assert all expected results
			assertEquals(firstActionType, "Create", "action type is not \" Create\"");
			assertEquals(firstOperationType, "MerchantManagement", "operation type is not \" MerchantManagement\"");
			assertEquals(firstStatus,"Approved", "status is not \" Approve\"");
			
		}//end  approveCreateMerchant
		
		
		// edit merchant
		@Test(priority = 2, enabled = true)
		
		public void editMerchant() throws InterruptedException {
	
			lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
			Thread.sleep(1000);
		
			//open merchant list
			openMerchantsList();
			
			//get the merchant name of the first row
			String merchantName1stRowA =  mechListPg.getmerchantName1stRow();
					
			//click on edit button
			mechListPg.clkEditButton();
			//change the name
			newMerchPgObj.clearMerchantName();
			newMerchPgObj.insertMerchantName(merchantName1stRowA + "AA");
			//scroll to the end of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//click save
			newMerchPgObj.clkSave();
			
			//log out
			systemAdminMenu.signOut();
						

			//approve the edit
			approve();
			
			firstActionType = ApprovalPipleLinePge.getFirstActionType();
			firstOperationType =  ApprovalPipleLinePge.getFirstOperatiopnType();
			firstStatus		   = ApprovalPipleLinePge.getStatusOfFirstRow(); 	
			
			//log out
			systemAdminMenu.signOut();
			
			//assert all expected results
			assertEquals(firstActionType, "Edit", "action type is not \" Edit\"");
			assertEquals(firstOperationType, "MerchantManagement", "operation type is not \" MerchantManagement\"");
			assertEquals(firstStatus,"Approved", "status is not \" Approve\"");
			
		}//end editMerchant
		
		
		// delete merchant
		@Test(priority = 3, enabled = true)	
		public void deleteMerchant() throws InterruptedException {
				
			    lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
				
				//open merchant list
				openMerchantsList();
				
				//click on delete button of the first row
				mechListPg.clkDelete();
				
				//click on yes button
				mechListPg.clkCnfrm();
			
				//log out
				systemAdminMenu.signOut();
							
				//approve the edit
				approve();
				
				firstActionType = ApprovalPipleLinePge.getFirstActionType();
				firstOperationType =  ApprovalPipleLinePge.getFirstOperatiopnType();
				firstStatus		   = ApprovalPipleLinePge.getStatusOfFirstRow(); 	
				
				//assert all expected results
				assertEquals(firstActionType, "Delete", "action type is not \" Delete\"");
				assertEquals(firstOperationType, "MerchantManagement", "operation type is not \" MerchantManagement\"");
				assertEquals(firstStatus,"Approved", "status is not \" Approve\"");
				
		}// end deleteMerchant
		
		//---------------------------------open merchants list
		public void openMerchantsList() throws InterruptedException {
			
			systemAdminMenu.clkMerchantsManagement();
			systemAdminMenu.clkMerchants();

			
		}//end openMerchantsList
		
		// approve	
		public void approve() throws InterruptedException{
			
			//sign in as supervisor
			lgnPgElmnts.validLogin("ysaBAdS", "P@ssw0rd");
			
			//Approve the merchant creation request
			ApprovalPipleLinePge.clkDetailsofFirsRow();
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //scroll down
			
			ApprovalPipleLinePge.clkApproveBtn();
									  
			
		}//end approve
}//end class
