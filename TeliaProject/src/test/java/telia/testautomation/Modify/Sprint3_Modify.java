package telia.testautomation.Modify;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
public class Sprint3_Modify extends ExtentManager {
	public static String url = "";
	private static String hostName;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];
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
		CommonWebActions.login();
	}
	

/**
 * @TestcaseName:TC_01_modifySDU_ChangeSpeed
 * @Description:
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */

	@Test(priority = 1, enabled = true)
	public void TC_01_modifySDU_ChangeSpeed() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			/*--  Launching URL  --*/
//			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
//			CommonWebActions.wait(2000);
			CommonWebActions.webSet("ProductType_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("QuerySrchSpec_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Product_GO_Button");
			CommonWebActions.webClick("Product_GO_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Click_SreviceBundel");
			CommonWebActions.webClick("Click_SreviceBundel");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(5000);
			CommonWebActions.waitUntil("ChangeSpeed_ServiceRecord");
			CommonWebActions.javaclick("ChangeSpeed_ServiceRecord");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.scrollIntoWebElement1("Speed_Editbox");
			String text = CommonWebActions.wd
					.findElement(
							By.xpath("(//input[@class='siebui-ctrl-input siebui-ecfg-editfield']//following::a)[1]"))
					.getText();
			CommonWebActions.fnHighlightMe("Speed_Editbox");
			CommonWebActions.javaclick("Speed_Editbox");
			CommonWebActions.webSet("Speed_Editbox", "0");
			Thread.sleep(2000);
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(2000);
			if (text.equals(ExcelUtil.getDataFromExcel(testcasename, "Promotion2"))) {
				CommonWebActions.Selectvaluefromdropdown("Promotion_2",
						ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			}
			else {

				CommonWebActions.Selectvaluefromdropdown("Promotion_2",
						ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			}
			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.waitUntil("Speed_AddItems");
			CommonWebActions.javaclick("Speed_AddItems");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");

			// ============
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
		}
	}

	

	@Test(priority = 2, enabled = true)
	public void TC_03_HandleNumberChange_ofpstnBB() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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
			/*--  Launching URL  --*/
//			CommonWebActions.login();
			CommonWebActions.waitUntil("Homebtn");
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			// CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("ProductType_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("QuerySrchSpec_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.waitUntil("Product_GO_Button");
			CommonWebActions.webClick("Product_GO_Button");
			CommonWebActions.waitUntil("ChangePSTN_SreviceBunde");
			CommonWebActions.webClick("ChangePSTN_SreviceBunde");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(3000);
			App_CommonFunctions.NewLineITem(1, "PSTN Number", ExcelUtil.getDataFromExcel(testcasename, "PSTNnum"));
			CommonWebActions.savePage();
			CommonWebActions.scrollIntoWebElement("oldPSTN_num");
			CommonWebActions.javaclick("oldPSTN_num");
			String oldPSTN = App_CommonFunctions.orderNoFetch("oldPSTNIp");
			System.out.println(oldPSTN);
			CommonWebActions.wait(2000);
			Assert.assertFalse(ExcelUtil.getDataFromExcel(testcasename, "PSTNnum").equals(oldPSTN));
			ExcelUtil.setDatatoExcel(Packagename,testcasename,"PSTNnum", ExcelUtil.getDataFromExcel(testcasename, "PSTNnum"));
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(6000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
//			CommonWebActions.wait(10000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Not Completed");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled = true)
	public void TC_004_Downgrade_Same_address_shared_line() throws Exception {

		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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
			/*--  Launching URL  --*/
//			CommonWebActions.login();
			CommonWebActions.waitUntil("Homebtn");
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
//			CommonWebActions.scrollIntoWebElement("SalesAddressApplet");
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("SalesAddressApplet");
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
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
			App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
			App_CommonFunctions.checkBoxSelect("PremiseCheckbox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("CopperMaxHD");
			CommonWebActions.webSet("CopperMaxHDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperHDMax"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("CopperMaxSD");
			CommonWebActions.webSet("CopperMaxSDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperSDMax"));
			CommonWebActions.wait(500);
			CommonWebActions.webClick("PointIDClick");
			String pointFetch = App_CommonFunctions.orderNoFetch("point_Fetch");
			System.out.println(pointFetch);
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");
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
			CommonWebActions.webClick("ShippingAddress");
			App_CommonFunctions.checkBoxSelect("Shipping_address");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("bill_dropdown", "Profiles");
			CommonWebActions.waitUntil("BillProfileBtn");
			CommonWebActions.javaclick("BillProfileBtn");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.waitUntil("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			// CommonWebActions.savePage();
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("PSTN_num4");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("PSTN_num1", "46346770070");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Telia Bredband Start 30 ADSL");
			CommonWebActions.wait(500);
			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Submit_btn");
			CommonWebActions.webClick("Submit_btn");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			extent.flush();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	@Test(priority = 4, enabled = true)
	public void TC_005_DSL_PSTN_DOWN() throws Exception {

		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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
			/*--  Launching URL  --*/
//			CommonWebActions.login();
			CommonWebActions.waitUntil("Homebtn");
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.waitUntil("SalesAddressApplet");
//			CommonWebActions.scrollIntoWebElement("SalesAddressApplet");
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("SalesAddressApplet");
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
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
			App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
			App_CommonFunctions.checkBoxSelect("PremiseCheckbox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("CopperMaxHD");
			CommonWebActions.webSet("CopperMaxHDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperHDMax"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("CopperMaxSD");
			CommonWebActions.webSet("CopperMaxSDIp", ExcelUtil.getDataFromExcel(testcasename, "CopperSDMax"));
			CommonWebActions.wait(500);
			CommonWebActions.webClick("PointIDClick");
			String pointFetch = App_CommonFunctions.orderNoFetch("point_Fetch");
			System.out.println(pointFetch);
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
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
			CommonWebActions.webClick("ShippingAddress");
			App_CommonFunctions.checkBoxSelect("Shipping_address");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.wait(500);
			CommonWebActions.Selectvaluefromdropdown("bill_dropdown", "Profiles");
			CommonWebActions.waitUntil("BillProfileBtn");
			CommonWebActions.javaclick("BillProfileBtn");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			CommonWebActions.waitUntil("AccountHierarchyTab");
//			CommonWebActions.webClick("AcctSummryTab");
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.waitUntil("CreditCheck_Button");
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			// CommonWebActions.savePage();
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("PSTN_num4");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("PSTN_num1", "46346770070");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("producr_dropdown", "Telia Bredband Start 30 ADSL");
			CommonWebActions.wait(500);
			CommonWebActions.javaSet("Add_QTY", "1");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Submit_btn");
			CommonWebActions.webClick("Submit_btn");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			extent.flush();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
		} catch (Exception e) {
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	@AfterClass
	public void logOut() throws Exception {
		extent.flush();
		CommonWebActions.logout();
		 CommonWebActions.wd.quit();
		// CommonWebActions.wd.quit();
	}

//	@AfterSuite
//	public void tearDown() throws Exception {
//		extent.flush();
//		CommonWebActions.logout();
//		 CommonWebActions.wd.quit();
//	}

}



	
	

