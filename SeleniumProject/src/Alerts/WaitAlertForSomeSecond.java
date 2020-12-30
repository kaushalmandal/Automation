package Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitAlertForSomeSecond 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement ele=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
	  ele.click();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  wait=(WebDriverWait) wait.until(ExpectedConditions.alertIsPresent());
	  driver.switchTo().alert().accept();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
  }

}
