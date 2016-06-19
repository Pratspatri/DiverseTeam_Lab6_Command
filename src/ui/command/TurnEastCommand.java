package ui.command;

import lifeform.LifeForm;

/**
 * The class represents a Command. It is used to turn the LifeForm towards East.
 * @author Jixiang Lu
 *
 */

public class TurnEastCommand implements Command
{
	private LifeForm life;
	
	/**
	 * Construct a TurnEastCommand.
	 * @param life the LifeForm will be manipulate.
	 */
	public TurnEastCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Execute the Command.
	 */
	@Override
	public String execute() {
		life.setDirection("East"); 
		return "Turn East!";
		
	}
}
