

/*
 * this class verify the fields of details page of approval pipeline
 */
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
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
import Pages.PiplineTaskDetailsPage;
import Pages.SideMenuElements;
import Pages.loginPage;
import Pages.ApprovalPipleLinePAge;

public class ApprovalPipelineDetails {
	
	WebDriver driver;
	
	ChromeOptions capability = new ChromeOptions();
	JavascriptExecutor js;
	
	loginPage lgnPgElmnts; 
	SideMenuElements systemAdminMenu;
	MerchantsListPage mechListPg;
	NewMerchantPage newMerchPgObj; 
	ApprovalPipleLinePAge ApprovalPipleLinePge;
	PiplineTaskDetailsPage PiplineTaskDetailsPge;
	
	//Bank Merchants Administrator Credentials
	String BankMerchantsAdminUserName = "ysaBMA1";
	String BankMerchantsAdminPasswsord = "P@ssw0rd";
	
	//merchants data
	String merchantName = "test101";
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
	String dateTime;
	Date userDate;
	Date detailsDate;
	
	//verify that a valid pipeline task added to the approval pipeline for merchant creation
	
	
	@BeforeClass
	public void MethodSetup() throws InterruptedException, ParseException {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","G:\\\\\\\\chromedriver_win32 (3)\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver(capability);
		WebDriverWait wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.get("https://41.32.119.56:1004/Portal/Account/Login");
		
		lgnPgElmnts = new loginPage(driver, wait);
		systemAdminMenu = new SideMenuElements(driver);
		mechListPg = new MerchantsListPage(wait,driver);
		js = (JavascriptExecutor) driver;
		newMerchPgObj = new NewMerchantPage(driver, wait);
		ApprovalPipleLinePge = new ApprovalPipleLinePAge(driver, wait);
		PiplineTaskDetailsPge = new PiplineTaskDetailsPage(driver);
		//*****************************************
		//*****************************************
		lgnPgElmnts.validLogin(BankMerchantsAdminUserName, BankMerchantsAdminPasswsord);
		
	
		/****open merchant list****/
	
		openMerchantsList();
		
	
		/*******open new merchant page*****/

		
		mechListPg.clkRotateButton(); 
		mechListPg.clkAddButton();
		
	
		/*******insert merchant data******/
		
	
		
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
	
		/***Configure Credentials****/

		newMerchPgObj.insertMerchantFullName(fullName);
		newMerchPgObj.insertMerchantUserEmail(userEmail);
		newMerchPgObj.clkloginMethod();
		newMerchPgObj.selectloginMethod(loginMethod);
		newMerchPgObj.clkNotificationMethod();
		newMerchPgObj.selectNotificationMethod(notMethod);
		
		js.executeScript("window.scrollBy(0,100)"); //scroll down

		
		/*******Click Save button********/
		newMerchPgObj.clkSave();

		
		// get the pipeline ID
	    pipelineID = mechListPg.getpipleLineID();
		pipelineID = pipelineID.substring(59);
		
		
		//open approval pipeline
		systemAdminMenu.clkApprovalPipline();
		//Thread.sleep(1000);
		
		//open the details of first request
		ApprovalPipleLinePge.clkDetailsofFirsRow();

		
		
	}//end before class method
	
	@AfterMethod
	public void closwWindnow() throws InterruptedException {
		//systemAdminMenu.signOut();

		
	}// end after method
	
	
	@Test(priority = 1, enabled = true) 
	public void pipelineID()  {
		
		assertEquals(PiplineTaskDetailsPge.getpipelineID(), pipelineID);
		
	}// end pipelineID
	
	@Test(priority = 2, enabled = true) 
	public void operationType()  {
		
		assertEquals(PiplineTaskDetailsPge.getOperationType(), "MerchantManagement");
		
	}// end operationType
	
	@Test(priority = 3, enabled = true) 
	public void actionType()  {
		
		assertEquals(PiplineTaskDetailsPge.getActionType(), "Create");
		
	}// end actionType
	
	@Test(priority = 4, enabled = true) 
	public void merchantName()  {
		
		assertEquals(PiplineTaskDetailsPge.getMerchantName(), merchantName);
		
	}// end merchantName
	
	@Test(priority = 5, enabled = true) 
	public void status()  {
		
		assertEquals(PiplineTaskDetailsPge.getStatus(), "Waiting");
		
	}// end status
	
	@Test(priority = 6, enabled = true) 
	public void Maker()  {
		
		assertEquals(PiplineTaskDetailsPge.getMaker(), "second");
		
	}// end Maker
	
	

	@Test(priority = 7, enabled = true) 
	public void dateTime() throws ParseException  {
		
		//get date and time of the main page
		userDate =new SimpleDateFormat("yyyy-M-dd hh:mm a").parse(systemAdminMenu.getDateTime());
		System.out.println(userDate);
				
		//get date and time of the details page
		detailsDate = new SimpleDateFormat("M/dd/yyyy hh:mm:ss a").parse(PiplineTaskDetailsPge.getDateTime());  
	    System.out.println(detailsDate); 
	    
	    SimpleDateFormat testFormat = new SimpleDateFormat("M/dd/yyyy hh a");
	    System.out.println(testFormat.format(detailsDate)); 
	    System.out.println(testFormat.format(userDate)); 
		
	    assertEquals(testFormat.format(userDate),testFormat.format(detailsDate));
		
		
	}// end Maker
	
	//---------------------------------open merchants list
	public void openMerchantsList() throws InterruptedException {
		
		systemAdminMenu.clkMerchantsManagement();
		systemAdminMenu.clkMerchants();

		
	}//end openMerchantsList
	

}//end class ApprovalPipeline
