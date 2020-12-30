package ABC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyInteger 
{
	public static int getIntegerValue(int value)
	{
		return value;
	}
  @Test
  public void f() 
  {
	  Assert.assertEquals(10, VerifyInteger.getIntegerValue(10));
  }

}
