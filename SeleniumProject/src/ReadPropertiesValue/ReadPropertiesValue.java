package ReadPropertiesValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadPropertiesValue 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	  username.sendKeys(ConfigReader.getApplicationURL());
	  WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
	  password.sendKeys(ConfigReader.getPassword());
	  driver.findElement(By.xpath("//button[@name='login']")).click();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver",ConfigReader.getDriverPath());
	  driver=new ChromeDriver();
	  driver.get(ConfigReader.getApplicationURL());
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
