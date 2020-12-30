package LaunchWithMultipleBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example1 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kaushal.mandal000@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("kaushal123");
	  driver.findElement(By.xpath("//button[@name='login']")).click();
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String str) 
  {
	  if(str.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.facebook.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  else if(str.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "E:\\Software\\driver\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.get("https://www.facebook.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
