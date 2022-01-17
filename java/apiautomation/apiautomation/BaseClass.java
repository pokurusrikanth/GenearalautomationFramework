package apiautomation.apiautomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	Properties prop;

	public BaseClass() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "C:\\Users\\Srikath\\eclipse-workspace\\apiautomation\\src\\main\\java\\configuration\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
