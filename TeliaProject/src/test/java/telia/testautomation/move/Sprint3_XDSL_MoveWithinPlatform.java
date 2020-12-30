/**
 * Manual Testcase Name : XDSL-753 Move BB, VoIP, IPTV services as-is on VDSL Platform
 * Description of Testcase:
 * Date of Creation: 04-03-2019
 * Reviewed By:
 * Author:QSG460
 * 
 */package telia.testautomation.move;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @author kaviag
 *
 */
public class Sprint3_XDSL_MoveWithinPlatform extends ExtentManager {

	private static String hostName;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];

	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName",Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("HostName : " + hostName);
	}

	@Test
	public void XDSL_Move_BB_VoIP_IPTV_on_VDSL_Platform() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : " + Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase : " + testcasename);
		try {
			/*--  Launching URL  --*/
			CommonWebActions.login();
			String SSN = ExcelUtil.getDataFromExcel(testcasename, "SSN");
			String StreetName = ExcelUtil.getDataFromExcel(testcasename, "StreetName");
			String City = ExcelUtil.getDataFromExcel(testcasename, "City");
			String Ingång = ExcelUtil.getDataFromExcel(testcasename, "Ingång");
			String PointId = ExcelUtil.getDataFromExcel(testcasename, "PointId");
			String CopperMaxHD = ExcelUtil.getDataFromExcel(testcasename, "CopperMaxHD");
			String CopperMaxSD = ExcelUtil.getDataFromExcel(testcasename, "CopperMaxSD");
			String Product_Broadband = ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband");
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP");
			String Product_IPTV = ExcelUtil.getDataFromExcel(testcasename, "Product_IPTV");
			String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type");
			// CommonWebActions.wait(20*1000);
			CommonWebActions.waitUntilLoaded("MyOrder_link", 80000);
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.SearchServiceAccount(SSN, "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcc_Link");
			CommonWebActions.webClick("ServiceAcc_Link");
			CommonWebActions.waitUntil("AddSearch_Icon");
			CommonWebActions.retryingFindClick("AddSearch_Icon");
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cl = Calendar.getInstance();
			String CurrentDate = inputFormat.format(cl.getTime());
			System.out.println(CurrentDate);
			SearchAddressPopup(1, "End Date",CurrentDate);
			CommonWebActions.webClick("NewAddress_Button");
			CommonWebActions.webSet("StreetName_Field",StreetName);
			CommonWebActions.webSet("City_Field", City);
			CommonWebActions.webSet("Ingång_Field", Ingång);
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.webClick("SearchAdd_Button");
			SelectAddress(PointId);
			CommonWebActions.webClick("AddressListOk_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AddSearch_Icon");
//			CommonWebActions.retryingFindClick("AddSearch_Icon");
//			CommonWebActions.waitUntil("AddSearch_Icon");
			 CommonWebActions.wait(3000);
			CommonWebActions.retryingFindClick("AddSearch_Icon");
			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("CopperMaxHD_Field");
			// CheckBoxValidation(2, "Installation Address");
			// CheckBoxValidation(2, "Shipping Address");
			// CheckBoxValidation(2, "Premise");
			CommonWebActions.webClick("CopperMaxHD_Field");
			CommonWebActions.waitUntil("CopperMaxHDIp");
			CommonWebActions.webSet("CopperMaxHDIp", CopperMaxHD);
			CommonWebActions.waitUntil("CopperMaxSD_Field");
			// CommonWebActions.wait(500);
			CommonWebActions.webClick("CopperMaxSD_Field");
			CommonWebActions.webSet("CopperMaxSDIp", CopperMaxSD);
			// CommonWebActions.wait(500);
			CommonWebActions.waitUntil("Shipping_Address");
			CommonWebActions.webClick("Shipping_Address");
			CommonWebActions.webClick("ShippingAddress_CheckBox");
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("CustAcc_Link");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("CustAcc_Link");
			 CommonWebActions.wait(3000);
			CommonWebActions.waitForLoad1();
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");	
//			CommonWebActions.waitUntil("Dropdown_Tab");
//			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Account Summary");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_Broadband);
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			CommonWebActions.waitUntil("Modify_Button");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.waitUntil("ServiceBundle_Expand");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("ServiceBundle_Expand");
			// SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			// Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE, 15);// adds 8days
			String newDueDate = inputFormat.format(cl.getTime());
			System.out.println(newDueDate);
			
			App_CommonFunctions.NewLineITem(3, "Due", newDueDate);

//			CommonWebActions.webClick("Edit_Tab");
//			CommonWebActions.webClick("Edit_option");
//			CommonWebActions.waitUntil("ChangeRecord_List");
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webClick("ChangeRecord_List");
//			CommonWebActions.waitUntil("EditPopup_Field");
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webSet("EditPopup_Field", Due);
//			CommonWebActions.waitUntil("EditPopup_Input");
//			// CommonWebActions.wait(6000);
//			CommonWebActions.webSet("EditPopup_Input", newDueDate);
//			CommonWebActions.waitUntil("Value_Ok");
			// CommonWebActions.wait(3000);
//			CommonWebActions.webClick("Value_Ok");
			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("PortalBtn");
			CommonWebActions.webClick("PortalBtn");
			// CommonWebActions.wait(1500);
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_IPTV);
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			// CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.waitUntil("PortalBtn");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("PortalBtn");
			// CommonWebActions.wait(1500);
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_VoIP);
			CommonWebActions.waitUntil("Installed_Assets_Go_Button");
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			// CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");
			CommonWebActions.wait(2000);
			// SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// Date date =
			// inputFormat1.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, 20);
			String newtime = inputFormat.format(cal.getTime());
			System.out.println(newtime);

			CommonWebActions.webSet("MoveDueDate", newtime);
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.waitUntil("Credit_Check");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.savePage();
			CommonWebActions.waitUntil("SalesOrder_Submit");
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(3000);
			
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

	
	
	public void SearchAddressPopup(int rowno, String Columnname, String StrTexttoSend) throws Exception {
		List<WebElement> column = CommonWebActions.wd
				.findElements(By.xpath("(//table[@class='ui-jqgrid-htable'])[4]/thead/tr/th"));
		int Line_Item_Column_Count = column.size();
		List<WebElement> LineItem_Data = CommonWebActions.wd.findElements(
				By.xpath("//table[@class='ui-jqgrid-btable' and @summary ='Account Addresses']//tbody//tr[@id=" + rowno
						+ "]/td"));
		for (int i = 0; i < Line_Item_Column_Count; i++) {
			String Column_Name = column.get(i).getText();
			if ((Columnname).trim().equalsIgnoreCase(Column_Name.trim())) {
				WebElement objName = LineItem_Data.get(i);
				CommonWebActions.javaSet2(objName, StrTexttoSend);
				System.out.println(Columnname + ":" + StrTexttoSend);
				CommonWebActions.wait(1000);
			}
		}
	}

	public void SelectAddress(String PointID) throws Exception {
		CommonWebActions.waitForLoad1();
		WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title="+PointID+"]"));
		Input_Data.click();
		CommonWebActions.wait(1000);
	}

	// public void CheckBoxValidation(int rowno,String Columnname) throws
	// Exception{
	// List<WebElement> column =
	// CommonWebActions.wd.findElements(By.xpath("(//table[@class='ui-jqgrid-htable'])[4]/thead/tr/th"));
	// int Line_Item_Column_Count = column.size();
	// List<WebElement> LineItem_Data =
	// CommonWebActions.wd.findElements(By.xpath("//table[@class='ui-jqgrid-btable'
	// and @summary ='Account Addresses']//tbody//tr[@id="+rowno+"]/td"));
	// for(int i=0;i<Line_Item_Column_Count;i++){
	// String Column_Name = column.get(i).getText();
	// if((Columnname).trim().equalsIgnoreCase(Column_Name.trim())){
	// WebElement objName=LineItem_Data.get(i);
	// objName.click();
	// if(objName.findElement(By.xpath(objName + "/span/input")).isSelected()){
	// System.out.println( Columnname + "is Selected");
	// }
	// else{
	// objName.findElement(By.xpath(objName + "/span/input")).click();
	// System.out.println( Columnname + "is Selected");
	// }
	// CommonWebActions.wait(1000);
	// }
	// }
	// }
	
	@AfterClass
	public static void teardown() throws Exception {
		CommonWebActions.logout();
	extent.flush();
	CommonWebActions.wd.quit();
	}

}
