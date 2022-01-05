/*
 * Preconditions
 * bank admin username
 * bank admin password UPG local URL
 * update the bulk file with new merchant names
 * 
 *
 */



import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.MerchantsBulkListPage;
import Pages.SideMenuElements;
import Pages.loginPage;
import Pages.ApprovalPipleLinePAge;


public class ArrovalAndRejectionOfBulks {
	
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	WebDriverWait wait;
	
	String bankAdminUsername = "ysaBMA1";
	String bankAdminPassword = "P@ssw0rd";	
	String batchID;
	loginPage lgnPgElmnts; 
	SideMenuElements systemAdminMenu;
	MerchantsBulkListPage MerchantsBulkListPge;
	ApprovalPipleLinePAge ApprovalPipleLinePge;
	
	@BeforeClass
	public void MethodSetup() {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver,40);  //explicit wait assignment
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //configure waits	
		driver.get("https://41.32.119.56:1004/Portal/Account/Login"); //open URL
		
		// create objects of pages
		lgnPgElmnts = new loginPage(driver, wait);
		systemAdminMenu = new SideMenuElements(driver);
		MerchantsBulkListPge = new MerchantsBulkListPage(wait, driver);
		ApprovalPipleLinePge = new ApprovalPipleLinePAge(driver, wait);
		
	}// end MethodSetup
	
	
	@Test(priority = 1, enabled = true)
	public void RejectAll() throws InterruptedException {
		
		lgnPgElmnts.validLogin(bankAdminUsername, bankAdminPassword);
		systemAdminMenu.clkMerchantsManagement();
		systemAdminMenu.clkBulkMerchants();
		MerchantsBulkListPge.clkRotateButton();
		MerchantsBulkListPge.clkAddButton();
		MerchantsBulkListPge.selectFile(System.getProperty("user.dir") + "\\Automation01.csv");
		MerchantsBulkListPge.clkSaveBtn();
		MerchantsBulkListPge.clkActionBtn();
		MerchantsBulkListPge.clkSndBtn();
		
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"divListPanel\"]/div[2]/div[2]/div/table/tbody/tr[1]/td[7]/b/span"), "Saved"));
		WebElement btnSend = driver.findElement(By.id("btnSaveBulk"));
		wait.until(ExpectedConditions.invisibilityOf(btnSend));
		batchID = driver.findElement(By.xpath("(//*[@class='notice notice-danger'])[2]")).getText().substring(26,31);
		systemAdminMenu.signOut();
		
		//Approve
		lgnPgElmnts.validLogin("ysaBAdS", "P@ssw0rd");
		driver.findElement(By.id("searchHeader")).click();
		driver.findElement(By.id("BulkBatchID")).sendKeys(batchID);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		ApprovalPipleLinePge.clkCheckAllBox();
		ApprovalPipleLinePge.clkQueueBtn();
		
		
	}//end createMerchant

}//end ArrovalAndRejectionOfBulks
