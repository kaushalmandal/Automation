package ClickRadioButtonAndCheckBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickRadioButton 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement>li=driver.findElements(By.xpath("//input[@type='radio']"));
	  System.out.println("Total radio button is :"+li.size());
	  for(int i=0;i<li.size();i++)
	  {
		  if(li.get(i).getText().equalsIgnoreCase("Option2"))
		  {
			  li.get(i).click();
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/radio.html");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
