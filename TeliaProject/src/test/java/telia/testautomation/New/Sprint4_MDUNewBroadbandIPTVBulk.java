package telia.testautomation.New;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import com4j.COM4J;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @author kaviag
 *
 */

@Listeners({ coreFramework.CoreListener.class })
public class Sprint4_MDUNewBroadbandIPTVBulk  extends ExtentManager{
	
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
	 * @TestcaseName:TC_001_MDU_New_Broadband_IPTV_Bulk
	 * @Description: Create a new MDU BB IPTV BULK order
	 * @Complexity:High
	 * @author :Kavia
	 * @ALM :
	 * 
	 */ 

	
	@Test(priority=1, enabled=false)
	public void TC_001_MDU_New_Broadband_IPTV_Bulk() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			AddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("BillingAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("NewBillingAdd");
			App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
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
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(5000);
			CommonWebActions.webImplicitWait(8);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
			// CommonWebActions.webClick("InstallationAdd");
			// CommonWebActions.wait(1000);
			// App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ShippingAdd_New");
			CommonWebActions.wait(1000);
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			CommonWebActions.wait(1000);
			// CommonWebActions.webClick("premise");
			// App_CommonFunctions.checkBoxSelect("premise_CheckBox");
			CommonWebActions.webClick("CareOf");
			CommonWebActions.webSet("CareOf_Input", ExcelUtil.getDataFromExcel(testcasename, "CareOf"));
			CommonWebActions.webClick("AttentionInfo");
			CommonWebActions.webSet("AttentionInfo_Input", ExcelUtil.getDataFromExcel(testcasename, "AttentionInfo"));
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.wait(3000);
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitForLoad1();
			if (CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");
			} else {
				CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");
			}

			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
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
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(3, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			App_CommonFunctions.NewLineITem(7, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.waitUntil("Package_Tab");
			CommonWebActions.webClick("Package_Tab");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Package_Dropdown", "Tv-paket Lagom");
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(6, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.waitUntil("SalesOrder_Submit");
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
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename, "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "TestCase_Status", "Fail");
			CommonWebActions.logout();

		}
	}
	
	/**
	 * @TestcaseName:TC_002_MDU_New_Broadband_IPTV_Bulk_Upgraded
	 * @Description: Create a new MDU BB IPTV BULK order
	 * @Complexity:High
	 * @author :Kavia
	 * @ALM :
	 * 
	 */ 

	
	@Test(priority=2, enabled=false)
	public void TC_002_MDU_New_Broadband_IPTV_Bulk_Upgraded() throws Exception  {
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try  {
            CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");				
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			AddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("NewBillingAdd");
			App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab",  "Profiles");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("BillingProfile_Tab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
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
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(5000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
//			CommonWebActions.webClick("InstallationAdd");
//			CommonWebActions.wait(1000);
//			App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ShippingAdd_New");
			CommonWebActions.wait(1000);
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			CommonWebActions.wait(1000);
//			CommonWebActions.webClick("premise");
//			App_CommonFunctions.checkBoxSelect("premise_CheckBox");		
			CommonWebActions.webClick("CareOf");
			CommonWebActions.webSet("CareOf_Input", ExcelUtil.getDataFromExcel(testcasename, "CareOf"));
			CommonWebActions.webClick("AttentionInfo");
			CommonWebActions.webSet("AttentionInfo_Input", ExcelUtil.getDataFromExcel(testcasename, "AttentionInfo"));
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");			
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitForLoad1();
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");			}
			
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1,"Product", ExcelUtil.getDataFromExcel(testcasename,"Product"));
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2,"Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename,"DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed", ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(3,"Product", ExcelUtil.getDataFromExcel(testcasename,"Product_IPTV"));
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(4,"Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename,"DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
//			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(7,"Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename,"DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.waitUntil("Package_Tab");
			CommonWebActions.webClick("Package_Tab");
			CommonWebActions.waitUntil("Package_Dropdown");
			CommonWebActions.webClick("Package_Dropdown");
			CommonWebActions.webClick("Package");
//			CommonWebActions.Selectvaluefromdropdown("Package_Dropdown", ExcelUtil.getDataFromExcel(testcasename,"Packages"));
			CommonWebActions.javaclick("Done_1A_Speed");
			App_CommonFunctions.NewLineITem(6,"Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename,"DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.waitUntil("SalesOrder_Submit");
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
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "Script_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename , "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output",testcasename , "Script_Status", "Fail");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			CommonWebActions.logout();
		}
	}
	
	/**
	 * @TestcaseName:MDU_New_Broadband_Upgraded
	 * @Description: Create a new MDU BB IPTV BULK order
	 * @Complexity:High
	 * @author :Kavia
	 * @ALM :
	 * 
	 */ 

	
	@Test(priority=3, enabled=true)
	public void MDU_New_Broadband_Upgraded() throws Exception  {
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try  {
            CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");				
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustAcc_Link");
			AddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("LegalAdd");
			CommonWebActions.webClick("LegalAdd");
			App_CommonFunctions.checkBoxSelect("LegalAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
//			CommonWebActions.webClick("NewBillingAdd");
//			App_CommonFunctions.checkBoxSelect("BillingAdd_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab",  "Profiles");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("BillingProfile_Tab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
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
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("SalesAddressApplet");
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.waitUntil("InstallationAdd");
//			CommonWebActions.webClick("InstallationAdd");
//			CommonWebActions.wait(1000);
//			App_CommonFunctions.checkBoxSelect("InstallationAdd_CheckBox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ShippingAdd_New");
			CommonWebActions.wait(1000);
			App_CommonFunctions.checkBoxSelect("ShippingAddress_CheckBox");
			CommonWebActions.wait(1000);
//			CommonWebActions.webClick("premise");
//			App_CommonFunctions.checkBoxSelect("premise_CheckBox");		
			CommonWebActions.webClick("CareOf");
			CommonWebActions.webSet("CareOf_Input", ExcelUtil.getDataFromExcel(testcasename, "CareOf"));
			CommonWebActions.webClick("AttentionInfo");
			CommonWebActions.webSet("AttentionInfo_Input", ExcelUtil.getDataFromExcel(testcasename, "AttentionInfo"));
			CommonWebActions.waitUntil("SearchAddOK_Button");	
			CommonWebActions.webClick("SearchAddOK_Button");			
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitForLoad1();
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");			}
			
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("New_InstallAssets");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1,"Product", ExcelUtil.getDataFromExcel(testcasename,"Product"));
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2,"Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename,"DeliveryContract"));
			CommonWebActions.wait(3000);
			Popup();
//			CommonWebActions.webClick("ActiveContact");
//			CommonWebActions.webClick("ActiveContactOK_Button");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed", ExcelUtil.getDataFromExcel(testcasename, "Speed"));
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_1A_Speed");
			CommonWebActions.wait(3000);
			
			CommonWebActions.waitUntil("SalesOrder_Submit");
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
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
			CommonWebActions.logout();
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			CommonWebActions.logout();
		}
	}
	
	public void Popup()throws Exception{
		
		WebElement popup = CommonWebActions.wd.findElement(By.xpath("//div[@name='popup' and @class ='ui-dialog-content ui-widget-content']"));
		Boolean popupIsPresent = popup.isDisplayed();
		if(popupIsPresent){
			
			CommonWebActions.webClick("ActiveContact");
			CommonWebActions.webClick("ActiveContactOK_Button");
			CommonWebActions.wait(3000);
		}
		else{
			CommonWebActions.waitUntil("Cutomize_Button");
		}
		
	}
	
	public boolean AddEmail(String xpath) throws Exception {
		try {
			By find = CommonWebActions.getWebElement1(xpath);
			String email = CommonWebActions.wd.findElement(find).getText();
			if (email.equals(null)) {
				String Lname = CommonWebActions.wd.findElement(By.xpath("//td[contains(@id, 'Last_Name')]")).getText();
				CommonWebActions.javaSet(xpath, Packagename + "." + Packagename + "ekz@live.se");
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
