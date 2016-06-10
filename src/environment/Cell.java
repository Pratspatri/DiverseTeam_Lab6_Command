/**
 *  Name:Malak Basssam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package environment;

import java.util.ArrayList;

import weapon.Weapon;
import lifeform.LifeForm;

/** 
 * A Cell that can hold a LifeForm.   
 */  

public class Cell 
{   

    // Instant of class LifeForm 	
	LifeForm entiry ;
		
	/**
	 * Constructor	
	 */
	public  Cell()
	{
	}
	
	/**
	 * To get the current lifeForm 
	 */
	public LifeForm getLifeForm()
	{
		return entiry;
	}
			
	 /** 
	  * Tries to add the LifeForm to the Cell.  Will not add if a   
	  *  LifeForm is already present.  
	  *  @ return true if the LifeForm was added to the Cell, false otherwise.   
	  */  
	 public boolean addLifeForm(LifeForm lf)
	 {   
		 if(entiry != null)
	       {
		      return false;
		   }
	     else 
	    	 entiry=lf;
	    	 return true;	
	 }
	/**
	 * Tries to remove the LifeForm from the Cell.
	 */
	 public LifeForm removeLifeForm()
	 {      
		  LifeForm temp;
		  temp= entiry;
		  entiry=null;
		  return temp;
	}
		/**
		 * Singleton Pattern
		 */
		ArrayList <Weapon> weapon = new ArrayList<Weapon>() ;
		
		/**
		 * Add weapon to the cell
		 * Each cell have two weapons
		 */
		public void setWeapon(Weapon w1)
		{
			
			if(weapon.size()<2)
			{
			weapon.add(w1);
			}
		}
		/**
		 * Remove the weapon
		 */
		public Weapon removeWeapon(Weapon w1)
		{
			if (weapon.get(0)==w1)
			{
				weapon.remove(0);
			}
			else	if (weapon.get(1)==w1)
			{
				weapon.remove(1);
			}	
			return w1;
		}

		/**
		 * Return all weapons
		 */
		public ArrayList <Weapon> getWeapon() 
		{
			return weapon;
		}
}//end class cell
