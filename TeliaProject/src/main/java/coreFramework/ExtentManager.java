package coreFramework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.model.ScreenCapture;
//import com.relevantcodes.extentreports.view.ScreenshotHtml;
import com.aventstack.extentreports.model.ScreenCapture;

public class ExtentManager extends CoreListener {
	
	protected static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	 protected static ExtentTest test;
	public static String onlyTestCaseName;
	public static String absoluteFilename;
	protected final static File CONFIG_FILE = new File("./src/test/resources/testArtifacts/report-config.xml");
	public static ExtentReports GetExtent(){
		if (extent != null)
                    return extent; //avoid creating new instance of html file
                extent = new ExtentReports();		
//		extent.attachReporter(Telia_Automation());
		return extent;
	}
	public static void startReporting(String testcasename,String PackageName) {
		
//		extent = ExtentManager.GetExtent();
		 extent = new ExtentReports();		
		extent.attachReporter(Telia_Automation(PackageName,testcasename));
		test=extent.createTest(testcasename);
	}
	
	
	private static ExtentHtmlReporter Telia_Automation(String PackageName,String testcasename) {
		String currDir = System.getProperty("user.dir");
		String reportTime = getTimeAsString();
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		File f = new File(currDir + "\\report-output\\" +timeStamp);
		if (!f.exists()) {
			f.mkdir();   
		}
		File f1 = new File(currDir + "\\report-output\\" +timeStamp+"\\"+PackageName);
		if (!f1.exists()) {
			f1.mkdir();   
		}
		String reportPath = currDir + "\\report-output\\" +timeStamp+"\\"+PackageName;
		String absoluteFilename = reportPath+ "\\" + testcasename + "_" + reportTime + ".html";
		 
		try {
					File newTextFile = new File(currDir + "\\report-output\\filepath.txt");
					FileWriter fw = new FileWriter(newTextFile);
					String actualpath=absoluteFilename.replaceAll("\\\\","\\\\\\\\");
					fw.write(actualpath);
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

        htmlReporter = new ExtentHtmlReporter(absoluteFilename);
        htmlReporter.loadXMLConfig(CONFIG_FILE);
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Telia Automation report");
        htmlReporter.config().setReportName("Regression cycle");
     // allow automatic saving of media files relative to the report
       
//        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        return htmlReporter;
		}
		
	
	public static ExtentTest createTest(String name, String description){
		String testCaseName = testCaseNameListner.toString();
		ExtentTest test = extent.createTest(name, description);
		return test;
	}
	
	public static String takeScreenShot(WebDriver driver,String screenShotName) throws Exception
    {

		 Date now = new Date();
		    DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
	    String currentDate = shortDf.format(now).replace("/", "_");
		    currentDate = currentDate.replace(" ", "_");
		    currentDate = currentDate.replace(":", "_");
		    currentDate = currentDate.replace(",", "");
		    currentDate = currentDate.replace("_IST", "");

//		    System.out.println("current Date "+currentDate); 

    TakesScreenshot ts = (TakesScreenshot)driver;

    File source = ts.getScreenshotAs(OutputType.FILE);
    String userDir = System.getProperty("user.dir");
	userDir = userDir.replace('\\', '/');
    String dest = "C:/IMD/imd.testautomation.project/report-output/Screenshots/" + screenShotName +"_"+currentDate+".png";

    File destination = new File(dest);

    FileUtils.copyFile(source, destination);

    return dest;

}
/*	public static ExtentTest CaptureScreenshot(){
		try {
			
			String Screenshot=test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Screenshot();
	}
	*/
//	public static void startReporting() {
//		try {
//			String currDir = System.getProperty("user.dir");
//			String testCaseName = testCaseNameListner.toString();
//			reportPath = currDir + "\\report-output\\" + testPackageName;
//			String absoluteFilename = reportPath + "\\" + testCaseNameOnly + "_" + reportTime + ".html";
//
//			report = new ExtentReports(absoluteFilename);
//
//			report.loadConfig(CONFIG_FILE);
//
//			logger = report.startTest(onlyTestCaseName, testCaseNameOnly);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	  public static String addScreenCapture(String imgPath) {
	        String screenCaptureHtml = isPathRelative(imgPath) 
	                ? ScreenshotHtml.getSource(imgPath).replace("file:///", "") 
	                        : ScreenshotHtml.getSource(imgPath);
	        
	        ScreenCapture img = new ScreenCapture();
	        img.setPath(screenCaptureHtml);
//	        img.setName(test.getName());
//	        img.setReportObjectId(test.getObjectId());
//	        test.setScreenCapture(img);
//	        Test.setScreenCapture(img);

	        return screenCaptureHtml;
	    }

	 
	public static String captureScreenshotAsBase64() {
		String screenshotBase64 = ((TakesScreenshot) CommonWebActions.wd)
				.getScreenshotAs(OutputType.BASE64);
		screenshotBase64 = "data:image/gif;base64," + screenshotBase64;
		String imageInBase64 = addScreenCapture(screenshotBase64);
		return imageInBase64;
	}
	   private static Boolean isPathRelative(String path) {
	        if (path.indexOf("http") == 0 || !new File(path).isAbsolute()) {
	            return true;
	        }
	        
	        return false;
	    }
  
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
	

	/*@Override
	public void Breakdown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("getStatus() == ITestResult.FAILURE");
			Assert.assertEquals(false, true,
					"Test Case Failed");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("getStatus() == ITestResult.SUCCESS");
		}
	}	*/
}