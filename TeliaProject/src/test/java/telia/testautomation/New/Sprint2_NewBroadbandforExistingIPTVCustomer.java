/*
 * Manual Testcase Name :
 * Description of Testcase:
 * Date of Creation:
 * Reviewed By:
 * Author:
 */ 
	
package telia.testautomation.New;	

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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
public class Sprint2_NewBroadbandforExistingIPTVCustomer extends ExtentManager {
	
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
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName", Packagename);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
/**
 * @TestcaseName:TC_001_New_Broadband_Service
 * @Description: 
 * @Complexity:High
 * @author :Rinki
 * @ALM :P-TV-IPTV-PlayPlus-1711	
 * 
 */ 
@Test(priority = 1,enabled=true)
	public void SDU_New_Broadband_for_existing_IPTV_customer
	() throws Exception {
		/* CommonMethods common = new CommonMethods(driver); */
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",30000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AddNew_Button");
			CommonWebActions.webClick("AddNew_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.scrollup();
			CommonWebActions.fnHighlightMe1(CommonWebActions.wd, CommonWebActions.findElement("CreditCheck_Button"));
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
//			Verification pending of scoring response
			CommonWebActions.webClick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.wait(1000);
			boolean alertpresent = CommonWebActions.isAlertPresent();
			if (alertpresent) {
				System.out.println(CommonWebActions.wd.switchTo().alert().getText());
				CommonWebActions.wd.switchTo().alert();
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.wait(1000);
			CommonWebActions.scrollDown();
			CommonWebActions.scrollIntoWebElement1("Item_OptGrpIAspeed_BB");
			CommonWebActions.fnHighlightMe1(CommonWebActions.wd, CommonWebActions.findElement("Item_OptGrpIAspeed_BB"));
//			CommonWebActions.fnHighlightMe("Item_OptGrpIAspeed");
			CommonWebActions.webClick("Item_OptGrpIAspeed_BB");
			CommonWebActions.Selectvaluefromdropdown("Item_OptGrpIAspeed_BB", "Bredband 250");
			CommonWebActions.webSet("Item_OptGrpIAspeed_QTY_BB", "1");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrpIAspeed_AddItem_BB");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(2000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("Home_Submit");
			CommonWebActions.wait(1000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			System.out.println(App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_date"));
			// CommonWebActions.webVerifyInnerText("ActivitiesTab_Type_Status","Sent");
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, testcasename, "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint2", 36542, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}	
/**
 * @TestcaseName:TC_002_New_IPTV_Service
 * @Description: 
 * @Complexity:High
 * @author :Rinki
 * @ALM :
 * 
 */ 
@Test(priority = 2,enabled=true)
public void SDU_New_IPTV_for_existing_Broadband_customer
() throws Exception {
/*CommonMethods common = new CommonMethods(driver);*/
			try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(),Packagename);
			try {
				boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				 if (Dialog){
					 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				 }
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// TODO Auto-generated catch block
//				e.printStackTrace();
				}
/*--  Launching URL  --*/
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			String testcasename=(new Object() {
			}.getClass().getEnclosingMethod().getName());
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
//			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddNew_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.wait(2000);
//			CommonWebActions.scrollIntoWebElement("Listitem_AddNew");
			CommonWebActions.webClick("Listitem_AddNew");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1,"Product",ExcelUtil.getDataFromExcel(testcasename,"Product"));
			boolean alertpresent=CommonWebActions.isAlertPresent();
			if(alertpresent){
				CommonWebActions.wd.switchTo().alert(); 
				CommonWebActions.wd.switchTo().alert().accept();
			}
					CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			//CommonWebActions.Tab();
			App_CommonFunctions.NewLineITem(3,"Access Type",ExcelUtil.getDataFromExcel(testcasename,"AccessType"));
//			App_CommonFunctions.NewLineITem(1,"Product",ExcelUtil.getDataFromExcel(testcasename,"Product"));
//			CommonWebActions.Tab();
//			App_CommonFunctions.NewLineITem(3,"Access Type",ExcelUtil.getDataFromExcel(testcasename,"AccessType"));
			//CommonWebActions.wait(1000);
			//CommonWebActions.Tab();
//			CommonWebActions.javaSet("Lineitem_Product", ExcelUtil.getDataFromExcel(testcasename,"Product"));
//			//CommonWebActions.Tab();
//			CommonWebActions.javaSet("Access_TypeIPTV", ExcelUtil.getDataFromExcel(testcasename,"AccessType"));
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.scrollDown();
			CommonWebActions.javaclick("Package_Button");
			CommonWebActions.wait(2000);
			for(int i=0; i<=2;i++){
				  try{
					  CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item", "Tv-paket Lagom");
				     break;
				  }
				  catch(Exception e){
				     System.out.println(e.getMessage());
				  }
			}
//			CommonWebActions.scrollIntoWebElement("OptGrp_TV_TeliaPackages_1704_Item");
			CommonWebActions.Selectvaluefromdropdown("OptGrp_TV_TeliaPackages_1704_Item", "Tv-paket Lagom");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp-TV-ViasatPackages-1704");
			CommonWebActions.wait(1000);
//			CommonWebActions.scrollIntoWebElement("OptGrp_TV_CMorePackages_1704");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Item_OptGrp_TV_CMorePackages_1704");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(1000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("Home_Submit");
			CommonWebActions.wait(2000);		
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			//CommonWebActions.fnHighlightMe("Activities_Tab");
			//CommonWebActions.javaclick("Activities_Tab");
			//CommonWebActions.javaclick("ActivitiesTab_Type_Status");
			//CommonWebActions.javaclick("ActivitiesTab_OrderID");
			ExcelUtil.setDatatoExcel("Test_Output",testcasename,"SSN",App_CommonFunctions.orderNoFetch("SSN"));
		    ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Order_Number",App_CommonFunctions.orderNoFetch("OrderNo_Input"));
		    ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date",App_CommonFunctions.orderNoFetch("Due_date")); 
			test.log(Status.PASS,"Submit  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			extent.flush();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
}
			catch (Exception e)
			{
				CommonWebActions.closeAlerts();
				// TODO Auto-generated catch block
				test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
			}
		}
/**
 * @TestcaseName:TC_003_New_VAS_Service
 * @Description: 
 * @Complexity:High
 * @author :Rinki
 * @ALM :
 * 
 */ 
@Test(priority = 3,enabled=true)
	public void SDU_Add_a_new_VAS_to_existing_Broadband
() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			try {
				boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				 if (Dialog){
					 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				 }
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// TODO Auto-generated catch block
//				e.printStackTrace();
				}
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddNew_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.webClick("CreditCheck_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Listitem_AddNew");
			App_CommonFunctions.NewLineITem(1,"Product",ExcelUtil.getDataFromExcel(testcasename,"Product"));
			CommonWebActions.savePage();
			boolean alertpresent=CommonWebActions.isAlertPresent();
			if(alertpresent){
				CommonWebActions.wd.switchTo().alert(); 
				CommonWebActions.wd.switchTo().alert().accept();
			}
			CommonWebActions.savePage();
			CommonWebActions.wait(1000);
			//CommonWebActions.Tab();
			App_CommonFunctions.NewLineITem(2,"Access Type",ExcelUtil.getDataFromExcel(testcasename,"AccessType"));
//			App_CommonFunctions.NewLineITem(1,"Product",ExcelUtil.getDataFromExcel(testcasename,"Product"));
//			CommonWebActions.Tab();
//			App_CommonFunctions.NewLineITem(2,"Access Type",ExcelUtil.getDataFromExcel(testcasename,"AccessType"));
//			CommonWebActions.javaSet("Lineitem_Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			//CommonWebActions.Tab();
//			CommonWebActions.javaSet("Access_Type_VAS", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.webClick("Customize_Button");
			CommonWebActions.Selectvaluefromdropdown("OptGrp_VAS_Spotify_1703_1_Item", "Telia Spotify Premium");
			CommonWebActions.wait(1000);
			CommonWebActions.webSet("OptGrp_VAS_Spotify_1703_1_QTY", ExcelUtil.getDataFromExcel(testcasename, "QTY"));
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Add_Item_VAS");
			CommonWebActions.wait(1000);
			CommonWebActions.scrollDown();
			CommonWebActions.javaclick("Salesorder_Done1");
			CommonWebActions.wait(1000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("Home_Submit");
			CommonWebActions.wait(2000);
			App_CommonFunctions.orderNoFetch("SalesOrder_Status");
			App_CommonFunctions.orderNoFetch("Priority_Status");
			App_CommonFunctions.orderNoFetch("Fullfillment_Status");
			//CommonWebActions.fnHighlightMe("Activities_Tab");
			//CommonWebActions.javaclick("Activities_Tab");
			//CommonWebActions.javaclick("ActivitiesTab_Type_Status");
			//CommonWebActions.javaclick("ActivitiesTab_OrderID");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
			App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", App_CommonFunctions.orderNoFetch("Due_date"));
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_submit")));
			extent.flush();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
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

