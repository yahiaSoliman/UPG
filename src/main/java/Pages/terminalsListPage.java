package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class terminalsListPage {

	WebDriver myDriver;
	WebDriverWait wait;	
	
	By merchantID1stRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[4]");
	By terminalID1stRow = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr[1]/td[2]");
	By rotateButton 	= By.className("rotate");
	By addButton 		= By.xpath("/html/body/div[2]/div[2]/div/div[4]/a[3]/span");
							 
	
	public terminalsListPage(WebDriver myDriver, WebDriverWait wait) {
		
		this.myDriver = myDriver;
		this.wait = wait;
		
	}//end constructor
	
	/********Methods********/
	
	//click on rotate button
	public void clkRotateButton() {
		
		myDriver.findElement(rotateButton).click();
		
	}//clkRotateButton
	
	
	//click on add button
	public void clkAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		myDriver.findElement(addButton).click();
		
	}//end clkAddButton
	
	public String getMerchantIDof1stRow() {
		
		return myDriver.findElement(merchantID1stRow).getText();
		
	}//clkRotateButton
	
	public String getTerminalIDof1stRow() {
		
		return myDriver.findElement(terminalID1stRow).getText();
		
	}//clkRotateButton
}
