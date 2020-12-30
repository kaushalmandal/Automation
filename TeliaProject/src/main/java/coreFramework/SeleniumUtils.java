package coreFramework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import applicationSpecific.AUT;

public class SeleniumUtils {

	private static boolean acceptNextAlert;
	public static String basePath = "C:\\Apps\\ICM\\";
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	public static String resultPath = basePath + "PerformanceTester\\logs\\icm_performance_result_001.csv";

	public static void closeAlerts(WebDriver driver) {

		try {
			Alert alert = driver.switchTo().alert();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return;
		} catch (NoAlertPresentException Ex) {
			return;
		} finally {
			acceptNextAlert = true;
		}
	}

	public static void pause(long pasueTime) {
		try {

			Thread.sleep(pasueTime);
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void takeScreenshot(String methodName) {
		File scrFile = ((TakesScreenshot) CommonWebActions.wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Apps\\ICM\\PerformanceTester\\logs\\error_screenshot_" + methodName + "_" + timeStamp + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printError(String message) {
		try {

			PrintWriter writer = new PrintWriter(basePath + "PerformanceTester\\logs\\icm_performance_exception_" + timeStamp + ".csv", "UTF-8");
			writer.println(message);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static void selectOptionWithText(String textToSelect, String IdEval, WebDriverWait wait) {
		try {
			WebElement autoOptions = CommonWebActions.wd.findElement(By.id(IdEval));
			autoOptions.getAttribute("aria-labelledby");
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("div"));

			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {

					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public boolean isAlertPresent() {
		try {
			CommonWebActions.wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static String getHeaderTemplate(String strEnvURL) {
		InputStream inputStream = null;
		try {

//			AUT.urlPropertyKey = strEnvURL;
			if (strEnvURL.contains("IF"))
				inputStream = SeleniumUtils.class.getResourceAsStream("/com/daimler/itc/icm/utils/headerTemplate_IF.txt");
			else {
				inputStream = SeleniumUtils.class.getResourceAsStream("/coreFramework/PrintHeaderTemplate.txt");
				System.out.println("Coreframework" + inputStream);
			}
			String s = IOUtils.toString(inputStream, "UTF-8");
			System.out.println(s);
			return s;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public static void printLog() {
		PrintWriter writer = null;
		try {
			File f = new File(resultPath);
			System.out.println(f);
			String headers = "";
			headers = SeleniumUtils.getHeaderTemplate("0");
			System.out.println(headers);
			if (!f.exists()) {
				writer = new PrintWriter(resultPath, "UTF-8");
				writer.println("TestTimeStamp," + headers + ",TotalSubmissionTime");
			} else {
				writer = new PrintWriter(new BufferedWriter(new FileWriter(resultPath, true)));
			}
			writer.print(timeStamp);

			String[] headerColumns = headers.split(",");
			long totalTime = 0;

			for (String header : headerColumns) {
				writer.print(",");

//				Long value = AUT.executionTimes.get(header);
//				System.out.println(value);
//				if (value == null) {
//					value = AUT.EXECUTION_FAILURE_TIME;
//				}
//				writer.print(value);
//				totalTime = totalTime + value;
//				if (totalTime > AUT.EXECUTION_FAILURE_MAX) {
//					totalTime = AUT.EXECUTION_FAILURE_MAX;
//				}
			}

			writer.print("," + totalTime);
			writer.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (null != writer) {
				writer.close();
			}

		}

	}

}
