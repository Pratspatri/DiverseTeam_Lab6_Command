package ui.command;

import lifeform.LifeForm;

/**
 * The class represents a Command. It is used to turn the LifeForm towards South.
 * @author Jixiang Lu
 *
 */
public class TurnSouthCommand implements Command
{
private LifeForm life;
	
	/**
	 * Construct a TurnSouthCommand.
	 * @param life the LifeForm will be manipulate.
	 */
	public TurnSouthCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Execute the Command.
	 */
	@Override
	public String execute() {
		life.setDirection("South");
		return "Turn South!";
		
	}
}
