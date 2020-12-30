package ABC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyName 
{
	public static String getName(String name)
	{
		return name;
	}
  @Test
  public void f() 
  {
	  Assert.assertEquals("kaushal", VerifyName.getName("kaushal"));
  }


}
