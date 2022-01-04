package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	WebDriver myDriver;
	WebDriverWait wait; 
	
	By userName = By.id("UserName");
	By password = By.id("userpassword");
	By otpBtn = By.id("sendotp");
	By otpInpt = By.id("otp");
	By lgnBtn = By.id("signinbtn");
	
		
	public loginPage(WebDriver driver,  WebDriverWait wait) {

		this.myDriver = driver;
		this.wait = wait;
				}//end constructor
	
	public void setName(String userNameValue) {
		myDriver.findElement(userName).sendKeys(userNameValue);
	}//end setName
	
	public void setPass(String passWalue) {
		myDriver.findElement(password).sendKeys(passWalue);
	}//end setName
	
	public void clkOtp() {
		myDriver.findElement(otpBtn).click();
	}//end clkOtp
	
	public void setOtp(String otpValue) {
		myDriver.findElement(otpInpt).sendKeys(otpValue);
	}//end setOtp
	
	public void clkLogin() {
		myDriver.findElement(lgnBtn).click();
	}//end clkLogin
	
	public void validLogin(String userName, String password){
		
	    setName(userName);
		setPass(password);
		clkOtp();
		
		//wait.until(ExpectedConditions.elementToBeClickable(otpInpt));
		wait.until(ExpectedConditions.attributeToBe(otpInpt, "readonly", ""));
		
		setOtp("1111");
		clkLogin();
		
	}//end valid login
	

}//end class
