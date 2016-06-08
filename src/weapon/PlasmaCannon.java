package weapon;

/**
 * The class contains methods to PlasmaCannon. PlasmaCannon is a weapon.
 * @author Prathyusha Akshintala.
 */
public class PlasmaCannon extends GenericWeapon
{

	/**
	 * Creates PlasmaCannon with default values.
	 * PLASMACANNON_BASE_DAMAGE = 50;
	 * PLASMACANNON_MAX_RANGE = 20;
	 * PLASMACANNON_RATE_OF_FIRE = 1;
	 * PLASMACANNON_MAX_AMMO = 4;
	 */
	public PlasmaCannon()
	{
		super(50, 20, 1, 4);
	}

	/**
	 * Calculates the damage to be done by PlasmaCannon.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int calculateDamage(int distence)
	{
		double temp;
		temp = baseDamage * (actualAmmo + 1);
		temp /= maxAmmo;
		return (int) temp;
	}

}
