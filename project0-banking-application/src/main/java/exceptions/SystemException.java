package exceptions;

public class SystemException extends Exception {

	@Override
	public String getMessage() {
		return "internal error ... try again later";
	}

}
