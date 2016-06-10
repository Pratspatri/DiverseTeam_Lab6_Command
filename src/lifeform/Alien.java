/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;

import exceptions.MyNewException;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;
/** 
 * A Alien that can hold a LifeForm.   
 */  
public class Alien extends LifeForm
{
	public int maxLifePoints=super.getCurrentLifePoints();
	protected RecoveryBehavior recoveryBehavior;  
	public  int recovery_rate;
	public int recovery;
	/**
	 * Constructor1	
	 */
	public Alien(String name, int life) 
	{ 
	
		super(name, life,10);
		recovery=0;
		recoveryBehavior= new RecoveryNone();
		maxSpeed=2;
	}
	/**
	 * Constructor2 that is different from 	Constructor1 in 
	 * Constructor2 take recover object.
	 */
	
	public Alien(String name, int life,RecoveryBehavior rb,int recoveryrate ) throws MyNewException 
	{
		super();
		maxSpeed=2;
		if (recoveryrate<0) {    
			throw new MyNewException("The recovery rate must be > or = 0");
	
		}
		if(recoveryrate>=0)
		{   this.myName=name;
		    this.currentLifePoints=life;
		    this.attacks_strength=10;
		    recoveryBehavior= rb;
		    recovery_rate=recoveryrate;
		    maxLifePoints=this.getCurrentLifePoints();
		}
		
		
	}
	public void setRecoveryRate(int rate)
	{
		recovery_rate=rate;
	}
	public int getRecoveryRate()
	{
		return recovery_rate;
	}
	/**
	 * Constructor2 that is different from 	Constructor1 in 
	 * Constructor2 take recover object.
	 */
	
	/**
	 * After the Alien take hit points from its current life points
	 * this method do recovery depend on type of recovery
	 */
    public void recover()
    {
    	if(recovery_rate>0)
    {	
	if(recovery==0 || (super.time%recovery_rate)==0 )
	setCurrentLifePoints(recoveryBehavior.calculateRecovery(this.getCurrentLifePoints(), maxLifePoints));
    	
  }
    }
    
    public void setCurrentLifePoints(int life)
    {
	   this.currentLifePoints=life;
    }

}// end Alien class
