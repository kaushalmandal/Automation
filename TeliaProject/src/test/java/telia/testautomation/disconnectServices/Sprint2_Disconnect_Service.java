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

import org.openqa.selenium.By;
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

public class Sprint2_Disconnect_Service extends ExtentManager {
	public static String url = "Test";
	private static String hostName;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];

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

// -----------------------TC_001_xDSL_Disconnect_Broadband_Service----------------------
/**
* @TestcaseName:TC_001_xDSL_Disconnect_Broadband_Service
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
*/
@Test(priority = 1, enabled = true)
	public void TC_001_xDSL_Disconnect_Broadband_Service() throws Exception {
		try {
			// -- Getting Current Method Name and passing to .xls file to get
			// appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

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

			// -- Launching URL --//
			// CommonWebActions.login(); 
			
			//Get data from .xls file
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type")
					.trim();
			String Expected_ActivitiesTab_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			
			//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

			// --Step:2 Verify Service Bundle and Product --//
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband); // --- // 3

			// --Step:3 Enter Due Date and click on continue button and Verify
			// Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

			// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_ActiviActivitiesTab_Type, Expected_ActivitiesTab_Status, testcasename);

			// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

// -----------------------Sprint_2_TC_002_xDSL_Disconnect_Broadband_and_VoIP_VDSL----------------------
/**
* @TestcaseName:TC_002_xDSL_Disconnect_Broadband_and_VoIP_VDSL
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
*/
@Test(priority = 2, enabled = true)
	public void TC_002_xDSL_Disconnect_Broadband_and_VoIP_VDSL() throws Exception {

		try {
			// -- Getting Current Method Name and passing to .xls file to
			// getappropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

			/*try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			}*/

// -- Launching URL --//
			// CommonWebActions.login(); 	// --> Note: Moved into before test

//Get value from .xls file
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();

			
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

// --Step:2 get value from .xls and Verify VoIP Service Bundle and Product and click on Disconnect --//
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_VoIP, ExpectedAccesssType, Product_VoIP);

// --Step:3 get value form .xls Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateforVOiPAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Click Portal Button to Disconnect Another Product //
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

// --Step:5 Verify Broadband Service Bundle and Product and click on Disconnect --//
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
					Product_Broadband); //

// --Step:6 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateforVOiPAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:7 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
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
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	// -----------------------@TestcaseName:TC_003_xDSL_Disconnect_Broadband_VoIP_and_IPTV_ADSL----------------------
// -----------------------@TestcaseName:TC_003_xDSL_Disconnect_Broadband_VoIP_and_IPTV_ADSL----------------------
/**
* @TestcaseName:TC_003_xDSL_Disconnect_Broadband_VoIP_and_IPTV_ADSL
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
*/
@Test(priority = 3, enabled = true)
public void TC_003_xDSL_Disconnect_Broadband_VoIP_and_IPTV_ADSL() throws Exception {
/// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. --/
      try {
//-- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
      ExtentManager.startReporting(new Object() {
      }.getClass().getEnclosingMethod().getName(), Packagename);
      String testcasename = (new Object() {
      }.getClass().getEnclosingMethod().getName());
      System.out.println("testcase:" + testcasename);
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

//-- Launching URL --//
             // Note: Moved into before test

//-- Launching URL --//
      // Note: Moved into before test
      //--Step:1 Navigate Tab & Search By SSN and click on User Name Link
      String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
      String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
      System.out.println("** SSN **: " + SSN_No);
      CommonWebActions.waitForLoad1();
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
//Step:2 Verify ServiceBundle_IPTV and Product_IPTV and click on Disconnect --///
      String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
      String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
      String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
      String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
       App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType,
                          Product_IPTV); // --- // 3

//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
       String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
                   .trim();
// -- set Data in to Excel --//
      ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
       App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:4 Click Portal Button to Disconnect Another Product //
       App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

//--Step:5 Verify VoIP Service Bundle and Product_VoIP and click on Disconnect --///
      String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
      String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
       App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_VoIP, ExpectedAccesssType,
                   Product_VoIP); // --- // 3

//--Step:6 Enter Due Date and click on continue button and Verify Action Code Status --///
       App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:7 Click Portal Button to Disconnect Another Product //
       App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

//--Step:8 Verify Broadband Service Bundle and Product_Broadband and click on Disconnect --///
      String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
      String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
             
       App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
                   Product_Broadband); // --- // 3

//--Step:9 Enter Due Date and click on continue button and Verify Action Code Status --///
       App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

//--Step:10 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --///
      String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
      String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
      String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
       App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type,
                   Expected_Activities_Status, testcasename);

//-- Taking Screenshot -- //
      CommonWebActions.waitForLoad1();
      test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
             + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
             + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
             extent.flush();
      String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
      ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
      ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
      }.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
      System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
      ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
      ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
      }.getClass().getEnclosingMethod().getName()), "Not Completed");

      } catch (Exception e) {
      CommonWebActions.closeAlerts();
      ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
      }.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
      test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
      }.getClass().getEnclosingMethod().getName()) + ":" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
      ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
      ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
      }.getClass().getEnclosingMethod().getName()), "Fail");
      }
}
    



// -----------------------TestcaseName:TC_004_xDSL_Disconnect_Broadband_VoIP_and_IPTV_VDSL----------------------
/**
* @TestcaseName:TC_004_xDSL_Disconnect_Broadband_VoIP_and_IPTV_VDSL
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
* 
*/
@Test(priority = 4, enabled = true)
public void TC_004_xDSL_Disconnect_Broadband_VoIP_and_IPTV_VDSL() throws Exception {
	try {
			/// -- Getting Current Method Name and passing to .xls file to get
			/// appropriate value for this TC. --/
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
			// Note: Moved into before test

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
			
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.wait(1000);

/// --Step:1 Navigate Tab and Search By SSN and click on User Name
			// -- Launching URL --//
			// Note: Moved into before test
			//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim(); 
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			System.out.println("** SSN **: " + SSN_No);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
/// --Step:2 Verify ServiceBundle_IPTV and Product_IPTV and click on Disconnect --///
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ServiceBundle_IPTV = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_IPTV, ExpectedAccesssType,
					Product_IPTV); // --- // 3

/// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --///
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// ---Step:4 Click Portal Button to Disconnect Another Product //
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

/// --Step:5 Verify VoIP Service Bundle and Product_VoIP and click  on Disconnect --///
			String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_VoIP, ExpectedAccesssType,
					Product_VoIP);

/// --Step:6 Enter Due Date and click on continue button and Verify  Action Code Status --///
			App_CommonFunctions.enterDueDateforVOiPAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// ---Step:7 Click Portal Button to Disconnect Another Product //
			App_CommonFunctions.clickPortalButtonToDisconnectAnotherProduct();

/// --Step:8 Verify Broadband Service Bundle and Product_Broadband and click on Disconnect --///
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
					Product_Broadband);

/// --Step:9 Enter Due Date and click on continue button and Verify Action Code Status --///
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --///
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
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
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			 ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail"); 
		}
	}
//-----------------------TC_005_xDSL_Disconnect_IPTV----------------------
/**
* @TestcaseName: TC_005_xDSL_Disconnect_IPTV
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
* 
*/
@Test(priority = 5, enabled = true)
	public void TC_005_xDSL_Disconnect_IPTV() throws Exception {
		try {
// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
			// CommonWebActions.login();
			// Note: Moved into before test

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
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();

// --Step:1 Navigate Tab and Search By SSN and click on User Name Link--//
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			System.out.println("** SSN **: " + SSN_No);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();
			
//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

			
// --Step:2 Verify Service Bundle and Product --//
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
					Product_IPTV); 

// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
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
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}
//-----------------------TC_006_xDSL_Disconnect_VoIP----------------------
/**
* @TestcaseName: TC_006_xDSL_Disconnect_VoIP --> DATA iSSUE
* @Description:
* @Complexity:High
* @author :Suresh
* @ALM :
*/

@Test(priority = 6, enabled = true)
	public void TC_006_xDSL_Disconnect_VoIP() throws Exception {

		try {
// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
			// CommonWebActions.login();
			// Note: Moved into before test

// Handling_Alert -- //
			/*try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
			}*/

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String MenuItemInput = ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input").trim();
			System.out.println("** SSN **: " + SSN_No);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");
			
// --Step:2 Verify Service Bundle and Product --//
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ServiceBundle_VoIP = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_VoIP").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_VoIP, ExpectedAccesssType,
					Product_VoIP); //

// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();
			App_CommonFunctions.enterDueDateforVOiPAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
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
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}
//-----------------------TC_007_XDSL_68_Handle_Disconnectreasons_for_xDSL_Disconnect_orders----------------------
	/**
	 * TC_007_XDSL_68_Handle_Disconnectreasons_for_xDSL_Disconnect_orders
	 * @Description:
	 * @Complexity:High
	 * @author :Suresh
	 * @ALM :
	 * 
	 */
	@Test(priority = 7, enabled = true)
	public void TC_007_XDSL_68_Handle_Disconnectreasons_for_xDSL_Disconnect_orders() throws Exception {
		try {
// -- Getting Current Method Name and passing to .xls file to get appropriate value for this TC. -- //
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);

// -- Launching URL --//
			// CommonWebActions.login();
			// Note: Moved into before test
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

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN").trim();
			String DueDate = ExcelUtil.getDataFromExcel(testcasename, "DueDate").trim();
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			System.out.println("** SSN **: " + SSN_No);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Home_Tab");
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(500);

//--Step:1 Navigate Tab & Search By SSN and click on User Name Link
			App_CommonFunctions.SearchServiceAccount(SSN_No, "Residential");

// -- Set Value into xls File --//
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", SSN_No);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", DueDate);
						
// -- Click on First Name Link
			CommonWebActions.retryingFindClick("FirstName_Link");

// --Step:2 Verify Service Bundle and Product --//
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();	
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();	
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,
					Product_Broadband); //

// --Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus")
					.trim();	
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);

// --Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String Expected_ActiviActivitiesTab_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type")
					.trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_ActiviActivitiesTab_Type,
					Expected_Activities_Status, testcasename);

// -- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "BB,IPTV, Disconnect Bradband ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "Fail");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
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
