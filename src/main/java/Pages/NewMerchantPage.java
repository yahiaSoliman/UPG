package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMerchantPage {
	
	
	WebDriver driver;
	 WebDriverWait wait;
	 
	public NewMerchantPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait; 
	}//end constructor
	
	/****************Elements****************/
	
	By bankList 			= By.id("BankId");
	By merchantNameElement  = By.id("MerchantName");
	By categoryName 		= By.name("Merchant.CategoryCodeId_input");
	By cityName     		= By.name("Merchant.StateId_input");
	By phoneNumber  		= By.name("TempMerchant_ContactPersonPhone");
    By refundCheckBox 		= By.id("MerChantUserCanRefund");
    By address				= By.id("Merchant_Address1");
    By accountType 			= By.id("SettlementAccountType");
    By merchantID			= By.id("MerchantID");
    
	By merchantFullName 	= By.id("MerchantFullName");
	By merchantUserEmail 	= By.name("MerchantUserEmail");
	By notificationMethod 	= By.id("NotificationId");
	By loginMethod   		= By.name("MerchantUserNameSelectedType");
	
	By meezaDigitalSwitch 		 = By.xpath("//*[@id=\"dvTahweel\"]/div/div/div[2]/label/div");
	By meezaIdentificationType   = By.id("WalletAccount_IdentificationType");
	By meezaIdentificationNumber = By.id("WalletAccount_IdentificationNumber");
	By meezaAccount 			 = By.xpath("//*[@id=\"uploadForm\"]/div[2]/div/div/div[4]/div[3]/div/div[2]/label/div");	
	
	By mVisaAccount 			= By.xpath("//*[@id=\"uploadForm\"]/div[2]/div/div/div[4]/div[3]/div/div[2]/label/div");
	By payLink 					= By.xpath("//*[@id=\"dvPayLink\"]/div[2]/label/div");
	By saveBtn 					= By.id("btnSave");
	
	//----MIGS Data
	
	By migsAccount 				= By.xpath("//*[@id=\"dvMiGS\"]/div/div/div[2]/label/div");	
	By migsHost 			= By.xpath("//*[@id=\"uploadForm\"]/div[2]/div/div/div[4]/div[6]/div/div[1]/div[1]/div[2]/label/div");
	By migsAMAmerchantID 	= By.id("migs_0__AMAMerchantId");
	By migsAMAuser 			= By.id("migs_0__AMAUser");
	By migsAMAaccessCode 	= By.id("migs_0__AMAAccessCode");			
	By AMAsecretHashKey 	= By.id("migs_0__AMASecretHashKey");
	By AMApassword			= By.id("migs_0__AMAPassword");
	
	//------MPGS Data
	By mpgsAccount 			= By.xpath("//*[@id=\"dvMPGS\"]/div/div/div[2]/label/div");
	By mpgsAccount2			= By.xpath("//*[@id=\"uploadForm\"]/div[2]/div/div/div[4]/div[7]/div/div[1]/div[1]/div[2]/label/div");
										
	By mpgsUserName 		= By.name("mpgs[0].UserName");
	By mpgsPassword 		= By.name("mpgs[0].Password");
	By mpgsURL 				= By.name("mpgs[0].URL");
	By mpgsMerchantName 	= By.name("mpgs[0].MerchantName");
	
	By invoiceSwitch 		= By.xpath("	//*[@id=\"dvInvoiceCloud\"]/div[2]/label/div");
	By payLinkSwitchGrey	= By.xpath("//*[@id=\"dvPayLink\"]/div[2]/label/div");
	
	/****************Methods*****************/
	
	public void selectBank(String bankID) {

		Select drpUserRole = new Select(driver.findElement(bankList));
		drpUserRole.selectByValue(bankID);
		
	}//end selectBank
	
	//---------------------------------------------
	public void insertMerchantName(String merchantNameValue) {
		
		driver.findElement(merchantNameElement).sendKeys(merchantNameValue);		
		
	}//end insertMerchantName
	
	//------------------------------------------
	
	public void clearMerchantName() {
		
		driver.findElement(merchantNameElement).clear();
		
	}//end clearMerchantName
	
	//------------------------------------------
	
	public void insertCategoryName(String categoryNameValue) {
		
		driver.findElement(categoryName).sendKeys(categoryNameValue);		
		
	}//end insertMerchantName
	
	//------------------------------------------
	
	public void insertCityName(String cityNameValue) {
		
		driver.findElement(cityName).sendKeys(cityNameValue);		
		
	}//end insertCityName
	
	//------------------------------------------
	
	public void insertAddress(String addressValue) {
		
		driver.findElement(address).sendKeys(addressValue);		
		
	}//end insertAddress
	
	//------------------------------------------
	
	public void insertMobile(String mobileNumber) {
		
		driver.findElement(phoneNumber).sendKeys(mobileNumber);		
		
	}//end mobileNumber
	
	//------------------------------------------
	
	public void clkRefundCheckBox() {
		
		driver.findElement(refundCheckBox).click();		
		
	}//end clkRefundCheckBox
	
	//------------------------------------------
	
	public void clkAccountType() {
		
		driver.findElement(accountType).click();	
		
	}//end clkAccountType
	
	//------------------------------------------
	
	public void selectAccountType(String accountTypeValue) {

		Select drpUserRole = new Select(driver.findElement(accountType));
		drpUserRole.selectByVisibleText(accountTypeValue);
		
	}//end selectAccountType
	
	//------------------------------------------
	
	public void clkMeezaDigitalSwitch() {
		
		driver.findElement(meezaDigitalSwitch).click();		
		
	}//end clkmeezaDigitalSwitch
	
	//------------------------------------------
	
	public void clkMeezaIdentificationType() {
		
		driver.findElement(meezaIdentificationType).click();	
		
	}//end clkMeezaIdentificationType
	
	//------------------------------------------
	
	public void selectMeezaIdentificationType(String identificationTypeValue) {

		Select drpUserRole = new Select(driver.findElement(meezaIdentificationType));
		drpUserRole.selectByVisibleText(identificationTypeValue);
		
	}//end selectMeezaIdentificationType
	
	//------------------------------------------
	
	public void insertMeezaIdentificationNumber(String identificationNumberValue) {
		
		driver.findElement(meezaIdentificationNumber).sendKeys(identificationNumberValue);		
		
	}//end insertMeezaIdentificationNumber
	
	//------------------------------------------
	
	public void clkMeezaAccountSwitch() {
		
		driver.findElement(meezaAccount).click();		
		
	}//end clkMeezaAccountSwitch
	
	//------------------------------------------
	
	public void clkMigsAccountSwitch() {
		
		driver.findElement(migsAccount).click();		
		
	}//end clkMigsAccountSwitch
	
	//------------------------------------------
	
	public void clkMigsHostSwitch() {
		
		driver.findElement(migsHost).click();		
		
	}//end clkMigsHostSwitch
	
	//------------------------------------------
	
	public void insertmigsAMAmerchantID(String AMAmerchantIDValue) {
		
		driver.findElement(migsAMAmerchantID).sendKeys(AMAmerchantIDValue);		
		
	}//end insertmigsAMAmerchantID
	
	//------------------------------------------
	
	public void insertmigsAMAuser(String migsAMAuserValue) {
		
		driver.findElement(migsAMAuser).sendKeys(migsAMAuserValue);		
		
	}//end insertmigsAMAuser
	
	//------------------------------------------
	
	public void insertmigsAMAaccessCode(String migsAMAaccessCodeValue) {
		
		driver.findElement(migsAMAaccessCode).sendKeys(migsAMAaccessCodeValue);		
		
	}//end insertmigsAMAaccessCode
	
	//------------------------------------------
	
	public void insertmigsAMAsecretHashKey(String AMAsecretHashKeyValue) {
		
		driver.findElement(AMAsecretHashKey).sendKeys(AMAsecretHashKeyValue);		
		
	}//end insertAMAsecretHashKey
	
	//------------------------------------------
	
	public void insertmigsAMApassword(String AMApasswordValue) {
		
		driver.findElement(AMApassword).sendKeys(AMApasswordValue);		
		
	}//end insertAMApassword
	
	//------------------------------------------
	
	public void clkMvisaAccount() {
		
		driver.findElement(mVisaAccount).click();		
		
	}//end clkMvisaAccount
	
	//------------------------------------------
	
	public void clkPayLink() {
		
		driver.findElement(payLink).click();		
		
	}//end clkPayLink
	
	//------------------------------------------
	
	public void insertMerchantFullName(String merchantFullNameValue) {
		
		driver.findElement(merchantFullName).sendKeys(merchantFullNameValue);		
		
	}//end insertMerchantFullName
	
	//------------------------------------------
	
	
	public void insertMerchantUserEmail(String merchantUserEmailValue) {
		
		driver.findElement(merchantUserEmail).sendKeys(merchantUserEmailValue);		
		
	}//end insertMerchantUserEmail
	
	//------------------------------------------
	
	public void clkNotificationMethod() {
		
		driver.findElement(notificationMethod).click();	
		
	}//end clkNotificationMethod
	
	//------------------------------------------
	
	public void selectNotificationMethod(String notificationMethodValue) {

		Select drpUserRole = new Select(driver.findElement(notificationMethod));
		drpUserRole.selectByVisibleText(notificationMethodValue);
		
	}//end selectNotificationMethod
	
	//------------------------------------------
	
	public void clkloginMethod() {
		
		driver.findElement(loginMethod).click();	
		
	}//end clkloginMethod
	
	//------------------------------------------
	
	public void selectloginMethod(String loginMethodValue) {

		Select drpUserRole = new Select(driver.findElement(loginMethod));
		drpUserRole.selectByVisibleText(loginMethodValue);
		
	}//end selectloginMethod
	
	//------------------------------------------
	
	
	public void clkSave() {
		
		driver.findElement(saveBtn).click();	
		
	}//end clkSave
	
	//------------------------------------------
	
	public void clickMPGS1() {

		driver.findElement(mpgsAccount).click();	
		
	}//end clickMPGS1 
	
	//------------------------------------------
	
	public void clickMPGS2() {
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(mpgsAccount2)));
		driver.findElement(mpgsAccount2).click();	
		
		
	}//end clickMPGS2
	
	//------------------------------------------
	
	public void setMpgsUserName(String mpgsUserNameValue) {
		
		driver.findElement(mpgsUserName).sendKeys(mpgsUserNameValue);	
		
		
	}//end setMpgsUserName
	
	//------------------------------------------
	
	public void setMpgsPassword(String mpgsPasswordValue) {
		
		driver.findElement(mpgsPassword).sendKeys(mpgsPasswordValue);	
		
	}//end setMpgsPassword
	
	//------------------------------------------
	
	public void setMpgsURLValue(String mpgsURLValue) {
		
		driver.findElement(mpgsURL).sendKeys(mpgsURLValue);	
		
	}//end setMpgsURLValue
	
	//-----------------------------------------
	
	public String getMerchantID() {
		
		//wait.until(ExpectedConditions.text);
		return driver.findElement(merchantID).getText();	
		
	}//end getMerchantID
	
	//------------------------------------------
	
	public void insertMerchantID(String merchantIDValue) {
		
		driver.findElement(merchantID).clear();
		driver.findElement(merchantID).sendKeys(merchantIDValue);	
		
	}//end insertMerchantID
	//------------------------------------------
	
	public void setMpgsMerchantName(String mpgsMerchantNameValue) {
		
		driver.findElement(mpgsMerchantName).sendKeys(mpgsMerchantNameValue);	
		
	}//end setMpgsMerchantName
	
	//open invoice cloud switch in grey
	public void clkInvoiceSwitch() {
		
		driver.findElement(invoiceSwitch).click();
		
	}//end clkInvoiceSwitch
	
	//open paylink switch on grey
	public void clkPaylinkSwitch() {
		
		driver.findElement(payLinkSwitchGrey).click();
		
	}//end clkPaylinkSwitch
	
}//end NewMerchantPage
