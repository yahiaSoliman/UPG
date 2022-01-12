package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUsersPage {

WebDriver myDriver;
	
	By rotateButton = By.className("rotate");
	By addButton = By.xpath("/html/body/div[2]/div[2]/div/div[4]/a[3]");

	
	
	public ManageUsersPage(WebDriver myDriver) {
		
		this.myDriver = myDriver;
		
	}//end constructor
	
	/********Methods********/
	
	public void clkRotateButton() {
		
		myDriver.findElement(rotateButton).click();
		
	}//clkRotateButton
	
	//--------------------------------------
	
	public void clkAddButton() {
		
		myDriver.findElement(addButton).click();
		
	}//end clkAddButton
	
	
}//end class
