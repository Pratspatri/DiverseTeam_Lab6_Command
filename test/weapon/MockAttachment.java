package weapon;

import exceptions.AttachmentException;

/**
 * Mock class to create a Generic Weapon.
 * @author Prathyusha Akshintala.
 */
public class MockAttachment extends Attachment
{

	/**
	 * Decorates the attachment to the weapon.
	 * @param weapon : Weapon to which the attachment to be added.
	 * @throws AttachmentException : thrown when the maximum number of
	 *             attachments already present.
	 */
	MockAttachment(Weapon weapon) throws AttachmentException
	{
		super(weapon);
	}

	/**
	 * Mock Attachment returns 0 damage.
	 */
	@Override
	public int fire(int distence)
	{
		return 0;
	}
}