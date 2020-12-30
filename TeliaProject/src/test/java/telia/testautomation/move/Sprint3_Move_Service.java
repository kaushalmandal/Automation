package telia.testautomation.move;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;
import coreFramework.TrippleDes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class Sprint3_Move_Service extends ExtentManager{
	private static String hostName;
	static String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	public static final String OBJECT_REPO_PATH_Move = "./src/test/resources/testArtifacts/ObjectRepository_move.properties";
	
	
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
/**
 * @TestcaseName:TC_001_xDSL_Suspend_Abuse_ADSL
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */

@Test(priority = 10, enabled=true)
public void TC_004_Move_xDSL_and_voip_to_a_new_aria() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		login1();
		
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",35000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"),"Business");
		CommonWebActions.wait(3000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();  
       //Date d=inputFormat.parse(orderNoFetch1("Btnlocator"));
        Calendar cl = Calendar. getInstance();
//      
       cl.setTime(date);
      // cl.add(Calendar.MINUTE,25);
       //cl.add(Calendar.MINUTE,-250);
       cl.add(Calendar.HOUR,-4);
       cl.add(Calendar.MINUTE,-10);
       String newtime=inputFormat.format(cl.getTime());
       cl.add(Calendar.DATE,7);
       String newdate=inputFormat.format(cl.getTime());
       System.out.println(newdate);
       System.out.println(newtime);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","BYVÄGEN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","SANKT OLOF");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","21");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Ingang","A");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.passWithoutClear("Select_Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move4_1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Continue");
		CommonWebActions.passWithoutClear("Continue","");
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntil("Expand1");
		CommonWebActions.javaclick("Expand1");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Expand2");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Service_Bundle1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle3");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle4");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Portal");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move4_2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date20Min",newtime);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(3000);
		CommonWebActions.waitUntil("Service_Bundle4");
		CommonWebActions.fnHighlightMe("Service_Bundle4");
		CommonWebActions.webClick("Service_Bundle4");
		CommonWebActions.wait(3000);
//		CommonWebActions.waituntilElementToBeClickable("Number_Btn");
//		CommonWebActions.webClick("Number_Btn");
//		CommonWebActions.wait(2000);
//		CommonWebActions.waituntilElementToBeClickable("Number_Search_Btn");
//		CommonWebActions.webClick("Number_Search_Btn");
//		CommonWebActions.wait(2000);
//		CommonWebActions.waituntilElementToBeClickable("Number_Search_Btn");
//		//CommonWebActions.waitUntil("First_Number");
//		CommonWebActions.wait(2000);
//		CommonWebActions.webClick("First_Number");
//		CommonWebActions.wait(2000);
//		CommonWebActions.webClick("Book");
		CommonWebActions.waitForLoad1();
		App_CommonFunctions.voipphoneBook();
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 6, enabled=true)
public void TC_005_Move_xDSL_and_voip_to_a_same_aria() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
//		login1();
		
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();  
       //Date d=inputFormat.parse(orderNoFetch1("Btnlocator"));
        Calendar cl = Calendar. getInstance();
//      
       cl.setTime(date);
       cl.add(Calendar.MINUTE,20);
       String newtime=inputFormat.format(cl.getTime());
       cl.add(Calendar.DATE,7);
       String newdate=inputFormat.format(cl.getTime());
       System.out.println(newdate);
       System.out.println(newtime);
       CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","RIPAVÄGEN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","SKURUP");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","4");
		CommonWebActions.wait(2000);
		//CommonWebActions.webSet("Ingang","D");
		//CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Select_Address3");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move4_1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Continue");
		CommonWebActions.passWithoutClear("Continue","");
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntil("Expand1");
		CommonWebActions.javaclick("Expand1");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Expand2");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Service_Bundle1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle3");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle4");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Portal");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move4_2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date20Min",newtime);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 1, enabled=true)
public void TC_001_Move_SDU_with_downgrade_same_aria() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		
		login1();
		
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","FYRBÅKSVÄGEN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","TORSLANDA");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","14");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Ingang","B");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Select_Address2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Service_bundle");
		CommonWebActions.webClick("Service_bundle");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_bundle2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customise");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Qty_clear","");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Bredbandsalternativ_dropdown");
		CommonWebActions.wait(2000);
		CommonWebActions.Selectvaluefromdropdown("Bredbandsalternativ_dropdown","Bredband 10/10");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("QtyEnter","1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddItem");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Done");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 2, enabled=true)
public void TC_002_Move_SDU_with_upgrade_new_aria() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		login1();
		
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","ÖSTRA HORNSGATAN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","SKURUP");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Ingang","D");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Select_Address3");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-02-28");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-02-28");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Service_bundle");
		CommonWebActions.webClick("Service_bundle");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_bundle2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customise");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Qty_clear","");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Bredbandsalternativ_dropdown");
		CommonWebActions.wait(2000);
		CommonWebActions.Selectvaluefromdropdown("Bredbandsalternativ_dropdown","Bredband 100/100");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("QtyEnter","1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddItem");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Done");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 3, enabled=true)
public void TC_007_SDU_Move_Broadband_and_IPTV_to_new_SDU_adress() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		//login1();
		
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","LILLA TORGGATAN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","SKURUP");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","9");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Ingang","B");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Select_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
		if(CommonWebActions.isPresentAndDisplayed(more))
		{
			//System.out.println(more.isDisplayed());
		CommonWebActions.javaclick("Show_more");
		}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move7_1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Portal");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move7_2");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}


@Test(priority = 4, enabled=true)
public void TC_008_SDU_Move_Broadband_to_new_SDU_adress() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		login1();
		
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Add_Address_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Name","LILLA TORGGATAN");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("City","SKURUP");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Street_Number","9");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Ingang","B");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Type","Installation Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Search_Address");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Select_Address3");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("OK_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.passWithoutClear("Address","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		//CommonWebActions.webClick("Primary_Field_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab2");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		//CommonWebActions.webClick("Shipping_Address_checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move8");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 9, enabled=true)
public void TC_001_SDU_Cancel_order_that_is_not_PONR() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		login1();
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();  
       //Date d=inputFormat.parse(orderNoFetch1("Btnlocator"));
        Calendar cl = Calendar. getInstance();
//      
       cl.setTime(date);
       //cl.add(Calendar.MINUTE,20);
       //String newtime=inputFormat.format(cl.getTime());
       cl.add(Calendar.DATE,7);
       String newdate=inputFormat.format(cl.getTime());
       System.out.println(newdate);
       //System.out.println(newtime);
        CommonWebActions.waitUntil("Promotion_MoveC1");
        CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_MoveC1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("New");
		CommonWebActions.wait(2000);
		CommonWebActions.waitUntil("Credit_check");
		CommonWebActions.webClick("Credit_check");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddNewLineItem_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddPromotion_Btn");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("EnterPromotionText","P-TV-IPTV-PlayPlus-1711");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Emty_space");
		CommonWebActions.webClick("AccessType_Btn2");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customise");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Package");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddPackage");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AdditionalPackage");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AddAdditionalPackage");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Done");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AccessType_Btn1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("EnterAccessType_Btn","200");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AccessType_Btn2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("EnterAccessType_Btn","200");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Header",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Expand3");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Expand4");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle5");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle3");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle4");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Bundle6");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Due_Date7D",newdate);
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(12000);
		App_CommonFunctions.refreshComplete("Status3","Open");
		CommonWebActions.wait(2000);
		CommonWebActions.waitUntil("Cancel_Reason_Label");
		CommonWebActions.javaclick("Cancel_Reason_Label");
		CommonWebActions.wait(1000);
		CommonWebActions.javaclick("No_Reason_Text");
		//CommonWebActions.waitUntil("Cancel_Reason");
		//CommonWebActions.webSet("Cancel_Reason2","No Reason");
		CommonWebActions.wait(1000);
		//CommonWebActions.EntertextThenPressTabAndSave("Cancel_Reason", "");
		CommonWebActions.wait(1000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.passWithoutClear("Cancel_Btn","");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

@Test(priority = 7, enabled=true)
public void TC_003_Move_xDSL_to_SDU() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		//login1();
		
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",35000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
		CommonWebActions.wait(3000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		//CommonWebActions.webSet("Start_Date","2019-02-10");
		//CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-17");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("PointID_td");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("PointID_Input");
		CommonWebActions.wait(2000);
		

		//String s=CommonWebActions.wd.findElement(By.xpath("//input[contains(@id,'TS_Point_Id')]")).getText();
		//CommonWebActions.wait(2000);
		String s2=CommonWebActions.wd.findElement(By.xpath("//input[contains(@id,'TS_Point_Id')]")).getAttribute("value");
		//System.out.println(App_CommonFunctions.orderNoFetch("PointID_Input"));
		//System.out.println("Point Id:: "+s);
		System.out.println("Point Id:: "+s2);
//		
		
		
		
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",35000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "Second_SSN"), "Business");
		CommonWebActions.wait(3000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("PointID_Dropdown_Value","Point Id");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("PointId_Text",s2);
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("SearchBtn");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Adress_Against_PI");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Shift");
		CommonWebActions.wait(2000);
		
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("End_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("End_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-14");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Installation_Address_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Installation_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Promotion_Move33");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Modify");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Move_Service");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Continue");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port1");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port_Checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port2");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port_Checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port3");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Busy_Port_Checkbox");
		CommonWebActions.wait(2000);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.webClick("Submit");
		CommonWebActions.wait(12000);
		App_CommonFunctions.refreshComplete("Status3","Open");
		CommonWebActions.wait(2000);
		
		
		CommonWebActions.waitForLoad1();
		CommonWebActions.waitUntilLoaded("MyOrder_link",35000);
		App_CommonFunctions.SearchServiceAccount1(ExcelUtil.getDataFromExcel(testcasename, "Third_SSN"), "Business");
		CommonWebActions.wait(3000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.wait(2000);
		
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Service_Account");
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Address");
		CommonWebActions.webClick("Address");
		
//		CommonWebActions.wait(2000);
//		CommonWebActions.webSet("PointID_Dropdown_Value","Point Id");
//		CommonWebActions.wait(2000);
//		CommonWebActions.webSet("PointId_Text",s2);
//		CommonWebActions.wait(2000);
//		CommonWebActions.webClick("SearchBtn");
//		CommonWebActions.wait(2000);
//		CommonWebActions.webClick("Adress_Against_PI");
//		CommonWebActions.wait(2000);
//		CommonWebActions.webClick("Shift");
//		CommonWebActions.wait(2000);
		
		CommonWebActions.javaclick("Start_Date_Tab2");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","");
		CommonWebActions.wait(2000);
		//CommonWebActions.javaclick("End_Date_Tab1");
		//CommonWebActions.wait(2000);
		//CommonWebActions.webSet("End_Date","2019-03-14");
		//CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Start_Date_Tab1");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Start_Date","2019-03-25");
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Primary_Field_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Primary_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Shipping_Address_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Shipping_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.javaclick("Installation_Address_Tab1");
		CommonWebActions.wait(2000);
		App_CommonFunctions.verify_Installation_Checkbox();
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Addresses_OK");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Account_Hierarchy");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Customer_Account");
		CommonWebActions.wait(2000);
		if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {CommonWebActions.webClick("AcctSummryTab");}else {CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");}
		CommonWebActions.wait(2000);
		
		CommonWebActions.webClick("Failed_Order");
		CommonWebActions.wait(2000);
       
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Revise_btn2");
		CommonWebActions.webClick("Revise_btn2");
		CommonWebActions.wait(3000);
		CommonWebActions.waitUntil("Submit2");
		CommonWebActions.passWithoutClear("Submit2","");
		//CommonWebActions.wait(3000);
		//CommonWebActions.javaclick("Submit2");
		CommonWebActions.wait(12000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		CommonWebActions.wait(2000);
		//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

public static void login1() throws Exception {
	String chromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver70.exe";
	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	CommonWebActions.wd = new ChromeDriver();
    //SIT
    // wd.get("https://"+username+":"+new String(td.decrypt("hl4l9sGnxvniLSjaQXyseQ==").getBytes("UTF-8"), "UTF-8")+"@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmsit1-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe%3F&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe%3F&login_param=5");
    
  //AT
	TrippleDes td = new TrippleDes();
	String username = "sco662";
	String password = "Qwaszx12";
	CommonWebActions.wd.get("https://" + username + ":" + new String(td.decrypt("+S9+vaOKkAKJJSpQl9fUJg==").getBytes("UTF-8"), "UTF-8" )
			+ "@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmat-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe&login_param=5");
	//-----
	
	//AT
	/*username = "hxm810";
	password = "capG01/03";
	wd.get("https://" + username + ":" + password 
			+ "@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmat-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe&login_param=5");
	*/
	CommonWebActions.webImplicitWait(20);
	CommonWebActions.wd.manage().window().maximize();
}

public static String packagename() throws Exception{
	
	return Packagename;
	
}

public static String MOVE_OR(String key) throws IOException{
	String objectPropertyVal1 = null;
	Properties prop = new Properties();
	try {
		FileInputStream fis;
		fis = new FileInputStream(OBJECT_REPO_PATH_Move);
		prop.load(fis);
		objectPropertyVal1=prop.getProperty(key);
//		return objectPropertyVal1;
//		System.out.println("loadPropertiesFile called: path = " + OBJECT_REPO_PATH_Move);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	return objectPropertyVal1;
}

@AfterTest
public void logOut() {
	// CommonWebActions.wd.quit();
}

@AfterSuite
public void tearDown() {
	extent.flush();
	//CommonWebActions.wd.quit();
}



}
