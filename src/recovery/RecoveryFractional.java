package recovery;

/**
 * This class RecoveryFractional is a type of RecoveryBehaviour.
 * @author : Sameer Kumar Kotra
 */
public class RecoveryFractional implements RecoveryBehavior
{

	/**
	 * double to store the percent to recovery at each time.
	 */
	private double percentRecovery;

	/**
	 * Create the RecoveryFractional with given values.
	 * @param recovery : Percent to recover at each time.
	 */
	public RecoveryFractional(double recovery)
	{
		percentRecovery = recovery;
	}

	/**
	 * RecoveryFraactional Alien recovers a percent of the current life points
	 * at each time. Alien does not recover if it is dead or it has max Life
	 * points.
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
			int recovery = (int) Math.ceil(currentLife * percentRecovery);
			currentLife += recovery;
			currentLife = (currentLife <= maxLife) ? currentLife : maxLife;
			return currentLife;
		}
	}

}
