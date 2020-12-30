package Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitAlertPresent 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  boolean b=true;
	  WebElement ele=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
	  ele.click();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.alertIsPresent());
	   if(b=true)
	   {
		   driver.switchTo().alert().accept();
		   driver.switchTo().alert().getText();
	   }
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/alerts");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
