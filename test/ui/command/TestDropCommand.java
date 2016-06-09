package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Before;
import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;
import environment.Environment;

/**
 * Test DropCommand class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestDropCommand
{

	/**
	 * Clear all the LifeForms and Weapons in the Environment before each test. 
	 */
	@Before
	public void resetEnvironment()
	{
		Environment.resetInstance();
	}
	
	/**
	 * Test DropCommand class initialization.
	 */
	@Test
	public void testInitialization()
	{
		LifeForm life = new MockLifeForm("Bob",100);
		Command drop = new DropCommand(life);
		assertTrue(drop instanceof Command);
	}
	
	/**
	 * Test the execute() method.
	 */
	@Test
	public void testExecute()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",100);
		env.addLifeForm(0, 0, life);
		Command drop = new DropCommand(life);
		
		//LifeForm has no weapon.
		String infor = drop.execute();
		assertEquals("Weapon has benn dropped",infor);
		assertNull(life.getWeapon());
		
		//LifeForm has weapon and there is enough space for the weapon in the Cell.
		Weapon wpCell = new MockGenericWeapon(50,15,1,5);
		Weapon wpLife = new MockGenericWeapon(50,15,1,5);
		env.addWeapon(0, 0, wpCell,1);
		life.pickUp(wpLife);
		infor = drop.execute();
		assertEquals("Weapon has benn dropped",infor);
		assertNull(life.getWeapon());
		assertEquals(wpLife,env.getWeapon(0, 0, 2));

		//There is no space for the Weapon in the Cell.
		Weapon wpLife2 = new MockGenericWeapon(50,15,1,5);
		life.pickUp(wpLife2);
		infor = drop.execute();
		assertEquals("Weapon cannot be dropped.",infor);
		assertEquals(wpLife2,life.getWeapon());
		
	}

}