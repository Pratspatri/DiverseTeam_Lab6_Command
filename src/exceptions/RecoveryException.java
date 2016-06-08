package exceptions;

/**
 * Recovery Exception is thrown when the Alien is created with negative recovery
 * rate.
 * @author Sameer Kumar Kotra
 */
public class RecoveryException extends Exception
{
	/**
	 * Creates RecoveryException with given Message
	 * @param message
	 */
	public RecoveryException(String message)
	{
		super(message);
	}

}
