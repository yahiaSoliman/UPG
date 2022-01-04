/*
 * 
 * preconditions
 * 
 * grey
 * system admin credentials
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.MerchantsListPage;
import Pages.NewMerchantPage;
import Pages.SideMenuElements;
import Pages.loginPage;



public class EditAllMerchantList {
	
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	JavascriptExecutor js;
	WebDriverWait wait;
	ArrayList<String> tabs;
	
	//pages' references
	loginPage lgnPgElmnts; 
	SideMenuElements systemAdminMenu;
	MerchantsListPage mechListPg;
	NewMerchantPage newMerchPgObj; 
	String sysAdminUserName = "ramy"; 
	String sysAdminPass = "P@ssw0rd";
	
	
	
	@BeforeClass
	public void MethodSetup() {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver(capability);
		wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://grey.paysky.io/Portal/Account/Login");
		
		//assign objects to pages references
		lgnPgElmnts = new loginPage(driver, wait);
		systemAdminMenu = new SideMenuElements(driver);
		mechListPg = new MerchantsListPage(wait,driver);
		newMerchPgObj = new NewMerchantPage(driver, wait);
		js = (JavascriptExecutor) driver;
		
		
	}//end BeforeCalss Method
	
	
	//*************************************************************************//
	
	@Test(priority = 1, enabled = true)
	public void EditAllList() throws InterruptedException {
		
		lgnPgElmnts.validLogin(sysAdminUserName, sysAdminPass);	//login
	
		systemAdminMenu.clkMerchantsManagement(); //open merchant lsit
		systemAdminMenu.clkMerchants();
		String merchantNameCurrentRow; 
		
		List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr"));
		
		for(WebElement e: items)
		{
		 // System.out.println(e. findElement(By.tagName("a")).getAttribute("title")); 
			
			List<WebElement> tds = e. findElements(By.tagName("td"));
			
			merchantNameCurrentRow = tds.get(1).getText();
			
			//mechListPg.clkEditButton();	//click on edit button
			//mechListPg.clkEditButtonNewTab();
			String URL = tds.get(7).findElement(By.tagName("a")).getAttribute("href");
			System.out.println(URL);
			
			js.executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(URL);
			
			newMerchPgObj.clearMerchantName();
			newMerchPgObj.insertMerchantName(merchantNameCurrentRow + "Update"); //change the name
			
			
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //scroll to the end of the page
		
			newMerchPgObj.clkSave(); //click save
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
		}//end for loop	
		
	}//end EditAllList
		

}//end ApproveAllSelected
