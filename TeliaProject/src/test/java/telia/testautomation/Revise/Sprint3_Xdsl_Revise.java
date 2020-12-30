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
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

@Test
@Listeners({ coreFramework.CoreListener.class })

public class Sprint3_Xdsl_Revise extends ExtentManager {
	public static String url = "";
	private static String hostName;
	// private static ITestSet testSet;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];

	@BeforeSuite
	public void init() throws Exception {
		try {
			// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName", Packagename);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
	
	@BeforeClass
	public void beforetest() throws Exception {
		CommonWebActions.login();
	}

	/**
	 * @TestcaseName:xDSL_Revise
	 * @Description:Revising New Order
	 * @Complexity:
	 * @author :srujana,g
	 * @param :
	 * 
	 */
	@Test(priority = 1,enabled = true)
	public void xDSL_Revise_New() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get
			// appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			
			// -- Launching URL --//
//			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 2000);
			CommonWebActions.waitForLoad1();
			 CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("MyOrder_link");
			// CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("Testcase : " + testcasename  +"Started.......");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			/*-Step 5- Click on New Installassets --*/
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.javaclick("New_InstallAssets");

			CommonWebActions.scrollup();
			/*-Step 6- Print the status of Scoring Response --*/
			CommonWebActions.waitUntil("Credit_Check");
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			/*-Step 7- Create Line Items by using XDSL Product --*/
			CommonWebActions.webClick("Listitem_AddNew");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1,"Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			// CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.savePage();
			/*-Step 8- Add XDSL product --*/
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(850);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);
			/*-Step 9- If UnEncryptedEmailFlag is "Y" and Order Suppression is "N" --*/
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
			CommonWebActions.waitForLoad1();
			WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 120);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Sales Order:Revise']")));
			// Click on Revise
			CommonWebActions.fnHighlightMe("Revise_Button");
			element.click();
			
			// CommonWebActions.waitUntil("Revise_Button");
			// CommonWebActions.javaclick("Revise_Button"); //changecost
			// CommonWebActions.Tab();
			// CommonWebActions.wait(10000);
			// Adding todays date
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = new Date();
			// Date d =
			// inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			String date1 = inputFormat1.format(d1);
			System.out.println(date1);
			// Submit the order with today's date
			CommonWebActions.webSet("Due_date",date1);
			CommonWebActions.savePage();
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.wait(2000);
			App_CommonFunctions.DueDate_LineItem(1,date1);
			App_CommonFunctions.DueDate_LineItem(2,date1);
			App_CommonFunctions.DueDate_LineItem(3,date1);
			CommonWebActions.webClick("SalesOrder_Submit");

			/* Print the ScreenShot */
			test.log(Status.PASS, "Revise New" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID")
					+ " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()),"Not Completed");
		} catch (Exception e) {
			// CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 38476,
					(new Object().getClass().getEnclosingMethod().getName()), "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

	/**
	 * @TestcaseName:xDSL_Cancel_Modify
	 * @Description:Modify the exsiting order and cancel it
	 * @Complexity:
	 * @author :srujana,g
	 * @param :
	 * 
	 */
	@Test(priority = 2, enabled = true)
	public void xDSL_Revise_Modify() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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

			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("Testcase : " + testcasename  +"Started.......");
			// CommonWebActions.login();
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Lineitem_Go_Button");
			CommonWebActions.webClick("Lineitem_Go_Button");
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.wait(1000);
			CommonWebActions.passValuesnSave("DueDate_Popup",
					ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.javaclick("Continue_Popup");
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("TreePlusExpand_Icon");
			CommonWebActions.webClick("TreePlusExpand_Icon");
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(2000);
			// CommonWebActions.scrollIntoWebElement("Qty_EditTextbox");
			CommonWebActions.fnHighlightMe("Qty_Editbox");
			CommonWebActions.webClick("Qty_EditTextbox");
			CommonWebActions.webSet("Qty_EditTextbox", "0");
			CommonWebActions.waitUntil("AddItem_1A_Speed");
			CommonWebActions.javaclick("AddItem_1A_Speed");
			CommonWebActions.waitUntil("Item_1A_speed");
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.javaSet("Qty_1A_Speed", "1");
			CommonWebActions.javaclick("AddItem_1A_Speed");
			CommonWebActions.waitUntil("Done_1A_Speed");
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.wait(1000);
			/*- If UnEncryptedEmailFlag is "Y" and Order Suppression is "N" --*/
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			// CommonWebActions.scrollIntoWebElement("SalesOrder_Submit");
			CommonWebActions.EntertextThenPressTabAndSave("Reason_Code",
					ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(1000);
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
			CommonWebActions.webSet("Due_date",date1);
			CommonWebActions.savePage();
			CommonWebActions.waitUntil("TreePlusExpand_Icon");
			CommonWebActions.webClick("TreePlusExpand_Icon");
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
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);

			/*- Storing the ordernumber and Duedate --*/
		
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN",
			  App_CommonFunctions.orderNoFetch("SSN_Input"));
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename,
			  "Order_Number",
			  App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
			  App_CommonFunctions.orderNoFetch("Due_Date"));
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",
			  App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
			  System.out.println("Your new order is sucessfully cancelled ");
			  extent.flush(); System.setProperty("jacob.dll.path",
			  System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			  ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			  ALMTestfactory.updateResults("E2EMM Automation", "Sprint2",
			  38476, (new Object() {
			  }.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			 CommonWebActions.closeAlerts(); test.log(Status.FAIL,
			  "Test Case Failed:" + (new Object() {
			  }.getClass().getEnclosingMethod().getName()) + ":" +
			  test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(
			  CommonWebActions.wd, "Failed TC")));
			  ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			  ALMTestfactory.updateResults("E2EMM Automation", "Sprint2",
			  38476, (new Object() {
			  }.getClass().getEnclosingMethod().getName()), "Fail");
			  e.printStackTrace();
		

		}
	}

	/**
	 * @TestcaseName:xDSL_Cancel_Disconnect
	 * @Description: Disconnect the existing order and cancel it
	 * @Complexity:
	 * @author :srujana,g
	 * @param :
	 * 
	 */

	@Test(priority = 3,enabled = true)
	public void xDSL_Revise_Disconnect() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("Testcase : " + testcasename  +"Started.......");
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
			//CommonWebActions.login();

		     CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Lineitem_Go_Button");
			CommonWebActions.webClick("Lineitem_Go_Button");
			CommonWebActions.waitUntil("Disconnect_Button");
			CommonWebActions.javaclick("Disconnect_Button");
			CommonWebActions.waitUntil("DueDate_Popup");
			CommonWebActions.EntertextThenPressTabAndSave("DueDate_Popup",
					ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.javaclick("Continue_Popup");
			CommonWebActions.waitUntil("Reason_Code");
			/*-Step 9- If UnEncryptedEmailFlag is "Y" and Order Suppression is "N" --*/
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.EntertextThenPressTabAndSave("Reason_Code",
					ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			// CommonWebActions.scrollIntoWebElement("SalesOrder_Submit");
			CommonWebActions.EntertextThenPressTabAndSave("Reason_Code",
					ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(1000);
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
			cl.add(Calendar.DATE,5);
			System.out.println(date1);
			// Submit the order with today's date
			CommonWebActions.webSet("Due_date",date1);
			CommonWebActions.savePage();
			CommonWebActions.waitUntil("TreePlusExpand_Icon");
			CommonWebActions.webClick("TreePlusExpand_Icon");
			
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
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",
					App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}

	}
	
	
	@AfterClass
	public static void logout() throws  Exception {
	    CommonWebActions.javaclick("SettingsBtn");
	    CommonWebActions.waitUntil("LogoutBtn");
	    CommonWebActions.webClick("LogoutBtn");
	    CommonWebActions.waitUntil("UserPopup");
	  } 

//	@AfterSuite
//	public void tearDown() {
//		 extent.flush();
//		 CommonWebActions.wd.quit();
//	}

}

