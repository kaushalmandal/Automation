package WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleWebTable {
	public static WebDriver driver;

	@Test
	public void handleWebTable() {
		WebElement webtable = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));
		System.out.println("total rows size is :" + rows.size());
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
