package telia.testautomation.migration;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

public class OrderStatusChange extends ExtentManager {

private String actual_StatusXL;
String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
@BeforeTest
	public void init() {
		String hostName;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	
@Test(enabled=true)
	public void Migrationcheck() throws Exception {
		 String OutputSheet="Test_Output";
		 String InputSheet="Regression_Test_Data";
		//--  Intializing Reporting --	//
		 
				ExtentManager.startReporting(new Object() {
				}.getClass().getEnclosingMethod().getName(),Packagename);
				
				int Rw_cnt_Output=ExcelUtil.getRowCount(OutputSheet);
				int Rw_cnt_Input=ExcelUtil.getRowCount(InputSheet);
				loop:
				for (int i=2;i<=Rw_cnt_Output;i++){
					String TCNameinOutputSheet=ExcelUtil.getCellData(OutputSheet, "Test_Case", i);
					if (ExcelUtil.getCellData(OutputSheet, "Due_Date", i).isEmpty()){
//						break;	
					}
					String DueDate=ExcelUtil.getCellData(OutputSheet, "Due_Date", i);
					if (!DueDate.isEmpty()){
					String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date ADueDate = sdf.parse(DueDate);
					Date end = sdf.parse(endDate);
//					System.out.println(ADueDate.before(end));
					
		             if ((ADueDate.compareTo(end) < 0) || (ADueDate.compareTo(end) == 0)) {
		            }  else {
		            	ExcelUtil.setDatatoExcel(OutputSheet, TCNameinOutputSheet, "Status","PENDING");
		            	continue;
		            }
					
					for (int j=2;j<=Rw_cnt_Input;j++){
//						if (ExcelUtil.getCellData(InputSheet, "Test_Case",j).equalsIgnoreCase(TCNameinOutputSheet)){
							if (!ExcelUtil.getCellData(OutputSheet, "Order_Number",j).isEmpty()){
							CommonWebActions.launch();
							actual_StatusXL = ExcelUtil.getCellData(OutputSheet, "Expected_Final_Status",j);
//							continue;
							CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
							CommonWebActions.webClick("MyOrder_link");
//							CommonWebActions.Selectvaluefromdropdown("Order_list","All Sales Orders");
							 WebDriverWait wait = new WebDriverWait (CommonWebActions.wd, 30);
							 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text'][@aria-label='Find']"))).click();
//							CommonWebActions.waituntilElementToBeClickable("Order_Type");
							CommonWebActions.webSet("Order_Type", "Order #");
							System.out.println(ExcelUtil.getCellData(OutputSheet, "Order_Number",j+1));
							CommonWebActions.webSet("Order_number",ExcelUtil.getCellData(OutputSheet, "Order_Number",j) );
							CommonWebActions.webClick("Order_Search");
							CommonWebActions.wait(2000);
//							WebDriverWait wait = new WebDriverWait (CommonWebActions.wd, 30);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='Order Number']")));
//							CommonWebActions.waituntilElementToBeClickable("FirstName_Link");
							CommonWebActions.webClick("Orderno_link");
							CommonWebActions.waituntilElementToBeClickable("Order_Detail");
							CommonWebActions.webClick("Order_Detail");
//							CommonWebActions.fnHighlightMe("Order_Status_Label");
							String ExpectedStatus_AUT=CommonWebActions.webGetAttribute("Order_Status", "value");
							System.out.println(ExpectedStatus_AUT);
							System.out.println(actual_StatusXL);
							String Fulfilment_Status=CommonWebActions.webGetAttribute("Order_Fulfilmentstatus", "value");
//							System.out.println(Fulfilment_Status);
							if ((actual_StatusXL).trim().equalsIgnoreCase(ExpectedStatus_AUT.trim())){
								test.log(Status.PASS,"Order Number:"+ExcelUtil.getCellData(OutputSheet, "Due_Date", i));
								ExcelUtil.setDatatoExcel(OutputSheet, TCNameinOutputSheet, "Status","PASS");
//								break loop;
								///Update Pass to ALM 
								ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
								ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 39921,TCNameinOutputSheet,"Pass" );
							
							}else if (ExpectedStatus_AUT.equalsIgnoreCase("Failed")) {
								ExcelUtil.setDatatoExcel(OutputSheet, TCNameinOutputSheet, "Status","FAIL");
								ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
								ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 39921,TCNameinOutputSheet,"Fail" );
								
								//Update FAIL to ALM
							}else {
								ExcelUtil.setDatatoExcel(OutputSheet, TCNameinOutputSheet, "Status","FAIL");
								ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
								ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 39921,TCNameinOutputSheet,"Not Completed" );
								//Update NOt completed to ALM
							}
							 CommonWebActions.wd.quit();
						}
//						}
						}
					}
						
					
					
					
//					String ExpectedStatus_AUT=CommonWebActions.webGetAttribute("","");
//					String ExpectedStatus_AUT="Completed";
									}
	}
	
	@AfterTest
	public void logOut() {
//		 extent.flush();
//		 CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		 extent.flush();
		 CommonWebActions.wd.quit();
	}
	
	
	
}
