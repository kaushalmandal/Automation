package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyValue 
{
	public static String verifyValue(String name)
	{
		return name;
		
	}
  @Test
  public void f(String name) 
  {
	  Assert.assertEquals(VerifyValue.verifyValue(name),"kaushal");
  }

}
