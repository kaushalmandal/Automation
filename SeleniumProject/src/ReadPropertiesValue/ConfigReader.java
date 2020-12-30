package ReadPropertiesValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	static Properties prop;
	public void readConfigValue() throws IOException
	{
		FileInputStream fi=new FileInputStream("E:\\JavaAndSeleniumProgram\\SeleniumProject\\src\\ReadPropertiesValue\\config.properties");
		 prop=new Properties();
		prop.load(fi);
		
	}
	public static String getDriverPath()
	{
		String driverpath=prop.getProperty("driver");
		return driverpath;
		
	}
	public static String getApplicationURL()
	{
		String url=prop.getProperty("url");
		return url;
	}
	public static String getUserName()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public static String getPassword()
	{
		String pass=prop.getProperty("password");
		return pass;
	}

}
