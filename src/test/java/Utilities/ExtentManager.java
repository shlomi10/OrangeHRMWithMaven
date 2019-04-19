package utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public  ExtentReports extent;
	public  ExtentTest test;
	public  ExtentHtmlReporter htmlReporter;
	public  String reportDate;
	public  String filePath;

	public  void init() {
		reportDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());	
		filePath = ".\\reports\\OrangeHRM Report "+ reportDate;
		htmlReporter = new ExtentHtmlReporter(filePath+"/report.html");
		new File(filePath).mkdirs();

		extent = new ExtentReports();               	 
		extent.attachReporter(htmlReporter);            

		htmlReporter.config().setDocumentTitle("automation report on OrangeHRM");
		htmlReporter.config().setReportName("OrangeHRM Test");               
		htmlReporter.config().setEncoding("windows-1255");                      
	}

	public void create_test(String testName, String testDescription)
	{
		test = extent.createTest (testName, testDescription);
	}

	public String CaptureScreen() throws AWTException, IOException
	{
		String picDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String imagePath = filePath+"/pic"+picDate+".jpg";
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "jpg", new File(imagePath));
		return imagePath;
	}
}