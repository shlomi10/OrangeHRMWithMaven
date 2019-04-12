package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import Pages.AddEmpPage;
import Pages.EmployeeList;
import Pages.LeaveListPage;
import Pages.LoginPage;
import Utilities.ExtentManager;


public class BaseTest extends ExtentManager {
	
	WebDriver driver;
	LoginPage loginPage;
	EmployeeList pimEmpList;
	AddEmpPage addEmpPage;
	LeaveListPage leaveList;
	
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		
		try {
		     if (browser.equalsIgnoreCase("fireFox")) {
		     System.setProperty("webdriver.ie.driver", ".\\drivers\\geckodriver.exe");
		     driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
		   System.setProperty("webdriver.chrome.driver" , ".\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();
		} 
		} catch (WebDriverException e) {
		    System.out.println(e.getMessage());
		}
		  driver.manage().window().maximize();
		  
		  //create reporting folder and report
		  init();
		  
		  loginPage = new LoginPage(driver);
		  pimEmpList = new EmployeeList(driver);
		  addEmpPage = new AddEmpPage (driver);
		  leaveList = new LeaveListPage(driver);
		}
  
  
	@AfterTest
	public void closeBrowser() {
	  driver.quit();
	  extent.flush(); 
	}
}