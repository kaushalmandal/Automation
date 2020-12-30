/**
 * Manual Testcase Name : Possibility to use a temporary contact in XDSL orders (Part 2)
 * Description of Testcase:
 * Date of Creation: 27-02-2019
 * Reviewed By:
 * Author:QSG460
 * 
 */
package telia.testautomation.New;

import java.lang.reflect.Executable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @author kaviag
 *
 */

public class Sprint3_Temporary_contact_XDSLPart2 extends ExtentManager {
	
	public static String url = "Test";
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	
	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName",Packagename);
			hostName = InetAddress.getLocalHost().getHostName();

		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("HostName : " + hostName);
	}
	@BeforeClass
	public void beforetest() throws Exception {
		CommonWebActions.login();
	}

@Test(priority = 1,enabled=true)
	public void TC_002_XDSL527_Temporary_contact_in_XDSL_orders_Part2() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : " + Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase : " + testcasename + "Started.......");

		try {

			/*--  Launching URL  --*/
			String SSN = ExcelUtil.getDataFromExcel(testcasename, "SSN");
			String FirstName = ExcelUtil.getDataFromExcel(testcasename, "FristName");
			String LastName = ExcelUtil.getDataFromExcel(testcasename, "LastName");
			String Expected_AlertMessage1 = ExcelUtil.getDataFromExcel(testcasename, "Expected_AlertMessage1");
			String Expected_AlertMessage2 = ExcelUtil.getDataFromExcel(testcasename, "Expected_AlertMessage2");

			// CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 50000);
			App_CommonFunctions.SearchServiceAccount(SSN, "Residential");
			System.out.println(SSN);
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.javaclick("FirstName_Link");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("CustAcc_Link");
			CommonWebActions.webClick("CustAcc_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AddNew_Button1");
			CommonWebActions.webImplicitWait(2);
			CommonWebActions.webClick("AddNew_Button1");
			// CommonWebActions.retryingFindClick("AddNew_Button1");
			AddNewContact(1, "First Name", FirstName);
			// CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.wait(3000);
			CommonWebActions.webImplicitWait(10);
			boolean alertpresent1 = CommonWebActions.isAlertPresent();
			if (alertpresent1) {
				CommonWebActions.wd.switchTo().alert();
				String Actual_AlertMessage1 = CommonWebActions.wd.switchTo().alert().getText();
				System.out.println(Actual_AlertMessage1);
				if (Actual_AlertMessage1.contains(Expected_AlertMessage1)) {
					System.out.println(testcasename + ": Pass Level-1");
				}
			}
			CommonWebActions.wd.switchTo().alert().accept();
			CommonWebActions.webClick("Delete_Button");
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.waitForLoad1();
			CommonWebActions.webImplicitWait(10);
			CommonWebActions.wait(2000);
			// CommonWebActions.waitUntil("AddNew_Button1");
			CommonWebActions.webImplicitWait(2);
			CommonWebActions.webClick("AddNew_Button1");
			AddNewContact(1, "Last Name", LastName);
			CommonWebActions.webClick("AccHierarchy_Tab");
			boolean alertpresent2 = CommonWebActions.isAlertPresent();
			if (alertpresent2) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wait(1000);
				String Actual_AlertMessage2 = CommonWebActions.wd.switchTo().alert().getText();
				System.out.println(Actual_AlertMessage2);
				if (Actual_AlertMessage2.contains(Expected_AlertMessage2)) {
					System.out.println(testcasename + ": Pass Level-2");
				}
				CommonWebActions.wd.switchTo().alert().accept();
			}
			test.log(Status.PASS, "Test case Pass :" + testcasename);
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", "No Order is created .Validation Scenario");
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "PASS");
		} catch (Exception e) {
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		}
	}

public void AddNewContact(int rowno,String Columnname,String StrTexttoSend) throws Exception{
	List<WebElement> column = CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_1_l']/div[2]/div/table/thead/tr/th"));
	int Line_Item_Column_Count = column.size();
	List<WebElement> LineItem_Data = CommonWebActions.wd.findElements(By.xpath("//*[@id="+rowno+"]/td"));
		for(int i=0;i<Line_Item_Column_Count;i++){
		String Column_Name = column.get(i).getText();
		if((Columnname).trim().equalsIgnoreCase(Column_Name.trim())){
			WebElement objName=LineItem_Data.get(i);
			CommonWebActions.javaSet2(objName, StrTexttoSend);
			
			System.out.println(Columnname + ":" + StrTexttoSend );
			CommonWebActions.wait(1000);
		}
	}
}

@AfterClass
public static void teardown() throws Exception {
	CommonWebActions.logout();
	System.out.println("Testcase Completed.......");
extent.flush();
CommonWebActions.wd.quit();
}

}
