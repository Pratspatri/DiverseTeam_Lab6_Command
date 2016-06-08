package weapon;

import exceptions.AttachmentException;

/**
 * Attachment has common method to all Attachments. Attachment is a Weapon.
 * @author Prathyusha Akshintala.
 */
public abstract class Attachment implements Weapon
{

	/**
	 * Weapon to store the Weapon.
	 */
	protected Weapon weapon;

	/**
	 * Creates an Attachment for the Weapon.
	 * @param weapon : Weapon to which attachment to be added.
	 * @throws AttachmentException : thrown when the maximum number of
	 *             attachments already present.
	 */
	Attachment(Weapon weapon) throws AttachmentException
	{
		int counter = 0;
		Weapon temp = weapon;
		while (true)
		{
			if (temp instanceof Attachment)
			{
				temp = ((Attachment) temp).weapon;
				counter++;
			}
			else
			{
				break;
			}
		}
		if (counter < 2)
		{
			this.weapon = weapon;
		}
		else
		{
			throw new AttachmentException("You can add only 2 attachments");
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
		weapon.updateTime(time);
	}

	/**
	 * @return the max range of the weapon.
	 */
	@Override
	public int getMaxRange()
	{
		return weapon.getMaxRange();
	}

	/**
	 * @return the maximum Ammo of the weapon.
	 */
	@Override
	public int getMaxAmmo()
	{
		return weapon.getMaxAmmo();
	}

	/**
	 * @return the base damage of the weapon.
	 */
	@Override
	public int getBaseDamage()
	{
		return weapon.getBaseDamage();
	}

	/**
	 * @return the rate of fire of the weapon.
	 */
	@Override
	public int getRateOfFire()
	{
		return weapon.getRateOfFire();
	}

	/**
	 * @return the current ammo of the weapon.
	 */
	@Override
	public int getActualAmmo()
	{
		return weapon.getActualAmmo();
	}

	/**
	 * Reloads the weapon to the max Ammo .
	 */
	@Override
	public void relod()
	{
		weapon.relod();
	}

	/**
	 * Calculates the damage to be done.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int calculateDamage(int distence)
	{
		return weapon.calculateDamage(distence);
	}

}
