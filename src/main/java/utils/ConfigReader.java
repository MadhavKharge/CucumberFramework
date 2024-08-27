package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties intializeProperties() {
		
		Properties prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"/src/test/resourcess/config/config.properties");

		try {
			FileInputStream fis=new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
