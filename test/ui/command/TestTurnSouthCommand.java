package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Test the TurnSouthCommand Class.
 * @author Jixiang Lu
 *
 */
public class TestTurnSouthCommand {

	/**
	 * Test initialization and execute method.
	 */
	@Test
	public void testInitializationAndExecute() {
		LifeForm life = new MockLifeForm("Bob",60);
		life.setDirection("Nouth");
		Command turnNorth = new TurnSouthCommand(life);
		assertTrue(turnNorth instanceof Command);
		String infor = turnNorth.execute();
		assertEquals(0,life.getDirection().compareToIgnoreCase("south"));
		assertEquals(infor,"Turn South!");
		
	}

}
