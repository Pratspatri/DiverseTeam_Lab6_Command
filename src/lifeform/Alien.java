
package lifeform;

import exceptions.RecoveryException;
import recovery.RecoveryBehavior;

/**
 * This class consists members and functions related to Alien. Alien is a
 * LifeForm.
 * @author Sameer Kumar Kotra
 */
public class Alien extends LifeForm
{

	/**
	 * int to store max life points of the alien.
	 */
	private int maxLifePoints;

	/**
	 * RecoveryBehaviour to store the recovary behaviour of the alien at run
	 * time.
	 */
	private RecoveryBehavior recoveryBehavior;

	/**
	 * int to store the recovery rate of the Alien.
	 */
	private int recoveryRate;

	/**
	 * Create the instance of the Alien with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 */
	public Alien(String name, int points)
	{
		super(name, points);
		maxLifePoints = currentLifePoints;
		recoveryBehavior = null;
		attachStrength = 10;
	}

	/**
	 * Create the instance of the Alien with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param rb : Recovery behavior of the Alien.
	 */
	public Alien(String name, int points, RecoveryBehavior rb)
	{
		this(name, points);
		recoveryBehavior = rb;
	}

	/**
	 * Create the instance of the Alien with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param rb : Recovery behavior of the Alien.
	 * @param recoveryRate : Rate at with alien recovers.
	 * @throws RecoveryException : If recovery rate is less than 0.
	 */
	public Alien(String name, int points, RecoveryBehavior rb, int recoveryRate) throws RecoveryException
	{
		this(name, points, rb);
		if (recoveryRate >= 0)
		{
			this.recoveryRate = recoveryRate;
		}
		else
		{
			throw new RecoveryException("Recovery Rate can not be less than 0");
		}

	}

	/**
	 * Sets the life point sof the Alien. Used for the recovery of the Alien.
	 * @param lifePoints : New life points to be stored. Stores only if new life
	 *            points is less than the max life points.
	 */
	public void setCurrentLifePoints(int lifePoints)
	{
		if (lifePoints < maxLifePoints)
		{
			currentLifePoints = (lifePoints >= 0) ? lifePoints : 0;
		}
	}

	/**
	 * Recovers the alien based on the recovery behavior stored in it.
	 */
	public void recover()
	{
		if (recoveryBehavior != null)
		{
			int lifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
			setCurrentLifePoints(lifePoints);
		}
	}

	/**
	 * @return the recovery rate of the Alien.
	 */
	public int getRecoveryRate()
	{
		return recoveryRate;
	}

	/**
	 * Set the recovery rate of the alien.
	 * @param recoveryRate : set the recoveryRate to alien recovery rate if
	 *            greater than 0.
	 * @throws RecoveryException : if recovery rate is less than 0.
	 */
	public void setRecoveryRate(int recoveryRate) throws RecoveryException
	{
		if (recoveryRate >= 0)
		{
			this.recoveryRate = recoveryRate;
		}
		else
		{
			throw new RecoveryException("Recovery Rate can not be less than 0");
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
		if (recoveryRate != 0 && (time) % recoveryRate == 0)
		{
			recover();
		}
	}

}
