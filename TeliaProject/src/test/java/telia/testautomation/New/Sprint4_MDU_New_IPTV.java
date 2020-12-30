package telia.testautomation.New;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;
public class Sprint4_MDU_New_IPTV extends ExtentManager {
	
	private static final String SomeElementNotFound = null;
	String hostName;
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
	
/**
	 * @TestcaseName:MDU_NewIPTVBulk
	 * @Description:
	 * @Complexity:High
	 * @author :srujana G
	 * @ALM :
	 * 
	 */
	@Test(priority = 1, enabled =true)
	public void MDU_NewIPTVBulk() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		/* CommonMethods common = new CommonMethods(driver); */
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);

			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 3000);
			CommonWebActions.webClick("Homebtn");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.webClick("New_InstallAssets");

			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitUntil("Listitem_AddNew");
			CommonWebActions.javaclick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(1000);
			// CommonWebActions.Tab();
			/*--Entering the delivery Contract --*/
			App_CommonFunctions.NewLineITem(2, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(6, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4, "Access Type", "300");

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
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.wait(2000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			test.log(Status.PASS, "MDU_NewIPTVBulk"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			extent.flush();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			// TODO Auto-generated catch block
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	/**
	 * @TestcaseName:MDU_NewIPTVBulk_Upgraded
	 * @Description:
	 * @Complexity:High
	 * @author :srujana G
	 * @ALM :
	 * 
	 */
	@Test(priority = 2, enabled =true)
	public void MDU_NewIPTVBulk_Upgraded() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		/* CommonMethods common = new CommonMethods(driver); */
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);

			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			// CommonWebActions.webClick("Homebtn");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("New_InstallAssets");
			CommonWebActions.webClick("New_InstallAssets");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitUntil("Listitem_AddNew");
			CommonWebActions.javaclick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(1000);
			/*--Entering the delivery Contract --*/
			App_CommonFunctions.NewLineITem(2, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(6, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4, "Access Type", "300");
			CommonWebActions.waitUntil("Customize_Button");
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.scrollDown();
			CommonWebActions.javaclick("Package_Button");
			CommonWebActions.wait(2000);
			for (int i = 0; i <= 2; i++) {
				try {
					CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item",
							"Tv-paket Lagom med Viasat Film och Sport");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item",
					"Tv-paket Lagom med Viasat Film och Sport");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp-TV-ViasatPackages-1704");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp_TV_CMorePackages_1704");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(1000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.wait(2000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			extent.flush();
			CommonWebActions.logout();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	
	@AfterClass
	public void logOut() throws Exception {
		extent.flush();
//		CommonWebActions.logout();
//		 CommonWebActions.wd.quit();
		// CommonWebActions.wd.quit();
	}

}