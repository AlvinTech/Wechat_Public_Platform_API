package alvin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	private static final String path = ReadProperties.class.getResource("").getPath()+ File.separator +"config.properties";
	
	public static Properties loadProperties() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void main(String args[]){
        String appSecret = ReadProperties.loadProperties().getProperty("APPSECRET");
        System.out.println(appSecret);
    }
}
