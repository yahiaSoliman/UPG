package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantsListPage {
	
	WebDriver myDriver;
	WebDriverWait wait;	

	By rotateButton = By.className("rotate");
	By addButton = By.xpath("/html/body/div[2]/div[2]/div/div[4]/a[4]/span");
	By detailsButton = By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr[1]/td[9]/b/a");
	By editButton = By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr[1]/td[8]/b/a");
	By merchantName1stRow = By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr[1]/td[2]");
	By searchHeader = By.id("searchHeader");
	By merchantIDinputField = By.id("MerchantRefId_Name");
	By searchBtn = By.xpath("//button[@type = 'submit']");
	By terminalBtn = By.xpath("//*[@id=\"divListPanel\"]/div[2]/div/table/tbody/tr/td[10]/b/a");	
	By deleteBtn = By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr[1]/td[12]/div/form/button");
    By deleteCnfrm = By.xpath("//a[@class='btn btn-xs btn-primary']");
    By status = By.xpath("//*[@id=\"divListPanel\"]/div[3]/div/table/tbody/tr[1]/td[5]");
    By alertMessage = By.xpath("/html/body/div[2]/div[2]/div/div[1]/p");
    							
	
	public MerchantsListPage(WebDriverWait wait, WebDriver myDriver) {
		
		this.myDriver = myDriver;
		this.wait = wait;
	}//end constructor
	
	/********Methods********/
	
	public void clkRotateButton() {
		
		myDriver.findElement(rotateButton).click();
		
	}//clkRotateButton
	
	public void clkAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		myDriver.findElement(addButton).click();
		
	}//end clkAddButton
	
	public void clkDetailsButton() {
		
		myDriver.findElement(detailsButton).click();
		
	}//end clkDetailsButton
	
	
	public void clkEditButton() {
	
	myDriver.findElement(editButton).click();
	
	
}//end clkEditButton
	
	public void clkEditButtonNewTab() {
		
		myDriver.findElement(editButton).sendKeys(Keys.CONTROL +"t");;
	
	
}//end clkEditButtonNewTab
	
	
	
	public String getmerchantName1stRow() {
		
		return myDriver.findElement(merchantName1stRow).getText();
		
	}//end clkAddButton
	
	public void clickSearchHeader() {
		myDriver.findElement(searchHeader).click();
	}
	
	public void insertMerchantID(String merchantIDvalue) {
		myDriver.findElement(merchantIDinputField).sendKeys(merchantIDvalue);
		myDriver.findElement(merchantIDinputField).sendKeys(Keys.DOWN, Keys.RETURN);
		//myDriver.findElement(merchantIDinputField).sendKeys(Keys.ENTER);
	}
	
	public void clkSearchBtn() {
		myDriver.findElement(searchBtn).click();
	}
	
	public void clkTerminalsBtn() {
		myDriver.findElement(terminalBtn).click();
	}
	
	public void clkDelete() {
		myDriver.findElement(deleteBtn).click();
	}
	
	public void clkCnfrm() {
		myDriver.findElement(deleteCnfrm).click();
	}
	
	public String  getStatus() {
		return myDriver.findElement(status).getText();
	}
	
	public String  getpipleLineID() {
		return myDriver.findElement(alertMessage).getText();
	}
	

}//end MerchantsListPage
