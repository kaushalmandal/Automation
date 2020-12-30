package telia.testautomation.Modify;
import static org.testng.Assert.assertTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
public class Sprint4_Modify extends ExtentManager{

	
	
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
			//CommonWebActions.login();
		}
	
	
	
		

/**
 * @TestcaseName:TC_003_MDU_Modify_Broadband_and_IPTV_Upgrade_Bulk
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
 @Test(priority = 3,enabled=true)
	public void TC_003_MDU_Modify_Broadband_and_IPTV_Upgrade_Bulk() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);

		try {

			/*--  Launching URL  --*/
			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			CommonWebActions.waitUntil("Click_SreviceBundel");
			CommonWebActions.webClick("Click_SreviceBundel");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			// ====================================
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link2");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("speed_zero", "0");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 500");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(3000);
			// ===================================
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("Portal_Link");
			CommonWebActions.waitUntil("Click_SreviceBunde2");
			CommonWebActions.webClick("Click_SreviceBunde2");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);

			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link1");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");

			CommonWebActions.wait(2000);
			CommonWebActions.Selectvaluefromdropdown("Upgrade_IPTV", "Tv-paket Stor");
			CommonWebActions.wait(2000);

			CommonWebActions.waitUntil("Checkbox_new");
			CommonWebActions.javaclick("Checkbox_new");
			/*
			 * CommonWebActions.waitUntil("Checkbox_new2");
			 * CommonWebActions.javaclick("Checkbox_new2");
			 */
			CommonWebActions.waitUntil("Checkbox_new3");
			CommonWebActions.javaclick("Checkbox_new3");
			/*
			 * CommonWebActions.waitUntil("Checkbox_new4");
			 * CommonWebActions.javaclick("Checkbox_new4");
			 */
			CommonWebActions.waitUntil("Additional_Pkg");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.waitUntil("Checkbox_new6");
			CommonWebActions.webClick("Checkbox_new6");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename,"Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename,"Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}



 /**
  * @TestcaseName:TC_004_MDU_Modify_Broadband_and_IPTV_Upgrade
  * @Description: 
  * @Complexity:High
  * @author :Mohan
  * @ALM :
  * 
  */ 

 @Test(priority = 4,enabled=true)
	public void TC_004_MDU_Modify_Broadband_and_IPTV_Upgrade() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);

		try {

			/*--  Launching URL  --*/
			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			CommonWebActions.waitUntil("Click_SreviceBundel");
			CommonWebActions.webClick("Click_SreviceBundel");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			// ====================================
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link2");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("speed_zero", "0");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 500");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(3000);
			// ===================================
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("Portal_Link");
			CommonWebActions.waitUntil("Click_SreviceBunde2");
			CommonWebActions.webClick("Click_SreviceBunde2");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link1");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");

			CommonWebActions.wait(2000);
			CommonWebActions.Selectvaluefromdropdown("Upgrade_IPTV", "Tv-paket Stor");
			CommonWebActions.wait(2000);

			CommonWebActions.waitUntil("Checkbox_new");
			CommonWebActions.javaclick("Checkbox_new");
			/*
			 * CommonWebActions.waitUntil("Checkbox_new2");
			 * CommonWebActions.javaclick("Checkbox_new2");
			 */
			CommonWebActions.waitUntil("Checkbox_new3");
			CommonWebActions.javaclick("Checkbox_new3");
			/*
			 * CommonWebActions.waitUntil("Checkbox_new4");
			 * CommonWebActions.javaclick("Checkbox_new4");
			 */
			CommonWebActions.waitUntil("Additional_Pkg");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.waitUntil("Checkbox_new5");
			CommonWebActions.webClick("Checkbox_new5");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}


 
 /**
  * @TestcaseName:TC_005_MDU_Modify_IPTV_Upgrade
  * @Description: 
  * @Complexity:High
  * @author :Mohan
  * @ALM :
  * 
  */ 
 
 
 @Test(priority = 5,enabled=true)
	public void TC_005_MDU_Modify_IPTV_Upgrade() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);

		try {

			/*--  Launching URL  --*/
			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			/*
			 * CommonWebActions.waitUntil("Click_SreviceBundel");
			 * CommonWebActions.webClick("Click_SreviceBundel");
			 * CommonWebActions.waitUntil("Modify_Link");
			 * CommonWebActions.webClick("Modify_Link");
			 * CommonWebActions.waitUntil("Continue_Link");
			 * CommonWebActions.webClick("Continue_Link");
			 * CommonWebActions.waitUntil("Portal_Link");
			 * CommonWebActions.javaclick("Portal_Link");
			 */
			CommonWebActions.waitUntil("Click_SreviceBunde2");
			CommonWebActions.webClick("Click_SreviceBunde2");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link1");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");

			CommonWebActions.wait(2000);
			CommonWebActions.Selectvaluefromdropdown("Upgrade_IPTV", "Tv-paket Stor");
			CommonWebActions.wait(2000);

			CommonWebActions.waitUntil("Checkbox_new");
			CommonWebActions.javaclick("Checkbox_new");
			CommonWebActions.waitUntil("Checkbox_new2");
			CommonWebActions.javaclick("Checkbox_new2");
			CommonWebActions.waitUntil("Checkbox_new3");
			CommonWebActions.javaclick("Checkbox_new3");
			CommonWebActions.waitUntil("Checkbox_new4");
			CommonWebActions.javaclick("Checkbox_new4");
			CommonWebActions.waitUntil("Additional_Pkg");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.waitUntil("Checkbox_new5");
			CommonWebActions.webClick("Checkbox_new5");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}

 /**
  * @TestcaseName:TC_006_MDU_Modify_IPTV_Upgrade_Bulk
  * @Description: 
  * @Complexity:High
  * @author :Mohan
  * @ALM :
  * 
  */ 
 
 @Test(priority = 6,enabled=true)
	public void TC_006_MDU_Modify_IPTV_Upgrade_Bulk() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {

			/*--  Launching URL  --*/
			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			/*
			 * CommonWebActions.waitUntil("Click_SreviceBundel");
			 * CommonWebActions.webClick("Click_SreviceBundel");
			 * CommonWebActions.waitUntil("Modify_Link");
			 * CommonWebActions.webClick("Modify_Link");
			 * CommonWebActions.waitUntil("Continue_Link");
			 * CommonWebActions.webClick("Continue_Link");
			 * CommonWebActions.waitUntil("Portal_Link");
			 * CommonWebActions.javaclick("Portal_Link");
			 */
			CommonWebActions.waitUntil("Click_SreviceBunde2");
			CommonWebActions.webClick("Click_SreviceBunde2");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link1");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");

			CommonWebActions.wait(2000);
			CommonWebActions.Selectvaluefromdropdown("Upgrade_IPTV", "Tv-paket Stor");
			CommonWebActions.wait(2000);

			CommonWebActions.waitUntil("Checkbox_new");
			CommonWebActions.javaclick("Checkbox_new");
			CommonWebActions.waitUntil("Checkbox_new2");
			CommonWebActions.javaclick("Checkbox_new2");
			CommonWebActions.waitUntil("Checkbox_new3");
			CommonWebActions.javaclick("Checkbox_new3");
			CommonWebActions.waitUntil("Checkbox_new4");
			CommonWebActions.javaclick("Checkbox_new4");
			CommonWebActions.waitUntil("Additional_Pkg");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.waitUntil("Checkbox_new5");
			CommonWebActions.webClick("Checkbox_new5");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}


 /**
  * @TestcaseName:TC_007_MDU_Modify_Broadband_Upgrade
  * @Description: 
  * @Complexity:High
  * @author :Mohan
  * @ALM :
  * 
  */
 
 @Test(priority = 7,enabled=true)
	public void TC_007_MDU_Modify_Broadband_Upgrade() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {

			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			CommonWebActions.waitUntil("Click_SreviceBundel");
			CommonWebActions.webClick("Click_SreviceBundel");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			/*
			 * CommonWebActions.waitUntil("Portal_Link");
			 * CommonWebActions.javaclick("Portal_Link");
			 * CommonWebActions.waitUntil("Click_SreviceBunde2");
			 * CommonWebActions.webClick("Click_SreviceBunde2");
			 * CommonWebActions.waitUntil("Modify_Link");
			 * CommonWebActions.webClick("Modify_Link");
			 * CommonWebActions.waitUntil("Continue_Link");
			 * CommonWebActions.webClick("Continue_Link"); CommonWebActions.wait(5000);
			 */
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link2");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("speed_zero", "0");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 500");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(3000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + testcasename + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}


 /**
  * @TestcaseName:TC_008_MDU_Modify_Broadband_Upgrade_Bulk
  * @Description: 
  * @Complexity:High
  * @author :Mohan
  * @ALM :
  * 
  */
 
 @Test(priority = 8,enabled=true)
	public void TC_008_MDU_Modify_Broadband_Upgrade_Bulk() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {

			/*--  Launching URL  --*/
			CommonWebActions.login();
			// CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Go_Enter");
			CommonWebActions.webClick("Go_Enter");
			CommonWebActions.waitUntil("Click_SreviceBundel");
			CommonWebActions.webClick("Click_SreviceBundel");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			/*
			 * CommonWebActions.waitUntil("Portal_Link");
			 * CommonWebActions.javaclick("Portal_Link");
			 * CommonWebActions.waitUntil("Click_SreviceBunde2");
			 * CommonWebActions.webClick("Click_SreviceBunde2");
			 * CommonWebActions.waitUntil("Modify_Link");
			 * CommonWebActions.webClick("Modify_Link");
			 * CommonWebActions.waitUntil("Continue_Link");
			 * CommonWebActions.webClick("Continue_Link"); CommonWebActions.wait(5000);
			 */
			CommonWebActions.waitUntil("Portal_Link");
			CommonWebActions.javaclick("bund_Link2");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("speed_zero", "0");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 500");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(3000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}

	}
 /**
  * @TestcaseName:Modify_MDU_ChangeSpeed
  * @Description: 
  * @Complexity:High
  * @author :Srujana
  * @ALM :
  * 
  */
 @Test(priority =9, enabled = true)
	public void Modify_MDU_ChangeSpeed() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			// ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			// CommonWebActions.wait(2000);
			CommonWebActions.webSet("ProductType_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("QuerySrchSpec_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Product_GO_Button");
			CommonWebActions.webClick("Product_GO_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("MDU_ServiceBundle");
			CommonWebActions.webClick("MDU_ServiceBundle");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			/*
			 * CommonWebActions.waitUntil("ChangeSpeed_ServiceRecord");
			 * CommonWebActions.javaclick("ChangeSpeed_ServiceRecord");
			 * CommonWebActions.waitUntil("Customize_Link");
			 * CommonWebActions.webClick("Customize_Link"); CommonWebActions.wait(3000);
			 */
			CommonWebActions.scrollIntoWebElement1("Speed_Editbox");
			String text = CommonWebActions.wd
					.findElement(
							By.xpath("(//input[@class='siebui-ctrl-input siebui-ecfg-editfield']//following::a)[1]"))
					.getText();
			System.out.println(text);
			// CommonWebActions.fnHighlightMe("Speed_Editbox");
			// CommonWebActions.javaclick("Speed_Editbox");
			CommonWebActions.webSet("Speed_Editbox", "0");
			Thread.sleep(2000);
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(2000);
			if (text.equals(ExcelUtil.getDataFromExcel(testcasename, "Promotion2"))) {
				CommonWebActions.Selectvaluefromdropdown("Promotion_2",
						ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			} else {

				CommonWebActions.Selectvaluefromdropdown("Promotion_2",
						ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			}
			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");

			// ============
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + testcasename + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
		}
	}	
 @AfterClass
	public void logOut() throws Exception {
		extent.flush();
//		CommonWebActions.logout();
//		 CommonWebActions.wd.quit();
		// CommonWebActions.wd.quit();
	}

//	@AfterSuite
//	public void tearDown() throws Exception {
//		extent.flush();
//		CommonWebActions.logout();
//		 CommonWebActions.wd.quit();
//	}

}