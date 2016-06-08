package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the Pistol class.
 * @author Sameer Kumar Kotra
 */
public class TestPistol
{

	/**
	 * Test the initialization of Pistol.
	 */
	@Test
	public void testInitialization()
	{
		Pistol pistol = new Pistol();
		assertEquals(10, pistol.getBaseDamage());
		assertEquals(25, pistol.getMaxRange());
		assertEquals(2, pistol.getRateOfFire());
		assertEquals(10, pistol.getMaxAmmo());
	}

	/**
	 * Tests the damage done in different scenarios.
	 */
	@Test
	public void testDamage()
	{
		Pistol pistol = new Pistol();
		// distance 10.
		assertEquals(8, pistol.fire(10));
		// distance 20.
		assertEquals(4, pistol.fire(20));
		// 0 damage as target is out of range.
		assertEquals(0, pistol.fire(30));
	}
}
