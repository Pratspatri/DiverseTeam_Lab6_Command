package lifeform;

import environment.Environment;
import gameplay.TimeObserver;
import weapon.Weapon;

/**
 * This class consists members and functions related to LifeForm.
 * New methods @author - Malak Bassam
 * Previous existing files @author : Prathyusha Akshintala
 */
public abstract class LifeForm implements TimeObserver
{
	/**
	 * String to store the name of the LifeForm.
	 */
	private String myName;

	/**
	 * int to store the life points of the LifeForm. It can be accessed by sub
	 * classes.
	 */
	protected int currentLifePoints;

	/**
	 * int to store the strength of the LifeForm.
	 */
	protected int attachStrength;

	/**
	 * Weapon to store the weapon the LifeForm has.
	 */
	private Weapon weapon;
	
	/**
	 * @author - Prathyusha Akshintala
	 * int to track and store row coordinate
	 */
	private int trackRow;
	/**
	 * @author - Prathyusha Akshintala
	 * int to track and store col coordinate
	 */
	private int trackCol;

	/**
	 * Max speed let life form move per round
	 */
	 protected int maxSpeed=0;
	 /**
	  * Set Direction for each life form
	  */
	 protected String direction="North";
	/**
	 * Modified existing method - @author - Prathyusha Akshintala
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points :The current starting life points of the life form.
	 */
	public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = (points >= 0) ? points : 0;
		attachStrength = 0;
		weapon = null;
		trackRow = -1;
		trackCol = -1;
		 maxSpeed=0;
		 direction="North";
	}

	/**
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param strength: The Strength of the LifeForm.
	 */
	public LifeForm(String name, int points, int strength)
	{
		this(name, points);
		this.attachStrength = (strength >= 0) ? strength : 0;
	}

	/**
	 * Returns the name of the LifeForm.
	 * @return the name of the life form.
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * Returns the current life points of a LifeForm.
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints()
	{
		return currentLifePoints;
	}

	/**
	 * Reduces the damage from current life points.
	 * @param damage : specifies the damage to the LifeForm.
	 */
	public void takeHit(int damage)
	{
		if (damage > 0)
		{
			currentLifePoints -= damage;
			currentLifePoints = (currentLifePoints >= 0) ? currentLifePoints : 0;
		}
	}

	/**
	 * Returns the strength of a LifeForm.
	 * @return the strength the life form has.
	 */
	public int getAttachStrength()
	{
		return attachStrength;
	}

	/**
	 * Modified existing method @author - Prathyusha Akshintala
	 * Used to attack a LifeForm.
	 * lifeForm1.attack(lifeForm2).
	 * lifeForm1:attacker.
	 * lifeForm2:attacked.
	 * @param lifeForm2 : It is attached by the calling LifeForm.
	 */
	public void attack(LifeForm lifeForm2)
	{
		Environment environ = Environment.getWorldInstance();
		int distance = environ.getDistance(this, lifeForm2);
		if (getCurrentLifePoints() > 0)
		{
			if (weapon == null || weapon.getActualAmmo() == 0)
			{
				if (distance <= 10)
				{
					lifeForm2.takeHit(getAttachStrength());
				}
			}
			else
			{
				lifeForm2.takeHit(weapon.fire(distance));
			}
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * It performs nothing in here.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
	}

	/**
	 * Pickup the Weapon.
	 * @param weapon : The weapon to be picked up.
	 */
	public void pickUp(Weapon weapon)
	{
		if (this.weapon == null)
		{
			this.weapon = weapon;
		}
	}

	/**
	 * @return the weapon the LifeForm has.
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * Drops the weapon the LifeForm has.
	 */
	public void dropWeapon()
	{
		weapon = null;
	}

	/**
	 * Reloads the weapon the lifeForm has.
	 */
	public void reload()
	{
		weapon.relod();
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Sets the locale with respect to coordinates
	 * @param row
	 * @param col
	 */
	public void setLocaleXY(int row, int col) 
	{
		this.trackRow = row;
		this.trackCol = col;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Removes and resets the location given with respect to coordinates
	 */
	public void removeLocaleXY() 
	{
		this.trackRow = -1;
		this.trackCol = -1;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * @return - the row coordinate
	 */
	public int getRowTrack() 
	{
		return this.trackRow;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * @return - the col coordinate
	 */
	public int getColTrack() 
	{
		return this.trackCol;
	}
	
	/**
	 * @author - Malak Bassam
	 * Change the direction for life form
	 * @param direction
	 */
	  public void setDirection(String direction)
	  {
		  this.direction=direction;
	  }
	  
	  /**
	   *  @author - Malak Bassam
	   * get Direction for any life form
	   * @return  direction 
	   */
	  public String getDirection()
	  {
		  return direction;
	  }
	  
	  /**
	   * @author - Malak Bassam
	   * Set Max speed which how fast should life form move per round
	   * @param maxSpeed
	   */
	  public void setMaxSpeed(int maxSpeed)
	  {
		  this.maxSpeed=maxSpeed;
	  }
	  
	  /**
	   * @author - Malak Bassam
	   * get max speed
	   * @return
	   */
	  public int getMaxSpeed()
	  {
		  return maxSpeed;
	  }
	  
	  /**
	   * Gets the number of Cell that the LifeForm can attach other LifeForm through.
	   * @author Jixiang Lu
	   * @return
	   */
	  public int getAttachDistance()
	  {
		  return (weapon==null)?0:weapon.getMaxRange()/5;
	  }
}
