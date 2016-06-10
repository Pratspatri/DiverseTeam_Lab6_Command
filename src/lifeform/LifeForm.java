/**
 * Team Members:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;


import environment.Environment;

import exceptions.MyNewException;
import weapon.Weapon;
import gameplay.TimeObserver;

/**
 *  Keeps track of the information associated with a simple 
 *  life form.Also provides the functionality related to the 
 *  life form.   
 */  
public abstract class LifeForm implements TimeObserver
{
	
 protected String myName; 
 protected int currentLifePoints;
 protected int attacks_strength;
 public int time;
 protected Weapon weapon;
 protected int maxSpeed=0;
 protected String direction="North";
 protected int trackRow;
 protected int trackCol;
 /** 
  * Create an instance    
  * @param name the name of the lifeForm   
  * @param points the current starting life points of the life form   
  */  
   public LifeForm(String name,int points, int strength)
   {
	 myName=name;
	 if(points>0)
	 {
	 currentLifePoints=points;
	 }
	 attacks_strength=strength;
	 weapon=null;
   }

  /**
   * Constructor 2
   */
   public LifeForm()
   {
   }
   
 /** 
  * @return the name of the lifeForm.    
  */  
   public String getName()  
   {  
      return myName;  
   }  

/**
 * Return the current lifeForm 
 */
   public int getCurrentLifePoints()  
   {  
     return currentLifePoints;  
   }  
   
   /**
    * Take some points from currentlifePoints.
    */
  public void takeHit(int damage)
  {
	  if(currentLifePoints>damage)
	  {
		  currentLifePoints=currentLifePoints- damage;
	  }
	  else
		  currentLifePoints=0;  
  
  }
  /**
   * Allow one lifeform attacks another either with weapon or not
   * @param attacks_strength
   * @throws MyNewException 
   */
  public void attack(LifeForm lifeform) throws MyNewException
  {  
	  int distance=Environment.getWorldInstance().getDistance(this,lifeform);
	if(this.getCurrentLifePoints() !=0 && lifeform.getCurrentLifePoints()!=0)
	{
		if(distance<=5 && (this.weapon==null || this.weapon.getActualAmmo()==0))
		  {   
		  if(lifeform.currentLifePoints>0)
			  
			 lifeform.takeHit(getAttack());
		  }
		  else if  (this.weapon.getActualAmmo()>0 && distance<=this.weapon.getMaxRange())
		  {
			  lifeform.currentLifePoints=lifeform.currentLifePoints-this.weapon.calculateDamage(distance);
		  }  
	}
	  
  }
  
  /**
   * @return strength 
   */
  public int getAttack()
  {
 return attacks_strength;
  }
  /**
   * To set new value for strength
   */
  public void setAttack(int att)
  {
   this.attacks_strength=att;
  }
  /**
   * To update time
   */
  public void updateTime(int time)
  {
	 this.time=time;
  }
  /**
   * Lifeform can pickup a weapon
   */
  public void pickup(Weapon weap)
  {
 	if(this.weapon==null)
 	{
  this.weapon=weap;
 	}

  }
  /**
   * Lifeform can drop a weapon
   */
  public void drop()
  {
 	this.weapon=null;
  }
  
  public void setLocaleXY(int row, int col) 
	{
		this.trackRow = row;
		this.trackCol = col;
	}
	/**
	 * Removes and resets the location given with respect to coordinates
	 */
	public void removeLocaleXY() 
	{
		this.trackRow = -1;
		this.trackCol = -1;
	}
	/**
	 * @return - the row coordinate
	 */
	public int getRowTrack() 
	{
		return this.trackRow;
	}
	/**
	 * @return - the col coordinate
	 */
	public int getColTrack() 
	{
		return this.trackCol;
	}
 /**
  * Change the direction for Lifeform
  */
  public void setDirection(String direction)
  {
	  this.direction=direction;
  }
  /**
   * Get Direction for lifeform
   * @return
   */
  public String getDirection()
  {
	  return direction;
  }
  /**
   * Set MaxSpeed for life form
   * @param maxSpeed
   */
  public void setMaxSpeed(int maxSpeed)
  {
	  this.maxSpeed=maxSpeed;
  }
  /**
   * Get Max speed for lifeform
   * @return
   */
  public int getMaxSpeed()
  {
	  return maxSpeed;
  }
} // end the class LifeForm


