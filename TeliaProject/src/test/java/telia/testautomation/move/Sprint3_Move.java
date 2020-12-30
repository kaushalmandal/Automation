/**
 

	 * @Description: 
	 * @Complexity:High
	 * @author :Rinki
	 * @ALM :
	 * 
	 */ 
package telia.testautomation.move;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
@Test
@Listeners({ coreFramework.CoreListener.class })


public class Sprint3_Move extends ExtentManager {

	public static String url = "Test";
	private static String hostName;
//    private static ITestSet testSet;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];

	@BeforeSuite
	public void init() throws Exception {
		try {
			// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName",Packagename);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	@Test(priority = 1,enabled=true)	

	public void XDSL_1172_Move_BB_IPTV_with_new_TV_package () throws Exception {
	/*CommonMethods common = new CommonMethods(driver);*/
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : " + Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase : " + testcasename);
		
		try {
	/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 80000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");        
	        CommonWebActions.webClick("Account_Hierarchy");
	        CommonWebActions.waitUntil("ServiceAcct");
			CommonWebActions.javaclick("ServiceAcct");
			CommonWebActions.wait(1000);
	        //CommonWebActions.webClick("SASP_Link_2");
	        CommonWebActions.wait(1000);
	        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
	        CommonWebActions.webClick("Address_Icon");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Add_Address_Btn");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webSet("Street_Name", ExcelUtil.getDataFromExcel(testcasename, "StreetName"));
	        CommonWebActions.webSet("City_Name", ExcelUtil.getDataFromExcel(testcasename, "City"));
	        
	        CommonWebActions.webSet("InstallType","Installation Address");
	        CommonWebActions.wait(1000);
	        CommonWebActions.webClick("Search_Address_New");
	        CommonWebActions.wait(1000);
	        CommonWebActions.webClick("Select_Address_New");
	        
	        CommonWebActions.webClick("OK_Btn_New");
	        CommonWebActions.wait(2000);
	        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
	        CommonWebActions.wait(2000);
	        CommonWebActions.javaclick("Address_Icon");
	        
	        CommonWebActions.webClick("Account_ShippingAccount_Select");
	        CommonWebActions.webClick("shipping");
	        
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Copper_MAX_HD1");
	        CommonWebActions.webSet("Copper_MAX_HD1_Input", ExcelUtil.getDataFromExcel(testcasename,"CopperMaxHD"));
	        CommonWebActions.Tab();
	        CommonWebActions.webSet("Copper_MAX_HD2", ExcelUtil.getDataFromExcel(testcasename,"CopperMaxSD"));
	        CommonWebActions.savePage();
	        CommonWebActions.webClick("Account_Address_OK");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Account_Hierarchy");
	        CommonWebActions.wait(2000);
	        CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
	        //CommonWebActions.webClick("Customer_Account_Link1");
	        CommonWebActions.wait(2000);
	        
	        CommonWebActions.waitForLoad1();
	        if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
	             CommonWebActions.webClick("AcctSummryTab");          
	        }else {
	             CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
	        } 
	       //CommonWebActions.Selectvaluefromdropdown("Account_Summary", "Account Summary");
	        //CommonWebActions.webClick("Account_Summary");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Promotion_BBXdSL");
	        CommonWebActions.wait(3000);
	        CommonWebActions.webClick("Modify_ButtonClick");
	        CommonWebActions.webSet("Due_Date_BB", ExcelUtil.getDataFromExcel(testcasename,"DueDateBB"));
	        CommonWebActions.webClick("Move_Service");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Continue_Button");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Portal_Button");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("Promotion_IPTV1");
	        CommonWebActions.wait(2000);
	        CommonWebActions.webClick("ModifyBtn1");
	        CommonWebActions.wait(1000);
	           
	        CommonWebActions.webSet("Due_Date_BB", ExcelUtil.getDataFromExcel(testcasename,"DueDateBB"));
	        CommonWebActions.wait(2000);
	        
	        CommonWebActions.checkBoxSelect("Move_Service1");
	        //CommonWebActions.webClick("Move_Service");
	        CommonWebActions.wait(1000);
	        CommonWebActions.webClick("Continue_Button");
	        CommonWebActions.wait(1000);
	        CommonWebActions.webClick("Home_Submit");
	       
		
			ExcelUtil.setDatatoExcel("Test_Output",testcasename,"SSN",App_CommonFunctions.orderNoFetch("SSN"));
	        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Order_Number",App_CommonFunctions.orderNoFetch("OrderNo_Input"));
	        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date",App_CommonFunctions.orderNoFetch("Due_date")); 
	        test.log(Status.PASS,"Moved Broadband and IPTV to new Address"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
			extent.flush();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint3", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Open" );
			}
			catch (Exception e)
			{
				CommonWebActions.closeAlerts();
			  // TODO Auto-generated catch block
			    test.log(Status.PASS, "Test Case Passed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Passed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
	             System.out.println("Move should be Successfully ");
	            e.printStackTrace();
			}
	}


@AfterClass
public static void teardown() throws Exception {
	CommonWebActions.logout();
extent.flush();
CommonWebActions.wd.quit();
}
}