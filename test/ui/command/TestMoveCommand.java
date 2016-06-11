package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import environment.Environment;

public class TestMoveCommand 
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
		LifeForm life = new MockLifeForm("Bob",60);
		Command move = new MoveCommand(life);
		assertTrue(move instanceof Command);
		
	}
	
	@Test
	public void testExecute()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		Command move = new MoveCommand(life);
		env.addLifeForm(3, 3, life);
		
		//move North
		life.setDirection("North");
		life.setMaxSpeed(1);
		String infor = move.execute();
		assertEquals(life,env.getLifeForm(2, 3));
		assertEquals(infor,"Move!");
		
		//move South
		life.setDirection("South");
		infor = move.execute();
		assertEquals(life,env.getLifeForm(3, 3));
		assertEquals(infor,"Move!");
		
		//move East
		life.setDirection("East");
		infor = move.execute();
		assertEquals(life,env.getLifeForm(3, 4));
		assertEquals(infor,"Move!");
		
		//move West
		life.setDirection("West");
		infor = move.execute();
		assertEquals(life,env.getLifeForm(3, 3));
		assertEquals(infor,"Move!");
		
		env.removeLifeForm(3, 3);
		env.addLifeForm(0, 0, life);
		//can not move
		infor = move.execute();
		assertEquals(life,env.getLifeForm(0, 0));
		assertEquals(infor,"Can't move!");
		
		
	}

}
