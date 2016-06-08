package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the ChainGun class.
 * @author Prathyusha Akshintala.
 */
public class TestChainGun
{

	/**
	 * Test the initialization of ChainGun.
	 */
	@Test
	public void testInitialization()
	{
		ChainGun gun = new ChainGun();
		assertEquals(15, gun.getBaseDamage());
		assertEquals(30, gun.getMaxRange());
		assertEquals(4, gun.getRateOfFire());
		assertEquals(40, gun.getMaxAmmo());
	}

	/**
	 * Tests the damage done in different scenarios.
	 */
	@Test
	public void testDamage()
	{
		ChainGun gun = new ChainGun();
		assertEquals(5, gun.fire(10));
		assertEquals(10, gun.fire(20));
		// 0 damage as target is out of range.
		assertEquals(0, gun.fire(40));
	}
}