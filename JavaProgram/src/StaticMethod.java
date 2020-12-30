
public class StaticMethod 
{
	public static String name(String name)
	{
		return name;
	}
	public static void main(String[]args)
	{
		name("kaushal");
	}
	
	public void getname()
	{
		StaticMethod.name("kaushal");
	}

}
