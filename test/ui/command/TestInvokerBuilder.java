package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Test;
import ui.command.Invoker;
import ui.command.InvokerBuilder;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Test;

import lifeform.MockLifeForm;


public class TestInvokerBuilder {

	/**
	 * Test if each commands attached to each receiver 
	 */
	@Test
	public void test() {
		
		

		LifeForm life = new MockLifeForm("Bob",60);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		
		/**
		 * Test move command
		 */
		assertTrue(in.MoveCm instanceof MoveCommand);
		/**
		 * Test drop command
		 */
		
		assertTrue(in.DropCm instanceof DropCommand);
		/**
		 * Test Acquire command
		 */
		
		assertTrue(in.AcquireCm instanceof AcquireCommand);
		/**
		 * Test turn East command
		 */
		
		assertTrue(in.TurnEastCm instanceof TurnEastCommand);
		/**
		 * Test turn West command
		 */
		
		assertTrue(in.TurnWestCm instanceof TurnWestCommand);
		/**
		 * Test turn north command
		 */

		assertTrue(in.TurnNourthCm instanceof TurnNorthCommand);
		/**
		 * Test turn South command
		 */
		
		assertTrue(in.TurnSouthCm instanceof TurnSouthCommand);
		/**
		 * Test reload command
		 */
		
		assertTrue(in.reloadCm instanceof ReloadCommand);
		/**
		 * Test attack command
		 */
		
		assertTrue(in.AttackCm instanceof AttackCommand);
		
		

		
		
	}


	 
	}

