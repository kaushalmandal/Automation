package telia.testautomation.move;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

public class Sprint4_MDUMove extends ExtentManager{
	
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	
	
	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
			ORUtil.setValue("testDataWorkSheetName", Packagename);
			
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
	
	@Test(priority =1,enabled =false)
	public void Move_MDU_uppgrade_newaria() throws Exception {
				
		ExtentManager.startReporting(new Object(){
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : "+ Packagename);
		String testcasename = (new Object(){
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase :"+testcasename);
				
		try {
			
	/*--  Launching URL  --*/
		String SSN = ExcelUtil.getDataFromExcel(testcasename,"SSN");
		String StreetName = ExcelUtil.getDataFromExcel(testcasename,"StreetName");
		String City = ExcelUtil.getDataFromExcel(testcasename,"City");
		String PointId = ExcelUtil.getDataFromExcel(testcasename,"PointId");
		String Product_Broadband =ExcelUtil.getDataFromExcel(testcasename,"Product_Broadband");
		String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename,"Product_VoIP");
		String ProductType = ExcelUtil.getDataFromExcel(testcasename,"Product_Type");
		String Due = ExcelUtil.getDataFromExcel(testcasename,"FieldDue");
		String UpdradePromotion = ExcelUtil.getDataFromExcel(testcasename,"Upgrade_Promotion");
		String Street_Number = ExcelUtil.getDataFromExcel(testcasename,"StreetNo");
		String Apartment_Num = ExcelUtil.getDataFromExcel(testcasename,"ApartNO");
		System.out.println(UpdradePromotion);
		CommonWebActions.login();
		CommonWebActions.waitUntilLoaded("MyOrder_link",50000);
		App_CommonFunctions.SearchServiceAccount(SSN,"Business");
		System.out.println(SSN);
		CommonWebActions.wait(5000);
		CommonWebActions.javaclick("FirstName_Link");
		CommonWebActions.webClick("AccHierarchy_Tab");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("ServiceAcc_Link");
		CommonWebActions.wait(3000);
		CommonWebActions.webClick("AddSearch_Icon");
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cl = Calendar.getInstance();
		String CurrentDate = inputFormat.format(cl.getTime());
		System.out.println(CurrentDate);
	    SearchAddressPopup(1,"End Date",CurrentDate);
	    CommonWebActions.webClick("NewAddress_Button");
		CommonWebActions.waitUntil("StreetName_Field");
		CommonWebActions.webSet("StreetName_Field",StreetName);
//		CommonWebActions.waitUntil("Street_Number");
		CommonWebActions.webSet("Street_Number",Street_Number);
        CommonWebActions.webSet("Apartment_Number",Apartment_Num);
	    CommonWebActions.webSet("City_Field",City);
	    CommonWebActions.webClick("AddressType_Dropdown");
		CommonWebActions.webClick("AddressType_List");
		CommonWebActions.waitUntil("SearchAdd_Button");
		CommonWebActions.webClick("SearchAdd_Button");
	 	SelectAddress(PointId);
		CommonWebActions.wait(1000);
		CommonWebActions.retryingFindClick("AddressListOk_Button");
		CommonWebActions.wait(1000);
		CommonWebActions.waitUntil("AddSearch_Icon");
		CommonWebActions.retryingFindClick("AddSearch_Icon");
		CommonWebActions.wait(3000);
	    CommonWebActions.webClick("Shipping_Address");
        CommonWebActions.webClick("ShippingAddress_CheckBox");
		CommonWebActions.wait(1000);
		CommonWebActions.webClick("SearchAddOK_Button");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("AccHierarchy_Tab");
		CommonWebActions.wait(3000);
	    CommonWebActions.webClick("CustAcc_Link");
        CommonWebActions.wait(3000);
        CommonWebActions.waitForLoad1();
        if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
             CommonWebActions.webClick("AcctSummryTab");          
        }else {
             CommonWebActions.Selectvaluefromdropdown("MoreTabs", "Account Summary");
        }
        CommonWebActions.webSet("InstallAssets_Dropdown",ProductType);
        CommonWebActions.webSet("InstallAssets_Textdown",Product_Broadband);
		CommonWebActions.waitUntil("Installed_Assets_Go_Button");
		CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
		CommonWebActions.waitUntil("Promotion_BroadBand");
		CommonWebActions.webClick("Promotion_BroadBand");
		
		CommonWebActions.waitUntil("Settings");
		CommonWebActions.webClick("Settings");
		CommonWebActions.passWithoutClear("UpgradePromotion_Button", "");
		CommonWebActions.wait(2000);
		CommonWebActions.webSet("Promotion_Upgrade",UpdradePromotion);
		CommonWebActions.waitUntil("Move_Upgrade");
		CommonWebActions.webClick("Move_Upgrade");
		CommonWebActions.waitUntil("PortalBtn");
        CommonWebActions.webClick("PortalBtn");
        CommonWebActions.waitUntil("InstallAssets_Dropdown");
		CommonWebActions.webSet("InstallAssets_Dropdown",ProductType);
		CommonWebActions.webSet("InstallAssets_Textdown",Product_VoIP);
		CommonWebActions.waitUntil("Installed_Assets_Go_Button");
        CommonWebActions.webClick("Installed_Assets_Go_Button");
        CommonWebActions.waitUntil("Promotion_Move_Voip");
		CommonWebActions.webClick("Promotion_Move_Voip");
		
        CommonWebActions.waitUntil("Modify_Button");
		CommonWebActions.webClick("Modify_Button");
		CommonWebActions.webClick("Move_CheckBox");
		CommonWebActions.wait(2000);
		
		SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = new Date();
		String newtime= inputFormat1.format(d1);
		System.out.println(newtime);
		CommonWebActions.webSet("MoveDueDate",newtime);
		CommonWebActions.webClick("Continue_Button");
		CommonWebActions.webClick("LI_Voip");
        App_CommonFunctions.voipphoneBook();
		CommonWebActions.waitUntil("Credit_Check");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("Credit_Check");
		CommonWebActions.savePage();
		CommonWebActions.waitUntil("SalesOrder_Submit");
		CommonWebActions.webClick("SalesOrder_Submit");
		CommonWebActions.wait(3000);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
				App_CommonFunctions.orderNoFetch("OrderNo"));
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
				App_CommonFunctions.orderNoFetch("Due_value1"));
		CommonWebActions.wait(3000);
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
		System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
		CommonWebActions.logout();
	} catch (Exception e) {
		CommonWebActions.closeAlerts();
		test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
		}.getClass().getEnclosingMethod().getName()) + ":"
				+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
		ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
		ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status","FAIL");
		ALMTestfactory.updateResults("E2EMM Automation", "Sprint4",39921, testcasename, "Fail");
		e.printStackTrace();
		e.getMessage();
	}

}
	
	
	
	@Test(priority =2,enabled =true)
	public void Move_MDU_downgrade_samearia() throws Exception {
				
		ExtentManager.startReporting(new Object(){
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : "+ Packagename);
		String testcasename = (new Object(){
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase :"+testcasename);
				
		try {
			/*--  Launching URL  --*/
			String SSN = ExcelUtil.getDataFromExcel(testcasename,"SSN");
			String StreetName = ExcelUtil.getDataFromExcel(testcasename,"StreetName");
			String City = ExcelUtil.getDataFromExcel(testcasename,"City");
			String PointId = ExcelUtil.getDataFromExcel(testcasename,"PointId");
			String Product_Broadband =ExcelUtil.getDataFromExcel(testcasename,"Product_Broadband");
			String ServiceBundle_Broadband=ExcelUtil.getDataFromExcel(testcasename,"ServiceBundle_Broadband");
			String Product_VoIP = ExcelUtil.getDataFromExcel(testcasename,"Product_VoIP");
			String ServiceBundle_Voip=ExcelUtil.getDataFromExcel(testcasename,"ServiceBundle_VoIP");
			String ProductType = ExcelUtil.getDataFromExcel(testcasename,"Product_Type");
			String Due = ExcelUtil.getDataFromExcel(testcasename,"FieldDue");
			String UpdradePromotion = ExcelUtil.getDataFromExcel(testcasename,"Upgrade_Promotion");
			String Street_Number = ExcelUtil.getDataFromExcel(testcasename,"StreetNo");
			String Apartment_Num = ExcelUtil.getDataFromExcel(testcasename,"ApartNO");
			System.out.println(UpdradePromotion);
			CommonWebActions.login();
			CommonWebActions.waitUntilLoaded("MyOrder_link",50000);
			App_CommonFunctions.SearchServiceAccount(SSN,"Business");
			System.out.println(SSN);
			CommonWebActions.wait(5000);
			CommonWebActions.javaclick("FirstName_Link");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("ServiceAcc_Link");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("AddSearch_Icon");
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cl = Calendar.getInstance();
			String CurrentDate = inputFormat.format(cl.getTime());
			System.out.println(CurrentDate);
			SearchAddressPopup(1,"End Date",CurrentDate);
		    CommonWebActions.webClick("NewAddress_Button");
			CommonWebActions.waitUntil("StreetName_Field");
			CommonWebActions.webSet("StreetName_Field",StreetName);
			CommonWebActions.waitUntil("Street_Number");
			CommonWebActions.webSet("Street_Number",Street_Number);
			CommonWebActions.waitUntil("Apartment_Number");
			CommonWebActions.webSet("Apartment_Number",Apartment_Num);
			CommonWebActions.waitUntil("City_Field");
			CommonWebActions.webSet("City_Field",City);
		    CommonWebActions.webClick("AddressType_Dropdown");
			CommonWebActions.webClick("AddressType_List");
			CommonWebActions.waitUntil("SearchAdd_Button");
			CommonWebActions.webClick("SearchAdd_Button");
		 	SelectAddress(PointId);
			CommonWebActions.wait(1000);
			CommonWebActions.retryingFindClick("AddressListOk_Button");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("AddSearch_Icon");
			CommonWebActions.retryingFindClick("AddSearch_Icon");
			CommonWebActions.wait(1000);
			CommonWebActions.waitUntil("Shipping_Address");
		    CommonWebActions.webClick("Shipping_Address");
		    CommonWebActions.waitUntil("ShippingAddress_CheckBox");
	        CommonWebActions.webClick("ShippingAddress_CheckBox");
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("SearchAddOK_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.wait(3000);
		    CommonWebActions.webClick("CustAcc_Link");
	        CommonWebActions.wait(3000);
	        CommonWebActions.waitForLoad1();
	        if(CommonWebActions.wd.findElements( By.xpath("//a[text()='Account Summary']")).size() != 0) {
	             CommonWebActions.webClick("AcctSummryTab");          
	        }else {
	             CommonWebActions.Selectvaluefromdropdown("MoreTabs","Account Summary");
	        }
	        /*--Modifying the Broadband Product --*/
	        CommonWebActions.webSet("InstallAssets_Dropdown",ProductType);
	        CommonWebActions.webSet("InstallAssets_Textdown",Product_Broadband);
			CommonWebActions.waitUntil("Installed_Assets_Go_Button");
			CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
			
		//	CommonWebActions.waitUntil("Promotion_BroadBand");
		//	CommonWebActions.webClick("Promotion_BroadBand");
			CommonWebActions.waitUntil("Modify_Button");
		    CommonWebActions.webClick("Modify_Button");
		    CommonWebActions.wait(2000);
		    
			 SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     Date d1 = new Date();
		     String newtime= inputFormat1.format(d1);
			 System.out.println(newtime);
			 CommonWebActions.webSet("MoveDueDate",newtime);
			 CommonWebActions.waitUntil("Move_CheckBox");
			 CommonWebActions.webClick("Move_CheckBox");
			 CommonWebActions.waitUntil("Continue_Button");
			 CommonWebActions.webClick("Continue_Button");
			 CommonWebActions.wait(6000);
	
			//App_CommonFunctions.lineItemCustomize(ProductType,ServiceBundle_Broadband,"Customzsearch","Cutomize_Button");
			 CommonWebActions.webSet("LineTyp",ProductType);
			 CommonWebActions.webSet("LinePromo",ServiceBundle_Broadband);
			 CommonWebActions.wait(2000);
			 CommonWebActions.webClick("Customzsearch");
			 
			 CommonWebActions.wait(4000);
     		 CommonWebActions.webClick("Cutomize_Button");
			 CommonWebActions.wait(2000);
		     CommonWebActions.fnHighlightMe("Qty_Editbox");
			 CommonWebActions.webClick("Qty_EditTextbox");
			 CommonWebActions.webSet("Qty_EditTextbox","0");
				Thread.sleep(2000);
				CommonWebActions.javaclick("AddItem_1A_Speed");
				CommonWebActions.wait(5000);
				CommonWebActions.Selectvaluefromdropdown("Item_1A_speed",ExcelUtil.getDataFromExcel(testcasename,"Speed"));
				CommonWebActions.javaSet("Qty_1A_Speed","1");
				CommonWebActions.javaclick("AddItem_1A_Speed");
				CommonWebActions.wait(3000);
				CommonWebActions.javaclick("Done_1A_Speed");
				CommonWebActions.wait(1000);
			
				
				/*--Modifying the Voip Number-- */
				CommonWebActions.waitUntil("PortalBtn");
				CommonWebActions.webClick("PortalBtn");
				CommonWebActions.webSet("InstallAssets_Dropdown",ProductType);
		        CommonWebActions.webSet("InstallAssets_Textdown",Product_VoIP);
				CommonWebActions.waitUntil("Installed_Assets_Go_Button");
				CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
				CommonWebActions.waitUntil("Modify_Button");
			    CommonWebActions.webClick("Modify_Button");
			    CommonWebActions.wait(2000);
			    
			    cl.add(Calendar.DATE,5);// adds 8days
				String futuredate = inputFormat.format(cl.getTime());
				System.out.println(futuredate);
				 CommonWebActions.webSet("MoveDueDate",futuredate);
				 CommonWebActions.waitUntil("Move_CheckBox");
				 CommonWebActions.webClick("Move_CheckBox");
				 CommonWebActions.waitUntil("Continue_Button");
				 CommonWebActions.webClick("Continue_Button");
				 CommonWebActions.wait(6000);
				 CommonWebActions.webSet("LineTyp",ProductType);
				 CommonWebActions.webSet("LinePromo",ServiceBundle_Voip);
				 CommonWebActions.wait(2000);
				 CommonWebActions.webClick("Customzsearch");
			     CommonWebActions.wait(4000);
			       App_CommonFunctions.voipphoneBook();
					CommonWebActions.waitUntil("Credit_Check");
					CommonWebActions.wait(2000);
					CommonWebActions.webClick("Credit_Check");
					CommonWebActions.savePage();
					CommonWebActions.waitUntil("SalesOrder_Submit");
					CommonWebActions.webClick("SalesOrder_Submit");
					CommonWebActions.wait(3000);
					ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
							App_CommonFunctions.orderNoFetch("OrderNo"));
					ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
							App_CommonFunctions.orderNoFetch("Due_value1"));
					CommonWebActions.wait(3000);
					ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
					System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
					ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
					ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, testcasename, "Not Completed");
					CommonWebActions.logout();
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status","FAIL");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint5",39921, testcasename, "Fail");
			e.printStackTrace();
			e.getMessage();
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
	
	public void SelectAddress(String PointID) throws Exception{
		
		WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title="+PointID+"]"));
		Input_Data.click();
		CommonWebActions.wait(1000);
	}
	

	
}



