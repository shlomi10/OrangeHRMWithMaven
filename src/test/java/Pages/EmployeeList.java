package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EmployeeList extends BasePage {

	public EmployeeList(WebDriver driver) {
		super(driver);
	}
	
	By pimTab = By.cssSelector("[id='menu_pim_viewPimModule']");
	By employeeListSubMenu = By.cssSelector("[id='menu_pim_viewEmployeeList']");
	By firstLastNameTab = By.xpath("//a[contains(text(),'First (& Middle) Name')]");
	String ASCOrder = "ASC";
	String defaultAttribute= "null";
	String attributeToGet = "class";

	
	public void openEmployeeList() {
		moveToElement(pimTab,employeeListSubMenu);
	}
	
	public void orderByFirstName() {
		Assert.assertEquals(defaultAttribute,getAttribute(firstLastNameTab,attributeToGet));
		clickOnElement(firstLastNameTab);
		Assert.assertEquals(ASCOrder,getAttribute(firstLastNameTab,attributeToGet));
	}
	

}
