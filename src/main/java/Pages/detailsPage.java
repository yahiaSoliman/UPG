package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class detailsPage {

WebDriver myDriver;
	
	By merchantNameField = By.xpath("//*[@id=\"uploadForm\"]/div[2]/div/div/div[2]/div[4]/div[1]/div");
	
	public detailsPage(WebDriver myDriver) {
		
		this.myDriver = myDriver;
		
	}//end constructor
	
	/********Methods********/
	
	public String getMerchantName() {
		
		return myDriver.findElement(merchantNameField).getText();
		
	}//clkRotateButton
	
}//end class
