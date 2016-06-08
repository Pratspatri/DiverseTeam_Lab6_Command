package recovery;

/**
 * This class RecoveryLinear is a type of RecoveryBehaviour.
 * @author : Sameer Kumar Kotra
 */
public class RecoveryLinear implements RecoveryBehavior
{
	/**
	 * int to store the step to recovery at each step.
	 */
	private int recoveryLinear;

	/**
	 * Create the RecoveryLinear with given values.
	 * @param step : Step to recovery at each time.
	 */
	public RecoveryLinear(int step)
	{
		recoveryLinear = step;
	}

	/**
	 * RecoveryLinear Alien recovers each a fixed step at each time. Alien does
	 * not recover if it is dead or it has max Life points.
	 * @param currentLife : Current life points.
	 * @param maxLife : Max life points allowed.
	 * @return the recovery points .
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		if (currentLife == 0)
		{
			return 0;
		}
		else
		{
			currentLife += recoveryLinear;
			currentLife = (currentLife <= maxLife) ? currentLife : maxLife;
			return currentLife;
		}
	}

}
