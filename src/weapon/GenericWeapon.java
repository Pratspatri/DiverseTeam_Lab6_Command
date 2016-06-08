package weapon;

/**
 * Generic weapon has common methods to all weapons. Generic weapon is a weapon.
 * @author Sameer Kumar Kotra
 */
public abstract class GenericWeapon implements Weapon
{

	/**
	 * int to store base damage of the weapon.
	 */
	protected int baseDamage;
	/**
	 * int to store max range of the weapon.
	 */
	protected int maxRange;
	/**
	 * int to store rate of fire of the weapon.
	 */
	protected int rateOfFire;
	/**
	 * int to store max Ammo of the weapon.
	 */
	protected int maxAmmo;
	/**
	 * int to store actual Ammo of the weapon.
	 */
	protected int actualAmmo;
	/**
	 * int to store the no of times weapon fired in one round.
	 */
	private int fireCounter;

	/**
	 * Create the GenericWeapon with given values.
	 * @param baseDamage : Base damage of weapon.
	 * @param maxRange : Max range of the weapon.
	 * @param rateOfFire : Rate of fire of the weapon.
	 * @param maxAmmo : Max Ammo of the weapon.
	 */
	public GenericWeapon(int baseDamage, int maxRange, int rateOfFire, int maxAmmo)
	{
		this.baseDamage = baseDamage;
		this.maxRange = maxRange;
		this.rateOfFire = rateOfFire;
		this.maxAmmo = maxAmmo;
		actualAmmo = maxAmmo;
		fireCounter = 0;
	}

	/**
	 * @return the max range of the weapon.
	 */
	@Override
	public int getMaxRange()
	{
		return maxRange;
	}

	/**
	 * @return the maximum Ammo of the weapon.
	 */
	@Override
	public int getMaxAmmo()
	{
		return maxAmmo;
	}

	/**
	 * @return the base damage of the weapon.
	 */
	@Override
	public int getBaseDamage()
	{
		return baseDamage;
	}

	/**
	 * @return the rate of fire of the weapon.
	 */
	@Override
	public int getRateOfFire()
	{
		return rateOfFire;
	}

	/**
	 * @return the current ammo of the weapon.
	 */
	@Override
	public int getActualAmmo()
	{
		return actualAmmo;
	}

	/**
	 * Reloads the weapon to the max Ammo .
	 */
	@Override
	public void relod()
	{
		actualAmmo = maxAmmo;
	}

	/**
	 * Fires the weapon .
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	@Override
	public int fire(int distence)
	{
		if (actualAmmo > 0)
		{
			actualAmmo--;
			if (distence <= maxRange && fireCounter < rateOfFire)
			{
				fireCounter++;
				return calculateDamage(distence);
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}

	/**
	 * @return the no of times weapon fired in a round.
	 */
	public int getFireCounter()
	{
		return fireCounter;
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
		fireCounter = 0;
	}

}
