import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.SideMenuElements;
import Pages.createNewOrderPage;
import Pages.loginPage;
import Pages.orderListPage;
import Pages.valueAddedServicesPage;

/*
 * this class includes test for the column status of the View Payment Order Section
 * Status is Unpaid, Partially Paid, Paid
 */


/*
 * Preconditions
 * 
 * merchant name
 * merchant password
 * terminal
 * 
 * staging URL
 * 
 */

public class ViewPaymentOrderStatus {
	
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	WebDriverWait wait;
	ArrayList<String> tabs;
	JavascriptExecutor js;
	
	loginPage lgnPgElmnts; 
	SideMenuElements SideMenu;
	valueAddedServicesPage valueAddedServices;
	createNewOrderPage createNewOrder;
	orderListPage orderListPge;
	String terminal = "145316";
	String amount = "30";
	String email = "we@io.c";
	String paymentTypeValue = "Multiple-use link";
	String numberOfPaymetnsValue = "2";
			
	String merchantName = "10920989408";
	String merchantPassword = "852369";
	
	String link;
	String orderID;
	
	
	@BeforeClass
	public void MethodSetup() throws AWTException {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
	    
		wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://upgstagportal.egyptianbanks.com/Portal/Account/Login");

		lgnPgElmnts = new loginPage(driver, wait);
		SideMenu = new SideMenuElements(driver);
		valueAddedServices = new valueAddedServicesPage(driver, wait);
		createNewOrder = new createNewOrderPage(driver);
		orderListPge = new orderListPage(wait, driver);
		
		//login with merchant credentials
		lgnPgElmnts.validLogin(merchantName, merchantPassword);
				
		//open value added services
		SideMenu.clkValueAddedServices();
				
		//click create payment order
		valueAddedServices.clkCreatePaymentOrder();
				
		//insert order data and click save
		createNewOrder.selectTerminal(terminal);
				
		//set amount
		createNewOrder.setAmount(amount);
				
		//set email
		createNewOrder.setEmail(email);
		
		//select payment type
		createNewOrder.selectPaymentType(paymentTypeValue);
		
		//set number of payments
		createNewOrder.setNumberOfPayments(numberOfPaymetnsValue);
			
		//click save button
		createNewOrder.clckSaveBtn();
		
		//get the order pay link
		link = createNewOrder.getOrderLink();
	
	}//end BeforeClass
	
	//verify that the status is Unpaid for transaction that is not paid at all
	@Test(priority = 1, enabled = true)
	public void unPaid() {
		
		//open value added services
		SideMenu.clkValueAddedServices();
		
		//open view payment order status
		valueAddedServices.clkViewPaymentOrderStatus();
		
		assertEquals(orderListPge.getStatus(),"Unpaid");
		 
	}//unPaid
	
	//verify that the status is Partially Paid if the transaction is paid at least one time
	@Test(priority = 2, enabled = true)
	public void partialllyPaid() throws InterruptedException {
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(link);

		//pay, get back to the list and refresh it
	     payAndBack();
	 
	    assertEquals(orderListPge.getStatus2(),"Partially Paid");
	       
		 
	}//partially paid
	
	//verify that the status is paid if the transaction can't be paid any more
	@Test(priority = 3, enabled = true)
	public void paid()  {
		
		 //switch the the payment tab
	     driver.switchTo().window(tabs.get(1));
	    
	     //refresh the page to repay
	     driver.navigate().refresh();
	    
	     //pay, get back to the list and refresh it
	     payAndBack();
		 
	  	 assertEquals(orderListPge.getStatus2(),"Paid");
	      
	}//paid
	
	
	//------------------------------
	
	//pay, get back to the list and refresh it
	public void payAndBack() {
		
		 //click pay now
	  	 createNewOrder.clkPayNow1st();
	  		
	  	 //insert card data
	  	 createNewOrder.filLightBox();
	  		
	  	 //click pay
	  	 createNewOrder.clkPayNow2nd();
	  				
	  	 //wait until the successful message get displayed
	  	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"divReceipt\"]/div[1]/div/p")));
	  	
	  	 //switch the the list page tab
	  	 driver.switchTo().window(tabs.get(0));
	  	    
	  	 //refresh the list 
	  	 orderListPge.clickRotateBtn();
	  	 orderListPge.clickReloadBtn();
	  	 
	  	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ytLoad")));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ytLoad")));
		 
	}//end payAndBack
	
	
	
	
}//end ViewPaymentOrderStatus
