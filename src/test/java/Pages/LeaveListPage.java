package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LeaveListPage extends BasePage {

	public LeaveListPage(WebDriver driver) {
		super(driver);
	}
	
	LoginPage log = new LoginPage(driver);
	By userNameField = By.xpath("//input[@name='txtUsername']");
	By passwordField = By.xpath("//input[@name='txtPassword']");
	By loginButton = By.xpath("//input[@name='Submit']");
	By leaveListLink = By.xpath("//span[.='Leave List']");
	By firstCalendar = By.xpath("(//img[@class='ui-datepicker-trigger'])[1]");
	By secondCalendar = By.xpath("(//img[@class='ui-datepicker-trigger'])[2]");

	By dateWidgetLocator = By.id("ui-datepicker-div");
	Select year, month;
	String startYear="2014", endYear = "2019";
	String startMonth = "7" , endMonth = "0"; 
	String startDay = "28", endDay ="22";
	By days = By.tagName("td");
	WebElement dateWidget;
	List<WebElement> cells;

	By yearLocatorOnCalendar = By.className("ui-datepicker-year");
	By monthLocatorOnCalendar = By.className("ui-datepicker-month");

	By checkAll = By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']");
	By searchBTN = By.id("btnSearch");
	By rowsCounter = By.xpath("//tr[td]");
	int expectedRows = 3;

	public void displayLeaveReport() {
		log.loginWithcredentials(userNameField,passwordField,log.correctUserName,log.correctPassword,loginButton);
		clickOnElement(leaveListLink);

		//first date picker
		clickOnElement(firstCalendar);
		year = new Select(elementBack(yearLocatorOnCalendar));
		year.selectByValue(startYear);
		month = new Select(elementBack(monthLocatorOnCalendar));
		month.selectByValue(startMonth);
		dateWidget = elementBack(dateWidgetLocator);
		List<WebElement> cells = elementList(days);
		for (WebElement cell : cells)
		{       
			if (cell.getText().equals(startDay))       
			{
				cell.click();  
				break;    
			}
		}

		//last date picker
		invisibilityOf(dateWidgetLocator);
		clickOnElement(secondCalendar);
		year = new Select(elementBack(yearLocatorOnCalendar));
		year.selectByValue(endYear);
		month = new Select(elementBack(monthLocatorOnCalendar));
		month.selectByValue(endMonth);
		dateWidget = elementBack(dateWidgetLocator);
		cells = elementList(days);
		for (WebElement cell : cells)
		{       
			if (cell.getText().equals(endDay))       
			{
				cell.click();  
				break;    
			}
		}
		//count the rows
		invisibilityOf(dateWidgetLocator);
		clickOnElement(checkAll);
		clickOnElement(searchBTN);
		System.out.println("the rows number :" + countElements(rowsCounter));
		Assert.assertEquals(countElements(rowsCounter), expectedRows);
	}
}
