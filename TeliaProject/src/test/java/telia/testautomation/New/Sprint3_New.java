package telia.testautomation.New;

import java.io.IOException;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

public class Sprint3_New extends ExtentManager {
	
	private static final String SomeElementNotFound = null;
	String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	@BeforeSuite
	public void init() throws Exception {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName", Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
	
//	@BeforeClass
//	public void beforetest() throws Exception {
//		CommonWebActions.login();
//	}
	
	/**
	 * @TestcaseName:TC_001_xDSL_New_Broadband_ADSL
	 * @Description: Create a new XDSL BB order
	 * @Complexity:High
	 * @author :Satya
	 * @ALM :
	 * 
	 */ 

	
	@Test(priority=1, enabled=true)
	public void TC_001_xDSL_New_Broadband_ADSL() throws Exception  {
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try  {
            CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 120000);
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.SearchServiceAccount( ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
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
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar", ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
			if(!CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement( By.xpath("//a[text()='Account Summary']")).click();		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
//			CommonWebActions.waitUntil("AccountHierarchyTab");
//			WebElement webElem = CommonWebActions.wd.findElement(By.xpath("//a[text()='Account Summary']"));
			CommonWebActions.waitUntil("AccountHierarchyTab");			
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("LineItemPlus");
//			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			boolean alertpresent=CommonWebActions.isAlertPresent();
			if(alertpresent){
				CommonWebActions.wd.switchTo().alert(); 
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");			
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
			Date d = new Date();
//            Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("BrdbandDate"));
            Calendar cl = Calendar.getInstance();
            cl.setTime(d);
            cl.add(Calendar.DATE,8);//adds 8days
            String newtime = inputFormat.format(cl.getTime());
            System.out.println(newtime);           
            App_CommonFunctions.DueDate_LineItem(3,newtime);			
			CommonWebActions.waitUntil("SubmitBtn");	
			CommonWebActions.webClick("SubmitBtn");

			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
			test.log(Status.PASS, "Create BB Add ADSL  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		}
		catch (Exception e) {

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
		
			e.getMessage();
		}
	}	
	
	@Test(priority=2, enabled=true)
	public void TC_002_xDSL_New_Broadband_VDSL() throws Exception  {
			
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:"+testcasename);
			try  {
				CommonWebActions.login();
//				CommonWebActions.webClick("Homebtn");
//	            
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
				CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar", ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
				CommonWebActions.waitUntil("AccountHierarchyTab");
				CommonWebActions.javaclick("BillProfileBtn");
				CommonWebActions.waitUntil("AccountHierarchyTab");
				App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
				CommonWebActions.webClick("AccountHierarchyTab");
				CommonWebActions.waitUntil("AccountHierarchyTab");
				CommonWebActions.webClick("CustomerAcct");
				CommonWebActions.wait(1000);
//				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
				CommonWebActions.waitUntil("AccountHierarchyTab");
				if(!CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).isEmpty()) {
					CommonWebActions.wd.findElement( By.xpath("//a[text()='Account Summary']")).click();		
				}else {
					CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
				}
//				CommonWebActions.webClick("AcctSummryTab");			
				CommonWebActions.waitUntil("AccountHierarchyTab");				
				CommonWebActions.webClick("LineItemAddBtn");
				CommonWebActions.waitUntil("LineItemPlus");
				App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
				App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
				CommonWebActions.waitForLoad1();
				CommonWebActions.wait(2000);
				CommonWebActions.webClick("Plus_button");
				CommonWebActions.wait(2000);
				App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
				CommonWebActions.wait(2000);
				CommonWebActions.waitUntil("LineItemPlus");
				boolean alertpresent=CommonWebActions.isAlertPresent();
				if(alertpresent){
					CommonWebActions.wd.switchTo().alert(); 
					CommonWebActions.wd.switchTo().alert().accept();
				}
				CommonWebActions.waitUntil("LineItemPlus");
				App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
				CommonWebActions.wait(1000);
				CommonWebActions.waitUntil("LineItemPlus");
				App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
				CommonWebActions.wait(1000);
				CommonWebActions.waitUntil("LineItemPlus");				
				CommonWebActions.webClick("CustmzeBtn");
				CommonWebActions.waitUntil("DoneBtn1");
				CommonWebActions.wait(2000);
				CommonWebActions.waitForLoad1();
				CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
						ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
				CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
				CommonWebActions.javaclick("AddItemBtn2");
				CommonWebActions.waitUntil("DoneBtn1");
				CommonWebActions.webClick("DoneBtn1");
				CommonWebActions.waitUntil("LineItemPlus");
				CommonWebActions.webClick("MilestonChevron");
				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
	            Calendar cl = Calendar.getInstance();
	            cl.setTime(d);
	            cl.add(Calendar.DATE,8);//adds 8days
	            String newtime = inputFormat.format(cl.getTime());
	            System.out.println(newtime);
	            App_CommonFunctions.NewLineITem(3, "Due", newtime);
				CommonWebActions.savePage();
				CommonWebActions.waitForLoad1();
				CommonWebActions.waitUntil("SubmitBtn");
				CommonWebActions.webClick("SubmitBtn");				
				App_CommonFunctions.refreshComplete("StatusFld",
						ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
				App_CommonFunctions.orderNoFetch("OrderNo");
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
						App_CommonFunctions.orderNoFetch("OrderNo"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
						App_CommonFunctions.orderNoFetch("DueDate"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
				test.log(Status.PASS, "Create BB Add VDSL  ["
						+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
				extent.flush();
				CommonWebActions.logout();
				ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
				}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
				System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
				}.getClass().getEnclosingMethod().getName()), "Not Completed");
				

			}
			catch (Exception e) {

				CommonWebActions.closeAlerts();
				test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
				}.getClass().getEnclosingMethod().getName()) + ":"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
				}.getClass().getEnclosingMethod().getName()), "Fail");
				e.printStackTrace();
				ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
				}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
				e.getMessage();
			}	
		
	}
	
	@Test(priority=3, enabled=true)
	public void TC_003_xDSL_New_BroadbandandVOIP_ADSL() throws Exception  {
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try  {
			CommonWebActions.login();
//			CommonWebActions.webClick("Homebtn");
//			CommonWebActions.login();
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
			CommonWebActions.Selectvaluefromdropdown("ThirdLevelBar", ExcelUtil.getDataFromExcel(testcasename, "BillingProfileDrpdown"));
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.javaclick("BillProfileBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.imageCheck("BillImage", "BillStatusRefresh");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if(!CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement( By.xpath("//a[text()='Account Summary']")).click();		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");			
			CommonWebActions.waitUntil("AccountHierarchyTab");				
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.wait(1000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("OrderHeaderDue"));
    		Calendar cl = Calendar.getInstance();
    		cl.setTime(d);
    		cl.add(Calendar.MINUTE,20);//adds 20 minutes
    		String newtime = inputFormat.format(cl.getTime());
    		System.out.println(newtime);
    		CommonWebActions.waitUntil("OrderHeaderDue");
    		CommonWebActions.waitForLoad1();
    		CommonWebActions.webSet("OrderHeaderDue", newtime);
    		CommonWebActions.webClick("OrderNo");
    		CommonWebActions.savePage();
    		CommonWebActions.wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		boolean alertpresent=CommonWebActions.isAlertPresent();
    		if (alertpresent){
    			CommonWebActions.closeAlerts();
    		}
    		CommonWebActions.wait(500);
    		CommonWebActions.webSet("OrderHeaderDue", newtime);
    		CommonWebActions.waitUntil("Number_Lineitems");
//    		App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(1,"Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(2000);
//			boolean alertpresent=CommonWebActions.isAlertPresent();
//			if(alertpresent){
//				CommonWebActions.wd.switchTo().alert(); 
//				CommonWebActions.wd.switchTo().alert().accept();
//			}
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));			
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("LineItemPlus");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(3, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("VoiPMinusChevron");
			CommonWebActions.wait(650);
			App_CommonFunctions.NewLineITem(4, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));			
//			if(alertpresent){
//				CommonWebActions.wd.switchTo().alert(); 
//				CommonWebActions.wd.switchTo().alert().accept();
//			}
			CommonWebActions.waitUntil("LineItemPlus");			
			App_CommonFunctions.NewLineITem(4, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));			
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.wait(500);
			CommonWebActions.webClick("Device_typeClicks");
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
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
			Date d1 = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar c2 = Calendar.getInstance();
			cl.setTime(d1);
			cl.add(Calendar.DATE,8);//adds 8days
			String newtime1 = inputFormat.format(cl.getTime());
			System.out.println(newtime1);
			App_CommonFunctions.NewLineITem(3, "Due", newtime1);
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("AcssTyp100Chek3");			
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");			
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
			test.log(Status.PASS, "Create BB and VOIP Add ADSL  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");

		}
		catch (Exception e) {

			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			e.getMessage();
		}	

	}
	
	@Test(priority=4, enabled=true)
	public  void TC_004_xDSL_New_VoIP() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);	
		try {
			
			CommonWebActions.login();
//			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");				
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("CopperMaxHD");
    		CommonWebActions.webSet("CopperMaxHDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("CopperMaxSD");
    		CommonWebActions.webSet("CopperMaxSDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("AddressOkBtn");
    		CommonWebActions.waitUntil("ContactsBtn");
    		CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if(!CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement( By.xpath("//a[text()='Account Summary']")).click();		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");			
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
    		cl.add(Calendar.MINUTE,20);//adds 8days
    		String newtime = inputFormat.format(cl.getTime());
    		System.out.println(newtime);
    		CommonWebActions.waitUntil("OrderHeaderDue");
    		CommonWebActions.waitForLoad1();
    		CommonWebActions.webSet("OrderHeaderDue", newtime);
    		CommonWebActions.webClick("OrderNo");
    		CommonWebActions.savePage();
    		CommonWebActions.wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		boolean alertpresent=CommonWebActions.isAlertPresent();
    		if (alertpresent){
    			CommonWebActions.closeAlerts();
    		}
    		CommonWebActions.wait(500);
    		CommonWebActions.webSet("OrderHeaderDue", newtime);
    		CommonWebActions.waitUntil("Number_Lineitems");
//    		CommonWebActions.waitUntil("Number_Lineitems");
//    		CommonWebActions.webClick("Number_Lineitems");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("LineItemPlus");			
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");
			CommonWebActions.webClick("Device_typeSinClick");			
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.savePage();
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			App_CommonFunctions.voipphoneBook();
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Create VoIP  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
			
		}
		catch (Exception e) {

			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test(priority=5, enabled=true)
	public  void TC_005_xDSL_New_IPTV() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);	
		try {
			CommonWebActions.login();
//			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");				
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.waitUntil("ContactsBtn");
			CommonWebActions.webClick("SalesAddressApplet");
			CommonWebActions.waitUntil("SalesAddressAfterDiv");
			CommonWebActions.webClick("CopperMaxHD");
    		CommonWebActions.webSet("CopperMaxHDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("CopperMaxSD");
    		CommonWebActions.webSet("CopperMaxSDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("AddressOkBtn");
    		CommonWebActions.waitUntil("ContactsBtn");
    		CommonWebActions.webClick("AccountHierarchyTab");
			CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.webClick("CustomerAcct");
			CommonWebActions.wait(1000);
//			CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			if(!CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).isEmpty()) {
				CommonWebActions.wd.findElement( By.xpath("//a[text()='Account Summary']")).click();		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");			
			CommonWebActions.waitUntil("AccountHierarchyTab");
			CommonWebActions.webClick("LineItemAddBtn");
			CommonWebActions.waitUntil("LineItemPlus");
			App_CommonFunctions.creditCheck("CreditCheckButn", "ScoringReason");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("LineItemPlus");	
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("LineItemPlus");			
			App_CommonFunctions.NewLineITem(3, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");			
			App_CommonFunctions.NewLineITem(3, "Connectivity Reference Number", ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("LineItemPlus");				
			CommonWebActions.webClick("AcssTyp100Chk");								
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("SubmitBtn");				
			CommonWebActions.webClick("SubmitBtn");
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Create IPTv  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "PASS");
			CommonWebActions.logout();
		}
		catch (Exception e) {
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			e.printStackTrace();
		
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 6, enabled=true)
	public void TC_02_addvoipOn_xdslHoleLine() throws Exception {
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
			CommonWebActions.login();
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntil("MyOrder_link");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
            CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.wait(2000);
			// ====Time Change
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 15);
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.webSet("Due_value", newtime);
			CommonWebActions.wait(3000);
			// ===========
			CommonWebActions.webClick("NewLine_Button");
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
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number",
					ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Device_typeClick");
			CommonWebActions.wait(1000);
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Number_Lineitems");
			CommonWebActions.wait(3000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.webClick("Number_arrow");
			CommonWebActions.wait(3000);
			CommonWebActions.waitForLoad1();
			// =============Book PH Number
			List<WebElement> Phonenos = CommonWebActions.getWebElements("Phonelist");
			Biglabel: if (Phonenos.size() > 0) {
				System.out.println("Phone number LIST is DISPLAYED and hence booking one");
				label: for (int i = 0; i <= Phonenos.size() - 1;) {
					WebElement Number = Phonenos.get(i);
					CommonWebActions.wait(2000);
					JavascriptExecutor executor = (JavascriptExecutor) CommonWebActions.wd;
					executor.executeScript("arguments[0].click();", Number);
					// Number.click();
					CommonWebActions.wait(2000);
					CommonWebActions.webClick("Book_tab");
					CommonWebActions.wait(2000);
					CommonWebActions.wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					boolean alertpresent1 = CommonWebActions.isAlertPresent();
					if (alertpresent1) {
						System.out.println("Alert  present");
						CommonWebActions.closeAlerts();
						CommonWebActions.waitForLoad1();
						CommonWebActions.waitUntil("Book_tab");
						i++;
						continue label;
					} else {
						break Biglabel;
					}
				}

			} else {
				System.out.println("PHONE NUMBER LIST IS NOT DISPLAYED");
			}
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.waitUntil("Submit_btn");
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
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", App_CommonFunctions.orderNoFetch("Order_Status"));
			CommonWebActions.logout();
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
	

	@AfterClass
	public static void teardown() throws Exception {
//		CommonWebActions.logout();
		CommonWebActions.wd.quit();
//		CommonWebActions.logout();
//	extent.flush();
//	CommonWebActions.wd.quit();
	}
	
}
