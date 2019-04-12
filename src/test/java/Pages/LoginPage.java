package Pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By userNameField = By.xpath("//input[@name='txtUsername']");
	By passwordField = By.xpath("//input[@name='txtPassword']");
	By loginButton = By.xpath("//input[@name='Submit']");
	By loggedInIndicator = By.xpath("//a[@class='panelTrigger']");
	By errorMessege = By.cssSelector("[id='spanMessage']");
	//String correctUserName = "Admin";
	//String correctPassword = "admin123";
	List<String> username = Arrays.asList("", "adminn");
	List<String> password = Arrays.asList("", "test");
			
	public void getPage(String URL) {
		driver.get(URL);
	}
	
	public void invalidLoginCredentialsTest() {
		for (int i=0;i<username.size();i++) {
			for (int j=0;j<password.size();j++) {
				loginWithcredentials(userNameField,passwordField,username.get(i),password.get(j),loginButton);
				System.out.println("Tested with: \n Username: "+username.get(i)+" Password: "+password.get(j)+" \n error messege: "+getText(errorMessege));
				Assert.assertTrue(visibalityOfElement(errorMessege), "invalid credentials tested");
			}
		}		
	}
	

	public void loginCredentialsTest() {
		loginWithcredentials(userNameField,passwordField,correctUserName,correctPassword,loginButton);
	}
}
