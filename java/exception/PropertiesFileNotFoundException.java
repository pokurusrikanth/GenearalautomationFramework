package exception;

import org.openqa.selenium.WebDriverException;

public class PropertiesFileNotFoundException extends WebDriverException{

	String strmessage;
	public PropertiesFileNotFoundException(String message) {
		strmessage=message;
	}
	
	
	public String getmessage() {
		return strmessage;
	}
	
	
	
	
	
}
