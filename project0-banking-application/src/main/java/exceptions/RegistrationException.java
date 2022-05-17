package exceptions;

public class RegistrationException extends Exception {

	@Override
	public String getMessage() {
		return "login credentials not found";
	}
	
}
