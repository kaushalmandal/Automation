package Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
	  WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));
	  Actions act=new Actions(driver);
	  act.dragAndDrop(source, destination).build().perform();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/droppable/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
