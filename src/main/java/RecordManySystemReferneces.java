/*
 * 
 * preconditons
 * 
 * merchant name
 * password
 * terminal
 * 
 * staging URL
 */

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.SideMenuElements;
import Pages.createNewOrderPage;
import Pages.loginPage;
import Pages.transactionReportPage;
import Pages.valueAddedServicesPage;

public class RecordManySystemReferneces {
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	ArrayList<String> tabs;
	JavascriptExecutor js;
	WebDriverWait wait;
	loginPage lgnPgElmnts; 
	SideMenuElements SideMenu;
	valueAddedServicesPage valueAddedServices;
	createNewOrderPage createNewOrder;
	transactionReportPage transactionReportPge;
	
	String terminal = "145316";
	String amount = "63";
	String email = "we@io.c";
	int  payCounts = 20;
	
	String merchantName = "10920989408";
	String merchantPassword = "852369";
	
	String URL = "https://upgstagportal.egyptianbanks.com/Portal/Account/Login";
	BufferedWriter bw; 
	String window1;
	String window2;
	String a;
	
	@BeforeClass
	public void MethodSetup() throws AWTException {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
	    
		wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		lgnPgElmnts = new loginPage(driver, wait);
		SideMenu = new SideMenuElements(driver);
		valueAddedServices = new valueAddedServicesPage(driver, wait);
		createNewOrder = new createNewOrderPage(driver);
		transactionReportPge = new transactionReportPage(driver);
		
		//assign a file to the buffer
		try {
			bw = new BufferedWriter(new FileWriter("text.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//*************** steps not to be repeated *****************//
		
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
				createNewOrder.selectPaymentType("Multiple-use link");
				
				//set number of payments
				createNewOrder.setNumberOfPayments(String.valueOf(payCounts));
				
				//click save button
				createNewOrder.clckSaveBtn();
				
				//open the order pay link
				String link = createNewOrder.getOrderLink();
				
				((JavascriptExecutor)driver).executeScript("window.open()");
				tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				
				//driver.get("http://197.45.97.122"+link.substring(20)); // for 140 server
				

				driver.get(link);

	}//end MethodSetup
	
	@AfterClass
	public void finishing() {
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //end finishing
	
	@Test(priority = 1, enabled = true, invocationCount = 10)
	public void makeTransaction() {


		//click pay now
		createNewOrder.clkPayNow1st();
		
		//insert card data
	  	createNewOrder.filLightBox();
				
		//click pay
		createNewOrder.clkPayNow2nd();
				
		//wait until the successful message get displayed
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"divReceipt\"]/div[1]/div/p")));
			
		//write system reference number in a file 
		
		try {
			bw.write(createNewOrder.getTrxRef() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//reload the page to pay again
		driver.navigate().refresh();
		
	}//end makeTransaction
	
	@Test(priority = 2, enabled = false)
	public void singleUse()  {
		
		 driver.navigate().refresh();
		
		 assertEquals( createNewOrder.getErrorMessageOfOrderPaid(), "Order is already paid !!");
	}//end transactionReportNewItem
	
	@Test(priority = 3, enabled = false)
	public void transactionReportNewItem()  {
		
		 driver.switchTo().window(tabs.get(0));
		 SideMenu.clkTransactionReport();
		 transactionReportPge.getAmount();
		 assertEquals( transactionReportPge.getAmount(),amount+" EGP");
		 
		 
	}//end transactionReportNewItem

	@Test(priority = 4, enabled = false)
	public void testKeys() {

	}

}//end class
