package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class UtilityMethods {

	
	public static void main(String[] args) {
		


	}
	
	
	public static HashMap<String, String> getPropertiesData(String filepath) {

		HashMap<String, String> data = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Properties properties = new Properties();
			properties.load(fis);
			Set<Object> allproperties = properties.keySet();
			for (Object props : allproperties) {
				data.putIfAbsent(props.toString(), properties.getProperty(props.toString()));

			}

		} catch (IOException e) {
			System.out.println("exeception while reading poperties file" + filepath);
			System.exit(0);
		}

		return data;

	}
	
	public static String getvalueforkey(String key) 
	{
	Properties configproperties = new Properties();
	try {
		configproperties.load(new FileInputStream(new String("./ConfigFile/Environment.properties")));
	} catch (IOException e) {
		
	}
	return configproperties.getProperty(key);
	}
	
	

	public static void closeBrowser() {
		System.exit(0);

	}

	public static String gettimestamp() {
		String timestamp = "";
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		month++;
		timestamp = timestamp + month+"_"+ + day+"_"+ + hour+"_"+ + min+"_"+ + second;

		return timestamp;

	}
	//yyyy_mm_hh_dd_ss"yyyy_hh_dd_ss dd-M-yyyy hh:mm:ss
	
	
	public static String generateDate() {
		Date date = new Date();// import Date from java.util
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_mm_hh_dd_ss");
		return sdf.format(date);
	}

	public static void creat_Folder(String folderpath) {
		File f = new File(folderpath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

}
