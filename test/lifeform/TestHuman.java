/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;
/**
 *  Tests the functionality provided by the Human class   
 */
import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;

public class TestHuman 
{
	/**
	 * Test the max speed for any Human is 3
	 */
	@Test
	public void testDefultMaxSpeed() 
	{ 
		 Human human1 = new Human("Bob", 40,10); 
		 assertEquals(3, human1.getMaxSpeed());
	}
	
	
	//All these test bellow for observer code
	/**
	 * To check for attack as default.
	 */
	@Test
	public void testAttacDefult()
	{ 
		 Human human1 = new Human("Bob", 40,10); 
		 assertEquals(5,human1.getAttack());
	}
	/**
	 * To test the value of ArmorPoints and CurrentLifePoints
	 * in different saturation 
	 * @throws MyNewException 
	 */
	@Test
	public void testtakeHit() throws MyNewException
	{
		// armorPoints>damage
	   
	    Human human1 = new Human("Bob", 40,10);  
	    Human human2 = new Human("fred", 40,15); 
	    Environment.getWorldInstance().addLifeForm(3, 0, human1);
		Environment.getWorldInstance().addLifeForm(4, 0, human2);
		human1.attack(human2);
	    assertEquals(40,human2.getCurrentLifePoints());
		
		//0<armor<damage
	     //	Human human3 = new Human("Bob", 40,10);  
	    //Environment.getWorldInstance().addLifeForm(2, 4, human1);
	    human1.setAttack(20);
		human1.attack(human2);

	   // human3.attack(human4);
	    assertEquals(35,human2.getCurrentLifePoints());

	    //armoe==attac
	    human1.setAttack(15);
		human1.attack(human2);
	    assertEquals(35,human2.getCurrentLifePoints());
    }
	//All these test bellow for Strategy Pattern

	/**
	   * When a Human is created, it should know its name,how   
	   * many life points it has,and armor points.
	   */ 
	@Test
	public void testInitialization()  
	 {  
		Human human ; 
		human = new Human("Bob", 40,5);  
		assertTrue(human instanceof Human);
	    
	 }  
	@Test
	public void testArmor()
	{
		//Test set and get ArmorPoints
		Human human ; 
		human = new Human("Bob", 40,10); 
	    int armor=3;
	    human.setArmorPoints(armor);
	    assertEquals(armor,human.getArmorPoints());
	   
	    // Test border case , when the armor pints is <0
	    human = new Human("Bob", 40,-5);  
	    assertEquals(0,human.getArmorPoints()); 
		
	    //Test border case , when the armor pints is =>0
		human = new Human("Bob", 40,10);  
	    assertEquals(10,human.getArmorPoints()); 
	   
	    
	}
}
