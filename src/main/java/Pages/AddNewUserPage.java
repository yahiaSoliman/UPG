package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewUserPage {

	WebDriver driver;

	public AddNewUserPage(WebDriver driver) {

		this.driver = driver;
	}// end Constructor

	/************ Elements **************/

	By UserRole = By.id("UserRole");
	By BankName = By.id("BankId");
	By UserName = By.id("UserName");
	By FullName = By.id("FullName");
	By Email = By.id("Email");
	By PhoneNum = By.id("TempPhone");
	By NotificationMethod = By.id("NotificationId");
	By RegisterBtn = By.id("btnSave");
	By PrivligesBox = By.xpath("//*[@id=\"PipelineOperationsContent\"]/div/div[2]/div/div/div/input");
	By MerchantManagement = By.xpath("//*[@id=\"ApprovalModuleAccessList\"]/option[1]");
	By UserManagement = By.xpath("//*[@id=\"ApprovalModuleAccessList\"]/option[2]");
	By DisputeTransaction = By.xpath("//*[@id=\"ApprovalModuleAccessList\"]/option[3]");

	/************ Methods *******/

	public void clkUserRoleDrpDownList() {

		driver.findElement(UserRole).click();
		

	}// end clkUserRoleDrpDownList

	// -----------------------------------------------

	public void selectUserRole(String userRole) {

		Select drpUserRole = new Select(driver.findElement(UserRole));
		drpUserRole.selectByVisibleText(userRole);

	}// end selectUserRole

	// -----------------------------------------------

	public void clkBankNameDrpDownList() {

		driver.findElement(BankName).click();
		

	}// end clkBankNameDrpDownList

	// ----------------------------------------------
	public void selectBankName(String bankID) {

		Select drpBankName = new Select(driver.findElement(BankName));
		drpBankName.selectByValue(bankID);
	}// end selectBankName

	// ----------------------------------------------

	public void insertUserName(String BankUserName) {

		driver.findElement(UserName).sendKeys(BankUserName);
	}// end insertBankUserName

	// ----------------------------------------------

	public void insertFullName(String BankFullName) {

		driver.findElement(FullName).sendKeys(BankFullName);
	}// end insertBankFullName

	// ----------------------------------------------

	public void insertEmail(String EmialAddress) {

		driver.findElement(Email).sendKeys(EmialAddress);
	}// end insertEmail

	// ----------------------------------------------

	public void insertPhoneNum(String phoneNumber) {

		driver.findElement(PhoneNum).sendKeys(phoneNumber);

	}// end insertPhoneNum

	// ----------------------------------------------

	public void clkNotificationMethod() {

		driver.findElement(NotificationMethod).click();

	}// end selectNotificationMethod

	// ----------------------------------------------

	public void selectNotificationMethod(String NotMethod) {

		driver.findElement(NotificationMethod).sendKeys(NotMethod);

	}// end selectNotificationMethod

	// ----------------------------------------------

	public void clkRegisterBtn() {

		driver.findElement(RegisterBtn).click();

	}// end clkRegisterBtn
	
	// ----------------------------------------------

	public void clkPrivliges() throws InterruptedException {

		driver.findElement(PrivligesBox).click();
		Thread.sleep(200);
		driver.findElement(PrivligesBox).sendKeys(Keys.ENTER);
		Thread.sleep(200);
		driver.findElement(PrivligesBox).sendKeys(Keys.DOWN, Keys.RETURN);
		driver.findElement(PrivligesBox).sendKeys(Keys.DOWN, Keys.RETURN);

	}// end clkPrivliges
	
	//------------------------------------------------

	public void insertUserDataPack(String userName, String fullName, String emailAddress,
			String phoneNumber ,String NotificationMethod) throws InterruptedException {

		insertUserName(userName);
		insertFullName(fullName);
		insertEmail(emailAddress);
		insertPhoneNum(phoneNumber);
		clkNotificationMethod();
		Thread.sleep(1000);
		selectNotificationMethod(NotificationMethod);

	}// end insertUserDataPack


}// end class
