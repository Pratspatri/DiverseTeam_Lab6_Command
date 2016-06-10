package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;
import environment.Environment;

/**
 * Test AcquireCommand Class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestAcquireCommand
{	
	
	/**
	 * Clear all the LifeForms and Weapons in the Environment before each test. 
	 */
	@Before
	public void resetEnvironmentBefore()
	{
		Environment.resetInstance();
	}
	/**
	 * Clear all the LifeForms and Weapons in the Environment before each test.
	 */
	@After
	public void resetEnvironmentAfter()
	{
		Environment.resetInstance();
	}
	@Test
	public void testInitialization()
	{
		LifeForm life = new MockLifeForm("Bob",100);
		Command acquire = new AcquireCommand(life);
		assertTrue(acquire instanceof Command);
	}
	
	/**
	 * 
	 */
	@Test
	public void testExecute()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",100);
		Command acquire = new AcquireCommand(life);
		env.addLifeForm(0, 0, life);
		
		//LifeForm has no weapon and there is no weapon in the Cell.
		String infor = acquire.execute();
		assertEquals(infor,"No Weapon can be picked up.");
		assertNull(life.getWeapon());
		
		//LifeForm has a weapon and there is no weapon in the Cell.
		Weapon wp = new MockGenericWeapon(15,15,1,2);
		life.pickUp(wp);
		infor = acquire.execute();
		assertEquals(infor,"No Weapon can be picked up.");
		assertEquals(wp,life.getWeapon());
		
		//LifeForm has no weapon and there is one weapon at slot 1.
		life.dropWeapon();
		env.addWeapon(0, 0, wp,1);
		infor = acquire.execute();
		assertEquals(infor,"Weapon has been picked up.");
		assertEquals(life.getWeapon(),wp);
		assertNull(env.getWeapon(0, 0, 0));
		
		//LifeForm has weapon and there is two weapon.
		Weapon wp2 = new MockGenericWeapon(15,15,1,2);
		Weapon wp3 = new MockGenericWeapon(15,15,1,2);
		env.addWeapon(0, 0, wp2,1);
		env.addWeapon(0, 0, wp3,2);
		infor = acquire.execute();
		assertEquals(infor,"Weapon has been picked up.");
		assertEquals(wp2,life.getWeapon());	
		assertEquals(wp,env.getWeapon(0, 0, 1));
		assertEquals(wp3,env.getWeapon(0, 0, 2));
		
		//LifeForm has no Weapon and there is only one in slot2.
		life.dropWeapon();
		env.removeWeapon(0, 0, 1);
		infor = acquire.execute();
		assertEquals(infor,"Weapon has been picked up.");
		assertEquals(wp3,life.getWeapon());	
		assertNull(env.getWeapon(0, 0, 1));
		assertNull(env.getWeapon(0, 0, 2));
		
		//LifeForm has one Weapon and there is only one in slot2.
		env.addWeapon(0, 0, wp, 2);
		infor = acquire.execute();
		assertEquals(infor,"Weapon has been picked up.");
		assertEquals(wp,life.getWeapon());	
		assertEquals(wp3,env.getWeapon(0, 0, 1));
		assertNull(env.getWeapon(0, 0, 2));

		
	}

}
