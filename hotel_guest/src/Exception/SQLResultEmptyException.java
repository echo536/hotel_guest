package Exception;

public class SQLResultEmptyException extends Exception {

	public SQLResultEmptyException() {
		super("The result is empty.");
	}

	public SQLResultEmptyException(String message) {
		super(message);
	}
}
