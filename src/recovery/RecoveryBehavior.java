
package recovery;

/**
 * Interface to declare recovery methods.
 * @author Sameer Kumar Kotra
 */
public interface RecoveryBehavior
{
	/**
	 * Calculates the recovery of Alien based on implementation.
	 * @param currentLife : Current life points.
	 * @param maxLife : Max life points allowed.
	 * @return the recovery points .
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}
