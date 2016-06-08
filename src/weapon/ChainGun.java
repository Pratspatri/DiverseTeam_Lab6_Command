package weapon;

/**
 * The class contains methods to ChainGun. ChainGun is a weapon.
 * @author Prathyusha Akshintala.
 */
public class ChainGun extends GenericWeapon
{

	/**
	 * Creates ChainGun with default values.
	 * CHAINGUN_BASE_DAMAGE = 15;
	 * CHAINGUN_MAX_RANGE = 30;
	 * CHAINGUN_RATE_OF_FIRE = 4;
	 * CHAINGUN_MAX_AMMO = 40;
	 */
	public ChainGun()
	{
		super(15, 30, 4, 40);
	}

	/**
	 * Calculates the damage to be done by ChainGun.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int calculateDamage(int distence)
	{
		double temp;
		temp = baseDamage * distence;
		temp /= maxRange;
		return (int) temp;
	}

}
