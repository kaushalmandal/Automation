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

public class Sprint6_Disconnect_service extends ExtentManager {
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
		public void TC_001_Ext_KO_Disconnect_Broadband() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			
//-- Launching URL --//
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(4000);

//Handling_Alert -- //			
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
			
//-- Launching URL --//
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
//-- click on promotions
			
			//kaushal
			CommonWebActions.webClick("click_promotions");
			CommonWebActions.webClick("Disconnect_Button1");
			 CommonWebActions.webClick("Continue_Button");

			
//--Step:2 Verify Service Bundle and Product --//
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type").trim();
			String ExpectedActionCodeStatus = ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus").trim();
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband").trim();
			String ServiceBundle_Broadband = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_Broadband").trim();
			String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "AccesssType").trim();
			App_CommonFunctions.verifyserviceBundleandProduct(ProductType, ServiceBundle_Broadband, ExpectedAccesssType,Product_IPTV);
			
//--Step:3 Enter Due Date and click on continue button and Verify Action Code Status --//
			App_CommonFunctions.enterDueDateAndVerifyActionCodeStatus(DueDate, ExpectedActionCodeStatus, testcasename);
//--Step:4 Enter Reason Code, Save, click on submit button and click on Query button and verify the Status --//
			String ReasonCode = ExcelUtil.getDataFromExcel(testcasename, "ReasonCode").trim();
			String Expected_Activities_Type = ExcelUtil.getDataFromExcel(testcasename, "Activities_Type").trim();
			String Expected_Activities_Status = ExcelUtil.getDataFromExcel(testcasename, "Activities_Status").trim();
			App_CommonFunctions.enterReasonCodeandSubmit(ReasonCode, Expected_Activities_Type, Expected_Activities_Status, testcasename);

//-- Taking Screenshot -- //
			CommonWebActions.waitForLoad1();
			test.log(Status.PASS, "Brodband Disconnect ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
//			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
//			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
//			ALMTestfactory.updateResults("E2EMM Automation", "Sprint6", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
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
//			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
//			ALMTestfactory.updateResults("E2EMM Automation", "Sprint6", 39921, (new Object() {
//			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL"); 
			
			// -- Log out -- //		
			CommonWebActions.logout();
		}
	}
}