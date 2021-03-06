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

public class Sprint5_Disconnect_Service extends ExtentManager {
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
		/*CommonWebActions.login();
		CommonWebActions.waitForLoad1();
		CommonWebActions.wait(2000);*/
	}
	

//---------------------------------------TC_001_SDU_Disconnect_Broadband_Service -----------------------------------------
/**
 * @TestcaseName: TC_001_SDU_Disconnect_Broadband_Service
 * @Description: 
 * @Complexity:High
 * @author :R. Suresh
 * Date: 28-Mar-2019 
 * @ALM : 
 */ 
	
@Test(priority = 1,enabled=true)
		public void TC_001_SDU_Disconnect_Broadband_Service() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			
// -- Launching URL --//
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(4000);

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
			
// -- Launching URL --//
			//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			CommonWebActions.wait(1000); 
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.wait(1000); 
			CommonWebActions.webClick("Home_Tab");


//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			CommonWebActions.wait(1000); 
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
								
//-- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

			
// --Step:2 Verify Service Bundle and Product --//
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,Product_IPTV);
			
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Brodband Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "Pass"); 
			
			// -- Log out -- //		
						CommonWebActions.logout();
						
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_001_SDU_Disconnect_Broadband_Service Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC_001_MDU_Disconnect_Broadband_BULK")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL"); 
			
			// -- Log out -- //		
			CommonWebActions.logout();
		}
	}

//---------------------------------------TC_002_SDU_Disconnect_IPTV_Service-----------------------------------------
/**
 * TC_002_SDU_Disconnect_IPTV_Service
 * @Description: Disconnecting the IPTV Service form the Account.
 * @Complexity:High
 * @author :Suresh
 * Date: 28-March-2019
 * @ALM :
 * 
 */ 
@Test(priority = 2,enabled=false)
	public void TC_002_SDU_Disconnect_IPTV_Service() throws Exception {
		// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Test Case Started:" + testcasename);
		try {			
// -- Launching URL --//
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();

			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
								
//-- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
// --Step:2 Verify ServiceBundle_IPTV and Product_IPTV and click on Disconnect --///
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType,
					Product_IPTV); 

// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
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
            
// --Step:5 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --///
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			//String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			//String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type,
					Expected_Activities_Status, testcasename);
			
			// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS"); 
			
			// -- Log out -- //		
			CommonWebActions.logout();
			
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL"); 
			
			// -- Log out -- //		
			CommonWebActions.logout();
		}

	}

//---------------------------------------TC_003_SDU_Disconnect_VAS_Service-----------------------------------------
/**
* TC_003_SDU_Disconnect_VAS_Service
* @Description: 
* @Complexity:High
* @author :Suresh
 * Date: 28-Mar-2019 
 * @ALM : 
 */ 
	
@Test(priority = 1,enabled=false)
		public void TC_003_SDU_Disconnect_VAS_Service() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			
// -- Launching URL --//
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(4000);

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
			
// -- Launching URL --//
			//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			CommonWebActions.wait(1000); 
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.wait(1000); 
			CommonWebActions.webClick("Home_Tab");


//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			CommonWebActions.wait(1000); 
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
								
//-- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

			
// --Step:2 Verify Service Bundle and Product --//
		String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
		String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
		String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
		String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
		String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
		App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType,Product_IPTV);
						
						
// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Brodband Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "Pass"); 
			
			// -- Log out -- //		
						CommonWebActions.logout();
						
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Fail");
			test.log(Status.FAIL, "TC_001_SDU_Disconnect_Broadband_Service Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC_001_MDU_Disconnect_Broadband_BULK")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL"); 
			
			// -- Log out -- //		
			CommonWebActions.logout();
		}
	}
//---------------------------------------TC_004_SDU_Disconnect_VoIP_Service-----------------------------------------
/**
* TC_004_SDU_Disconnect_VoIP_Service
* @Description: 
* @Complexity:High
* @author :Suresh
* Date: 28-March-2019
* @ALM :
* 
*/ 
@Test(priority = 4,enabled=false)
	public void TC_004_SDU_Disconnect_VoIP_Service() throws Exception {
	// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
	ExtentManager.startReporting(new Object() {
	}.getClass().getEnclosingMethod().getName(), Packagename);
	String testcasename = (new Object() {
	}.getClass().getEnclosingMethod().getName());
	System.out.println("Test Case Started:" + testcasename);
	try {	
			// -- Launching URL --//
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			
			//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim(); 

			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

//-- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
								
//-- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

			 
			// --Step:2 Verify ServiceBundle_IPTV and Product_IPTV and click on  Disconnect --///
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType,
					Product_IPTV);  

			// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

			// --Step:4 Click Portal Button to Disconnect Another Product //
			CommonWebActions.wait(1000);
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

			// --Step:5 Verify Broadband Service Bundle and Product_Broadband and click on Disconnect --///
			CommonWebActions.wait(1000);
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
					Product_Broadband);  

			// --Step:6 Enter Due Date and click on continue button and Verify Action Code Status --///
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

			// --Step:7 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --///
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type")
					.trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type,
					Expected_Activities_Status, testcasename);
				 
			// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS"); 

			// -- Log out -- //		
			CommonWebActions.logout();
			
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL"); 

			// -- Log out -- //		
			CommonWebActions.logout();	
		}
		

	}
//-----------------------------End Test ----------------------------------------//
	@AfterTest
	public void logOut() throws Exception {
		//CommonWebActions.logout();
		//CommonWebActions.wd.quit();
		// CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		//CommonWebActions.wd.quit();
	}
}
