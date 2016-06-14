package ui.command;


import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import ui.command.Invoker;
import ui.command.InvokerBuilder;


public class TestInvokerBuilder {

	@Test
	public void test() {
		LifeForm life = new MockLifeForm("Bob",60);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		assertTrue(in.MoveCm instanceof MoveCommand);
		//......
		assertTrue(in.DropCm instanceof DropCommand);
	}

}
