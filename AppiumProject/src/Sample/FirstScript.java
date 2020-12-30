package Sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class FirstScript {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platform version", "9");
		cap.setCapability("deviceName", "758bc486");
		//cap.setCapability("automationName","UiAutomator2");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("automationName", "UiAutomator2");
		//cap.setCapability("autoGrantPermissions": True);
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), cap);
		driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		Thread.sleep(2000);
	}

}
