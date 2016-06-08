package lifeform;

/**
 * This class consists members and functions related to Human. Human is a
 * LifeForm.
 * @author : Sameer Kumar Kotra
 */
public class Human extends LifeForm
{

	/**
	 * int to store the armour points of the Human.
	 */
	private int armPoints;

	/**
	 * Create an instance of Human with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param armPoints : The armor points of the human.
	 */
	public Human(String name, int points, int armPoints)
	{
		super(name, points);
		this.armPoints = (armPoints >= 0) ? armPoints : 0;
		attachStrength = 5;
	}

	/**
	 * @return the armor points of the Human.
	 */
	public int getArmPoints()
	{
		return armPoints;
	}

	/**
	 * Set the armor points to Human.
	 * @param armPoints : Set the points to armor points if greater than 0.
	 */
	public void setArmPoints(int armPoints)
	{
		this.armPoints = (armPoints >= 0) ? armPoints : 0;
	}

	/**
	 * comments Overrides the method in super class.
	 * Reduces the damage from current life points.
	 * @param damage : specifies the damage to the LifeForm.
	 */
	@Override
	public void takeHit(int damage)
	{
		if (damage > 0)
		{
			damage -= armPoints;
			if (damage > 0)
			{
				currentLifePoints -= damage;
				currentLifePoints = (currentLifePoints >= 0) ? currentLifePoints : 0;
			}
		}
	}
}
