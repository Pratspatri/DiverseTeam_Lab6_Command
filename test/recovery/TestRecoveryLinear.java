package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the RecoveryLinear class.
 * @author : Sameer Kumar Kotra
 */
public class TestRecoveryLinear
{

	/**
	 * Test the calculateRecovery of RecoveryLinear.
	 */
	@Test
	public void testRecovery()
	{
		RecoveryBehavior rb = new RecoveryLinear(3);

		// Test for currentLP = maxLP
		assertEquals(40, rb.calculateRecovery(40, 40));

		// Test for w 0 < maxLP- currentLP < step
		assertEquals(40, rb.calculateRecovery(39, 40));

		// foe step < maxLP – currentLP
		assertEquals(38, rb.calculateRecovery(35, 40));

		// Test for currentLP = 0
		assertEquals(0, rb.calculateRecovery(0, 40));

	}

}
