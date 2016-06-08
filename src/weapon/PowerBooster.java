package weapon;

import exceptions.AttachmentException;

/**
 * The class contains methods to PowerBooster. PowerBooster is a Attachment.
 * @author Prathyusha Akshintala.
 */
public class PowerBooster extends Attachment
{

	/**
	 * Decorates the attachment to the weapon.
	 * @param weapon : Weapon to which the attachment to be added.
	 * @throws AttachmentException : thrown when the maximum number of
	 *             attachments already present.
	 */
	PowerBooster(Weapon weapon) throws AttachmentException
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
			temp = weapon.getMaxAmmo() + weapon.getActualAmmo();
			temp *= damage;
			temp /= weapon.getMaxAmmo();
			return (int) temp;
		}
	}

}
