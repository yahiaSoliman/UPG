package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class createNewOrderPage {

	WebDriver driver; //chrome driver
	

	
	/*********Elements**********/
	
	By terminalList = By.id("NodeId");
	By amount = By.id("Amount");
	By email = By.id("Email");
	By saveBtn = By.id("btnSave");
	By orderLink = By.partialLinkText("https://");
	By orderLinkGrey = By.partialLinkText("http://");	
	//By orderLink = By.partialLinkText("http://"); for 140
	By payNow1st = By.id("btnSubmit");
	By cardNumber = By.id("CardNumber");
	By expirationDate = By.id("Expiration");
	By CVV = By.id("CVV");
	By cardName = By.id("NameOnCard");
	By payNow2nd = By.id("pay");
	By orderPaidError = By.xpath("//*[@id=\"container\"]/div/div/p");
	By paymentType = By.id("PaymentType");
	By numberOfPayments = By.id("MaxNumberOfPayment");
	By orderID = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div[2]");
	By numberOfPaymentsConfirm = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div[2]");
	By systemReference = By.id("pReferenceNumber");
	/********Constructor*****/
	
	public createNewOrderPage(WebDriver myDriver) {
		
		this.driver = myDriver;
	}//end constructor	
	
	/*************Methods*************/
	
	public void selectTerminal(String terminaID) {
		
		Select drop1 = new Select(driver.findElement(terminalList));
		drop1.selectByVisibleText(terminaID);
		
	}//end selectTerminal
	
	//---------------------------------
	
	public void setAmount(String amountValue) {
		
		driver.findElement(amount).sendKeys(amountValue);
		
	}//end setAmount
	
	//---------------------------------
	
	public void setEmail(String emailValue) {
		
		driver.findElement(email).sendKeys(emailValue);
		
	}//end setEmail
	
	//---------------------------------
	
	public void clckSaveBtn() {
		
		driver.findElement(saveBtn).click();
		
	}//end clckSaveBtn
	
	//---------------------------------
	
	public String getOrderLink() {
		
		return driver.findElement(orderLink).getText();
		
	}//end getOrderLink
	
	//---------------------------------
	
	public void clkOrderLink() {
		
		driver.findElement(orderLink).click();
	}//end getOrderLink
	
	
	//---------------------------------
	
	public void clkPayNow1st() {
		
		driver.findElement(payNow1st).click();
		
	}//end clkPayNow1st
	
	//---------------------------------
	
	public String getOrderLinkGrey() {
		
		return driver.findElement(orderLinkGrey).getText();
		
	}//end getOrderLink
	
	
	//---------------------------------
	
	public void insertCardNumber(String cardNumberValue) {
		
		driver.findElement(cardNumber).sendKeys(cardNumberValue);
		
	}//end insertCardNumber
	
	//---------------------------------
	
	public void insertExpirationDate(String expirateDateValue) {
		
		driver.findElement(expirationDate).sendKeys(expirateDateValue);
		
	}//end insertExpirationDate
	
	//---------------------------------
	
	public void insertCVV(String CVVvalue) {
		
		driver.findElement(CVV).sendKeys(CVVvalue);
		
	}//end insertCVV
	
	
	//---------------------------------
	
	public void insetCardName(String cardNameValue) {
		
		driver.findElement(cardName).sendKeys(cardNameValue);
		
	}//end insetCardName
	
	
	
	//---------------------------------
	
	public void clkPayNow2nd() {
		
		driver.findElement(payNow2nd).click();
		
	}//end clkPayNow2nd
	
	//---------------------------------
	
	public String getErrorMessageOfOrderPaid() {
		
		return driver.findElement(orderPaidError).getText();
		
	}//end getErrorMessageOfOrderPaid
	
	//---------------------------------
	
	public void selectPaymentType(String paymentTypeValue) {
		
		Select drop1 = new Select(driver.findElement(paymentType));
		drop1.selectByVisibleText(paymentTypeValue);
		
	}//end selectPaymentType
	
	
	//---------------------------------
	
	public void setNumberOfPayments(String numberOfPaymetnsValue) {
		
		driver.findElement(numberOfPayments).clear();
		driver.findElement(numberOfPayments).sendKeys(numberOfPaymetnsValue);
		
	}//end setNumberOfPayments
	
	//---------------------------------
	
	public String getOrderID() {
		
		return driver.findElement(orderID).getText();
		
	}//end getOrderID
	
	//--------------------------------
	
	public String getTrxRef() {
		
		return driver.findElement(systemReference).getText();
		
	}//end getTrxRef
	
	//---------------------------------
	
	public String getNumnerOfPaymentsConfirm() {
		
		return driver.findElement(numberOfPaymentsConfirm).getText();
		
	}//end getOrderID
	
	//insert data into light box
	public void filLightBox() {
		
		//insert CardNumber 			
		insertCardNumber("5123");
		insertCardNumber("4567");
		insertCardNumber("8901");
		insertCardNumber("2346");
						
		//insert Expiration date
		insertExpirationDate("05");
		insertExpirationDate("24");
						
		//insert CVV
		insertCVV("100");
					 
		//insert NameOnCard
		insetCardName("Yahia");
	 
	}//end filLightBox
		
	
	
	
	
	
	
}//end class
