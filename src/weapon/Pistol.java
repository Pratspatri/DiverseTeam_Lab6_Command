package weapon;

/**
 * The class contains methods to Pistol. Pistol is a weapon.
 * @author Sameer Kumar Kotra
 */
public class Pistol extends GenericWeapon
{

	/**
	 * Creates Pistol with default values.
	 * PISTOL_BASE_DAMAGE = 10;
	 * PISTOL_MAX_RANGE = 25;
	 * PISTOL_RATE_OF_FIRE = 2;
	 * PISTOL_MAX_AMMO = 10;
	 */
	public Pistol()
	{
		super(10, 25, 2, 10);
	}

	/**
	 * Calculates the damage to be done by Pistol.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int calculateDamage(int distence)
	{
		double temp = maxRange + 5 - distence;
		temp *= baseDamage;
		temp /= maxRange;
		return (int) temp;
	}

}
