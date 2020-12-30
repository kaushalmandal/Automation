/*
 * Manual Testcase Name :
 * Description of Testcase:
 * Date of Creation:
 * Reviewed By:
 * Author:
 */

package telia.testautomation.Cancel;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mercury.qualitycenter.otaclient.ITestSet;
import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

@Test
@Listeners({ coreFramework.CoreListener.class })

public class Sprint2_Cancel_Scenario extends ExtentManager {
	public static String url = "";
	private static String hostName;
//    private static ITestSet testSet;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];

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
/**
 * @TestcaseName:xDSL_Cancel_New
 * @Description:Cancelling new order 
 * @Complexity:
 * @author :srujana,g
 * @param :
 * 
 */
    @Test(priority=1, enabled=true)    
	public void xDSL_Cancel_New() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			/*-Step 5- Click on New Installassets --*/
			CommonWebActions.javaclick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			/*-Step 6- Print the status of Scoring Response --*/
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			/*-Step 7- Create Line Items by using XDSL Product --*/
			CommonWebActions.webClick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1,"Product",ExcelUtil.getDataFromExcel(testcasename,"Product"));
			CommonWebActions.savePage();
			boolean alertpresent=CommonWebActions.isAlertPresent();
			if(alertpresent){
				CommonWebActions.wd.switchTo().alert(); 
				CommonWebActions.wd.switchTo().alert().accept();
			}
					
			CommonWebActions.wait(1000);
			CommonWebActions.wait(1000);
			// CommonWebActions.webClick("Lineitem_Product");
//			CommonWebActions.wait(1000);
//			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
//			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			// CommonWebActions.Tab();
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			// CommonWebActions.javaSet("Lineitem_ConnectivityRef",
			// ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
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
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(12000);
			/*-Step 12- Cancel the order Before Reaching PONR  --*/
			CommonWebActions.webSet("Cancel_Reason", ExcelUtil.getDataFromExcel(testcasename, "Cancel_Reason"));
			CommonWebActions.EntertextThenPressTabAndSave("Cancel_Reason", " ");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cancel_Order_Button");
			CommonWebActions.wait(3000);
			/*-Step 13- Print the order status  --*/
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			/*-Step 10- Storing the ordernumber and Duedate  --*/
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",
					App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
			// System.out.println("Your new order is sucessfully cancelled ");
			/*-  Print the ScreenShot  --*/
			test.log(Status.PASS, "Cancel_New " + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID")
					+ " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    @Test(priority=2, enabled=true)     
	public void xDSL_Cancel_Modify() throws Exception {
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
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.wait(1000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			// Modify the order
			CommonWebActions.webSet("InstallAssets_Dropdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			// CommonWebActions.webSet("InstallAssets_Textdown", "");
			CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Go_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.wait(1000);
			CommonWebActions.passValuesnSave("DueDate_Popup",
					ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.javaclick("Continue_Popup");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(2000);
			// CommonWebActions.scrollIntoWebElement("Qty_EditTextbox");
			CommonWebActions.fnHighlightMe("Qty_Editbox");
			CommonWebActions.webClick("Qty_EditTextbox");
			CommonWebActions.webSet("Qty_EditTextbox", "0");
			Thread.sleep(2000);
			CommonWebActions.javaclick("AddItem_1A_Speed");
			CommonWebActions.wait(5000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.javaSet("Qty_1A_Speed", "1");
			CommonWebActions.javaclick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.wait(1000);
			/*- If UnEncryptedEmailFlag is "Y" and Order Suppression is "N" --*/
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			// CommonWebActions.scrollIntoWebElement("SalesOrder_Submit");
			CommonWebActions.EntertextThenPressTabAndSave("Reason_Code",
					ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(8000); // Due to slow performance
			CommonWebActions.passValuesnSave("Cancel_Reason",
					ExcelUtil.getDataFromExcel(testcasename, "Cancel_Reason"));
			CommonWebActions.webClick("Cancel_Reason");
			CommonWebActions.webSet("Due_Date", ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cancel_Order_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			/*- Storing the ordernumber and Duedate --*/
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",
					App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
			System.out.println("Your new order is sucessfully cancelled ");
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
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
  
    @Test(priority=3, enabled=true)    
 public void xDSL_Cancel_Disconnect() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			try {
				boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				 if (Dialog){
					 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				 }
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			}
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.wait(1000);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.scrollup();
					CommonWebActions.webSet("InstallAssets_Dropdown",
					ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Go_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Disconnect_Button");
			CommonWebActions.wait(1000);
			CommonWebActions.EntertextThenPressTabAndSave("DueDate_Popup", ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.javaclick("Continue_Popup");
			CommonWebActions.wait(1000);
			/*-Step 9- If UnEncryptedEmailFlag is "Y" and Order Suppression is "N" --*/
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.EntertextThenPressTabAndSave("Reason_Code",
					ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);
			CommonWebActions.passValuesnSave("Cancel_Reason", ExcelUtil.getDataFromExcel(testcasename, "Cancel_Reason"));
			CommonWebActions.webSet("Due_Date", ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim());
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cancel_Order_Button");
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",	App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
			extent.flush();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
//			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
//			// System.out.println("Your new order is sucessfully cancelled ");
//			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			/* ALM Method call */
//			System.setProperty("jacob.dll.path",
//					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
//			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
//			ALMTestfactory.updateResults("E2EMM Automation","Demo", 34441, "Demo_Test","Not Completed" );
			
		}

		catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
			// TODO Auto-generated catch block
		
		}

	}
    	
	// -----------------------------End Test ----------------------------------------//
	@AfterTest
	public void logOut() throws Exception {
		CommonWebActions.logout();
		CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		CommonWebActions.wd.quit();
	}

}
