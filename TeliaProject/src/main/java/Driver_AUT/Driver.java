package Driver_AUT;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

//import smoke.TestScripts.test.*;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.aventstack.extentreports.ExtentReports;
//import com.beust.testng.TestNG;
import com.beust.testng.*;

//import Applibrary.AppUtils;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
//import main.java.util.ExcelLibrary;
//import CommonUtils.ReportUtil;


 @Test
public  class Driver{
    String BrowserType;
	public ArrayList SS;
	public static ExcelUtil config ;
	public String RegressionSheetName="Regression_Test_Data";
	public String SmokeSheetName="Smoke_Test_Data";
	static WebDriver driver = null;
	ExcelUtil config1 = new ExcelUtil( System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx");
	int Rw_cnt;
	
	
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
		


	public static void testCaseFlow() throws Exception {
		ExcelUtil config = new ExcelUtil( System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx");
		String Testtype=ExcelUtil.getCellData("config", 6, 11);
		Object obj[]=Testcaselistforrun(Testtype);
		String SheetName=(String) obj[0];
		int Rw_cnt=(int) obj[1];
		System.out.println("atest");
		ArrayList SS=config.TestcaseListTorun(Rw_cnt, SheetName);
		System.out.println("Done");
	for(int i=0; i<SS.size();i++){
		System.out.println(SS.get(i));
		String TC=(String) SS.get(i);
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");
		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
//		String Classname="smoke.TestScripts.test"+"."+TC;
		String Classname="TBC.testautomation.regression"+"."+TC;
		classes.add(new XmlClass(Classname));
		test.setXmlClasses(classes) ;
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		
		tng.runSuitesLocally();
	 }
	}
	
	
	public static Object[] Testcaselistforrun(String Testtype) throws Exception{
		if (Testtype.equalsIgnoreCase("Smoke")) {
			System.out.println(Testtype);
			String SheetName="Smoke_Test_Data";
			int Rw_cnt=  ExcelUtil.getRowCount(SheetName);
			return new Object[] {SheetName,Rw_cnt};
//			 ArrayList SS = config.TestcaseListTorun(Rw_cnt, SheetName);
		}else if(Testtype.equalsIgnoreCase("Regression")){
			System.out.println(Testtype);	
			String SheetName ="Regression_Test_Data";
			int Rw_cnt=  ExcelUtil.getRowCount(SheetName);
			System.out.println(Rw_cnt);
			return new Object[] {SheetName,Rw_cnt};
//			ArrayList SS=config.TestcaseListTorun(Rw_cnt, SheetName);
//			System.out.println(SS.size());
			}
		else
		{
			ExtentReports extent = ExtentManager.GetExtent();
/*			ReportUtil.startReporting("Null");
			ReportUtil.reporterEvent("fail", "No Test cases are set to True flag for Run");
			ReportUtil.endReporter();
*/			return null;
					}
		
	}
	
	/**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            } else if(file.getName().endsWith(".java")){
            	classes.add(file.getName());
            }
        }
        return classes;
    }
    
    public void generatedXMLfile () throws IOException {


        XmlSuite suite = new XmlSuite ();
        suite.setName ("Regression");
        suite.setParallel ("Tests");
//        suite.setThreadCount (10);

        XmlTest test = new XmlTest (suite);
        test.setName ("Test");
        test.setPreserveOrder ("true");

        XmlClass testClass = new XmlClass ();
      
//		String classname="smoke.TestScripts.test"+"."+TC
//        testClass.setName ("smoke.TestScripts.test");
//        List<XmlInclude> methodsToRun = constructIncludes (new String[] { "Method01", "Method02", "Method03" });
//        testClass.setIncludedMethods (methodsToRun);

//        XmlClass testClass1 = new XmlClass ();
//        testClass1.setName ("ClassName21");
//        methodsToRun = constructIncludes (new String[] { "Method21", "Method22", "Method23" });
//        testClass1.setIncludedMethods (methodsToRun);
//
//        test.setXmlClasses (Arrays.asList (new XmlClass[] { testClass, testClass1 }));
        System.out.println ("Printing TestNG Suite Xml");
        System.out.println (suite.toXml ());
    }



	private List<XmlInclude> constructIncludes (String... methodNames)  {
		  List<XmlInclude> includes = new ArrayList<XmlInclude> ();
	        for (String eachMethod : methodNames) {
	            includes.add (new XmlInclude (eachMethod));
	        }
	        return includes;
	}
	}
	

