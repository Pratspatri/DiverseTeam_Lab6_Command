package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameplay.SimpleTimer;

/**
 * The test cases for the Generic Weapon class.
 * @author Sameer Kumar Kotra
 */
public class TestGenericWeapon
{

	/**
	 * Tests weather ammo is used when weapon is fired.
	 */
	@Test
	public void testUseAmmo()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		assertEquals(10, weapon.getActualAmmo());
		weapon.fire(10);
		assertEquals(9, weapon.getActualAmmo());
	}

	/**
	 * Tests weapon fires in limit in one round.
	 */
	@Test
	public void testRateOfFire()
	{
		SimpleTimer timer = new SimpleTimer();
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		timer.addTimeObserver(weapon);

		assertEquals(5, weapon.fire(10));
		assertEquals(5, weapon.fire(10));

		// Can not fire as for this round it completed max rate of fire.
		assertEquals(0, weapon.fire(10));

		timer.updateRound();
		timer.timeChanged();

		assertEquals(5, weapon.fire(10));
	}

	/**
	 * Test weather weapon can reload .
	 */
	@Test
	public void testReload()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		weapon.fire(10);
		weapon.fire(10);

		assertEquals(0, weapon.getActualAmmo());
		weapon.relod();
		assertEquals(2, weapon.getActualAmmo());
	}

	/**
	 * Test weapon when it is out of Ammo.
	 */
	@Test
	public void testOutOfAmmo()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		weapon.fire(10);
		weapon.fire(10);
		assertEquals(0, weapon.getActualAmmo());
		// returns 0 damage as out of ammo
		assertEquals(0, weapon.fire(10));
	}

	/**
	 * Test when the target is out of range.
	 */
	@Test
	public void testOutOfRange()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		assertEquals(2, weapon.getActualAmmo());
		// Returns 0 as distance is more than distance.
		assertEquals(0, weapon.fire(35));
		// Actual ammo is decreased
		assertEquals(1, weapon.getActualAmmo());
	}

	/**
	 * test the initialization of the mock weapon.
	 */
	@Test
	public void testInitialization()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		assertEquals(10, weapon.getBaseDamage());
		assertEquals(25, weapon.getMaxRange());
		assertEquals(2, weapon.getRateOfFire());
		assertEquals(10, weapon.getMaxAmmo());
		assertEquals(10, weapon.getActualAmmo());
		assertEquals(0, weapon.getFireCounter());
	}

}
