package Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Doubleclick {
	public static WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		WebElement doubleClick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleClick).build().perform();
		Thread.sleep(4);

		WebElement rightclickmsg = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));
		Assert.assertEquals("You have done a right click", rightclickmsg.getText(), "Text matched");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
