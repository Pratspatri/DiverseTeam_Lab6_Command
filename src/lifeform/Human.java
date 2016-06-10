/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;
/** 
 * A Human that can hold a LifeForm.   
 */
public class Human extends LifeForm
{
  private int armorPoints;
  /**
   * Constructor that take name and current life points
   *  from LifeForm. Also,it has armor points.
   */
  public Human(String name, int life,int armor)
  {
	  super(name, life,5); 
	  maxSpeed=3;
	  setArmorPoints(armor);
  }
 
  /**
   * @return armor points.
   */
  public int getArmorPoints()
  {
	  return armorPoints;
  }
  /**
   * To update armor points.
   * @param armor
   */
  public void setArmorPoints(int armor)
  {
	  if(armor>=0)
	  {
	  armorPoints= armor;
	  }
	  else
		  armorPoints=0;  
  }
  /**
   * 
   */
	@Override
	public void takeHit(int strength)
  {
		int damage;
		 if (this.armorPoints < strength)
		{
			damage = strength - this.armorPoints;
			this.currentLifePoints = this.currentLifePoints - damage;
			if (this.currentLifePoints < 0)
				super.currentLifePoints = 0;
			
		}
		 else if (this.armorPoints == strength)
		{
			this.currentLifePoints = this.currentLifePoints ;
		}
  }
  
}// end Human class
