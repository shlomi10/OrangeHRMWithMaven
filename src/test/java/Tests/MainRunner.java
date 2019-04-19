package tests;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;

public class MainRunner extends BaseTest {
		
	String siteURL ="https://opensource-demo.orangehrmlive.com/index.php";
	String firstName = "Donald";
	String lastName = "Trump";
	
	@Test (priority = 1)
	public void invalidLoginCredentialsTest() throws IOException, AWTException {
		create_test("Test Login with invalid credentials", "incorrect Usernames and Passwords");
		loginPage.getPage(siteURL);
		loginPage.invalidLoginCredentialsTest();
		test.pass("login screen", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
	}
	
	@Test (priority = 2)
	public void validLoginCredentialsTest() throws IOException, AWTException {
		create_test("Test Login with with valid credentials", "correct Username: Admin, Password admin123");
		loginPage.loginCredentialsTest();
		test.pass("main Dashboard", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
	}
	
	@Test (priority =3)
	public void employeeListOrder() throws IOException, AWTException {
		create_test("ASC Employee first name List ", "correct order of table by first name");
		pimEmpList.openEmployeeList();
		test.pass("default order of first name", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
		pimEmpList.orderByFirstName();
		test.pass("ASC order of first name", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
	}
	
	@Test (priority = 4)
	public void addEmployee() {
		create_test("create employee ", "create employee");
		addEmpPage.addEmployee(firstName, lastName);
	}
	
	@Test (priority = 5)
	public void compareCreatedEmployee() throws IOException, AWTException {
		create_test("compare new employeeID to table ", "employeeID compared");
		addEmpPage.IDCompare();
		addEmpPage.signOut();
		test.pass("user is at the table", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
	}
	
	@Test (priority = 6)
	public void LeaveListTest() throws IOException, AWTException {
		create_test("count rows ", "expected rows = 3");
		leaveList.displayLeaveReport();
		test.pass("rows counted as design", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
	}
}
