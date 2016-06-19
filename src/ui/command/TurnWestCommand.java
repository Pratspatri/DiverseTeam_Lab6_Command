package ui.command;

import lifeform.LifeForm;

/**
 * The class represents a Command. It is used to turn the LifeForm towards West.
 * @author Jixiang Lu
 *
 */
public class TurnWestCommand implements Command
{
	private LifeForm life;
	
	/**
	 * Construct a TurnWestCommand.
	 * @param life the LifeForm will be manipulate.
	 */
	public TurnWestCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Execute the Command.
	 */
	@Override
	public String execute() {
		life.setDirection("West");
		return "Turn West!";
		
	}
}
