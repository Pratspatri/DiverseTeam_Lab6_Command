package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;

/**
 * Test ReloadCommand Class
 * 
 * @author Jixiang Lu
 *
 */

public class TestReloadCommand
{

	/**
	 * Test initialization of ReloadCommand Class and execute() method.
	 * 
	 */
	@Test
	public void testInitializationAndExecute() 
	{
		LifeForm life = new MockLifeForm("Bob",100);
		Weapon wp = new MockGenericWeapon(50,15,2,1);
		life.pickUp(wp);
		Command reload = new ReloadCommand(life);
		//Initialization
		assertTrue(reload instanceof Command);
		assertEquals(1,life.getWeapon().getActualAmmo());
		
		//Weapon shoots
		life.getWeapon().fire(10) ;
		assertEquals(0,life.getWeapon().getActualAmmo());
		
		//Weapon reload.
		String st = reload.execute();
		assertEquals("The Weapon has been reloaded!",st);
		assertEquals(1,life.getWeapon().getActualAmmo());
		
	}
	

}
