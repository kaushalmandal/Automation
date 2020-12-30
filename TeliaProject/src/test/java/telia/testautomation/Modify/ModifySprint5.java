package telia.testautomation.Modify;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

public class ModifySprint5 extends ExtentManager {
	
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
	public  void TC_001_xDSL_Modify_BB_Upgrade_ADSL() throws Exception 
	{
	ExtentManager.startReporting(new Object() {
	}.getClass().getEnclosingMethod().getName(), Packagename);
	String testcasename = (new Object() {
	}.getClass().getEnclosingMethod().getName());
	System.out.println("testcase:"+testcasename);
	try
	{
		CommonWebActions.login();
		CommonWebActions.waitUntil("WelcomeDiv");
		App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.retryingFindClick("FirstName_Link");
		CommonWebActions.waitUntil("AccountHierarchyTab");
		App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
		CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
		CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
		CommonWebActions.webClick("PromtnSrchGoBtn");
		CommonWebActions.waitUntil("AccountHierarchyTab");
		App_CommonFunctions.promotioncount("ProdNotEmptyList");
		CommonWebActions.webClick("ModifyBtn");
		CommonWebActions.waitUntil("ContinueButtne");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("DuePopUp"));
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE,8);//adds 8days
		String newtime1 = inputFormat.format(c.getTime());
		System.out.println(newtime1);
		CommonWebActions.webSet("DuePopUp", newtime1);
		CommonWebActions.webClick("ContinueButtne");
		CommonWebActions.waitUntil("SubmitBtn");
		App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundleForExistingIPTV"), "Customzsearch", "CustmzeBtn");
		CommonWebActions.webClick("CustmzeBtn");		
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.clearValuesnSave("VoipAgreementRemove");
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
				ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
		CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
		CommonWebActions.waitUntil("AddItemBtn2");
		CommonWebActions.webClick("AddItemBtn2");
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.javaclick("DoneBtn1");
		CommonWebActions.waitUntil("SubmitBtn");
		CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
		CommonWebActions.waitUntil("SubmitBtn");
		CommonWebActions.webClick("SubmitBtn");
		App_CommonFunctions.refreshComplete("StatusFld",
				ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
		App_CommonFunctions.orderNoFetch("OrderNo");
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
				App_CommonFunctions.orderNoFetch("OrderNo"));
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
				App_CommonFunctions.orderNoFetch("DueDate"));
		test.log(Status.PASS, "XDSL Modify BB Upgrade ADSL to VDSL ["
				+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
		extent.flush();
		CommonWebActions.logout();
	}
	catch (Exception e) 
	{
		CommonWebActions.closeAlerts();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	}
		
	}
	
	@Test(priority=2, enabled=true)
	public  void TC_002_xDSL_Modify_BB_Downgrade_VDSL() throws Exception 
	{
	ExtentManager.startReporting(new Object() {
	}.getClass().getEnclosingMethod().getName(), Packagename);
	String testcasename = (new Object() {
	}.getClass().getEnclosingMethod().getName());
	System.out.println("testcase:"+testcasename);
	try
	{
		CommonWebActions.login();
		CommonWebActions.waitUntil("WelcomeDiv");
		App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		CommonWebActions.retryingFindClick("FirstName_Link");
		CommonWebActions.waitUntil("AccountHierarchyTab");
		App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
		CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
		CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
		CommonWebActions.webClick("PromtnSrchGoBtn");
		CommonWebActions.waitUntil("AccountHierarchyTab");
		App_CommonFunctions.promotioncount("ProdNotEmptyList");
		CommonWebActions.webClick("ModifyBtn");
		CommonWebActions.waitUntil("ContinueButtne");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("DuePopUp"));
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE,8);//adds 8days
		String newtime1 = inputFormat.format(c.getTime());
		System.out.println(newtime1);
		CommonWebActions.webSet("DuePopUp", newtime1);
		CommonWebActions.webClick("ContinueButtne");
		CommonWebActions.waitUntil("SubmitBtn");
		App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundleForExistingIPTV"), "Customzsearch", "CustmzeBtn");
		CommonWebActions.webClick("CustmzeBtn");		
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.clearValuesnSave("VoipAgreementRemove");
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
				ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
		CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
		CommonWebActions.waitUntil("AddItemBtn2");
		CommonWebActions.webClick("AddItemBtn2");
		CommonWebActions.waitUntil("DoneBtn1");
		CommonWebActions.javaclick("DoneBtn1");
		CommonWebActions.waitUntil("SubmitBtn");
		CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
		CommonWebActions.waitUntil("SubmitBtn");
		CommonWebActions.webClick("SubmitBtn");
		App_CommonFunctions.refreshComplete("StatusFld",
				ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
		App_CommonFunctions.orderNoFetch("OrderNo");
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
				App_CommonFunctions.orderNoFetch("OrderNo"));
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
				App_CommonFunctions.orderNoFetch("DueDate"));
		test.log(Status.PASS, "XDSL Modify BB Downgrade VDSL to ADSL ["
				+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
		extent.flush();
		CommonWebActions.logout();
	}
	catch (Exception e) 
	{
		CommonWebActions.closeAlerts();
		test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
	}
		
	}
	
	@Test(priority=3, enabled=true)
	public void TC_003_SDU_ModifyBB_Upgrade() throws Exception  
	
	{
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try	 
		{
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.promotioncount("ProdNotEmptyList");
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.waitUntil("ContinueButtne");
			CommonWebActions.webClick("ContinueButtne");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundleForExistingIPTV"), "Customzsearch", "CustmzeBtn");
			CommonWebActions.webClick("CustmzeBtn");		
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.waitUntil("AddItemBtn2");
			CommonWebActions.webClick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "SDU Modify BB Downgrade  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
		}
		catch (Exception e)
		{
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		}
	}
	
	
	@Test(priority=4, enabled=true)
	public void TC_004_SDU_ModifyBB_Downgrade() throws Exception  
	
	{
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try	 
		{
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.promotioncount("ProdNotEmptyList");
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.waitUntil("ContinueButtne");
			CommonWebActions.webClick("ContinueButtne");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundleForExistingIPTV"), "Customzsearch", "CustmzeBtn");
			CommonWebActions.webClick("CustmzeBtn");		
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.clearValuesnSave("VoipAgreementRemove");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Promotion2"));
			CommonWebActions.passWithoutClear("SpeedAddTxtFld2", "1");
			CommonWebActions.waitUntil("AddItemBtn2");
			CommonWebActions.webClick("AddItemBtn2");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "SDU Modify BB Downgrade  ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
		}
		catch (Exception e)
		{
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		}
	}
	
	
	@Test(priority=5, enabled=true)
	public void TC_005_SDU_ModifyIpTV_Upgrade() throws Exception  
	
	{
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try	 
		{
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.promotioncount("ProdNotEmptyList");
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.waitUntil("ContinueButtne");
			CommonWebActions.webClick("ContinueButtne");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV"), "Customzsearch", "CustmzeBtn");
			CommonWebActions.webClick("CustmzeBtn");		
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));				
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "XDSL Modify IpTV Upgrade Lagom to Stor ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
		}
		catch (Exception e)
		{
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		}
	}
	
	
	@Test(priority=6, enabled=true)
	public void TC_006_SDU_ModifyIpTV_Downgrade() throws Exception  
	
	{
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("testcase:"+testcasename);
		try	 
		{
			CommonWebActions.login();
			CommonWebActions.waitUntil("WelcomeDiv");
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.listnotemptycheck("ProdNotEmptyList");
			CommonWebActions.webSet("SSNTypChos", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("SSNValBox", ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV"));
			CommonWebActions.webClick("PromtnSrchGoBtn");
			CommonWebActions.waitUntil("AccountHierarchyTab");
			App_CommonFunctions.promotioncount("ProdNotEmptyList");
			CommonWebActions.webClick("ModifyBtn");
			CommonWebActions.waitUntil("ContinueButtne");
			CommonWebActions.webClick("ContinueButtne");
			CommonWebActions.waitUntil("SubmitBtn");
			App_CommonFunctions.lineItemCustomize(ExcelUtil.getDataFromExcel(testcasename, "Product_Type"), ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle_IPTV"), "Customzsearch", "CustmzeBtn");
			CommonWebActions.webClick("CustmzeBtn");		
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.webClick("Package_Button");
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.Selectvaluefromdropdown("BrdvoipSpedDrpdown2",
					ExcelUtil.getDataFromExcel(testcasename, "Modify3Speed"));				
			CommonWebActions.waitUntil("DoneBtn1");
			CommonWebActions.javaclick("DoneBtn1");
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.passValuesnSave("ResonCodDrpdwn", ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			CommonWebActions.waitUntil("SubmitBtn");
			CommonWebActions.webClick("SubmitBtn");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			App_CommonFunctions.orderNoFetch("OrderNo");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("DueDate"));
			test.log(Status.PASS, "XDSL Modify IpTV Downgrade Stor to Lagom ["
					+ ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));
			extent.flush();
			CommonWebActions.logout();
		}
		catch (Exception e)
		{
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		}
	}

}
