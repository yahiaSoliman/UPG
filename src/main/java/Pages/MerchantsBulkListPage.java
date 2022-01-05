package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantsBulkListPage {
	
		
		WebDriver driver; //chrome driver
		WebDriverWait wait;	//wait
		
		By rotateButton = By.className("rotate");
		By addButton = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/a[2]/span");	
		By addFile = By.id("attachments");		
		By saveBtn = By.id("btnSave");
		By clkActions = By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/table/tbody/tr[1]/td[6]/b/div/a");
								 
		By sndBulkBtn = By.id("btnSaveBulk");
	
		public MerchantsBulkListPage(WebDriverWait wait, WebDriver myDriver) {
			
			this.driver = myDriver;
			this.wait = wait;
		}//end constructor	
		
		//------------------------
		
		public void clkRotateButton() {
			
			driver.findElement(rotateButton).click();
			
		}//clkRotateButton
		
		//------------------------
		public void clkAddButton() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
			driver.findElement(addButton).click();
			
		}//end clkAddButton
		
		//------------------------
		public void selectFile(String filePath) {
			driver.findElement(addFile).sendKeys(filePath);
		}//end selectFile
		
		//-------------------------
		public void clkSaveBtn() {
			driver.findElement(saveBtn).click();
		}//end clkAddButton	
		
		//-------------------------
		public void clkSndBtn() {
			driver.findElement(sndBulkBtn).click();
		}//end clkSndBtn
		
		//-------------------------
		public void clkActionBtn() {
				wait.until(ExpectedConditions.visibilityOfElementLocated(clkActions));
				driver.findElement(clkActions).click();
		}//end clkActionBtn
		
		
		
		

}// end MerchantsBulkListPage
