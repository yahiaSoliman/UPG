/*
 * Preconditions
 *  grey URL
 *  merchant user name
 *  merchant password
 */


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.loginPage;

public class LoginTestMethods {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String excelFilePath = "E:/TestData.xlsx"; // excel file path
	ChromeOptions capability = new ChromeOptions();
	loginPage lgnPgElmnts;
	String username = "14299454110";
	String password = "852147";
	
	/*
	 * Open Google Chrome Maximize Chrome window Open UPG 140 portal
	 */
	@BeforeMethod
	public void setup() {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		driver = new ChromeDriver(capability);
	    wait = new WebDriverWait(driver,30);
		lgnPgElmnts = new loginPage(driver,wait);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://grey.paysky.io/Portal/Account/Login");

	}// end setup method

	@AfterMethod
	public void closwWindnow() {
		driver.close();
	}// end after method

	// *******************************************************

	@Test(priority = 1, enabled = true)
	public void validNamePass(){

		
		lgnPgElmnts.validLogin(username, password);
		
		//just wait for that element as an indication for complete loading of the page
		driver.findElement(By.id("SupportTicketDiv"));
		
		String Curl = driver.getTitle();
		assertTrue(Curl.equals("CTMS - Merchant Dashboard"));

	}// end method validRegister

	// **************************************************************

	@Test(priority = 2, enabled = true)
	public void emptyNamePass() throws InterruptedException {


		lgnPgElmnts.setName("");
		lgnPgElmnts.setPass("");
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "User name and password must be set");
		
	}// end method validRegister

	// *********************************************************

	@Test(priority = 3, enabled = true)
	public void emptyName() throws InterruptedException {


		lgnPgElmnts.setName("");
		lgnPgElmnts.setPass(password);
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "User name and password must be set");

	}// end method validRegister

	// *********************************************************

	@Test(priority = 4, enabled = true)
	public void emptyPass() throws InterruptedException {


		lgnPgElmnts.setName(username);
		lgnPgElmnts.setPass("");
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "User name and password must be set");

	}// end method validRegister

	// *****************************************************************

	@Test(priority = 5, enabled = true)
	public void invalidName() throws InterruptedException {


		lgnPgElmnts.setName("14608421722");
		lgnPgElmnts.setPass(password);
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "Invalid user name or password.");

	}// end method validRegister

	// *****************************************************************

	@Test(priority = 6, enabled = true)
	public void invalidPass() throws InterruptedException {


		lgnPgElmnts.setName(username);
		lgnPgElmnts.setPass("147855");
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "Invalid user name or password.");

	}// end method validRegister

	// *****************************************************************

	@Test(priority = 7, enabled = true)
	public void invalidNamePass() throws InterruptedException {


		lgnPgElmnts.setName("14608421722");
		lgnPgElmnts.setPass("147855");
		lgnPgElmnts.clkOtp();
		Thread.sleep(1000);
		String InvalidCre = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(InvalidCre, "Invalid user name or password.");

	}// end method validRegister

	// *****************************************************************

	@Test(priority = 8, enabled = false)
	public void userBlock() throws InterruptedException {


		lgnPgElmnts.setName("14608421720");
		lgnPgElmnts.setPass("12");

		for (int count = 1; count <= 6; count++) {
			lgnPgElmnts.clkOtp();
			Thread.sleep(1000);
		} // end for
		Thread.sleep(1000);
		String block = driver.findElement(By.id("validateSummaryDiv")).getText();
		assertEquals(block, "Your have exceeded allowed login trials, "
				+ "Your account was blocked. Please contact customer support to reactivate your account.");

	}// end method validRegister
	
	// *****************************************************************

	
	
}//end setup
