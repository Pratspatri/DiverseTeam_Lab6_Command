package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Test TurnNorthCommand Class.
 * @author Jixiang Lu
 *
 */
public class TestTurnNorthCommand {

	/**
	 * Test initialization and execute method.
	 */
	@Test
	public void testInitializationAndExecute() {
		LifeForm life = new MockLifeForm("Bob",60);
		life.setDirection("South");
		Command turnNorth = new TurnNorthCommand(life);
		assertTrue(turnNorth instanceof Command);
		String infor = turnNorth.execute();
		assertEquals(0,life.getDirection().compareToIgnoreCase("North"));
		assertEquals(infor,"Turn North!");
		
	}

}
