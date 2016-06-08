package weapon;

import exceptions.AttachmentException;

/**
 * The class contains methods to Scope. Scope is a Attachment.
 * @author Sameer Kumar Kotra
 */
public class Scope extends Attachment
{

	/**
	 * Decorates the attachment to the weapon.
	 * @param weapon : Weapon to which the attachment to be added.
	 * @throws AttachmentException : thrown when the maximum number of
	 *             attachments already present.
	 */
	Scope(Weapon weapon) throws AttachmentException
	{
		super(weapon);
	}

	/**
	 * Calculates enhances the damage caused by the Scope.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int fire(int distence)
	{
		int damage = weapon.fire(distence);
		if (damage == 0)
		{
			return 0;
		}
		else
		{
			double temp;
			temp = 2 * weapon.getMaxRange() - distence;
			temp *= damage;
			temp /= weapon.getMaxRange();
			return (int) temp;
		}
	}

}
