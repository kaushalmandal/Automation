/**
 * 
 */
package telia.testautomation.New;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @author kaviag
 *
 */

@Test
@Listeners({ coreFramework.CoreListener.class })
public class Sprint4_PSTN_UPP  extends ExtentManager{
	
	String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	@BeforeSuite
	public void init() throws Exception {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName",Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
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
	 * @TestcaseName:XDSL_PSTN_UPP
	 * @Description:
	 * @Complexity:High
	 * @author :Kavia
	 * @ALM :
	 * 
	 */ 

	@Test(priority=1, enabled=false)
	public void XDSL_PSTN_UPP() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);

			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchOrgAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("ServiceAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "City"));
			CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.webClick("SearchAdd_Button");
			SelectAddress(ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
			// CommonWebActions.webClick("InstallationAdd");
			// App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.webClick("ShippingAdd_New");
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			// CommonWebActions.webClick("premise");
			// App_CommonFunctions.checkBoxSelect("premise_CheckBox");
			CommonWebActions.waitUntil("NewCopperMaxHD_Field");
			CommonWebActions.webClick("NewCopperMaxHD_Field");
			CommonWebActions.webSet("CopperMaxHDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxHD"));
			CommonWebActions.webClick("NewCopperMaxSD_Field");
			CommonWebActions.webSet("CopperMaxSDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxSD"));
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webSet("Search_DropDown", ExcelUtil.getDataFromExcel(testcasename, "PointID"));
			CommonWebActions.wait(500);
			CommonWebActions.webSet("PointFetch_Enter", ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_go");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_right");
			CommonWebActions.waitUntil("BillingAdd");
			// CommonWebActions.webClick("NewBillingAdd");
			// App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Profiles");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("BillingProfile_Tab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("CustomerAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("Dropdown_Tab");
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			} else {
				System.out.println("Alert not present");
			}
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);

			CommonWebActions.webClick("ServiceBundle_Expand");
			// *---------DueDate------------*//
			App_CommonFunctions.NewLineITem(3, "Due", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));

			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));

			extent.flush();
			CommonWebActions.logout();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	@Test(priority=2, enabled=true)
	public void XDSL_change_between_whole_shared_copperline_Part_2() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			// App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			AddEmail("Enter_email");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("ServiceAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "City"));
			CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.webClick("SearchAdd_Button");
			SelectAddress(ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
			// CommonWebActions.webClick("InstallationAdd");
			// App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.webClick("ShippingAdd_New");
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			// CommonWebActions.webClick("premise");
			// App_CommonFunctions.checkBoxSelect("premise_CheckBox");
			CommonWebActions.waitUntil("NewCopperMaxHD_Field");
			CommonWebActions.webClick("NewCopperMaxHD_Field");
			CommonWebActions.webSet("CopperMaxHDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxHD"));
			CommonWebActions.webClick("NewCopperMaxSD_Field");
			CommonWebActions.webSet("CopperMaxSDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxSD"));
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webSet("Search_DropDown", ExcelUtil.getDataFromExcel(testcasename, "PointID"));
			CommonWebActions.wait(500);
			CommonWebActions.webSet("PointFetch_Enter", ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_go");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_right");
			CommonWebActions.wait(500);
			// CommonWebActions.webClick("NewBillingAdd");
			// App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Profiles");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("BillingProfile_Tab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			} else {
				System.out.println("Alert not present");
			}
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);

			CommonWebActions.webClick("ServiceBundle_Expand");
			// *---------DueDate------------*//
			App_CommonFunctions.NewLineITem(3, "Due", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));

			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));

			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + testcasename + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	@Test(priority=3, enabled=true)
	public void XDSL_change_between_whole_shared_copperline_Part_3() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);

			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			AddEmail("Enter_email");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("ServiceAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "City"));
			CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.webClick("SearchAdd_Button");
			SelectAddress(ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
			// CommonWebActions.webClick("InstallationAdd");
			// App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.webClick("ShippingAdd_New");
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			// CommonWebActions.webClick("premise");
			// App_CommonFunctions.checkBoxSelect("premise_CheckBox");
			CommonWebActions.waitUntil("NewCopperMaxHD_Field");
			CommonWebActions.webClick("NewCopperMaxHD_Field");
			CommonWebActions.webSet("CopperMaxHDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxHD"));
			CommonWebActions.webClick("NewCopperMaxSD_Field");
			CommonWebActions.webSet("CopperMaxSDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperMaxSD"));
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Search_DropDown", ExcelUtil.getDataFromExcel(testcasename, "PointID"));
			CommonWebActions.wait(500);
			CommonWebActions.webSet("PointFetch_Enter", ExcelUtil.getDataFromExcel(testcasename, "PointId"));
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_go");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Push_right");
			CommonWebActions.wait(500);
			// CommonWebActions.webClick("NewBillingAdd");
			// App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Profiles");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("BillingProfile_Tab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.savePage();
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			} else {
				System.out.println("Alert not present");
			}
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",
					ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);

			CommonWebActions.javaclick("PSTN_num4");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("PSTN_num1", ExcelUtil.getDataFromExcel(testcasename, "PSTNnum"));
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("ServiceBundle_Expand");
			// *---------DueDate------------*//
			App_CommonFunctions.NewLineITem(3, "Due", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));

			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));

			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	public boolean AddEmail(String xpath) throws Exception {
		try {
			By find = CommonWebActions.getWebElement1(xpath);
			String email = CommonWebActions.wd.findElement(find).getText();
			if (email.equals(null)) {
				CommonWebActions.javaSet(xpath,Packagename + "." + Packagename + "ekz@live.se");
				return true;
			} else {
				System.out.println(email);
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Some Exception is thrown");
			return false;
		}
	}
	public void SelectAddress(String PointID) throws Exception {
		CommonWebActions.waitForLoad1();
		WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title="+PointID+"]"));
		Input_Data.click();
		CommonWebActions.wait(1000);
	}
	
	@AfterClass
	public static void teardown() throws Exception {
		extent.flush();
//		CommonWebActions.logout();
//		CommonWebActions.wd.quit();
	}

}
