package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApprovalPipleLinePAge {

	
	WebDriver myDriver;
	WebDriverWait wait;
	
	By stCheckBox 			= By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/table/tbody/tr[1]/td[2]/center/input");
	By details1st 			= By.xpath("(//*[@title='Details'])[1]");
	By approveAllBtn 		= By.id("btnReply");
	By firstpipeLineID 		= By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/table/tbody/tr[1]/td[2]");
	By firstActionType 		= By.xpath("//tbody/tr/td[7]");
	By firstOperationType 	= By.xpath("//tbody/tr/td[6]");
	By firstStatus 			= By.xpath("//tbody/tr/td[5]");
	By checkAllBox 			= By.id("GirdCheckBox");
	By searchHeader 		= By.id("searchHeader");
	By statusDropDownList 	= By.id("Status");
	By itemsCount 			= By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/div/p");
	By srchBtn 				= By.xpath("//*[@id=\"searchBody\"]/div[2]/div/div/button");
	By apprBtn 				= By.id("btnSave");
	
	//constructor
	public ApprovalPipleLinePAge(WebDriver myDriver, WebDriverWait wait) {
		
		this.myDriver = myDriver;
		this.wait = wait;
		
	}//end constructor
	
	/********Methods********/
	
	public void clkstCheckBox() {
		
		myDriver.findElement(stCheckBox).click();
		
	}//clkdetailsButton
	
	//-------------------------
	
	public void clkCheckAllBox() {
		
		myDriver.findElement(checkAllBox).click();
		
	}//clkCheckAllBox
	
	//-------------------------
	
	public void clkapproveAllBtn() {
		
		myDriver.findElement(approveAllBtn).click();
		
	}//clkapproveAllBtn
	
	//------------------------
	
	public void clkDetailsofFirsRow() {
		
		myDriver.findElement(details1st).click();
		
		}//clkBankManagement
	
	//------------------------
	
	public String getFirstpipeLineID() {
		
		return myDriver.findElement(firstpipeLineID).getText();
		
		}//getFirstpipeLineID
	
	//------------------------
	
	public String getFirstActionType() {
		
		return myDriver.findElement(firstActionType).getText();
		
		}//getFirstActionType
	
	//------------------------
	
	public String getFirstOperatiopnType() {
		
		return myDriver.findElement(firstOperationType).getText();
		
		}//getFirstOperatiopnType
	
	//----------------------
	
	public void clkSrchHdr() {
		myDriver.findElement(searchHeader).click();
	}//end clkSrchHdr
	
	//----------------------
	
	public void selectSatus(String statusValue) {
		
		Select Drop1 = new Select(myDriver.findElement(statusDropDownList));
		Drop1.selectByVisibleText(statusValue);
		
	}//end selectSatus
	
	//----------------------
	
	public String getItemsCount() {
		
		return myDriver.findElement(itemsCount).getText();
	}//end getItemsCount
	
	//----------------------
	
		public void clkApproveBtn() {
			
		 myDriver.findElement(apprBtn).click();
		 
		}//end getItemsCount
		
		//----------------------
		
		public String getStatusOfFirstRow() {
			
			return myDriver.findElement(firstStatus).getText();
			
		}//end getStatusOfFirstRow
			
	
	//----------------------
	
	public void clkSrch() {
		
		myDriver.findElement(srchBtn).click();
		WebElement elemnt1 = myDriver.findElement(srchBtn); 
		wait.until(ExpectedConditions.textToBePresentInElement(elemnt1, "Search"));
		 
	}//end clkSrch
	
}// end ApprovalPipleLinePAge
