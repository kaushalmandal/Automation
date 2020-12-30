package telia.testautomation.Modify;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
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

public class Sprint2_Modify_updated extends ExtentManager {

	private static final String SomeElementNotFound = null;
	String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
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
 * @TestcaseName:TC_001_xDSL_ModifyVoIPUpgrade
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */ 
	@Test(priority=1,enabled=true)
	public void TC_001_xDSL_ModifyVoIPUpgrade() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		/*--  Launching URL  --*/
		try {
			CommonWebActions.login();
//			Thread.sleep(10000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			System.out.println(ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
					ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("VoiceMailDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "VoiceMailValue"));
			CommonWebActions.passWithoutClear("VoiceMailQty", "1");
			CommonWebActions.webClick("VoiceMailAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("MilestonChevron");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			test.log(Status.PASS, "Modify VOIP Upgrade Page ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
//			ALMTestfactory.updateResults("E2EMM Automation","Demo", 34441, "Demo_Test","Not Completed" );
		} catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}

	}
/**
 * @TestcaseName:TC_002_xDSL_ModifyVoIPDwngrade
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */ 
	@Test(priority=2,enabled=true)
	public void TC_002_xDSL_ModifyVoIPDwngrade() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
//		Thread.sleep(10000);
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
		try {
			boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
			 if (Dialog){
				 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
			 }
		} catch (Exception e) {
			System.out.println("Cancel Element not present");
			// TODO Auto-generated catch block
//			e.printStackTrace();
			}
		/*--  Launching URL  --*/
		try {
		
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);//
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
					ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("MilestonChevron");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Modify VOIP Downgrade ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			extent.flush();
			CommonWebActions.logout();
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
//			ALMTestfactory.updateResults("E2EMM Automation","Demo", 34441, "Demo_Test","Not Completed" );
		} catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}

	}
/**
 * @TestcaseName:TC_003_xDSL_ModifyBrdbandandUpgrd_ADSL_VDSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */
	@Test(priority=3,enabled=true)
	public void TC_003_xDSL_ModifyBrdbandandUpgrd_ADSL_VDSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
//		Thread.sleep(10000);
		CommonWebActions.waitUntilLoaded("MyOrder_link", 4000);
		try {
			boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
			 if (Dialog){
				 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
			 }
		} catch (Exception e) {
			System.out.println("Cancel Element not present");
			// TODO Auto-generated catch block
//			e.printStackTrace();
			}
		/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
//			CommonWebActions.webClick("AcctsTab");
//			CommonWebActions.webClick("AcctListBtn");
//			CommonWebActions.waitUntilLoaded("SSNSrchDiv", 30);
//			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input"));
//			CommonWebActions.webSet("SSN_Org_Input", ExcelUtil.getDataFromExcel(testcasename, "SSN"));
//			CommonWebActions.webClick("SSNAcctGoBtn");
//			CommonWebActions.wait(1000);
//			CommonWebActions.webClick("CustmrNameLnkClk");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Modify BB Upgrade ADSL to VDSL ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
			System.setProperty("jacob.dll.path",
					System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Not Completed" );
//			ALMTestfactory.updateResults("E2EMM Automation","Demo", 34441, "Demo_Test","Not Completed" );
		} catch (Exception e) {CommonWebActions.closeAlerts();
		CommonWebActions.logout();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );}

	}
/**
 * @TestcaseName:TC_004_xDSL_ModifyBrdbandandDwngrd_VDSL_ADSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */
	@Test(priority=4, enabled=true)
	public void TC_004_xDSL_ModifyBrdbandandDwngrd_VDSL_ADSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
//		Thread.sleep(10000);
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
		try {
			boolean Dialog=CommonWebActions.Exists(CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
			 if (Dialog){
				 CommonWebActions.wd.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
			 }
		} catch (Exception e) {
			System.out.println("Cancel Element not present");
			// TODO Auto-generated catch block
//			e.printStackTrace();
			}
		/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("AcctsTab");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			// CommonWebActions.webClick("AcctListBtn");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));

			test.log(Status.PASS, "Modify BB Downgrade VDSL to ADSL ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
 * @TestcaseName:TC_005_xDSL_ModifyBroadbandandVoIPUpgrade_VDSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */
	@Test(priority=5,enabled=true)
	public void TC_005_xDSL_ModifyBroadbandandVoIPUpgrade_VDSL() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
//		Thread.sleep(10000);
		CommonWebActions.waitUntilLoaded("MyOrder_link", 4000);
		/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);//
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
					ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("VoiceMailDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "VoiceMailValue"));
			CommonWebActions.passWithoutClear("VoiceMailQty", "1");
			CommonWebActions.webClick("VoiceMailAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Modify BB and VOIP Upgrade to VDSL ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
 * @TestcaseName:TC_006_xDSL_ModifyBroadbandandVoIPDwngrd_ADSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */
	@Test(priority=6, enabled=true)
	public void TC_006_xDSL_ModifyBroadbandandVoIPDwngrd_ADSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
//		Thread.sleep(10000);
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
				/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);//
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
					ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("VoiceMailDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "VoiceMailValue"));
			CommonWebActions.passWithoutClear("VoiceMailQty", "1");
			CommonWebActions.webClick("VoiceMailAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Modify BB and VOIP Downgrade to ADSL ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
 * @TestcaseName:TC_007_XDSL_555652_Keep_tv_when_disconnecting_broadband
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */	
	@Test(priority=7, enabled=true)
	public void TC_007_XDSL_555652_Keep_tv_when_disconnecting_broadband() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
				/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "Keep Tv and Disconnect BB ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
 * @TestcaseName:TC_008_xDSL_ModifyBroadband_IPTV_VoIP_Upgrade_ADSL_VDSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */	
	@Test(priority=8, enabled=true)
	public void TC_008_xDSL_ModifyBroadband_IPTV_VoIP_Upgrade_ADSL_VDSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
		/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion3"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PackageTab");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek2");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
					ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("VoiceMailDrpdwn",
					ExcelUtil.getDataFromExcel(testcasename, "VoiceMailValue"));
			CommonWebActions.passWithoutClear("VoiceMailQty", "1");
			CommonWebActions.webClick("VoiceMailAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "BB,IPTV, VOIP Upgrade ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
		
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
 * @TestcaseName:TC_009_xDSL_ModifyBroadband_IPTV_VoIP_Dwngrade_ADSL
 * @Description: 
 * @Complexity:High
 * @author :Satya
 * @ALM :
 * 
 */
	@Test(priority=9, enabled=true)
	public void TC_009_xDSL_ModifyBroadband_IPTV_VoIP_Dwngrade_ADSL() throws Exception {
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		CommonWebActions.login();
		CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
		/*--  Launching URL  --*/
		try {
			CommonWebActions.webClick("Homebtn");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("FirstName_Link");
			CommonWebActions.wait(2000);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.wait(1500);
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Promotion3"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.wait(3000);
			CommonWebActions.webSet("XDSLModDate", ExcelUtil.getDataFromExcel(testcasename, "DueDate"));
			CommonWebActions.webClick("ContinueBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chk");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
			ExcelUtil.getDataFromExcel(testcasename, "Modify2Speed"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.javaclick("AddItemBtn2");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek3");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("PackgeTab");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("TVSpedDrpdwn",
			ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.webClick("AcssTyp100Chek2");
			CommonWebActions.webClick("CustmzeBtn");
			CommonWebActions.wait(4000);
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.wait(2500);
			CommonWebActions.Selectvaluefromdropdown("VoipSubscriptionDrpdown",
			ExcelUtil.getDataFromExcel(testcasename, "VoipSubscription"));
			CommonWebActions.passWithoutClear("VoipSubscrQty", "1");
			CommonWebActions.javaclick("VoipAgreementAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.Selectvaluefromdropdown("VoiceMailDrpdwn",
			ExcelUtil.getDataFromExcel(testcasename, "VoiceMailValue"));
			CommonWebActions.passWithoutClear("VoiceMailQty", "1");
			CommonWebActions.webClick("VoiceMailAddItmBtn");
			CommonWebActions.wait(1000);
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.wait(4000);
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.wait(2000);
			// CommonWebActions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("TestOutput", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));

			test.log(Status.PASS, "BB,IPTV, VOIP Downgrade ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
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
	
	//-----------------------------End Test ----------------------------------------//
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
