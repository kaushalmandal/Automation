package Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertConfirmationButton 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement ele=driver.findElement(By.xpath("//button[@id='confirmButton']"));
	  ele.click();
	  driver.switchTo().alert().accept();
	  String text=driver.switchTo().alert().getText();
	  Assert.assertEquals("Do you confirm action?",text,"text matching");
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/alerts");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
