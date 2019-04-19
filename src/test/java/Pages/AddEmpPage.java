package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddEmpPage extends BasePage {

	public AddEmpPage(WebDriver driver) {
		super(driver);
	}

	By addemployeeButton = By.cssSelector("[id='btnAdd']");
	By firstNameElem = By.cssSelector("[id='firstName']");
	By lastNameElem = By.cssSelector("[id='lastName']");
	By saveButton = By.cssSelector("[id='btnSave']");
	By loginDetailsCheckbox = By.cssSelector("[type='checkbox']");
	By userNameField = By.cssSelector("[id='user_name']");
	By passwordField = By.cssSelector("[id='user_password']");
	By rePasswordField = By.cssSelector("[name='re_password']");
	String userName = "donaldUserName";
	String Password = "donaldPSW";
	By empIDField =  By.xpath("//input[@id='personal_txtEmployeeId']");
	String IDattribute = "value";
	String employeeID;
	By employeeListTab = By.cssSelector("[id='menu_pim_viewEmployeeList']");
	By pimTab = By.cssSelector("[id='menu_pim_viewPimModule']");
	//By employeeIDINTable = By.xpath("//*[contains(text(),"+employeeID+")]");
	By employeeIDINTable = By.xpath("//a[.="+employeeID+"]");
	By welcomeElement = By.id("welcome");
	By logOutLink = By.xpath("//a[.='Logout']");
	
	public void addEmployee(String firstName,String lastName) {
		clickOnElement(addemployeeButton);
		sendKeys(firstNameElem,firstName);
		sendKeys(lastNameElem,lastName);
		if(!isChecked(loginDetailsCheckbox)) {
			clickOnElement(loginDetailsCheckbox);
		}
		else {
			clickOnElement(loginDetailsCheckbox);
		}
		sendKeys(userNameField,createRandomUser(userName));
		sendKeys(passwordField,Password);
		sendKeys(rePasswordField,Password);
		clickOnElement(saveButton);
	}
	
	public void IDCompare() {
		waitVisibility(empIDField);
		employeeID=getAttribute(empIDField,IDattribute);
		By employeeIDINTable = By.xpath("//a[.="+employeeID+"]");
		//By employeeIDINTable = By.xpath("//*[contains(text(),"+employeeID+")]");
		moveToElement(pimTab,employeeListTab);
		scrollDown(employeeIDINTable);
		waitVisibility(employeeIDINTable);
		Assert.assertEquals ((getText(employeeIDINTable)) , employeeID);
	}
	
	public void signOut() {
		scrollDown(welcomeElement);
		scrollAndClick(welcomeElement);
		waitVisibility(logOutLink);
		clickOnElement(logOutLink);
	}
}
