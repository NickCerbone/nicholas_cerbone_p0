package exception;

public class EmptyAccountException extends Exception{

	@Override
	public String getMessage() {
		return "No bank information available";
	}

	
	
}
