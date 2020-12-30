package coreFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
//import coreFramework.Sprint3_Move_Service;
//import telia.testautomation.move.Sprint3_Move_Service;

//import telia.testautomation.move.Sprint3_Move_Service;

/**
 * This class consists of methods to connect to a property file
 * 
 * @author kapildev j
 * @version 1.0
 * @since 10-Dec-2015
 */
public class ORUtil {
	private final static Properties CONFIG_FILE = loadPropertiesFile("./src/test/resources/testArtifacts/Config.properties");
	private static final String CONFIG_REPO_PATH = "./src/test/resources/testArtifacts/Config.properties";
	static String ORPropertyfilename = CONFIG_FILE.getProperty("testDataWorkSheetName");
	private static final String OBJECT_REPO_PATH = "./src/test/resources/testArtifacts/ObjectRepository"+"_"+ORPropertyfilename+".properties";
	private final static Properties OBJECT_REPO = loadPropertiesFile(OBJECT_REPO_PATH);
//	private final static Properties IMAGE_REPO = loadPropertiesFile("./src/test/resources/testArtifacts/ImageLocationRepository.properties");

	/**
	 * This method is used to connect to a property file
	 * 
	 * @author kapildev j
	 * @param strFilePath
	 *            This is the file path
	 */
	private static Properties loadPropertiesFile(String strFilePath) {
		
		Properties prop = new Properties();
		try {
			FileInputStream fis;
			fis = new FileInputStream(strFilePath);
//			if (Sprint3_Move_Service.packagename()!=("move")) {
				prop.load(fis);
				System.out.println("loadPropertiesFile called: path = " + strFilePath);
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	private static void savePropertiesFile(String strFilePath) {
		System.out.println("savePropertiesFile called: path = " + strFilePath);
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(strFilePath);
			OBJECT_REPO.store(fos, "modified properties file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * This method is used to get value from the property file
	 * 
	 * @author kapildev j
	 * @param key
	 *            This is the key name (logical name)
	 * @return String This returns the value from property file
	 */
	public static String getValue(String key) throws IOException {

		String objectPropertyVal = OBJECT_REPO.getProperty(key, "ELEMENTNOTFOUND");
		return objectPropertyVal;
	}

	public static void setValue(String key, String valueToSet) throws IOException {
		System.out.println("setValue called - key: " + key + " value: " + valueToSet);
		CONFIG_FILE.setProperty(key, valueToSet);
		System.out.println("in Set:" + CONFIG_FILE.getProperty(key));
		FileOutputStream fos;
		fos = new FileOutputStream(CONFIG_REPO_PATH);
		CONFIG_FILE.store(fos, "modified properties file");
//		savePropertiesFile(CONFIG_REPO_PATH);
	}
	/**
	 * This method is used to set value from the property file
	 * 
	 * @author kapildev j
	 * @param key
	 *            This is the key name (logical name)
	 * @param valueToSet
	 *            This is the value to be set in the property file
	 */
	public static void setValue1(String key, String valueToSet) throws IOException {
		System.out.println("setValue called - key: " + key + " value: " + valueToSet);
		OBJECT_REPO.setProperty(key, valueToSet);
		System.out.println("in Set:" + OBJECT_REPO.getProperty(key));
		savePropertiesFile(OBJECT_REPO_PATH);
	}

	/**
	 * This method is used to get value from the property file
	 * 
	 * @author kapildev j
	 * @param key
	 *            This is the key name
	 * @return String This returns the value from property file
	 */
	public static String getConfigValue(String key) throws IOException {
		String configValue = CONFIG_FILE.getProperty(key);
		return configValue;
	}

	/**
	 * This method is used to get value from the Image Location Repository
	 * property file
	 * 
	 * @author kapildev j
	 * @param key
	 *            This is the key name
	 * @return String This returns the value from property file
	 */
/*	public static String getImageLocationValue(String key) throws IOException {
		String configValue = IMAGE_REPO.getProperty(key, "IMAGELOCATIONNOTFOUND");
		return configValue;
	}*/
}
