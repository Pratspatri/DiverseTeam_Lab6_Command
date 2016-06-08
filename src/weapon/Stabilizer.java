package weapon;

import exceptions.AttachmentException;

/**
 * The class contains methods to Stabilizer. Stabilizer is a Attachment.
 * @author Prathyusha Akshintala.
 */
public class Stabilizer extends Attachment
{

	/**
	 * Decorates the attachment to the weapon.
	 * @param weapon : Weapon to which the attachment to be added.
	 * @throws AttachmentException : thrown when the maximum number of
	 *             attachments already present.
	 */
	Stabilizer(Weapon weapon) throws AttachmentException
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
			temp = 1.25 * damage;
			if (weapon.getActualAmmo() == 0)
			{
				weapon.relod();
			}
			return (int) temp;
		}
	}

}
