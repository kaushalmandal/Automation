package TestNG;

import org.testng.annotations.Test;

public class Priority 
{
  @Test(priority=0)
  public void m1() 
  {
	  System.out.println("priority----0");
  }
  @Test(priority=2)
  public void m2()
  {
	  System.out.println("priority-----2");
  }
  @Test(priority=1)
  public void m3()
  {
	  System.out.println("priority-------1");
  }
}
