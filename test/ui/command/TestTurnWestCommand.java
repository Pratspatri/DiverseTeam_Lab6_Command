package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Test the TurnWestCommand Class.
 * @author Jixiang Lu
 *
 */
public class TestTurnWestCommand 
{
	/**
	 * Test initialization and execute method.
	 */
	@Test
	public void testInitializationAndExecute() {
		LifeForm life = new MockLifeForm("Bob",60);
		life.setDirection("South");
		Command turnNorth = new TurnWestCommand(life);
		assertTrue(turnNorth instanceof Command);
		String infor = turnNorth.execute();
		assertEquals(0,life.getDirection().compareToIgnoreCase("West"));
		assertEquals(infor,"Turn West!");
		
	}
}
