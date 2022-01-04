package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class transactionReportPage {
	
	
	WebDriver driver;
	
	By transactionAmount        = By.xpath("//*[@id=\"trxTable\"]/div[2]/div/table/tbody/tr[1]/td[6]");
	By branchTransactionAmount  = By.xpath("//tbody/tr/td[6]");
	By branchName1stRow  		= By.xpath("//tbody/tr/td[3]");
	By branchName2ndRow  		= By.xpath("//tbody/tr[2]/td[3]");
	By itemCounts		 		= By.xpath("//div[@class='grid-footer']/p");

	
	//constructor	
	public transactionReportPage(WebDriver driver) {

		this.driver = driver;

	}//end constructor
	
	
	//get the transaction amount value in EGP
	public String getAmount() {
		
		return driver.findElement(transactionAmount).getText();
		
	}//end getAmount
	
	//get branch user transaction amount
	public String getBranchTrxAmount() {
		
		return driver.findElement(branchTransactionAmount).getText();
		
	}//end getBranchTrxAmount
	
	
	public String getBranchNameOf1stRow() {
		
		return driver.findElement(branchName1stRow).getText();
		
	}//end getBranchNameOf1stRow
	
	public String getBranchNameOf2ndRow() {
		
		return driver.findElement(branchName2ndRow).getText();
		
	}//end  getBranchNameOf2ndRow
	
	//get items count
	public String getItemCounts() {
		
		return driver.findElement(itemCounts).getText();
		
	}//end getItemCounts

}//end transactionReportPage
