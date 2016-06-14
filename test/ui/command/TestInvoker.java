 package ui.command;

import static org.junit.Assert.*; 
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;
import environment.Environment;

public class TestInvoker 
{
	
	/**
	 * Invoker Class tests 
	 * @author Saad
	 */
	
	
	
	
	/**
	 * This method tests that clicking north button will attached 
	 * the correct command 
	 */
	@Test
	public void testButtonClickNorthcommand()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(3, 3, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		life.setMaxSpeed(1);
		/**
		 * What north.doclick() does is set the Direction ("North")
		 * Now the row is 3 and when it turns to north will be -1
		 * So the expected result is 2 
		 */
		in.north.doClick();
		in.move.doClick();
		assertEquals(life,env.getLifeForm(2, 3));
	
	}
	
	/**
	 * This method tests that clicking South button will attached 
	 * the correct command 
	 */
	@Test
	public void testButtonClickSouthcommand()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(3, 3, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		life.setMaxSpeed(1);
		/**
		 * What south.doclick() does is set the Direction ("South")
		 * Now the row is 3 and when it turns to South will be +1
		 * So the expected result is 4
		 */
		in.south.doClick();
		in.move.doClick();
		assertEquals(life,env.getLifeForm(4, 3));
	
	}
	
	/**
	 * This method tests that clicking East button will attached 
	 * the correct command 
	 */
	@Test
	public void testButtonClickEastCommand()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(3, 3, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		life.setMaxSpeed(1);
		
		/**
		 * What east.doclick() does is to set the Direction ("East")
		 * Now the column is 3 and when it turns to East will be +1
		 * So the expected result is 4
		 */
		in.east.doClick();
		in.move.doClick();
		assertEquals(life,env.getLifeForm(3, 4));
	
	}
	
	/**
	 * This method tests that clicking West button will attached 
	 * the correct command 
	 */
	@Test
	public void testButtonClickWestCommand()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(3, 3, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		life.setMaxSpeed(1);
		/**
		 * What east.doclick() does is set the Direction ("West")
		 * Now the column is 3 and when it turns to West will be -1
		 * So the expected result is 2
		 */
		
		in.west.doClick();
		in.move.doClick();
		assertEquals(life,env.getLifeForm(3, 2));
	}
	
	/**
	 * This method tests that clicking Aquire and Drop buttons will attached 
	 * the correct commands
	 */


	@Test
	public void testButtonClickAquireandDropCommand()
	{
		
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(2, 2, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		
		Weapon wp = new MockGenericWeapon(50,12,5,5); 
	    env.addWeapon(2, 2, wp, 1);
		in.acquire.doClick();
		assertEquals(wp,life.getWeapon());
		assertNull(env.getWeapon(2, 2, 1));
			
	    in.drop.doClick();
		assertNull(life.getWeapon());
		assertEquals(wp,env.getWeapon(2, 2, 1));
				
		
	}
	
	

}
