package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the RecoveryFractional class.
 * @author : Sameer Kumar Kotra
 */
public class TestRecoveryFractional
{

	/**
	 * Test the calculateRecovery of RecoveryFractional.
	 */
	@Test
	public void testRecovery()
	{
		RecoveryBehavior rb = new RecoveryFractional(.1);

		// Test for currentLP = maxLP
		assertEquals(40, rb.calculateRecovery(40, 40));

		// Test for w 0 < maxLP- currentLP < step
		assertEquals(40, rb.calculateRecovery(39, 40));

		// foe step < maxLP – currentLP
		assertEquals(39, rb.calculateRecovery(35, 40));

		// Test for currentLP = 0
		assertEquals(0, rb.calculateRecovery(0, 40));

	}

}
