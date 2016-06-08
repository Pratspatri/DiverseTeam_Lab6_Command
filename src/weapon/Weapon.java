package weapon;

import gameplay.TimeObserver;

/**
 * Interface to declare weapon menthods.
 * @author Sameer Kumar Kotra
 */
public interface Weapon extends TimeObserver
{

	/**
	 * @return the max range of the weapon.
	 */
	public int getMaxRange();

	/**
	 * @return the maximum Ammo of the weapon.
	 */
	public int getMaxAmmo();

	/**
	 * @return the base damage of the weapon.
	 */
	public int getBaseDamage();

	/**
	 * @return the rate of fire of the weapon.
	 */
	public int getRateOfFire();

	/**
	 * @return the current ammo of the weapon.
	 */
	public int getActualAmmo();

	/**
	 * Reloads the weapon to the max Ammo .
	 */
	public void relod();

	/**
	 * Fires the weapon .
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	public int fire(int distence);

	/**
	 * Calculates the damage to be done.
	 * @param distence : distance to the target.
	 * @return the damage caused by the weapon.
	 */
	public int calculateDamage(int distence);
}
