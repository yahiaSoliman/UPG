package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class valueAddedServicesPage {
	
	WebDriver driver; //chrome driver
	WebDriverWait wait; 
	

	
	/*********Elements**********/
	
	By createPaymentOrder = By.xpath("//div[@class='panel-footer announcement-bottom']");
	By viewPaymentOrderStatus = By.partialLinkText("View Payment Order Status");
	/********Constructor*****/
	
	public valueAddedServicesPage(WebDriver myDriver,  WebDriverWait wait) {
		
		this.driver = myDriver;
		this.wait = wait;
	}//end constructor	
	
	/*************Methods*************/
	
	public void clkCreatePaymentOrder() {
		 wait.until(ExpectedConditions.elementToBeClickable(createPaymentOrder));	
		driver.findElement(createPaymentOrder).click();
		
	}//end clkCreatePaymentOrder
	
	//-----------------------------------
	
	public void clkViewPaymentOrderStatus() {
		 wait.until(ExpectedConditions.elementToBeClickable(viewPaymentOrderStatus));	
		 driver.findElement(viewPaymentOrderStatus).click();
		
	}//end clkViewPaymentOrderStatus
	
	

}
