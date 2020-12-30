package telia.testautomation.suspendresume;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

	public class Sprint5_SuspendResume extends ExtentManager{
		
		private static String hostName;
		String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
		
		
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
		
		@Test(priority=1,enabled=true)
		  
		public void MDU_Suspend_Payment_Broadband() throws Exception {
			try {
				ExtentManager.startReporting(new Object() {
				}.getClass().getEnclosingMethod().getName(),Packagename);
				String testcasename = (new Object() {
				}.getClass().getEnclosingMethod().getName());
				CommonWebActions.login();
				CommonWebActions.waitUntilLoaded("MyOrder_link",50000);
				CommonWebActions.webClick("Home_Tab");
				App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
				CommonWebActions.wait(2000);
				CommonWebActions.webClick("FirstName_Link");
				CommonWebActions.webSet("InstallAssets_Dropdown",ExcelUtil.getDataFromExcel(testcasename,"Product_Type"));
		        CommonWebActions.webSet("InstallAssets_Textdown",ExcelUtil.getDataFromExcel(testcasename,"Product_Broadband"));
				CommonWebActions.waitUntil("Installed_Assets_Go_Button");
				CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
                CommonWebActions.wait(2000);
                CommonWebActions.waitUntil("Settings");
				CommonWebActions.webClick("Settings");
			    CommonWebActions.waitUntil("Suspend");
				CommonWebActions.passWithoutClear("Suspend", "");
				// ====Adding Duedate 
				/* Adding Due date to 8days */
				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cl = Calendar.getInstance();
			    cl.add(Calendar.DATE,8);// adds 8days
				String newtime = inputFormat.format(cl.getTime());
				System.out.println(newtime);
				CommonWebActions.webSet("MoveDueDate",newtime);
				CommonWebActions.webClick("Continue");
				CommonWebActions.wait(3000);
				CommonWebActions.webSet("ReasonCode_I",ExcelUtil.getDataFromExcel(testcasename,"ReasonCode"));
				CommonWebActions.webSet("Sapdate",newtime);
				CommonWebActions.wait(3000);
				App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
				CommonWebActions.savePage();
				CommonWebActions.wait(2000);
				CommonWebActions.scrollup();
				CommonWebActions.wait(4000);
				CommonWebActions.waituntilElementToBeClickable("Submit");
				CommonWebActions.webClick("Submit");
				CommonWebActions.wait(5000);
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
						App_CommonFunctions.orderNoFetch("OrderNo"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
						App_CommonFunctions.orderNoFetch("Due_value1"));
				CommonWebActions.wait(3000);
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
				System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, testcasename, "Not Completed");
				CommonWebActions.logout();
			} catch (Exception e) {
				CommonWebActions.closeAlerts();
				test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
				}.getClass().getEnclosingMethod().getName()) + ":"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			//	ExcelUtil.setDatatoExcel("Test_Output", testcasename,"Script_Status","FAIL");
			//	ALMTestfactory.updateResults("E2EMM Automation", "Sprint5",39921,testcasename,"Fail");
				e.printStackTrace();
				e.getMessage();
			}
	}
		
		@Test(priority=2, enabled=true)
		  
		public void MDU_Resume_Payment() throws Exception {
			try {
				ExtentManager.startReporting(new Object() {
				}.getClass().getEnclosingMethod().getName(),Packagename);
				String testcasename = (new Object() {
				}.getClass().getEnclosingMethod().getName());
				CommonWebActions.login();
				CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
				//CommonWebActions.login();
				//CommonWebActions.login();
				CommonWebActions.webClick("Home_Tab");
				CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
				App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
				CommonWebActions.wait(2000);
				CommonWebActions.webClick("FirstName_Link");
				CommonWebActions.webSet("InstallAssets_Dropdown",ExcelUtil.getDataFromExcel(testcasename,"Product_Type"));
		        CommonWebActions.webSet("InstallAssets_Textdown",ExcelUtil.getDataFromExcel(testcasename,"Product_Broadband"));
				CommonWebActions.waitUntil("Installed_Assets_Go_Button");
				CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
                CommonWebActions.wait(2000);
                CommonWebActions.waitUntil("Settings");
				CommonWebActions.webClick("Settings");
			    CommonWebActions.waitUntil("Resume");
				CommonWebActions.passWithoutClear("Resume", "");
			  /* Adding Due date to 8days */
				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cl = Calendar.getInstance();
			    cl.add(Calendar.DATE,8);// adds 8days
				String newtime = inputFormat.format(cl.getTime());
				System.out.println(newtime);
				CommonWebActions.webSet("MoveDueDate",newtime);
				CommonWebActions.webClick("Continue");
				CommonWebActions.wait(3000);
		//		CommonWebActions.webSet("ReasonCode_I",ExcelUtil.getDataFromExcel(testcasename,"ReasonCode"));
		//		CommonWebActions.webSet("Sapdate",newtime);
				CommonWebActions.wait(3000);
				App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
				CommonWebActions.savePage();
				CommonWebActions.wait(2000);
				CommonWebActions.scrollup();
				CommonWebActions.wait(4000);
				CommonWebActions.waituntilElementToBeClickable("Submit");
				CommonWebActions.webClick("Submit");
				CommonWebActions.wait(5000);
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
						App_CommonFunctions.orderNoFetch("OrderNo"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
						App_CommonFunctions.orderNoFetch("Due_value1"));
				CommonWebActions.wait(3000);
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
				System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, testcasename, "Not Completed");
				CommonWebActions.logout();
			} catch (Exception e) {
				CommonWebActions.closeAlerts();
				test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
				}.getClass().getEnclosingMethod().getName()) + ":"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			//	ExcelUtil.setDatatoExcel("Test_Output", testcasename,"Script_Status","FAIL");
			//	ALMTestfactory.updateResults("E2EMM Automation", "Sprint5",39921,testcasename,"Fail");
				e.printStackTrace();
				e.getMessage();
			}
		}
	}
	
	
	
	
	
	
	
	

