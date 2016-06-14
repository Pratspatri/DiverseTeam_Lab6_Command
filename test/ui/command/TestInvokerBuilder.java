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

	@Test
	public void test() {

		LifeForm life = new MockLifeForm("Bob",60);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		assertTrue(in.MoveCm instanceof MoveCommand);
		
		assertTrue(in.DropCm instanceof DropCommand);
		
		
		assertTrue(in.AcquireCm instanceof AcquireCommand);
		
		assertTrue(in.TurnEastCm instanceof TurnEastCommand);
		
		assertTrue(in.TurnWestCm instanceof TurnWestCommand);

		assertTrue(in.TurnNourthCm instanceof TurnNorthCommand);
		
		assertTrue(in.TurnSouthCm instanceof TurnSouthCommand);
		
		assertTrue(in.reloadCm instanceof ReloadCommand);
		
		

		
		
	}


	 
	}

