//package applicationSpecific;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.NoSuchElementException;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.configuration.ConfigurationException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.FluentWait;
//
//import com.google.common.base.Function;
//
//import coreFramework.CommonWebActions;
//import coreFramework.CommonWindowsActions;
//import coreFramework.ExcelUtil;
//import coreFramework.ORUtil;
//import coreFramework.ReportUtil;
//import coreFramework.SeleniumUtils;
//
///**
// * This class consists of methods specific to application under test
// * 
// * @author Nagaraj Jayagondra
// * @version 1.0
// * @since 10-Dec-2015
// */
//
//public class AUT {
//
//	public static long startTime, startTimeI, startTimeRR;
//	public static long stopTime, stopTimeI, stopTimeRR;
//	public static HashMap<String, Long> executionTimes = new LinkedHashMap<>();
//	public static long EXECUTION_FAILURE_TIME = 888888;
//	public static long EXECUTION_FAILURE_MAX = 999999;
//	public static String processID;
//	public static String packageNumber;
//	public static String crTitle;
//	private static String initialTaskRowId = null;
//	public static String urlPropertyKey;
//	private static String shellOverviewURL;
////	public static ArrayList<STATEMENTS> statementsToRun;
//	public static WebDriver wd = null;
//
////	private static ArrayList<Consolidationviewstmts> statementsToRunCV;
//
///*	public AUT(ArrayList<STATEMENTS> statementsToRun) {
//		// TODO Auto-generated constructor stub
//		AUT.statementsToRun = statementsToRun;
//	}
//
//	public ArrayList<STATEMENTS> getStatementsToRun() {
//		return statementsToRun;
//
//	}
//
//	public ArrayList<Consolidationviewstmts> getStatementsToRun1() {
//		return statementsToRunCV;
//
//	}
//*/
//	public static void EDCmontoring(String strEnvURL) {
//		try {
//
//			CommonWebActions.launch();
//
//			CommonWebActions.webVerifyInnerText("Applicationinformation", "Applicationinformation");
//			CommonWebActions.webVerifyInnerText("Applicationdetails", "Applicationdetails");
//			CommonWebActions.wait(5000);
//			CommonWebActions.webClick("Applicationinformation");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.back();
//			CommonWebActions.wait(5000);
//			CommonWebActions.webClick("Applicationdetails");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.webVerifyInnerText("ICMExternalServiceEndpoint", "ICMExternalServiceEndpoint");
//			CommonWebActions.webVerifyInnerText("ICMMOCKUPSERVICE", "ICMMOCKUPSERVICE");
//			CommonWebActions.webVerifyInnerText("EngBusEndPointAddress", "EngBusEndPointAddress");
//			CommonWebActions.webVerifyInnerText("ICMRealServiceEndpoint", "ICMRealServiceEndpoint");
//			CommonWebActions.webVerifyInnerText("ICMAppServiceEndpoint", "ICMAppServiceEndpoint");
//			CommonWebActions.webVerifyInnerText("GlobusEndPointAddress", "GlobusEndPointAddress");
//			CommonWebActions.webVerifyInnerText("ICMMAINDS", "ICMMAINDS");
//			CommonWebActions.webVerifyInnerText("TeamWorksDB", "TeamWorksDB");
//			CommonWebActions.webVerifyInnerText("PerformanceDB", "PerformanceDB");
//
//			ReportUtil.reporterEvent("pass", "EDC Monitoring Success" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void Verifytasklogin() {
//		// AUT.urlPropertyKey = strEnvURL;
//		try {
//
//			FileInputStream loginFile = new FileInputStream(
//					new File("C:\\ICM\\latest project\\icm.testautomation.project\\src\\test\\resources\\testData\\TestData_CGSCDIT41492678.xlsx"));
//
//			System.out.println("abc");
//
//			// Get the workbook instance for xlsx file
//			XSSFWorkbook workbook = new XSSFWorkbook(loginFile);
//
//			// Get the first sheet of the xlsx file
//			XSSFSheet sheet = workbook.getSheet("TESTDATA1");
//
//			// Iterate through each row from first sheet
//			Iterator<Row> rowIterator = sheet.iterator();
//
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//
//				// For each row iterate through each columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//
//				while (cellIterator.hasNext()) {
//
//					Cell cell = cellIterator.next();
//					if (cell.equals("task-url"))
//
//					{
//						String a = cell.getStringCellValue();
//						System.out.println(a);
//						wd.get(a);
//
//					} else
//
//						System.out.println("**********User login failure**********");
//				}
//				break;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void login(String strEnvURL, String strUserName, String strPassword) {
//		AUT.urlPropertyKey = strEnvURL;
//		try {
//
//			startTime = System.currentTimeMillis();
//			System.out.println("startTime" + startTime);
//			CommonWebActions.launch();
//			stopTime = System.currentTimeMillis();
//			System.out.println("stopTime" + stopTime);
//			executionTimes.put("LoginPageLoad", stopTime - startTime);
//
//			System.out.println(stopTime - startTime);
//
//			CommonWebActions.waituntil("txtuserid");
//			// CommonWebActions.webSetFromXls("txtuserid", strUserName, true);
//
//			CommonWebActions.waituntil("txtPassword");
//			// CommonWebActions.webSetFromXls("txtPassword", strPassword, true);
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("btnLogin");
//
//			CommonWebActions.webClick("btnLogin");
//
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("login", stopTime - startTime);
//			ReportUtil.reporterEvent("pass", "Login Success");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	
//
//	private static String getProcessID(String objName) {
//		WebElement lwebElement = null;
//		String ProcessID1 = null;
//		try {
//			lwebElement = CommonWebActions.findElement(objName);
//			System.out.println(lwebElement);
//			ProcessID1 = lwebElement.getText();
//			System.out.println(ProcessID1);
//			ProcessID1 = ProcessID1.substring("1.1 Initiation (Set up Request):".length());
//			System.out.println(ProcessID1);
//
//		} catch (Exception e) {
//			ReportUtil.reporterEvent("fail", "Web Element [ " + objName + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
//		}
//		return ProcessID1;
//	}
//
//	public static void initiateProcess() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("strIcmLink");
//			CommonWebActions.webClick("strIcmLink");
//
//			// CommonWebActions.webMouseHover1();//(for MBRDI DEV)
//
//			CommonWebActions.waituntil("ProcessID");
//			CommonWebActions.wait(3000);
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("initiateProcess", stopTime - startTime);
//			CommonWebActions.switchToDefaultContent();
//
//			processID = getProcessID("ProcessID");
//			System.out.println(processID);
//			processID = processID.replaceAll("[^0-9.]", "");
//			System.out.println(processID);
//
//			CommonWebActions.switchToDefaultContent();
//			//CommonWebActions.switchToiFrame1("iframeString2");
//
//			System.out.println("switched to frame1");
//			CommonWebActions.wait(3000);
//
//			packageNumber = CommonWebActions.getPackageNumber("PackageNumber");
//
//			System.out.println(packageNumber);
//			CommonWebActions.wait(5000);
//			ExcelUtil.setDatatoExcel(CommonWebActions.onlyTestCaseName, "packageNumber", packageNumber);
//
//			String url = ORUtil.getConfigValue(urlPropertyKey);
//			shellOverviewURL = url + "/icmres/shelloverview/" + packageNumber;
//			System.out.println("Link to shell overview: " + shellOverviewURL);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	private static void writeReportOverviewSummaryLine(String crTitle1) {
//		// logging the PackageNumber to an overview-file
//		String pathnameReportOverview = ReportUtil.getReportPath() + "\\Report-Overview.txt";
//		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathnameReportOverview), true))) {
//			String overviewLogEntry = packageNumber + " " + processID + " " + ReportUtil.getReportTime() + " " + crTitle1 + " " + shellOverviewURL + "\n";
//			bw.append(overviewLogEntry);
//			bw.close();
//			System.out.println("Added following " + overviewLogEntry + " to " + pathnameReportOverview);
//		} catch (IOException ex) {
//			System.out.println(ex.toString());
//		}
//	}
//
//	public static void fillCRInfo() {
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//			//CommonWebActions.switchToiFrame1("iframeString2");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("protyp");
//			// CommonWebActions.webSetFromXls("protyp", "ProductType");
//			//JavascriptExecutor jse=(JavascriptExecutor)wd;
//			//jse.executeScript("window.scrollBy(0,100)", "");
//			CommonWebActions.waituntil("PackageResponsible");
////			jse.executeScript("window.scrollBy(0,-100)", "");
//			// CommonWebActions.webSetFromXls("PackageResponsible", "Addtionalpacpersonid", true);
//			CommonWebActions.wait(4000);
//			CommonWebActions.waituntil("PackageResponsibledropdown");
//			CommonWebActions.webClick("PackageResponsibledropdown");
//			// CommonWebActions.webSetFromXls("ShellResponsible", "Addtionalpacpersonid", true);
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ShellResponsibledropdown");
//			CommonWebActions.webClick("ShellResponsibledropdown");
//
//			/*
//			 * CommonWebActions.webClick("packRespSearch");
//			 * CommonWebActions.waituntilTileContains("Roles and Rights");
//			 * 
//			 * CommonWebActions.webClick("packRespSearch2");
//			 * 
//			 * CommonWebActions.waituntil("PackageUser");
//			 * CommonWebActions.webClick("PackageUser");
//			 * 
//			 * CommonWebActions.waituntil("Searchuser");
//			 * CommonWebActions.webClick("Searchuser");
//			 * 
//			 * CommonWebActions.waituntil("AllLink");
//			 * CommonWebActions.webClick("AllLink");
//			 * 
//			 * CommonWebActions.SelectUser("Username2", "attribute",
//			 * "valueToSet1", "valueToSet");
//			 * 
//			 * CommonWebActions.waituntil("packRespSubmit");
//			 * CommonWebActions.webClick("packRespSubmit");
//			 */
//
//			// CommonWebActions.ICMclick("packRespSubmit");
//
//			// CommonWebActions.waituntil("SubmitChangeRequest");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("RolesAndRights-PackageResponsible", stopTime - startTime);
//
//			CommonWebActions.switchToDefaultContent();
//
//			//CommonWebActions.switchToiFrame1("iframeString2");
//			CommonWebActions.waituntil("reqtext");
//
//			startTime = System.currentTimeMillis();
//
//			// CommonWebActions.webSetFromXls("reqtext", "RequestType");
//			
//			CommonWebActions.waituntil("PackageResponsible");
////			jse.executeScript("window.scrollBy(0,-100)", "");
//			// CommonWebActions.webSetFromXls("PackageResponsible", "Addtionalpacpersonid", true);
//			CommonWebActions.wait(4000);
//			CommonWebActions.waituntil("PackageResponsibledropdown");
//			CommonWebActions.webClick("PackageResponsibledropdown");
//			
//			String crTitleFromXls = ExcelUtil.getDataFromExcel(CommonWebActions.onlyTestCaseName, "CRTitle");
//			String crTitle1 = crTitleFromXls + "_" + ReportUtil.getReportTime();
//
//			ExcelUtil.setDatatoExcel(CommonWebActions.onlyTestCaseName, "Initialpackagetitle", crTitle1);
//
//			CommonWebActions.webSet("titleobj", crTitle1);
//			// CommonWebActions.webSetFromXls("strProbDesc", "ProbDescription");
//
//			writeReportOverviewSummaryLine(crTitle1);
//
//			CommonWebActions.waituntil("Interdisciplinary_TeamsEditbutton");
//			CommonWebActions.webClick("Interdisciplinary_TeamsEditbutton");
//
//			CommonWebActions.waituntil("Interdisciplinary_Teams");
//			CommonWebActions.webClick("Interdisciplinary_Teams");
//
//			CommonWebActions.waituntil("updateInterdisciplinaryTeamsbutton");
//			CommonWebActions.webClick("updateInterdisciplinaryTeamsbutton");
//
//			CommonWebActions.waituntil("ProjectNamesEditbutton");
//			CommonWebActions.webClick("ProjectNamesEditbutton");
//		//	CommonWebActions.ICMclick("ProjectNamesEditbutton");
//
//			CommonWebActions.waituntil("SelectProject");
//			CommonWebActions.webClick("SelectProject");
//
//			CommonWebActions.waituntil("UpdateProjects");
//			CommonWebActions.webClick("UpdateProjects");
//
//			CommonWebActions.waituntil("AffectedLocations");
//			CommonWebActions.webClick("AffectedLocations");
//			// CommonWebActions.webSet1("AffectedLocations", "AffectedLocations");
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("AffectedLocations");
//
//			CommonWebActions.waituntil("TriggerText");
//
//			// CommonWebActions.webSetFromXls("TriggerText", "Trigger");
//
//			CommonWebActions.waituntil("SubTriggerText");
//
//			// CommonWebActions.webSetFromXls("SubTriggerText", "SubTrigger");
//
//			CommonWebActions.wait(2000);
//
//			CommonWebActions.waituntil("ZeusNumbertext");
//
//			// CommonWebActions.webSetFromXls("ZeusNumbertext", "ZeusNumbertext");
//
//			// CommonWebActions.webSet("Risk_of_non-implementation",
//			// "Risk_of_non-implementation");
//
//			// CommonWebActions.webSet("Related_Shell_numbers",
//			// "Related_Shell_numbers");
//
//			// CommonWebActions.webIcmDropDown("TriggerText", "Trigger");
//			// CommonWebActions.webIcmDropDown("SubTriggerText", "SubTrigger");
//			// CommonWebActions.wait(2000);
//			// CommonWebActions.webIcmDropDown("ZeusNumbertext",
//			// "ZeusNumbertext");
//
//			// CommonWebActions.waituntil("ProjectnamesTextarea");
//			// CommonWebActions.webClick("ProjectnamesTextarea");
//
//			// CommonWebActions.waituntil("ProjectNamesEditbutton");
//
//			/*
//			 * CommonWebActions.waituntil("SelectAllButton");
//			 * CommonWebActions.webClick("SelectAllButton");
//			 * 
//			 * CommonWebActions.waituntil("DeselectAllButton");
//			 * CommonWebActions.webClick("DeselectAllButton");
//			 */
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillCRInfo", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void Fasttrack() {
//
//		try {
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.switchToiFrame(1);
//			CommonWebActions.waituntil("fasttrackRequested_yes");
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("fasttrackRequested_yes");
//			CommonWebActions.waituntil("fasttrack_Reason");
//			// CommonWebActions.webSetFromXls("fasttrack_Reason", "fasttrack_Reason");
//			// CommonWebActions.webSetFromXls("fasttrack_Requiredstartofprod", "fasttrack_Requiredstartofprod");
//
//			// CommonWebActions.webSetFromXls("fasttrack_RequiredstartofprodComment", "fasttrack_Requiredstartofprodcomment");
//
//			// CommonWebActions.webSetFromXls("fasttrack_Developmentcost", "fasttrack_Developmentcost");
//			// CommonWebActions.webSetFromXls("fasttrack_DevelopmentcostComment", "fasttrack_DevelopmentcostComment");
//			// CommonWebActions.webSetFromXls("fasttrack_DeltaMaterialcost", "fasttrack_DeltaMaterialcost");
//			// CommonWebActions.webSetFromXls("fasttrack_DeltaMaterialcostComment", "fasttrack_DeltaMaterialcostComment");
//			// CommonWebActions.webSetFromXls("fasttrack_ontimecosts", "fasttrack_ontimecosts");
//			// CommonWebActions.webSetFromXls("fasttrack_onetimecostscomment", "fasttrack_onetimecostscomment");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("openTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void Priority() {
//
//		try {
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.switchToiFrame(1);
//			CommonWebActions.waituntil("priority_yes");
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("priority_yes");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("openTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	///////////////////////////////////////////////////////////////////////////////
//
//	public static void distributeTechAgent() {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("TecnicalAgent_Yes_No");
//			CommonWebActions.webClick("TecnicalAgent_Yes_No");
//
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntil("AddTechnicalAgentButton");
//			CommonWebActions.webClick("AddTechnicalAgentButton");
//
//			CommonWebActions.waituntil("TechnicalAgentExpert");
//			CommonWebActions.webClick("TechnicalAgentExpert");
//
//			CommonWebActions.waituntil("TechnicalAgentComment");
//			// CommonWebActions.webSetFromXls("TechnicalAgentComment", "Shortdescription");
//
//			// CommonWebActions.webSetFromXls("TechnicalAgentExpert", "Addtionalpacpersonid");
//
//			CommonWebActions.webClick("TechnicalAgentExpertPopupselection");
//
//			CommonWebActions.waituntil("TechAgentDuedate");
//			// CommonWebActions.webSetFromXls("TechAgentDuedate", "TechSolDueDate");
//
//			CommonWebActions.waituntil("TechnicalAgentDistributebutton");
//
//			CommonWebActions.webClick("TechnicalAgentDistributebutton");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTechAgent", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void findTechAgent() throws ConfigurationException, IOException {
//		String TechAgentstmt1 = null;
//		String TechAgentstmt2 = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			crTitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(crTitle);
//
//			TechAgentstmt1 = "xpath:=//a[starts-with(text(),'Modify Package as Technical Agent for " + packageNumber + "') and contains(text()," + crTitle
//					+ ")][@title='Click to work on the task']";
//
//			TechAgentstmt2 = TechAgentstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", crTitle);
//			System.out.println("Replacedvalue" + TechAgentstmt2);
//			ORUtil.setValue("TechAgentstmt1", TechAgentstmt2);
//			CommonWebActions.waituntil("TechAgentstmt1");
//			System.out.println("Techsol stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("TechAgentstmt1");
//
//		}
//
//	}
//
//	public static void openTechAgent() {
//
//		try {
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("TechAgentstmt1");
//			
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			
//			//CommonWebActions.switchToiFrame1("TechAgentIframe");
//			System.out.println("switched to frame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");	
//			
//			CommonWebActions.waituntil("TechAgentShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("openTechAgent");
//
//		}
//	}
//
//	public static void fillTechAgent() {
//		try {
//
//			CommonWebActions.waituntil("Solutiondesc");
//			// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//			CommonWebActions.waituntil("ItemsTab");
//
//			CommonWebActions.webClick("ItemsTab");
//
//			CommonWebActions.webClick("searchandAddbutton");
//
//			CommonWebActions.waituntil("partno");
//			// CommonWebActions.webSetFromXls("partno", "PartNumber1");
//
//			CommonWebActions.webClick("searchPartsButton");
//
//			CommonWebActions.ICMSpaceClick("Checkbox");
//		//	CommonWebActions.ICMclick("addandClose");
//
//			CommonWebActions.waituntil("PartVolumes1");
//			// CommonWebActions.webSetFromXls("PartVolumes1", "PartVolumes");
//
//			CommonWebActions.waituntil("Techsol_Recommendation");
//			// CommonWebActions.webSetFromXls("Techsol_Recommendation", "Recommendation");
//
//			CommonWebActions.waituntil("Techsol_RecComment");
//			// CommonWebActions.webSetFromXls("Techsol_RecComment", "Recommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillTechAgent", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void finishTechAgent() {
//		try {
//			startTime = System.currentTimeMillis();					
//			
//			CommonWebActions.waituntil("TechnicalagentRefresh");
//			CommonWebActions.webClick("TechnicalagentRefresh");
//
//			CommonWebActions.waituntil("FinishtechAgent");
//			CommonWebActions.webClick("FinishtechAgent");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("finishTechAgent", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	///////////////////////////////////////////////////////////////////////////////
//	public static void distributeTechSol() {
//
//		try {
//
//			//CommonWebActions.waituntil("TechSolutionHeader");
//
//			startTime = System.currentTimeMillis();
//
//			//CommonWebActions.webClick("TechSolutionHeader");
//
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntil("Shortdesc");
//			CommonWebActions.webClick("Shortdesc");
//			// CommonWebActions.webSetFromXls("Shortdesc", "Shortdescription");
//
//			CommonWebActions.waituntil("TechnicalExpert");
//			CommonWebActions.webClick("TechnicalExpert");
//
//			// CommonWebActions.webSetFromXls("TechnicalExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("Technicalexpertpopupselection");
//
//			CommonWebActions.waituntil("TechSolDueDate");
//			// CommonWebActions.webSetFromXls("TechSolDueDate", "TechSolDueDate");
//
//			CommonWebActions.waituntil("Distributebutton");
//			CommonWebActions.webClick("Distributebutton");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("openTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void findTechSol() throws ConfigurationException, IOException {
//		String Techsolstmt1 = null;
//		String Techsolstmt2 = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			crTitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(crTitle);
//
//			Techsolstmt1 = "xpath:=//a[starts-with(text(),'1. Maintain Technical Solution for " + packageNumber + "') and contains(text()," + crTitle
//					+ ")][@title='Click to work on the task']";
//
//			Techsolstmt2 = Techsolstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", crTitle);
//			System.out.println("Replacedvalue" + Techsolstmt2);
//			ORUtil.setValue("Techsolstmt1", Techsolstmt2);
//			CommonWebActions.waituntil("Techsolstmt1");
//			System.out.println("Techsol stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("Techsolstmt");
//
//		}
//
//	}
//
//	public static void openTechSol() {
//
//		try {
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("Techsolstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("TechsolIframe");
//			System.out.println("switched to frame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//			CommonWebActions.waituntil("TechsolShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("openTechSolstmt");
//
//		}
//	}
//
//	public static void fillTechSol() {
//		try {
//			
//			
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.webClick("Solutiondesc");
//			// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//			//CommonWebActions.waituntil("ItemsTab");
//
//			//CommonWebActions.webClick("ItemsTab");
//
//			CommonWebActions.webClick("searchandAddbutton");
//
//			CommonWebActions.waituntil("partno");
//			// CommonWebActions.webSetFromXls("partno", "PartNumber1");
//
//			CommonWebActions.webClick("searchPartsButton");
//
//			CommonWebActions.ICMSpaceClick("Checkbox");
//
//		//	CommonWebActions.ICMclick("addandClose");
//
//			CommonWebActions.waituntil("PartVolumes1");
//			// CommonWebActions.webSetFromXls("PartVolumes1", "PartVolumes");
//
//			/*
//			 * CommonWebActions.waituntil("AddNewpartbutton");
//			 * CommonWebActions.webClick("AddNewpartbutton");
//			 * CommonWebActions.ICMclick("AddNewpartbutton");
//			 * 
//			 * //CommonWebActions.webSet("partchange2","partchange");
//			 * 
//			 * //CommonWebActions.webSet("parttype2","parttype");
//			 * 
//			 * CommonWebActions.webSet("PartNumber2", "PartNumber2");
//			 * 
//			 * CommonWebActions.webClick("SearchPartDetails2");
//			 * 
//			 * //CommonWebActions.webSet("partNumberdesc2", "partNumberdesc");
//			 * 
//			 * CommonWebActions.webSet("PartVolumes2","PartVolumes");
//			 */
//
//			CommonWebActions.waituntil("Techsol_Recommendation");
//			// CommonWebActions.webSetFromXls("Techsol_Recommendation", "Recommendation");
//
//			CommonWebActions.waituntil("Techsol_RecComment");
//			// CommonWebActions.webSetFromXls("Techsol_RecComment", "Recommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void fillTechSolImportitems() {
//		try {
//
//			CommonWebActions.wait(5000);
//			// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//			CommonWebActions.webClick("TechnicalsolImportbutton");
//		//	CommonWebActions.ICMclick("TechnicalsolImportbutton");
//
//			CommonWebActions.waituntil("TechnicalsolImportBrowsebutton");
//			CommonWebActions.webClick("TechnicalsolImportBrowsebutton");
//
//			CommonWebActions.wait(25000);
//			CommonWindowsActions.winSet("FileName1", "TechnicalsolpartsFileLocation");
//
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("Openbutton");
//
//			CommonWebActions.waituntil("TecnicalsolImportbuttonafterbrowse");
//			CommonWebActions.webClick("TecnicalsolImportbuttonafterbrowse");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void ExportfillTechSol() {
//		try {
//
//			CommonWebActions.wait(5000);
//			// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//			CommonWebActions.webClick("searchandAddbutton");
//
//			CommonWebActions.waituntil("partno");
//			// CommonWebActions.webSetFromXls("partno", "PartNumber3");
//
//			CommonWebActions.webClick("searchPartsButton");
//
//			CommonWebActions.waituntil("TechnicalsolSelectallbutton");
//			CommonWebActions.webClick("TechnicalsolSelectallbutton");
//
//			CommonWebActions.waituntil("addandClose");
//			CommonWebActions.webClick("addandClose");
//
//			CommonWebActions.waituntil("PartVolumes1");
//			// CommonWebActions.webSetFromXls("PartVolumes1", "PartVolumes");
//
//		//	CommonWebActions.ICMclick("TechnicalsolitemsExportbutton");
//			CommonWebActions.webClick("TechnicalsolitemsExportbutton");
//
//			CommonWebActions.wait(10000);
//			CommonWindowsActions.winClick("Savefile");
//			CommonWebActions.wait(2000);
//			CommonWindowsActions.winClick("Okbutton");
//
//			CommonWebActions.wait(5000);
//			String downloadPath = "C:\\Users\\GSATISH\\Downloads";
//			File dir = new File(downloadPath);
//			File[] dir_contents = dir.listFiles();
//
//			for (int i = 0; i < dir_contents.length; i++) {
//
//				System.out.println(dir_contents[i].getName());
//				String filename = dir_contents[i].getName();
//				String filename1 = filename.substring(0, 11);
//				System.out.println("filename1" + filename1);
//				System.out.println(filename1);
//
//				if (filename1.equals("partsexport")) {
//					String filename2 = dir_contents[i].getName();
//					System.out.println(filename2);
//					System.out.println(i);
//					System.out.println(dir_contents[i].length());
//
//					if (dir_contents[i].length() > 100) {
//
//						System.out.println("FOUND and its size more than 100 bytes");
//
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is more than 100 bytes");
//					} else {
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is less than 100 bytes ");
//					}
//				} else {
//					System.out.println("File not found");
//					ReportUtil.reporterEvent("info", "File not found ");
//				}
//			}
//
//			CommonWebActions.waituntil("Techsol_Recommendation");
//			// CommonWebActions.webSetFromXls("Techsol_Recommendation", "Recommendation");
//
//			CommonWebActions.waituntil("Techsol_RecComment");
//			// CommonWebActions.webSetFromXls("Techsol_RecComment", "Recommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void fillTechSolInterfaces() {
//		String a = null;
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("Expandcoach");
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			CommonWebActions.wait(5000);
//			CommonWebActions.switchToDefaultContent();
//
//			//CommonWebActions.switchToiFrame1("TechsolIframe");
//
//			CommonWebActions.wait(3000);
//			// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//			CommonWebActions.webClick("searchandAddbutton");
//
//			CommonWebActions.waituntil("partno");
//			// CommonWebActions.webSetFromXls("partno", "PartNumber1");
//
//			CommonWebActions.webClick("searchPartsButton");
//
//			CommonWebActions.ICMSpaceClick("Checkbox");
//
////		//	CommonWebActions.ICMclick("addandClose");
//
//			CommonWebActions.waituntil("PartVolumes1");
//			// CommonWebActions.webSetFromXls("PartVolumes1", "PartVolumes");
//
//			CommonWebActions.waituntil("AddNewpartbutton");
//			CommonWebActions.webClick("AddNewpartbutton");
//			// CommonWebActions.ICMclick("AddNewpartbutton");
//
//			// CommonWebActions.webSet("partchange2","partchange");
//
//			// CommonWebActions.webSet("parttype2","parttype");
//
//			// CommonWebActions.webSetFromXls("PartNumber2", "PartNumber2");
//
//			CommonWebActions.webClick("SearchPartDetails2");
//
//			// CommonWebActions.webSet("partNumberdesc2", "partNumberdesc");
//
//			// CommonWebActions.webSetFromXls("PartVolumes2", "PartVolumes");
//
//			// ////////////////////////////////////////////////////
//
//			CommonWebActions.waituntil("CheckboxPart2itemstab");
//			CommonWebActions.ICMSpaceClick("CheckboxPart2itemstab");
//
//			CommonWebActions.waituntil("Partusageupbutton");
//			CommonWebActions.webClick("Partusageupbutton");
//		//	CommonWebActions.ICMclick("Partusageupbutton");
//
//			CommonWebActions.waituntil("Partusageupcheckbox");
//			CommonWebActions.ICMSpaceClick("Partusageupcheckbox");
//
//			CommonWebActions.waituntil("PartusageupAddandClose");
//			// CommonWebActions.webClick("PartusageupAddandClose");
//		//	CommonWebActions.ICMclick("PartusageupAddandClose");
//
//			// //////////////////////////////////////////////////
//
//			CommonWebActions.waituntil("partusagedownbutton");
//		//	CommonWebActions.ICMclick("partusagedownbutton");
//
//			CommonWebActions.waituntil("partusagedownerrormessage");
//			CommonWebActions.webVerifyInnerText("partusagedownerrormessage", "partusagedownerrormessage");
//
//			// CommonWebActions.waituntil("Partusagedowncheckbox");
//			// CommonWebActions.ICMSpaceClick("Partusagedowncheckbox");
//
//			CommonWebActions.waituntil("PartUsagedownclosebutton1");
//		//	CommonWebActions.ICMclick("PartUsagedownclosebutton1");
//
//			// ///////////////////////////////////////////////////need to start
//			// from here
//
//			CommonWebActions.waituntil("partDetailsbutton");
//		//	CommonWebActions.ICMclick("partDetailsbutton");
//
//			CommonWebActions.waituntil("partDetailstitle");
//			CommonWebActions.webVerifyInnerText("partDetailstitle", "PartDetailsTitle");
//
//			// CommonWebActions.webVerifyPageTitle("PartDetailsTitle", true);
//
//			// CommonWebActions.webVerifyInnerText("getPartNumberPartDetails","PartNumber2");
//			CommonWebActions.wait(2000);
//			// CommonWebActions.webClick("tempClick");
//			// CommonWebActions.ICMEscape("tempClick");
//			// CommonWebActions.webClick("partDetailsClose");
//			CommonWebActions.webClick("partDetailsClose");
//			// CommonWebActions.ICMEscape("partDetailsClose");
//
//			// /////////////////////////////////////////////////////////////
//			// CommonWebActions.waituntil("ItemsTab");
//			CommonWebActions.waituntil("PlantDistribution");
//			CommonWebActions.webClick("PlantDistribution");
//		//	CommonWebActions.ICMclick("PlantDistribution");
//			CommonWebActions.waituntil("Plantdistributiontitle");
//			CommonWebActions.webVerifyInnerText("Plantdistributiontitle", "PlantDistributionTitle");
//			CommonWebActions.webVerifyInnerText("getPartnumberPlantDistribution", "PartNumber2");
//			// CommonWebActions.webVerifyPageTitle("PlantDistributionTitle",true);
//			CommonWebActions.webClick("PlantDistributionClose");
//			// CommonWebActions.ICMEscape("PlantDistributionClose");
//			// ////////////////////////////////////////////////
//			// CommonWebActions.waituntil("ItemsTab");
//			CommonWebActions.waituntil("CheckboxPart2itemstab");
//			CommonWebActions.ICMSpaceClick("CheckboxPart2itemstab");
//
//			CommonWebActions.waituntil("CheckboxPart1itemstab");
//			CommonWebActions.ICMSpaceClick("CheckboxPart1itemstab");
//			CommonWebActions.webClick("BuyerInformation");
//		//	CommonWebActions.ICMclick("BuyerInformation");
//			CommonWebActions.waituntil("BuyerInformationtitle");
//			CommonWebActions.webVerifyInnerText("BuyerInformationtitle", "BuyerInformationTitle");
//			CommonWebActions.webVerifyInnerText("getBuyerID", "getBuyerID");
//			// CommonWebActions.webVerifyPageTitle("BuyerInformationTitle",true);
//			CommonWebActions.webClick("buyerInformationClose");
//			// CommonWebActions.ICMEscape("buyerInformationClose");
//			// //////////////////////////////////////////////////////////
//			// CommonWebActions.waituntil("ItemsTab");
//		//	CommonWebActions.ICMclick("sharedparts");
//			CommonWebActions.waituntil("Sharedpartstitle");
//			CommonWebActions.wait(5000);
//			// CommonWebActions.webClick("sharedpartdetailscheckbox");
//			CommonWebActions.ICMSpaceClick("sharedpartdetailscheckbox");
//			CommonWebActions.webVerifyInnerText("Sharedpartstitle", "SharedpartsTilte");
//
//			CommonWebActions.webClick("SharedpartAddandClose");
//
//			// CommonWebActions.webSet("Recommendation", "Recommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("fillTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void finishTechSol() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("Finishtechsol");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("finishTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void findinitialtask() {
//		try {
//			startTime = System.currentTimeMillis();
//			findinitialtask(processID);
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("finishTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void findTechsoltask() throws Exception
//
//	{
//		String techsollink = null;
//		String c = null;
//
//		System.out.println(packageNumber);
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("WorkTab");
//
//		CommonWebActions.webClick("WorkTab");
//
//		String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//		final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//		System.out.println(CRtitle);
//
//	//CommonWebActions.showmoreTasks();
//
//		c = ORUtil.getValue("FindTechSoltask");
//		System.out.println("Orvalue" + c);
//		techsollink = "xpath:=//a[starts-with(text(),'1. Maintain Technical Solution for " + packageNumber + "') and contains(text()," + CRtitle
//				+ ")][@title='Click to work on the task']";
//
//		System.out.println("Replacedvalue" + techsollink);
//		ORUtil.setValue("FindTechSoltask", techsollink);
//		CommonWebActions.waituntil("FindTechSoltask");
//
//	//	CommonWebActions.ICMclick("FindTechSoltask");
//
//		CommonWebActions.webClick("FindTechSoltask");
//		//CommonWebActions.switchToiFrame1("TechsolIframe");
//		System.out.println("switched to frame");
//		CommonWebActions.waituntil("TechsolShellNumber");
//		System.out.println("waited until shellnumber is dispalyed");
//
//		CommonWebActions.wait(5000);
//		// CommonWebActions.webSetFromXls("Solutiondesc", "SolutionDescription");
//
//		CommonWebActions.waituntil("ItemsTab");
//
//		CommonWebActions.webClick("ItemsTab");
//	//	CommonWebActions.ICMclick("ItemsTab");
//
//		CommonWebActions.webClick("searchandAddbutton");
//
//		CommonWebActions.waituntil("partno");
//		// CommonWebActions.webSetFromXls("partno", "PartNumber");
//
//		CommonWebActions.webClick("searchPartsButton");
//
//		CommonWebActions.ICMSpaceClick("Checkbox");
//
//	//	CommonWebActions.ICMclick("addandClose");
//
//		CommonWebActions.waituntil("Techsol_Recommendation");
//		// CommonWebActions.webSetFromXls("Techsol_Recommendation", "Recommendation");
//		CommonWebActions.waituntil("Techsol_RecComment");
//		// CommonWebActions.webSetFromXls("Techsol_RecComment", "Recommendation");
//		stopTime = System.currentTimeMillis();
//		executionTimes.put("fillTechSol", stopTime - startTime);
//
//		startTime = System.currentTimeMillis();
//		CommonWebActions.webClick("Finishtechsol");
//
//		stopTime = System.currentTimeMillis();
//		executionTimes.put("finishTechSol", stopTime - startTime);
//
//	}
//
//	public static void openinitialtask() {
//		try {
//			startTime = System.currentTimeMillis();
//			openinitialtaskDelegate();
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("finishTechSol", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void openinitialtaskDelegate() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.wd.findElement(By.xpath("//div[@id='" + initialTaskRowId + "']/div/div[2]/div[1]/span[2]/a")).click();
//
//			// ChangeforMBRDI DEV
//			// //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='com_ibm_bpm_social_widgets_details_InstanceDetails_0']/div[1]/div[3]")));
//
//			//CommonWebActions.switchToiFrame1("InitiationiFrame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//
//			CommonWebActions.waituntil("CreateChangeRequesttab");
//
//			stopTime = System.currentTimeMillis();
//
//			executionTimes.put("Openinitialtask", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.takeScreenshot("Openinitialtask");
//			SeleniumUtils.printError(exception.getMessage());
//			executionTimes.put("OpenCheckPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void TechSol() {
//		try {
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String Shortdescription = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Shortdescription");
//			System.out.println(Shortdescription);
//			String[] Shortdesc = Shortdescription.split(",");
//
//			String SolutionDescription = ExcelUtil.getDataFromExcel(onlyTestCaseName, "SolutionDescription");
//			String[] Solutiondesc = SolutionDescription.split(",");
//
//			String partchange = ExcelUtil.getDataFromExcel(onlyTestCaseName, "partchange");
//			String[] partchange1 = partchange.split(",");
//
//			String parttype = ExcelUtil.getDataFromExcel(onlyTestCaseName, "parttype");
//			String[] parttype1 = parttype.split(",");
//
//			String PartNumber = ExcelUtil.getDataFromExcel(onlyTestCaseName, "PartNumber");
//			String[] pn = PartNumber.split(",");
//
//			String partNumberdesc = ExcelUtil.getDataFromExcel(onlyTestCaseName, "partNumberdesc");
//			String[] pnd = partNumberdesc.split(",");
//
//			String Volume = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Volume");
//			String[] Vol = Volume.split(",");
//
//			String Recommendation = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Recommendation");
//			String[] rec = Recommendation.split(",");
//
//			System.out.println("shortdeslen= " + Shortdesc.length);
//			for (int i = 0; i < Shortdesc.length; i++) {
//				if (i == 0) {
//					CommonWebActions.waituntil("TechSolution");
//					CommonWebActions.webClick("TechSolution");
//					SeleniumUtils.pause(1000);
//					CommonWebActions.webClick("TechsolEdit");
//
//					CommonWebActions.switchToDefaultContent();
//					CommonWebActions.switchToFrameWithCSS();
//					SeleniumUtils.pause(10000);
//					CommonWebActions.waituntil("Shortdesc");
//					SeleniumUtils.pause(15000);
//
//					CommonWebActions.webSet("Shortdesc", Shortdesc[i]);
//
//					CommonWebActions.webSet("Solutiondesc", Solutiondesc[i]);
//					CommonWebActions.waituntil("ItemsTab");
//					CommonWebActions.wait(5000);
//					CommonWebActions.webClick("ItemsTab");
//				//	CommonWebActions.ICMclick("ItemsTab");
//
//				//	CommonWebActions.ICMclick("AddNewpartbutton");
//
//					CommonWebActions.wait(1000);
//					CommonWebActions.webSet("partchange", partchange1[i]);
//					CommonWebActions.wait(1000);
//					CommonWebActions.webSet("parttype", parttype1[i]);
//
//					CommonWebActions.webSet("PartNumber", pn[i]);
//
//					CommonWebActions.webSet("partNumberdesc", pnd[i]);
//
//					CommonWebActions.webSet("Volume", Vol[i]);
//
//					CommonWebActions.webSet("Recommendation", rec[i]);
//
//					CommonWebActions.webClick("Finishtechsol");
//					CommonWebActions.waituntil("createCRTab");
//					CommonWebActions.captureScreenshotAsBase64();
//					System.out.println(i);
//				}
//				if (i >= 1) {
//					WebElement lwebElement = null;
//					String TechsolEdit = "xpath:=.//div[@data-bindingrt='local.technicalSolutions[" + i + "].id']/a[contains(@class, 'edit')]";
//					System.out.println(i);
//
//					SeleniumUtils.pause(3000);
//					CommonWebActions.waituntil("TechSolution");
//
//					CommonWebActions.webClick("TechSolution");
//					SeleniumUtils.pause(5000);
//					CommonWebActions.waituntil("TechsolAdd");
//					CommonWebActions.webClick("TechsolAdd");
//					SeleniumUtils.pause(5000);
////					lwebElement = CommonWebActions.getWebElementWithElement(TechsolEdit);
//
//					lwebElement.click();
//
//					SeleniumUtils.pause(1000);
//
//					CommonWebActions.switchToDefaultContent();
//					CommonWebActions.switchToFrameWithCSS();
//					SeleniumUtils.pause(5000);
//					CommonWebActions.waituntil("Shortdesc");
//					SeleniumUtils.pause(15000);
//					System.out.println(Shortdesc[i]);
//					CommonWebActions.webSet("Shortdesc", Shortdesc[i]);
//
//					CommonWebActions.webSet("Solutiondesc", Solutiondesc[i]);
//					CommonWebActions.waituntil("ItemsTab");
//					CommonWebActions.wait(5000);
//					CommonWebActions.webClick("ItemsTab");
//				//	CommonWebActions.ICMclick("ItemsTab");
//
//				//	CommonWebActions.ICMclick("AddNewpartbutton");
//
//					CommonWebActions.wait(1000);
//					CommonWebActions.webSet("partchange", partchange1[i]);
//					CommonWebActions.wait(1000);
//					CommonWebActions.webSet("parttype", parttype1[i]);
//
//					CommonWebActions.webSet("PartNumber", pn[i]);
//
//					CommonWebActions.webSet("partNumberdesc", pnd[i]);
//
//					CommonWebActions.webSet("Volume", Vol[i]);
//
//					CommonWebActions.webSet("Recommendation", rec[i]);
//
//					if (rec[i].equalsIgnoreCase("Conditionally approved")) {
//						// CommonWebActions.webSetFromXls("RecComment", "RecComment");
//					}
//
//					if (rec[i].equalsIgnoreCase("Rejected")) {
//						// CommonWebActions.webSetFromXls("RecComment", "RecComment1");
//					}
//					if (rec[i].equalsIgnoreCase("Not affected")) {
//						// CommonWebActions.webSetFromXls("RecComment", "RecComment2");
//					}
//
//					CommonWebActions.webClick("Finishtechsol");
//					CommonWebActions.waituntil("createCRTab");
//					CommonWebActions.captureScreenshotAsBase64();
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void addBaumuster() {
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//
//			//CommonWebActions.switchToiFrame1("iframeString2");
//
//			//CommonWebActions.waituntil("BaumusterHeaderExpand");
//			//CommonWebActions.webClick("BaumusterHeaderExpand");
//
//			CommonWebActions.waituntil("BaumusterExpand");
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("BaumusterExpand");
////			CommonWebActions.webClick("BaumusterExpand");
//			System.out.println("BaumusterExpand button is clicked");
//
//			CommonWebActions.waituntil("BaumusterProducttype");
//			// CommonWebActions.webSetFromXls("BaumusterProducttype", "BaumusterProducttype");
//
//			CommonWebActions.waituntil("strBaumusterType");
//			// CommonWebActions.webSetFromXls("strBaumusterType", "baumusterTypText");
//
//			CommonWebActions.waituntil("Baumuster_partlist");
//			// CommonWebActions.webSetFromXls("Baumuster_partlist", "Baumuster_partlist");
//
//			// CommonWebActions.webSetFromXls("Series_Baumuster_Partslist", "Series_Baumuster_Partslist");
//			CommonWebActions.wait(5000);
//			CommonWebActions.webClick("Baumustersearch");
//
//			CommonWebActions.waituntil("BaumusterformodelSearch");
//			// CommonWebActions.webSetFromXls("BaumusterformodelSearch", "Series_Baumuster_Partslist");
//			
//			CommonWebActions.waituntil("Searchmodelcodessearch");
//
//			CommonWebActions.webClick("Searchmodelcodessearch");
//
//			CommonWebActions.waituntil("Searchmodelcodecheckbox");
//
//			CommonWebActions.webClick("Searchmodelcodecheckbox");
//
//			CommonWebActions.waituntil("SearchmodelAddbutton");
//
//			CommonWebActions.webClick("SearchmodelAddbutton");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("BaumusterCodeSearch");
//
//			CommonWebActions.webClick("BaumusterCodeSearch");
//
//			CommonWebActions.waituntil("selectcodeinput");
//			// CommonWebActions.webSet1("selectcodeinput", "selectcodetextbox");
//
//			CommonWebActions.waituntil("Searchcodessearchbutton");
//
//			CommonWebActions.webClick("Searchcodessearchbutton");
//
//			CommonWebActions.waituntil("Searchcodescheckbox");
//
//			CommonWebActions.webClick("Searchcodescheckbox");
//
//			CommonWebActions.waituntil("Selectcode_ADD");
//			CommonWebActions.webClick("Selectcode_ADD");
//
//			CommonWebActions.waituntil("BaumusterCodeCondition");
//			// CommonWebActions.webSetFromXls("BaumusterCodeCondition", "BaumusterCodeCondition");
//
//			CommonWebActions.waituntil("BaumusterDescription");
//			// CommonWebActions.webSetFromXls("BaumusterDescription", "BaumusterDescription");
//
//			CommonWebActions.waituntil("RequestedImplementedDate");
//			// CommonWebActions.webSetFromXls("RequestedImplementedDate", "RequestedImplementedDate");
//
//			CommonWebActions.waituntil("Lifecycleattribute");
//			// CommonWebActions.webSetFromXls("Lifecycleattribute", "Lifecycleattribute");
//
//			CommonWebActions.waituntil("RemainingprodPeriod");
//			// CommonWebActions.webSetFromXls("RemainingprodPeriod", "RemainingprodPeriod");
//
//			CommonWebActions.waituntil("Volumeperyear");
//			// CommonWebActions.webSetFromXls("Volumeperyear", "Volumeperyear");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("addBaumuster", stopTime - startTime);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void addBaumuster_additionalpac() {
//		try {
//
//			// CommonWebActions.switchToDefaultContent();
//
//			// //CommonWebActions.switchToiFrame1("iframeString2");
//
//			CommonWebActions.waituntil("BaumusterExpand");
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("BaumusterExpand");
//			System.out.println("BaumusterExpand button is clicked");
//
//			CommonWebActions.waituntil("BaumusterProducttype");
//			// CommonWebActions.webSetFromXls("BaumusterProducttype", "BaumusterProducttype");
//			// CommonWebActions.webClick("BaumusterProducttypedown");
//
//			CommonWebActions.waituntil("strBaumusterType");
//			// CommonWebActions.webSetFromXls("strBaumusterType", "baumusterTypText");
//
//			CommonWebActions.waituntil("Baumuster_partlist");
//			// CommonWebActions.webSetFromXls("Baumuster_partlist", "Baumuster_partlist");
//
//			// CommonWebActions.webSetFromXls("Series_Baumuster_Partslist", "Series_Baumuster_Partslist");
//
//			CommonWebActions.webClick("Baumustersearch_Additional");
//
//			CommonWebActions.waituntil("Searchmodelcodessearch");
//
//			CommonWebActions.webClick("Searchmodelcodessearch");
//
//			CommonWebActions.waituntil("Searchmodelcodecheckbox");
//
//			CommonWebActions.webClick("Searchmodelcodecheckbox");
//
//			CommonWebActions.waituntil("SearchmodelAddbutton");
//
//			CommonWebActions.webClick("SearchmodelAddbutton");
//
//			CommonWebActions.waituntil("BaumusterCodeSearch_Additional");
//
//			CommonWebActions.webClick("BaumusterCodeSearch_Additional");
//
//			CommonWebActions.waituntil("selectcodeinput");
//			// CommonWebActions.webSet1("selectcodeinput", "selectcodetextbox");
//
//			CommonWebActions.waituntil("Searchcodessearchbutton");
//
//			CommonWebActions.webClick("Searchcodessearchbutton");
//
//			CommonWebActions.waituntil("Searchcodescheckbox");
//
//			CommonWebActions.webClick("Searchcodescheckbox");
//
//			CommonWebActions.waituntil("Selectcode_ADD");
//			CommonWebActions.webClick("Selectcode_ADD");
//
//			CommonWebActions.waituntil("BaumusterCodeCondition");
//			// CommonWebActions.webSetFromXls("BaumusterCodeCondition", "BaumusterCodeCondition");
//
//			CommonWebActions.waituntil("BaumusterDescription");
//			// CommonWebActions.webSetFromXls("BaumusterDescription", "BaumusterDescription");
//
//			CommonWebActions.waituntil("RequestedImplementedDate");
//			// CommonWebActions.webSetFromXls("RequestedImplementedDate", "RequestedImplementedDate");
//
//			CommonWebActions.waituntil("Lifecycleattribute");
//			// CommonWebActions.webSetFromXls("Lifecycleattribute", "Lifecycleattribute");
//
//			CommonWebActions.waituntil("RemainingprodPeriod");
//			// CommonWebActions.webSetFromXls("RemainingprodPeriod", "RemainingprodPeriod");
//
//			CommonWebActions.waituntil("Volumeperyear");
//			// CommonWebActions.webSetFromXls("Volumeperyear", "Volumeperyear");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("addBaumuster", stopTime - startTime);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void ImportBaumuster() {
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//
//			//CommonWebActions.switchToiFrame1("iframeString2");
//
//			CommonWebActions.waituntil("BaumusterEdit2");
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("BaumusterEdit2");
//			System.out.println("baumusterEdit button is clicked");
//
//			CommonWebActions.waituntil("BaumusterImport");
//
//		//	CommonWebActions.ICMclick("BaumusterImport");
//
//			CommonWebActions.waituntil("BaumusterImportBrowsebutton");
//			CommonWebActions.webClick("BaumusterImportBrowsebutton");
//
//			CommonWebActions.wait(15000);
//			CommonWindowsActions.winSet("FileName1", "BaumusterFileLocation");
//
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("Openbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("Okbutton2");
//
//			CommonWebActions.waituntil("BaumusterImportbuttonafterbrowse");
//			CommonWebActions.webClick("BaumusterImportbuttonafterbrowse");
//
//			CommonWebActions.waituntil("baumusterClose");
//			CommonWebActions.webClick("baumusterClose");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("addBaumuster", stopTime - startTime);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void ExportBaumuster() {
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//
//			//CommonWebActions.switchToiFrame1("iframeString2");
//
//			CommonWebActions.waituntil("BaumusterEdit2");
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("BaumusterEdit2");
//			System.out.println("baumusterEdit button is clicked");
//
//			CommonWebActions.waituntil("BaumusterProducttype");
//			// CommonWebActions.webSetFromXls("BaumusterProducttype", "BaumusterProducttype");
//
//			CommonWebActions.waituntil("strBaumusterType");
//			// CommonWebActions.webSetFromXls("strBaumusterType", "baumusterTypText");
//
//			CommonWebActions.waituntil("Baumuster_partlist");
//			// CommonWebActions.webSetFromXls("Baumuster_partlist", "Baumuster_partlist");
//
//			// CommonWebActions.webSetFromXls("Series_Baumuster_Partslist", "Series_Baumuster_Partslist");
//
//			CommonWebActions.webClick("Baumustersearch");
//
//			CommonWebActions.waituntil("Searchmodelcodessearch");
//
//			CommonWebActions.webClick("Searchmodelcodessearch");
//
//			CommonWebActions.waituntil("Searchmodelcodecheckbox");
//
//			CommonWebActions.webClick("Searchmodelcodecheckbox");
//
//			CommonWebActions.waituntil("SearchmodelAddbutton");
//
//			CommonWebActions.webClick("SearchmodelAddbutton");
//
//			CommonWebActions.waituntil("BaumusterCodeSearch");
//
//			CommonWebActions.webClick("BaumusterCodeSearch");
//
//			CommonWebActions.waituntil("selectcodeinput");
//			// CommonWebActions.webSet1("selectcodeinput", "selectcodetextbox");
//
//			CommonWebActions.waituntil("Searchcodessearchbutton");
//
//			CommonWebActions.webClick("Searchcodessearchbutton");
//
//			CommonWebActions.waituntil("Searchcodescheckbox");
//
//			CommonWebActions.webClick("Searchcodescheckbox");
//
//			CommonWebActions.waituntil("Selectcode_ADD");
//			CommonWebActions.webClick("Selectcode_ADD");
//
//			CommonWebActions.waituntil("BaumusterCodeCondition");
//			// CommonWebActions.webSetFromXls("BaumusterCodeCondition", "BaumusterCodeCondition");
//
//			CommonWebActions.waituntil("BaumusterDescription");
//			// CommonWebActions.webSetFromXls("BaumusterDescription", "BaumusterDescription");
//
//			CommonWebActions.waituntil("RequestedImplementedDate");
//			// CommonWebActions.webSetFromXls("RequestedImplementedDate", "RequestedImplementedDate");
//
//			CommonWebActions.waituntil("Lifecycleattribute");
//			// CommonWebActions.webSetFromXls("Lifecycleattribute", "Lifecycleattribute");
//
//			CommonWebActions.waituntil("RemainingprodPeriod");
//			// CommonWebActions.webSetFromXls("RemainingprodPeriod", "RemainingprodPeriod");
//
//			CommonWebActions.waituntil("Volumeperyear");
//			// CommonWebActions.webSetFromXls("Volumeperyear", "Volumeperyear");
//
//			CommonWebActions.waituntil("BaumusterExportbutton");
//
//		//	CommonWebActions.ICMclick("BaumusterExportbutton");
//
//			CommonWebActions.wait(10000);
//			CommonWindowsActions.winClick("Savefile");
//			CommonWebActions.wait(2000);
//			CommonWindowsActions.winClick("Okbutton");
//
//			CommonWebActions.wait(5000);
//			String downloadPath = "C:\\Users\\GSATISH\\Downloads";
//			File dir = new File(downloadPath);
//			File[] dir_contents = dir.listFiles();
//
//			for (int i = 0; i < dir_contents.length; i++) {
//
//				System.out.println(dir_contents[i].getName());
//				String filename = dir_contents[i].getName();
//				String filename1 = filename.substring(0, 15);
//				System.out.println("filename1" + filename1);
//
//				if (filename1.equals("baumusterexport"))
//
//				{
//					String filename2 = dir_contents[i].getName();
//					System.out.println(filename2);
//					System.out.println(i);
//					System.out.println(dir_contents[i].length());
//
//					if (dir_contents[i].length() > 100) {
//
//						System.out.println("FOUND and its size more than 100 bytes");
//
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is more than 100 bytes");
//					} else {
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is less than 100 bytes ");
//					}
//				} else {
//					System.out.println("File not found");
//					ReportUtil.reporterEvent("info", "File not found ");
//				}
//			}
//
//			CommonWebActions.waituntil("baumusterClose");
//			CommonWebActions.webClick("baumusterClose");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("addBaumuster", stopTime - startTime);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void addAdditionalPackage() {
//		try {
//			startTime = System.currentTimeMillis();
//			/// CommonWebActions.waituntil("AddtionalPactab");
//			// CommonWebActions.webClick("AddtionalPactab");
//			// CommonWebActions.ICMclick("AddtionalPactab");
//
//			CommonWebActions.waituntil("AddtionalpacADD");
//			CommonWebActions.webClick("AddtionalpacADD");
//
//			CommonWebActions.waituntil("AddtionalpacTitle");
//			// CommonWebActions.webSetFromXls("AddtionalpacTitle", "AddtionalpacTitle");
//
//			// CommonWebActions.webSetFromXls("AddtionalpacDesc", "AddtionalpacDesc");
//
//			// CommonWebActions.webSetFromXls("AddtionalpacReason", "AddtionalpacReason");
//			// CommonWebActions.webSetFromXls("Addtionalpacprodtype", "Addtionalpacprodtype");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("addAdditionalPackage", stopTime - startTime);
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("Addtionalpacpersonid");
//
//			// CommonWebActions.webSetFromXls("Addtionalpacpersonid", "Addtionalpacpersonid");
//
//			CommonWebActions.webClick("Addtionalpacpersonidpopup");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("SelectAdditionalPackageIncharge", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void addAttachement() {
//		try {
//
//			CommonWebActions.waituntil("CreateDocumentbutton");
//			CommonWebActions.webClick("CreateDocumentbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("AttachementName");
//			// CommonWebActions.webSetFromXls("AttachementName", "AttachmentName");
//
//			CommonWebActions.waituntil("Browsebutton");
//			CommonWebActions.webClick("Browsebutton");
//
//			CommonWebActions.wait(15000);
//			CommonWindowsActions.winSet("FileName1", "FileLocation");
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("Openbutton");
//
//			CommonWebActions.waituntil("CreatedocumentOKbutton");
//			CommonWebActions.webClick("CreatedocumentOKbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.closeAlerts();
//
//			;
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void addEmailNotification() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("EmailNotification_AddButton");
//			CommonWebActions.webClick("EmailNotification_AddButton");
//
//			CommonWebActions.waituntil("EmailNotification_Personincharge");
//			CommonWebActions.webClick("EmailNotification_Personincharge");
//
//			// CommonWebActions.webSetFromXls("EmailNotification_Personincharge", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.ICMDownClick("EmailNotification_Personincharge");
//
//			CommonWebActions.waituntil("EmailNotification_IntiationtoEvaluation");
//			CommonWebActions.webClick("EmailNotification_IntiationtoEvaluation");
//
//			CommonWebActions.waituntil("EmailNotification_EvaluationtoDecision");
//			CommonWebActions.webClick("EmailNotification_EvaluationtoDecision");
//
//			CommonWebActions.waituntil("EmailNotification_DecisiontoImplementation");
//			CommonWebActions.webClick("EmailNotification_DecisiontoImplementation");
//
//			CommonWebActions.waituntil("EmailNotification_Closed");
//			CommonWebActions.webClick("EmailNotification_Closed");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("EmailNotification_Personincharge", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void submitPackage() throws Exception {
//
//		CommonWebActions.switchToDefaultContent();
//		//CommonWebActions.switchToiFrame1("iframeString2");
//		startTime = System.currentTimeMillis();
//		CommonWebActions.waituntil("IcmVersionFooter");
//		// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//		CommonWebActions.waituntil("SubmitChangeRequest");
//		CommonWebActions.webClick("SubmitChangeRequest");
//		
//		CommonWebActions.switchToDefaultContent();
//		CommonWebActions.waituntil("workBenchHeading");
//		stopTime = System.currentTimeMillis();
//		executionTimes.put("submitPackage", stopTime - startTime);
//
//		ReportUtil.reporterEvent("submitPackage", "CR created successfully" + CommonWebActions.captureScreenshotAsBase64());
//	}
//
//	public static void findCheckPackage() throws ConfigurationException, IOException {
//		String CheckPackagetask1 = null;
//		String CheckPackagetask2 = null;
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
////		\\	CommonWebActions.showmoreTasks();
//
//			CheckPackagetask1 = "xpath:=//a[starts-with(text(),'1. Check  \"" + packageNumber + "\"') and contains(text(),\"" + crTitle
//					+ "\")][@title='Click to work on the task']";
//
//			CheckPackagetask2 = CheckPackagetask1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", crTitle);
//			System.out.println("Replacedvalue" + CheckPackagetask2);
//			ORUtil.setValue("CheckPackagetask1", CheckPackagetask2);
//			CommonWebActions.waituntil("CheckPackagetask1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("findCheckPackage", stopTime - startTime);
//			System.out.println("CheckPackage task found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findCheckPackage");
//
//		}
//
//	}
//
//	public static void OpenCheckPackage() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("CheckPackagetask1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("CheckpackageiFrame");
//			System.out.println("switched to frame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("CheckpackageShellnumber");
//			System.out.println("Shell Number is displayed");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenCheckPackage", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenCheckPackage");
//
//		}
//	}
//
//	public static void FillCheckPackage() {
//		try {
//			startTime = System.currentTimeMillis();
//			String Checkpackagetitle = // CommonWebActions.gettext1("checkpackagegettilte");
//			System.out.println(Checkpackagetitle);
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "checkpackagegettilte", Checkpackagetitle);
//			CommonWebActions.waituntil("ChecpacRecommendation");
//
//			/*
//			 * // CommonWebActions.webSetFromXls("AddPacCheckpacApproval",
//			 * "AddPacCheckpacApproval");
//			 * // CommonWebActions.webSetFromXls("AddPacCheckpacApprovalComment",
//			 * "AddPacCheckpacApproval"); String
//			 * PackageNumber1=ExcelUtil.getDataFromExcel(onlyTestCaseName,
//			 * "packageNumber"); System.out.println(PackageNumber1); String
//			 * AdditionalpacNumber=PackageNumber1.substring(0, 8);
//			 * System.out.println(AdditionalpacNumber);
//			 * ExcelUtil.setDatatoExcel(onlyTestCaseName, "AdditionalpacNumber",
//			 * AdditionalpacNumber);
//			 */
//
//			// CommonWebActions.webSetFromXls("ChecpacRecommendation", "ChecpacRecommendation");
//			// CommonWebActions.webSetFromXls("ChecpacRecommendationComment", "ChecpacRecommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillCheckPackage", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//			SeleniumUtils.printError(e.getMessage());
//			SeleniumUtils.takeScreenshot("FillCheckPackage");
//			executionTimes.put("FillCheckPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishCheckPackage() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//			CommonWebActions.waituntil("FinishChecpacButton");
//			CommonWebActions.webClick("FinishChecpacButton");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishCheckPackage", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishCheckPackage");
//			executionTimes.put("FinishCheckPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//	public static void FinishCheckPackageWithFastTrack() {
//        try {
//
//               startTime = System.currentTimeMillis();
//               CommonWebActions.waituntil("IcmVersionFooter");
//               // CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//               CommonWebActions.waituntil("FinishChecpacButton");
//               CommonWebActions.webClick("FinishChecpacButton");
//               //Added to click on SubmitAnywayForFastTrack-Nishant
//               CommonWebActions.waituntil("SubmitAnywayForFastTrack");
//               CommonWebActions.webClick("SubmitAnywayForFastTrack");
//               
//               CommonWebActions.switchToDefaultContent();
//               CommonWebActions.waituntil("workBenchHeading");
//               stopTime = System.currentTimeMillis();
//               executionTimes.put("FinishCheckPackage", stopTime - startTime);
//        } catch (Exception exception) {
//               SeleniumUtils.printError(exception.getMessage());
//               SeleniumUtils.takeScreenshot("FinishCheckPackage");
//               executionTimes.put("FinishCheckPackage", new Long(EXECUTION_FAILURE_TIME));
//        }
//
// }
//
//	public static void findAdditionalPackage() throws ConfigurationException, IOException {
//		String AdditionalPackagetask1 = null;
//		String AdditionalPackagetask2 = null;
//		String Additionalpactitle = null;
//		String Additionalpacnumber = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//	//	CommonWebActions.showmoreTasks();
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			Additionalpactitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "AddtionalpacTitle");
//
//			Additionalpacnumber = ExcelUtil.getDataFromExcel(onlyTestCaseName, "AdditionalpacNumber");
//
//			AdditionalPackagetask1 = "xpath:=//a[starts-with(text(),'Review additional Package from \"" + Additionalpacnumber + "\"') and contains(text(),\""
//					+ Additionalpactitle + "\")][@title='Click to work on the task']";
//
//			AdditionalPackagetask2 = AdditionalPackagetask1.replaceAll("Additionalpacnumber", Additionalpacnumber).replaceAll("Additionalpactitle",
//					Additionalpactitle);
//			System.out.println("Replacedvalue" + AdditionalPackagetask2);
//			ORUtil.setValue("AdditionalPackagetask1", AdditionalPackagetask2);
//			CommonWebActions.waituntil("AdditionalPackagetask1");
//			System.out.println("AdditionalPackage task found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("AdditionalPackagetask");
//
//		}
//
//	}
//
//	public static void OpenAdditionalPackage() {
//
//		try {
//
//			CommonWebActions.webClick("AdditionalPackagetask1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("Additionalpaciframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("AdditionalpackageShellnumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenAdditionalPackage");
//
//		}
//	}
//
//	public static void FillAdditionalPackage() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("Additionalpacsubmitter");
//
//			CommonWebActions.wait(10000);
//
//			// CommonWebActions.webSetFromXls("Additionalpacsubmitter", "Addtionalpacpersonid", true);
//
//			CommonWebActions.wait(10000);
//
//			// CommonWebActions.webSetFromXls("AdditionalpacRecommendation", "AdditionalpacRecommendation");
//
//			// CommonWebActions.webSetFromXls("AdditionalpacRecommendationComment", "AdditionalpacRecommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillAdditionalPackage", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//			SeleniumUtils.printError(e.getMessage());
//			SeleniumUtils.takeScreenshot("FillAdditionalPackage");
//			executionTimes.put("FillAdditionalPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishAdditionalPackage() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//			CommonWebActions.waituntil("FinishAdditionalpacButton");
//			CommonWebActions.webClick("FinishAdditionalpacButton");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishAdditionalPackage", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishAdditionalPackage");
//			executionTimes.put("FinishAdditionalPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void findinitiateAdditionalPackage() throws ConfigurationException, IOException {
//		String AdditionalinitiatePackagetask1 = null;
//		String AdditionalinitiatePackagetask2 = null;
//		String Additionalpactitle = null;
//		String Additionalpacnumber = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			Additionalpactitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "AddtionalpacTitle");
//
//			Additionalpacnumber = ExcelUtil.getDataFromExcel(onlyTestCaseName, "AdditionalpacNumber");
//
//			AdditionalinitiatePackagetask1 = "xpath:=//a[starts-with(text(),'1. Initiate additional Package from \"" + Additionalpacnumber
//					+ "\"') and contains(text(),\"" + Additionalpactitle + "\")][@title='Click to work on the task']";
//
//			AdditionalinitiatePackagetask2 = AdditionalinitiatePackagetask1.replaceAll("Additionalpacnumber", Additionalpacnumber)
//					.replaceAll("Additionalpactitle", Additionalpactitle);
//			System.out.println("Replacedvalue" + AdditionalinitiatePackagetask2);
//			ORUtil.setValue("AdditionalinitiatePackagetask1", AdditionalinitiatePackagetask2);
//			CommonWebActions.waituntil("AdditionalinitiatePackagetask1");
//			System.out.println("AdditionalinitiatePackage task found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("AdditionalinitiatePackagetask");
//
//		}
//
//	}
//
//	public static void OpeninitiateAdditionalPackage() {
//
//		try {
//
//			CommonWebActions.webClick("AdditionalinitiatePackagetask1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("Additionalinitiatepaciframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("AdditionalinitiatepackageShellnumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpeninitiateAdditionalPackage");
//
//		}
//	}
//
//	public static void FillinitiateAdditionalPackage() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.wait(2000);
//
//			CommonWebActions.waituntil("ZeusNumbertext");
//
//			// CommonWebActions.webSetFromXls("ZeusNumbertext", "ZeusNumbertext");
//
//			CommonWebActions.waituntil("AddBaumusterbutton");
//
//			CommonWebActions.webClick("AddBaumusterbutton");
//
//			CommonWebActions.wait(12000);
//
//			AUT.addBaumuster_additionalpac();
//
//			CommonWebActions.wait(12000);
//
//			CommonWebActions.waituntil("AddTechsolbutton");
//
//			CommonWebActions.webClick("AddTechsolbutton");
//
//			AUT.distributeTechSol();
//
//			// // CommonWebActions.webSetFromXls("AddiIntiatepacRecomm","AdditionalpacRecommendation");
//
//			// // CommonWebActions.webSetFromXls("AdditionalpacRecommendationComment","AdditionalpacRecommendation");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillAdditionalPackage", stopTime - startTime);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//			SeleniumUtils.printError(e.getMessage());
//			SeleniumUtils.takeScreenshot("FillAdditionalPackage");
//			executionTimes.put("FillAdditionalPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishinitiateAdditionalPackage() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//			CommonWebActions.waituntil("FinishAdditionalpacButton");
//			CommonWebActions.webClick("FinishAdditionalpacButton");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishAdditionalPackage", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishAdditionalPackage");
//			executionTimes.put("FinishAdditionalPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishCheckPackageFasttrack() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("FinishChecpacButton");
//			CommonWebActions.webClick("FinishChecpacButton");
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("ConfirmFastTrack");
//			CommonWebActions.webClick("ConfirmFastTrack");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishCheckPackage", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishCheckPackage");
//			executionTimes.put("FinishCheckPackage", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	/*public static void FindEvaluatetask1() throws ConfigurationException, IOException {
//		String EvaluationTask1 = null;
//		String EvaluationTask2 = null;
//
//		System.out.println(packageNumber);
//		startTime = System.currentTimeMillis();
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("WorkTab");
//
//		CommonWebActions.webClick("WorkTab");
//
//	\\	CommonWebActions.showmoreTasks();
//
//		String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//		final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//		System.out.println(CRtitle);
//
//		EvaluationTask1 = "xpath:=//a[starts-with(text(),'2. Evaluate \"" + packageNumber + "\"') and contains(text(),\"" + CRtitle
//				+ "\")][@title='Click to work on the task']";
//
//		EvaluationTask2 = EvaluationTask1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//		System.out.println("Replacedvalue" + EvaluationTask2);
//		ORUtil.setValue("EvaluationTask1", EvaluationTask2);
//		CommonWebActions.waituntil("EvaluationTask1");
//		stopTime = System.currentTimeMillis();
//		executionTimes.put("FindEvaluationtask", stopTime - startTime);
//
//		startTime = System.currentTimeMillis();
//		CommonWebActions.webClick("EvaluationTask1");
//		CommonWebActions.switchToDefaultContent();
//		System.out.println("switched to default content");
//		CommonWebActions.waituntil("EvaluationtaskiFrame");
//		//CommonWebActions.switchToiFrame1("EvaluationtaskiFrame");
//		System.out.println("switched to frame");
//		CommonWebActions.waituntil("EvaluatetaskShellNumber");
//		System.out.println("Shell Number is displayed");
//		stopTime = System.currentTimeMillis();
//		executionTimes.put("OPenEvaluationtask", stopTime - startTime);
//
//		// CommonWebActions.waituntil("PersoninchargefieldCVE");
//
//		// CommonWebActions.webClick("PersoninchargefieldCVE");
//
//		CommonWebActions.scrollup1();
//
//		if (statementsToRun.contains(Consolidationviewstmts.CVE)) {
//			CommonWebActions.scrollup1();
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldCVEstmt", "PersoninchargedropdownCVE", "Addtionalpacpersonid", "CVEstmtDate", "CVEstmtDate",
//					"CVEstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeCVE", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//
//		if (statementsToRun.contains(Consolidationviewstmts.CVPC)) {
//			CommonWebActions.scrollup1();
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldCVPCstmt", "PersoninchargedropdownCVPC", "Addtionalpacpersonid", "CVPCstmtDate", "CVEstmtDate",
//					"CVPCstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeCVPC", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//
//		if (statementsToRun.contains(Consolidationviewstmts.CVP)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldCVPstmt", "PersoninchargedropdownCVP", "Addtionalpacpersonid", "CVPstmtDate", "CVEstmtDate",
//					"CVPstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeCVP", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//
//		if (statementsToRun.contains(STATEMENTS.DESIGN)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldDesignstmt", "PersoninchargedropdownDesign", "Addtionalpacpersonid", "DesignstmtDate", "DesignstmtDate",
//					"DesignstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeDesignstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.TESTING)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldTestingstmt", "PersoninchargedropdownTesting", "Addtionalpacpersonid", "TestingstmtDate",
//					"DesignstmtDate", "TestingstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeTestingstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.HOMOLOGATION)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldHomologationstmt", "PersoninchargedropdownHomologation", "Addtionalpacpersonid", "HomologationstmtDate",
//					"DesignstmtDate", "HomologationstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeHomologationstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SDC)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldSDCstmt", "PersoninchargedropdownSDC", "Addtionalpacpersonid", "SDCstmtDate", "DesignstmtDate",
//					"SDCstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeSDCstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.PURCHASING)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldPurchasingstmt", "PersoninchargedropdownPurchasing", "Addtionalpacpersonid", "PurchasingstmtDate",
//					"DesignstmtDate", "PurchasingstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributePurchasingstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.COST_ENGINEERING)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldCostEngstmt", "PersoninchargedropdownCostEng", "Addtionalpacpersonid", "CostEngstmtDate",
//					"DesignstmtDate", "CostEngstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeCostEngineeringstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.ME)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldMfgEngstmt", "PersoninchargedropdownMfgEng", "Addtionalpacpersonid", "MfgEngstmtDate", "DesignstmtDate",
//					"MfgEngstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeMEstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.LOGISTICS)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldLogisticsstmt", "PersoninchargedropdownLogistics", "Addtionalpacpersonid", "LogisticsstmtDate",
//					"DesignstmtDate", "LogisticsstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeLogisticsstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SM)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldSMstmt", "PersoninchargedropdownSM", "Addtionalpacpersonid", "SMstmtDate", "DesignstmtDate",
//					"SMstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeSMstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SALES)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldSalesstmt", "PersoninchargedropdownSales", "Addtionalpacpersonid", "SalesstmtDate", "DesignstmtDate",
//					"SalesstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeSalesstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.MODULE_STRATEGY)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldModstrategystmt", "PersoninchargedropdownModstrategy", "Addtionalpacpersonid", "ModstrategystmtDate",
//					"DesignstmtDate", "ModstrategystmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeModuleStrategystmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.AFTERSALES)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldAftersalesstmt", "PersoninchargedropdownAftersales", "Addtionalpacpersonid", "AftersalesstmtDate",
//					"DesignstmtDate", "AftersalesstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeAftersalesstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.QM)) {
//			startTime = System.currentTimeMillis();
//			selectEvalautionStmts1("PersoninchargeFieldQMstmt", "PersoninchargedropdownQM", "Addtionalpacpersonid", "QMstmtDate", "DesignstmtDate",
//					"QMstmtCheckbox");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeQMstmt", stopTime - startTime);
//			CommonWebActions.scrollDown(40);
//		}
//
//		CommonWebActions.waituntil("EvalDistributeButton");
//		// CommonWebActions.webClick("EvalDistributeButton");
//	//	CommonWebActions.ICMclick("EvalDistributeButton");
//
//	}
//*/
//	/*public static void FindEvaluatetask2() throws ConfigurationException, IOException {
//		String EvaluationTask1 = null;
//		String EvaluationTask2 = null;
//
//		System.out.println(packageNumber);
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("WorkTab");
//
//		CommonWebActions.webClick("WorkTab");
//
//	\\	CommonWebActions.showmoreTasks();
//
//		String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//		final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//		System.out.println(CRtitle);
//
//		EvaluationTask1 = "xpath:=//a[starts-with(text(),'2. Evaluate \"" + packageNumber + "\"') and contains(text(),\"" + CRtitle
//				+ "\")][@title='Click to work on the task']";
//
//		EvaluationTask2 = EvaluationTask1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//		System.out.println("Replacedvalue" + EvaluationTask2);
//		ORUtil.setValue("EvaluationTask1", EvaluationTask2);
//		CommonWebActions.waituntil("EvaluationTask1");
//
//		CommonWebActions.webClick("EvaluationTask1");
//		CommonWebActions.switchToDefaultContent();
//		System.out.println("switched to default content");
//		CommonWebActions.waituntil("EvaluationtaskiFrame");
//		//CommonWebActions.switchToiFrame1("EvaluationtaskiFrame");
//		System.out.println("switched to frame");
//		CommonWebActions.waituntil("EvaluatetaskShellNumber");
//		System.out.println("Shell Number is displayed");
//
//		// CommonWebActions.waituntil("PersoninchargefieldCVE");
//
//		// CommonWebActions.webClick("PersoninchargefieldCVE");
//
//		CommonWebActions.scrollup1();
//
//		
//		 * if (statementsToRun.contains(STATEMENTS.CVE)) {
//		 * 
//		 * selectEvalautionStmts1("PersoninchargeFieldCVEstmt",
//		 * "PersoninchargedropdownCVE", "Addtionalpacpersonid", "CVEstmtDate",
//		 * "CVEstmtDate", "CVEstmtCheckbox"); CommonWebActions.scrollDown(40); }
//		 * 
//		 * if (statementsToRun.contains(STATEMENTS.CVPC)) {
//		 * 
//		 * selectEvalautionStmts1("PersoninchargeFieldCVPCstmt",
//		 * "PersoninchargedropdownCVPC", "Addtionalpacpersonid", "CVPCstmtDate",
//		 * "CVEstmtDate", "CVPCstmtCheckbox"); CommonWebActions.scrollDown(40);
//		 * }
//		 * 
//		 * if (statementsToRun.contains(STATEMENTS.CVP)) {
//		 * selectEvalautionStmts1("PersoninchargeFieldCVPstmt",
//		 * "PersoninchargedropdownCVP", "Addtionalpacpersonid", "CVPstmtDate",
//		 * "CVEstmtDate", "CVPstmtCheckbox"); CommonWebActions.scrollDown(40); }
//		 
//		if (statementsToRun.contains(STATEMENTS.DESIGN)) {
//
//			selectEvalautionStmts1("PersoninchargeFieldDesignstmt", "PersoninchargedropdownDesign", "Addtionalpacpersonid", "DesignstmtDate", "DesignstmtDate",
//					"DesignstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.TESTING)) {
//			selectEvalautionStmts1("PersoninchargeFieldTestingstmt", "PersoninchargedropdownTesting", "Addtionalpacpersonid", "TestingstmtDate",
//					"DesignstmtDate", "TestingstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.HOMOLOGATION)) {
//			selectEvalautionStmts1("PersoninchargeFieldHomologationstmt", "PersoninchargedropdownHomologation", "Addtionalpacpersonid", "HomologationstmtDate",
//					"DesignstmtDate", "HomologationstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SDC)) {
//			selectEvalautionStmts1("PersoninchargeFieldSDCstmt", "PersoninchargedropdownSDC", "Addtionalpacpersonid", "SDCstmtDate", "DesignstmtDate",
//					"SDCstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.PURCHASING)) {
//			selectEvalautionStmts1("PersoninchargeFieldPurchasingstmt", "PersoninchargedropdownPurchasing", "Addtionalpacpersonid", "PurchasingstmtDate",
//					"DesignstmtDate", "PurchasingstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.COST_ENGINEERING)) {
//			selectEvalautionStmts1("PersoninchargeFieldCostEngstmt", "PersoninchargedropdownCostEng", "Addtionalpacpersonid", "CostEngstmtDate",
//					"DesignstmtDate", "CostEngstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.ME)) {
//			selectEvalautionStmts1("PersoninchargeFieldMfgEngstmt", "PersoninchargedropdownMfgEng", "Addtionalpacpersonid", "MfgEngstmtDate", "DesignstmtDate",
//					"MfgEngstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.LOGISTICS)) {
//			selectEvalautionStmts1("PersoninchargeFieldLogisticsstmt", "PersoninchargedropdownLogistics", "Addtionalpacpersonid", "LogisticsstmtDate",
//					"DesignstmtDate", "LogisticsstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SM)) {
//			selectEvalautionStmts1("PersoninchargeFieldSMstmt", "PersoninchargedropdownSM", "Addtionalpacpersonid", "SMstmtDate", "DesignstmtDate",
//					"SMstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.SALES)) {
//			selectEvalautionStmts1("PersoninchargeFieldSalesstmt", "PersoninchargedropdownSales", "Addtionalpacpersonid", "SalesstmtDate", "DesignstmtDate",
//					"SalesstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.MODULE_STRATEGY)) {
//			selectEvalautionStmts1("PersoninchargeFieldModstrategystmt", "PersoninchargedropdownModstrategy", "Addtionalpacpersonid", "ModstrategystmtDate",
//					"DesignstmtDate", "ModstrategystmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.AFTERSALES)) {
//			selectEvalautionStmts1("PersoninchargeFieldAftersalesstmt", "PersoninchargedropdownAftersales", "Addtionalpacpersonid", "AftersalesstmtDate",
//					"DesignstmtDate", "AftersalesstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//		if (statementsToRun.contains(STATEMENTS.QM)) {
//			selectEvalautionStmts1("PersoninchargeFieldQMstmt", "PersoninchargedropdownQM", "Addtionalpacpersonid", "QMstmtDate", "DesignstmtDate",
//					"QMstmtCheckbox");
//			CommonWebActions.scrollDown(40);
//		}
//
//		CommonWebActions.waituntil("EvalDistributeButton");
//		// CommonWebActions.webClick("EvalDistributeButton");
//	//	CommonWebActions.ICMclick("EvalDistributeButton");
//
//	}
//*/
//	public static void SeletPersonINcahrgeForDesignStmt() {
//
//		try {
//			startTimeRR = System.currentTimeMillis();
//			CommonWebActions.webClick("PersonInchargeDesignstmt");
//
//			CommonWebActions.waituntilTileContains("Roles and Rights");
//
//			CommonWebActions.webClick("packRespSearch2");
//
//			CommonWebActions.waituntil("PackageUser");
//			CommonWebActions.webClick("PackageUser");
//
//			CommonWebActions.waituntil("Searchuser");
//			CommonWebActions.webClick("Searchuser");
//
//			CommonWebActions.waituntil("AllLink");
//			CommonWebActions.webClick("AllLink");
//
////			CommonWebActions.SelectUser("Username2", "attribute", "valueToSet1", "valueToSet");
//			CommonWebActions.waituntil("packRespSubmit");
//			CommonWebActions.webClick("packRespSubmit");
//			CommonWebActions.waituntil("SubmitEvaluation");
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("RolesAndRights-StatementExpertDesign", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("RolesAndRights-StatementExpertDesign");
//			executionTimes.put("RolesAndRights-StatementExpertDesign", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//		ReportUtil.reporterEvent("StatementExpertDesign", "StatementExpertDesign selectd successfully" + CommonWebActions.captureScreenshotAsBase64());
//	}
//
//	public static void SeletPersonINcahrgeForTestingStmt() {
//
//		try {
//			startTimeRR = System.currentTimeMillis();
//			CommonWebActions.webClick("PersonInchargeTestingstmt");
//
//			CommonWebActions.waituntilTileContains("Roles and Rights");
//
//			CommonWebActions.webClick("packRespSearch2");
//
//			CommonWebActions.waituntil("PackageUser");
//			CommonWebActions.webClick("PackageUser");
//
//			CommonWebActions.waituntil("Searchuser");
//			CommonWebActions.webClick("Searchuser");
//
//			CommonWebActions.waituntil("AllLink");
//			CommonWebActions.webClick("AllLink");
//
////			CommonWebActions.SelectUser("Username2", "attribute", "valueToSet1", "valueToSet");
//			CommonWebActions.waituntil("packRespSubmit");
//			CommonWebActions.webClick("packRespSubmit");
//			CommonWebActions.waituntil("SubmitEvaluation");
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("RolesAndRights-StatementExpertDesign", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("RolesAndRights-StatementExpertDesign");
//			executionTimes.put("RolesAndRights-StatementExpertDesign", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//		ReportUtil.reporterEvent("StatementExpertDesign", "StatementExpertDesign selectd successfully" + CommonWebActions.captureScreenshotAsBase64());
//	}
//
//	public static void FindDesignstmt() throws ConfigurationException, IOException {
//		String Designstmt1 = null;
//		String Designstmt2 = null;
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			Designstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Design" + "\" Statement for \"" + packageNumber + "\"') and contains(text(),\""
//					+ CRtitle + "\")][@title='Click to work on the task']";
//
//			Designstmt2 = Designstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Designstmt2);
//			ORUtil.setValue("Designstmt1", Designstmt2);
//			CommonWebActions.waituntil("Designstmt1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FindDesignstmt", stopTime - startTime);
//			System.out.println("design stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindDesignstmt");
//
//		}
//
//	}
//
//	public static void OpenDesignStatement() {
//
//		try {
//			startTime = System.currentTimeMillis();
//		//	CommonWebActions.ICMclick("Designstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("DesignstmtiFrame");
//			System.out.println("switched to frame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//			CommonWebActions.waituntil("DesignstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenDesignStatement", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfo() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			//CommonWebActions.webClick("DesignDistributeTeams");
//
//			//CommonWebActions.waituntil("desteamheader");
//			//CommonWebActions.webClick("desteamheader");
//
//			CommonWebActions.waituntil("desTeaminfoAddbutton");
//			CommonWebActions.webClick("desTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("desTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.waituntil("Designteaminfotechexpertpopup");
//
//			CommonWebActions.webClick("Designteaminfotechexpertpopup");
//
//			CommonWebActions.waituntil("desTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("desTeaminfoteamlist", "desTeaminfoteamlist");
//
//			CommonWebActions.waituntil("desTeaminfoTasksdesc");
//			// CommonWebActions.webSetFromXls("desTeaminfoTasksdesc", "desTeaminfoteamlist");
//
//			CommonWebActions.waituntil("DesignDistributeTeams");
//			CommonWebActions.webClick("DesignDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void distributeTeamInfoDesign() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			distributeTeamInfo("desteamheader", "Numberofteams", "Addtionalpacpersonid", "desTeaminfoteamlist", "desTeaminfoTasksdesc");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfodesign() {
//
//		String Designteaminfo1 = null;
//		String Designteaminfo2 = null;
//		try {
//			startTime = System.currentTimeMillis();
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		//CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			Designteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Design" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			Designteaminfo2 = Designteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Designteaminfo2);
//			ORUtil.setValue("Designteaminfo1", Designteaminfo2);
//
//			CommonWebActions.waituntil("Designteaminfo1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("findTeaminfodesign", stopTime - startTime);
//
//			System.out.println("findTeaminfodesign found successfully");
//			ReportUtil.reporterEvent("findTeaminfodesign", "findTeaminfodesign  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfodesign");
//			executionTimes.put("findTeaminfodesign", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoDesign() {
//
//		try {
//			startTime = System.currentTimeMillis();
//		//	CommonWebActions.ICMclick("Designteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("DesignteaminfoiFrame");
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("DesignteaminfoShellNumber");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenTeaminfoDesign", stopTime - startTime);
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoDesign", "OpenTeaminfoDesign opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoDesign");
//
//		}
//
//	}
//
//	public static void FillTeamInfo() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("TeamTaskDesignteaminfo");
//			// CommonWebActions.webSetFromXls("TeamTaskDesignteaminfo", "desTeaminfoTasksdesc");
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			/*
//			 * String Hourlyrate=// CommonWebActions.gettext1("Hourlyrate");
//			 * System.out.println(Hourlyrate); int
//			 * Hourlyrate1=Integer.parseInt(Hourlyrate);
//			 * 
//			 * 
//			 * CommonWebActions.waituntil("Internalheader");
//			 * CommonWebActions.webClick("Internalheader");
//			 * 
//			 * CommonWebActions.waituntil("desInternalEffort");
//			 * // CommonWebActions.webSetFromXls("desInternalEffort",
//			 * "desInternalEffortHours");
//			 * 
//			 * String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			 * 
//			 * /* String desInternalEffortHours =
//			 * ExcelUtil.getDataFromExcel(onlyTestCaseName,
//			 * "desInternalEffortHours");
//			 * System.out.println(desInternalEffortHours); int
//			 * desInternalEffortHours1=Integer.parseInt(desInternalEffortHours);
//			 * int desInternalEffort=(Hourlyrate1)*(desInternalEffortHours1);
//			 * System.out.println(desInternalEffort);
//			 */
//
//			CommonWebActions.waituntil("desInternalEffort");
//			// CommonWebActions.webSetFromXls("desInternalEffort", "desInternalEffortHours");
//
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webClick("desInternalEffortComment");
//			// CommonWebActions.waituntil("desInternalEffortComment");
//			// CommonWebActions.webSetFromXls("desInternalEffortComment", "desInternalEffortComment");
//
//			double desInternalEffort = AUT.Costvalue("desInternalEffortHours", "Hourlyrate");
//			System.out.println(desInternalEffort);
//
//			CommonWebActions.wait(3000);
//			double desInternalEffort1 = CommonWebActions.getValue("desInternalEffortValue");
//			System.out.println(desInternalEffort1);
//
//			double cmp = Double.compare(desInternalEffort, desInternalEffort1);
//
//			System.out.println(cmp);
//			if (cmp == 0) {
//				String desInternalEffort2 = Double.toString(desInternalEffort);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "desInternalEffort", desInternalEffort2);
//
//			}
//
//			//CommonWebActions.webClick("desInternalEffortPartNumber");
//			//// CommonWebActions.webSetFromXls("desInternalEffortPartNumber", "desInternalEffortPartNumber");
//
//			/*
//			 * String desInternalCostsHours =
//			 * ExcelUtil.getDataFromExcel(onlyTestCaseName,
//			 * "desInternalCostsHours");
//			 * System.out.println(desInternalCostsHours); int
//			 * desInternalCostsHours1=Integer.parseInt(desInternalCostsHours);
//			 * int desInternalCosts=(Hourlyrate1)*(desInternalCostsHours1);
//			 * System.out.println(desInternalCosts);
//			 */
//			/*
//			 * CommonWebActions.webClick("desInternalCostsHours");
//			 * CommonWebActions.webSet("desInternalCostsHours",
//			 * "desInternalCostsHours");
//			 * 
//			 * CommonWebActions.webClick("desInternalCostsComment");
//			 * CommonWebActions.webSet("desInternalCostsComment",
//			 * "desInternalCostsComment");
//			 * 
//			 * double desInternalCosts = CommonWebActions.Costvalue(
//			 * "desInternalCostsHours", "Hourlyrate");
//			 * System.out.println(desInternalCosts);
//			 * 
//			 * CommonWebActions.wait(3000); double desInternalCosts1 =
//			 * CommonWebActions .getValue("desInternalCostsValue");
//			 * System.out.println(desInternalCosts1);
//			 * 
//			 * double cmp1 = Double.compare(desInternalEffort,
//			 * desInternalEffort1);
//			 * 
//			 * System.out.println(cmp1);
//			 * 
//			 * if (cmp1 == 0) { String desInternalCosts2 =
//			 * Double.toString(desInternalCosts);
//			 * 
//			 * ExcelUtil.setDatatoExcel(onlyTestCaseName, "desInternalCosts",
//			 * desInternalCosts2);
//			 * 
//			 * }
//			 * 
//			 * CommonWebActions.webClick("desInternalCostsPartNumber");
//			 * CommonWebActions.webSet("desInternalCostsPartNumber",
//			 * "desInternalCostsPartNumber");
//			 * 
//			 * 
//			 * String desInternalDocumentationeffortHours =
//			 * ExcelUtil.getDataFromExcel(onlyTestCaseName,
//			 * "desInternalDocumentationeffortHours");
//			 * System.out.println(desInternalCostsHours); int
//			 * desInternalDocumentationeffortHours1
//			 * =Integer.parseInt(desInternalDocumentationeffortHours); int
//			 * desInternalDocumentationeffort
//			 * =(Hourlyrate1)*(desInternalDocumentationeffortHours1);
//			 * System.out.println(desInternalDocumentationeffort);
//			 * 
//			 * 
//			 * CommonWebActions.webClick("desInternalDocumentationeffortHours");
//			 * CommonWebActions.webSet("desInternalDocumentationeffortHours",
//			 * "desInternalDocumentationeffortHours");
//			 * 
//			 * CommonWebActions.webClick(
//			 * "desInternalDocumentationeffortComment") ;
//			 * CommonWebActions.webSet("desInternalDocumentationeffortComment",
//			 * "desInternalDocumentationeffortComment");
//			 * 
//			 * double desInternalDocumentationeffort =
//			 * CommonWebActions.Costvalue(
//			 * "desInternalDocumentationeffortHours", "Hourlyrate");
//			 * System.out.println(desInternalDocumentationeffort);
//			 * 
//			 * CommonWebActions.wait(3000); double
//			 * desInternalDocumentationeffort1 = CommonWebActions
//			 * .getValue("desInternalDocumentationeffortValue");
//			 * System.out.println(desInternalDocumentationeffort1);
//			 * 
//			 * double cmp2 = Double.compare(desInternalDocumentationeffort,
//			 * desInternalDocumentationeffort1);
//			 * 
//			 * System.out.println(cmp2);
//			 * 
//			 * if (cmp2 == 0) { String desInternalDocumentationeffort2 = Double
//			 * .toString(desInternalDocumentationeffort);
//			 * 
//			 * ExcelUtil.setDatatoExcel(onlyTestCaseName,
//			 * "desInternalDocumentationeffort",
//			 * desInternalDocumentationeffort2);
//			 * 
//			 * }
//			 * 
//			 * CommonWebActions
//			 * .webClick("desInternalDocumentationeffortPartNumber");
//			 * CommonWebActions
//			 * .webSet("desInternalDocumentationeffortPartNumber",
//			 * "desInternalDocumentationeffortPartNumber");
//			 * 
//			 * CommonWebActions.webClick("desInternalSimulationeffortHours");
//			 * CommonWebActions.webSet("desInternalSimulationeffortHours",
//			 * "desInternalSimulationeffortHours");
//			 * 
//			 * CommonWebActions.webClick("desInternalSimulationeffortComment");
//			 * CommonWebActions.webSet("desInternalSimulationeffortComment",
//			 * "desInternalSimulationeffortComment");
//			 * 
//			 * double desInternalSimulationeffort = CommonWebActions.Costvalue(
//			 * "desInternalSimulationeffortHours", "Hourlyrate");
//			 * System.out.println("desInternalSimulationeffort" +
//			 * desInternalSimulationeffort);
//			 * 
//			 * CommonWebActions.waituntil("desInternalSimulationeffortValue");
//			 * CommonWebActions.wait(3000);
//			 * 
//			 * double desInternalSimulationeffort1 = CommonWebActions
//			 * .getValue("desInternalSimulationeffortValue");
//			 * System.out.println("desInternalSimulationeffortValue" +
//			 * desInternalSimulationeffort1);
//			 * 
//			 * double cmp3 = Double.compare(desInternalDocumentationeffort,
//			 * desInternalDocumentationeffort1);
//			 * 
//			 * System.out.println(cmp3);
//			 * 
//			 * if (cmp3 == 0) { String desInternalSimulationeffort2 = Double
//			 * .toString(desInternalSimulationeffort);
//			 * 
//			 * ExcelUtil.setDatatoExcel(onlyTestCaseName,
//			 * "desInternalSimulationeffort", desInternalSimulationeffort2);
//			 * 
//			 * }
//			 * 
//			 * CommonWebActions.webClick(
//			 * "desInternalSimulationeffortPartNumber") ;
//			 * CommonWebActions.webSet("desInternalSimulationeffortPartNumber",
//			 * "desInternalSimulationeffortPartNumber");
//			 */
//			CommonWebActions.webClick("desExternalMaterial");
//			// CommonWebActions.webSetFromXls("desExternalMaterial", "desExternalMaterial");
//
//			// String desExternalMaterialValue2=
//			// Double.toString(desExternalMaterialValue1);
//
//			// ExcelUtil.setDatatoExcel(onlyTestCaseName,
//			// "desExternalMaterialValue1", desExternalMaterialValue2);
//
//			CommonWebActions.webClick("desExternalMaterialComment");
//			// CommonWebActions.webSetFromXls("desExternalMaterialComment", "desExternalMaterialComment");
//
//			CommonWebActions.wait(3000);
//			double desExternalMaterialValue1 = CommonWebActions.getValue("desExternalMaterialValue");
//			System.out.println(desExternalMaterialValue1);
//
//			//CommonWebActions.webClick("descExternalMaterialPartNumber");
//			//// CommonWebActions.webSetFromXls("descExternalMaterialPartNumber", "descExternalMaterialPartNumber");
//
//			CommonWebActions.webClick("desExternalCosts");
//			// CommonWebActions.webSetFromXls("desExternalCosts", "desExternalCosts");
//
//			// String desExternalCostsValue2=
//			// Double.toString(desExternalCostsValue1);
//
//			// ExcelUtil.setDatatoExcel(onlyTestCaseName,
//			// "desExternalCostsValue", desExternalCostsValue2);
//
//			CommonWebActions.webClick("desExternalCostsComment");
//			// CommonWebActions.webSetFromXls("desExternalCostsComment", "desExternalCostsComment");
//
//			CommonWebActions.wait(3000);
//			double desExternalCostsValue1 = CommonWebActions.getValue("desExternalCostsValue");
//			System.out.println(desExternalCostsValue1);
//
//			//CommonWebActions.webClick("desExternalCostsPartNumber");
//			//// CommonWebActions.webSetFromXls("desExternalCostsPartNumber", "desExternalCostsPartNumber");
//
//			CommonWebActions.webClick("desExternalEngineering");
//			// CommonWebActions.webSetFromXls("desExternalEngineering", "desExternalEngineering");
//
//			// String desExternalEngineeringValue2=
//			// Double.toString(desExternalEngineeringValue1);
//
//			// ExcelUtil.setDatatoExcel(onlyTestCaseName,
//			// "desExternalEngineeringValue1", desExternalEngineeringValue2);
//
//			CommonWebActions.webClick("desExternalEngineeringComment");
//			// CommonWebActions.webSetFromXls("desExternalEngineeringComment", "desExternalEngineeringComment");
//
//			CommonWebActions.wait(3000);
//			double desExternalEngineeringValue1 = CommonWebActions.getValue("desExternalEngineeringValue");
//			System.out.println(desExternalEngineeringValue1);
//
//			//CommonWebActions.webClick("desExternalEngineeringPartNumber");
//			//// CommonWebActions.webSetFromXls("desExternalEngineeringPartNumber", "desExternalEngineeringPartNumber");
//
//			CommonWebActions.webClick("desUpdateoverallcostsbutton");
//		//	CommonWebActions.ICMclick("desUpdateoverallcostsbutton");
//
//			double desTotalcostsvalue = desInternalEffort + +desExternalMaterialValue1 + desExternalCostsValue1 + desExternalEngineeringValue1;
//
//			// desInternalCosts+ desInternalDocumentationeffort+
//			// desInternalSimulationeffort
//			System.out.println("desTotalcostsvalue" + desTotalcostsvalue);
//
//			CommonWebActions.wait(3000);
//			double desTotalcostsvalue1 = CommonWebActions.getValue("desTotalcostsvalue");
//			System.out.println("desTotalcostsvalue1" + desTotalcostsvalue1);
//
//			double cmp4 = Double.compare(desTotalcostsvalue, desTotalcostsvalue1);
//
//			System.out.println(cmp4);
//
//			/*double desTotalcostsInternalvalue = desInternalEffort;
//
//			// + desInternalCosts + desInternalDocumentationeffort
//			// + desInternalSimulationeffort
//			System.out.println("desTotalcostsInternalvalue" + desTotalcostsInternalvalue);
//
//			String desTotalcostsInternalvalue1 = Double.toString(desTotalcostsInternalvalue);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "desTotalcostsInternalvalue", desTotalcostsInternalvalue1);
//
//			double desTotalcostsExternallvalue = desExternalMaterialValue1 + desExternalCostsValue1 + desExternalEngineeringValue1;
//			System.out.println("desTotalcostsExternallvalue" + desTotalcostsExternallvalue);
//
//			String desTotalcostsExternallvalue1 = Double.toString(desTotalcostsExternallvalue);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "desTotalcostsExternallvalue", desTotalcostsExternallvalue1);*/
//
//			CommonWebActions.webClick("desExternalEngineering");
//
//			//CommonWebActions.waituntil("Milestonetypeheader");
//			//CommonWebActions.webClick("Milestonetypeheader");
//
//			CommonWebActions.waituntil("Des_MilestoneAddButton");
//			CommonWebActions.webClick("Des_MilestoneAddButton");
//
//			CommonWebActions.webClick("Des_MilestoneAddButton");
//			// CommonWebActions.ICMclick("Des_MilestoneAddButton");
//			
//			//Need to work from here for 8.1 int2
//
//			CommonWebActions.waituntil("Des_Milestonetype1");
//			// CommonWebActions.webSetFromXls("Des_Milestonetype1", "Des_Milestonetype1");
//
//			CommonWebActions.webClick("desMilestoneDesignRelease");
//			// CommonWebActions.webSetFromXls("desMilestoneDesignRelease", "desMilestoneDesignRelease");
//
//			CommonWebActions.webClick("desMilestoneDesignReleaseComment");
//			// CommonWebActions.webSetFromXls("desMilestoneDesignReleaseComment", "desMilestoneDesignReleaseComment");
//
//			CommonWebActions.waituntil("Des_Milestonetype2");
//			// CommonWebActions.webSetFromXls("Des_Milestonetype2", "Des_Milestonetype2");
//
//			CommonWebActions.webClick("desMilestoneDocumentFinished");
//			// CommonWebActions.webSetFromXls("desMilestoneDocumentFinished", "desMilestoneDocumentFinished");
//
//			CommonWebActions.webClick("desMilestoneDocumentFinishedComment");
//			// CommonWebActions.webSetFromXls("desMilestoneDocumentFinishedComment", "desMilestoneDocumentFinishedComment");
//
//			// CommonWebActions.webClick("desMilestoneDocumentFinished1");
//			// CommonWebActions.webSet("desMilestoneDocumentFinished1","desMilestoneDocumentFinished");
//			//
//			// CommonWebActions.webClick("desMilestoneDocumentFinishedComment1");
//			// CommonWebActions.webSet("desMilestoneDocumentFinishedComment1","desMilestoneDocumentFinishedComment");
//
//			CommonWebActions.webClick("desTeaminfoRecommendation");
//			// CommonWebActions.webSetFromXls("desTeaminfoRecommendation", "desTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignTeamInfo");
//			executionTimes.put("FillDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfo() {
//		try {
//			startTime = System.currentTimeMillis();
//
//		//	CommonWebActions.ICMclick("desSubmitteaminfo");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignTeamInfo");
//			executionTimes.put("FinishDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillDesignStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("desCopyCostsbutton");
//		//	CommonWebActions.ICMclick("desCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("desUpdatetotal&Overallcosts");
//
//			CommonWebActions.wait(3000);
//			double desTotalDesignCostInternal1 = CommonWebActions.getValue("desTotalDesignCostInternal");
//			System.out.println("desTotalDesignCostInternal1" + desTotalDesignCostInternal1);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String desTotalcostsInternalvalue1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desTotalcostsInternalvalue");
//
//			System.out.println("desTotalcostsInternalvalue1" + desTotalcostsInternalvalue1);
//
//			double desTotalcostsInternalvalue2 = Double.parseDouble(desTotalcostsInternalvalue1);
//
//			System.out.println("desTotalcostsInternalvalue2" + desTotalcostsInternalvalue2);
//
//			double cmp5 = Double.compare(desTotalDesignCostInternal1, desTotalcostsInternalvalue2);
//
//			System.out.println(cmp5);
//
//			CommonWebActions.wait(3000);
//			double desTotalDesignCostExternal = CommonWebActions.getValue("desTotalDesignCostExternal");
//			System.out.println(desTotalDesignCostExternal);
//
//			String desTotalcostsExternallvalue1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desTotalcostsExternallvalue");
//
//			System.out.println(desTotalcostsExternallvalue1);
//
//			double desTotalcostsExternallvalue2 = Double.parseDouble(desTotalcostsExternallvalue1);
//
//			double cmp6 = Double.compare(desTotalDesignCostExternal, desTotalcostsExternallvalue2);
//
//			System.out.println(cmp6);
//
//			CommonWebActions.wait(3000);
//			double desTotalInternalEffort1 = CommonWebActions.getValue("desTotalInternalEffort");
//			System.out.println(desTotalInternalEffort1);
//
//			String desInternalEffort1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desInternalEffort");
//
//			System.out.println(desInternalEffort1);
//
//			double desTotalInternalEffort2 = Double.parseDouble(desInternalEffort1);
//
//			double cmp7 = Double.compare(desTotalInternalEffort1, desTotalInternalEffort2);
//
//			System.out.println(cmp7);
//
//			/*CommonWebActions.wait(3000);
//			double desTotalInternalCost1 = CommonWebActions.getValue("desTotalInternalCost");
//			System.out.println(desTotalInternalCost1);
//
//			String desInternalCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desInternalCosts");
//
//			System.out.println(desInternalCosts1);
//
//			double desTotalInternalCost2 = Double.parseDouble(desInternalCosts1);
//
//			double cmp8 = Double.compare(desTotalInternalCost1, desTotalInternalCost2);
//
//			System.out.println(cmp8);*/
//
//			/*
//			 * CommonWebActions.wait(3000); double desTotalDocumentationeffort =
//			 * CommonWebActions .getValue("desTotalDocumentationeffort");
//			 * System.out.println(desTotalDocumentationeffort);
//			 * 
//			 * String desInternalDocumentationeffort1 = ExcelUtil
//			 * .getDataFromExcel(onlyTestCaseName,
//			 * "desInternalDocumentationeffort");
//			 * 
//			 * System.out.println(desInternalDocumentationeffort1);
//			 * 
//			 * double desInternalDocumentationeffort2 = Double
//			 * .parseDouble(desInternalDocumentationeffort1);
//			 * 
//			 * double cmp9 = Double.compare(desTotalDocumentationeffort,
//			 * desInternalDocumentationeffort2);
//			 * 
//			 * System.out.println(cmp9);
//			 * 
//			 * CommonWebActions.wait(3000);
//			 * 
//			 * double desTotalSimulationeffort = CommonWebActions
//			 * .getValue("desTotalSimulationeffort");
//			 * System.out.println(desTotalSimulationeffort);
//			 * 
//			 * String desInternalSimulationeffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desInternalSimulationeffort");
//			 * 
//			 * System.out.println(desInternalSimulationeffort1);
//			 * 
//			 * double desInternalSimulationeffort2 = Double
//			 * .parseDouble(desInternalSimulationeffort1);
//			 * 
//			 * double cmp10 = Double.compare(desTotalSimulationeffort,
//			 * desInternalSimulationeffort2);
//			 * 
//			 * System.out.println(cmp10);
//			 */
//
//			CommonWebActions.wait(3000);
//
//			double desextTotalmaterial = CommonWebActions.getValue("desextTotalmaterial");
//			System.out.println(desextTotalmaterial);
//
//			String desExternalMaterial1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desExternalMaterial");
//
//			System.out.println(desExternalMaterial1);
//
//			double desExternalMaterial2 = Double.parseDouble(desExternalMaterial1);
//
//			double cmp11 = Double.compare(desextTotalmaterial, desExternalMaterial2);
//
//			System.out.println(cmp11);
//
//			CommonWebActions.wait(3000);
//
//			double desTotalExternalcosts = CommonWebActions.getValue("desTotalExternalcosts");
//			System.out.println(desTotalExternalcosts);
//
//			String desExternalCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desExternalCosts");
//
//			System.out.println(desExternalCosts1);
//
//			double desExternalCosts2 = Double.parseDouble(desExternalCosts1);
//
//			double cmp12 = Double.compare(desTotalExternalcosts, desExternalCosts2);
//
//			System.out.println(cmp12);
//
//			CommonWebActions.wait(3000);
//
//			double desTotalextEngCosts = CommonWebActions.getValue("desTotalextEngCosts");
//			System.out.println(desTotalextEngCosts);
//
//			String desExternalEngineering1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "desExternalEngineering");
//
//			System.out.println(desExternalEngineering1);
//
//			double desExternalEngineering2 = Double.parseDouble(desExternalEngineering1);
//
//			double cmp13 = Double.compare(desTotalextEngCosts, desExternalEngineering2);
//
//			System.out.println(cmp13);
//
//		//	CommonWebActions.ICMclick("desConsolidateMilestones");
//
//			// CommonWebActions.webSetFromXls("FillDesignStmtRecommendation", "FillDesignStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignStmt");
//			executionTimes.put("FillDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishDesignStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("desSubmitStatementbutton");
//		//	CommonWebActions.ICMclick("desSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignStmt");
//			executionTimes.put("FinishDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindTestingstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Testingstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Testing" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Testingstmt2 = Testingstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Testingstmt2);
//			ORUtil.setValue("Testingstmt1", Testingstmt2);
//			CommonWebActions.waituntil("Testingstmt1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FindTestingstmt", stopTime - startTime);
//			System.out.println("Found Testingstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindTestingstmt");
//
//		}
//
//	}
//
//	public static void OpenTestingStatement() {
//
//		try {
//			startTime = System.currentTimeMillis();
//		//	CommonWebActions.ICMclick("Testingstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("TestingstmtiFrame");
//			
//			
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("TestingstmtShellNumber");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenTestingStatement", stopTime - startTime);
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoTesting() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("testDistributeTeams");
//
//			CommonWebActions.waituntil("testTeamHeader");
//			CommonWebActions.webClick("testTeamHeader");
//
//			CommonWebActions.waituntil("testTeaminfoAddbutton");
//			CommonWebActions.webClick("testTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("TestTeamexpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("TestTeamexpertpopup");
//
//			// CommonWebActions.webSetFromXls("testTeaminfoteamlist", "testTeaminfoteamlist");
//
//			// CommonWebActions.webSetFromXls("testTeaminfoTasksdesc", "testTeaminfoTasksdesc");
//
//			CommonWebActions.webClick("testDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoTesting", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoTesting");
//			executionTimes.put("distributeTeamInfoTesting", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoTesting() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Testingteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Testing" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Testingteaminfo2 = Testingteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Testingteaminfo2);
//			ORUtil.setValue("Testingteaminfo1", Testingteaminfo2);
//			CommonWebActions.waituntil("Testingteaminfo1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("findTeaminfoTesting", stopTime - startTime);
//			System.out.println("found TeaminfoTesting");
//
//			ReportUtil.reporterEvent("findTeaminfoTesting", "findTeaminfoTesting  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoTesting");
//			executionTimes.put("findTeaminfoTesting", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoTesting() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//		//	CommonWebActions.ICMclick("Testingteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("TestingteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("TestingteaminfoShellNumber");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenTeaminfoTesting", stopTime - startTime);
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoTesting", "OpenTeaminfoTesting opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoTesting");
//
//		}
//
//	}
//
//	public static void FillTeamInfoTesting() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("testTeamtask");
//
//			// CommonWebActions.webSetFromXls("testTeamtask", "testTeaminfoTasksdesc");
//
//			CommonWebActions.waituntil("testHeaderInternal");
//			CommonWebActions.webClick("testHeaderInternal");
//
//			CommonWebActions.waituntil("testTestEffortHours");
//			CommonWebActions.webClick("testTestEffortHours");
//			// CommonWebActions.webSetFromXls("testTestEffortHours", "testTestEffortHours");
//
//			CommonWebActions.webClick("testTestEffortComment");
//			// CommonWebActions.webSetFromXls("testTestEffortComment", "testTestEffortComment");
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			double testTestEffort = AUT.Costvalue("testTestEffortHours", "testHourlyRate");
//			System.out.println(testTestEffort);
//
//			CommonWebActions.wait(3000);
//			double testTestEffort1 = CommonWebActions.getValue("testTestEffort");
//			System.out.println("testTestEffort1" + testTestEffort1);
//
//			double cmp = Double.compare(testTestEffort, testTestEffort1);
//
//			System.out.println(cmp);
//			if (cmp == 0) {
//				String testTestEffort2 = Double.toString(testTestEffort);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "testTestEffort", testTestEffort2);
//
//			}
//
//			CommonWebActions.webClick("testTestEffortPartNumber");
//			// CommonWebActions.webSetFromXls("testTestEffortPartNumber", "testTestEffortPartNumber");
//
//			CommonWebActions.webClick("testTestbenchHours");
//			// CommonWebActions.webSetFromXls("testTestbenchHours", "testTestbenchHours");
//
//			CommonWebActions.webClick("testTestbenchComment");
//			// CommonWebActions.webSetFromXls("testTestbenchComment", "testTestbenchComment");
//
//			double testTestbench = AUT.Costvalue("testTestbenchHours", "testHourlyRate");
//			System.out.println(testTestbench);
//
//			CommonWebActions.wait(3000);
//			double testTestbench1 = CommonWebActions.getValue("testTestbench");
//			System.out.println("testTestbench1" + testTestbench1);
//
//			double cmp1 = Double.compare(testTestbench, testTestbench1);
//
//			System.out.println(cmp1);
//			if (cmp1 == 0) {
//				String testTestbench2 = Double.toString(testTestbench);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "testTestbench", testTestbench2);
//
//			}
//
//			CommonWebActions.webClick("testTestbenchPartNumber");
//			// CommonWebActions.webSetFromXls("testTestbenchPartNumber", "testTestbenchPartNumber");
//
//			CommonWebActions.webClick("testMechanicseffortHours");
//			// CommonWebActions.webSetFromXls("testMechanicseffortHours", "testMechanicseffortHours");
//
//			CommonWebActions.webClick("testMechanicseffortComment");
//			// CommonWebActions.webSetFromXls("testMechanicseffortComment", "testMechanicseffortComment");
//
//			double testMechanicseffort = AUT.Costvalue("testMechanicseffortHours", "testHourlyRate");
//			System.out.println(testMechanicseffort);
//
//			CommonWebActions.wait(3000);
//			double testMechanicseffort1 = CommonWebActions.getValue("testMechanicseffort");
//			System.out.println("testMechanicseffort1:" + testMechanicseffort1);
//
//			double cmp2 = Double.compare(testMechanicseffort, testMechanicseffort1);
//
//			System.out.println(cmp2);
//			if (cmp2 == 0) {
//				String testMechanicseffort2 = Double.toString(testMechanicseffort);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "testMechanicseffort", testMechanicseffort2);
//
//			}
//
//			CommonWebActions.webClick("testMechanicseffortPartNumber");
//			// CommonWebActions.webSetFromXls("testMechanicseffortPartNumber", "testMechanicseffortPartNumber");
//
//			CommonWebActions.webClick("testTestingParts");
//			// CommonWebActions.webSetFromXls("testTestingParts", "testTestingParts");
//
//			CommonWebActions.webClick("testTestingPartsComment");
//			// CommonWebActions.webSetFromXls("testTestingPartsComment", "testTestingPartsComment");
//
//			CommonWebActions.wait(3000);
//			double testTestingPartsvalue1 = CommonWebActions.getValue("testTestingPartsvalue");
//			System.out.println("testTestingPartsvalue1:" + testTestingPartsvalue1);
//
//			String testTestingParts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTestingParts");
//
//			System.out.println(testTestingParts1);
//
//			double testTestingParts2 = Double.parseDouble(testTestingParts1);
//
//			double cmp3 = Double.compare(testTestingPartsvalue1, testTestingParts2);
//
//			System.out.println(cmp3);
//
//			CommonWebActions.webClick("testTestingPartsPartNumber");
//			// CommonWebActions.webSetFromXls("testTestingPartsPartNumber", "testTestingPartsPartNumber");
//
//			// External Costs - External Effort
//			CommonWebActions.webClick("testExternalEffortHours");
//			// CommonWebActions.webSetFromXls("testExternalEffortHours", "testExternalEffortHours");
//
//			CommonWebActions.webClick("testExternalEffortComment");
//			// CommonWebActions.webSetFromXls("testExternalEffortComment", "testExternalEffortComment");
//
//			double testExternalEffort = AUT.Costvalue("testExternalEffortHours", "testHourlyRate");
//			System.out.println(testExternalEffort);
//
//			CommonWebActions.wait(3000);
//			double testExternalEffort1 = CommonWebActions.getValue("testExternalEffort");
//			System.out.println("testExternalEffort1:" + testExternalEffort1);
//
//			double cmp4 = Double.compare(testMechanicseffort, testMechanicseffort1);
//
//			System.out.println(cmp4);
//			if (cmp4 == 0) {
//				String testExternalEffort2 = Double.toString(testExternalEffort);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "testExternalEffort", testExternalEffort2);
//
//			}
//
//			CommonWebActions.webClick("testExternalEffortPartNumber");
//			// CommonWebActions.webSetFromXls("testExternalEffortPartNumber", "testExternalEffortPartNumber");
//
//			CommonWebActions.webClick("testupdateoverallcostsbutton");
//		//	CommonWebActions.ICMclick("testupdateoverallcostsbutton");
//
//			double testTotalcosts = testTestEffort + testTestbench + testMechanicseffort + testTestingPartsvalue1 + testExternalEffort;
//
//			System.out.println(testTotalcosts);
//
//			CommonWebActions.wait(3000);
//			double testTotalcosts1 = CommonWebActions.getValue("testTotalcosts");
//			System.out.println("testTotalcosts1:" + testTotalcosts1);
//
//			double cmp5 = Double.compare(testTotalcosts, testTotalcosts1);
//
//			System.out.println(cmp5);
//
//			double testTotalcostsInternal = testTestEffort + testTestbench + testMechanicseffort;
//
//			System.out.println(testTotalcostsInternal);
//
//			String testTotalcostsInternal1 = Double.toString(testTotalcostsInternal);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "testTotalcostsInternal", testTotalcostsInternal1);
//
//			double testTotalcostsExternal = testTestingPartsvalue1 + testExternalEffort;
//
//			System.out.println(testTotalcostsExternal);
//
//			String testTotalcostsExternal1 = Double.toString(testTotalcostsExternal);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "testTotalcostsExternal", testTotalcostsExternal1);
//
//			CommonWebActions.webClick("TestingRisk");
//
//			// CommonWebActions.webSetFromXls("TestingRisk", "TestingRisk");
//
//			/*
//			 * CommonWebActions.waituntil("MilestoneDeleteHeader");
//			 * CommonWebActions.webClick("MilestoneDeleteHeader");
//			 * 
//			 * CommonWebActions.waituntil("testMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.webClick("testMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.webClick("testMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.webClick("testMilestonetype");
//			 * // CommonWebActions.webSetFromXls("testMilestonetype",
//			 * "testMilestonetype");
//			 * 
//			 * CommonWebActions.webClick("testMilestonedate");
//			 * // CommonWebActions.webSetFromXls("testMilestonedate",
//			 * "testMilestonedate");
//			 * 
//			 * CommonWebActions.webClick("testMilestoneComment");
//			 * // CommonWebActions.webSetFromXls("testMilestoneComment",
//			 * "testMilestoneComment");
//			 * 
//			 * CommonWebActions.webClick("testMilestonetype2");
//			 * // CommonWebActions.webSetFromXls("testMilestonetype2",
//			 * "testMilestonetype2");
//			 * 
//			 * CommonWebActions.webClick("testMilestonedate2");
//			 * // CommonWebActions.webSetFromXls("testMilestonedate2",
//			 * "testMilestonedate2");
//			 * 
//			 * CommonWebActions.webClick("testMilestoneComment2");
//			 * // CommonWebActions.webSetFromXls("testMilestoneComment2",
//			 * "testMilestoneComment2");
//			 */
//			// CommonWebActions.webSetFromXls("testteaminforecommendation", "testteaminforecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTestinTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTestinTeamInfo");
//			executionTimes.put("FillTestinTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishTeamInfoTesting() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("testSubmitteaminfo");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTestingTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTestingTeamInfo");
//			executionTimes.put("FinishTestingTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillTestingStmt() {
//		try {
//
//			CommonWebActions.webClick("Refereshteamtable");
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("testCopyCostsbutton");
//		//	CommonWebActions.ICMclick("testCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("testUpdatetotal&Overallcosts");
//
//			CommonWebActions.wait(3000);
//			double Totaltestingcostsinternal1 = CommonWebActions.getValue("Totaltestingcostsinternal");
//			System.out.println("Totaltestingcostsinternal" + Totaltestingcostsinternal1);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String testTotalcostsInternal1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTotalcostsInternal");
//
//			System.out.println("testTotalcostsInternal1" + testTotalcostsInternal1);
//
//			double testTotalcostsInternal2 = Double.parseDouble(testTotalcostsInternal1);
//
//			System.out.println("testTotalcostsInternal2" + testTotalcostsInternal2);
//
//			double cmp5 = Double.compare(Totaltestingcostsinternal1, testTotalcostsInternal2);
//
//			System.out.println(cmp5);
//
//			CommonWebActions.wait(3000);
//			double TotaltestingcostsExternal1 = CommonWebActions.getValue("TotaltestingcostsExternal");
//			System.out.println("TotaltestingcostsExternal1" + TotaltestingcostsExternal1);
//
//			String testTotalcostsExternal1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTotalcostsExternal");
//
//			System.out.println("testTotalcostsExternal1" + testTotalcostsExternal1);
//
//			double testTotalcostsExternal2 = Double.parseDouble(testTotalcostsExternal1);
//
//			System.out.println("testTotalcostsExternal2" + testTotalcostsExternal2);
//
//			double cmp6 = Double.compare(TotaltestingcostsExternal1, testTotalcostsExternal2);
//
//			System.out.println(cmp6);
//
//			CommonWebActions.wait(3000);
//			double Totaltestingeffort1 = CommonWebActions.getValue("Totaltestingeffort");
//			System.out.println("Totaltestingeffort1" + Totaltestingeffort1);
//
//			String testTestEffort1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTestEffort");
//
//			System.out.println("testTestEffort1" + testTestEffort1);
//
//			double testTestEffort2 = Double.parseDouble(testTestEffort1);
//
//			System.out.println("testTestEffort2" + testTestEffort2);
//
//			double cmp7 = Double.compare(Totaltestingeffort1, testTestEffort2);
//
//			System.out.println(cmp7);
//
//			CommonWebActions.wait(3000);
//			double Totaltestbench1 = CommonWebActions.getValue("Totaltestbench");
//			System.out.println("Totaltestbench1" + Totaltestbench1);
//
//			String testTestbench1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTestbench");
//
//			System.out.println("testTestbench1" + testTestbench1);
//
//			double testTestbench2 = Double.parseDouble(testTestbench1);
//
//			System.out.println("testTestEffort2" + testTestEffort2);
//
//			double cmp8 = Double.compare(Totaltestbench1, testTestbench2);
//
//			System.out.println(cmp8);
//
//			CommonWebActions.wait(3000);
//			double TotalMechanicseffort1 = CommonWebActions.getValue("TotalMechanicseffort");
//			System.out.println("TotalMechanicseffort1" + TotalMechanicseffort1);
//
//			String testMechanicseffort1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testMechanicseffort");
//
//			System.out.println("testMechanicseffort1" + testMechanicseffort1);
//
//			double testMechanicseffort2 = Double.parseDouble(testMechanicseffort1);
//
//			System.out.println("testMechanicseffort2" + testMechanicseffort2);
//
//			double cmp9 = Double.compare(TotalMechanicseffort1, testMechanicseffort2);
//
//			System.out.println(cmp9);
//
//			CommonWebActions.wait(3000);
//			double TotalTestingparts1 = CommonWebActions.getValue("TotalTestingparts");
//			System.out.println("TotalTestingparts1" + TotalTestingparts1);
//
//			String testTestingParts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testTestingParts");
//
//			System.out.println("testTestingParts1" + testTestingParts1);
//
//			double testTestingParts2 = Double.parseDouble(testTestingParts1);
//
//			System.out.println("testTestingParts2" + testTestingParts2);
//
//			double cmp10 = Double.compare(TotalTestingparts1, testTestingParts2);
//
//			System.out.println(cmp10);
//
//			CommonWebActions.wait(3000);
//			double TotalExternaleffort1 = CommonWebActions.getValue("TotalExternaleffort");
//			System.out.println("TotalExternaleffort1" + TotalExternaleffort1);
//
//			String testExternalEffort1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "testExternalEffort");
//
//			System.out.println("testExternalEffort1" + testExternalEffort1);
//
//			double testExternalEffort2 = Double.parseDouble(testExternalEffort1);
//
//			System.out.println("testExternalEffort2" + testExternalEffort2);
//
//			double cmp11 = Double.compare(TotalExternaleffort1, testExternalEffort2);
//
//			System.out.println(cmp11);
//
//			CommonWebActions.waituntil("testTestingRisk");
//			CommonWebActions.wait(10000);
//			CommonWebActions.webClick("testTestingRisk");
//			// CommonWebActions.webSetFromXls("testTestingRisk", "TestingRisk");
//
//		//	CommonWebActions.ICMclick("testConsolidateMilestones");
//
//			// CommonWebActions.webSetFromXls("FillTestingStmtRecommendation", "FillTestingStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTestingStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTestingStmt");
//			executionTimes.put("FillTestingStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTestingStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("testSubmitStatementbutton");
//		//	CommonWebActions.ICMclick("testSubmitStatementbutton");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTestingStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTestingStmt");
//			executionTimes.put("FinishTestingStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FindHomologationstmt() throws ConfigurationException, IOException {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
////		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Homologationstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Homologation" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Homologationstmt2 = Homologationstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Homologationstmt2);
//			ORUtil.setValue("Homologationstmt1", Homologationstmt2);
//			CommonWebActions.waituntil("Homologationstmt1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FindHomologationstmt", stopTime - startTime);
//			System.out.println("Found Homologationstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindHomologationstmt");
//
//		}
//
//	}
//
//	public static void OpenHomologationStatement() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//		//	CommonWebActions.ICMclick("Homologationstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("HomologationstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("HomologationstmtShellNumber");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenHomologationStatement", stopTime - startTime);
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenHomologationStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoHomologation() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("HomDistributeTeams");
//
//			CommonWebActions.waituntil("HomoTeamHeader");
//			CommonWebActions.webClick("HomoTeamHeader");
//
//			CommonWebActions.waituntil("HomTeaminfoAddbutton");
//			CommonWebActions.webClick("HomTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("HomTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("Homoteaminfoexpertpopup");
//
//			// CommonWebActions.ICMDownClick("HomTeaminfoExpert");
//
//			CommonWebActions.waituntil("HomTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("HomTeaminfoteamlist", "HomTeaminfoteamlist");
//
//			CommonWebActions.waituntil("HomTeaminfoTasksdesc");
//			// CommonWebActions.webSetFromXls("HomTeaminfoTasksdesc", "HomTeaminfoTasksdesc");
//
//			CommonWebActions.waituntil("HomDistributeTeams");
//			CommonWebActions.webClick("HomDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoHomologation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoHomologation() {
//		try {
//			System.out.println(packageNumber);
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Homologationteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Homologation" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Homologationteaminfo2 = Homologationteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Homologationteaminfo2);
//			ORUtil.setValue("Homologationteaminfo1", Homologationteaminfo2);
//			CommonWebActions.waituntil("Homologationteaminfo1");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("findTeaminfoHomologation", stopTime - startTime);
//
//			System.out.println("found Homologationteaminfo");
//
//			ReportUtil.reporterEvent("findTeaminfoHomologation", "findTeaminfoHomologation  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoHomologation");
//			executionTimes.put("findTeaminfoHomologation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoHomologation() {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//		//	CommonWebActions.ICMclick("Homologationteaminfo1");
//			// CommonWebActions.webClick("Homologationteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("HomologationteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("HomologationteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenTeaminfoHomologation", stopTime - startTime);
//			ReportUtil.reporterEvent("OpenTeaminfoHomologation", "OpenTeaminfoHomologation opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoHomologation");
//
//		}
//
//	}
//
//	public static void FillTeamInfoHomologation() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("TeamTaskHomoteaminfo");
//			// CommonWebActions.webSetFromXls("TeamTaskHomoteaminfo", "desTeaminfoTasksdesc");
//
//			CommonWebActions.waituntil("HomteaminfoInternalheader");
//			CommonWebActions.webClick("HomteaminfoInternalheader");
//
//			CommonWebActions.waituntil("HomologationInternalEffortHours");
//			// CommonWebActions.webSetFromXls("HomologationInternalEffortHours", "HomologationInternalEffortHours");
//
//			CommonWebActions.webClick("HomologationInternalEffortComments");
//			// CommonWebActions.webSetFromXls("HomologationInternalEffortComments", "HomologationInternalEffortComments");
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			double HomologationInternalEffort = AUT.Costvalue("HomologationInternalEffortHours", "HomHourlyRate");
//			System.out.println(HomologationInternalEffort);
//
//			CommonWebActions.wait(3000);
//			double HomologationInternalEffort1 = CommonWebActions.getValue("HomologationInternalEffort");
//			System.out.println("HomologationInternalEffort1" + HomologationInternalEffort1);
//
//			double cmp = Double.compare(HomologationInternalEffort, HomologationInternalEffort1);
//
//			System.out.println(cmp);
//			if (cmp == 0) {
//				String HomologationInternalEffort2 = Double.toString(HomologationInternalEffort);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "HomologationInternalEffort", HomologationInternalEffort2);
//
//			}
//
//			CommonWebActions.webClick("HomologationInternalEffortPartNumber");
//			// CommonWebActions.webSetFromXls("HomologationInternalEffortPartNumber", "HomologationInternalEffortPartNumber");
//
//			CommonWebActions.webClick("HomExternalMaterialAmount");
//			// CommonWebActions.webSetFromXls("HomExternalMaterialAmount", "HomExternalMaterialAmount");
//
//			CommonWebActions.webClick("HomExternalMaterialCommemts");
//			// CommonWebActions.webSetFromXls("HomExternalMaterialCommemts", "HomExternalMaterialCommemts");
//
//			CommonWebActions.wait(3000);
//			double HomExternalMaterialAmountvalue1 = CommonWebActions.getValue("HomExternalMaterialAmountvalue");
//			System.out.println("HomExternalMaterialAmountvalue1:" + HomExternalMaterialAmountvalue1);
//
//			String HomExternalMaterialAmount1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomExternalMaterialAmount");
//
//			System.out.println(HomExternalMaterialAmount1);
//
//			double HomExternalMaterialAmount2 = Double.parseDouble(HomExternalMaterialAmount1);
//
//			double cmp3 = Double.compare(HomExternalMaterialAmountvalue1, HomExternalMaterialAmount2);
//
//			System.out.println(cmp3);
//
//			CommonWebActions.webClick("HomExternalMaterialPartNumber");
//			// CommonWebActions.webSetFromXls("HomExternalMaterialPartNumber", "HomExternalMaterialPartNumber");
//
//			CommonWebActions.webClick("HomExternalFeesAmount");
//			// CommonWebActions.webSetFromXls("HomExternalFeesAmount", "HomExternalFeesAmount");
//
//			CommonWebActions.webClick("HomExternalFeesCommemts");
//			// CommonWebActions.webSetFromXls("HomExternalFeesCommemts", "HomExternalFeesCommemts");
//
//			CommonWebActions.wait(3000);
//			double HomExternalFeesAmountvalue1 = CommonWebActions.getValue("HomExternalFeesAmountvalue");
//			System.out.println("HomExternalFeesAmountvalue1:" + HomExternalFeesAmountvalue1);
//
//			String HomExternalFeesAmount1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomExternalFeesAmount");
//
//			System.out.println(HomExternalFeesAmount1);
//
//			double HomExternalFeesAmount2 = Double.parseDouble(HomExternalFeesAmount1);
//
//			double cmp4 = Double.compare(HomExternalFeesAmountvalue1, HomExternalFeesAmount2);
//
//			System.out.println(cmp4);
//
//			CommonWebActions.webClick("HomExternalFeesPartNumber");
//			// CommonWebActions.webSetFromXls("HomExternalFeesPartNumber", "HomExternalFeesPartNumber");
//
//			// CommonWebActions.webClick("HomoCostsHeaderTeaminfo");
//
//			// CommonWebActions.webClick("Homoteaminforecommendation");
//
//			/*
//			 * CommonWebActions.waituntil("HomMilestonetypeheader");
//			 * 
//			 * CommonWebActions.webClick("HomMilestonetypeheader");
//			 * 
//			 * CommonWebActions.waituntil("MilestoneDeleteHeader");
//			 * CommonWebActions.webClick("MilestoneDeleteHeader");
//			 * 
//			 * // CommonWebActions.scrollup(40);
//			 * 
//			 * CommonWebActions.waituntil("HomMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.webClick("HomMilestoneAddbutton");
//			 * 
//			 * // CommonWebActions.scrollup(40);
//			 * 
//			 * CommonWebActions.webClick("HomMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.webClick("HomMilestonetype");
//			 * // CommonWebActions.webSetFromXls("HomMilestonetype",
//			 * "HomMilestonetype");
//			 * 
//			 * CommonWebActions.webClick("HomMilestonedate");
//			 * // CommonWebActions.webSetFromXls("HomMilestonedate",
//			 * "HomMilestonedate");
//			 * 
//			 * CommonWebActions.webClick("HomMilestoneComment");
//			 * // CommonWebActions.webSetFromXls("HomMilestoneComment",
//			 * "HomMilestoneComment");
//			 * 
//			 * CommonWebActions.webClick("HomMilestonetype1");
//			 * // CommonWebActions.webSetFromXls("HomMilestonetype1",
//			 * "HomMilestonetype1");
//			 * 
//			 * CommonWebActions.webClick("HomMilestonedate1");
//			 * // CommonWebActions.webSetFromXls("HomMilestonedate1",
//			 * "HomMilestonedate1");
//			 * 
//			 * CommonWebActions.webClick("HomMilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("HomMilestoneComment1",
//			 * "HomMilestoneComment1");
//			 */
//
//			// CommonWebActions.webSetFromXls("Homoteaminforecommendation", "Homoteaminforecommendation");
//
//			CommonWebActions.webClick("HomUpdateOverallCostsButton");
//		//	CommonWebActions.ICMclick("HomUpdateOverallCostsButton");
//
//			double HomTotalCosts = HomologationInternalEffort1 + HomExternalMaterialAmountvalue1 + HomExternalFeesAmountvalue1;
//
//			System.out.println(HomTotalCosts);
//
//			CommonWebActions.wait(3000);
//			double HomTotalCosts1 = CommonWebActions.getValue("HomTotalCosts");
//			System.out.println("HomTotalCosts1:" + HomTotalCosts1);
//
//			double cmp5 = Double.compare(HomTotalCosts, HomTotalCosts1);
//
//			System.out.println(cmp5);
//
//			double HomTotalCostsInternal = HomologationInternalEffort1;
//
//			System.out.println(HomTotalCostsInternal);
//
//			String HomTotalCostsInternal1 = Double.toString(HomTotalCostsInternal);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "HomTotalCostsInternal", HomTotalCostsInternal1);
//
//			double HomTotalCostsExternal = HomExternalMaterialAmountvalue1 + HomExternalFeesAmountvalue1;
//
//			System.out.println(HomTotalCostsExternal);
//
//			String testTotalcostsExternal1 = Double.toString(HomTotalCostsExternal);
//
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "HomTotalCostsExternal", testTotalcostsExternal1);
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoHomologation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoHomologation");
//			executionTimes.put("FillTeamInfoHomologation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoHomologation() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("HomoSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoHomologation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoHomologation");
//			executionTimes.put("FinishTeamInfoHomologation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillHomologationStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("HomoCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("HomoCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("HomoUpdatetotal&Overallcosts");
//
//			CommonWebActions.wait(3000);
//			double HomTotalInternal1 = CommonWebActions.getValue("HomTotalInternal");
//			System.out.println("HomTotalInternal1" + HomTotalInternal1);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String HomTotalCostsInternal1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomTotalCostsInternal");
//
//			System.out.println("HomTotalCostsInternal1" + HomTotalCostsInternal1);
//
//			double HomTotalCostsInternal2 = Double.parseDouble(HomTotalCostsInternal1);
//
//			System.out.println("HomTotalCostsInternal2" + HomTotalCostsInternal2);
//
//			double cmp5 = Double.compare(HomTotalInternal1, HomTotalCostsInternal2);
//
//			System.out.println(cmp5);
//
//			CommonWebActions.wait(3000);
//			double HomTotalExternal1 = CommonWebActions.getValue("HomTotalExternal");
//			System.out.println("HomTotalExternal1" + HomTotalExternal1);
//
//			String HomTotalCostsExternal1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomTotalCostsExternal");
//
//			System.out.println("HomTotalCostsExternal1" + HomTotalCostsExternal1);
//
//			double HomTotalCostsExternal2 = Double.parseDouble(HomTotalCostsExternal1);
//
//			System.out.println("HomTotalCostsExternal2" + HomTotalCostsExternal2);
//
//			double cmp6 = Double.compare(HomTotalExternal1, HomTotalCostsExternal2);
//
//			System.out.println(cmp6);
//
//			CommonWebActions.wait(3000);
//			double HomTotalHomologationeffort1 = CommonWebActions.getValue("HomTotalHomologationeffort");
//			System.out.println("HomTotalHomologationeffort1" + HomTotalHomologationeffort1);
//
//			String HomologationInternalEffort1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomologationInternalEffort");
//
//			System.out.println("HomTotalCostsExternal1" + HomTotalCostsExternal1);
//
//			double HomologationInternalEffort2 = Double.parseDouble(HomologationInternalEffort1);
//
//			System.out.println("HomologationInternalEffort2" + HomologationInternalEffort2);
//
//			double cmp7 = Double.compare(HomTotalHomologationeffort1, HomologationInternalEffort2);
//
//			System.out.println(cmp7);
//
//			CommonWebActions.wait(3000);
//			double HomTotalMaterial1 = CommonWebActions.getValue("HomTotalMaterial");
//			System.out.println("HomTotalMaterial1" + HomTotalMaterial1);
//
//			String HomExternalMaterialAmount1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomExternalMaterialAmount");
//
//			System.out.println("HomExternalMaterialAmount1" + HomExternalMaterialAmount1);
//
//			double HomExternalMaterialAmount2 = Double.parseDouble(HomExternalMaterialAmount1);
//
//			System.out.println("HomExternalMaterialAmount2" + HomExternalMaterialAmount2);
//
//			double cmp8 = Double.compare(HomTotalMaterial1, HomExternalMaterialAmount2);
//
//			System.out.println(cmp8);
//
//			CommonWebActions.wait(3000);
//			double HomExternalfees1 = CommonWebActions.getValue("HomExternalfees");
//			System.out.println("HomExternalfees1" + HomExternalfees1);
//
//			String HomExternalFeesAmount1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "HomExternalFeesAmount");
//
//			System.out.println("HomExternalFeesAmount1" + HomExternalFeesAmount1);
//
//			double HomExternalFeesAmount2 = Double.parseDouble(HomExternalFeesAmount1);
//
//			System.out.println("HomExternalFeesAmount2" + HomExternalFeesAmount2);
//
//			double cmp9 = Double.compare(HomExternalfees1, HomExternalFeesAmount2);
//
//			System.out.println(cmp9);
//
//		//	CommonWebActions.ICMclick("HomoConsolidateMilestones");
//
//			// CommonWebActions.webSetFromXls("FillHomoStmtRecommendation", "FillHomoStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillHomologationStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillHomologationStmt");
//			executionTimes.put("FillHomologationStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishHomologationStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.wait(5000);
//
//		//	CommonWebActions.ICMclick("desSubmitStatementbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishHomologationStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishHomologationStmt");
//			executionTimes.put("FinishHomologationStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindSDCstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String SDCstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Supplier Development Costs" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String SDCstmt2 = SDCstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + SDCstmt2);
//			ORUtil.setValue("SDCstmt1", SDCstmt2);
//			CommonWebActions.waituntil("SDCstmt1");
//			System.out.println("Found SDCstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindSDCstmt");
//
//		}
//
//	}
//
//	public static void OpenSDCStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("SDCstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
////			//CommonWebActions.switchToiFrame1("SDCstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SDCstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenSDCStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoSDC() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("SDCDistributeTeams");
//
//			CommonWebActions.waituntil("SDCTeamsHeader");
//			CommonWebActions.webClick("SDCTeamsHeader");
//
//			CommonWebActions.waituntil("SDCTeaminfoAddbutton");
//			CommonWebActions.webClick("SDCTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("SDCTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("SDCTeaminfoExpertpopup");
//
//			CommonWebActions.waituntil("SDCTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("SDCTeaminfoteamlist", "SDCTeaminfoteamlist");
//
//			CommonWebActions.waituntil("SDCTeaminfoRemark");
//			// CommonWebActions.webSetFromXls("SDCTeaminfoRemark", "SDCTeaminfoRemark");
//
//			CommonWebActions.waituntil("SDCDistributeTeams");
//			CommonWebActions.webClick("SDCDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoSDC", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoSDC");
//			executionTimes.put("distributeTeamInfoSDC", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoSDC() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String SDCteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Supplier Development Costs" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String SDCteaminfo2 = SDCteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + SDCteaminfo2);
//			ORUtil.setValue("SDCteaminfo1", SDCteaminfo2);
//			CommonWebActions.waituntil("SDCteaminfo1");
//			System.out.println("found SDCteaminfo");
//
//			ReportUtil.reporterEvent("findTeaminfoSDC", "findTeaminfoSDC  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoSDC");
//			executionTimes.put("findTeaminfoSDC", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoSDC() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("SDCteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("SDCteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SDCteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoSDC", "OpenTeaminfoSDC opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoSDC");
//
//		}
//
//	}
//
//	public static void FillTeamInfoSDC() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("SDCCommonInformationtab");
//
//			CommonWebActions.waituntil("SDCStatementteamtask");
//			// CommonWebActions.webSetFromXls("SDCStatementteamtask", "SDCStatementteamtask");
//
//			CommonWebActions.waituntil("SDCteaminfoInternalheader");
//			CommonWebActions.webClick("SDCteaminfoInternalheader");
//
//			CommonWebActions.scrollup(300);
//
//			CommonWebActions.webClick("PiecepriceAllocationCosts");
//			// CommonWebActions.webSetFromXls("PiecepriceAllocationCosts", "PiecepriceAllocationCosts");
//
//			CommonWebActions.webClick("PiecepriceAllocationDesc");
//			// CommonWebActions.webSetFromXls("PiecepriceAllocationDesc", "PiecepriceAllocationDesc");
//
//			// ///////////////////////////////////////////////////////////////////////////////
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String PiecepriceAllocationCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "PiecepriceAllocationCosts");
//			System.out.println(PiecepriceAllocationCosts1);
//
//			double PiecepriceAllocationCosts2 = Double.parseDouble(PiecepriceAllocationCosts1);
//
//			System.out.println("PiecepriceAllocationCosts2" + PiecepriceAllocationCosts2);
//
//			CommonWebActions.wait(3000);
//			double PiecepriceAllocationCostsValue1 = CommonWebActions.getValue("PiecepriceAllocationCostsValue");
//			System.out.println("PiecepriceAllocationCostsValue1" + PiecepriceAllocationCostsValue1);
//
//			double cmp = Double.compare(PiecepriceAllocationCostsValue1, PiecepriceAllocationCosts2);
//
//			System.out.println(cmp);
//
//			// ////////////////////////////////////////////////////////////////////////
//
//			CommonWebActions.webClick("DirectPaymentCosts");
//			// CommonWebActions.webSetFromXls("DirectPaymentCosts", "DirectPaymentCosts");
//
//			CommonWebActions.webClick("DirectPaymentDesc");
//			// CommonWebActions.webSetFromXls("DirectPaymentDesc", "DirectPaymentDesc");
//
//			String DirectPaymentCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "DirectPaymentCosts");
//			System.out.println(DirectPaymentCosts1);
//
//			double DirectPaymentCosts2 = Double.parseDouble(DirectPaymentCosts1);
//
//			System.out.println("DirectPaymentCosts2" + DirectPaymentCosts2);
//
//			CommonWebActions.wait(3000);
//			double DirectPaymentCostsValue1 = CommonWebActions.getValue("DirectPaymentCostsValue");
//			System.out.println("DirectPaymentCostsValue1" + DirectPaymentCostsValue1);
//
//			double cmp1 = Double.compare(DirectPaymentCosts2, DirectPaymentCostsValue1);
//
//			System.out.println(cmp1);
//
//			CommonWebActions.waituntil("SDCUpdateOverallCostsButton");
//
//		//	CommonWebActions.ICMclick("SDCUpdateOverallCostsButton");
//
//			double SDCTotalcosts = PiecepriceAllocationCosts2 + DirectPaymentCosts2;
//
//			System.out.println(SDCTotalcosts);
//
//			CommonWebActions.wait(3000);
//			double SDCTotalCosts1 = CommonWebActions.getValue("SDCTotalCosts");
//			System.out.println("SDCTotalCosts1" + SDCTotalCosts1);
//
//			double cmp2 = Double.compare(SDCTotalcosts, SDCTotalCosts1);
//
//			System.out.println(cmp2);
//			if (cmp2 == 0) {
//				String SDCTotalCosts2 = Double.toString(SDCTotalcosts);
//
//				ExcelUtil.setDatatoExcel(onlyTestCaseName, "SDCTotalcosts", SDCTotalCosts2);
//
//			}
//
//			CommonWebActions.webClick("PiecepriceAllocationDesc");
//
//			CommonWebActions.waituntil("SDCTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("SDCTeaminfoRecommendation", "SDCTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("SDCTeaminfoRecommendationComment", "SDCTeaminfoRecommendationComment");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignTeamInfo");
//			executionTimes.put("FillDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoSDC() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("SDCSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignTeamInfo");
//			executionTimes.put("FinishDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillSDCStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("SDCCopyCostsbutton");
//		//	CommonWebActions.ICMclick("SDCCopyCostsbutton");
//		//	CommonWebActions.ICMclick("SDCUpdatetotal&Overallcosts");
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			String PiecepriceAllocationCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "PiecepriceAllocationCosts");
//			System.out.println(PiecepriceAllocationCosts1);
//			double PiecepriceAllocationCosts2 = Double.parseDouble(PiecepriceAllocationCosts1);
//
//			System.out.println("PiecepriceAllocationCosts2" + PiecepriceAllocationCosts2);
//
//			CommonWebActions.wait(3000);
//			double TotalPiecepriceAllocation1 = CommonWebActions.getValue("TotalPiecepriceAllocation");
//			System.out.println("TotalPiecepriceAllocation1" + TotalPiecepriceAllocation1);
//
//			double cmp = Double.compare(TotalPiecepriceAllocation1, PiecepriceAllocationCosts2);
//
//			System.out.println(cmp);
//
//			String DirectPaymentCosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "DirectPaymentCosts");
//			System.out.println(DirectPaymentCosts1);
//
//			double DirectPaymentCosts2 = Double.parseDouble(DirectPaymentCosts1);
//
//			System.out.println("DirectPaymentCosts2" + DirectPaymentCosts2);
//
//			CommonWebActions.wait(3000);
//			double TotalDirectPayment1 = CommonWebActions.getValue("TotalDirectPayment");
//			System.out.println("TotalDirectPayment1" + TotalDirectPayment1);
//
//			double cmp1 = Double.compare(DirectPaymentCosts2, TotalDirectPayment1);
//
//			System.out.println(cmp1);
//
//			String SDCTotalcosts1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, "SDCTotalcosts");
//			System.out.println(SDCTotalcosts1);
//
//			double SDCTotalcosts2 = Double.parseDouble(SDCTotalcosts1);
//
//			System.out.println("SDCTotalcosts2" + SDCTotalcosts2);
//
//			CommonWebActions.wait(3000);
//			double SDCTotalcosts = CommonWebActions.getValue("SDCTotalcosts");
//			System.out.println("SDCTotalcosts" + SDCTotalcosts);
//
//			double cmp2 = Double.compare(SDCTotalcosts2, SDCTotalcosts);
//
//			System.out.println(cmp2);
//
//			CommonWebActions.waituntil("SDCProjectspecificInvest");
//
//			// CommonWebActions.webSetFromXls("SDCProjectspecificInvest", "SDCProjectspecificInvest");
//
//			CommonWebActions.waituntil("SDCWhatisMissing");
//
//			// CommonWebActions.webSetFromXls("SDCWhatisMissing", "SDCWhatisMissing");
//
//			// CommonWebActions.webSetFromXls("FillSDCStmtRecommendation", "FillSDCStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignStmt");
//			executionTimes.put("FillDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishSDCStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("SDCSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("SDCSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignStmt");
//			executionTimes.put("FinishDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindPurchasingstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Purchasingstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Purchasing" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Purchasingstmt2 = Purchasingstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Purchasingstmt2);
//			ORUtil.setValue("Purchasingstmt1", Purchasingstmt2);
//			CommonWebActions.waituntil("Purchasingstmt1");
//			System.out.println("Found Purchasingstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindPurchasingstmt");
//
//		}
//
//	}
//
//	public static void OpenPurchasingStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Purchasingstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("PurchasingstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("PurchasingstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenPurchasingStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoPurchasing() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("PurchaseDistributiontab");
//			CommonWebActions.webClick("PurchaseDistributiontab");
//
//			CommonWebActions.waituntil("PurchasingTeamsHeader");
//			CommonWebActions.webClick("PurchasingTeamsHeader");
//
//			CommonWebActions.waituntil("PurchasingTeaminfoAddbutton");
//			CommonWebActions.webClick("PurchasingTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("PurchasingTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("PurchasingTeaminfoExpertpopup");
//
//			CommonWebActions.waituntil("PurchasingTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("PurchasingTeaminfoteamlist", "PurchasingTeaminfoteamlist");
//
//			CommonWebActions.waituntil("PurchasingTeaminfoRemark");
//			// CommonWebActions.webSetFromXls("PurchasingTeaminfoRemark", "PurchasingTeaminfoRemark");
//
//			CommonWebActions.waituntil("PurchasingAssignParts");
//			CommonWebActions.webClick("PurchasingAssignParts");
//
//			CommonWebActions.waituntil("PurchasingPartAssignedcheckbox");
//			CommonWebActions.webClick("PurchasingPartAssignedcheckbox");
//
//			CommonWebActions.waituntil("PartsAssignedSaveButton");
//			CommonWebActions.webClick("PartsAssignedSaveButton");
//
//			CommonWebActions.waituntil("Purchasing_DistributeTeams");
//			CommonWebActions.webClick("Purchasing_DistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("OpenDesignTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoPurchasing() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Purchasingteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Purchasing" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Purchasingteaminfo2 = Purchasingteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Purchasingteaminfo2);
//			ORUtil.setValue("Purchasingteaminfo1", Purchasingteaminfo2);
//			CommonWebActions.waituntil("Purchasingteaminfo1");
//			System.out.println("found Purchasingteaminfo");
//
//			ReportUtil.reporterEvent("findTeaminfoPurchasing", "findTeaminfoPurchasing  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoPurchasing");
//			executionTimes.put("findTeaminfoPurchasing", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoPurchasing() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Purchasingteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("PurchasingteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("PurchasingteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoPurchasing", "OpenTeaminfoPurchasing opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoPurchasing");
//
//		}
//
//	}
//
//	public static void FillTeamInfoPurchasing() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("PurchasingStatementteamtask");
//			// CommonWebActions.webSetFromXls("PurchasingStatementteamtask", "PurchasingStatementteamtask");
//
//			CommonWebActions.waituntil("PurchasingTeaminfoPartstab");
//			CommonWebActions.webClick("PurchasingTeaminfoPartstab");
//
//			CommonWebActions.waituntil("Purchasingpartnumber_header");
//			CommonWebActions.webClick("Purchasingpartnumber_header");
//
//			CommonWebActions.waituntil("Purchasing_selectPart");
//			CommonWebActions.webClick("Purchasing_selectPart");
//
//			CommonWebActions.waituntil("Purchasing_Expand");
//			CommonWebActions.webClick("Purchasing_Expand");
//
//			CommonWebActions.waituntil("PurchasingNewBuyer");
//			// CommonWebActions.webSetFromXls("PurchasingNewBuyer", "PurchasingNewBuyer");
//
//			// CommonWebActions.waituntil("PurchasingSupplier");
//			// // CommonWebActions.webSetFromXls("PurchasingSupplier","PurchasingSupplier");
//
//			CommonWebActions.waituntil("Purchasing_SourceBundle");
//			// CommonWebActions.webSetFromXls("Purchasing_SourceBundle", "Purchasing_SourceBundle");
//
//			CommonWebActions.waituntil("Purchasing_incoterms");
//			// CommonWebActions.webSetFromXls("Purchasing_incoterms", "Purchasing_incoterms");
//
//			CommonWebActions.waituntil("Purchasing_Country");
//			// CommonWebActions.webSetFromXls("Purchasing_Country", "Purchasing_Country");
//
//			CommonWebActions.waituntil("Purchasing_State");
//			// CommonWebActions.webSetFromXls("Purchasing_State", "Purchasing_State");
//			// //////////////////////////////////////////////////////////////////////////////////
//
//			CommonWebActions.waituntil("Purchasing_Pricechangeperpiece");
//			CommonWebActions.webClick("Purchasing_Pricechangeperpiece");
//
//			CommonWebActions.wait(2000);
//
//			CommonWebActions.waituntil("PurchasingLocalCurrency");
//			// CommonWebActions.webSetFromXls("PurchasingLocalCurrency", "PurchasingLocalCurrency");
//
//			CommonWebActions.wait(2000);
//
//			CommonWebActions.waituntil("PurchasingCurrentPriceLC");
//			// CommonWebActions.webSetFromXls("PurchasingCurrentPriceLC", "PurchasingCurrentPriceLC");
//
//			CommonWebActions.waituntil("PurchasingNewPriceLC");
//			// CommonWebActions.webSetFromXls("PurchasingNewPriceLC", "PurchasingNewPriceLC");
//
//			CommonWebActions.waituntil("SurchargeonPricebased");
//			// CommonWebActions.webSetFromXls("SurchargeonPricebased", "SurchargeonPricebased");
//
//			CommonWebActions.waituntil("Purchasing_Material");
//			// CommonWebActions.webSetFromXls("Purchasing_Material", "Purchasing_Material");
//
//			CommonWebActions.waituntil("NegotiatedPrices");
//			// CommonWebActions.webSetFromXls("NegotiatedPrices", "NegotiatedPrices", true);
//
//			///////////////////////////////////////////////////////////////////////////////////////////
//
//			CommonWebActions.waituntil("Purchasing_Packingandonetinecosts");
//			CommonWebActions.webClick("Purchasing_Packingandonetinecosts");
//
//			CommonWebActions.waituntil("PackagingCosts");
//			// CommonWebActions.webSetFromXls("PackagingCosts", "PackagingCosts");
//
//			CommonWebActions.waituntil("DeltaToolingCosts");
//			// CommonWebActions.webSetFromXls("DeltaToolingCosts", "DeltaToolingCosts");
//
//			CommonWebActions.waituntil("Descriptiontoinvest");
//			// CommonWebActions.webSetFromXls("Descriptiontoinvest", "Descriptiontoinvest");
//
//			////////////////////////////////////////////////////////////////////////////////////
//
//			/*
//			 * CommonWebActions.waituntil("Purchasing_Addmilestonebutton");
//			 * CommonWebActions.webClick("Purchasing_Addmilestonebutton");
//			 * CommonWebActions.webClick("Purchasing_Addmilestonebutton");
//			 * CommonWebActions.webClick("Purchasing_Addmilestonebutton");
//			 * CommonWebActions.webClick("Purchasing_Addmilestonebutton");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_milestonetype1");
//			 * // CommonWebActions.webSetFromXls("Purchasing_milestonetype1",
//			 * "Purchasing_milestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDate1");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDate1",
//			 * "Purchasing_MilestoneDate1");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDuration1");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDuration1",
//			 * "Purchasing_MilestoneDuration1");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneComment1",
//			 * "Purchasing_MilestoneComment1");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_milestonetype2");
//			 * // CommonWebActions.webSetFromXls("Purchasing_milestonetype2",
//			 * "Purchasing_milestonetype2");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDate2");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDate2",
//			 * "Purchasing_MilestoneDate2");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDuration2");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDuration2",
//			 * "Purchasing_MilestoneDuration2");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneComment2");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneComment2",
//			 * "Purchasing_MilestoneComment2");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_milestonetype3");
//			 * // CommonWebActions.webSetFromXls("Purchasing_milestonetype3",
//			 * "Purchasing_milestonetype3");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDate3");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDate3",
//			 * "Purchasing_MilestoneDate3");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDuration3");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDuration3",
//			 * "Purchasing_MilestoneDuration3");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneComment3");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneComment3",
//			 * "Purchasing_MilestoneComment3");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_milestonetype4");
//			 * // CommonWebActions.webSetFromXls("Purchasing_milestonetype4",
//			 * "Purchasing_milestonetype4");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDate4");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDate4",
//			 * "Purchasing_MilestoneDate4");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneDuration4");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneDuration4",
//			 * "Purchasing_MilestoneDuration4");
//			 * 
//			 * CommonWebActions.waituntil("Purchasing_MilestoneComment4");
//			 * // CommonWebActions.webSetFromXls("Purchasing_MilestoneComment4",
//			 * "Purchasing_MilestoneComment4");
//			 */
//
//			CommonWebActions.waituntil("PurchasingRecommendationtab");
//			CommonWebActions.webClick("PurchasingRecommendationtab");
//
//			// CommonWebActions.webSetFromXls("PurchasingTeaminfoRecommendation", "PurchasingTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("PurchasingTeaminfoRecommendationComment", "PurchasingTeaminfoRecommendationComment");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoPurchasing", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoPurchasing");
//			executionTimes.put("FillTeamInfoPurchasing", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoPurchasing() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("PurchasingSubmitteaminfo");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoPurchasing", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoPurchasing");
//			executionTimes.put("FinishTeamInfoPurchasing", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillPurchasingStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			// CommonWebActions.waituntil("Purchasing_Consolidatemilestones");
//
//			// CommonWebActions.webClick("Purchasing_Consolidatemilestones");
//
//			CommonWebActions.waituntil("PurchasingRecommendationtab");
//			CommonWebActions.webClick("PurchasingRecommendationtab");
//
//			// CommonWebActions.webSetFromXls("FillPurchasingStmtRecommendation", "FillPurchasingStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillPurchasingStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillPurchasingStmt");
//			executionTimes.put("FillPurchasingStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishPurchasingStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("PurchasingSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("PurchasingSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignStmt");
//			executionTimes.put("FinishDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindCostEngstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String CostEngstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Cost Engineering" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String CostEngstmt2 = CostEngstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + CostEngstmt2);
//			ORUtil.setValue("CostEngstmt1", CostEngstmt2);
//			CommonWebActions.waituntil("CostEngstmt1");
//			System.out.println("Found CostEngstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindCostEngstmt");
//
//		}
//
//	}
//
//	public static void OpenCostEngStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("CostEngstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("CostEngstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("CostEngstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenCostEngStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoCostEng() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("PurchaseDistributiontab");
//			CommonWebActions.webClick("PurchaseDistributiontab");
//
//			CommonWebActions.waituntil("CostEngTeamsHeader");
//			CommonWebActions.webClick("CostEngTeamsHeader");
//
//			CommonWebActions.waituntil("CostEngTeaminfoAddbutton");
//			CommonWebActions.webClick("CostEngTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("CostEngTeaminfoExpert", "CostEngTeaminfoExpert");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("CostEngTeaminfoExpertpopup");
//
//			CommonWebActions.waituntil("CostEngTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("CostEngTeaminfoteamlist", "CostEngTeaminfoteamlist");
//
//			CommonWebActions.waituntil("CostEngTeaminfoRemark");
//			// CommonWebActions.webSetFromXls("CostEngTeaminfoRemark", "CostEngTeaminfoRemark");
//
//			CommonWebActions.waituntil("CostEngAssignParts");
//			CommonWebActions.webClick("CostEngAssignParts");
//
//			CommonWebActions.waituntil("CostEngPartAssignedcheckbox");
//			CommonWebActions.webClick("CostEngPartAssignedcheckbox");
//
//			CommonWebActions.waituntil("CostEngPartAssignedcheckboxTool");
//			CommonWebActions.webClick("CostEngPartAssignedcheckboxTool");
//
//			CommonWebActions.waituntil("CostEng_PartsAssignedSaveButton");
//			CommonWebActions.webClick("CostEng_PartsAssignedSaveButton");
//
//			CommonWebActions.waituntil("CostEng_DistributeTeams");
//			CommonWebActions.webClick("CostEng_DistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoCostEng", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoCostEng");
//			executionTimes.put("distributeTeamInfoCostEng", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoCostEng() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String CostEngteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Cost Engineering" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String CostEngteaminfo2 = CostEngteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + CostEngteaminfo2);
//			ORUtil.setValue("CostEngteaminfo1", CostEngteaminfo2);
//			CommonWebActions.waituntil("CostEngteaminfo1");
//			System.out.println("found CostEngteaminfo");
//
//			ReportUtil.reporterEvent("findTeaminfoCostEng", "findTeaminfoCostEng  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoCostEng");
//			executionTimes.put("findTeaminfoCostEng", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoCostEng() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("CostEngteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("CostEngteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("CostEngteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoCostEng", "OpenTeaminfoCostEng opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoCostEng");
//
//		}
//
//	}
//
//	public static void FillTeamInfoCostEng() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("CostEngStatementteamtask");
//			// CommonWebActions.webSetFromXls("CostEngStatementteamtask", "CostEngStatementteamtask");
//
//			CommonWebActions.waituntil("CostengineeringItemstab");
//			CommonWebActions.webClick("CostengineeringItemstab");
//
//			// CommonWebActions.waituntil("Costengpartnumber_header");
//			// CommonWebActions.webClick("Costengpartnumber_header");
//
//			CommonWebActions.waituntil("Costeng_selectPart");
//			CommonWebActions.webClick("Costeng_selectPart");
//
//			CommonWebActions.waituntil("Costeng_Expand");
//			CommonWebActions.webClick("Costeng_Expand");
//
//			CommonWebActions.waituntil("CostEngLocalCurrency");
//			// CommonWebActions.webSetFromXls("CostEngLocalCurrency", "CostEngLocalCurrency");
//
//			CommonWebActions.waituntil("DeltaCostperpart");
//			// CommonWebActions.webSetFromXls("DeltaCostperpart", "DeltaCostperpart");
//
//			CommonWebActions.waituntil("CountryofCostEng");
//			// CommonWebActions.webSetFromXls("CountryofCostEng", "CountryofCostEng");
//
//			CommonWebActions.waituntil("Productionsite");
//			// CommonWebActions.webSetFromXls("Productionsite", "Productionsite");
//
//			// CommonWebActions.waituntil("DeltaCostperyear");
//			// // CommonWebActions.webSetFromXls("DeltaCostperyear","DeltaCostperyear");
//
//			CommonWebActions.waituntil("Costeng_AddToolingcost");
//			CommonWebActions.webClick("Costeng_AddToolingcost");
//
//			CommonWebActions.waituntil("ToolingName");
//			// CommonWebActions.webSetFromXls("ToolingName", "ToolingName");
//
//			CommonWebActions.waituntil("ToolingDesc");
//			// CommonWebActions.webSetFromXls("ToolingDesc", "ToolingDesc");
//
//			CommonWebActions.waituntil("ToolingStatus");
//			// CommonWebActions.webSetFromXls("ToolingStatus", "ToolingStatus");
//
//			CommonWebActions.waituntil("ToolingCostType");
//			// CommonWebActions.webSetFromXls("ToolingCostType", "ToolingCostType");
//
//			CommonWebActions.waituntil("ToolingImplementationPlant");
//			// CommonWebActions.webSetFromXls("ToolingImplementationPlant", "ToolingImplementationPlant");
//
//			// CommonWebActions.waituntil("ToolingLeadTime");
//			// CommonWebActions.webSet("ToolingLeadTime", "ToolingLeadTime");
//
//			CommonWebActions.waituntil("ToolingLocalCurrency");
//			// CommonWebActions.webSetFromXls("ToolingLocalCurrency", "ToolingLocalCurrency");
//
//			CommonWebActions.waituntil("DeltaSupplierToolingCosts");
//			// CommonWebActions.webSetFromXls("DeltaSupplierToolingCosts", "DeltaSupplierToolingCosts");
//
//			CommonWebActions.waituntil("ToolingComment");
//			// CommonWebActions.webSetFromXls("ToolingComment", "ToolingComment");
//
//			/*
//			 * CommonWebActions.waituntil("CostEngMilestonetypeHeader");
//			 * CommonWebActions.webClick("CostEngMilestonetypeHeader");
//			 * 
//			 * // CommonWebActions.waituntil("CostEngMilestonedeleteheader"); //
//			 * CommonWebActions.webClick("CostEngMilestonedeleteheader");
//			 * 
//			 * CommonWebActions.waituntil("CostEngMilestoneAddbutton");
//			 * CommonWebActions.webClick("CostEngMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.waituntil("CostEngMilestonetype1");
//			 * // CommonWebActions.webSetFromXls("CostEngMilestonetype1",
//			 * "CostEngMilestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("CostEngMilestonedate1");
//			 * // CommonWebActions.webSetFromXls("CostEngMilestonedate1",
//			 * "CostEngMilestonedate1");
//			 * 
//			 * CommonWebActions.waituntil("CostEngMilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("CostEngMilestoneComment1",
//			 * "CostEngMilestoneComment1");
//			 */
//
//			CommonWebActions.waituntil("PurchasingRecommendationtab");
//			CommonWebActions.webClick("PurchasingRecommendationtab");
//
//			// CommonWebActions.webSetFromXls("CostEngTeaminfoRecommendation", "CostEngTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("CostEngTeaminfoRecommendationComment", "CostEngTeaminfoRecommendationComment");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoCostEng", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoCostEng");
//			executionTimes.put("FillTeamInfoCostEng", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoCostEng() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.webClick("CostEngSubmitteaminfo");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoCostEng", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoCostEng");
//			executionTimes.put("FinishTeamInfoCostEng", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillCostEngStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			// CommonWebActions.waituntil("CostEngStmt_Consolidatemilestones");
//
//			// CommonWebActions.webClick("CostEngStmt_Consolidatemilestones");
//
//			CommonWebActions.waituntil("PurchasingRecommendationtab");
//			CommonWebActions.webClick("PurchasingRecommendationtab");
//
//			// CommonWebActions.webSetFromXls("FillCostEngStmtRecommendation", "FillCostEngStmtRecommendation");
//
//			// CommonWebActions.webSetFromXls("CostEngStmtRecommendationComment", "CostEngStmtRecommendationComment");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillCostEngStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillCostEngStmt");
//			executionTimes.put("FillCostEngStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishCostEngStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("CostEngSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("CostEngSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishDesignStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishDesignStmt");
//			executionTimes.put("FinishDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindMfgEngstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String MfgEngstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Manufacturing Engineering" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String MfgEngstmt2 = MfgEngstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + MfgEngstmt2);
//			ORUtil.setValue("MfgEngstmt1", MfgEngstmt2);
//			CommonWebActions.waituntil("MfgEngstmt1");
//			System.out.println("Found CostEngstmt");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindMfgEngstmt");
//
//		}
//
//	}
//
//	public static void OpenMfgEngStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("MfgEngstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("MfgEngstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("MfgEngstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenMfgEngStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoMfgEng() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("MFGDistributiontab");
//			CommonWebActions.webClick("MFGDistributiontab");
//
//			CommonWebActions.waituntil("Mfgteamheader");
//			CommonWebActions.webClick("Mfgteamheader");
//
//			CommonWebActions.waituntil("MfgTeaminfoAddbutton");
//			CommonWebActions.webClick("MfgTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("MfgTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("MFGTeaminfoExpertpopup");
//
//			CommonWebActions.waituntil("MfgTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("MfgTeaminfoteamlist", "MfgTeaminfoteamlist");
//
//			CommonWebActions.waituntil("MfgTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("MfgTeaminfoRemarkdesc", "MfgTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("MFGEng_DistributeTeams");
//			CommonWebActions.webClick("MFGEng_DistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeMfgTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("DistributeMfgTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoMfgEng() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String MfgEngteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Manufacturing Engineering" + "\" Statement: Fill team info for \""
//					+ packageNumber + "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String MfgEngteaminfo2 = MfgEngteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + MfgEngteaminfo2);
//			ORUtil.setValue("MfgEngteaminfo1", MfgEngteaminfo2);
//			CommonWebActions.waituntil("MfgEngteaminfo1");
//			System.out.println("found MfgEngteaminfo");
//
//			ReportUtil.reporterEvent("findTeaminfoMfgEng", "findTeaminfoMfgEng found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoMfgEng");
//			executionTimes.put("findTeaminfoMfgEng", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoMfgEng() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("MfgEngteaminfo1");
//			// CommonWebActions.webClick("MfgEngteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("MfgEngteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("MfgEngteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoMfgEng", "OpenTeaminfoMfgEng opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoMfgEng");
//
//		}
//
//	}
//
//	public static void FillTeamInfoMfgEng() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("ME_PlantAffected");
//			// CommonWebActions.webClick("ME_PlantAffected");
//			// CommonWebActions.webClick("ME_PlantAffected");
//			// CommonWebActions.ICMclick("ME_PlantAffected");
//			CommonWebActions.webClick("ME_PlantAffected");
//
//			CommonWebActions.waituntil("ME_AddPlant");
//			CommonWebActions.webClick("ME_AddPlant");
//
//			CommonWebActions.waituntil("ExpensesPlant");
//			// CommonWebActions.webSetFromXls("ExpensesPlant", "ExpensesPlant");
//			// CommonWebActions.webClick("ExpensesPlant");
//
//			CommonWebActions.waituntil("ME_AddNewPlant_AddButton");
//			// CommonWebActions.webClick("ME_AddNewPlant_AddButton");
//			// CommonWebActions.webClick("ME_AddNewPlant_AddButton");
//			// CommonWebActions.ICMclick("ME_AddNewPlant_AddButton");
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("ME_AddNewPlant_AddButton");
//
//			CommonWebActions.waituntil("ME_PlantCheckbox");
//			CommonWebActions.webClick("ME_PlantCheckbox");
//
//			CommonWebActions.waituntil("ME_PlantExpand");
//			CommonWebActions.webClick("ME_PlantExpand");
//
//			CommonWebActions.waituntil("ExpensesAddButton");
//			CommonWebActions.webClick("ExpensesAddButton");
//
//			CommonWebActions.waituntil("ExpensesCostcenter");
//			// CommonWebActions.webSetFromXls("ExpensesCostcenter", "ExpensesCostcenter");
//
//			CommonWebActions.waituntil("ExpensesCostCategory");
//			// CommonWebActions.webSetFromXls("ExpensesCostCategory", "ExpensesCostCategory");
//
//			// CommonWebActions.waituntil("ExpensesCostDetails");
//			// // CommonWebActions.webSetFromXls("ExpensesCostDetails","ExpensesCostDetails");
//
//			CommonWebActions.waituntil("ExpensesCurrency");
//			// CommonWebActions.webSetFromXls("ExpensesCurrency", "ExpensesCurrency");
//
//			CommonWebActions.waituntil("ExpensesLocalCurrency");
//			// CommonWebActions.webSetFromXls("ExpensesLocalCurrency", "ExpensesLocalCurrency");
//
//			CommonWebActions.waituntil("ExpensesComment");
//			// CommonWebActions.webSetFromXls("ExpensesComment", "ExpensesComment");
//
//			CommonWebActions.waituntil("ME_AddExpenesemodal_AddExpensesButton");
//			CommonWebActions.webClick("ME_AddExpenesemodal_AddExpensesButton");
//
//			CommonWebActions.waituntil("ME_PlantExpand");
//			CommonWebActions.webClick("ME_PlantExpand");
//
//			CommonWebActions.waituntil("ExpensesEditbutton");
//			CommonWebActions.webClick("ExpensesEditbutton");
//
//			CommonWebActions.waituntil("Editexpensescostcenter");
//			// CommonWebActions.webSetFromXls("Editexpensescostcenter", "ExpensesCostcenter");
//
//			// CommonWebActions.waituntil("ExpensesCostCategory");
//			// // CommonWebActions.webSetFromXls("ExpensesCostCategory","ExpensesCostCategory");
//
//			CommonWebActions.waituntil("Editexpensescostdetails");
//			// CommonWebActions.webSetFromXls("Editexpensescostdetails", "ExpensesCostDetails");
//
//			CommonWebActions.waituntil("ME_EditExpenesemodal_AddExpensesButton");
//			CommonWebActions.webClick("ME_EditExpenesemodal_AddExpensesButton");
//
//			CommonWebActions.waituntil("ME_PlantExpand");
//			CommonWebActions.webClick("ME_PlantExpand");
//
//			CommonWebActions.waituntil("ME_ProcessTimeLink");
//			CommonWebActions.webClick("ME_ProcessTimeLink");
//
//			CommonWebActions.waituntil("ME_AddProcessTimeButton");
//			CommonWebActions.webClick("ME_AddProcessTimeButton");
//
//			CommonWebActions.wait(2000);
//			CommonWebActions.waituntil("ProcessTimeCostCenter");
//			// CommonWebActions.webSetFromXls("ProcessTimeCostCenter", "ProcessTimeCostCenter");
//
//			CommonWebActions.webClick("ProcessTimeTECurrentlabel");
//			CommonWebActions.waituntil("ProcessTimeTECurrent");
//			// CommonWebActions.webSetFromXls("ProcessTimeTECurrent", "ProcessTimeTECurrent");
//			// CommonWebActions.webSetFromXls("ProcessTimeTECurrent", "ProcessTimeTECurrent");
//
//			CommonWebActions.waituntil("ProcessTimeTENew");
//			// CommonWebActions.webSetFromXls("ProcessTimeTENew", "ProcessTimeTENew");
//
//			CommonWebActions.waituntil("ManpowerforintegrationDirect");
//			// CommonWebActions.webSetFromXls("ManpowerforintegrationDirect", "ManpowerforintegrationDirect");
//
//			CommonWebActions.waituntil("ManpowerforintegrationIndirect");
//			// CommonWebActions.webSetFromXls("ManpowerforintegrationIndirect", "ManpowerforintegrationIndirect");
//
//			CommonWebActions.waituntil("ProcessTimeComment");
//			// CommonWebActions.webSetFromXls("ProcessTimeComment", "ExpensesComment");
//
//			CommonWebActions.waituntil("ME_AddprocesTimeModal_Addprocesstimebutton");
//			CommonWebActions.webClick("ME_AddprocesTimeModal_Addprocesstimebutton");
//
//			CommonWebActions.waituntil("ME_PlantExpand");
//			CommonWebActions.webClick("ME_PlantExpand");
//
//			CommonWebActions.waituntil("ME_Launchlink");
//			CommonWebActions.webClick("ME_Launchlink");
//
//			CommonWebActions.waituntil("ME_AddLaunch_button");
//			CommonWebActions.webClick("ME_AddLaunch_button");
//
//			CommonWebActions.waituntil("ME_Addnewlaunch_RiskEstimation");
//			// CommonWebActions.webSetFromXls("ME_Addnewlaunch_RiskEstimation", "LaunchRiskEstimation");
//
//			CommonWebActions.waituntil("ME_Addnewlaunch_Rampupmanager");
//			// CommonWebActions.webSetFromXls("ME_Addnewlaunch_Rampupmanager", "LaunchRampupmanager");
//
//			CommonWebActions.waituntil("ME_Addnewlaunch_Suggestionforlaunchmethod");
//			// CommonWebActions.webSetFromXls("ME_Addnewlaunch_Suggestionforlaunchmethod", "LaunchSuggestionforLaunchMethod");
//
//			CommonWebActions.waituntil("ME_Addnewlaunch_Comment");
//			// CommonWebActions.webSetFromXls("ME_Addnewlaunch_Comment", "LaunchComment");
//
//			CommonWebActions.waituntil("ME_Addnewlaunch_AddButton");
//			CommonWebActions.webClick("ME_Addnewlaunch_AddButton");
//
//			CommonWebActions.waituntil("Recommendationtab");
//			CommonWebActions.webClick("Recommendationtab");
//
//			CommonWebActions.waituntil("MfgTeaminfoRecommendation");
//			// CommonWebActions.webSetFromXls("MfgTeaminfoRecommendation", "MfgTeaminfoRecommendation");
//
//			CommonWebActions.waituntil("MfgupdateallValuesbutton");
//			CommonWebActions.webClick("MfgupdateallValuesbutton");
//		//	CommonWebActions.ICMclick("MfgupdateallValuesbutton");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillMfgTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignTeamInfo");
//			executionTimes.put("FillMfgTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoMfgEng() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("MfgSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishMfgTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishMfgTeamInfo");
//			executionTimes.put("FinishDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillMfgEngStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("Consolidationtab");
//			CommonWebActions.webClick("Consolidationtab");
//
//			CommonWebActions.waituntil("MfgCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("MfgCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("MfgUpdatetotalcostbutton");
//
//			// CommonWebActions.ICMclick("MfgConsolidateMilestones");
//
//			CommonWebActions.waituntil("Recommendationtab");
//			CommonWebActions.webClick("Recommendationtab");
//
//			// CommonWebActions.webSetFromXls("FillMfgStmtRecommendation", "FillMfgStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillMfgEngStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillMfgEngStmt");
//			executionTimes.put("FillMfgEngStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishMfgEngStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("MfgSubmitStatementbutton");
//			CommonWebActions.webClick("MfgSubmitStatementbutton");
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("workBenchHeading");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishMfgEngStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishMfgEngStmt");
//			executionTimes.put("FinishDesignStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindLogisticsstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Logisticsstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Logistics" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Logisticsstmt2 = Logisticsstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Logisticsstmt2);
//			ORUtil.setValue("Logisticsstmt1", Logisticsstmt2);
//			CommonWebActions.waituntil("Logisticsstmt1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindLogisticsstmt");
//
//		}
//
//	}
//
//	public static void OpenLogisticsStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Logisticsstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("LogisticsstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("LogisticsstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenLogisticsStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoLogistics() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("Log_DistributeTeams");
//
//			CommonWebActions.waituntil("teamheader");
//			CommonWebActions.webClick("teamheader");
//
//			CommonWebActions.waituntil("LogTeaminfoAddbutton");
//			CommonWebActions.webClick("LogTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("LogTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.wait(1000);
//			CommonWebActions.webClick("LogTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("LogTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("LogTeaminfoteamlist", "LogTeaminfoteamlist");
//
//			CommonWebActions.waituntil("LogTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("LogTeaminfoRemarkdesc", "LogTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("Log_DistributeTeams");
//			CommonWebActions.webClick("Log_DistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoLogistics", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoLogistics");
//			executionTimes.put("distributeTeamInfoLogistics", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoLogistics() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//	//	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Logisticsteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Logistics" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Logisticsteaminfo2 = Logisticsteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Logisticsteaminfo2);
//			ORUtil.setValue("Logisticsteaminfo1", Logisticsteaminfo2);
//			CommonWebActions.waituntil("Logisticsteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoLogistics", "findTeaminfoLogistics  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoLogistics");
//			executionTimes.put("findTeaminfoLogistics", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoLogistics() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Logisticsteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("LogisticsteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("LogisticsteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoLogistics", "OpenTeaminfoLogistics opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoLogistics");
//
//		}
//
//	}
//
//	public static void FillTeamInfoLogistics() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("LogCommonInformationtab");
//			CommonWebActions.webClick("LogCommonInformationtab");
//		//	CommonWebActions.ICMclick("LogCommonInformationtab");
//
//			CommonWebActions.waituntil("LogStatementteamtask");
//			// CommonWebActions.webSetFromXls("LogStatementteamtask", "LogStatementteamtask");
//
//			CommonWebActions.scrollDown(300);
//
//			CommonWebActions.waituntil("Onetimecostsheader");
//			CommonWebActions.webClick("Onetimecostsheader");
//
//			CommonWebActions.waituntil("OnetimecostsAddButton");
//			CommonWebActions.webClick("OnetimecostsAddButton");
//
//			CommonWebActions.waituntil("OnetimecostsPlant");
//			// CommonWebActions.webSetFromXls("OnetimecostsPlant", "OnetimecostsPlant");
//
//			CommonWebActions.webClick("OnetimecostsTeam");
//			// CommonWebActions.webSetFromXls("OnetimecostsTeam", "OnetimecostsTeam");
//
//			CommonWebActions.waituntil("OnetimecostsIsplanteffected_yes");
//			CommonWebActions.webClick("OnetimecostsIsplanteffected_yes");
//
//			CommonWebActions.webClick("OnetimecostsBreifdesctechimpl");
//			// CommonWebActions.webSetFromXls("OnetimecostsBreifdesctechimpl", "OnetimecostsBreifdesctechimpl");
//
//			CommonWebActions.webClick("Packaging");
//			// CommonWebActions.webSetFromXls("Packaging", "Packaging");
//
//			CommonWebActions.webClick("MaterialHandling");
//			// CommonWebActions.webSetFromXls("MaterialHandling", "MaterialHandling");
//
//			CommonWebActions.scrollDown(200);
//
//			CommonWebActions.waituntil("Int&extlogcostslheader");
//			CommonWebActions.webClick("Int&extlogcostslheader");
//
//			CommonWebActions.waituntil("Int&extlogcostsAddButton");
//			CommonWebActions.webClick("Int&extlogcostsAddButton");
//
//			CommonWebActions.waituntil("Int&extlogcostsPlant");
//			// CommonWebActions.webSetFromXls("Int&extlogcostsPlant", "Int&extlogcostsPlant");
//
//			CommonWebActions.waituntil("Int&extlogcostsTeam");
//			// CommonWebActions.webSetFromXls("Int&extlogcostsTeam", "Int&extlogcostsTeam");
//
//			CommonWebActions.waituntil("Int&extlogIsplanteffected_yes");
//			CommonWebActions.webClick("Int&extlogIsplanteffected_yes");
//
//			CommonWebActions.waituntil("Int&extlogBreifdesctechimpl");
//			// CommonWebActions.webSetFromXls("Int&extlogBreifdesctechimpl", "Int&extlogBreifdesctechimpl");
//
//			CommonWebActions.waituntil("Int&extlogIncoterms");
//			// CommonWebActions.webSetFromXls("Int&extlogIncoterms", "Int&extlogIncoterms");
//
//			CommonWebActions.waituntil("Int&extlogIncotermsLocation");
//			// CommonWebActions.webSetFromXls("Int&extlogIncotermsLocation", "Int&extlogIncotermsLocation");
//
//			CommonWebActions.waituntil("UseIndirectmaterialcosts_yes");
//			CommonWebActions.webClick("UseIndirectmaterialcosts_yes");
//
//			CommonWebActions.waituntil("InternalLogisticcosts_Current");
//			// CommonWebActions.webSetFromXls("InternalLogisticcosts_Current", "InternalLogisticcosts_Current");
//
//			CommonWebActions.waituntil("InternalLogisticcosts_New");
//			// CommonWebActions.webSetFromXls("InternalLogisticcosts_New", "InternalLogisticcosts_New");
//
//			CommonWebActions.waituntil("ExternalLogisticCosts_Current");
//			// CommonWebActions.webSetFromXls("ExternalLogisticCosts_Current", "ExternalLogisticCosts_Current");
//
//			CommonWebActions.waituntil("ExternalLogisticCosts_New");
//			// CommonWebActions.webSetFromXls("ExternalLogisticCosts_New", "ExternalLogisticCosts_New");
//
//			/*
//			 * CommonWebActions.waituntil("LogMilestonetypeHeader");
//			 * CommonWebActions.webClick("LogMilestonetypeHeader");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonedeleteheader");
//			 * CommonWebActions.webClick("LogMilestonedeleteheader");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestoneAddbutton");
//			 * CommonWebActions.webClick("LogMilestoneAddbutton");
//			 * CommonWebActions.webClick("LogMilestoneAddbutton");
//			 * CommonWebActions.webClick("LogMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonetype1");
//			 * // CommonWebActions.webSetFromXls("LogMilestonetype1",
//			 * "LogMilestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonedate1");
//			 * // CommonWebActions.webSetFromXls("LogMilestonedate1",
//			 * "LogMilestonedate1");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("LogMilestoneComment1",
//			 * "LogMilestoneComment1");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonetype2");
//			 * // CommonWebActions.webSetFromXls("LogMilestonetype2",
//			 * "LogMilestonetype2");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonedate2");
//			 * // CommonWebActions.webSetFromXls("LogMilestonedate2",
//			 * "LogMilestonedate2");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestoneComment2");
//			 * // CommonWebActions.webSetFromXls("LogMilestoneComment2",
//			 * "LogMilestoneComment2");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonetype3");
//			 * // CommonWebActions.webSetFromXls("LogMilestonetype3",
//			 * "LogMilestonetype3");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestonedate3");
//			 * // CommonWebActions.webSetFromXls("LogMilestonedate3",
//			 * "LogMilestonedate3");
//			 * 
//			 * CommonWebActions.waituntil("LogMilestoneComment3");
//			 * // CommonWebActions.webSetFromXls("LogMilestoneComment3",
//			 * "LogMilestoneComment3");
//			 */
//
//			CommonWebActions.webClick("LogTeaminfoRecommendation");
//			// CommonWebActions.webSetFromXls("LogTeaminfoRecommendation", "LogTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoLogistics", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoLogistics");
//			executionTimes.put("FillTeamInfoLogistics", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoLogistics() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("LogSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoLogistics", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoLogistics");
//			executionTimes.put("FinishTeamInfoLogistics", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillLogisticsStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			// CommonWebActions.waituntil("LogCopyCostsbutton");
//
//			// CommonWebActions.ICMclick("LogCopyCostsbutton");
//
//			// CommonWebActions.webSetFromXls("FillLogStmtRecommendation", "FillLogStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillLogisticsStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillLogisticsStmt");
//			executionTimes.put("FillLogisticsStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishLogisticsStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("LogSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("LogSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishLogisticsStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishLogisticsStmt");
//			executionTimes.put("FinishLogisticsStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindSupplierManagementstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String SupplierManagement1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Supplier Management" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String SupplierManagement2 = SupplierManagement1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + SupplierManagement2);
//			ORUtil.setValue("SupplierManagement1", SupplierManagement2);
//			CommonWebActions.waituntil("SupplierManagement1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindSupplierManagementStatement");
//
//		}
//
//	}
//
//	public static void OpenSupplierManagementStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("SupplierManagement1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("SupplierManagementiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SupplierManagementShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenSupplierManagementStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoSupplierManagement() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("SMDistributeTeams");
//
//			CommonWebActions.waituntil("SM_teamheader");
//			CommonWebActions.webClick("SM_teamheader");
//
//			CommonWebActions.waituntil("SMTeaminfoAddbutton");
//			CommonWebActions.webClick("SMTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("SMTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("SupplierTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("SMTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("SMTeaminfoteamlist", "SMTeaminfoteamlist");
//
//			CommonWebActions.waituntil("SMTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("SMTeaminfoRemarkdesc", "SMTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("SMDistributeTeams");
//			CommonWebActions.webClick("SMDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoSupplierManagement", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoSupplierManagement");
//			executionTimes.put("distributeTeamInfoSupplierManagement", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoSupplierManagement() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String SupplierManagementteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Supplier Management" + "\" Statement: Fill team info for \""
//					+ packageNumber + "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String SupplierManagementteaminfo2 = SupplierManagementteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + SupplierManagementteaminfo2);
//			ORUtil.setValue("SupplierManagementteaminfo1", SupplierManagementteaminfo2);
//			CommonWebActions.waituntil("SupplierManagementteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoSupplierManagement",
//					"findTeaminfoSupplierManagement  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoSupplierManagement");
//			executionTimes.put("distributeTeamInfoSupplierManagement", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoSupplierManagement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("SupplierManagementteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("SupplierManagementteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SupplierManagementteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoSupplierManagement",
//					"OpenTeaminfoSupplierManagement opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenSupplierManagementStatement");
//
//		}
//
//	}
//
//	public static void FillTeamInfoSupplierManagement() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("SMCommonInformationtab");
//			CommonWebActions.webClick("SMCommonInformationtab");
//		//	CommonWebActions.ICMclick("SMCommonInformationtab");
//
//			CommonWebActions.waituntil("SMStatementteamtask");
//			// CommonWebActions.webSetFromXls("SMStatementteamtask", "SMStatementteamtask");
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.waituntil("SMteaminfo_Plantstab_plant");
//			// CommonWebActions.webSetFromXls("SMteaminfo_Plantstab_plant", "SMteaminfo_Plantstab_plant");
//
//			CommonWebActions.waituntil("SMteaminfo_Plantstab_plantaffected");
//			CommonWebActions.webClick("SMteaminfo_Plantstab_plantaffected");
//
//			CommonWebActions.waituntil("SMteaminfo_Plantstab_Rsikestimation");
//			// CommonWebActions.webSetFromXls("SMteaminfo_Plantstab_Rsikestimation", "SMteaminfo_Plantstab_Rsikestimation");
//
//			CommonWebActions.waituntil("SMteaminfo_Plantstab_Suggestionforlaunchmethod");
//			// CommonWebActions.webSetFromXls("SMteaminfo_Plantstab_Suggestionforlaunchmethod", "SMteaminfo_Plantstab_Suggestionforlaunchmethod");
//
//			CommonWebActions.waituntil("SMteaminfo_Plantstab_Supplierreadinessactivities");
//			// CommonWebActions.webSetFromXls("SMteaminfo_Plantstab_Supplierreadinessactivities", "SMteaminfo_Plantstab_Supplierreadinessactivities");
//
//			CommonWebActions.waituntil("SMUpdateoverallcostsbutton");
//			CommonWebActions.webClick("SMUpdateoverallcostsbutton");
//		//	CommonWebActions.ICMclick("SMUpdateoverallcostsbutton");
//
//			/*
//			 * CommonWebActions.waituntil("SMMilestonetypeHeader");
//			 * CommonWebActions.webClick("SMMilestonetypeHeader");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonedeleteheader");
//			 * CommonWebActions.webClick("SMMilestonedeleteheader");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestoneAddbutton");
//			 * CommonWebActions.webClick("SMMilestoneAddbutton");
//			 * CommonWebActions.webClick("SMMilestoneAddbutton");
//			 * CommonWebActions.webClick("SMMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonetype1");
//			 * // CommonWebActions.webSetFromXls("SMMilestonetype1",
//			 * "SMMilestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonedate1");
//			 * // CommonWebActions.webSetFromXls("SMMilestonedate1",
//			 * "SMMilestonedate1");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("SMMilestoneComment1",
//			 * "SMMilestoneComment1");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonetype2");
//			 * // CommonWebActions.webSetFromXls("SMMilestonetype2",
//			 * "SMMilestonetype2");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonedate2");
//			 * // CommonWebActions.webSetFromXls("SMMilestonedate2",
//			 * "SMMilestonedate2");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestoneComment2");
//			 * // CommonWebActions.webSetFromXls("SMMilestoneComment2",
//			 * "SMMilestoneComment2");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonetype3");
//			 * // CommonWebActions.webSet1("SMMilestonetype3", "SMMilestonetype3");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestonedate3");
//			 * // CommonWebActions.webSetFromXls("SMMilestonedate3",
//			 * "SMMilestonedate3");
//			 * 
//			 * CommonWebActions.waituntil("SMMilestoneComment3");
//			 * // CommonWebActions.webSetFromXls("SMMilestoneComment3",
//			 * "SMMilestoneComment3");
//			 */
//
//			CommonWebActions.waituntil("SMTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("SMTeaminfoRecommendation", "SMTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoSupplierManagement", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoSupplierManagement");
//			executionTimes.put("FillTeamInfoSupplierManagement", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoSupplierManagement() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("SMSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoSupplierManagement", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoSupplierManagement");
//			executionTimes.put("FinishTeamInfoSupplierManagement", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillSupplierManagementStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("SMCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("SMCopyCostsbutton");
//
//			CommonWebActions.waituntil("SMUpdatetotalcostsbutton");
//
//		//	CommonWebActions.ICMclick("SMUpdatetotalcostsbutton");
//
//			CommonWebActions.waituntil("SMConsolidatemilestonesbutton");
//
//		//	CommonWebActions.ICMclick("SMConsolidatemilestonesbutton");
//
//			// CommonWebActions.webSetFromXls("FillSMStmtRecommendation", "FillSMStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillSupplierManagementStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillSupplierManagementStmt");
//			executionTimes.put("FillSupplierManagementStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishSupplierManagementStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("SMSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("SMSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishSupplierManagementStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishSupplierManagementStmt");
//			executionTimes.put("FinishSupplierManagementStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindSalesstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Salesstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Sales" + "\" Statement for \"" + packageNumber + "\"') and contains(text(),\""
//					+ CRtitle + "\")][@title='Click to work on the task']";
//
//			String Salesstmt2 = Salesstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Salesstmt2);
//			ORUtil.setValue("Salesstmt1", Salesstmt2);
//			CommonWebActions.waituntil("Salesstmt1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindSalesstmt");
//
//		}
//
//	}
//
//	public static void OpenSalesStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Salesstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("SalesisticsstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SalesisticsstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenSalesStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoSales() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("SalesDistributeTeams");
//
//			CommonWebActions.waituntil("Sales_teamheader");
//			CommonWebActions.webClick("Sales_teamheader");
//
//			CommonWebActions.waituntil("SalesTeaminfoAddbutton");
//			CommonWebActions.webClick("SalesTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("SalesTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("SalesTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("SalesTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("SalesTeaminfoteamlist", "SalesTeaminfoteamlist");
//
//			CommonWebActions.waituntil("SalesMarket");
//			// CommonWebActions.webSetFromXls("SalesMarket", "SalesMarket");
//
//			CommonWebActions.waituntil("SalesTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("SalesTeaminfoRemarkdesc", "SalesTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("SalesDistributeTeams");
//			CommonWebActions.webClick("SalesDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoSales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoSales");
//			executionTimes.put("distributeTeamInfoSales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoSales() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Salesteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Sales" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Salesteaminfo2 = Salesteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Salesteaminfo2);
//			ORUtil.setValue("Salesteaminfo1", Salesteaminfo2);
//			CommonWebActions.waituntil("Salesteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoSales", "findTeaminfoSales  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoSales");
//			executionTimes.put("findTeaminfoSales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoSales() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Salesteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("SalesteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("SalesteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoSales", "OpenTeaminfoSales opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoSales");
//
//		}
//
//	}
//
//	public static void FillTeamInfoSales() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("SalesCommonInformationtab");
//			CommonWebActions.webClick("SalesCommonInformationtab");
//		//	CommonWebActions.ICMclick("SalesCommonInformationtab");
//
//			CommonWebActions.waituntil("SalesStatementteamtask");
//			// CommonWebActions.webSetFromXls("SalesStatementteamtask", "SalesStatementteamtask");
//
//			CommonWebActions.waituntil("MarketDetails");
//			// CommonWebActions.webSetFromXls("MarketDetails", "MarketDetails");
//
//			CommonWebActions.waituntil("SalesRemark");
//			// CommonWebActions.webSetFromXls("SalesRemark", "SalesRemark");
//
//			CommonWebActions.waituntil("CustomerNeedtobeinformed");
//			// CommonWebActions.webSetFromXls("CustomerNeedtobeinformed", "CustomerNeedtobeinformed");
//
//			CommonWebActions.waituntil("Customerinformedcomment");
//			// CommonWebActions.webSetFromXls("Customerinformedcomment", "Customerinformedcomment");
//
//			/*
//			 * CommonWebActions.waituntil("Cutomeragreedwithchange");
//			 * CommonWebActions
//			 * .webSet("Cutomeragreedwithchange","Cutomeragreedwithchange");
//			 * 
//			 * CommonWebActions.webClick("Customeragreedtext");
//			 * 
//			 * CommonWebActions.waituntil("Customeragreedcomment");
//			 * CommonWebActions
//			 * .webSet("Customeragreedcomment","Customeragreedcomment");
//			 */
//
//			CommonWebActions.waituntil("SalesMilestonetypeHeader");
//			CommonWebActions.webClick("SalesMilestonetypeHeader");
//
//			/*
//			 * CommonWebActions.waituntil("SalesMilestonedeleteheader");
//			 * CommonWebActions.webClick("SalesMilestonedeleteheader");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestoneAddbutton");
//			 * CommonWebActions.webClick("SalesMilestoneAddbutton");
//			 * CommonWebActions.webClick("SalesMilestoneAddbutton");
//			 * CommonWebActions.webClick("SalesMilestoneAddbutton");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonetype1");
//			 * // CommonWebActions.webSetFromXls("SalesMilestonetype1",
//			 * "SalesMilestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonedate1");
//			 * // CommonWebActions.webSetFromXls("SalesMilestonedate1",
//			 * "SalesMilestonedate1");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestoneComment1");
//			 * // CommonWebActions.webSetFromXls("SalesMilestoneComment1",
//			 * "SalesMilestoneComment1");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonetype2");
//			 * // CommonWebActions.webSetFromXls("SalesMilestonetype2",
//			 * "SalesMilestonetype2");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonedate2");
//			 * // CommonWebActions.webSetFromXls("SalesMilestonedate2",
//			 * "SalesMilestonedate2");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestoneComment2");
//			 * // CommonWebActions.webSetFromXls("SalesMilestoneComment2",
//			 * "SalesMilestoneComment2");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonetype3");
//			 * // CommonWebActions.webSet1("SalesMilestonetype3",
//			 * "SalesMilestonetype3");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestonedate3");
//			 * // CommonWebActions.webSetFromXls("SalesMilestonedate3",
//			 * "SalesMilestonedate3");
//			 * 
//			 * CommonWebActions.waituntil("SalesMilestoneComment3");
//			 * // CommonWebActions.webSetFromXls("SalesMilestoneComment3",
//			 * "SalesMilestoneComment3");
//			 */
//
//			CommonWebActions.waituntil("SalesTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("SalesTeaminfoRecommendation", "SalesTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoSales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoSales");
//			executionTimes.put("FillTeamInfoSales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoSales() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("SalesSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoSales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoSales");
//			executionTimes.put("FinishTeamInfoSales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillSalesStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("SalesConsolidatemilestonesbutton");
//
//		//	CommonWebActions.ICMclick("SalesConsolidatemilestonesbutton");
//
//			// CommonWebActions.webSetFromXls("FillSalesStmtRecommendation", "FillSalesStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillSalesStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillSalesStmt");
//			executionTimes.put("FillSalesStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishSalesStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("SalesSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("SalesSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishSalesStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishSalesStmt");
//			executionTimes.put("FinishSalesStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindModulestrategystmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Modulestrategystmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Module Strategy" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Modulestrategystmt2 = Modulestrategystmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Modulestrategystmt2);
//			ORUtil.setValue("Modulestrategystmt1", Modulestrategystmt2);
//			CommonWebActions.waituntil("Modulestrategystmt1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindModulestrategystmt");
//
//		}
//
//	}
//
//	public static void OpenModulestrategyStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Modulestrategystmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("ModulestrategystmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("ModulestrategystmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenModulestrategyStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoModulestrategy() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("GMSmoduleHeader");
//			CommonWebActions.webClick("GMSmoduleHeader");
//
//			CommonWebActions.waituntil("GMSmoduledeleteheader");
//			CommonWebActions.webClick("GMSmoduledeleteheader");
//
//			CommonWebActions.waituntil("GMSmodule");
//			// CommonWebActions.webSetFromXls("GMSmodule", "GMSmodule");
//
//			CommonWebActions.scrollup();
//
//			CommonWebActions.waituntil("AddGMSmodule");
//			CommonWebActions.webClick("AddGMSmodule");
//
//			CommonWebActions.waituntil("Relevantparts");
//			CommonWebActions.webClick("Relevantparts");
//
//			CommonWebActions.scrollup();
//
//			CommonWebActions.waituntil("ModulestrategyTeaminfoAddbutton");
//			CommonWebActions.webClick("ModulestrategyTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("ModulestrategyTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("ModulestgyTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("ModulestrategyTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("ModulestrategyTeaminfoteamlist", "ModulestrategyTeaminfoteamlist");
//
//			CommonWebActions.waituntil("ModulestrategyTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("ModulestrategyTeaminfoRemarkdesc", "ModulestrategyTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("ModulestrategyAssignmodulestrategy");
//			CommonWebActions.webClick("ModulestrategyAssignmodulestrategy");
//
//			CommonWebActions.waituntil("GmsmoduleAssignedcheckbox");
//			CommonWebActions.webClick("GmsmoduleAssignedcheckbox");
//
//			CommonWebActions.waituntil("GmsmoduleAssignedSaveButton");
//			CommonWebActions.webClick("GmsmoduleAssignedSaveButton");
//
//			CommonWebActions.waituntil("ModulestrategyDistributeTeams");
//			CommonWebActions.webClick("ModulestrategyDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoModulestrategy", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoModulestrategy");
//			executionTimes.put("distributeTeamInfoModulestrategy", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoModulestrategy() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String ModuleStrategyteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Module Strategy" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String ModuleStrategyteaminfo2 = ModuleStrategyteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + ModuleStrategyteaminfo2);
//			ORUtil.setValue("ModuleStrategyteaminfo1", ModuleStrategyteaminfo2);
//			CommonWebActions.waituntil("ModuleStrategyteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoModulestrategy",
//					"findTeaminfoModulestrategy found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoModulestrategy");
//			executionTimes.put("findTeaminfoModulestrategy", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoModulestrategy() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("ModuleStrategyteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("ModulestrategyteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("ModulestrategyteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoModulestrategy",
//					"OpenTeaminfoModulestrategy opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoModulestrategy");
//
//		}
//
//	}
//
//	public static void FillTeamInfoModulestrategy() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("ModulestrategyCommonInformationtab");
//			CommonWebActions.webClick("ModulestrategyCommonInformationtab");
//		//	CommonWebActions.ICMclick("ModulestrategyCommonInformationtab");
//
//			CommonWebActions.waituntil("ModulestrategyStatementteamtask");
//			// CommonWebActions.webSetFromXls("ModulestrategyStatementteamtask", "ModulestrategyStatementteamtask");
//
//			CommonWebActions.waituntil("Modulestrategycomment");
//			// CommonWebActions.webSetFromXls("Modulestrategycomment", "Modulestrategycomment");
//
//			CommonWebActions.waituntil("Reasonformodulestrategyviolation");
//			CommonWebActions.webClick("Reasonformodulestrategyviolation");
//
//			CommonWebActions.waituntil("producttypeaffected");
//			CommonWebActions.webClick("producttypeaffected");
//
//			/*
//			 * CommonWebActions.waituntil("ModulestrategyMilestonetypeHeader");
//			 * Not ready
//			 * CommonWebActions.webClick("ModulestrategyMilestonetypeHeader");
//			 * 
//			 * CommonWebActions.waituntil("ModulestrategyMilestonedeleteheader")
//			 * ;
//			 * CommonWebActions.webClick("ModulestrategyMilestonedeleteheader");
//			 * 
//			 * CommonWebActions.waituntil("ModulestrategyMilestoneAddbutton");
//			 * CommonWebActions.webClick("ModulestrategyMilestoneAddbutton");
//			 * 
//			 * 
//			 * CommonWebActions.waituntil("ModulestrategyMilestonetype1");
//			 * CommonWebActions.webSet("ModulestrategyMilestonetype1",
//			 * "ModulestrategyMilestonetype1");
//			 * 
//			 * CommonWebActions.waituntil("ModulestrategyMilestonedate1");
//			 * CommonWebActions.webSet("ModulestrategyMilestonedate1",
//			 * "ModulestrategyMilestonedate1");
//			 * 
//			 * CommonWebActions.waituntil("ModulestrategyMilestoneComment1");
//			 * CommonWebActions.webSet("ModulestrategyMilestoneComment1",
//			 * "ModulestrategyMilestoneComment1");
//			 */
//
//			CommonWebActions.waituntil("ModulestrategyTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("ModulestrategyTeaminfoRecommendation", "ModulestrategyTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoModulestrategy", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoModulestrategy");
//			executionTimes.put("FillTeamInfoModulestrategy", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoModulestrategy() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("ModulestrategySubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoModulestrategy", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoModulestrategy");
//			executionTimes.put("FinishTeamInfoModulestrategy", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillModulestrategyStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			// CommonWebActions.webSetFromXls("FillModulestrategyStmtRecommendation", "FillModulestrategyStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillModulestrategyStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillModulestrategyStmt");
//			executionTimes.put("FillModulestrategyStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishModulestrategyStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("ModulestrategySubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("ModulestrategySubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishSalesStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishModulestrategyStmt");
//			executionTimes.put("FinishModulestrategyStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindAftersalesstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Aftersalesstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "Aftersales" + "\" Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Aftersalesstmt2 = Aftersalesstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Aftersalesstmt2);
//			ORUtil.setValue("Aftersalesstmt1", Aftersalesstmt2);
//			CommonWebActions.waituntil("Aftersalesstmt1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindModulestrategystmt");
//
//		}
//
//	}
//
//	public static void OpenAftersalesStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Aftersalesstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("AftersalesstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("AftersalesstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenAftersalesStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoAftersales() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("AftersalesDistributeTeams");
//
//			CommonWebActions.waituntil("Aftersales_teamheader");
//			CommonWebActions.webClick("Aftersales_teamheader");
//
//			CommonWebActions.waituntil("AftersalesTeaminfoAddbutton");
//			CommonWebActions.webClick("AftersalesTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("AftersalesTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("AftersalesTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("AftersalesTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("AftersalesTeaminfoteamlist", "AftersalesTeaminfoteamlist");
//
//			CommonWebActions.waituntil("AftersalesTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("AftersalesTeaminfoRemarkdesc", "AftersalesTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("AftersalesDistributeTeams");
//			CommonWebActions.webClick("AftersalesDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoAftersales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoAftersales");
//			executionTimes.put("distributeTeamInfoAftersales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoAftersales() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Aftersalesteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "Aftersales" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String Aftersalesteaminfo2 = Aftersalesteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Aftersalesteaminfo2);
//			ORUtil.setValue("Aftersalesteaminfo1", Aftersalesteaminfo2);
//			CommonWebActions.waituntil("Aftersalesteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoAftersales", "findTeaminfoAftersales found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoAftersales");
//			executionTimes.put("findTeaminfoAftersales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoAftersales() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Aftersalesteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("AftersalesteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("AftersalesteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoAftersales", "OpenTeaminfoAftersales opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoAftersales");
//
//		}
//
//	}
//
//	public static void FillTeamInfoAftersales() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("AftersalesCommonInformationtab");
//			CommonWebActions.webClick("AftersalesCommonInformationtab");
//		//	CommonWebActions.ICMclick("AftersalesCommonInformationtab");
//
//			CommonWebActions.waituntil("AftersalesStatementteamtask");
//			// CommonWebActions.webSetFromXls("AftersalesStatementteamtask", "AftersalesStatementteamtask");
//
//			CommonWebActions.waituntil("ServiceEngineeringCosts");
//			// CommonWebActions.webSetFromXls("ServiceEngineeringCosts", "ServiceEngineeringCosts");
//
//			CommonWebActions.waituntil("ServiceEngineeringComment");
//			// CommonWebActions.webSetFromXls("ServiceEngineeringComment", "ServiceEngineeringComment");
//
//			CommonWebActions.waituntil("S&PmarketingCosts");
//			// CommonWebActions.webSetFromXls("S&PmarketingCosts", "S&PmarketingCosts");
//
//			CommonWebActions.waituntil("S&PmarketingComment");
//			// CommonWebActions.webSetFromXls("S&PmarketingComment", "S&PmarketingComment");
//
//			CommonWebActions.waituntil("Repmethodsorliteratures");
//			// CommonWebActions.webSetFromXls("Repmethodsorliteratures", "Repmethodsorliteratures");
//
//			CommonWebActions.waituntil("RepmethodsorliteraturesComment");
//			// CommonWebActions.webSetFromXls("RepmethodsorliteraturesComment", "RepmethodsorliteraturesComment");
//
//			CommonWebActions.waituntil("Diagnoses&telematics");
//			// CommonWebActions.webSetFromXls("Diagnoses&telematics", "Diagnoses&telematics");
//
//			CommonWebActions.waituntil("Diagnoses&telematicsComment");
//			// CommonWebActions.webSetFromXls("Diagnoses&telematicsComment", "Diagnoses&telematicsComment");
//
//			CommonWebActions.waituntil("Partsengineering");
//			// CommonWebActions.webSetFromXls("Partsengineering", "Partsengineering");
//
//			CommonWebActions.waituntil("PartsengineeringComment");
//			// CommonWebActions.webSetFromXls("PartsengineeringComment", "PartsengineeringComment");
//
//			CommonWebActions.waituntil("Reman");
//			// CommonWebActions.webSetFromXls("Reman", "Reman");
//
//			CommonWebActions.waituntil("RemanComment");
//			// CommonWebActions.webSetFromXls("RemanComment", "RemanComment");
//
//			CommonWebActions.waituntil("AftersalesTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("AftersalesTeaminfoRecommendation", "AftersalesTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoAftersales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoAftersales");
//			executionTimes.put("FillTeamInfoAftersales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoAftersales() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("AftersalesSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoAftersales", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoAftersales");
//			executionTimes.put("FinishTeamInfoAftersales", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillAftersalesStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("Refreshteamtablebutton");
//
//			CommonWebActions.wait(3000);
//			CommonWebActions.webClick("Refreshteamtablebutton");
//		//	CommonWebActions.ICMclick("Refreshteamtablebutton");
//
//			CommonWebActions.waituntil("AftersalesCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("AftersalesCopyCostsbutton");
//
//			// CommonWebActions.waituntil("AftersalesUpdatetotalcostsbutton");
//
//			// CommonWebActions.ICMclick("AftersalesUpdatetotalcostsbutton");
//
//			// CommonWebActions.waituntil("AftersalesConsolidatemilestonesbutton");
//
//			// CommonWebActions.ICMclick("AftersalesConsolidatemilestonesbutton");
//
//			// CommonWebActions.webSetFromXls("AftersalesStmtRecommendation", "AftersalesStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillAftersalesStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillAftersalesStmt");
//			executionTimes.put("FillAftersalesStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishAftersalesStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("AftersalesSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("AftersalesSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishAftersalesStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishAftersalesStmt");
//			executionTimes.put("FinishAftersalesStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FindQMstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String QMstmt1 = "xpath:=//a[starts-with(text(),'2. Fill \"" + "QM" + "\" Statement for \"" + packageNumber + "\"') and contains(text(),\""
//					+ CRtitle + "\")][@title='Click to work on the task']";
//
//			String QMstmt2 = QMstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + QMstmt2);
//			ORUtil.setValue("QMstmt1", QMstmt2);
//			CommonWebActions.waituntil("QMstmt1");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FindQMstmt");
//
//		}
//
//	}
//
//	public static void OpenQMStatement() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("QMstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("QMstmtiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("QMstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenQMStatement");
//
//		}
//	}
//
//	public static void distributeTeamInfoQM() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.scrollDown(500);
//
//			CommonWebActions.webClick("QMDistributeTeams");
//
//			CommonWebActions.waituntil("QM_teamheader");
//			CommonWebActions.webClick("QM_teamheader");
//
//			CommonWebActions.waituntil("QMTeaminfoAddbutton");
//			CommonWebActions.webClick("QMTeaminfoAddbutton");
//
//			// CommonWebActions.webSetFromXls("QMTeaminfoExpert", "Addtionalpacpersonid");
//			CommonWebActions.webClick("QMTeaminfoExpertPopup");
//
//			CommonWebActions.waituntil("QMTeaminfoteamlist");
//			// CommonWebActions.webSetFromXls("QMTeaminfoteamlist", "QMTeaminfoteamlist");
//
//			CommonWebActions.waituntil("QMTeaminfoRemarkdesc");
//			// CommonWebActions.webSetFromXls("QMTeaminfoRemarkdesc", "QMTeaminfoRemarkdesc");
//
//			CommonWebActions.waituntil("QMDistributeTeams");
//			CommonWebActions.webClick("QMDistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeTeamInfoQM", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeTeamInfoQM");
//			executionTimes.put("distributeTeamInfoQM", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findTeaminfoQM() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String QMteaminfo1 = "xpath:=//a[starts-with(text(),'2. \"" + "QM" + "\" Statement: Fill team info for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String QMteaminfo2 = QMteaminfo1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + QMteaminfo2);
//			ORUtil.setValue("QMteaminfo1", QMteaminfo2);
//			CommonWebActions.waituntil("QMteaminfo1");
//
//			ReportUtil.reporterEvent("findTeaminfoQM", "findTeaminfoQM found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findTeaminfoQM");
//			executionTimes.put("findTeaminfoQM", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenTeaminfoQM() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("QMteaminfo1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("QMteaminfoiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("QMteaminfoShellNumber");
//			System.out.println("Shell Number is displayed");
//			ReportUtil.reporterEvent("OpenTeaminfoQM", "OpenTeaminfoQM opened successfully" + CommonWebActions.captureScreenshotAsBase64());
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenTeaminfoQM");
//
//		}
//
//	}
//
//	public static void FillTeamInfoQM() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("QMCommonInformationtab");
//			CommonWebActions.webClick("QMCommonInformationtab");
//		//	CommonWebActions.ICMclick("QMCommonInformationtab");
//
//
//			CommonWebActions.waituntil("QMStatementteamtask");
//			// CommonWebActions.webSetFromXls("QMStatementteamtask", "QMStatementteamtask");
//
//			CommonWebActions.scrollDown(600);
//
//			CommonWebActions.waituntil("Warranty&policycostsaddbutton");
//			CommonWebActions.webClick("Warranty&policycostsaddbutton");
//
//			CommonWebActions.waituntil("Warranty&policycostsMarket");
//			// CommonWebActions.webSetFromXls("Warranty&policycostsMarket", "Warranty&policycostsMarket");
//
//			CommonWebActions.waituntil("Warranty&policycostsModel");
//			// CommonWebActions.webSetFromXls("Warranty&policycostsModel", "Warranty&policycostsModel");
//
//			CommonWebActions.scrollup();
//
//			CommonWebActions.waituntil("Warranty&policycostsDamagecodessl");
//			// CommonWebActions.webSet1("Warranty&policycostsDamagecodessl", "Warranty&policycostsDamagecodessl");
//
//			CommonWebActions.waituntil("Warranty&policycostsActualw_prate_product");
//			// CommonWebActions.webSet1("Warranty&policycostsActualw_prate_product", "Warranty&policycostsActualw_prate_product");
//
//			CommonWebActions.waituntil("Warranty&policycostsInspectedparts");
//			// CommonWebActions.webSet1("Warranty&policycostsInspectedparts", "Warranty&policycostsInspectedparts");
//
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("Warranty&policycostsPartswithrelatedfailure");
//			// CommonWebActions.webSet1("Warranty&policycostsPartswithrelatedfailure", "Warranty&policycostsPartswithrelatedfailure");
//
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("Warranty&policycostseffectivenessofmeasure");
//			// CommonWebActions.webSetFromXls("Warranty&policycostseffectivenessofmeasure", "Warranty&policycostseffectivenessofmeasure");
//
//			CommonWebActions.waituntil("Warranty&policycostsComment");
//			// CommonWebActions.webSetFromXls("Warranty&policycostsComment", "Warranty&policycostsComment");
//
//			CommonWebActions.waituntil("Warranty&policyrateupdatebutton");
//			CommonWebActions.webClick("Warranty&policyrateupdatebutton");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Productionsvolume");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Productionsvolume", "Warranty&policyrate_Productionsvolume");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Affectedvolumesbychange");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Affectedvolumesbychange", "Warranty&policyrate_Affectedvolumesbychange");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Updateallvaluesbutton");
//			CommonWebActions.webClick("Warranty&policyrate_Updateallvaluesbutton");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Latestfailurerate");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Latestfailurerate", "Warranty&policyrate_Latestfailurerate");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Numberofbreakdowns");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Numberofbreakdowns", "Warranty&policyrate_Numberofbreakdowns");
//
//			CommonWebActions.waituntil("Warranty&policyrate_inlastmonths");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_inlastmonths", "Warranty&policyrate_inlastmonths");
//
//			CommonWebActions.waituntil("Warranty&policyrate_DataStatus");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_DataStatus", "Warranty&policyrate_DataStatus");
//
//			CommonWebActions.wait(3000);
//
//			CommonWebActions.webClick("QMTeaminfoRecommendation");
//
//			CommonWebActions.scrollup();
//
//			CommonWebActions.scrollup1();
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsMarketHeader");
//			CommonWebActions.webClick("RelationstoqualitysystemsMarketHeader");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsDeleteHeader");
//			CommonWebActions.webClick("RelationstoqualitysystemsDeleteHeader");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsAddbutton");
//			CommonWebActions.webClick("RelationstoqualitysystemsAddbutton");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsMarket");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsMarket", "RelationstoqualitysystemsMarket");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsQualitysystem");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsQualitysystem", "RelationstoqualitysystemsQualitysystem");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsFailureno");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsFailureno", "RelationstoqualitysystemsFailureno");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsFavIrano");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsFavIrano", "RelationstoqualitysystemsFavIrano");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsPriority");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsPriority", "RelationstoqualitysystemsPriority");
//
//			CommonWebActions.waituntil("RelationstoqualitysystemsDate");
//			// CommonWebActions.webSetFromXls("RelationstoqualitysystemsDate", "RelationstoqualitysystemsDate");
//
//			CommonWebActions.waituntil("QMTeaminfoRecommendation");
//
//			// CommonWebActions.webSetFromXls("QMTeaminfoRecommendation", "QMTeaminfoRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillTeamInfoQM", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTeamInfoQM");
//			executionTimes.put("FillTeamInfoQM", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FinishTeamInfoQM() {
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.webClick("QMSubmitteaminfo");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishTeamInfoQM", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishTeamInfoQM");
//			executionTimes.put("FinishTeamInfoQM", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillQMStmt() {
//		try {
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("Warranty&policyrateHeader");
//			CommonWebActions.webClick("Warranty&policyrateHeader");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Productionsvolume");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Productionsvolume", "Warranty&policyrate_Productionsvolume");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Affectedvolumesbychange");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Affectedvolumesbychange", "Warranty&policyrate_Affectedvolumesbychange");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Updateallvaluesbutton");
//			CommonWebActions.webClick("Warranty&policyrate_Updateallvaluesbutton");
//
//			CommonWebActions.scrollup1();
//
//			CommonWebActions.waituntil("Warranty&policyrate_Latestfailurerate_QMStmt");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Latestfailurerate_QMStmt", "Warranty_policyrate_Latestfailurerate_QMStmt");
//
//			CommonWebActions.waituntil("Warranty&policyrate_Numberofbreakdowns_QMStmt");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_Numberofbreakdowns_QMStmt", "Warranty_policyrate_Numberofbreakdowns_QMStmt");
//
//			CommonWebActions.waituntil("Warranty&policyrate_inlastmonths_QMStmt");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_inlastmonths_QMStmt", "Warranty_policyrate_inlastmonths_QMStmt");
//
//			CommonWebActions.waituntil("Warranty&policyrate_DataStatus_QMStmt");
//			// CommonWebActions.webSetFromXls("Warranty&policyrate_DataStatus_QMStmt", "Warranty_policyrate_DataStatus_QMStmt");
//
//			CommonWebActions.waituntil("QMCopyCostsbutton");
//
//		//	CommonWebActions.ICMclick("QMCopyCostsbutton");
//
//			// CommonWebActions.webSetFromXls("QMStmtRecommendation", "QMStmtRecommendation");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FillQMStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillQMStmt");
//			executionTimes.put("FillQMStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void FinishQMStmt() {
//
//		try {
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("QMSubmitStatementbutton");
//
//		//	CommonWebActions.ICMclick("QMSubmitStatementbutton");
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("FinishQMStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FinishQMStmt");
//			executionTimes.put("FinishQMStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void RecommendAndFinishEvaluate() {
//
//		try {
//
//			CommonWebActions.waituntil("processPortalWorkLink");
//			CommonWebActions.webClick("processPortalWorkLink");
//			CommonWebActions.waituntil("EvaluationTask1");
//		//	CommonWebActions.ICMclick("EvaluationTask1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("EvaluationtaskiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("EvaluatetaskShellNumber");
//			System.out.println("Shell Number is displayed");
//
//			CommonWebActions.wait(1000);
//			
//			CommonWebActions.scrollDown(600);
//
//			CommonWebActions.waituntil("Refreshbutton");
//
//			CommonWebActions.webClick("Refreshbutton");
//
//		//	CommonWebActions.ICMclick("Refreshbutton");
//
//			startTime = System.currentTimeMillis();
//			// CommonWebActions.webSetFromXls("evaluateRecommendation", "evaluateRecommendation");
//
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//			CommonWebActions.webClick("evalSubmitbutton");
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("workBenchHeading");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("RecommendAndFinishEvaluate", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("RecommendAndFinishEvaluate");
//			executionTimes.put("RecommendAndFinishEvaluate", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void findPreparePackageDecisionstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String PrepareBCstmt1 = "xpath:=//a[starts-with(text(),'3. Prepare Package Decision for \"" + packageNumber + "\"') and contains(text(),\""
//					+ CRtitle + "\")][@title='Click to work on the task']";
//
//			String PrepareBCstmt2 = PrepareBCstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + PrepareBCstmt2);
//			ORUtil.setValue("PrepareBCstmt1", PrepareBCstmt2);
//			CommonWebActions.waituntil("PrepareBCstmt1");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findPreparePackageDecisionstmt");
//
//		}
//
//	}
//
//	public static void OpenPreparePackageDecisionstmt() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("PrepareBCstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("PrepareBCiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("PrepareShellnumber");
//			System.out.println("waited for Shell Number");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenPreparePackageDecisionstmt");
//
//		}
//	}
//
//	public static void FillPreparePackageDecisionstmt() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			//CommonWebActions.waituntil("MilestoneHeader");
//
//			//CommonWebActions.webClick("MilestoneHeader");
//
//			CommonWebActions.waituntil("PrepareAddMilestoneButton");
//
//			CommonWebActions.webClick("PrepareAddMilestoneButton");
//
//			Thread.sleep(3000);
//
//			CommonWebActions.waituntil("PrepareMilestonetype");
//
//			// CommonWebActions.webSetFromXls("PrepareMilestonetype", "PrepareMilestonetype");
//
//			CommonWebActions.waituntil("PrepareMilestoneadjusteddate");
//			// CommonWebActions.webSetFromXls("PrepareMilestoneadjusteddate", "Startofproddate");
//
//			// CommonWebActions.webSetFromXls("PrepareMilestoneadjustedduration", "StartofprodAdujDuration");
//
//			// CommonWebActions.webSetFromXls("Decisionboard", "Decisionboard");
//
//			// CommonWebActions.webSetFromXls("Decisionmaker_Responsibleperson", "Addtionalpacpersonid", true);
//			//CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("DecisionmakerResponsibledropdown");
//			CommonWebActions.webClick("DecisionmakerResponsibledropdown");
//
//			// CommonWebActions.webSetFromXls("ControlExpert_Responsibleperson", "Addtionalpacpersonid", true);
//			//CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ControlExpertResponsibledropdown");
//			CommonWebActions.webClick("ControlExpertResponsibledropdown");
//
//			/*
//			 * CommonWebActions.webClick("DecisionMakerpackagesearch"); //
//			 * CommonWebActions.ICMclick("DecisionMakerpackagesearch");
//			 * CommonWebActions.wait(3000);
//			 * CommonWebActions.waituntil("groupSearch");
//			 * CommonWebActions.webClick("groupSearch");
//			 * CommonWebActions.waituntil("userSearch");
//			 * CommonWebActions.webClick("userSearch");
//			 * CommonWebActions.waituntil("Searchuser");
//			 * CommonWebActions.webClick("Searchuser");
//			 * CommonWebActions.waituntil("AllLink");
//			 * CommonWebActions.webClick("AllLink");
//			 * CommonWebActions.SelectUser("Username2", "attribute",
//			 * "valueToSet1", "valueToSet");
//			 * 
//			 * CommonWebActions.webClick("Submit");
//			 * 
//			 * CommonWebActions.webClick("ControlExpertDecisionsearch");
//			 * //CommonWebActions.ICMclick("ControlExpertDecisionsearch");
//			 * 
//			 * CommonWebActions.wait(3000);
//			 * CommonWebActions.waituntil("groupSearch");
//			 * CommonWebActions.webClick("groupSearch");
//			 * 
//			 * CommonWebActions.waituntil("userSearch");
//			 * CommonWebActions.webClick("userSearch");
//			 * 
//			 * CommonWebActions.waituntil("Searchuser");
//			 * 
//			 * CommonWebActions.webClick("Searchuser");
//			 * 
//			 * CommonWebActions.waituntil("AllLink");
//			 * CommonWebActions.webClick("AllLink");
//			 * 
//			 * CommonWebActions.SelectUser("Username2", "attribute",
//			 * "valueToSet1", "valueToSet");
//			 * 
//			 * CommonWebActions.webClick("Submit");
//			 */
//
//			stopTime = System.currentTimeMillis();
//
//			// CommonWebActions.webSetFromXls("PrepareBC_recomendation", "PrepareBC_recomendation");
//
//			CommonWebActions.webClick("PrepareBC_recomendation_Comment");
//
//			// CommonWebActions.webSetFromXls("PrepareBC_recomendation_Comment", "PrepareBC_recomendation");
//
//			// ReviewBC_Recommendation
//			/*
//			 * CommonWebActions.waituntil("AssignExpertsHeader"); startTime =
//			 * System.currentTimeMillis();
//			 * 
//			 * CommonWebActions.ICMclick("AssignExpertsHeader");
//			 * 
//			 * CommonWebActions.waituntil("PhaseLeadDevsearch");
//			 * CommonWebActions.ICMclick("PhaseLeadDevsearch");
//			 * 
//			 * CommonWebActions.waituntil("groupSearch");
//			 * CommonWebActions.webClick("groupSearch");
//			 * CommonWebActions.waituntil("userSearch");
//			 * CommonWebActions.webClick("userSearch");
//			 * CommonWebActions.waituntil("Searchuser");
//			 * CommonWebActions.webClick("Searchuser");
//			 * CommonWebActions.waituntil("AllLink");
//			 * CommonWebActions.webClick("AllLink");
//			 * CommonWebActions.SelectUser("Username2", "attribute",
//			 * "valueToSet1", "valueToSet");
//			 * CommonWebActions.waituntil("Submit");
//			 * CommonWebActions.webClick("Submit");
//			 * 
//			 * stopTime = System.currentTimeMillis();
//			 * 
//			 * CommonWebActions.waituntil("AssignExpertsHeader");
//			 * 
//			 * startTime = System.currentTimeMillis();
//			 * 
//			 * CommonWebActions.ICMclick("AssignExpertsHeader");
//			 * 
//			 * CommonWebActions.ICMclick("PhaseLeadProdsearch");
//			 * 
//			 * CommonWebActions.waituntil("groupSearch");
//			 * CommonWebActions.webClick("groupSearch");
//			 * CommonWebActions.waituntil("userSearch");
//			 * CommonWebActions.webClick("userSearch");
//			 * 
//			 * CommonWebActions.waituntil("Searchuser");
//			 * CommonWebActions.webClick("Searchuser");
//			 * 
//			 * CommonWebActions.waituntil("AllLink");
//			 * CommonWebActions.webClick("AllLink");
//			 * 
//			 * CommonWebActions.SelectUser("Username2", "attribute",
//			 * "valueToSet1", "valueToSet");
//			 * CommonWebActions.waituntil("Submit");
//			 * CommonWebActions.webClick("Submit");
//			 * 
//			 * stopTime = System.currentTimeMillis();
//			 */
//
//			/*
//			 * CommonWebActions.waituntil("StartofproddateCalanderimg");
//			 * 
//			 * CommonWebActions.webClick("StartofproddateCalanderimg");
//			 * 
//			 * CommonWebActions.waituntil("SelectStartofproddate");
//			 * 
//			 * CommonWebActions.webClick("SelectStartofproddate");
//			 */
//
//			// CommonWebActions.webClick("Startofproddate");
//
//			// CommonWebActions.webClick("Startofproddate");
//
//			/*
//			 * CommonWebActions.waituntil("FundingRequirementoverviewHeader");
//			 * 
//			 * CommonWebActions.webClick("FundingRequirementoverviewHeader");
//			 * 
//			 * CommonWebActions.ICMclick("FundingRequirementoverviewHeader");
//			 * 
//			 * CommonWebActions.wait(3000);
//			 * 
//			 * CommonWebActions.waituntil("DeciDesignEffortValue");
//			 * 
//			 * //////////////////////////////////////
//			 * 
//			 * double DeciDesignEffortValue1 = CommonWebActions
//			 * .getValue("DeciDesignEffortValue");
//			 * System.out.println("DeciDesignEffortValue1:" +
//			 * DeciDesignEffortValue1);
//			 * 
//			 * int DeciDesignEffortValue2 = (int) DeciDesignEffortValue1;
//			 * 
//			 * System.out.println(DeciDesignEffortValue2);
//			 * 
//			 * String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			 * 
//			 * String desInternalEffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desInternalEffort");
//			 * 
//			 * System.out.println(desInternalEffort1);
//			 * 
//			 * double desInternalEffort2 = Double
//			 * .parseDouble(desInternalEffort1);
//			 * 
//			 * int desInternalEffort3 = (int) Math.round(desInternalEffort2);
//			 * 
//			 * System.out.println(desInternalEffort3);
//			 * 
//			 * int cmp3 = Integer.compare(DeciDesignEffortValue2,
//			 * desInternalEffort3);
//			 * 
//			 * System.out.println(cmp3);
//			 * 
//			 * //////////////////////////////////////////
//			 * 
//			 * double DeciDesignCostValue1 = CommonWebActions
//			 * .getValue("DeciDesignCostValue");
//			 * System.out.println("DeciDesignCostValue1:" +
//			 * DeciDesignCostValue1);
//			 * 
//			 * int DeciDesignCostValue2 = (int) DeciDesignCostValue1;
//			 * 
//			 * System.out.println(DeciDesignCostValue2);
//			 * 
//			 * String desInternalCosts1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desInternalCosts");
//			 * 
//			 * System.out.println(desInternalCosts1);
//			 * 
//			 * double desInternalCosts2 = Double
//			 * .parseDouble(desInternalCosts1);
//			 * 
//			 * int desInternalCosts3 = (int) Math.round(desInternalCosts2);
//			 * 
//			 * System.out.println(desInternalCosts3);
//			 * 
//			 * int cmp4 = Integer.compare(DeciDesignCostValue2,
//			 * desInternalCosts3);
//			 * 
//			 * System.out.println(cmp4);
//			 * //////////////////////////////////////////////////////
//			 * 
//			 * double DeciDocumentationeffortvalue1 = CommonWebActions
//			 * .getValue("DeciDocumentationeffortvalue");
//			 * System.out.println("DeciDocumentationeffortvalue1:" +
//			 * DeciDocumentationeffortvalue1);
//			 * 
//			 * int DeciDocumentationeffortvalue2 = (int)
//			 * DeciDocumentationeffortvalue1;
//			 * 
//			 * System.out.println(DeciDocumentationeffortvalue2);
//			 * 
//			 * String desInternalDocumentationeffort1 =
//			 * ExcelUtil.getDataFromExcel( onlyTestCaseName,
//			 * "desInternalDocumentationeffort");
//			 * 
//			 * System.out.println(desInternalDocumentationeffort1);
//			 * 
//			 * double desInternalDocumentationeffort2 = Double
//			 * .parseDouble(desInternalDocumentationeffort1);
//			 * 
//			 * int desInternalDocumentationeffort3 = (int)
//			 * Math.round(desInternalDocumentationeffort2);
//			 * 
//			 * System.out.println(desInternalDocumentationeffort3);
//			 * 
//			 * int cmp5 = Integer.compare(DeciDocumentationeffortvalue2,
//			 * desInternalDocumentationeffort3);
//			 * 
//			 * System.out.println(cmp5);
//			 * 
//			 * 
//			 * //////////////////////////////////////////////////////
//			 * 
//			 * double DeciSimulationeffortvalue1 = CommonWebActions
//			 * .getValue("DeciSimulationeffortvalue");
//			 * System.out.println("DeciSimulationeffortvalue1:" +
//			 * DeciSimulationeffortvalue1);
//			 * 
//			 * int DeciSimulationeffortvalue2 = (int)
//			 * DeciSimulationeffortvalue1;
//			 * 
//			 * System.out.println(DeciSimulationeffortvalue2);
//			 * 
//			 * String desInternalSimulationeffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desInternalSimulationeffort");
//			 * 
//			 * System.out.println(desInternalSimulationeffort1);
//			 * 
//			 * double desInternalSimulationeffort2 = Double
//			 * .parseDouble(desInternalSimulationeffort1);
//			 * 
//			 * int desInternalSimulationeffort3 = (int)
//			 * Math.round(desInternalSimulationeffort2);
//			 * 
//			 * System.out.println(desInternalSimulationeffort3);
//			 * 
//			 * int cmp6 = Integer.compare(DeciSimulationeffortvalue2,
//			 * desInternalSimulationeffort3);
//			 * 
//			 * System.out.println(cmp6);
//			 * 
//			 * ///////////////////////////////////////////////////////
//			 * 
//			 * double DeciMaterialCostvalue1 = CommonWebActions
//			 * .getValue("DeciMaterialCostvalue");
//			 * System.out.println("DeciMaterialCostvalue1:" +
//			 * DeciMaterialCostvalue1);
//			 * 
//			 * int DeciMaterialCostvalue2 = (int) DeciMaterialCostvalue1;
//			 * 
//			 * System.out.println(DeciMaterialCostvalue2);
//			 * 
//			 * String desExternalMaterial1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desExternalMaterial");
//			 * 
//			 * System.out.println(desExternalMaterial1);
//			 * 
//			 * double desExternalMaterial2 = Double
//			 * .parseDouble(desExternalMaterial1);
//			 * 
//			 * int desExternalMaterial3 = (int)
//			 * Math.round(desExternalMaterial2);
//			 * 
//			 * System.out.println(desExternalMaterial3);
//			 * 
//			 * int cmp7 = Integer.compare(DeciMaterialCostvalue2,
//			 * desExternalMaterial3);
//			 * 
//			 * System.out.println(cmp7);
//			 * 
//			 * /////////////////////////////////////////////////////////
//			 * 
//			 * double DeciExternalCostvalue1 = CommonWebActions
//			 * .getValue("DeciExternalCostvalue");
//			 * System.out.println("DeciExternalCostvalue1:" +
//			 * DeciExternalCostvalue1);
//			 * 
//			 * int DeciExternalCostvalue2 = (int) DeciExternalCostvalue1;
//			 * 
//			 * System.out.println(DeciExternalCostvalue2);
//			 * 
//			 * String desExternalCosts1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desExternalCosts");
//			 * 
//			 * System.out.println(desExternalCosts1);
//			 * 
//			 * double desExternalCosts2 = Double
//			 * .parseDouble(desExternalCosts1);
//			 * 
//			 * int desExternalCosts3 = (int) Math.round(desExternalCosts2);
//			 * 
//			 * System.out.println(desExternalCosts3);
//			 * 
//			 * int cmp8 = Integer.compare(DeciExternalCostvalue2,
//			 * desExternalCosts3);
//			 * 
//			 * System.out.println(cmp8);
//			 * 
//			 * ////////////////////////////////////////////////////////
//			 * 
//			 * double DeciExternalEngineeringcostvalue1 = CommonWebActions
//			 * .getValue("DeciExternalEngineeringcostvalue");
//			 * System.out.println("DeciExternalEngineeringcostvalue1:" +
//			 * DeciExternalEngineeringcostvalue1);
//			 * 
//			 * int DeciExternalEngineeringcostvalue2 = (int)
//			 * DeciExternalEngineeringcostvalue1;
//			 * 
//			 * System.out.println(DeciExternalEngineeringcostvalue2);
//			 * 
//			 * String desExternalEngineering1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "desExternalEngineering");
//			 * 
//			 * System.out.println(desExternalEngineering1);
//			 * 
//			 * double desExternalEngineering2 = Double
//			 * .parseDouble(desExternalEngineering1);
//			 * 
//			 * int desExternalEngineering3 = (int)
//			 * Math.round(desExternalEngineering2);
//			 * 
//			 * System.out.println(desExternalEngineering3);
//			 * 
//			 * int cmp9 = Integer.compare(DeciExternalEngineeringcostvalue2,
//			 * desExternalEngineering3);
//			 * 
//			 * System.out.println(cmp9);
//			 * 
//			 * ////////////////////////////////////////////////////////////
//			 * 
//			 * double DeciSDCDirectpayement1 = CommonWebActions
//			 * .getValue("DeciSDCDirectpayement");
//			 * System.out.println("DeciSDCDirectpayement1:" +
//			 * DeciSDCDirectpayement1);
//			 * 
//			 * int DeciSDCDirectpayement2 = (int) DeciSDCDirectpayement1;
//			 * 
//			 * System.out.println(DeciSDCDirectpayement2);
//			 * 
//			 * String DirectPaymentCosts1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "DirectPaymentCosts");
//			 * 
//			 * System.out.println(DirectPaymentCosts1);
//			 * 
//			 * double DirectPaymentCosts2 = Double
//			 * .parseDouble(DirectPaymentCosts1);
//			 * 
//			 * int DirectPaymentCosts3 = (int) Math.round(DirectPaymentCosts2);
//			 * 
//			 * System.out.println(DirectPaymentCosts3);
//			 * 
//			 * int cmp10 = Integer.compare(DeciSDCDirectpayement2,
//			 * DirectPaymentCosts3);
//			 * 
//			 * System.out.println(cmp10);
//			 * 
//			 * ///////////////////////////////////////////////////////////
//			 * 
//			 * double DeciTestingeffort1 = CommonWebActions
//			 * .getValue("DeciTestingeffort");
//			 * System.out.println("DeciTestingeffort1:" + DeciTestingeffort1);
//			 * 
//			 * int DeciTestingeffort2 = (int) DeciTestingeffort1;
//			 * 
//			 * System.out.println(DeciTestingeffort2);
//			 * 
//			 * String testTestEffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "testTestEffort");
//			 * 
//			 * System.out.println(testTestEffort1);
//			 * 
//			 * double testTestEffort2 = Double .parseDouble(testTestEffort1);
//			 * 
//			 * int testTestEffort3 = (int) Math.round(testTestEffort2);
//			 * 
//			 * System.out.println(testTestEffort3);
//			 * 
//			 * int cmp11 = Integer.compare(DeciTestingeffort2, testTestEffort3);
//			 * 
//			 * System.out.println(cmp11);
//			 * 
//			 * 
//			 * /////////////////////////////////////////////////////////
//			 * 
//			 * double DeciTestingBench1 = CommonWebActions
//			 * .getValue("DeciTestingBench");
//			 * System.out.println("DeciTestingBench1:" + DeciTestingBench1);
//			 * 
//			 * int DeciTestingBench2 = (int) DeciTestingBench1;
//			 * 
//			 * System.out.println(DeciTestingBench2);
//			 * 
//			 * String testTestbench1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "testTestbench");
//			 * 
//			 * System.out.println(testTestbench1);
//			 * 
//			 * double testTestbench2 = Double .parseDouble(testTestbench1);
//			 * 
//			 * int testTestbench3 = (int) Math.round(testTestbench2);
//			 * 
//			 * System.out.println(testTestbench3);
//			 * 
//			 * int cmp12 = Integer.compare(DeciTestingBench2, testTestbench3);
//			 * 
//			 * System.out.println(cmp12);
//			 * 
//			 * //////////////////////////////////////////////////////////
//			 * 
//			 * double DeciMechanicseffort1 = CommonWebActions
//			 * .getValue("DeciMechanicseffort");
//			 * System.out.println("DeciMechanicseffort1:" +
//			 * DeciMechanicseffort1);
//			 * 
//			 * int DeciMechanicseffort2 = (int) DeciMechanicseffort1;
//			 * 
//			 * System.out.println(DeciMechanicseffort2);
//			 * 
//			 * String testMechanicseffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "testMechanicseffort");
//			 * 
//			 * System.out.println(testMechanicseffort1);
//			 * 
//			 * double testMechanicseffort2 = Double
//			 * .parseDouble(testMechanicseffort1);
//			 * 
//			 * int testMechanicseffort3 = (int)
//			 * Math.round(testMechanicseffort2);
//			 * 
//			 * System.out.println(testMechanicseffort3);
//			 * 
//			 * int cmp13 = Integer.compare(DeciMechanicseffort2,
//			 * testMechanicseffort3);
//			 * 
//			 * System.out.println(cmp13);
//			 * 
//			 * 
//			 * ////////////////////////////////////////////////////////////
//			 * 
//			 * double DeciTestingparts1 = CommonWebActions
//			 * .getValue("DeciTestingparts");
//			 * System.out.println("DeciTestingparts1:" + DeciTestingparts1);
//			 * 
//			 * int DeciTestingparts2 = (int) DeciTestingparts1;
//			 * 
//			 * System.out.println(DeciTestingparts2);
//			 * 
//			 * String testTestingParts1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "testTestingParts");
//			 * 
//			 * System.out.println(testTestingParts1);
//			 * 
//			 * double testTestingParts2 = Double
//			 * .parseDouble(testTestingParts1);
//			 * 
//			 * int testTestingParts3 = (int) Math.round(testTestingParts2);
//			 * 
//			 * System.out.println(testTestingParts3);
//			 * 
//			 * int cmp14 = Integer.compare(DeciTestingparts2,
//			 * testTestingParts3);
//			 * 
//			 * System.out.println(cmp14);
//			 * 
//			 * //////////////////////////////////////////////////////
//			 * 
//			 * double DeciTestingexternaleffort1 = CommonWebActions
//			 * .getValue("DeciTestingexternaleffort");
//			 * System.out.println("DeciTestingexternaleffort1:" +
//			 * DeciTestingexternaleffort1);
//			 * 
//			 * int DeciTestingexternaleffort2 = (int)
//			 * DeciTestingexternaleffort1;
//			 * 
//			 * System.out.println(DeciTestingparts2);
//			 * 
//			 * String testExternalEffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "testExternalEffort");
//			 * 
//			 * System.out.println(testExternalEffort1);
//			 * 
//			 * double testExternalEffort2 = Double
//			 * .parseDouble(testExternalEffort1);
//			 * 
//			 * int testExternalEffort3 = (int) Math.round(testExternalEffort2);
//			 * 
//			 * System.out.println(testExternalEffort3);
//			 * 
//			 * int cmp15 = Integer.compare(DeciTestingexternaleffort2,
//			 * testExternalEffort3);
//			 * 
//			 * System.out.println(cmp15);
//			 * 
//			 * 
//			 * ///////////////////////////////////////////////////////////
//			 * 
//			 * double DeciHomologationeffort1 = CommonWebActions
//			 * .getValue("DeciHomologationeffort");
//			 * System.out.println("DeciHomologationeffort1:" +
//			 * DeciHomologationeffort1);
//			 * 
//			 * int DeciHomologationeffort2 = (int) DeciHomologationeffort1;
//			 * 
//			 * System.out.println(DeciHomologationeffort2);
//			 * 
//			 * String HomologationInternalEffort1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "HomologationInternalEffort");
//			 * 
//			 * System.out.println(HomologationInternalEffort1);
//			 * 
//			 * double HomologationInternalEffort2 = Double
//			 * .parseDouble(HomologationInternalEffort1);
//			 * 
//			 * int HomologationInternalEffort3 = (int)
//			 * Math.round(HomologationInternalEffort2);
//			 * 
//			 * System.out.println(HomologationInternalEffort3);
//			 * 
//			 * int cmp16 = Integer.compare(DeciHomologationeffort2,
//			 * HomologationInternalEffort3);
//			 * 
//			 * System.out.println(cmp16);
//			 * 
//			 * 
//			 * ////////////////////////////////////////////////////
//			 * 
//			 * double DeciHomologationmaterial1 = CommonWebActions
//			 * .getValue("DeciHomologationmaterial");
//			 * System.out.println("DeciHomologationmaterial1:" +
//			 * DeciHomologationmaterial1);
//			 * 
//			 * int DeciHomologationmaterial2 = (int) DeciHomologationmaterial1;
//			 * 
//			 * System.out.println(DeciHomologationmaterial2);
//			 * 
//			 * String HomExternalMaterialAmount1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "HomExternalMaterialAmount");
//			 * 
//			 * System.out.println(HomExternalMaterialAmount1);
//			 * 
//			 * double HomExternalMaterialAmount2 = Double
//			 * .parseDouble(HomExternalMaterialAmount1);
//			 * 
//			 * int HomExternalMaterialAmount3 = (int)
//			 * Math.round(HomExternalMaterialAmount2);
//			 * 
//			 * System.out.println(HomExternalMaterialAmount3);
//			 * 
//			 * int cmp17 = Integer.compare(DeciHomologationmaterial2,
//			 * HomExternalMaterialAmount3);
//			 * 
//			 * System.out.println(cmp17);
//			 * 
//			 * 
//			 * ///////////////////////////////////////////////////////////
//			 * 
//			 * 
//			 * double DeciExternalfees1 = CommonWebActions
//			 * .getValue("DeciExternalfees");
//			 * System.out.println("DeciExternalfees1:" + DeciExternalfees1);
//			 * 
//			 * int DeciExternalfees2 = (int) DeciExternalfees1;
//			 * 
//			 * System.out.println(DeciExternalfees2);
//			 * 
//			 * String HomExternalFeesAmount1 = ExcelUtil.getDataFromExcel(
//			 * onlyTestCaseName, "HomExternalFeesAmount");
//			 * 
//			 * System.out.println(HomExternalFeesAmount1);
//			 * 
//			 * double HomExternalFeesAmount2 = Double
//			 * .parseDouble(HomExternalFeesAmount1);
//			 * 
//			 * int HomExternalFeesAmount3 = (int)
//			 * Math.round(HomExternalFeesAmount2);
//			 * 
//			 * System.out.println(HomExternalFeesAmount3);
//			 * 
//			 * int cmp18 = Integer.compare(DeciExternalfees2,
//			 * HomExternalFeesAmount3);
//			 * 
//			 * System.out.println(cmp18);
//			 * 
//			 * 
//			 * 
//			 * /////////////////////////////////////////////////////////
//			 * 
//			 * double RDtotalvalue=desInternalEffort2+desInternalCosts2+
//			 * desInternalDocumentationeffort2
//			 * +desInternalSimulationeffort2+desExternalMaterial2
//			 * +desExternalCosts2
//			 * +desExternalEngineering2+DirectPaymentCosts2+testTestEffort2
//			 * +testTestbench2
//			 * +testMechanicseffort2+testTestingParts2+testExternalEffort2
//			 * +HomologationInternalEffort2
//			 * +HomExternalMaterialAmount2+HomExternalFeesAmount2;
//			 * 
//			 * System.out.println(RDtotalvalue);
//			 * 
//			 * int RDtotalvalue1 = (int) Math.round(RDtotalvalue);
//			 * System.out.println(RDtotalvalue1); double RDtotal1 =
//			 * CommonWebActions .getValue("R&Dtotal");
//			 * System.out.println("RDtotal1:" + RDtotal1);
//			 * 
//			 * int RDtotal2 = (int) RDtotal1;
//			 * 
//			 * System.out.println(RDtotal2);
//			 * 
//			 * int cmp19 = Integer.compare(RDtotalvalue1, RDtotal2);
//			 * 
//			 * System.out.println(cmp19);
//			 */
//			// //////////////////////////////////////////////////////////
//
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//			CommonWebActions.waituntil("SubmitDecision");
//
//			CommonWebActions.webClick("SubmitDecision");
//
//			executionTimes.put("FillPreparePackageDecisionstmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillPreparePackageDecisionstmt");
//			executionTimes.put("FillPreparePackageDecisionstmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findReviewPackageDecisionstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String ReviewBCstmt1 = "xpath:=//a[starts-with(text(),'3. Review for Package Decision \"" + packageNumber + "\"') and contains(text(),\"" + CRtitle
//					+ "\")][@title='Click to work on the task']";
//
//			String ReviewBCstmt2 = ReviewBCstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + ReviewBCstmt2);
//			ORUtil.setValue("ReviewBCstmt1", ReviewBCstmt2);
//			CommonWebActions.waituntil("ReviewBCstmt1");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findReviewPackageDecisionstmt");
//
//		}
//
//	}
//
//	public static void OpenReviewPackageDecisionstmt() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("ReviewBCstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("ReviewBCiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("ReviewBCShellnumber");
//			System.out.println("waited for ReviewBCShellnumber");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenReviewPackageDecisionstmt");
//
//		}
//	}
//
//	public static void FillReviewPackageDecisionstmt() {
//		try {
//
//			CommonWebActions.waituntil("ReviewBC_Recommendation");
//
//			CommonWebActions.webClick("ReviewBC_Recommendation");
//
//			// CommonWebActions.webSetFromXls("ReviewBC_Recommendation", "PrepareBC_recomendation");
//
//			CommonWebActions.waituntil("BusinesscaseReviewComment");
//
//			CommonWebActions.webClick("BusinesscaseReviewComment");
//
//			// CommonWebActions.webSetFromXls("BusinesscaseReviewComment", "BusinesscaseReviewComment");
//
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//			CommonWebActions.waituntil("SubmitDecision");
//
//		//	CommonWebActions.ICMclick("SubmitDecision");
//
//			executionTimes.put("FillReviewBCStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillReviewBCStmt");
//			executionTimes.put("FillReviewBCStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findDecidePackagestmt() throws ConfigurationException, IOException {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String DecidePackagestmt1 = "xpath:=//a[starts-with(text(),'3. Decide Package \"" + packageNumber + "\"') and contains(text(),\"" + CRtitle
//					+ "\")][@title='Click to work on the task']";
//
//			String DecidePackagestmt2 = DecidePackagestmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + DecidePackagestmt2);
//			ORUtil.setValue("DecidePackagestmt1", DecidePackagestmt2);
//			CommonWebActions.waituntil("DecidePackagestmt1");
//
//			executionTimes.put("findDecidePackagestmt", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findDecidePackagestmt");
//
//		}
//
//	}
//
//	public static void OpenDecidePackagestmt() {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//		//	CommonWebActions.ICMclick("DecidePackagestmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("DecidePackageiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("DecidePackageShellNumber");
//			System.out.println("waited for DecidePackageShellNumber");
//			executionTimes.put("OpenDecidePackagestmt", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDecidePackagestmt");
//
//		}
//	}
//
//	public static void FillDecidePackagestmt() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("Session");
//			// CommonWebActions.webSetFromXls("Session", "Session");
//			// CommonWebActions.webSetFromXls("Decisionfield", "Decisionfield");
//			// CommonWebActions.webSetFromXls("Decisionreason", "Decisionreason");
//			// CommonWebActions.webSetFromXls("Decisiondate", "Decisiondate");
//
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//			CommonWebActions.waituntil("SubmitDecision");
//
//			CommonWebActions.webClick("SubmitDecision");
//
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("WorkTab");
//
//			executionTimes.put("FillDecidePackagestmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDecidePackagestmt");
//			executionTimes.put("FillDecidePackagestmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findImplementationstmt() throws ConfigurationException, IOException {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String Implementationstmt1 = "xpath:=//a[starts-with(text(),'Work on Implementation for \"" + packageNumber + "\"') and contains(text(), \""
//					+ CRtitle + "\")][@title='Click to work on the task']";
//
//			String Implementationstmt2 = Implementationstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Implementationstmt2);
//			ORUtil.setValue("Implementationstmt1", Implementationstmt2);
//			CommonWebActions.waituntil("Implementationstmt1");
//
//			executionTimes.put("findImplementationstmt", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findImplementationstmt");
//
//		}
//
//	}
//
//	public static void OpenImplementationstmt() {
//
//		try {
//
//			startTime = System.currentTimeMillis();
//
//		//	CommonWebActions.ICMclick("Implementationstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("Implementationstmtiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("ImplementationstmtShellNumber");
//			System.out.println("Shell Number is displayed");
//
//			executionTimes.put("OpenImplementationstmt", stopTime - startTime);
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenImplementationstmt");
//
//		}
//	}
//
//	public static void distributeDesignImplsstmt() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("ImplFeebacktableheader");
//			CommonWebActions.webClick("ImplFeebacktableheader");
//
//			CommonWebActions.waituntil("ImplFeedbacktaskPersoninchargeChkbox");
//			CommonWebActions.webClick("ImplFeedbacktaskPersoninchargeChkbox");
//
//		//	CommonWebActions.ICMclick("ImplFeedbacktaskPersoninchargeChkbox");
//
//			// CommonWebActions.webSetFromXls("ImplFeedbacktaskPersonincharge", "Addtionalpacpersonid");
//			CommonWebActions.wait(2000);
//			CommonWebActions.webClick("Designstmtpersonrersponsibledropdown");
//
//			CommonWebActions.waituntil("Implfeebacktaskdistribute");
//			CommonWebActions.webClick("Implfeebacktaskdistribute");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeDesignImplsstmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeDesignImplsstmt");
//			executionTimes.put("distributeDesignImplsstmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findDesignImplsstmt() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String DesignImplsstmt1 = "xpath:=//a[starts-with(text(),'Fill \"" + "Design" + "\" Implementation Statement for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String DesignImplsstmt2 = DesignImplsstmt1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + DesignImplsstmt2);
//			ORUtil.setValue("DesignImplsstmt1", DesignImplsstmt2);
//			CommonWebActions.waituntil("DesignImplsstmt1");
//
//			ReportUtil.reporterEvent("findDesignImplsstmt1", "findDesignImplsstmt1  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("findDesignImplsstmt1");
//			executionTimes.put("findDesignImplsstmt1", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenDesignImplsstmt() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("DesignImplsstmt1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("DesignImplsstmtiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("DesignImplsstmtShellnumber");
//			System.out.println("waited for DesignImplsstmtShellnumber");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignImplsstmt");
//
//		}
//	}
//
//	public static void distributeDesignImplsstmtfeedback() {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil("ImplFeebackneededHeader");
//			CommonWebActions.webClick("ImplFeebackneededHeader");
//
//			CommonWebActions.waituntil("ImplFeedbacktaskchkbox");
//			CommonWebActions.webClick("ImplFeedbacktaskchkbox");
//
//			CommonWebActions.waituntil("Implfeedbackteamdistribute");
//			CommonWebActions.webClick("Implfeedbackteamdistribute");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("distributeDesignImplsstmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("distributeDesignImplsstmt");
//			executionTimes.put("distributeDesignImplsstmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void findDesignImplTeamfeedback() {
//		try {
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			String DesignImplTeamfeedback1 = "xpath:=//a[starts-with(text(),'019TP-EAP1_DS\": Fill Implementation Feedback for \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			String DesignImplTeamfeedback2 = DesignImplTeamfeedback1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + DesignImplTeamfeedback2);
//			ORUtil.setValue("DesignImplTeamfeedback1", DesignImplTeamfeedback2);
//			CommonWebActions.waituntil("DesignImplTeamfeedback1");
//
//			ReportUtil.reporterEvent("DesignImplTeamfeedback1", "DesignImplTeamfeedback1  found successfully" + CommonWebActions.captureScreenshotAsBase64());
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("DesignImplTeamfeedback1");
//			executionTimes.put("DesignImplTeamfeedback1", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void OpenDesignImplTeamfeedback() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("DesignImplTeamfeedback1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("DesignImplTeamfeedbackiframe");
//			System.out.println("switched to frame");
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil("ExpandallSections");
//			CommonWebActions.webClick("ExpandallSections");
//		//	CommonWebActions.ICMclick("ExpandallSections");
//			CommonWebActions.waituntil("DesignImplTeamfeedbackShellnumber");
//			System.out.println("waited for DesignImplTeamfeedbackShellnumber");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenDesignImplsstmt");
//
//		}
//	}
//
//	public static void FillDesignImplTeamfeedback() {
//		try {
//
//			CommonWebActions.waituntil("ImplfeedbackCompleteimpl");
//
//			CommonWebActions.webClick("ImplfeedbackCompleteimpl");
//
//			CommonWebActions.waituntil("Implfeedbackisnotaffected");
//
//			CommonWebActions.webClick("Implfeedbackisnotaffected");
//
//			CommonWebActions.waituntil("Implfeedbackcomment");
//			// CommonWebActions.webSetFromXls("Implfeedbackcomment", "BusinesscaseReviewComment");
//
//			CommonWebActions.waituntil("ImplfeebackSubmitbutton");
//
//		//	CommonWebActions.ICMclick("ImplfeebackSubmitbutton");
//
//			executionTimes.put("FillDesignImplTeamfeedback", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignImplTeamfeedback");
//			executionTimes.put("FillDesignImplTeamfeedback", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void FillDesignImplsstmt() {
//		try {
//
//			CommonWebActions.waituntil("Impldesignstmtisnotaffected");
//
//			CommonWebActions.webClick("Impldesignstmtisnotaffected");
//
//			CommonWebActions.waituntil("ImpldesignstmtComment");
//
//			// CommonWebActions.webSetFromXls("ImpldesignstmtComment", "BusinesscaseReviewComment");
//
//			CommonWebActions.waituntil("ImplDesignstmtSubmitbutton");
//
//		//	CommonWebActions.ICMclick("ImplDesignstmtSubmitbutton");
//
//			executionTimes.put("FillDesignImplsstmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillDesignImplsstmt");
//			executionTimes.put("FillDesignImplsstmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void SubmitImplementationStmt() {
//		try {
//
//			startTime = System.currentTimeMillis();
//			CommonWebActions.waituntil("Implementation_SOP_Milestone_Actualdate");
//
//			// CommonWebActions.webSetFromXls("Implementation_SOP_Milestone_Actualdate", "Startofproddate");
//
//			CommonWebActions.waituntil("IcmVersionFooter");
//			// CommonWebActions.gettext("IcmVersionFooter", "IcmVersion");
//
//			CommonWebActions.waituntil("SubmitImplemtation");
//			CommonWebActions.webClick("SubmitImplemtation");
//			
//			CommonWebActions.waituntil("Implementation_yesContinueButton");
//			CommonWebActions.webClick("Implementation_yesContinueButton");			
//
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("Organizetab");
//
//			executionTimes.put("SubmitImplementationStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("SubmitImplementationStmt");
//			executionTimes.put("SubmitImplementationStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void Reporting() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(30000);
//
//			CommonWindowsActions.winClick("SearchPackageTab");
//			CommonWebActions.wait(2000);
//			CommonWebActions.scrollDown();
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("Downloaddatapool");
//			CommonWebActions.wait(5000);
//			CommonWindowsActions.winClick("DownloadNow");
//			CommonWebActions.wait(20000);
//			CommonWindowsActions.winClick("Savefile");
//			CommonWebActions.wait(2000);
//			CommonWindowsActions.winClick("Okbutton");
//
//			CommonWebActions.wait(5000);
//			String downloadPath = "C:\\Users\\GSATISH\\Downloads";
//			File dir = new File(downloadPath);
//			File[] dir_contents = dir.listFiles();
//
//			for (int i = 0; i < dir_contents.length; i++) {
//
//				System.out.println(dir_contents[i].getName());
//				String filename = dir_contents[i].getName();
//				String filename1 = filename.substring(0, 8);
//				System.out.println("filename1" + filename1);
//
//				if (filename1.equals("datapool")) {
//					String filename2 = dir_contents[i].getName();
//					System.out.println(filename2);
//					System.out.println(i);
//					System.out.println(dir_contents[i].length());
//					if (dir_contents[i].length() > 100) {
//
//						System.out.println("FOUND and its size more than 100 bytes");
//
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is more than 100 bytes");
//					} else {
//						ReportUtil.reporterEvent("info", filename2 + " FOUND and its size [" + dir_contents[i].length() + "] is less than 100 bytes ");
//					}
//				} else {
//					System.out.println("File not found");
//					ReportUtil.reporterEvent("info", "File not found ");
//				}
//			}
//
//			executionTimes.put("FillTestingStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTestingStmt");
//			executionTimes.put("FillTestingStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageInitiation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.webClick("Mypackagesearchbutton");
//
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Initiation");
//
//			executionTimes.put("MypackageInitiation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageInitiation");
//			executionTimes.put("MypackageInitiation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageEvaluation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.webClick("Mypackagesearchbutton");
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("MypackagePhase");
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Evaluation");
//
//			executionTimes.put("MypackageEvaluation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageInitiation");
//			executionTimes.put("MypackageInitiation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageDecision() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.webClick("Mypackagesearchbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("MypackagePhase");
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Decision");
//
//			CommonWebActions.waituntil("Mypackage_Checkbox");
//
//			CommonWebActions.webClick("Mypackage_Checkbox");
//
//			CommonWebActions.waituntil("Mypackage_Milestoneplanbutton");
//
//			CommonWebActions.webClick("Mypackage_Milestoneplanbutton");
//
//			executionTimes.put("MypackageEvaluation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageInitiation");
//			executionTimes.put("MypackageInitiation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageReview() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			String winHandleBefore = CommonWebActions.getCurrentWindowHandle();
//
//			System.out.println(winHandleBefore);
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//			CommonWebActions.waituntil("Mypackage_Clearbutton");
//			CommonWebActions.webClick("Mypackage_Clearbutton");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.webClick("Mypackagesearchbutton");
//
//			CommonWebActions.wait(5000);
//			/*
//			 * CommonWebActions.waituntil("Mypackage_Shellonepager");
//			 * CommonWebActions.webClick("Mypackage_Shellonepager");
//			 */
//
//			CommonWebActions.waituntil("MypackagePhase");
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Decision");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.waituntil("Mypackage_Checkbox");
//
//			CommonWebActions.webClick("Mypackage_Checkbox");
//
//			CommonWebActions.waituntil("Mypackage_Milestoneplanbutton");
//
//			CommonWebActions.webClick("Mypackage_Milestoneplanbutton");
//
//			CommonWebActions.wait(25000);
//
//			CommonWebActions.switchToDefaultContent();
//
//			Set<String> WindowHandles = CommonWebActions.getAllWindowHandles();
//
//			WindowHandles.remove(winHandleBefore);
//			System.out.println(WindowHandles);
//
//			for (String winHandle : WindowHandles) {
//
//				System.out.println(winHandle);
//				CommonWebActions.switchToWindow(winHandle);
//				CommonWebActions.switchToDefaultContent();
//
//				CommonWebActions.wait(15000);
//
//				String Designstartdate = // CommonWebActions.gettext1("Mypackage_Designstartdate");
//				System.out.println(Designstartdate);
//				String DesignReleaseDate = // CommonWebActions.gettext1("Mypackage_DesignReleaseDate");
//				System.out.println(DesignReleaseDate);
//				String SystemApproveDate = // CommonWebActions.gettext1("Mypackage_SystemApproveDate");
//				System.out.println(SystemApproveDate);
//				String TypeTestingfinished = // CommonWebActions.gettext1("Mypackage_TypeTestingfinished");
//				System.out.println(TypeTestingfinished);
//				String SalesStartdate = // CommonWebActions.gettext1("Mypackage_SalesStartdate");
//				System.out.println(SalesStartdate);
//				String SOPdate = // CommonWebActions.gettext1("Mypackage_Milestoneplan_SOPdate");
//				System.out.println(SOPdate);
//
//				System.out.println(onlyTestCaseName);
//				String date = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Startofproddate");
//				System.out.println(date);
//
//				SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
//				SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//				String reformattedStr = myFormat.format(fromUser.parse(date));
//				System.out.println(reformattedStr);
//
//				if (SOPdate.equals(reformattedStr)) {
//					{
//						System.out.println("Output is correct");
//						ReportUtil.reporterEvent("pass", " Actual text [ " + SOPdate + " ] same as expected text [ " + reformattedStr + " ]"
//								+ CommonWebActions.captureScreenshotAsBase64());
//					}
//				} else {
//					System.out.println("Output is wrong");
//					ReportUtil.reporterEvent("fail", " Actual text [ " + SOPdate + " ] not same as expected text [ " + reformattedStr + " ]"
//							+ CommonWebActions.captureScreenshotAsBase64());
//				}
//			}
//
//			String Documentationfinisheddate = // CommonWebActions.gettext1("Mypackage_Documentationfinisheddate");
//			System.out.println(Documentationfinisheddate);
//
//			CommonWebActions.closeBrowser();
//
//			CommonWebActions.wait(3000);
//
//			CommonWebActions.switchToWindow(winHandleBefore);
//
//			System.out.println("winHandleBefore");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.wait(15000);
//
//			CommonWebActions.webClick("Mypackage_Shellonepager");
//
//			CommonWebActions.switchToDefaultContent();
//
//			Set<String> WindowHandles1 = CommonWebActions.getAllWindowHandles();
//
//			WindowHandles1.remove(winHandleBefore);
//			System.out.println(WindowHandles1);
//
//			for (String winHandle1 : WindowHandles1) {
//
//				System.out.println(winHandle1);
//				CommonWebActions.switchToWindow(winHandle1);
//
//				CommonWebActions.switchToDefaultContent();
//
//				//CommonWebActions.switchToiFrame1("Mypackage_shellonepager_iframe");
//
//				CommonWebActions.wait(15000);
//
//				String Mypackage_shellonepager_SOPdate = // CommonWebActions.gettext1("Mypackage_shellonepager_SOPdate");
//				System.out.println(Mypackage_shellonepager_SOPdate);
//
//			}
//
//			executionTimes.put("MypackageEvaluation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageInitiation");
//			executionTimes.put("MypackageInitiation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageImplementation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.webClick("Mypackagesearchbutton");
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("MypackagePhase");
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Implementation");
//
//			executionTimes.put("MypackageImplementation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageImplementation");
//			executionTimes.put("MypackageImplementation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MypackageClosed() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("Mypackagereportlink");
//			CommonWebActions.webClick("Mypackagereportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("Dynamicframe");
//			System.out.println("Dynamicframe");
//
//			CommonWebActions.waituntil("PackageNumber_Field");
//			CommonWebActions.webClick("PackageNumber_Field");
//
//			// CommonWebActions.webSetFromXls("PackageNumber_Field", "packageNumber");
//
//			CommonWebActions.webClick("Mypackagesearchbutton");
//
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("MypackagePhase");
//			// CommonWebActions.gettext("MypackagePhase", "MypackagePhase_Closed");
//
//			executionTimes.put("MypackageClosed", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MypackageClosed");
//			executionTimes.put("MypackageClosed", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MyTaskInitiation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("MyTaskreportlink");
//			CommonWebActions.webClick("MyTaskreportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("DynamicframeMytask");
//			System.out.println("DynamicframeMytask");
//
//			CommonWebActions.waituntil("PackageNumber_FieldMytask");
//			CommonWebActions.webClick("PackageNumber_FieldMytask");
//			// CommonWebActions.webSetFromXls("PackageNumber_FieldMytask", "packageNumber");
//
//			CommonWebActions.webClick("Mytasksearchbutton");
//			CommonWebActions.webClick("Mytasksearchbutton");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.waituntil("Mytaskpackagenumber");
//			// CommonWebActions.gettext("Mytaskpackagenumber", "packageNumber");
//
//			String Initialpackagetitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Initialpackagetitle");
//
//			System.out.println(Initialpackagetitle);
//
//			String PackageNum = ExcelUtil.getDataFromExcel(onlyTestCaseName, "packageNumber");
//
//			System.out.println(PackageNum);
//
//			String Chepackagettitle = "1. Check \"" + PackageNum + "\" \"" + Initialpackagetitle + "\"";
//
//			System.out.println(Chepackagettitle);
//
//			CommonWebActions.wait(15000);
//
//			CommonWebActions.waituntil("Mytasktitlelink");
//			// CommonWebActions.gettext2("Mytasktitlelink", Chepackagettitle);
//
//			executionTimes.put("MyTaskInitiation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MyTaskInitiation");
//			executionTimes.put("MyTaskInitiation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MyTaskEvaluation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("MyTaskreportlink");
//			CommonWebActions.webClick("MyTaskreportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("DynamicframeMytask");
//			System.out.println("DynamicframeMytask");
//
//			CommonWebActions.waituntil("PackageNumber_FieldMytask");
//			CommonWebActions.webClick("PackageNumber_FieldMytask");
//			// CommonWebActions.webSetFromXls("PackageNumber_FieldMytask", "packageNumber");
//
//			CommonWebActions.webClick("Mytasksearchbutton");
//			CommonWebActions.webClick("Mytasksearchbutton");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.waituntil("Mytaskpackagenumber");
//			// CommonWebActions.gettext("Mytaskpackagenumber", "packageNumber");
//
//			String Initialpackagetitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Initialpackagetitle");
//
//			System.out.println(Initialpackagetitle);
//
//			String PackageNum = ExcelUtil.getDataFromExcel(onlyTestCaseName, "packageNumber");
//
//			System.out.println(PackageNum);
//
//			String Evalpackagettitle = "2. Evaluate \"" + PackageNum + "\" \"" + Initialpackagetitle + "\"";
//
//			System.out.println(Evalpackagettitle);
//
//			CommonWebActions.wait(15000);
//
//			CommonWebActions.waituntil("Mytasktitlelink");
//			// CommonWebActions.gettext2("Mytasktitlelink", Evalpackagettitle);
//
//			executionTimes.put("MyTaskEvaluation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MyTaskEvaluation");
//			executionTimes.put("MyTaskEvaluation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MyTaskDecision() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("MyTaskreportlink");
//			CommonWebActions.webClick("MyTaskreportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("DynamicframeMytask");
//			System.out.println("DynamicframeMytask");
//
//			CommonWebActions.waituntil("PackageNumber_FieldMytask");
//			CommonWebActions.webClick("PackageNumber_FieldMytask");
//			// CommonWebActions.webSetFromXls("PackageNumber_FieldMytask", "packageNumber");
//
//			CommonWebActions.webClick("Mytasksearchbutton");
//			CommonWebActions.webClick("Mytasksearchbutton");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.waituntil("Mytaskpackagenumber");
//			// CommonWebActions.gettext("Mytaskpackagenumber", "packageNumber");
//
//			String Initialpackagetitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Initialpackagetitle");
//
//			System.out.println(Initialpackagetitle);
//
//			String PackageNum = ExcelUtil.getDataFromExcel(onlyTestCaseName, "packageNumber");
//
//			System.out.println(PackageNum);
//
//			String Decidepackagettitle = "3. Prepare Package Decision for \"" + PackageNum + "\" \"" + Initialpackagetitle + "\"";
//
//			System.out.println(Decidepackagettitle);
//
//			CommonWebActions.wait(15000);
//
//			CommonWebActions.waituntil("Mytasktitlelink");
//			// CommonWebActions.gettext2("Mytasktitlelink", Decidepackagettitle);
//
//			executionTimes.put("MyTaskDecision", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MyTaskDecision");
//			executionTimes.put("MyTaskDecision", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void MyTaskImplementation() {
//		try {
//
//			CommonWebActions.waituntil("Organizetab");
//
//			CommonWebActions.webClick("Organizetab");
//
//			CommonWebActions.waituntil("MyTaskreportlink");
//			CommonWebActions.webClick("MyTaskreportlink");
//
//			CommonWebActions.wait(20000);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//			ExcelUtil.setDatatoExcel(onlyTestCaseName, "packageNumber", packageNumber);
//			System.out.println("Package number is set to excel");
//
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switchToDefaultContent");
//
//			//CommonWebActions.switchToiFrame1("MypackageFrame");
//			System.out.println("Scoreboard frame");
//			//CommonWebActions.switchToiFrame1("DynamicframeMytask");
//			System.out.println("DynamicframeMytask");
//
//			CommonWebActions.waituntil("PackageNumber_FieldMytask");
//			CommonWebActions.webClick("PackageNumber_FieldMytask");
//			// CommonWebActions.webSetFromXls("PackageNumber_FieldMytask", "packageNumber");
//
//			CommonWebActions.webClick("Mytasksearchbutton");
//			CommonWebActions.webClick("Mytasksearchbutton");
//
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.waituntil("Mytaskpackagenumber");
//			// CommonWebActions.gettext("Mytaskpackagenumber", "packageNumber");
//
//			String Initialpackagetitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "Initialpackagetitle");
//
//			System.out.println(Initialpackagetitle);
//
//			String PackageNum = ExcelUtil.getDataFromExcel(onlyTestCaseName, "packageNumber");
//
//			System.out.println(PackageNum);
//
//			String Implpackagettitle = "Work on Implementation for \"" + PackageNum + "\" \"" + Initialpackagetitle + "\"";
//
//			System.out.println(Implpackagettitle);
//
//			CommonWebActions.wait(15000);
//
//			CommonWebActions.waituntil("Mytasktitlelink");
//			// CommonWebActions.gettext2("Mytasktitlelink", Implpackagettitle);
//
//			executionTimes.put("MyTaskImplementation", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("MyTaskImplementation");
//			executionTimes.put("MyTaskImplementation", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void AdminModule() {
//		try {
//
//			CommonWebActions.wait(10000);
//
//			CommonWebActions.waituntil("Organizetab");
//
//		//	CommonWebActions.ICMclick("Organizetab");
//
//			CommonWebActions.waituntil("icmAdministration");
//
//		//	CommonWebActions.ICMclick("icmAdministration");
//			CommonWebActions.wait(5000);
//
//			CommonWebActions.webVerifyPageTitleContains("Admintitle");
//			CommonWebActions.wait(5000);
//			//CommonWebActions.switchToiFrame1("FrameSwitch");
//
//			CommonWebActions.waituntil("StatementreleatedHeader");
//
//			CommonWebActions.webVerifyInnerText("StatementreleatedHeader", "StatementreleatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamRelatedHeader", "TeamRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamratesRelatedHeader", "TeamratesRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamStatementCorrelationRelatedHeader", "TeamStatementCorrelationRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("UserandgroupManagementHeader", "UserandgroupManagementHeader");
//
//			CommonWebActions.webVerifyInnerText("TaskReassignmentHeader", "TaskReassignmentHeader");
//
//			CommonWebActions.webVerifyInnerText("WritepassInformationheader", "WritepassInformationheader");
//
//			CommonWebActions.webVerifyInnerText("PlantAdministrationHeader", "PlantAdministrationHeader");
//
//			CommonWebActions.webClick("Exitbutton");
//		//	CommonWebActions.ICMclick("Exitbutton");
//
//			executionTimes.put("FillTestingStmt", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("FillTestingStmt");
//			executionTimes.put("FillTestingStmt", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void VerifyStatementRelated() {
//		try {
//
//			CommonWebActions.waituntil("StatementreleatedHeader");
//
//			CommonWebActions.webVerifyInnerText("StatementreleatedHeader", "StatementreleatedHeader");
//
//			CommonWebActions.webClick("AdminStatementsforRequestTypesbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Update table");
//
//		//	CommonWebActions.ICMclick("UpdatetableExitScreen");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyMilestonenamesrelated() {
//		try {
//
//			CommonWebActions.waituntil("Milestonerelatedheader");
//
//			CommonWebActions.webVerifyInnerText("Milestonerelatedheader", "Milestonerelatedheader");
//
//			CommonWebActions.webClick("AdminMilestonesbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Show all Milestones");
//
//		//	CommonWebActions.ICMclick("Backtoselction");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyMilestonerelated() {
//		try {
//
//			CommonWebActions.waituntil("Milestonerelatedheader");
//
//			CommonWebActions.webVerifyInnerText("Milestonerelatedheader", "Milestonerelatedheader");
//
//			CommonWebActions.webClick("AdminMilestonesbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Show all Milestones");
//
//		//	CommonWebActions.ICMclick("Backtoselction");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyExchangerelated() {
//		try {
//
//			CommonWebActions.waituntil("Exchangerelatedheader");
//
//			CommonWebActions.webVerifyInnerText("Exchangerelatedheader", "Exchangerelatedheader");
//
//			CommonWebActions.webClick("Adminexchangeratesbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Admin Exchange Rates");
//
//		//	CommonWebActions.ICMclick("BacktoAdminPage");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyTeamRelated() {
//		try {
//
//			CommonWebActions.waituntil("TeamRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamRelatedHeader", "TeamRelatedHeader");
//
//			CommonWebActions.webClick("AdminTeamsbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Show all Teams");
//
//		//	CommonWebActions.ICMclick("BacktoAdminteamrelated");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyTeamRatesRelated() {
//		try {
//
//			CommonWebActions.waituntil("TeamratesRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamratesRelatedHeader", "TeamratesRelatedHeader");
//
//			CommonWebActions.webClick("AdminTeamratesbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Show all Team Rates");
//
//		//	CommonWebActions.ICMclick("BacktoAdminteamRatesrelated");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyTeamStatementCorrelationRelated() {
//		try {
//
//			CommonWebActions.waituntil("TeamStatementCorrelationRelatedHeader");
//
//			CommonWebActions.webVerifyInnerText("TeamStatementCorrelationRelatedHeader", "TeamStatementCorrelationRelatedHeader");
//
//			CommonWebActions.webClick("AdminTeamStatementCorrelationbutton");
//
//			CommonWebActions.waituntil("TeamStatementCorrelationHeader");
//
//			CommonWebActions.webVerifyPageTitleContains("decision Team/statement or Statement/team ");
//
//		//	CommonWebActions.ICMclick("EditTeamStatementbutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Edit Team/statement Correlation");
//
//		//	CommonWebActions.ICMclick("AbortgobackTeamStatement");
//
//			CommonWebActions.waituntil("TeamStatementCorrelationHeader");
//
//		//	CommonWebActions.ICMclick("EditStatementTeambutton");
//
//			CommonWebActions.webVerifyPageTitleContains("Edit�Statement/team�Correlation");
//
//		//	CommonWebActions.ICMclick("AbortgobackStatementTeam");
//
//			CommonWebActions.waituntil("TeamStatementCorrelationHeader");
//
//		//	CommonWebActions.ICMclick("TeamStatemntCorrelationExit");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifyUserandgroupManagement() {
//		try {
//
//			CommonWebActions.waituntil("UserandgroupManagementHeader");
//
//			CommonWebActions.webVerifyInnerText("UserandgroupManagementHeader", "UserandgroupManagementHeader");
//
//			CommonWebActions.webClick("Adminusergroupmanagementbutton");
//
//			// ---------------------------------------------------------------------------------------
//			// Group Names
//			CommonWebActions.webVerifyPageTitleContains("Admin User Group Management");
//
//			CommonWebActions.waituntil("GroupNamesHeader");
//
//			CommonWebActions.webVerifyInnerText("GroupNamesHeader", "GroupNamesHeader");
//
//			CommonWebActions.webClick("AdminGroupNamebutton");
//
//			CommonWebActions.waituntil("AdministrationGroupHeader");
//
//			CommonWebActions.webVerifyInnerText("AdministrationGroupHeader", "AdministrationGroupHeader");
//
//			CommonWebActions.webClick("BacktoadminMainPage1");
//
//			// ------------------------------------------------------------------------------------------
//
//			// Group Attributes
//
//			CommonWebActions.waituntil("GroupAttributesHeader");
//
//			CommonWebActions.webVerifyInnerText("GroupAttributesHeader", "GroupAttributesHeader");
//
//			CommonWebActions.webClick("AdminGroupAttributesbutton");
//
//			CommonWebActions.waituntil("AdminGroupAttributesHeader");
//
//			CommonWebActions.webVerifyInnerText("AdminGroupAttributesHeader", "AdminGroupAttributesHeader");
//
//			CommonWebActions.webClick("BacktoadminMainPage1");
//
//			// -------------------------------------------------------------------------------------------
//
//		//	CommonWebActions.ICMclick("BacktoMainpageUGM");
//
//			ReportUtil.reporterEvent("pass", "Mandatory fields shown correctly");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void VerifymandatoryfieldValidation() {
//		try {
//
//		\\	CommonWebActions.showmoreTasks();
//			CommonWebActions.waituntil("strIcmLink");
//
//			CommonWebActions.webClick("strIcmLink");
//
//			CommonWebActions.switchToDefaultContent();
//			//CommonWebActions.switchToiFrame1("iframeString2");
//
//			CommonWebActions.waituntil("SubmitChangeRequest");
//
//			CommonWebActions.webClick("SubmitChangeRequest");
//
//			// CommonWebActions.gettext("ValidationsubmitCR", "ValidationMessageCR");
//
//			CommonWebActions.webClick("ValidationMessageErrorClose");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fatal", "Element Not Found" + CommonWebActions.captureScreenshotAsBase64());
//		}
//
//	}
//
//	public static void logOff() {
//		try {
//
//			CommonWebActions.switchToDefaultContent();
//			startTime = System.currentTimeMillis();
//			CommonWebActions.wait(5000);
//			CommonWebActions.waituntil("LogoutDropdown");
//			CommonWebActions.webClick("LogoutDropdown");
//			CommonWebActions.waituntil("Logout");
//			CommonWebActions.webClick("Logout");
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("submitPackage", stopTime - startTime);
//			ReportUtil.reporterEvent("pass", "Logoff Success");
//		} catch (Exception e) {
//			e.printStackTrace();
//			ReportUtil.reporterEvent("fail", "Logoff failure" + CommonWebActions.captureScreenshotAsBase64());
//		}
//	}
//
//	public static void closeBrowserWindow() {
//		CommonWebActions.closeBrowser();
//	}
//
//	public static double Costvalue(String Objname, String Hourlyrate1) {
//		int Objname2 = 0;
//		double Objname3 = 0;
//
//		try {
//			System.out.println("Objname" + Objname);
//			String Hourlyrate = // CommonWebActions.gettext1(Hourlyrate1);
////			System.out.println("Hourlyrate" + Hourlyrate);
//
//			double Hourlyrate2 = Double.parseDouble(Hourlyrate);
//
//			System.out.println("Hourlyrate2" + Hourlyrate2);
//			String Objname1 = ExcelUtil.getDataFromExcel(ReportUtil.onlyTestCaseName, Objname);
//			System.out.println(Objname1);
//
//			Objname2 = Integer.parseInt(Objname1);
//			System.out.println(Objname2);
//
//			Objname3 = (Hourlyrate2) * (Objname2);
//			System.out.println(Objname3);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return Objname3;
//	}
//
//	public static String findinitialtask(final String processID) {
//
//		try {
//			System.out.println("Commonweb" + processID);
//			CommonWebActions.switchToDefaultContent();
//			CommonWebActions.waituntil("WorkTab");
//			CommonWebActions.webClick("WorkTab");
//			System.out.println("Clicked on work tab");
//
//		\\	CommonWebActions.showmoreTasks();
//
//			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(CommonWebActions.wd).pollingEvery(1000, TimeUnit.MILLISECONDS)
//					.withTimeout(600, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//			wait.until(new Function<WebDriver, WebElement>() {
//				@Override
//				public WebElement apply(WebDriver webDriver) {
//
//					return webDriver.findElement(By
//							.xpath("//div[@class='bpm-task-list-content']/div/div[6]/div[2]/div/div/div//*[@class='bpm-social-task-row-data-second-line']/span[contains(text(),'Integrated Change Management:"
//									+ processID + "')]"));
//				}
//			});
//
//			WebElement iid = CommonWebActions.wd.findElement(By
//					.xpath("//div[@class='bpm-task-list-content']/div/div[6]/div[2]/div/div/div//*[@class='bpm-social-task-row-data-second-line']/span[contains(text(),'Integrated Change Management:"
//							+ processID + "')]"));
//			System.out.println("value is:" + "iid");
//			String label = iid.getAttribute("aria-labelledby");
//			System.out.println(label);
//			initialTaskRowId = label.substring("taskrowinstancelabel".length());
//			System.out.println(initialTaskRowId);
//
//		} catch (Exception e) {
//			ReportUtil.reporterEvent("fail", CommonWebActions.captureScreenshotAsBase64());
//
//		}
//
//		return initialTaskRowId;
//	}
//
//	public static void distributeTeamInfo(String teamheader, String Numberofteams, String Personincharge, String Teamlist, String Teaminforemark) {
//		try {
//
//			startTime = System.currentTimeMillis();
//
//			CommonWebActions.waituntil(teamheader);
//			CommonWebActions.webClick(teamheader);
//
//			final String expectedInnerText1 = ExcelUtil.getDataFromExcel(ReportUtil.getOnlyTestCaseName(), Numberofteams);
//			System.out.println(expectedInnerText1);
//
//			int y = Integer.parseInt(expectedInnerText1);
//			for (int Number = 0; Number < y; Number++) {
//
//				CommonWebActions.waituntil("LogTeaminfoAddbutton");
//				CommonWebActions.webClick("LogTeaminfoAddbutton");
//				String strI = String.valueOf(Number);
//				System.out.println(strI);
//				String desTeaminfoExpert = "xpath:=.//div[@data-bindingrt='local.currentStatement.teamList[Number].roleInCharge']/div[2]/div/input";
//
//				String TeaminfoExpert1 = desTeaminfoExpert.replace("Number", strI);
//				System.out.println("Replacedvalue" + TeaminfoExpert1);
//				ORUtil.setValue("desTeaminfoExpert", TeaminfoExpert1);
//
//				String desTeaminfoteamlist = "xpath:=.//div[@data-bindingrt='local.currentStatement.teamList[Number].teamNameAndId']/div[2]/div/input";
//				String desTeaminfoteamlist1 = desTeaminfoteamlist.replace("Number", strI);
//				System.out.println("Replacedvalue" + desTeaminfoteamlist1);
//				ORUtil.setValue("desTeaminfoteamlist", desTeaminfoteamlist1);
//
//				String desTeaminfoRemarkdesc = "xpath:=.//div[@data-bindingrt='local.currentStatement.teamList[Number].remark']/div[2]/div[2]/div[3]/input";
//
//				String desTeaminfoRemarkdesc1 = desTeaminfoRemarkdesc.replace("Number", strI);
//				System.out.println("Replacedvalue" + desTeaminfoRemarkdesc1);
//				ORUtil.setValue("desTeaminfoRemarkdesc", desTeaminfoRemarkdesc1);
//
//				CommonWebActions.waituntil("desTeaminfoExpert");
//				// CommonWebActions.webSetFromXls("desTeaminfoExpert", Personincharge);
//				CommonWebActions.wait(2000);
//				CommonWebActions.ICMDownClick("desTeaminfoExpert");
//
//				CommonWebActions.waituntil("desTeaminfoteamlist");
//				// CommonWebActions.webSetFromXls("desTeaminfoteamlist", Teamlist);
//
//				CommonWebActions.waituntil("desTeaminfoRemarkdesc");
//				// CommonWebActions.webSetFromXls("desTeaminfoRemarkdesc", Teaminforemark);
//			}
//			CommonWebActions.waituntil("DistributeTeams");
//			CommonWebActions.webClick("DistributeTeams");
//
//			stopTime = System.currentTimeMillis();
//			executionTimes.put("DistributeLogTeamInfo", stopTime - startTime);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("DistributeTeamInfo");
//			executionTimes.put("OpenDesignTeamInfo", new Long(EXECUTION_FAILURE_TIME));
//		}
//	}
//
//	public static void selectEvalautionStmts(String Personincharge, String Username2, String attribute, String valueToSet1, String valueToSet, String stmtdate,
//			String stmtDate1, String stmtcheckbox) {
//
//		try {
//			startTimeRR = System.currentTimeMillis();
//			System.out.println(Personincharge);
//			CommonWebActions.webClick("PersoninchargeFieldAftersalesstmt");
//			CommonWebActions.webClick(Personincharge);
//		//	CommonWebActions.ICMclick(Personincharge);
//			CommonWebActions.waituntilTileContains("Roles and Rights");
//
//			CommonWebActions.webClick("SearchGroupButton");
//
//			CommonWebActions.waituntil("StatementUser");
//			CommonWebActions.webClick("StatementUser");
//
//			CommonWebActions.waituntil("Searchuser");
//			CommonWebActions.webClick("Searchuser");
//
//			CommonWebActions.waituntil("AllLink");
//			CommonWebActions.webClick("AllLink");
//
////			CommonWebActions.SelectUser(Username2, attribute, valueToSet1, valueToSet);
//
//			CommonWebActions.waituntil("Roles&RightsSubmitbutton");
//			CommonWebActions.webClick("Roles&RightsSubmitbutton");
//
//			CommonWebActions.waituntil("SubmitEvaluation");
//
//			// CommonWebActions.webSetFromXls(stmtdate, stmtDate1);
//
//			WebElement stmtCheckbox1 = CommonWebActions.findElement(stmtcheckbox);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CheckboxAttribute = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CheckboxAttribute");
//
//			String sStmt = stmtCheckbox1.getAttribute(CheckboxAttribute);
//
//			if (sStmt.equalsIgnoreCase("false"))
//
//				CommonWebActions.webClick(stmtcheckbox);
//
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("selectEvalautionStmts", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("selectEvalautionStmts");
//			executionTimes.put("selectEvalautionStmts", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void selectEvalautionStmts1(String PersoninchargeField, String Personinchargedropdown, String PersoninchargeName, String stmtdate,
//			String stmtDate1, String stmtcheckbox) {
//
//		try {
//			startTimeRR = System.currentTimeMillis();
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			// CommonWebActions.webSetFromXls(PersoninchargeField, PersoninchargeName);
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil(Personinchargedropdown);
//			CommonWebActions.webClick(Personinchargedropdown);
//
//			// CommonWebActions.webSetFromXls(stmtdate, stmtDate1);
//
//			WebElement stmtCheckbox = CommonWebActions.findElement(stmtcheckbox);
//
//			final String CheckboxAttribute = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CheckboxAttribute");
//
//			String sStmt = stmtCheckbox.getAttribute(CheckboxAttribute);
//
//			if (sStmt.equalsIgnoreCase("false"))
//
//				CommonWebActions.webClick(stmtcheckbox);
//
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("selectEvalautionStmts1", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("selectEvalautionStmts1");
//			executionTimes.put("selectEvalautionStmts1", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static void selectEvalautionStmts2(String PersoninchargeField, String Personinchargedropdown, String PersoninchargeName, String stmtdate,
//			String stmtDate1, String stmtcheckbox) {
//
//		try {
//			startTimeRR = System.currentTimeMillis();
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			// CommonWebActions.webSetFromXls(PersoninchargeField, PersoninchargeName);
//			CommonWebActions.wait(3000);
//			CommonWebActions.waituntil(Personinchargedropdown);
//			CommonWebActions.webClick(Personinchargedropdown);
//
//			CommonWebActions.scrollup();
//
//			// CommonWebActions.webSetFromXls(stmtdate, stmtDate1);
//
//			CommonWebActions.scrollup();
//
//			WebElement stmtCheckbox = CommonWebActions.findElement(stmtcheckbox);
//
//			final String CheckboxAttribute = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CheckboxAttribute");
//
//			String sStmt = stmtCheckbox.getAttribute(CheckboxAttribute);
//
//			if (sStmt.equalsIgnoreCase("false"))
//
//				CommonWebActions.webClick(stmtcheckbox);
//
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("selectEvalautionStmts2", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("selectEvalautionStmts2");
//			executionTimes.put("selectEvalautionStmts2", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//	}
//
//	public static int Businesscasevalidation(String Objname, String excelObjname) {
//		int cmp = 0;
//		try {
//			startTimeRR = System.currentTimeMillis();
//
//			double Objname1 = CommonWebActions.getValue(Objname);
//			System.out.println("Objname1:" + Objname1);
//
//			int Objname2 = (int) Objname1;
//
//			System.out.println(Objname2);
//
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			String excelObjname1 = ExcelUtil.getDataFromExcel(onlyTestCaseName, excelObjname);
//
//			System.out.println(excelObjname1);
//
//			double excelObjname2 = Double.parseDouble(excelObjname);
//
//			int excelObjname3 = (int) Math.round(excelObjname2);
//
//			System.out.println(excelObjname3);
//
//			cmp = Integer.compare(Objname2, excelObjname3);
//
//			System.out.println(cmp);
//
//			if (cmp == 0) {
//
//				System.out.println("Value is correct");
//			} else {
//				System.out.println("Value is wrong");
//			}
//
//			stopTimeRR = System.currentTimeMillis();
//			executionTimes.put("RolesAndRights-StatementExpertTesting", stopTimeRR - startTimeRR);
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("RolesAndRights-StatementExpertTesting");
//			executionTimes.put("RolesAndRights-StatementExpertTesting", new Long(EXECUTION_FAILURE_TIME));
//		}
//
//		return cmp;
//	}
//
//	public static void FindConsoldidatevieweng() {
//
//		String Consoldidatevieweng1 = null;
//		String Consoldidatevieweng2 = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			Consoldidatevieweng1 = "xpath:=//a[starts-with(text(),'2. Work on statements for \"" + "Consolidation View Engineering" + "\" in \"" + packageNumber
//					+ "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			Consoldidatevieweng2 = Consoldidatevieweng1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Consoldidatevieweng2);
//			ORUtil.setValue("Consoldidatevieweng1", Consoldidatevieweng2);
//			CommonWebActions.waituntil("Consoldidatevieweng1");
//			System.out.println("design stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("Consoldidatevieweng1");
//
//		}
//
//	}
//
//	public static void OpenConsoldidatevieweng() {
//
//		try {
//
//		//	CommonWebActions.ICMclick("Consoldidatevieweng1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("ConsolidationviewengiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("ConsoldidateviewengShellnumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenConsoldidatevieweng");
//
//		}
//
//	}
//
//	public static void distributeCVEstmts() throws Exception {
//
//		CommonWebActions.webClick("Selectfordistribution");
//
//		CommonWebActions.scrollup1();
//
//		selectEvalautionStmts1("PersoninchargeFieldCVEstmt", "PersoninchargedropdownCVE", "Addtionalpacpersonid", "CVEstmtDate", "CVEstmtDate",
//				"CVEstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldDesignstmt", "PersoninchargedropdownDesign", "Addtionalpacpersonid", "DesignstmtDate", "DesignstmtDate",
//				"DesignstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldTestingstmt", "PersoninchargedropdownTesting", "Addtionalpacpersonid", "TestingstmtDate", "DesignstmtDate",
//				"TestingstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldHomologationstmt", "PersoninchargedropdownHomologation", "Addtionalpacpersonid", "HomologationstmtDate",
//				"DesignstmtDate", "HomologationstmtCheckbox");
//
//	//	CommonWebActions.ICMclick("CVEStmtsdistributebutton");
//
//	}
//
//	public static void FillConsoldidatevieweng() {
//
//		CommonWebActions.waituntil("CVERecommendation");
//		// CommonWebActions.webSetFromXls("CVERecommendation", "CVERecommendation");
//
//		CommonWebActions.waituntil("CVERecommendationcomment");
//		// CommonWebActions.webSetFromXls("CVERecommendationcomment", "CVERecommendationcomment");
//
//	}
//
//	public static void FinishConsoldidatevieweng() throws Exception {
//
//		CommonWebActions.waituntil("CVESumbitgroupbutton");
//	//	CommonWebActions.ICMclick("CVESumbitgroupbutton");
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("workBenchHeading");
//	}
//
//	public static void FindConsoldidateviewprice_cost() {
//		String Consoldidateviewprice_cost1 = null;
//		String Consoldidateviewprice_cost2 = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			Consoldidateviewprice_cost1 = "xpath:=//a[starts-with(text(),'2. Work on statements for \"" + "Consolidation View Price and Costs" + "\" in \""
//					+ packageNumber + "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			Consoldidateviewprice_cost2 = Consoldidateviewprice_cost1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Consoldidateviewprice_cost2);
//			ORUtil.setValue("Consoldidateviewprice_cost1", Consoldidateviewprice_cost2);
//			CommonWebActions.waituntil("Consoldidateviewprice_cost1");
//			System.out.println("design stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("Consoldidateviewprice_cost1");
//
//		}
//
//	}
//
//	public static void OpenConsoldidateviewprice_cost() {
//		try {
//
//		//	CommonWebActions.ICMclick("Consoldidateviewprice_cost1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("Consoldidateviewprice_costiFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("Consoldidateviewprice_costShellnumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenConsoldidateviewprice_cost");
//
//		}
//
//	}
//
//	public static void distributeCVPCstmts() throws Exception {
//
//		CommonWebActions.webClick("HeadertabCVPC");
//
//		selectEvalautionStmts1("PersoninchargeFieldCVEstmt", "PersoninchargedropdownCVE", "Addtionalpacpersonid", "CVEstmtDate", "CVEstmtDate",
//				"CVEstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldDesignstmt", "PersoninchargedropdownDesign", "Addtionalpacpersonid", "DesignstmtDate", "DesignstmtDate",
//				"DesignstmtCheckbox");
//
//	//	CommonWebActions.ICMclick("CVPCStmtsdistributebutton");
//
//	}
//
//	public static void FillConsoldidateviewprice_cost() {
//
//		CommonWebActions.waituntil("CVPCRecommendation");
//		// CommonWebActions.webSetFromXls("CVPCRecommendation", "CVERecommendation");
//
//		CommonWebActions.waituntil("CVPCRecommendationcomment");
//		// CommonWebActions.webSetFromXls("CVPCRecommendationcomment", "CVERecommendationcomment");
//	}
//
//	public static void FinishConsoldidateviewprice_cost() throws Exception {
//
//		CommonWebActions.waituntil("CVPCSumbitgroupbutton");
//	//	CommonWebActions.ICMclick("CVPCSumbitgroupbutton");
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("workBenchHeading");
//	}
//
//	public static void FinddoConsoldidateviewproduction() {
//		String Consoldidateviewproduction1 = null;
//		String Consoldidateviewproduction2 = null;
//
//		try {
//
//			System.out.println(packageNumber);
//
//			CommonWebActions.switchToDefaultContent();
//
//			CommonWebActions.waituntil("WorkTab");
//
//			CommonWebActions.webClick("WorkTab");
//
//		\\	CommonWebActions.showmoreTasks();
//			String onlyTestCaseName = ReportUtil.onlyTestCaseName;
//
//			final String CRtitle = ExcelUtil.getDataFromExcel(onlyTestCaseName, "CRTitle");
//			System.out.println(CRtitle);
//
//			Consoldidateviewproduction1 = "xpath:=//a[starts-with(text(),'2. Work on statements for \"" + "Consolidation View Production" + "\" in \""
//					+ packageNumber + "\"') and contains(text(),\"" + CRtitle + "\")][@title='Click to work on the task']";
//
//			Consoldidateviewproduction2 = Consoldidateviewproduction1.replaceAll("PackageNumber", packageNumber).replaceAll("CRtitle", CRtitle);
//			System.out.println("Replacedvalue" + Consoldidateviewproduction2);
//			ORUtil.setValue("Consoldidateviewproduction1", Consoldidateviewproduction2);
//			CommonWebActions.waituntil("Consoldidateviewproduction1");
//			System.out.println("design stmt found");
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("Consoldidateviewproduction1");
//
//		}
//
//	}
//
//	public static void OpendoConsoldidateviewproduction() {
//		try {
//
//		//	CommonWebActions.ICMclick("Consoldidateviewproduction1");
//			CommonWebActions.switchToDefaultContent();
//			System.out.println("switched to default content");
//			//CommonWebActions.switchToiFrame1("ConsoldidateviewproductioniFrame");
//			System.out.println("switched to frame");
//			CommonWebActions.waituntil("ConsoldidateviewproductionShellnumber");
//			System.out.println("Shell Number is displayed");
//
//		} catch (Exception exception) {
//			SeleniumUtils.printError(exception.getMessage());
//			SeleniumUtils.takeScreenshot("OpenConsoldidateviewproduction");
//
//		}
//
//	}
//
//	public static void distributeCVPstmts() throws Exception {
//		CommonWebActions.webClick("Selectfordistribution");
//
//		CommonWebActions.scrollup1();
//
//		selectEvalautionStmts1("PersoninchargeFieldCVEstmt", "PersoninchargedropdownCVE", "Addtionalpacpersonid", "CVEstmtDate", "CVEstmtDate",
//				"CVEstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldDesignstmt", "PersoninchargedropdownDesign", "Addtionalpacpersonid", "DesignstmtDate", "DesignstmtDate",
//				"DesignstmtCheckbox");
//
//		selectEvalautionStmts1("PersoninchargeFieldTestingstmt", "PersoninchargedropdownTesting", "Addtionalpacpersonid", "TestingstmtDate", "DesignstmtDate",
//				"TestingstmtCheckbox");
//
//	//	CommonWebActions.ICMclick("CVPStmtsdistributebutton");
//
//	}
//
//	public static void FilldoConsoldidateviewproduction() {
//		CommonWebActions.waituntil("CVPRecommendation");
//		// CommonWebActions.webSetFromXls("CVPRecommendation", "CVERecommendation");
//
//		CommonWebActions.waituntil("CVPRecommendationcomment");
//		// CommonWebActions.webSetFromXls("CVPRecommendationcomment", "CVERecommendationcomment");
//
//	}
//
//	public static void FinishdoConsoldidateviewproduction() throws Exception {
//		CommonWebActions.waituntil("CVPSumbitgroupbutton");
//	//	CommonWebActions.ICMclick("CVPSumbitgroupbutton");
//
//		CommonWebActions.switchToDefaultContent();
//
//		CommonWebActions.waituntil("workBenchHeading");
//
//	}
//
//}
