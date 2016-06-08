package exceptions;

/**
 * Attachment Exception is thrown when more than 2 attachments are tried to add
 * to a weapon.
 * @author Sameer Kumar Kotra
 */
public class AttachmentException extends Exception
{
	/**
	 * Creates AttachmentException with given message.
	 * @param message
	 */
	public AttachmentException(String message)
	{
		super(message);
	}

}
