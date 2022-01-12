package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bankListPage {
	
	WebDriver myDriver;
	WebDriverWait wait;
	
	By rotateButton = By.className("rotate");
	By addButton = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/a[3]/span");
	By detailsButton = By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/table/tbody/tr[1]/td[5]/b/a");
	By detailsWindowClose = By.xpath("//*[@id=\"UpdateWindowContent\"]/div/div[1]/button/span");
	By bankNameSearch = By.id("BankName");
	By searchBtn 	  = By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[2]/div/div/button");	
	By searchBar 	  = By.id("searchHeader");	
	By bankID 		  = By.xpath("//*[@id=\"divListPanel\"]/div/div[2]/div/table/tbody/tr/td[2]");	
	
	
	public bankListPage(WebDriver myDriver, WebDriverWait wait) {
		
		this.myDriver = myDriver;
		this.wait = wait;
		
	}//end constructor
	
	/********Methods********/
	
	public void clkRotateButton() {
		
		myDriver.findElement(rotateButton).click();
		
	}//clkRotateButton
	
	public void clkAddButton() {
		
		myDriver.findElement(addButton).click();
		
	}//end clkAddButton
	
	public void clkDetailsButton() {
		
		
		myDriver.findElement(detailsButton).click();
		
	}//end clkDetailsButton
	
	//-----------------------------------
	
	public void clkDetailsWindowClose() {
		
		myDriver.findElement(detailsWindowClose).click();
		
	}//end clkDetailsButton
	
	//-------------------------------------
	
	public void openNewBankPage() {
		
	clkRotateButton();
	clkAddButton();
	
	}//end clkDetailsWindowClose
	
	//------------------------------------
	
	public void insertBankNameSearch(String bankName) {
		
		myDriver.findElement(bankNameSearch).sendKeys(bankName);
		
	}//end seachByBankName
	
	//------------------------------------
	
	public void clkSearchBtn() {
		
		myDriver.findElement(searchBtn).click();
		
	}//end seachByBankName
	
	//------------------------------------
	
	public void clkSearchBar() {
		
		myDriver.findElement(searchBar).click();
		
	}//end seachByBankName
	
	//--------------------------------------
	
	public void searchByName(String bankNameValue) throws InterruptedException {
		
		clkSearchBar();
		insertBankNameSearch(bankNameValue);
		clkSearchBtn();
		wait.until(ExpectedConditions.textToBe(searchBtn, "Search"));
		
	}//end searchByName
	
	//------------------------------------
	
	public String getBankID() {
		
		return myDriver.findElement(bankID).getText();
		
	}//end getBankID
	
	
}//end bankListPage
