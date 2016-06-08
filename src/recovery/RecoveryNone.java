package recovery;

/**
 * This class RecoveryNone is a type of RecoveryBehaviour.
 * @author : Sameer Kumar Kotra
 */
public class RecoveryNone implements RecoveryBehavior
{

	/**
	 * RecoveryNone there is no recovery for the Alien.
	 * @param currentLife : Current life points.
	 * @param maxLife : Max life points allowed.
	 * @return the recovery points .
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		return currentLife;
	}

}
