package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewBankPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	/***********Constructor***********/
	
	public NewBankPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		js = (JavascriptExecutor) driver;
		
	}//end constructor
	
	/**********Elements************/
	
	By bankName     = By.id("Bank_Name");
	By eCommerce    = By.xpath("(//*[@class='slider round'])[6]");
	By ics          = By.xpath("(//*[@class='slider round'])[7]");
	By nps 		    = By.xpath("(//*[@class='slider round'])[11]");
	By NPSacqCode   = By.id("BankConfiguration_NPSECommerceAcquirerCode");				
	By digitalQR    = By.xpath("(//*[@class='slider round'])[18]");
	By mVisa 	    = By.xpath("(//*[@class='slider round'])[19]");
	By mVisaAcqCode = By.id("BankConfiguration_mVisaAcquirerCode");
	By mVisaBin     = By.id("mVisaBin");
	By meezaDigital = By.xpath("(//*[@class='slider round'])[20]");
	By bankID       = By.name("BankTahweelScheme.TahweelBankId");
	By schemeID     = By.name("BankTahweelScheme.TahweelSchemeId");
	By schemeName   = By.name("BankTahweelScheme.TahweelSchemeName");
	By clientID     = By.name("BankTahweelScheme.SchemeClientId");	
	By saveBtn		= By.id("btnSave");
	
	
	
	/**********Methods************/
	
	public void insertName(String name) {
		
		driver.findElement(bankName).sendKeys(name);
		
	}//end insertName
	
	//**********************************
	
	public void clkECommerce() {
		
		driver.findElement(eCommerce).click();
		
	}//end clkECommerce
	
	//**********************************
	
	public void clkICS() {
		
		driver.findElement(ics).click();
		
	}//end clkICS
	
	//**********************************
	
	public void clkNPS() {
		
		driver.findElement(nps).click();
		
	}//end clkICS
	
	//**********************************
	
	public void insertAcqCode(String code) {
		
		driver.findElement(NPSacqCode).sendKeys(code);
		
	}//end insertName
	
	//**********************************
	
	public void clkDigitalQR() {
		
		driver.findElement(digitalQR).click();
		
	}//end clkICS
	
	//**********************************
	
	public void clkMVisa() {
		
		driver.findElement(mVisa).click();
		
	}//end clkICS
	
	//**********************************
	
	public void InsertMVisaBin(String BIN) {
		
		driver.findElement(mVisaBin).sendKeys(BIN);
		
	}//end insertMVisaBin
	
	//**********************************
	
	public void clkMeezaDigital() {
		
		driver.findElement(meezaDigital).click();
		
	}//end clkICS
	
	//**********************************
	
	public void InsertBankID(String ID) {
		
		driver.findElement(bankID).sendKeys(ID);
		
	}//end insertMVisaBin
	
	//**********************************
	
	public void InsertSchemeID(String ID) {
		
		driver.findElement(schemeID).sendKeys(ID);
		
	}//end insertMVisaBin
	
	//**********************************
	
	public void InsertSchemeName(String name) {
		
		driver.findElement(schemeName).sendKeys(name);
		
	}//end insertMVisaBin
	
	//**********************************
	
	public void InsertmVisaAcqCode(String mVisaAcqCodeValue) {
		
		driver.findElement(mVisaAcqCode).sendKeys(mVisaAcqCodeValue);
		
	}//end InsertmVisaAcqCode
	
	public void InsertClientID(String ID) {
		
		driver.findElement(clientID).sendKeys(ID);
		
	}//end insertMVisaBin
	
	//**********************************
	
	public void clkSaveBtn() {
		
	driver.findElement(saveBtn).click();
	
	}//end clkSaveBtn
	
	//----------------------------------
	
	public void insertBankData(String bankNameValue, String mVisaBinValue, String acquirerCode,
			String meezaDigitalBankIDValue, String meezaDigitalSchemeIDValue, String meezaDigitalSchemeNameValue,
			String meezaDigitalClientID) throws InterruptedException {
		

		insertName(bankNameValue); //insert bank name
		Thread.sleep(1000);
		  
		
		clkECommerce(); //enable ecommerce
		Thread.sleep(1000);
		
		
		clkICS(); //enable ICS
		Thread.sleep(1000);
		
		clkNPS(); //enable NPS
		
		js.executeScript("window.scrollBy(0,500)"); //scroll down

		wait.until(ExpectedConditions.visibilityOfElementLocated(NPSacqCode));
		insertAcqCode(acquirerCode); //insert acquirer code for NPS 
		
		clkDigitalQR();  //enable digital QR
		
		Thread.sleep(1000);
		
		clkMVisa(); //enable mVisa
		
		
		InsertMVisaBin(mVisaBinValue);// insert visa Bin
		InsertmVisaAcqCode("12345678912"); // inser mVisa Acquirer Code
		
		js.executeScript("window.scrollBy(0,500)"); //scroll down
		
		Thread.sleep(500);
		clkMeezaDigital(); //enable meeza digital
		Thread.sleep(2000);
		
		InsertBankID(meezaDigitalBankIDValue); //insert bank ID
		InsertSchemeID(meezaDigitalSchemeIDValue); //insert scheme ID
		InsertSchemeName(meezaDigitalSchemeNameValue); //insert scheme name
		InsertClientID(meezaDigitalClientID); //insert client ID
		
		js.executeScript("window.scrollBy(0,300)");  //scroll down
		Thread.sleep(500);
		clkSaveBtn(); //click save
	}//end insertBankData
	

	
}//end class
