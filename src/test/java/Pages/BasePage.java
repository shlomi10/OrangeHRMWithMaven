package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait; 
	public Actions action1;
	public Random ran;
	public int randNum;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10); 
	}
	
	public void clickOnElement(By elem) {
		driver.findElement(elem).click();
	}
	
	public void sendKeys(By elem, String keysToSend) {
		driver.findElement(elem).sendKeys(keysToSend);
	}
	
	public String getText(By elem) {
		return driver.findElement(elem).getText();
	}
	
	public boolean visibalityOfElement(By elem) {
		return driver.findElement(elem).isDisplayed();
	}

	public void waitVisibility(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}
	
	public void clickableElement(By elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	public void invisibilityOf(By elem) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elem));
	}
	
	public String subString(String sub, int beginIndex) {
		 sub=sub.substring(beginIndex);
		 return sub;
	}
	
	public void moveToElement(By fromElem, By toElem) {
		action1 = new Actions(driver);
		WebElement fromelement = driver.findElement(fromElem);
		WebElement tolement = driver.findElement(fromElem);
		action1.moveToElement(fromelement ).moveToElement(tolement).click().build().perform();		
	}
	
	public String getAttribute(By elem, String att) {
		return driver.findElement(elem).getAttribute(att);
	}
	
	public Boolean isChecked(By elem) {
		return driver.findElement(elem).isSelected();
	}
	
	public String createRandomUser(String user) {
		ran = new Random ();
		randNum=ran.nextInt(1000+1);
		return user+randNum;
	}
	
	public void scrollDown(By elem) {
		WebElement element1 = driver.findElement(elem);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element1);
	}
	
	public void scrollAndClick(By elem) {
		WebElement element1 = driver.findElement(elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
	}
	
	public void scrollWindowsDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public WebElement elementBack(By elem) {
		return driver.findElement(elem);
	}
	
	public List<WebElement> elementList(By elem) {
		return driver.findElements(elem);
	}
	
	public int countElements(By elem) {
		return driver.findElements(elem).size();
	}
}
