package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;
import environment.Environment;

/**
 * Tests AttackCommand class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestAttackCommand 
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
	
	/**
	 * Tests initialization of AttackCommand Class
	 */
	@Test
	public void testInitialization()
	{
		LifeForm life = new MockLifeForm("Bob",50);
		Command attack = new AttackCommand(life);
		assertTrue(attack instanceof Command);	
	}
	
	/**
	 * Tests execute() method. The LifeForm face north.
	 */
	@Test
	public void testExcuteForNorth()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",50);
		LifeForm target = new MockLifeForm("Luck",60);
		LifeForm lifeBehindTarget = new MockLifeForm("Kit",60);
		Weapon wp = new MockGenericWeapon(50,10,2,2);
		life.pickUp(wp);
		env.addLifeForm(3, 3, life);
		env.addLifeForm(1, 3, target);
		env.addLifeForm(0, 3, lifeBehindTarget);
		life.setDirection("north");
		Command attack = new AttackCommand(life);
		
		//attacked target is in the north of LifeForm within the Maximum range.
		String infor = attack.execute();
		assertEquals(infor,"Attack target!");
		assertEquals(55,target.getCurrentLifePoints());
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attacked target is out of Maximum range.
		env.removeLifeForm(1, 3);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attack wall.
		wp = new MockGenericWeapon(50,30,2,2);
		life.dropWeapon();
		life.pickUp(wp);
		env.removeLifeForm(0, 3);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");	
	}
	
	/**
	 * Tests execute() method. The LifeForm faces south.
	 */
	@Test
	public void testExcuteForSouth()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",50);
		LifeForm target = new MockLifeForm("Luck",60);
		LifeForm lifeBehindTarget = new MockLifeForm("Kit",60);
		Weapon wp = new MockGenericWeapon(50,10,2,2);
		life.pickUp(wp);
		env.addLifeForm(3, 3, life);
		env.addLifeForm(5, 3, target);
		env.addLifeForm(6, 3, lifeBehindTarget);
		life.setDirection("South");
		Command attack = new AttackCommand(life);
		
		//attacked target is in the south of LifeForm within the Maximum range.
		String infor = attack.execute();
		assertEquals(infor,"Attack target!");
		assertEquals(55,target.getCurrentLifePoints());
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attacked target is out of Maximum range.
		env.removeLifeForm(5, 3);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attack wall.
		wp = new MockGenericWeapon(50,100,2,2);
		life.dropWeapon();
		life.pickUp(wp);
		env.removeLifeForm(6, 3);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");	
	}
	
	/**
	 * Tests execute() method. The LifeForm faces east.
	 */
	@Test
	public void testExcuteForEast()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",50);
		LifeForm target = new MockLifeForm("Luck",60);
		LifeForm lifeBehindTarget = new MockLifeForm("Kit",60);
		Weapon wp = new MockGenericWeapon(50,10,2,2);
		life.pickUp(wp);
		env.addLifeForm(3, 3, life);
		env.addLifeForm(3, 5, target);
		env.addLifeForm(3, 6, lifeBehindTarget);
		life.setDirection("East");
		Command attack = new AttackCommand(life);
		
		//attacked target is in the east of LifeForm within the Maximum range.
		String infor = attack.execute();
		assertEquals(infor,"Attack target!");
		assertEquals(55,target.getCurrentLifePoints());
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attacked target is out of Maximum range.
		env.removeLifeForm(3, 5);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attack wall.
		wp = new MockGenericWeapon(50,100,2,2);
		life.dropWeapon();
		life.pickUp(wp);
		env.removeLifeForm(3, 6);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");	
	}
	
	/**
	 * Tests execute() method. The LifeForm faces west.
	 */
	@Test
	public void testExcuteForWest()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",50);
		LifeForm target = new MockLifeForm("Luck",60);
		LifeForm lifeBehindTarget = new MockLifeForm("Kit",60);
		Weapon wp = new MockGenericWeapon(50,10,2,2);
		life.pickUp(wp);
		env.addLifeForm(3, 3, life);
		env.addLifeForm(3, 1, target);
		env.addLifeForm(3, 0, lifeBehindTarget);
		life.setDirection("west");
		Command attack = new AttackCommand(life);
		
		//attacked target is in the east of LifeForm within the Maximum range.
		String infor = attack.execute();
		assertEquals(infor,"Attack target!");
		assertEquals(55,target.getCurrentLifePoints());
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attacked target is out of Maximum range.
		env.removeLifeForm(3, 1);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
		assertEquals(60,lifeBehindTarget.getCurrentLifePoints());
		
		//attack wall.
		wp = new MockGenericWeapon(50,100,2,2);
		life.dropWeapon();
		life.pickUp(wp);
		env.removeLifeForm(3, 0);
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
		
		//direction is error.
		life.setDirection("nothing");
		infor = attack.execute();
		assertEquals(infor,"Can't attack!");
	}
}
