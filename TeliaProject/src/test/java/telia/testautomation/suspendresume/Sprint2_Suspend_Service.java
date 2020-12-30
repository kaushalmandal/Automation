package telia.testautomation.suspendresume;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

public class Sprint2_Suspend_Service extends ExtentManager

{
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	
@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
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
@Test(priority = 1, enabled=true)
	public void TC_001_xDSL_Suspend_Abuse_ADSL() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.webClick("FirstName_Link");
			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
			if(CommonWebActions.isPresentAndDisplayed(more))
			{
			CommonWebActions.javaclick("Show_more");
			}
			CommonWebActions.waitUntil("Promotion");
			CommonWebActions.javaclick("Promotion");
			CommonWebActions.javaclick("Settings");
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.javaclick("Continue");
			CommonWebActions.scrollup();
			CommonWebActions.waitUntil("ReasonCode_Text");
			CommonWebActions.webSet("ReasonCode_Text", "Abuse");
			CommonWebActions.waitUntil("SapTerminationDate");
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.waitUntil("DoneBtn2");
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.savePage();
			CommonWebActions.scrollup();
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			CommonWebActions.wait(2000);
			CommonWebActions.logout();
			extent.flush();
			 App_CommonFunctions.refreshComplete("StatusFld",
   					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			//ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
	}

/**
 * @TestcaseName:TC_002_xDSL_Suspend_Payment_Broadband
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */
	@Test(priority=2, enabled=false)
	  
	public void TC_002_xDSL_Suspend_Payment_Broadband() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			//CommonWebActions.login();
			//CommonWebActions.login();
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//// "Search_Account");
//			CommonWebActions.wait(4000);
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.wait(2000);
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_BBNP");
			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Show_more");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Show_more");
//			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//			if(CommonWebActions.isPresentAndDisplayed(more))
//			{
//				//System.out.println(more.isDisplayed());
//			CommonWebActions.javaclick("Show_more");
//			}
//			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_BBNP");
			CommonWebActions.javaclick("Promotion_BBNP");
			CommonWebActions.wait(2000);
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(3000);
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(4000);
			CommonWebActions.webSet("ReasonCode_Text", "Non Payment");
			//CommonWebActions.wait(6000);
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.wait(3000);
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(5000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
			}
		catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
	}
/**
 * @TestcaseName:TC_003_xDSL_Suspend_Payment_IPTV
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */ 
	@Test(priority=3, enabled=false)
	public void TC_003_xDSL_Suspend_Payment_IPTV() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			//CommonWebActions.login();
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//// "Search_Account");
//			CommonWebActions.wait(4000);
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.wait(2000);
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_IPTVNP");
			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Show_more");
//			CommonWebActions.javaclick("Show_more");
//			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//			if(CommonWebActions.isPresentAndDisplayed(more))
//			{
//				//System.out.println(more.isDisplayed());
//			CommonWebActions.javaclick("Show_more");
//			}
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_IPTVNP");
			CommonWebActions.javaclick("Promotion_IPTVNP");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(3000);
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(6000);
			CommonWebActions.webSet("ReasonCode_Text", "Non Payment");
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(4000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			CommonWebActions.logout();
			extent.flush();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
			} 
			catch (Exception e) {
				CommonWebActions.closeAlerts();
				CommonWebActions.logout();
				test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
		}

	}
/**
 * @TestcaseName:TC_004_xDSL_Suspend_Payment_VOIP
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */ 
@Test(priority = 4, enabled=false)
	public void TC_004_xDSL_Suspend_Payment_VOIP() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			//CommonWebActions.login();
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//			CommonWebActions.wait(4000);
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_VOIPNP");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Show_more");
//			CommonWebActions.javaclick("Show_more");
//			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//			if(CommonWebActions.isPresentAndDisplayed(more))
//			{
//				//System.out.println(more.isDisplayed());
//			CommonWebActions.javaclick("Show_more");
//			}
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_VOIPNP");
			CommonWebActions.javaclick("Promotion_VOIPNP");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(3000);
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("ReasonCode_Text", "Non Payment");
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(5000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
			}
		catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}

	}
/**
 * @TestcaseName:TC_005_SDU_Resume_Abuse_an_existing_Broadband
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */ 
@Test(priority = 6, enabled=false)

public void TC_005_SDU_Resume_Abuse_an_existing_Broadband() throws Exception {
	try {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		CommonWebActions.login();
		CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN");
		System.out.println(SSN_No);
		CommonWebActions.javaclick("Home_Tab");
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
		App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("FirstName_Link");
//		CommonWebActions.javaclick("Accounts");
//		CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//		CommonWebActions.javaclick("All_Accounts");
//		CommonWebActions.javaclick("Search_Account");
//		CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//		CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//		CommonWebActions.waituntilElementToBeClickable("Go_btn");
//		CommonWebActions.javaclick("Go_btn");
//		CommonWebActions.javaclick("Your_Account_SDU_BB_Abuse_Resume");
////		WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//		if(CommonWebActions.isPresentAndDisplayed(more))
//		{
//			//System.out.println(more.isDisplayed());
//		CommonWebActions.javaclick("Show_more");
//		}
		CommonWebActions.wait(4000);
		CommonWebActions.waituntilElementToBeClickable("Promotion_SDU_BB_Abuse_Resume");
		CommonWebActions.javaclick("Promotion_SDU_BB_Abuse_Resume");
		CommonWebActions.javaclick("Settings");
		CommonWebActions.passWithoutClear("Resume", "");
		CommonWebActions.javaclick("Continue");
		CommonWebActions.scrollup();
		App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
		CommonWebActions.wait(2000);
		CommonWebActions.savePage();
		CommonWebActions.wait(2000);
		CommonWebActions.scrollup();
		CommonWebActions.wait(2000);
		CommonWebActions.waituntilElementToBeClickable("Submit");
		CommonWebActions.javaclick("Submit");
		CommonWebActions.wait(5000);
		String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
		System.out.println("Order id is:" + Order_id2);
		String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
		System.out.println("Due date is:" + due_date);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
		extent.flush();
		CommonWebActions.logout();
		System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
	} catch (Exception e) {CommonWebActions.closeAlerts();
	CommonWebActions.logout();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
}

/**
 * @TestcaseName:TC_006_SDU_Suspend_Abuse_an_existing_Broadband
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */ 
	@Test(priority = 5, enabled=false)

	public void TC_006_SDU_Suspend_Abuse_an_existing_Broadband() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			CommonWebActions.webClick("Home_Tab");
			//CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_SDU_BB_Abuse");
			//CommonWebActions.wait(2000);
			//CommonWebActions.waituntilElementToBeClickable("Show_more");
//			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//			if(CommonWebActions.isPresentAndDisplayed(more))
//			{
//				//System.out.println(more.isDisplayed());
//			CommonWebActions.javaclick("Show_more");
//			}
			//CommonWebActions.javaclick("Show_more");
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_SDU_BB_Abuse");
			CommonWebActions.javaclick("Promotion_SDU_BB_Abuse");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(2000);
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("ReasonCode_Text", "Abuse");
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.wait(2000);
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(4000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
	}

/**
 * @TestcaseName:TC_007_Suspend_Resume
 * @Description: 
 * @Complexity:High
 * @author :Baladev
 * @ALM :
 * 
 */ 	
	@Test(priority=7,enabled=false)

	public void TC_007_Suspend_Resume() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			CommonWebActions.webClick("Home_Tab");
			//CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//			CommonWebActions.wait(2000);
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.wait(2000);
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_Sus_Res1");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Show_more");
//			CommonWebActions.javaclick("Show_more");
//			WebElement more=CommonWebActions.wd.findElement(By.xpath("//span[contains(@title,'Installed Assets:Show more')]/.."));
//			if(CommonWebActions.isPresentAndDisplayed(more))
//			{
//				//System.out.println(more.isDisplayed());
//			CommonWebActions.javaclick("Show_more");
//			}
			CommonWebActions.wait(4000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_Sus_Res");
			CommonWebActions.javaclick("Promotion_Sus_Res");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(2000);
			CommonWebActions.passWithoutClear("Suspend", "");
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("ReasonCode_Text", "Abuse");
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
			CommonWebActions.passWithoutClear("SapTerminationDate", "");
			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
			CommonWebActions.javaclick("DoneBtn2");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(4000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			extent.flush();
			CommonWebActions.logout();
			System.out.println("Order id is:" + Order_id2);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
			} catch (Exception e) {CommonWebActions.closeAlerts();
			CommonWebActions.logout();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
	}

	@Test(priority=8,enabled=false)
	
	public void TC_007_Suspend_Resume_Part2() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",5000);
			//CommonWebActions.login();
			CommonWebActions.webClick("Home_Tab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.javaclick("Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("All_Accounts");
//			CommonWebActions.javaclick("All_Accounts");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Search_Account");
//			CommonWebActions.wait(2000);
//			CommonWebActions.wd.findElement(By.xpath("//input[@aria-label='SSN/Org Number']")).clear();
//			CommonWebActions.webSet("SSN", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntilElementToBeClickable("Go_btn");
//			CommonWebActions.javaclick("Go_btn");
//			CommonWebActions.wait(2000);
//			CommonWebActions.javaclick("Your_Account_Sus_Res2");
//			CommonWebActions.wait(2000);
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("Promotion_Sus_Res2");
			CommonWebActions.javaclick("Promotion_Sus_Res2");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Settings");
			CommonWebActions.wait(2000);
			CommonWebActions.passWithoutClear("Resume", "");
			CommonWebActions.wait(2000);
			CommonWebActions.javaclick("Continue");
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
//			CommonWebActions.webSet("ReasonCode_Text", "Abuse");
//			CommonWebActions.waituntilElementToBeClickable("SapTerminationDate");
//			CommonWebActions.passWithoutClear("SapTerminationDate", "");
//			CommonWebActions.waituntilElementToBeClickable("DoneBtn2");
//			CommonWebActions.javaclick("DoneBtn2");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			CommonWebActions.wait(4000);
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
			} catch (Exception e) {CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
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
