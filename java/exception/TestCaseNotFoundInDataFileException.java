package exception;

public class TestCaseNotFoundInDataFileException extends RuntimeException{

	String strmessage;
	
	public TestCaseNotFoundInDataFileException(String message) {
		strmessage=message;
	}
	
	
	public String getmessage() {
		return strmessage;
	}
	
	
	
	
	
	
	
}
