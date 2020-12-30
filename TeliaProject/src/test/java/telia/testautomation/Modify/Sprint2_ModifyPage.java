package telia.testautomation.Modify;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

public class Sprint2_ModifyPage extends ExtentManager {
	
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
		//	Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName", Packagename);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
/**
 * @TestcaseName:TC_003_modify
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
 @Test(priority = 1,enabled=true)
	public void TC_003_modify() throws Exception {
		try {
			/*--  Reporting Initiation  --*/
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 120000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.javaclick("Continue_Link");
			CommonWebActions.waitUntil("bund_Link");
			CommonWebActions.javaclick("bund_Link");
			CommonWebActions.wait(2000);
			System.out.println("The test case value:" + ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("Goo_Link");
			CommonWebActions.webClick("Goo_Link");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.waituntilElementToBeClickable("Package_Link");
			CommonWebActions.webClick("Package_Link");
			CommonWebActions.waitUntil("Check_box");
			CommonWebActions.javaclick("Check_box");
			CommonWebActions.waitUntil("Check_box2");
			CommonWebActions.javaclick("Check_box2");
			CommonWebActions.waitUntil("Additional_Pkg");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.waitUntil("Hbo_box");
			CommonWebActions.webClick("Hbo_box");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.waitUntil("Reason_Code");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("Accept_Email");
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(3000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.waitUntil("Submit_btn");
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(1000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}  	

/**
 * @TestcaseName:TC_004_Disconnect_pkg
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
	@Test(priority = 2,enabled=true)
	public void TC_004_Disconnect_pkg() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 4000);
						/*--  Launching URL  --*/
			//CommonWebActions.login();
//			Launching URL  --*/
//			CommonWebActions.login();
//			CommonWebActions.waitUntilLoaded("MyOrder_link",25000);
			CommonWebActions.waitUntil("Homebtn");
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("Continue_Link");
			String Due_date=CommonWebActions.webGetAttribute("XDSLModDate", "value");
			if (Due_date.isEmpty()){
				test.log(Status.FAIL,"Due Date is empty");
				throw new AssertionError( "Due Date is empty");
			}
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.waitUntil("bund_Link");
			CommonWebActions.webClick("bund_Link");
			System.out.println("The test case value:" + ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("Goo_Link");
			CommonWebActions.webClick("Goo_Link");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");
			CommonWebActions.waitUntil("Check_box");
			CommonWebActions.webClick("Check_box");
			CommonWebActions.webClick("Check_box2");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.webClick("Hbo_box");
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.waituntilElementToBeClickable("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.webClick("Accept_Email");
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("Submit_btn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * @TestcaseName:TC_005_agreementOn_existingVoIP
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 
	@Test(priority = 3,enabled=true)
	public void TC_005_agreementOn_existingVoIP() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 4000);
			//			CommonWebActions.login();
//			CommonWebActions.waitUntilLoaded("MyOrder_link",25000);
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.waitUntil("Maxi_Link");
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("Go_Link");
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.waitUntil("XDSLModDate");
			String Due_date=CommonWebActions.webGetAttribute("XDSLModDate", "value");
			if (Due_date.isEmpty()){
				test.log(Status.FAIL,"Due Date is empty");
				throw new AssertionError( "Due Date is empty");
			}
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.waitUntil("Service_Record");
			CommonWebActions.javaclick("Service_Record");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.fnHighlightMe("Qty_Editbox");
			CommonWebActions.javaclick("Claer_value");
			CommonWebActions.webSet("Claer_value", "0");
			Thread.sleep(2000);
			CommonWebActions.javaclick("Add_Items");
			CommonWebActions.wait(3000);
			
			CommonWebActions.Selectvaluefromdropdown("Subscription_Alternative",
					ExcelUtil.getDataFromExcel(testcasename, "SubscriptionAlternative"));
			CommonWebActions.javaSet("Claer_value1", "1");
			CommonWebActions.webClick("Add_Items");
//			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Done_btn");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(5000);
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 15);
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
//			CommonWebActions.waituntil("Expand_bund");
			CommonWebActions.webClick("Expand_bund");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Expand_bund1");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Service_Record");
			CommonWebActions.wait(3000);
			CommonWebActions.wd.findElement(By.xpath("//input[@name='TS_Service_Account_Point_Id']"))
					.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Expand_edit");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Click_edit");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Change_Record");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Field_Due", ExcelUtil.getDataFromExcel(testcasename, "FieldDue"));
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Due_value", newtime);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Value_Ok");
			CommonWebActions.wait(3000);
//=============	
			CommonWebActions.webSet("Due_value1", newtime);
			CommonWebActions.wait(3000);
//============		
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(3000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * @TestcaseName:TC_006_changenumber_existingVoIP
 * @Description: 
 * @Complexity:High
 * @author :Mohan
 * @ALM :
 * 
 */ 		
	@Test(priority = 4,enabled=true)
	public void TC_006_changenumber_existingVoIP() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			// CommonWebActions.login();
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 120000);
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Active_Link");
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("Go_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.wait(3000);
			String Due_date = CommonWebActions.webGetAttribute("XDSLModDate", "value");
			if (Due_date.isEmpty()) {
				test.log(Status.FAIL, "Due Date is empty");
				throw new AssertionError("Due Date is empty");
			}
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Service_Record1");
			CommonWebActions.wait(3000);

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.MINUTE, 25);
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.webClick("Expand_bundnewSSn");
			CommonWebActions.wait(3000);
			/*
			 * CommonWebActions.webClick("Expand_bund1");
			 * CommonWebActions.wait(3000);
			 */
			CommonWebActions.webClick("Service_Record1");
			CommonWebActions.wait(3000);
			CommonWebActions.wd.findElement(By.xpath("(//td[@title='115323468'])[2]"))
					.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Expand_edit");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Click_edit");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Change_Record");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Field_Due", ExcelUtil.getDataFromExcel(testcasename, "FieldDue"));
			CommonWebActions.wait(3000);
			System.out.println(newtime);
			CommonWebActions.webSet("Due_value", newtime);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Value_Ok");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Due_value1", newtime);
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Service_Record1");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Number_Lineitems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Number_arrow");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Book_tab");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Customize_Link1");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("ChangeOf_Number",
					ExcelUtil.getDataFromExcel(testcasename, "ChangeOfNumber"));
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("Change_Num", "1");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(8000);
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(3000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
//			CommonWebActions.wait(10000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
//			CommonWebActions.wait(3000);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()));
			CommonWebActions.closeAlerts();
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


