package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankDetailsPage {
	
	WebDriver myDriver;
	WebDriverWait wait;
	
	/***********Constructor***********/
	
	public BankDetailsPage(WebDriver myDriver, WebDriverWait wait) {
		
		this.myDriver = myDriver;
		this.wait = wait;
		
	}//end constructor
	
   /**********Elements************/
	
	By activeSwitch    		 = By.xpath("//*[@id=\"MDRExTahweel_IsBinRule\"]/div");
	By bankName 	   		 = By.xpath("(//*[@class='col-xs-6'])[7]");
	By eCommerceSwitch		 = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[10]/div/div[2]/label/div");
	By ICSswitch 	  		 = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[11]/div/div[2]/label/div");
	By MIGSSwitch 	  		 = By.xpath("(//*[@class='col-xs-6'])[25]/label/div");
	By NPSSwitch 	   		 = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[14]/div/div[2]/label/div");
	By meezaDigitalBankID 	 = By.xpath("(//*[@class='col-xs-6'])[43]");
	By mVisaSwitch 	         = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[17]/div/div[2]/label/div");
	By acquirerCode          = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[15]/div/div[2]");
	By mVisaBin 		     = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[18]/div/div[2]");
	By meezaDigitalSchemeID  = By.xpath("(//*[@class='col-xs-6'])[45]");
	By meezaDigitalScemeName = By.xpath("(//*[@class='col-xs-6'])[47]");
	By meezaDigitalClientID  = By.xpath("(//*[@class='col-xs-6'])[49]");
	By creationDate 		 = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[25]/div/div[2]");
	
	/*********Methods************/

	public String getColorOfActiveSwitch() {
		
		return Color.fromString(myDriver.findElement(By.xpath("//*[@id=\"MDRExTahweel_IsBinRule\"]/div"))
				.getCssValue("background-color")).asHex();
		
	}//end getColorOfActiveSwitch
	
	//--------------------------------------------------------
	
	public String getBankName() {
		
		return myDriver.findElement(bankName).getText();
		
	}//end getBankName
	
	//---------------------------------------------------------
	
	public String getColorOfeCommerceSwitch() {
	
	return Color.fromString(myDriver.findElement(eCommerceSwitch).getCssValue("background-color")).asHex();
	
	}//end getColorOfeCommerceSwitch
	
	//---------------------------------------------------------
	
	public String getColorOfICSSwitch() {
		
	return Color.fromString(myDriver.findElement(ICSswitch).getCssValue("background-color")).asHex();
	
	}//end getColorOfeCommerceSwitch
	
	//---------------------------------------------------------
	
	public String getColorOfMIGSSwitch() {
		
	return Color.fromString(myDriver.findElement(MIGSSwitch).getCssValue("background-color")).asHex();
	
	}//end getColorOfeCommerceSwitch
	
	//---------------------------------------------------------
	
	public String getColorOfNPSSwitch() {
		
	return Color.fromString(myDriver.findElement(NPSSwitch).getCssValue("background-color")).asHex();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	public String getMeezaDigitalBankID() {
		
	return myDriver.findElement(meezaDigitalBankID).getText();	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	public String getColorOfmVisaSwitch() {
		
	return Color.fromString(myDriver.findElement(mVisaSwitch).getCssValue("background-color")).asHex();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	public String getAcquirerCode() {
		
	return myDriver.findElement(acquirerCode).getText();	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	public String getmVisaBIN() {
		
	return myDriver.findElement(mVisaBin).getText();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	public String getMeezaDigitalSchemeID() {
		
	return myDriver.findElement(meezaDigitalSchemeID).getText();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	

	public String getMeezaDigitalSchemeName() {
		
	return myDriver.findElement(meezaDigitalScemeName).getText();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------

	public String getMeezaDigitalClientID() {
		
	return myDriver.findElement(meezaDigitalClientID).getText();
	
	}//end getColorOfeCommerceSwitch
	
	//----------------------------------------------------------
	
	//creationDate
	public String getCreationDate() {
		
	return myDriver.findElement(creationDate).getText();
	
	}//end getColorOfeCommerceSwitch
	
}//end BankDetailsPage
