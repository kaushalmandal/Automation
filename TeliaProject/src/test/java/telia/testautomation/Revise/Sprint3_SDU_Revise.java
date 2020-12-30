/*
 * Manual Testcase Name :
 * Description of Testcase:
 * Date of Creation:
 * Reviewed By:
 * Author:
 */

package telia.testautomation.Revise;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
//import applicationSpecific.CommonMethods;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

@Listeners({ coreFramework.CoreListener.class })
public class Sprint3_SDU_Revise extends ExtentManager {

	/*
	 * public Disconnect_Service_1(WebDriver driver) { this.driver = driver; }
	 */

	public static String url = "";
	private static String hostName;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];
	/* WebDriver driver = CommonWebActions.wd; */

	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName",Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	@BeforeTest
	public void beforetest() throws Exception {
		CommonWebActions.login();
	}
	
	
	/**
	 * @TestcaseName:SDU_New_Broadband_Revise
	 * @Description:
	 * @Complexity:High
	 * @author :Srujana G
	 * @ALM :
	 * 
	 */
	@Test(priority = 1, enabled = true)
	public void SDU_New_Broadband_Revise() throws Exception {
		/* CommonMethods common = new CommonMethods(driver); */
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			/*--  Launching URL  --*/
//			CommonWebActions.login();
			System.out.println("Testcase : " + testcasename  +"Started.......");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 30000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			// CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.waitForLoad1();
			CommonWebActions.scrollup();
			CommonWebActions.fnHighlightMe("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(500);
			// Verification pending of scoring response
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1,"Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
		
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				System.out.println(CommonWebActions.wd.switchTo().alert().getText());
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			
            CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.wait(1000);
			CommonWebActions.scrollDown();
			CommonWebActions.scrollIntoWebElement1("Item_OptGrpIAspeed_BB");
			CommonWebActions.fnHighlightMe("Item_OptGrpIAspeed_BB");
			// CommonWebActions.fnHighlightMe("Item_OptGrpIAspeed");
			CommonWebActions.webClick("Item_OptGrpIAspeed_BB");
			CommonWebActions.Selectvaluefromdropdown("Item_OptGrpIAspeed_BB", "Bredband 250");
			CommonWebActions.webSet("Item_OptGrpIAspeed_QTY_BB", "1");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrpIAspeed_AddItem_BB");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);

			/* Adding Due date to 8days */
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE, 8);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			// Submit the order after modifying the duedate
			CommonWebActions.webSet("Due_date", newtime);
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.wait(2000);
			App_CommonFunctions.DueDate_LineItem(1, newtime);
			App_CommonFunctions.DueDate_LineItem(2, newtime);
			App_CommonFunctions.DueDate_LineItem(3, newtime);
			CommonWebActions.webClick("SalesOrder_Submit");
			// Fetch the status
			CommonWebActions.wait(1000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			CommonWebActions.waitForLoad1();
			WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 120);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Sales Order:Revise']")));
			// Click on Revise
			CommonWebActions.fnHighlightMe("Revise_Button");
			element.click();
			// Adding todays date
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = new Date();
			String date1 = inputFormat1.format(d1);
			System.out.println(date1);
			// Submit the order with today's date
			CommonWebActions.webSet("Due_date", date1);
			CommonWebActions.savePage();
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.wait(2000);

			App_CommonFunctions.DueDate_LineItem(1, date1);
			App_CommonFunctions.DueDate_LineItem(2, date1);
			App_CommonFunctions.DueDate_LineItem(3, date1);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(5000);

			System.out.println(App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			// CommonWebActions.webVerifyInnerText("ActivitiesTab_Type_Status","Sent");
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, testcasename, "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	/**
	 * @TestcaseName:SDU_NewIPTV_Revise
	 * @Description:
	 * @Complexity:High
	 * @author :srujana G
	 * @ALM :
	 * 
	 */
	@Test(priority = 2, enabled =true)
	public void SDU_NewIPTV_Revise() throws Exception {
		/* CommonMethods common = new CommonMethods(driver); */
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
			/*--  Launching URL  --*/
			System.out.println("Testcase : " + testcasename  +"Started.......");
		    CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.waitUntil("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.waitUntil("Listitem_AddNew");
			CommonWebActions.javaclick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.wait(1000);
			// CommonWebActions.Tab();
			App_CommonFunctions.NewLineITem(3,"Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("Customize_Button");
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.scrollDown();
			CommonWebActions.javaclick("Package_Button");
			CommonWebActions.wait(2000);
			for (int i = 0; i <= 2; i++) {
				try {
					CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item", "Tv-paket Lagom");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item", "Tv-paket Lagom");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp-TV-ViasatPackages-1704");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp_TV_CMorePackages_1704");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(1000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			/* Adding Due date to 8days */
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE,8);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			// Submit the order after modifying the duedate
			CommonWebActions.webSet("Due_date",newtime);
			CommonWebActions.waitUntil("TreePlusExpand_Icon");
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.waitUntil("TreePlusExpand_Icon2");
			CommonWebActions.scrollIntoWebElement1("TreePlusExpand_Icon2");
			CommonWebActions.javaclick("TreePlusExpand_Icon2");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_SelectAll");
			CommonWebActions.webClick("LineItem_SelectAll");
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_ChangeRecords");
			CommonWebActions.webClick("LineItem_ChangeRecords");
			CommonWebActions.waitUntil("1stField_DropDown");
			CommonWebActions.webSet("1stField_DropDown","Due");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Due_Select");
			CommonWebActions.waitUntil("1stValue_Textbox");
			CommonWebActions.webSet("1stValue_Textbox",newtime);
		     CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("OK_Button");
			CommonWebActions.webClick("OK_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");
			// Fetch the status
			CommonWebActions.wait(3000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			CommonWebActions.waitForLoad1();
			WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 120);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Sales Order:Revise']")));
			// Click on Revise
			CommonWebActions.fnHighlightMe("Revise_Button");
			element.click();
			// Adding todays date
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = new Date();
			String date1 = inputFormat1.format(d1);
			System.out.println(date1);
			// Submit the order with today's date
		
            CommonWebActions.waitUntil("TreePlusExpand_Icon");
            CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.scrollIntoWebElement1("TreePlusExpand_Icon");
			CommonWebActions.javaclick("TreePlusExpand_Icon2");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_SelectAll");
			CommonWebActions.webClick("LineItem_SelectAll");
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_ChangeRecords");
			CommonWebActions.webClick("LineItem_ChangeRecords");
			CommonWebActions.waitUntil("1stField_DropDown");
			CommonWebActions.webSet("1stField_DropDown","Due");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Due_Select");
			CommonWebActions.waitUntil("1stValue_Textbox");
			CommonWebActions.webSet("1stValue_Textbox",date1);
			CommonWebActions.wait(2000);
		    CommonWebActions.waitUntil("OK_Button");
			CommonWebActions.webClick("OK_Button");
			CommonWebActions.webSet("Due_date",date1);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(5000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			extent.flush();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	/**
	 * @TestcaseName:SDU_VAS_Revise
	 * @Description:
	 * @Complexity:High
	 * @author :srujana
	 * @ALM :
	 * 
	 */
	@Test(priority = 3, enabled = true)
	public void SDU_VAS_Revise() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			CommonWebActions.login();
			
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			}
			System.out.println("Testcase : " + testcasename  +"Started.......");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 30000);
	    	CommonWebActions.webClick("Homebtn");
//			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.waitForLoad1();
			CommonWebActions.scrollup();
			CommonWebActions.waitUntil("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.Selectvaluefromdropdown("OptGrp_VAS_Spotify_1703_1_Item", "Telia Spotify Premium");
			CommonWebActions.wait(1000);
			CommonWebActions.webSet("OptGrp_VAS_Spotify_1703_1_QTY", ExcelUtil.getDataFromExcel(testcasename, "QTY"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Add_Item_VAS");
			CommonWebActions.wait(1000);
			CommonWebActions.scrollDown();
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(1000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			/* Adding Due date to 8days */
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE, 8);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			// Submit the order after modifying the duedate
			CommonWebActions.webSet("Due_date", newtime);
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.wait(2000);

			App_CommonFunctions.DueDate_LineItem(1, newtime);
			App_CommonFunctions.DueDate_LineItem(2, newtime);
			App_CommonFunctions.DueDate_LineItem(3, newtime);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.waitForLoad1();

			// Fetch the status
			CommonWebActions.wait(1000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
						WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 120);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Sales Order:Revise']")));
			// Click on Revise
			CommonWebActions.fnHighlightMe("Revise_Button");
			element.click();
			// Adding todays date
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = new Date();
			String date1 = inputFormat1.format(d1);
			System.out.println(date1);
			// Submit the order with today's date
			CommonWebActions.webSet("Due_date", date1);
			CommonWebActions.savePage();
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.wait(2000);
			App_CommonFunctions.DueDate_LineItem(1, date1);
			App_CommonFunctions.DueDate_LineItem(2, date1);
			App_CommonFunctions.DueDate_LineItem(3, date1);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(5000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");

		}
	}

	@AfterTest
	public static void teardown() throws Exception {
		CommonWebActions.logout();
		CommonWebActions.wd.quit();
//		CommonWebActions.logout();
//	extent.flush();
//	CommonWebActions.wd.quit();
	}
		  




}
