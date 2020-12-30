/**
 * Manual Testcase Name : XDSL-755 Move BB, VoIP, IPTV services along with change of Platform (ADSL – VDSL)
 * Description of Testcase:
 * Date of Creation: 04-03-2019
 * Reviewed By:
 * Author:QSG460
 * 
 */
package telia.testautomation.move;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class Sprint3_XDSL_MoveADSLtoVDSL extends ExtentManager {

	public static String url = "Test";
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
	public void XDSL_Move_BB_VoIP_IPTV_with_ADSL_VDSL() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : " + Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase : " + testcasename);

		try {

			/*--  Launching URL  --*/
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
			String Speed = ExcelUtil.getDataFromExcel(testcasename, "Speed");

			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link", 80000);
			App_CommonFunctions.SearchServiceAccount(SSN, "Residential");
			System.out.println(SSN);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("FirstName_Link");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("ServiceAcc_Link");
			CommonWebActions.retryingFindClick("ServiceAcc_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AddSearch_Icon");
			CommonWebActions.retryingFindClick("AddSearch_Icon");

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cl = Calendar.getInstance();
			String CurrentDate = inputFormat.format(cl.getTime());
			System.out.println(CurrentDate);
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
			SearchAddressPopup(1, "End Date", CurrentDate);
			CommonWebActions.retryingFindClick("NewAddress_Button");
			CommonWebActions.webSet("StreetName_Field", StreetName);
			CommonWebActions.webSet("City_Field", City);
			CommonWebActions.webSet("Ingång_Field", Ingång);
			CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
			CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.webClick("SearchAdd_Button");
			SelectAddress(PointId);
			CommonWebActions.waitUntil("AddressListOk_Button");
			CommonWebActions.webClick("AddressListOk_Button");
			CommonWebActions.waitUntil("AddSearch_Icon");
			CommonWebActions.retryingFindClick("AddSearch_Icon");
			CommonWebActions.waitUntil("CopperMaxHD_Field");
			CommonWebActions.webClick("CopperMaxHD_Field");
			CommonWebActions.webSet("CopperMaxHDIp", CopperMaxHD);
			CommonWebActions.webClick("CopperMaxSD_Field");
			CommonWebActions.webSet("CopperMaxSDIp", CopperMaxSD);
			CommonWebActions.waitUntil("Shipping_Address");
			CommonWebActions.webClick("Shipping_Address");
			CommonWebActions.webClick("ShippingAddress_CheckBox");
			CommonWebActions.waitUntil("SearchAddOK_Button");
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("CustAcc_Link");
			CommonWebActions.retryingFindClick("CustAcc_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(2000);
//			CommonWebActions.waitUntil("Dropdown_Tab");
			if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
				CommonWebActions.webClick("AcctSummryTab");		
			}else {
				CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
			}
//			CommonWebActions.webClick("AcctSummryTab");	
//			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Account Summary");
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_Broadband);
			CommonWebActions.waitUntil("Installed_Assets_Go_Button");
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.waitUntil("Qty_EditTextbox");
			CommonWebActions.webClick("Qty_EditTextbox");
			CommonWebActions.webSet("Qty_EditTextbox", "0");
			CommonWebActions.javaclick("AddItem_1A_Speed");
			CommonWebActions.waitUntil("Item_1A_speed");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed", Speed);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.waitUntil("Done_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.waitUntil("ServiceBundle_Expand");
			CommonWebActions.javaclick("ServiceBundle_Expand");
			CommonWebActions.javaclick("SelectSpeed_VDSL");


			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 15);
			String newDueDate = inputFormat1.format(cal.getTime());
			System.out.println(newDueDate);
			App_CommonFunctions.NewLineITem(3, "Due", newDueDate);

//			CommonWebActions.webClick("Edit_Tab");
//			CommonWebActions.webClick("Edit_option");
//			CommonWebActions.webClick("ChangeRecord_List");
//			CommonWebActions.waitUntil("EditPopup_Field");
//			CommonWebActions.webSet("EditPopup_Field", Due);
//			CommonWebActions.webSet("EditPopup_Input", newDueDate);
//			CommonWebActions.waitUntil("Value_Ok");
//			CommonWebActions.webClick("Value_Ok");
			CommonWebActions.waitUntil("PortalBtn");

			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_IPTV);
			CommonWebActions.waitUntil("Installed_Assets_Go_Button");
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.webClick("AcssTyp100Chek3");
			// App_CommonFunctions.NewLineITem(4, "Due", null);
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.waitUntil("Package_Tab");
			CommonWebActions.webClick("Package_Tab");
			CommonWebActions.wait(3000);
			CommonWebActions.Selectvaluefromdropdown("Package_Dropdown", "Tv-paket Stor");
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.waitUntil("PortalBtn");

			CommonWebActions.webClick("PortalBtn");
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ProductType);
			CommonWebActions.webSet("InstallAssets_Textdown", Product_VoIP);
			CommonWebActions.waitUntil("Installed_Assets_Go_Button");
			CommonWebActions.webClick("Installed_Assets_Go_Button");
			CommonWebActions.waitUntil("Modify_Button");
			CommonWebActions.webClick("Modify_Button");
			CommonWebActions.webClick("Move_CheckBox");

			cl.add(Calendar.MINUTE, 20);
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);

			CommonWebActions.webSet("MoveDueDate", newtime);
			CommonWebActions.webClick("Continue_Button");
			CommonWebActions.webClick("AcssTyp100Chek2");
            
			App_CommonFunctions.voipphoneBook();
			
//			CommonWebActions.webClick("Number_Tab");
//			CommonWebActions.waitUntil("NumberSearch_GoButton");
//			CommonWebActions.webClick("NumberSearch_GoButton");
//			CommonWebActions.waitUntil("Book_Button");
//			CommonWebActions.webClick("Book_Button");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("Cutomize_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Cutomize_Button");
			CommonWebActions.Selectvaluefromdropdown("ChangeofNumber_DropDown", "VoIP-Change of number-1612");
			CommonWebActions.wait(3000);
			CommonWebActions.javaSet("ChangeofNumber_QTY", "1");
			CommonWebActions.javaclick("ChangeofNumber_Item");
			CommonWebActions.waitUntil("Done_1A_Speed");
			CommonWebActions.javaclick("Done_1A_Speed");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Credit_Check");
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.wait(2000);

//			App_CommonFunctions.refreshComplete("StatusFld",
//					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status",
					App_CommonFunctions.orderNoFetch("SalesOrder_Status"));
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
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
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

		WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title=" + PointID + "]"));
		Input_Data.click();
		CommonWebActions.wait(1000);
	}

	@AfterClass
	public static void teardown() throws Exception {
		CommonWebActions.logout();
	extent.flush();
	CommonWebActions.wd.quit();
	}
}
