package exceptions;

public class FundsException extends Exception {

	@Override
	public String getMessage() {
		return "insufficent funds";
	}

}
