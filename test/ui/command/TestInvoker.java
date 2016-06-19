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
	 * his method tests that clicking move  button will attached the correct command 
	 */
	
	@Test
	public void testMoveCommand()
	{
		Environment env = Environment.getWorldInstance(); 
		LifeForm life = new MockLifeForm("Bob",60);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		// add life Form 
		env.addLifeForm(5, 5, life);
		life.setMaxSpeed(1);
		//move North
		
		/**
		 * What north.doclick() does is set the Direction ("North")
		 * Now the row is 5 and when it turns to north will be -1
		 * So the expected result is 4
		 */ 
		
		in.north.doClick();
		in.move.doClick();
		
		assertEquals(life,env.getLifeForm(4, 5));
		
		/**
		 * What south.doclick() does is set the Direction ("south")
		 * Now the row is 4 and when it turns to north will be +1
		 * So the expected result is 5
		 */ 
		in.south.doClick();
		in.move.doClick();
		
		
		assertEquals(life,env.getLifeForm(5, 5));
	
		
	}
	
	
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
	   /**
	    * Test the Acquire button
	    */
		in.acquire.doClick();
		assertEquals(wp,life.getWeapon());
		assertNull(env.getWeapon(2, 2, 1));
		
		/**
		 * Test the Drop button 
		 */
		
			
	    in.drop.doClick();
		assertNull(life.getWeapon());
		assertEquals(wp,env.getWeapon(2, 2, 1));
				
		
	}
	
	
	/**
	 * This method tests that clicking reload  button will attached 
	 * the correct command
	 */
	@Test
	public void testButtonClickReload()
	{
		
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(2, 2, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		
		Weapon wp = new MockGenericWeapon(50,12,5,5); 
	   life.pickUp(wp);
	   assertEquals(5,life.getWeapon().getActualAmmo());
	   life.getWeapon().fire(10) ;
	   assertEquals(4,life.getWeapon().getActualAmmo());
	   /**
	    * Test The reload Button 
	    */
	   in.reload.doClick();
	   assertEquals(5,life.getWeapon().getActualAmmo());
				
		
	}
	
	/**
	 * This method tests that clicking Attack  button will attached 
	 * the correct command
	 */
	@Test
	public void testButtonClickattack()
	{
		
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		LifeForm target = new MockLifeForm("target", 60);
		env.addLifeForm(2, 2, life);
		env.addLifeForm(2, 1, target);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		
		Weapon wp = new MockGenericWeapon(50,12,5,5); 
		//life pick up the weapon 
	   life.pickUp(wp);
	   /**
	    * Use west button to turn West and attack the target
	    */
	   in.west.doClick();
	   /**
	    * Test Attack button 
	    */
	   in.attack.doClick();
	   /**
	    * expected Result is 55 the life points of the target 
	    */
	   assertEquals(55,target.getCurrentLifePoints());
				
		
	}
	
	
	

}
