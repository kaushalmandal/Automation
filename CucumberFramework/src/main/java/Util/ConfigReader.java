package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private Properties prop;
	public Properties init_prop()
	{
		prop=new Properties();
		try {
			FileInputStream fi=new FileInputStream("src\\test\\resource\\config\\config.properties");
			try {
				prop.load(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;

		
		
	}

}
