package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks 
{
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}
	@Before(order=1)
	public void launchBrowser()
	{
		String browsername=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browsername);
	}
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotname=scenario.getName().replaceAll(" ","-");
			byte[]sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath,"image/png",screenshotname);
		}
	}

}
