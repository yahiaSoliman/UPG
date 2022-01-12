
/*
 * preconditions
 * new ank name
 * new mVisa pin
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.AddNewUserPage;
import Pages.BankDetailsPage;
import Pages.ManageUsersPage;
import Pages.MerchantsListPage;
import Pages.NewBankPage;
import Pages.NewMerchantPage;
import Pages.SideMenuElements;
import Pages.bankListPage;
import Pages.loginPage;

public class CreateUsersTestCases  {

	WebDriver driver;
	JavascriptExecutor js;
	ChromeOptions capability = new ChromeOptions();
	WebDriverWait wait;

	SideMenuElements systemAdminMenu;
	ManageUsersPage manageUsrPg;
	AddNewUserPage addnewUserPg;
	loginPage lgnPgElmnts; 
	MerchantsListPage mechListPg;
	NewMerchantPage newMerchPgObj; 
	BankDetailsPage detailsPg;
	bankListPage bkList;
	NewBankPage newBk;
	
	/*********** Test Data To Create New Bank *********/

		String mVisaBinValue = "582106";
		
		static String bankNameValue = "8sep18";
		static String newUserNameValue  = bankNameValue + "user";
	
		String acquirerCode = "50780362319";
		String meezaDigitalBankIDValue = "91";
		String meezaDigitalSchemeIDValue = "1";
		String meezaDigitalSchemeNameValue = "UPGS-CIB-Staging";
		String meezaDigitalClientID = "UPGS-CIB-Staging";

		
	/********* Test Data To Create New User ****************/

		String userRole [] = {"Bank Merchants Administrator", "Bank Aggregator Supervisor (Approver)",
				"Bank Auditor", "Bank Business User", "Bank Financial Operations Administrator", "Bank Help Desk Operator / Call Center" ,
				"Bank Merchant Viewer", "Bank Users Administrator" , "Bank Administration Supervisor (Approver)"};
		String bankID = "20156";
		String bankFullName = "testBankFullName00";
		String emailAddress = "masryegyptian92@gmail.com";
		String phoneNumber = "01097508504";
		String NotificationMethod = "Email";
		
	/************ Test Data To Create New Merchant ********/
		
		String merchantName = "test00";
		String categoryName = "1520-General Contractors";
		String city = "Alexandria";
		String address = "ABC";
		String mobileNumber = "01097508504";
		String accountType = "SVA";
		String meezaDigitalIdentificationType = "GovernmentalEntity";
		String meezaDigitalIdentificationNumber = "123";
		
		//----Migs data
		String AMAmerchantID = "mpos1";
		String AMAuser = "amauser";
		String AMAaccessCode = "B9251664";
		String secretHashKey = "FB302F0882B00C5F1BE4F136EDEC67E3";
		String AMApassword = "pass0001";
		
		//----Credentials
		String fullName = "fullNameTest00";
		String userEmail = "masryegyptian92@gmail.com";
		String notMethod = "Email";
		String loginMethod = "UPG Merchant ID";

		//strings
		String a;
		String b;
		String c;
		String d;
		String e;
		String f;
		String g;
		String h;
		String i;
		String j;
		String k;
		String l;
		String m;
		
	
	 //Open Google Chrome Maximize Chrome window Open UPG 140 portal
	 
	@BeforeClass 
	public void ClassSetup() throws InterruptedException {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
		wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://41.32.119.56:1004/Portal/Account/Login");
		
		systemAdminMenu = new SideMenuElements(driver);
		manageUsrPg = new ManageUsersPage(driver);
		addnewUserPg = new AddNewUserPage(driver); 
		mechListPg = new MerchantsListPage(wait,driver);
		lgnPgElmnts = new loginPage(driver, wait);
		newMerchPgObj = new NewMerchantPage(driver, wait);
		bkList = new bankListPage(driver, wait);
		newBk = new NewBankPage(driver,wait);
		
		//Sign in as an administrator
		lgnPgElmnts.validLogin("abdo", "P@ssw0rd");
		
	}
	
	@BeforeMethod
	public void MethodSetup() {
		
		detailsPg = new BankDetailsPage(driver, wait);
		
	}// end setup method

	@AfterMethod
	public void closwWindnow() {
		/// driver.quit();
	}// end after method
	
	
	//-------------------------------------------------------------------
	
	@Test(priority = 1, enabled = true)
	public void createBank() throws InterruptedException {

		
		//Go to Banks
		systemAdminMenu.openBankList();
		
		//Go to Create New Bank Page
		bkList.openNewBankPage();

		
		//Insert bank data
		newBk.insertBankData(bankNameValue, mVisaBinValue,
				acquirerCode, meezaDigitalBankIDValue, meezaDigitalSchemeIDValue, 
				meezaDigitalSchemeNameValue, meezaDigitalClientID); 
		
		//Open Details Page
		bkList.searchByName(bankNameValue);
		bankID = bkList.getBankID();
		bkList.clkDetailsButton(); //open details
		
		//wait until the bank details dialogue appears
		WebElement element = driver.findElement(By.id("Heading"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		 a = detailsPg.getColorOfActiveSwitch(); // Active switch status		
		 b = detailsPg.getBankName();// bank name 
		 c = detailsPg.getColorOfeCommerceSwitch();
		 d = detailsPg.getColorOfICSSwitch();// ICS switch status
		 e = detailsPg.getColorOfMIGSSwitch(); // MIGS switch status=
		 f = detailsPg.getColorOfNPSSwitch();// NPS switch status
		 g = detailsPg.getColorOfmVisaSwitch(); // mVisa switch status
		 h = detailsPg.getAcquirerCode();// acquirer code value
		 i = detailsPg.getmVisaBIN();// mVisa Bin Value
		 j = detailsPg.getMeezaDigitalBankID();// meeza Digital BankID Value
		 k = detailsPg.getMeezaDigitalSchemeID(); //meeza Digital Scheme ID Value
		 l = detailsPg.getMeezaDigitalSchemeName();// meeza Digital Scheme name Value
		 m = detailsPg.getMeezaDigitalClientID();// meeza Digital client ID Value
		
		Date cur_dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strTodaysDate = dateFormat.format(cur_dt);
		String creationDate = detailsPg.getCreationDate(); // Creation date
		

		/********Assertions***********/
		
		Assert.assertEquals(a,"#a1c2fa"); //is bank active 
		Assert.assertEquals(b,bankNameValue); //is bank name valid
		Assert.assertEquals(c,"#a1c2fa"); //is commerce enabled
		Assert.assertEquals(d,"#a1c2fa"); //is ICS enabled
		Assert.assertEquals(e,"#a1c2fa"); //is MIGS enabled
		Assert.assertEquals(f,"#a1c2fa"); //is NPS enabled
		Assert.assertEquals(g,"#a1c2fa"); //is mVisa enabled
		Assert.assertEquals(h,acquirerCode); //is Acquirer Code valid
		Assert.assertEquals(i,mVisaBinValue + "00"); //is mVisa BIN valid
		Assert.assertEquals(j,meezaDigitalBankIDValue); //is meeza Digital BankID valid
		Assert.assertEquals(k,meezaDigitalSchemeIDValue); //is meeza Digital SchemeID valid
		Assert.assertEquals(l,meezaDigitalSchemeNameValue); //is meeza Digital SchemeName valid
		Assert.assertEquals(m,meezaDigitalClientID); //is meeza Digital ClientID valid
		Assert.assertEquals(creationDate, strTodaysDate);		
		
		//Close Details Window
		bkList.clkDetailsWindowClose();
		
		//open Manage Users
		systemAdminMenu.clkManageUsers();

		
	}// end method create bank
	
	
		//----------------------------------------------
	
	
	@Test(priority = 3, dataProvider = "newUserData", enabled = true)
	public void createBankUsers(String userRole, String userName) throws InterruptedException {

		//open new user page
		manageUsrPg.clkRotateButton();
		manageUsrPg.clkAddButton();

		//select User Role
		addnewUserPg.clkUserRoleDrpDownList(); 
		addnewUserPg.selectUserRole(userRole);
		
		//select bank
		addnewUserPg.clkBankNameDrpDownList(); 
		addnewUserPg.selectBankName(bankID);
		
		//set user data
		addnewUserPg.insertUserDataPack(userName, bankFullName, emailAddress, phoneNumber, NotificationMethod);
		
		//click register
		addnewUserPg.clkRegisterBtn();

	}// end createBankUsers
	
	//----------------------------------------------
	
	
@Test(priority = 2, enabled = true)
public void createBankAdminSuperVisor() throws InterruptedException {

	//open new user page
	manageUsrPg.clkRotateButton();
	manageUsrPg.clkAddButton();

	
	//select User Role
	addnewUserPg.clkUserRoleDrpDownList(); 
	addnewUserPg.selectUserRole(userRole[8]); 
	
	//select bank
	addnewUserPg.clkBankNameDrpDownList(); 
	addnewUserPg.selectBankName(bankID); 
	
	//set user data
	addnewUserPg.insertUserDataPack( newUserNameValue + "07", bankFullName, emailAddress, phoneNumber, NotificationMethod);
	addnewUserPg.clkPrivliges();
	
	//click register
	addnewUserPg.clkRegisterBtn();

} //end createBankAdminSuperVisor

//----------------------------------------------

@DataProvider 
public Object[][] newUserData() {
	
	Object [][] data = new Object [8][2]; 
	
	data [0][0] = userRole[0];
	data [0][1] = newUserNameValue;
	
	data [1][0] = userRole[1];
	data [1][1] = newUserNameValue + "00";
	
	data [2][0] = userRole[2];
	data [2][1] = newUserNameValue + "01";
	
	data [3][0] = userRole[3];
	data [3][1] = newUserNameValue + "02";
	
	data [4][0] = userRole[4];
	data [4][1] = newUserNameValue + "03";
	
	data [5][0] = userRole[5];
	data [5][1] = newUserNameValue + "04";
	
	data [6][0] = userRole[6];
	data [6][1] = newUserNameValue + "05";
	
	data [7][0] = userRole[7];
	data [7][1] = newUserNameValue + "06";
	
	
	return data;
}//end newUSerData

}// end class
