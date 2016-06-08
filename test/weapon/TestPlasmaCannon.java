package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the PlasmaCannon class.
 * @author Prathyusha Akshintala.
 */
public class TestPlasmaCannon
{

	/**
	 * Test the initialization of ChainGun.
	 */
	@Test
	public void testInitialization()
	{
		PlasmaCannon cannon = new PlasmaCannon();
		assertEquals(50, cannon.getBaseDamage());
		assertEquals(20, cannon.getMaxRange());
		assertEquals(1, cannon.getRateOfFire());
		assertEquals(4, cannon.getMaxAmmo());
	}

	/**
	 * Tests the damage done in different scenarios.
	 */
	@Test
	public void testDamage()
	{
		PlasmaCannon cannon = new PlasmaCannon();
		assertEquals(50, cannon.fire(10));
		// Only one fire per round need to update the round to test.
		cannon.updateTime(1);
		assertEquals(37, cannon.fire(20));
		cannon.updateTime(2);
		// 0 damage as target is out of range.
		assertEquals(0, cannon.fire(30));
	}
}