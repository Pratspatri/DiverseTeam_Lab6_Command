/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;

import static org.junit.Assert.*;

import exceptions.MyNewException;
import gameplay.SimpleTimer;


import org.junit.Test;

import environment.Environment;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
/**
 *  Tests the functionality provided by the Alien class   
 */
public class TestAlien 
{
	/**
	 * Test the max speed for any Alien is 2
	 */
	@Test
	public void testDefultMaxSpeed() 
	{ 
		
		 Alien a1 = new Alien("Bob", 40);
		 assertEquals(2,a1.getMaxSpeed());
	}
	
	
	
	
	
	//All these test bellow for observer code
/**
 * To check default attack
 */
	@Test
	public void testAttacDefult() throws MyNewException
	{ 
		// Constructor 1
		 Alien a1 = new Alien("Bob", 40); 
		 assertEquals(10,a1.getAttack());
		 
		// Constructor 2
		Alien a2= new Alien("Bob",40,new RecoveryLinear(5),1);
		assertEquals(10,a2.getAttack());
	}
	/**
	 * to test set recovery rate in constructor
	 */
	@Test
	public void steRecoveryRateInConstructor() throws MyNewException 
	{
		Alien a2= new Alien("Bob",40,new RecoveryLinear(5),1);
		assertEquals(1,a2.getRecoveryRate());
	}
	/**
	 * to test Set Recovery Rate
	 */
	@Test
	public void testSetRecoveryRate() throws MyNewException
	{
		Alien a1= new Alien("Bob",40,new RecoveryLinear(5),2);
		a1.setRecoveryRate(10);
		assertEquals(10,a1.getRecoveryRate());
	}
	/**
	 * To test recovery rate in different saturation
	 */
	@Test
	public void testRecoveryRate() throws MyNewException
	{
		//rate=0
		Alien a4= new Alien("Bob",40,new RecoveryLinear(5),0);
		a4.takeHit(20);
		SimpleTimer st3= new SimpleTimer();
		st3.addTimeObserver(a4);
		st3.setRound(16);
		st3.timeChanged();
		assertEquals(a4.time,st3.getRound());
		a4.recover();
		assertEquals(20,a4.currentLifePoints);
		
		//rate>0 and test removeObserver
		Alien a1= new Alien("Bob",40,new RecoveryLinear(5),2);
		a1.takeHit(20);
		SimpleTimer st= new SimpleTimer();
		st.addTimeObserver(a1);
		st.setRound(2);
		st.timeChanged();
		assertEquals(a1.time,st.getRound());
		a1.recover();
		assertEquals(25,a1.currentLifePoints);
		//removeobserv
		st.removeTimeObserver(a1);
		st.setRound(4);
		st.timeChanged();
		assertEquals(25,a1.currentLifePoints);
	
		//different 2
		// first
		Alien a2= new Alien("Bob",40,new RecoveryLinear(5),3);
		a2.takeHit(20);
		SimpleTimer st1= new SimpleTimer();
		st1.addTimeObserver(a2);
		st1.setRound(6);
		st1.timeChanged();
		assertEquals(a2.time,st1.getRound());
		a2.recover();
		assertEquals(25,a2.currentLifePoints);
		//second
		Alien a3= new Alien("Bob",40,new RecoveryLinear(5),4);
		a3.takeHit(20);
		SimpleTimer st2= new SimpleTimer();
		st2.addTimeObserver(a3);
		st2.setRound(16);
		st2.timeChanged();
		assertEquals(a3.time,st2.getRound());
		a3.recover();
		assertEquals(25,a3.currentLifePoints);
	}
	/**
	 * Do not allow to create object when recovery rate <0
	 */
	@Test(expected = MyNewException.class)
	public void testNigtevrecoveryRate() throws MyNewException
	{ 
		// should fails because there is no object's with name bob
		// because it is recovery rate < 0
		Alien a1= new Alien("Bob",40,new RecoveryLinear(5),-1);
		assertEquals("Bob",a1.getName());
	}
	
	@Test
	public void testTakeDamage() throws MyNewException
	{
		//non
		Alien a1= new Alien ("Bob",40);
		Alien a2= new Alien ("fred",20);
		Environment.getWorldInstance().addLifeForm(2, 0, a1);
		Environment.getWorldInstance().addLifeForm(2, 1, a2);
		a1.attack(a2);
		assertEquals(10,a2.getCurrentLifePoints());
        //the dead do not attack
		Alien a3= new Alien ("Bob",0);
		Environment.getWorldInstance().addLifeForm(2, 2, a3);
		a3.attack(a1);
		assertEquals(40,a1.getCurrentLifePoints());
		
		
	}
	//All these test bellow for Strategy Pattern

	@Test
	public void testInitialization() throws MyNewException 
	{
		// RecoveryNone
		Alien a= new Alien ("Bob",40);
		assertTrue(a instanceof Alien);
		
		// RecoveryLinear
		Alien a1= new Alien ("Bob",40,new RecoveryLinear(5),3);
		assertTrue(a1 instanceof Alien);
		
		// RecoveryFractional
        Alien a2= new Alien ("Bob",40,new RecoveryFractional(.1),5);
		assertTrue(a2 instanceof Alien);
	}
	/**
	   * When a Alien is created, it should know its name,how   
	   * many life points it has,and if there is recovery or not.Also,
      * test recover when recover Alien after take hit.    
     **/
 
	@Test
	public void testAlien() throws MyNewException 
	{
		//create Alien instance without recovery
		Alien a= new Alien ("Bob",40);
		a.takeHit(20);
		a.recover();
		assertEquals(20,a.currentLifePoints);
		
		//create Alien instance with out recovery linear
		Alien a2=new Alien("Bob",40,new RecoveryLinear(5),1);
		a2.takeHit(20);
		//System.out.println(a2.getCurrentLifePoints());

		a2.recover();
		//System.out.println(a2.getCurrentLifePoints());
		assertEquals(25,a2.getCurrentLifePoints());
		
		//create Alien instance with out recovery fractional
		Alien a3=new Alien("Bob",40,new RecoveryFractional(.5),4);
		a3.takeHit(20);
		a3.recover();
		assertEquals(30,a3.getCurrentLifePoints());
		
	}

}
