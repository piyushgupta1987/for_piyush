package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtil {
	private static final String DEFAULT_FILE_NAME = "application.properties";
	
	public static Properties readProperties(String fileName){
		if(fileName==null && "".equals(fileName)){
			fileName = DEFAULT_FILE_NAME;
		}
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
