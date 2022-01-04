/*
 * Preconditions
 * 
 * 	merchant Name, merchantID, merchant password, terminal
 * staging URL
 * 
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import Pages.TicketDetailsPage;
import Pages.TicketsMessagesPage;
import Pages.loginPage;
import Pages.newRequestPage;
import Pages.ticketsPage;

public class supportTicketTestCases {
	
	WebDriver driver;
	ChromeOptions capability = new ChromeOptions();
	JavascriptExecutor js;
	WebDriverWait wait;
	loginPage lgnPgElmnts; 
	SideMenuElements SideMenu;
	ticketsPage ticketsPge;
	newRequestPage newRequestPge;
	TicketDetailsPage TicketDetailsPge;
	TicketsMessagesPage TicketsMessagesPge;

	
	String merchantName = "209Merchant1";
	String merchantID = "10920989408";
	String merchantPassword = "852369";
	
	String terminal = "25655435";
	String severity = "Medium";
	String request = "Paper rolls request";
	String details = "the details have to be written here";
	String ticketID;
	Date firstRowDate;
	Date detailsRequestDate;
	Date systemDate;
	Date messageDate;
	String firstRowDateString;
	String newMessage = "this is my new message";
	
	@BeforeClass
	public void MethodSetup() throws InterruptedException {
		
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(capability);
	    
		wait = new WebDriverWait(driver,30); //explicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://upgstagportal.egyptianbanks.com/Portal/Account/Login");
		
		lgnPgElmnts = new loginPage(driver, wait);
		SideMenu = new SideMenuElements(driver);
		ticketsPge = new ticketsPage( wait, driver);
		newRequestPge = new newRequestPage(driver, wait);
		TicketDetailsPge = new TicketDetailsPage(driver);
		TicketsMessagesPge = new TicketsMessagesPage(wait, driver);
		
		//login with merchant credentials
		lgnPgElmnts.validLogin(merchantID, merchantPassword);
		SideMenu.clkSupportTickets();
		ticketsPge.clkRotateButton();
		ticketsPge.clkAddButton();
	
	}//end MethodSetup
	
	//verify that the system can't process without inserting the ticket details
	@Test(priority = 1, enabled = true)
	public void emptyDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSend")));
		newRequestPge.clkSendBtn();
		wait.until(ExpectedConditions.textToBePresentInElementLocated( By.id("customError"),"Please fill Details!"));
		assertEquals(newRequestPge.getTextOfDetailsError(),"Please fill Details!");
	}//end test
	
	//verify that the system can't process without selecting the terminal
	@Test(priority = 2, enabled = true)
	public void emptyTerminal() throws InterruptedException {
		
		newRequestPge.insertDetails(details);
		newRequestPge.clkSendBtn();
	
	}//end test
	
	//verify that the ticket has been submitted successfully
	@Test(priority = 3, enabled = true)
	public void validSubmit() {
		
		newRequestPge.selectTerminal(terminal);
		newRequestPge.selectSeverity(severity);
		newRequestPge.selectRequest(request);
		newRequestPge.clkSendBtn();
		assertTrue(newRequestPge.getTextOfConfirmationMessage().contains("Your Request has been sent with reference"));

	}// end successSubmitCompletion
	
	//verify that the ticket has been added successfully to the tickes list
	@Test(priority = 4, enabled = true)
	public void validTicketID() {
	
		ticketID = newRequestPge.getTextOfConfirmationMessage().substring(45);
		SideMenu.clkSupportTickets();
		
		assertEquals(ticketsPge.getTicketIDofFirstRow(),"#"+ticketID);
	}//end ticketAddedSuccessfully

	//verify that severity of the first row is valid
	@Test(priority = 5, enabled = true)
	public void validSeverity() {
		
		
		assertEquals(ticketsPge.getSeverityFirstRow(), severity);
	}// end validSeverity
	
	//verify that terminal of the first row is valid
	@Test(priority = 6, enabled = true)
	public void validTerminal() {
		
		
		assertEquals(ticketsPge.getTerminalFirstRow(), terminal);
	}// end validTerminal
	
	//verify that request of the first row is valid
	@Test(priority = 7, enabled = true)
	public void validRequest() {
		
		
		assertEquals(ticketsPge.getRequestFirstRow(), request);
	}// end validRequest
	
	//verify that merchant name of the first row is valid
	@Test(priority = 8, enabled = true)
	public void validMerchantName() {
		
		assertEquals(ticketsPge.getMerchantNameFirstRow(), merchantName);
	}// end validMerchantNAme
	
	//verify that the checkBox is not checked
	@Test(priority = 9, enabled = true)
	public void testCloseCheckbox() {
		
		
		assertEquals(ticketsPge.getChcekBoxStatusFirstRow(), null);
	}// end testCloseCheckbox
	
	//verify that the date and time are valid
	@Test(priority = 10, enabled = true)
	public void validDateTime() throws ParseException {
		
		// current date
		systemDate = Calendar.getInstance().getTime();
		System.out.println(systemDate);		
		
		//get date and time of the details page
		firstRowDate = new SimpleDateFormat("M/dd/yyyy hh:mm:ss a").parse(ticketsPge.getDateTime());  
	    System.out.println(firstRowDate); 
	    
	    SimpleDateFormat testFormat = new SimpleDateFormat("M/dd/yyyy hh a");
	    System.out.println(testFormat.format(firstRowDate)); 
	    System.out.println(testFormat.format(systemDate)); 
		
	    assertEquals(testFormat.format(firstRowDate),testFormat.format(systemDate));
	}//end validDateTime
	
	//verify that the Closed Date is empty
	@Test(priority = 11, enabled = true)
	public void validClosedDateEmpty() {
		
		
		assertEquals(ticketsPge.getClosedDate(), "");
	}// end testClosedDate
	
	//verify that the details ticket ID is valid
	@Test(priority = 12, enabled = true)
	public void validDetailsTicketID() {
		ticketsPge.clickDetails();
		assertEquals(TicketDetailsPge.getTicketID(), "# "+ticketID);
		
	}// end validDetailsTicketID
	
	//verify that the details MerchantName is valid
	@Test(priority = 13, enabled = true)
	public void validDetailsMerchantName() {
		assertEquals(TicketDetailsPge.getMerchantName(), merchantName);

	}//end validDetailsMerchantName
	
	//verify that the details Request Type is valid
	@Test(priority = 14, enabled = true)
	public void validDetailsRequestType() {
		
		assertEquals(TicketDetailsPge.getRequestType(), request);
	}//end validDetailsRequestType
	
	//verify that the details maker is valid
	@Test(priority = 15, enabled = true)
	public void validDetailsMaker() {

		assertEquals(TicketDetailsPge.getMaker(), merchantName);
	}//end validDetailsMaker
	
	//verify that the details severity is valid
	@Test(priority = 16, enabled = true)
	public void validDetailsSeverity() {

		assertEquals(TicketDetailsPge.getSeverity(), severity);
	}//end validDetailsSeverity
	
	//verify that the details request date is valid
	@Test(priority = 17, enabled = true)
	public void validDetailsequestDate() throws ParseException {
		
		detailsRequestDate = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(TicketDetailsPge.getRequestDate());
		SimpleDateFormat testFormat = new SimpleDateFormat("M/dd/yyyy hh a");
		assertEquals(testFormat.format(detailsRequestDate), testFormat.format(firstRowDate));
		
	}//end validRDetailsequestDate
	
	//verify that the details close state is valid
	@Test(priority = 18, enabled = true)
	public void validDetailsCloseState() {

		assertEquals(TicketDetailsPge.getCloseState(), "False");
	}//end validDetailsCloseState
	
	
	//verify that the details message get hidden after clicking the message header
	@Test(priority = 19, enabled = true)
	public void validMessageHide() {

		TicketDetailsPge.clkBackBtn();
		firstRowDateString = ticketsPge.getDateTime();
		ticketsPge.clickMessages();
		TicketsMessagesPge.clkMessageHeader();
		
		assertFalse(TicketsMessagesPge.getMessageTextVisabilityState());
		
	}//end validDetailsHide
	
	//verify that the details message has valid header
	@Test(priority = 20, enabled = true)
	public void validMessageHeader() {
		
		assertEquals(TicketsMessagesPge.getMessageDate(),merchantName+" "+firstRowDateString);
		
	}//end validMessageDate
	
	//verify that the details message has valid text content
	@Test(priority = 21, enabled = true)
	public void validMessageContent() {
		TicketsMessagesPge.clkMessageHeader();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collapse0\"]/div")));
		assertEquals(TicketsMessagesPge.getMessageText(), details);
		
	}//end validMessageContent
	
	//verify that user can insert a reply
	@Test(priority = 22, enabled = true)
	public void reply() {
		
		TicketsMessagesPge.insertNewMessage(newMessage);
		TicketsMessagesPge.clkReply();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collapse1\"]/div")));
		assertEquals(TicketsMessagesPge.getReplyText(), newMessage);
		
	}//end validMessageContent
	
	//verify that user can close request
	@Test(priority = 23, enabled = true)
	public void closeRequest() {
		
		TicketsMessagesPge.insertNewMessage(newMessage);
		TicketsMessagesPge.clkClose();;
		wait.until(ExpectedConditions.urlToBe("https://upgstagportal.egyptianbanks.com/Portal/SupportTicketManagement/SupportTicket/MerchantRequests"));
		
	}//end closeRequest
	
	//verify that the checkBox is checked
	@Test(priority = 24, enabled = true)
	public void testCloseCheckboxChecked() {

		assertEquals(ticketsPge.getChcekBoxStatusFirstRow(),"true");
		
	}// end testCloseCheckboxChecked
	
	//verify that the closed date is valid
	@Test(priority = 25, enabled = true)
	public void validClosedDate() {
		//on progress
		systemDate = Calendar.getInstance().getTime();
		//assertEquals(,"true");
		System.out.println(ticketsPge.getClosedDate());
	}// end testCloseCheckboxChecked
	
	
		
	
}//
