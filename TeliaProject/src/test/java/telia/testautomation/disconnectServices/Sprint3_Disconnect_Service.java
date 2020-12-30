/*
 * =============================================================
 * Created Date		: 14-Feb-2019
 * Reviewed By 		: murali.b.krishnan
 * Created By		: R.Suresh Babu
 * =============================================================
 */

package telia.testautomation.disconnectServices;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

@Listeners({ coreFramework.CoreListener.class })

public class Sprint3_Disconnect_Service extends ExtentManager {
	public static String url = "Test";
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName", Packagename);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
	
	
	@BeforeTest
	public void beforetest() throws Exception {
		CommonWebActions.login();
		CommonWebActions.waitForLoad1();		
	}
	
	
/**
 * @TestcaseName:TC_001_MDU_Disconnect_Broadband_IPTV_and_VoIP_Upgraded_BULK
 * @Description: 
 * @Complexity:High
 * @author :Suresh
 * Date: 26-Feb-2019
 * @ALM :
 * 
 */ 
@Test(priority = 1,enabled=true)
	public void TC_001_MDU_Disconnect_Broadband_IPTV_and_VoIP_Upgraded_BULK() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("Test Case Started:"+testcasename);
			
// -- Launching URL --//
			//Note: Moved into before test
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");			
			
			//-------
// -- Get value form .xls file and store into variable --//
			/*String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
			String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();*/
			
//--Step:2 get data from .xls and Verify ServiceBundle_IPTV and Product_IPTV and click on Disconnect  --///			
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();			
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType, Product_IPTV); // ---	// 3
			
//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
			
//--Step:4 Click Portal Button to Disconnect Another Product //
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

//--Step:5 get value form .xls and Verify Broadband Service Bundle and Product_Broadband and click on Disconnect  --///
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // ---	// 3

//--Step:6 Enter Due Date and click on continue button and Verify Action Code Status --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
	
//--Step:7 get value form .xls and Enter Reason Code, Save, click on submit button and click on Query button and verify the Status   --///
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil .getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

//-----------------------------------------------------------------TC_002----------------------------------------------------------------------
/**
 * @TestcaseName:TC_002_MDU_Disconnect_Broadband_IPTV_and_VoIP_Upgraded
 * @Description: 
 * @Complexity:High
 * @author :R. Suresh
 * Date: 27-Feb-2019 
 * @ALM :
 * 
 */ 
@Test(priority = 2,enabled=true)
	public void TC_002_MDU_Disconnect_Broadband_IPTV_and_VoIP_Upgraded() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/
			
// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();		
	
// Handling_Alert -- //
/*			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				//e.printStackTrace();
			}*/
			
// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
			String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

//--Step:2 Verify ServiceBundle_IPTV and Product_IPTV and click on Disconnect  --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType, Product_IPTV); // ---	// 3
			
//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:4 Click Portal Button to Disconnect Another Product //
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

//--Step:5 Verify VoIP Service Bundle and Product_VoIP and click on Disconnect  --///
			/*CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_VoIP, ExpectedAccesssType, Product_VoIP); // ---	// 3

//--Step:6 Enter Due Date and click on continue button and Verify Action Code Status --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:7 Click Portal Button to Disconnect Another Product //
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();*/
			
//--Step:8 Verify Broadband Service Bundle and Product_Broadband and click on Disconnect  --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // ---	// 3

//--Step:9 Enter Due Date and click on continue button and Verify Action Code Status --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
	
//--Step:10 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status   --///
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
					.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
//			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
// -- Taking Screenshot -- //
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}
	
//------------------------------------------TC_003 TC_003_MDU_Disconnect_IPTV_Upgraded------------------------------
/**
 * @TestcaseName:TC_003_MDU_Disconnect_IPTV_Upgraded
 * @Description: 
 * @Complexity:High
 * @author :R. Suresh
 * Date: 04-Mar-2019 
 * @ALM :
 * 
 */ 
@Test(priority = 3,enabled=true)
		public void TC_003_MDU_Disconnect_IPTV_Upgraded() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/
// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

// Handling_Alert -- //			
/*			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// e.printStackTrace();
			}*/

// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
// --Step:2 Verify Service Bundle and Product --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,Product_IPTV);
			
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "IPTV, Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
//			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_003_MDU_Disconnect_IPTV_Upgraded Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC_003_MDU_Disconnect_IPTV_Upgraded")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
		}
	}
//-----------------------------------TC_004_MDU_Disconnect_IPTV_Upgraded_BULK---------------------------------------
/**
 * @TestcaseName: TC_004_MDU_Disconnect_IPTV_Upgraded_BULK
 * @Description: 
 * @Complexity:High
 * @author :R. Suresh
 * Date: 05-Mar-2019 
 * @ALM :
 * 
 */ 
@Test(priority = 4,enabled=true)
		public void TC_004_MDU_Disconnect_IPTV_Upgraded_BULK() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get
			// appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);
			
// -- Launching URL --//
			/*CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("MyOrder_link");*/

// -- page load --//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();
			
// Handling_Alert -- //
/*			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// e.printStackTrace();
			}*/
			
// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
// --Step:2 Verify Service Bundle and Product --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,Product_IPTV);
			
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "IPTV, Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_003_MDU_Disconnect_IPTV_Upgraded Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC_003_MDU_Disconnect_IPTV_Upgraded")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
		}
	}

//---------------------------------------TC_005_MDU_Disconnect_IPTV_BULK-----------------------------------------
/**
 * @TestcaseName: TC_005_MDU_Disconnect_IPTV_BULK
 * @Description: 
 * @Complexity:High
 * @author :R. Suresh
 * Date: 05-Mar-2019 
 * @ALM :
 * 
 */ 
@Test(priority = 5,enabled=true)
		public void TC_005_MDU_Disconnect_IPTV_BULK() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);
			
// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/	
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

// Handling_Alert -- //			
/*			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// e.printStackTrace();
			}*/
		
// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
// --Step:2 Verify Service Bundle and Product --//
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,Product_IPTV);
			
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Brodband Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_005_MDU_Disconnect_IPTV_BULK Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC_005_MDU_Disconnect_IPTV_BULK")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint32", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
		}
	}

//---------------------------------------TC_006_MDU_Disconnect_Broadband_Upgraded-----------------------------------------
/**
 * TC_006_MDU_Disconnect_Broadband_Upgraded
 * @Description: 
 * @Complexity:High
 * @author :Suresh
 * Date: 7-March-2019
 * @ALM :
 * 
 */ 
@Test(priority = 6,enabled=true)
	public void TC_006_MDU_Disconnect_Broadband_Upgraded() throws Exception {
try {
	// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:"+testcasename);
			
// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1(); */
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

// Handling_Alert -- //
/*			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			}*/

// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

// --Step:2 Verify Service Bundle and Product --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // --- // 3
	
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
	
// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_006_MDU_Disconnect_Broadband_Upgraded Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");

		}
	}

//---------------------------------------TC_007_Disconnect_MDU_Revise-----------------------------------------
/**
* TC_007_Disconnect_MDU_Revise
* @Description: 
* @Complexity:High
* @author :Suresh
* Date: 7-March-2019
* @ALM :
* 
*/ 
@Test(priority = 7,enabled=true)
public void TC_007_Disconnect_MDU_Revise() throws Exception {
try {
// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);

// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/
// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

// Handling_Alert -- //
/*		try {
			boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
			 if (Dialog){
				 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
			 }
		} catch (Exception e) {
			System.out.println("Cancel Element not present");
		}*/
		
// -- Get value form .xls file and store into variable --//
		String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
		String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
		String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
		String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
		String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
		String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
		String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
		String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
		String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
		String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
		App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
					
//-- Click on First Name Link
		CommonWebActions.retryingFindClick("FirstName_Link");

//--Step:2 Verify Service Bundle and Product --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // --- // 3

//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:4 Enter Reason Code, Save, click on submit button and click on Revise button, Enter the Due date and Submit for Revise the order and submit and verify the Status --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.enterReasonCodeandSubmitAndRevise(ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status, testcasename);

//-- Taking Screenshot -- //
		test.log(Status.PASS, "Disconnect Bradband ["
				+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
		extent.flush();
		String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
		ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
		}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
		System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
	} catch (Exception e) {
		CommonWebActions.closeAlerts();
		ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
		}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
		test.log(Status.FAIL, "TC Name Failed:" + (new Object() {
		}.getClass().getEnclosingMethod().getName()) + ":"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
		}.getClass().getEnclosingMethod().getName()), "Fail");

		}
	}

//---------------------------------------TC_008_xDSL_Disconnect_B2B_WithCommitment-----------------------------------------
/**
* TC_008_xDSL_Disconnect_B2B_WithCommitment
* @Description: 
* @Complexity:High
* @author :Suresh
* Date: 5-March-2019
* @ALM :
* 
*/ 
@Test(priority = 8,enabled=true)
	public void TC_008_xDSL_Disconnect_B2B_WithCommitment() throws Exception {
try {
	// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:"+testcasename);

// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/
// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

// Handling_Alert -- //
/* 			try {
				boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				 if (Dialog){
					 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				 }
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			} */

// -- Get value form .xls file and store into variable --//
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

//--Step:2 Verify Service Bundle and Product --//
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // --- // 3
	
//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			CommonWebActions.waitForLoad1();
			//App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
	
			// -- Enter Due Date --//
      	    CommonWebActions.waitForLoad1();
      	    System.out.println("** Due Date **: " + DueDate);
      	    CommonWebActions.waitUntil("Disconnect_DueDate_Input");
            CommonWebActions.webSetTab("Disconnect_DueDate_Input", DueDate);	
            
            // -- Click on Continue button In POP-UP --//
            CommonWebActions.waitUntil("Continue_Button");
            CommonWebActions.webClick("Continue_Button");
			CommonWebActions.waitForLoad1();
            
//--Step:4 Accepting the Commitment 
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Commitment_Accept_Button");
            CommonWebActions.webClick("Commitment_Accept_Button");
			CommonWebActions.waitForLoad1();
            
			// --- Verify the Action Code Status by using Fun webVerifyInnerText() --//
            CommonWebActions.waitForLoad1();
            CommonWebActions.waitUntil("ActionCodeStatus");
            CommonWebActions.webVerifyInnerText("ActionCodeStatus", ExpectedActionCodeStatus);
            
//--Step:5 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
            CommonWebActions.waitForLoad1();
            App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status, testcasename);

//-- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC Name Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

//---------------------------------------TC_009_Disconnect_SDU_Revise-----------------------------------------
/**
* TC_009_Disconnect_SDU_Revise
* @Description: 
* @Complexity:High
* @author :Suresh
* Date: 8-March-2019
* @ALM :
* 
*/ 
@Test(priority = 9,enabled=true)
public void TC_009_Disconnect_SDU_Revise() throws Exception {
try {
//-- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);

// -- Launching URL --//
/*			CommonWebActions.login();
			CommonWebActions.waitForLoad1();*/
// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

//Handling_Alert -- //
/*		try {
			boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
			 if (Dialog){
				 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
			 }
		} catch (Exception e) {
			System.out.println("Cancel Element not present");
		}*/
		
//-- Get value form .xls file and store into variable --//
		String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
		String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
		String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
		String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
		String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
		String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
		String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
		String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
		String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
		String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
		App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
					
//-- Click on First Name Link
		CommonWebActions.retryingFindClick("FirstName_Link");

//--Step:2 Verify Service Bundle and Product --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // --- // 3

//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:4 Enter Reason Code, Save, click on submit button and click on Revise button, Enter the Due date and Submit for Revise the order and submit and verify the Status --//
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.enterReasonCodeandSubmitAndRevise(ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status, testcasename);

//-- Taking Screenshot -- //
		test.log(Status.PASS, "Disconnect Bradband ["
				+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
		extent.flush();String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
		System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
		}.getClass().getEnclosingMethod().getName()), "Not Completed");
		
	} catch (Exception e) {
		CommonWebActions.closeAlerts();
		ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
		}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
		test.log(Status.FAIL, "TC Name Failed:" + (new Object() {
		}.getClass().getEnclosingMethod().getName()) + ":"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
		}.getClass().getEnclosingMethod().getName()), "Fail");

		}
	}

//-----------------------------End Test ----------------------------------------//
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
