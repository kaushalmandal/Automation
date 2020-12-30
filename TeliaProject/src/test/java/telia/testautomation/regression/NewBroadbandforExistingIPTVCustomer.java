/*
 * Manual Testcase Name :
 * Description of Testcase:
 * Date of Creation:
 * Reviewed By:
 * Author:
 */ 
	
package telia.testautomation.regression;	

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import applicationSpecific.CommonMethods;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

@Listeners({ coreFramework.CoreListener.class })
public class NewBroadbandforExistingIPTVCustomer extends ExtentManager {
	
/*	public Disconnect_Service_1(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public static String url = "";
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	/*WebDriver driver = CommonWebActions.wd;*/

	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	@Test(priority = 0,enabled=true)
	public void TC_003_New_Broadband_Service() throws Exception {
		/*CommonMethods common = new CommonMethods(driver);*/
		try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(),Packagename);
		/*--  Launching URL  --*/
		CommonWebActions.login();
			
		//CommonWebActions.login(url, "test", "test");
		waitForLoad1(CommonWebActions.wd);
		waitUntilLoaded(CommonWebActions.wd,By.xpath("//span[@class='siebui-ctrl-link siebui-align-left siebui-input-align-left' and @name='s_5_1_9_0']/a"),20000);
		
		CommonWebActions.webClick("Account_Tab");
		CommonWebActions.webClick("Account_List_Menu");
		CommonWebActions.wait(2000);
	//---------------
		String MenuItemInput= "SSN/Org Number";  //getVariableValue("MenuItem_Input");
		CommonWebActions.webSetTab("MenuItem_Input", MenuItemInput);
		
		String testcasename3=(new Object() {
		}.getClass().getEnclosingMethod().getName());		
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename3, "SSN"); 		
		System.out.println("*********SSN********* :" + SSN_No);
		
		//String SSN_No="199104282430";           //getVariableValue("SSN");
		CommonWebActions.webSetTab("SSN_Org_Input", SSN_No);
		
		CommonWebActions.webClick("Go_Submit_button");
		CommonWebActions.wait(3000);
		
		CommonWebActions.webClick("FirstName_Link");
		CommonWebActions.waitForLoad1();
		CommonWebActions.wait(2000);
		
		CommonWebActions.webClick("AddNew_Button");
		CommonWebActions.waitForLoad1();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		
		CommonWebActions.webClick("CreditCheck_Button");
		//CommonWebActions.fnHighlightMe(CommonWebActions.wd,CommonWebActions.wd.findElement(By.xpath("//[@id='a_1']/div/table/tbody/tr[17]/td[10]/div/input")));
		CommonWebActions.scrollIntoWebElement("Listitem_AddNew");
		
		CommonWebActions.javaclick("Listitem_AddNew");
		CommonWebActions.wait(1000);
		CommonWebActions.Tab();
		
		CommonWebActions.javaSet("Lineitem_Product", ExcelUtil.getDataFromExcel(testcasename3,"Product"));
		CommonWebActions.Tab();
		
		CommonWebActions.javaSet("Access_Type", ExcelUtil.getDataFromExcel(testcasename3,"AccessType"));
		        
		CommonWebActions.webClick("Customize_Button");
		CommonWebActions.scrollDown();
		
		CommonWebActions.scrollIntoWebElement("Listitem_AddNew");
//		CommonWebActions.webClick("Item_Dropdown");
//		CommonWebActions.webClick("Item_Value");
		CommonWebActions.scrollIntoWebElement("Item_OptGrpIAspeed");
		CommonWebActions.Selectvaluefromdropdown("Item_OptGrpIAspeed", "Bredband 250");
		CommonWebActions.webSet("Item_OptGrpIAspeed_QTY", "1");
		CommonWebActions.wait(100);
		
		CommonWebActions.webClick("Item_OptGrpIAspeed_AddItem");
		CommonWebActions.wait(100);
		
		CommonWebActions.javaclick("Salesorder_Done");
		CommonWebActions.wait(100);
		
		CommonWebActions.webClick("Submit");
		test.log(Status.PASS,"Submit  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Submit")));
		}
		catch (Exception e)
		{
			 System.out.println("New Broadband order should be submitted Successfully ");
             
             e.printStackTrace();
		}
		
	}
	@AfterTest
	public void logOut() {

		// CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		// extent.flush();
	}

	public void waitForLoad1(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 30);
		wait.until(pageLoadCondition);
	}
	
	public WebElement waitUntilLoaded(WebDriver driver, By matcher, int seconds) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, seconds).pollingEvery(100, TimeUnit.MILLISECONDS);
		WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(matcher));
		return we;
	}
	
}

