package school;

/**
 * ValidateException will handle the exception raised by inputs taken from user.
 * @author savant
 */
class ValidateException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ValidateException(String str) {
		super(str);
	}
}