package telia.testautomation.New;

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
public class Sprint4_New extends ExtentManager{
	
	
	
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
 * @TestcaseName:TC_01_MDU_New_Broadband_Bulk
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
	
@Test(priority = 1,enabled=true)	
	public void TC_01_MDU_New_Broadband_Bulk() throws Exception {
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
			// CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.retryingFindClick("ServiceAcct");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			/*
			 * CommonWebActions.scrollIntoWebElement("SalesAddressApplet");
			 * CommonWebActions.wait(5000);
			 */
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			// CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename,
			// "Ingång"));
			// CommonWebActions.webSet("ApartmentNo",
			// ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
			App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
			App_CommonFunctions.checkBoxSelect("PremiseCheckbox");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Shipping_Click");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("Shipping_address");
			CommonWebActions.wait(1000);

			/*
			 * CommonWebActions.webClick("CopperMaxHD");
			 * CommonWebActions.webSet("CopperMaxHDIp",
			 * ExcelUtil.getDataFromExcel(testcasename, "CopperHDMax"));
			 * CommonWebActions.wait(1000); CommonWebActions.webClick("CopperMaxSD");
			 * CommonWebActions.webSet("CopperMaxSDIp",
			 * ExcelUtil.getDataFromExcel(testcasename, "CopperSDMax"));
			 * CommonWebActions.wait(500);
			 */
			CommonWebActions.webClick("PointIDClick");
			String pointFetch = App_CommonFunctions.orderNoFetch("point_Fetch");
			System.out.println(pointFetch);
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("Push_side");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Fiend_DropDown", ExcelUtil.getDataFromExcel(testcasename, "PointID"));
			CommonWebActions.wait(500);
			CommonWebActions.webSet("PointFetch_Enter", pointFetch);
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_go");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_right");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("BillingCheckBox1");
			CommonWebActions.wait(500);

			/*
			 * CommonWebActions.javaclick("ShippingAddress_Click");
			 * CommonWebActions.wait(500);
			 */
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("bill_dropdown", "Profiles");
			CommonWebActions.wait(500);

			CommonWebActions.javaclick("BillProfileBtn");

			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("CustomerAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			// CommonWebActions.webClick("AcctSummryTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.wait(2000);
			CommonWebActions.fnHighlightMe("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);

			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			// CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			} else {
				System.out.println("Alert not present");
			}

			/*
			 * App_CommonFunctions.NewLineITem(2, "Access Type",
			 * ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			 * CommonWebActions.wait(1000); App_CommonFunctions.NewLineITem(2,
			 * "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename,
			 * "Conn_Ref")); CommonWebActions.wait(1000);
			 * 
			 * CommonWebActions.javaclick("PSTN_num4"); CommonWebActions.wait(3000);
			 * CommonWebActions.webSet("PSTN_num1","46346770070");
			 * CommonWebActions.wait(2000);
			 */

			CommonWebActions.javaclick("Delivery_Contact");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Delivery_Contact_lick",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(2000);

			CommonWebActions.javaclick("Delivery_Contact_bundel");
			CommonWebActions.wait(500);

			/*
			 * CommonWebActions.waitUntil("DeliveryContact_ok");
			 * 
			 * CommonWebActions.webClick("Select_DeliveryContact");
			 * CommonWebActions.wait(500); CommonWebActions.webClick("DeliveryContact_ok");
			 */

			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			/*
			 * CommonWebActions.webSet("speed_zero","0");
			 * CommonWebActions.waitUntil("Speed_AddItems");
			 * CommonWebActions.javaclick("Speed_AddItems"); CommonWebActions.wait(500);
			 */

			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 100/100");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
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
 * @TestcaseName:TC_02_MDU_New_Broadband_Bulk_Upgraded
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
	
@Test(priority = 2,enabled=true)

	public void TC_02_MDU_New_Broadband_Bulk_Upgraded() throws Exception {
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
			// CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			/*
			 * CommonWebActions.scrollIntoWebElement("SalesAddressApplet");
			 * CommonWebActions.wait(5000);
			 */
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			// CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename,
			// "Ingång"));
			// CommonWebActions.webSet("ApartmentNo",
			// ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
			App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
			App_CommonFunctions.checkBoxSelect("PremiseCheckbox");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Shipping_Click");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("Shipping_address");
			CommonWebActions.wait(500);

			/*
			 * CommonWebActions.webClick("CopperMaxHD");
			 * CommonWebActions.webSet("CopperMaxHDIp",
			 * ExcelUtil.getDataFromExcel(testcasename, "CopperHDMax"));
			 * CommonWebActions.wait(1000); CommonWebActions.webClick("CopperMaxSD");
			 * CommonWebActions.webSet("CopperMaxSDIp",
			 * ExcelUtil.getDataFromExcel(testcasename, "CopperSDMax"));
			 * CommonWebActions.wait(500);
			 */
			CommonWebActions.webClick("PointIDClick");
			String pointFetch = App_CommonFunctions.orderNoFetch("point_Fetch");
			System.out.println(pointFetch);
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");

			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("Push_side");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Fiend_DropDown", ExcelUtil.getDataFromExcel(testcasename, "PointID"));
			CommonWebActions.wait(500);
			CommonWebActions.webSet("PointFetch_Enter", pointFetch);
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_go");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_right");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.wait(500);
			App_CommonFunctions.checkBoxSelect("BillingCheckBox1");
			CommonWebActions.wait(500);
			/*
			 * CommonWebActions.javaclick("Shipping_Click"); CommonWebActions.wait(500);
			 * App_CommonFunctions.checkBoxSelect("Shipping_address");
			 * CommonWebActions.wait(500);
			 */
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("bill_dropdown", "Profiles");
			CommonWebActions.wait(500);

			CommonWebActions.javaclick("BillProfileBtn");

			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.wait(2000);
			CommonWebActions.fnHighlightMe("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);

			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			// CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			} else {
				System.out.println("Alert not present");
			}

			/*
			 * App_CommonFunctions.NewLineITem(2, "Access Type",
			 * ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			 * CommonWebActions.wait(1000); App_CommonFunctions.NewLineITem(2,
			 * "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename,
			 * "Conn_Ref")); CommonWebActions.wait(1000);
			 * 
			 * CommonWebActions.javaclick("PSTN_num4"); CommonWebActions.wait(3000);
			 * CommonWebActions.webSet("PSTN_num1","46346770070");
			 * CommonWebActions.wait(2000);
			 */

			CommonWebActions.javaclick("Delivery_Contact");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Delivery_Contact_lick",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(2000);

			CommonWebActions.javaclick("Delivery_Contact_bundel");
			CommonWebActions.wait(500);

			/*
			 * CommonWebActions.waitUntil("DeliveryContact_ok");
			 * 
			 * CommonWebActions.webClick("Select_DeliveryContact");
			 * CommonWebActions.wait(500); CommonWebActions.webClick("DeliveryContact_ok");
			 */

			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			/*
			 * CommonWebActions.webSet("speed_zero","0");
			 * CommonWebActions.waitUntil("Speed_AddItems");
			 * CommonWebActions.javaclick("Speed_AddItems"); CommonWebActions.wait(500);
			 */
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Bredband 500");
			CommonWebActions.wait(500);

			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
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

	
@AfterClass
public void logOut() throws Exception {
//	extent.flush();
//	 CommonWebActions.wd.quit();
	// CommonWebActions.wd.quit();


//@AfterSuite
//public void tearDown() throws Exception {
//	extent.flush();
//	CommonWebActions.logout();
//	 CommonWebActions.wd.quit();
//}

}
	

}
