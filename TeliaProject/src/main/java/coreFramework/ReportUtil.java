package coreFramework;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.*;

/**
 * This class consists of methods to perform reporting
 * 
 * @author Nagaraj Jayagondra
 * @version 1.0
 * @since 10-Dec-2015
 */

public class ReportUtil extends CoreListener {

	protected final static File CONFIG_FILE = new File("./src/test/resources/testArtifacts/report-config.xml");
	protected static ExtentTest test;
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	public static String onlyTestCaseName;
	
	
	public static String getOnlyTestCaseName() {
		return onlyTestCaseName;
	}

	protected static String reportPath;
	protected static String reportTime;

	private static String absoluteReportFilename;

	private static boolean failDetectedDuringRun;

	public static String getReportTime() {
		return reportTime;
	}

	public static String getReportPath() {
		return reportPath;
	}

	/**
	 * This method is used to initiate the reporting
	 * 
	 * @author Nagaraj Jayagondra
	 */
	/*public static void startReporting() {
		setFailDetectedDuringRun(false);
		try {
			String currDir = System.getProperty("user.dir");
			String testCaseName = testCaseNameListner.toString();

			String[] arrtestCaseNameDetails = testCaseName.split("=");

			String testCaseNameOnly = arrtestCaseNameDetails[1];

			testCaseNameOnly = testCaseNameOnly.replace("class ", "");
			testCaseNameOnly = testCaseNameOnly.replace("]", "");
			reportTime = getTimeAsString();

			String[] packageNameDetails = testCaseNameOnly.split("\\.");

			String testPackageName = packageNameDetails[0];

			onlyTestCaseName = packageNameDetails[1];

			reportPath = currDir + "\\report-output\\" + testPackageName;
			String absoluteFilename = reportPath + "\\" + testCaseNameOnly + "_" + reportTime + ".html";

			report = new ExtentReports(absoluteFilename);

			report.loadConfig(CONFIG_FILE);

			logger = report.startTest(onlyTestCaseName, testCaseNameOnly);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * This method is used to initiate the reporting
	 * 
	 * @author 
	 * @param rowTestCaseName 
	 */
	public static void startReporting(String rowTestCaseName) {
		setFailDetectedDuringRun(false);
		try {
			String currDir = System.getProperty("user.dir");
			reportTime = getTimeAsString();
//			String testCaseName = testCaseNameListner.toString();
//			String testCaseName=this.getClass().getName(); 
//			System.out.println(testCaseName);
//			String[] arrtestCaseNameDetails = testCaseName.split("=");
//			String testCaseNameOnly = arrtestCaseNameDetails[1];
//			testCaseNameOnly = testCaseNameOnly.replace("class ", "");
//			testCaseNameOnly = testCaseNameOnly.replace("]", "");
////			reportPath = currDir + "\\report-output\\" ;
//			String[] packageNameDetails = testCaseNameOnly.split("\\.");
//			String testPackageName = packageNameDetails[0];
			reportPath = currDir + "\\report-output\\" ;
			String absoluteFilename = reportPath + "" + rowTestCaseName + "_" + reportTime + ".html";
			 // start reporters
	       

//			  htmlReporter.loadXMLConfig(CONFIG_FILE);
	    // creates a toggle for the given test, adds all log events under it   
		      // creates a toggle for the given test, adds all log events under it    
		   
//	       test=extent.createTest(rowTestCaseName,"Sample Test");
//	        ExtentTest test = extent.createTest(rowTestCaseName, rowTestCaseName +" Detailed Test Steps");
		    test = extent.createTest("MyFirstTest", "Sample description");
		   reporterEvent("pass", "Sample Test");
		   
//			logger = report.startTest(rowTestCaseName, rowTestCaseName +" Detailed Test Steps");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*public static void startReporting1(String packagenumber, String taskId) {
		setFailDetectedDuringRun(false);
		try {
			System.out.println(packagenumber);
			String currDir = System.getProperty("user.dir");
			String testCaseName = testCaseNameListner.toString();
			System.out.println(testCaseName);
			String[] arrtestCaseNameDetails = testCaseName.split("=");
			String testCaseNameOnly = arrtestCaseNameDetails[1];
			testCaseNameOnly = testCaseNameOnly.replace("class ", "");
			testCaseNameOnly = testCaseNameOnly.replace("]", "");
			reportTime = getTimeAsString();
			String[] packageNameDetails = testCaseNameOnly.split("\\.");
			String testPackageName = packageNameDetails[0];
			onlyTestCaseName = packageNameDetails[1];
			reportPath = currDir + "\\report-output\\" + testPackageName;
			absoluteReportFilename = reportPath + "\\" + testCaseNameOnly + "_" + packagenumber + "_" + "_" + taskId + "_" + reportTime + ".html";
			report = new ExtentHtmlReporter(absoluteReportFilename);
			report.loadXMLConfig(CONFIG_FILE);
			logger = report.startTest(testCaseName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * This method is used to get time stamp as a formated string
	 * 
	 * @return time stamp as formated string
	 * @author Nagaraj Jayagondra
	 */
	protected static String getTimeAsString() {
		java.util.Date date = new java.util.Date();
		Timestamp currentTimestamp = new Timestamp(date.getTime());
		String currentTimeStampAsString = currentTimestamp.toString();
		currentTimeStampAsString = currentTimeStampAsString.replace("-", "");
		currentTimeStampAsString = currentTimeStampAsString.replace(":", "");
		currentTimeStampAsString = currentTimeStampAsString.replace(".", "");
		currentTimeStampAsString = currentTimeStampAsString.replace(" ", "");
		return currentTimeStampAsString;
	}
	
	public static String getTimeStampAsString(){
		java.util.Date date = new java.util.Date();
		Timestamp currentTimestamp = new Timestamp(date.getTime());
		String timestamp=currentTimestamp.toString();
		return timestamp;
		
	}

	/**
	 * This method is report the step details in the overall automation report
	 * 
	 * @author Nagaraj Jayagondra
	 * @param string
	 *            This is the status to be set. Example pass, info, fail, fatal,
	 *            warning, error, skip and unknown
	 * @param description
	 *            This is the description you want to be in the report
	 */
	public static void reporterEvent(String status, String description) {
		
		switch (status) {
		case "info":
			test.log(Status.INFO, description);
//			logger.log(LogStatus.INFO, description);
			break;
		case "fail":
			test.log(Status.FAIL, description);
			break;
		case "pass":
			test.log(Status.PASS, description);
			break;
		case "error":
			test.log(Status.ERROR, description);
			break;
		case "fatal":
			test.log(Status.FATAL, description);
			break;
		case "warning":
			test.log(Status.WARNING, description);
			break;
		case "skip":
			test.log(Status.SKIP, description);
			break;
		default:
			break;
		}
	}

	public static void reporterEvent(String status, String description, boolean markRunAsFailure) {
		setFailDetectedDuringRun(markRunAsFailure);
		reporterEvent(status, description);
	}

	/**
	 * This method is used to close the reporter event. To be called at the end
	 * of all steps
	 * 
	 * @author Nagaraj Jayagondra
	 * @return
	 */
	public static void endReporter()  {
     
		//		report.endTest(logger);
//		startReporting().extent.flush;
		
//		extent.
		extent.flush();
		
//		htmlReporter.flush();
	}

	public static void endReporterWithResult() {
//		report.endTest(logger);
		extent.flush();
//		htmlReporter.flush();
		File fileOld = new File(absoluteReportFilename);
		File fileNew = null;
		if (isFailDetectedDuringRun()) {
			fileNew = new File(absoluteReportFilename.substring(0, absoluteReportFilename.length() - 5) + "_" + "FAIL" + ".html");
		} else {
			fileNew = new File(absoluteReportFilename.substring(0, absoluteReportFilename.length() - 5) + "_" + "PASS" + ".html");
		}
		fileOld.renameTo(fileNew);
	}

	public static boolean isFailDetectedDuringRun() {
		return failDetectedDuringRun;
	}

	public static void setFailDetectedDuringRun(boolean failDetectedDuringRun) {
		ReportUtil.failDetectedDuringRun = failDetectedDuringRun;
	}

}
