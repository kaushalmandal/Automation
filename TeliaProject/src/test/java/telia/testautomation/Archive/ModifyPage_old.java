package telia.testautomation.Archive;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

@Listeners({ coreFramework.CoreListener.class })

public class ModifyPage_old extends ExtentManager {
	
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
			CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Modify_Link");
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.waitUntil("Continue_Link");
			CommonWebActions.javaclick("Continue_Link");
			CommonWebActions.waitUntil("bund_Link");
			CommonWebActions.javaclick("bund_Link");
			CommonWebActions.wait(2000);
			System.out.println("The test case value:" + ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.waitUntil("Goo_Link");
			CommonWebActions.webClick("Goo_Link");
			CommonWebActions.waitUntil("Customize_Link");
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.waitUntil("Package_Link");
			CommonWebActions.webClick("Package_Link");
			CommonWebActions.javaclick("Check_box");
			CommonWebActions.javaclick("Check_box2");
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.webClick("Hbo_box");
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.webClick("Accept_Email");
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("Submit_btn");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
} catch (Exception e) {
	CommonWebActions.closeAlerts();
	test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
	ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
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
	@Test(priority = 2,enabled=false)
	public void TC_004_Disconnect_pkg() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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
			/*--  Launching URL  --*/
			//CommonWebActions.login();
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.webClick("Account_Tab");
//			CommonWebActions.webClick("Account_List_Menu");
//			CommonWebActions.wait(2000);
//			// ---------------
//			String MenuItemInput = "SSN/Org Number"; // getVariableValue("MenuItem_Input");
//			CommonWebActions.webSet("MenuItem_Input", MenuItemInput);
			
//			CommonWebActions.webClick("Go_Submit_button");
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("Go_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("bund_Link");
			CommonWebActions.wait(3000);
			System.out.println("The test case value:" + ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			boolean result=false;
			int attempts = 0;
			
				/*try {
					CommonWebActions.scrollIntoWebElement("Action_Input");
					CommonWebActions.javaclick("Action_Input");
					CommonWebActions.javaSet("Action_Input", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
					result = true;
				
				} catch (StaleElementReferenceException e) {
				}
				attempts++;*/
			
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Goo_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(10000);
			CommonWebActions.webClick("Package_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Check_box");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Check_box2");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Additional_Pkg");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Hbo_box");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(8000);
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(6000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(2000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
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
	@Test(priority = 3,enabled=false)
	public void TC_005_agreementOn_existingVoIP() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
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
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Active_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Maxi_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("Go_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Modify_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Continue_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.javaclick("Service_Record");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Customize_Link");
			CommonWebActions.wait(6000);
			CommonWebActions.fnHighlightMe("Qty_Editbox");
			CommonWebActions.javaclick("Claer_value");
			CommonWebActions.webSet("Claer_value", "0");
			Thread.sleep(2000);
			CommonWebActions.javaclick("Add_Items");
			CommonWebActions.wait(5000);
			
			CommonWebActions.Selectvaluefromdropdown("Subscription_Alternative",
					ExcelUtil.getDataFromExcel(testcasename, "SubscriptionAlternative"));
			CommonWebActions.javaSet("Claer_value1", "1");
			CommonWebActions.webClick("Add_Items");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Done_btn");
			CommonWebActions.wait(8000);
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
			CommonWebActions.wait(6000);
			CommonWebActions.webSet("Due_value", newtime);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Value_Ok");
			CommonWebActions.wait(3000);
//=============	
			CommonWebActions.webSet("Due_value1", newtime);
			CommonWebActions.wait(3000);
//============		
			CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("Accept_Email");
			CommonWebActions.wait(6000);
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Submit_btn");
			CommonWebActions.wait(10000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value1"));
			CommonWebActions.wait(3000);
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
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
	@Test(priority = 4,enabled=false)
    public void TC_006_changenumber_existingVoIP() throws Exception {
          try {
			ExtentManager.startReporting(new Object() {
			  }.getClass().getEnclosingMethod().getName(), Packagename);
/*--  Launching URL  --*/
//			  CommonWebActions.login();
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
//					e.printStackTrace();
					}
			  CommonWebActions.wait(2000);
			  CommonWebActions.webClick("Homebtn");
			  CommonWebActions.wait(2000);
			  CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			  App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			  CommonWebActions.wait(2000);
			  CommonWebActions.webClick("FirstName_Link");
//			  CommonWebActions.waitForLoad1();
			  CommonWebActions.wait(2000);
			  CommonWebActions.webClick("Active_Link");
			  CommonWebActions.wait(6000);
			  CommonWebActions.webClick("Maxi_Link");
			  CommonWebActions.wait(6000);
			  CommonWebActions.webSet("Product_Type_Input", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			  CommonWebActions.webSet("Product_Input", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			  CommonWebActions.webClick("Go_Link");
			  CommonWebActions.wait(6000);
			  CommonWebActions.webClick("Modify_Link");
			  CommonWebActions.wait(6000);
			  CommonWebActions.webClick("Continue_Link");
			  CommonWebActions.wait(6000);
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
			  /*CommonWebActions.webClick("Expand_bund1");
			  CommonWebActions.wait(3000);*/
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
			  CommonWebActions.wait(6000);
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
			  CommonWebActions.wait(6000);
			  CommonWebActions.javaclick("Customize_Link1");
			  CommonWebActions.wait(6000);
			  CommonWebActions.Selectvaluefromdropdown("ChangeOf_Number",
			              ExcelUtil.getDataFromExcel(testcasename, "ChangeOfNumber"));
			  CommonWebActions.wait(6000);
			  CommonWebActions.webSet("Change_Num", "1");
			  CommonWebActions.wait(6000);
			  CommonWebActions.webClick("Done_btn");
			  CommonWebActions.wait(8000);
			  CommonWebActions.webSet("Reason_Code", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			  CommonWebActions.wait(6000);
			  CommonWebActions.webClick("Accept_Email");
			  CommonWebActions.wait(6000);
			  App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			  CommonWebActions.wait(3000);
			  CommonWebActions.webClick("Submit_btn");
			  CommonWebActions.wait(10000);
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
			              App_CommonFunctions.orderNoFetch("OrderNo"));
			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
			              App_CommonFunctions.orderNoFetch("Due_value1"));
			  CommonWebActions.wait(3000);
			  System.setProperty("jacob.dll.path",
			              System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			  ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		} catch (Exception e) {CommonWebActions.closeAlerts();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName()));
		CommonWebActions.closeAlerts();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}
    }


	
	
	@AfterTest
	public void logOut() {

		// CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		 extent.flush();
		 CommonWebActions.wd.quit();
	}

	
	
}


