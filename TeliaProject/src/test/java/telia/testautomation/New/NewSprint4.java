package telia.testautomation.New;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
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


//@Listeners({ coreFramework.CoreListener.class })
public class NewSprint4 extends ExtentManager {
	
	private static final String SomeElementNotFound = null;
	String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	@BeforeSuite
	public void init() throws Exception {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName", Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

@Test(priority=1, enabled=true)	
	public void TC_001_xDSL_New_BroadbandandVOIP_VDSL() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("testcase:" + testcasename);
		try {
			CommonWebActions.login();
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
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
			App_CommonFunctions.addressnCopperAdd();
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar",
					ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("OrderHeaderDue"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 20);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.waitUntil("OrderHeaderDue");
			CommonWebActions.waitForLoad1();
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.webClick("OrderNo");
			CommonWebActions.savePage();
			CommonWebActions.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.closeAlerts();
			}
			CommonWebActions.wait(500);
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.waitUntil("Number_Lineitems");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(3, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("VoiPMinusChevron");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(4, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(4, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Device_typeClicks");
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("MilestonChevron");
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = inputFormat.parse(App_CommonFunctions.orderNoFetch("HedrDue"));
			Calendar c2 = Calendar.getInstance();
			cl.setTime(d1);
			cl.add(Calendar.DATE, 8);// adds 8days
			String newtime1 = inputFormat.format(cl.getTime());
			System.out.println(newtime1);
			App_CommonFunctions.NewLineITem(3, "Due", newtime1);
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			test.log(Status.PASS, "Create BB and VOIP Add VDSL  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			CommonWebActions.logout();

		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "TestCase_Status", "FAIL");
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


@Test(priority=2, enabled=true)	
	public void TC_002_xDSL_New_Broadband_IPTV_VoIP_ADSL() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
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
			App_CommonFunctions.addressnCopperAdd();
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar",
					ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(1000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("OrderHeaderDue"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 20);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.waitUntil("OrderHeaderDue");
			CommonWebActions.waitForLoad1();
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.webClick("OrderNo");
			CommonWebActions.savePage();
			CommonWebActions.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.closeAlerts();
			}
			CommonWebActions.wait(500);
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.waitUntil("Number_Lineitems");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
			// boolean alertpresent=CommonWebActions.isAlertPresent();
			// if(alertpresent){
			// CommonWebActions.wd.switchTo().alert();
			// CommonWebActions.wd.switchTo().alert().accept();
			// }
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(3, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("VoiPMinusChevron");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(4, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			// if(alertpresent){
			// CommonWebActions.wd.switchTo().alert();
			// CommonWebActions.wd.switchTo().alert().accept();
			// }
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(4, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Device_typeClicks");
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(5, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(8, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(8, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("MilestonChevron");
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = inputFormat1.parse(App_CommonFunctions.orderNoFetch("HedrDue"));
			Calendar c2 = Calendar.getInstance();
			c2.setTime(d1);
			c2.add(Calendar.DATE, 8);// adds 8days
			String newtime1 = inputFormat.format(c2.getTime());
			System.out.println(newtime1);
			App_CommonFunctions.NewLineITem(3, "Due", newtime1);
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek2");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Create BB and VOIP Add ADSL  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
		}

	}

@Test(priority=3, enabled=true)
	public void TC_003_xDSL_New_Broadband_IPTV_VoIP_VDSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
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
			CommonWebActions.wait(2000);
			App_CommonFunctions.addressnCopperAdd();
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar",
					ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			// CommonWebActions.webClick("AcctSummryTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(1000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("OrderHeaderDue"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 20);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.waitUntil("OrderHeaderDue");
			CommonWebActions.waitForLoad1();
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.webClick("OrderNo");
			CommonWebActions.savePage();
			CommonWebActions.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.closeAlerts();
			}
			CommonWebActions.wait(500);
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.waitUntil("Number_Lineitems");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(3, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("VoiPMinusChevron");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(4, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(4, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Device_typeClicks");
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(5, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(8, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(8, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("MilestonChevron");
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = inputFormat1.parse(App_CommonFunctions.orderNoFetch("HedrDue"));
			Calendar c2 = Calendar.getInstance();
			c2.setTime(d1);
			c2.add(Calendar.DATE, 8);// adds 8days
			String newtime1 = inputFormat.format(c2.getTime());
			System.out.println(newtime1);
			App_CommonFunctions.NewLineITem(3, "Due", newtime1);
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek2");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			test.log(Status.PASS, "Create BB and VOIP Add ADSL  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Script_Status", "PASS");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921,testcasename, "Fail");
			
		}
	}
	



@Test(priority=4, enabled=true)
	public void TC_004_MDU_New_VoIP() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);
		try {
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.wait(1500);
			App_CommonFunctions.emailAddifNot();
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));			
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(5000);
			CommonWebActions.fnHighlightMe("AccountHierarchyTab");
			// CommonWebActions.waitUntilLoaded("AccountHierarchyTab",10);
			// CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar",
					ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
			// CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("OrderHeaderDue"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 20);// adds 20 minutes
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.waitUntil("OrderHeaderDue");
			CommonWebActions.waitForLoad1();
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.webClick("OrderNo");
			CommonWebActions.savePage();
			CommonWebActions.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.closeAlerts();
			}
			CommonWebActions.wait(500);
			CommonWebActions.webSet("OrderHeaderDue", newtime);
			CommonWebActions.waitUntil("Number_Lineitems");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(2, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Device_typeSinClick");
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.wait(650);
			CommonWebActions.webClick("AcssTyp300Chk");		
			
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Create VoIP  [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID")
					+ " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
		}
	}


	public void TC_005_MDU_New_Broadband_Upgraded() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:" + testcasename);

		try {
//			CommonWebActions.webClick("Homebtn");
			 CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
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
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar",
					ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AcctSummryTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("LineItemPlus");
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Delivery Contract #",
					ExcelUtil.getDataFromExcel(testcasename, "Delivery_Contract"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("MilestonChevron");
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("HedrDue"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE, 8);// adds 8days
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			App_CommonFunctions.NewLineITem(3, "Due", newtime);
			CommonWebActions.savePage();
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			test.log(Status.PASS, "Create BB Add VDSL  [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID")
					+ " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
		}
	}
	
	@Test(priority=5, enabled=true)
	public void TC_006_MDU_New_IpTV_Upgraded() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		
		try  {
//			CommonWebActions.webClick("Homebtn");
	        CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");				
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			App_CommonFunctions.emailAddifNot();
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("SalesAddressRemove");
			CommonWebActions.waitUntil("SalesAdresAdd");
			CommonWebActions.webClick("SalesAdresAdd");
			CommonWebActions.waitUntil("SalesAdresCheckDiv");
			CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "Adres_StreetName"));
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));		
			CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
			CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "Adres_City"));
			CommonWebActions.webSet("InstallType", ExcelUtil.getDataFromExcel(testcasename, "Adres_Type"));
			CommonWebActions.webClick("SalesAdresCheckDiv");
			CommonWebActions.waitUntil("AddressSearchOkBtn");
			CommonWebActions.webClick("AddressSearchOkBtn");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.fnHighlightMe("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("BillingAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.checknaddEmail("EmailCheckSalesAcct");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			App_CommonFunctions.checkBoxSelect("BillingCheckBox");
			CommonWebActions.webClick("AddressOkBtn");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar", ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if (!CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']")).click();
			} else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");			
			CommonWebActions.waitUntil("AccountHierarchyTab");				
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("LineItemPlus");
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			boolean alertpresent=CommonWebActions.isAlertPresent();
			if(alertpresent){
				CommonWebActions.wd.switchTo().alert(); 
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(3, "Delivery Contract #", ExcelUtil.getDataFromExcel(testcasename, "DeliveryContract"));
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("AcssTyp300Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
//			CommonWebActions.webClick("CustmzeBtn");
//			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.javaclick("DoneBtn1");			
			CommonWebActions.webClick("SubmitBtn");			
			CommonWebActions.waitUntil("SubmitBtn");		
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "New MDU IpTV ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			CommonWebActions.logout();
		}
		catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
//			e.printStackTrace();
//			e.getMessage();
		}
	}
	
	
	


@AfterClass
public static void teardown() throws Exception {
	extent.flush();
	CommonWebActions.logout();
	CommonWebActions.wd.quit();
}

}
