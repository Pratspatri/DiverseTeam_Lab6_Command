/**
 * 
 */
package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the RecoveryNone class.
 * @author : Sameer Kumar Kotra
 */
public class TestRecoveryNone
{

	/**
	 * Test the calculateRecovery of RecoveryNone.
	 */
	@Test
	public void testRecovery()
	{
		RecoveryBehavior rb = new RecoveryNone();

		// Test for currentLP = maxLP
		assertEquals(40, rb.calculateRecovery(40, 40));

		// Test for currentLP < maxLP
		assertEquals(30, rb.calculateRecovery(30, 40));
	}

}
