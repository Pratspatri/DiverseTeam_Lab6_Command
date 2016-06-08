package weapon;

/**
 * Mock class to create a Generic Weapon.
 * @author Sameer Kumar Kotra
 */
public class MockGenericWeapon extends GenericWeapon
{
	/**
	 * Create the MockGenericWeapon with given values.
	 * @param baseDamage : Base damage of weapon.
	 * @param maxRange : Max range of the weapon.
	 * @param rateOfFire : Rate of fire of the weapon.
	 * @param maxAmmo : Max Ammo of the weapon.
	 */
	public MockGenericWeapon(int baseDamage, int maxRange, int rateOfFire, int maxAmmo)
	{
		super(baseDamage, maxRange, rateOfFire, maxAmmo);
	}

	/**
	 * Mock weapon returns 5 damage default.
	 */
	@Override
	public int calculateDamage(int distence)
	{
		return 5;
	}

}
