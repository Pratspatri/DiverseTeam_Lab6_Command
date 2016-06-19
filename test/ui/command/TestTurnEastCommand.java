package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Test the TurnEastCommand Class.
 * @author Jixiang Lu
 *
 */
public class TestTurnEastCommand 
{

	/**
	 * Test initialization and execute method.
	 */
	@Test
	public void testInitializationAndExecute() {
		LifeForm life = new MockLifeForm("Bob",60);
		life.setDirection("South");
		Command turnNorth = new TurnEastCommand(life);
		assertTrue(turnNorth instanceof Command);
		String infor = turnNorth.execute();
		assertEquals(0,life.getDirection().compareToIgnoreCase("East"));
		assertEquals(infor,"Turn East!");
		
	}
}
