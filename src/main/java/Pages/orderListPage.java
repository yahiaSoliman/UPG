package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orderListPage {

	WebDriver myDriver;
	WebDriverWait wait;	
		
	By rotateButton = By.className("rotate");
	By statusField =  By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[1]/td[5]");
	By statusField2 =  By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/div/table/tbody/tr[1]/td[5]");
											
	By relaodBtn = By.xpath("/html/body/div[2]/div[2]/div/div[4]/a[1]/span");
							 
	public orderListPage(WebDriverWait wait, WebDriver myDriver) {
		
		this.myDriver = myDriver;
		this.wait = wait;
	}//end constructor
	
	//-------------------------
	
	public String  getStatus() {
		
		return myDriver.findElement(statusField).getText(); 
	}//end getStatus
	
	//-------------------------
	
	public String  getStatus2() {
		
		return myDriver.findElement(statusField2).getText(); 
	}//end getStatus2
	
	
	//--------------------------
	
	public void clickRotateBtn() {
		
		myDriver.findElement(rotateButton).click(); 
	}//end clickRotateBtn
	
	//-----------------------
	
	public void clickReloadBtn() {
		
		myDriver.findElement(relaodBtn).click(); 
		
	}//end clickReloadBtn
	
	
	
		
}//end orderListPage
