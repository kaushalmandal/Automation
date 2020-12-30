package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindBrokenLinksInAnotherWay 
{
	public static WebDriver driver;
	
	public void verifyLinks(String linkURL) throws IOException
	{
		URL url=new URL(linkURL);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setConnectTimeout(300);
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println(linkURL+"-----------"+con.getResponseMessage());
		}
		else if(con.getResponseCode()==400)
		{
			System.out.println(linkURL+"----------"+con.getResponseMessage());
		}
		
	}
  @Test
  public void f() throws IOException 
  {
	  List<WebElement>links=driver.findElements(By.tagName("a"));
	  for(int i=0;i<links.size();i++)
	  {
		  WebElement ele=links.get(i);
		  String URL=ele.getAttribute("href");
		  verifyLinks(URL);
	  }
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
