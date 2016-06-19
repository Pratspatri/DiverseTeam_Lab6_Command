package ui.command;

import lifeform.LifeForm;

/**
 * The class represents a Command. It is used to turn the LifeForm towards North.
 * @author Jixiang Lu
 *
 */
public class TurnNorthCommand implements Command 
{
	private LifeForm life;
	
	/**
	 * Construct a TurnNorthCommand.
	 * @param life the LifeForm will be manipulate.
	 */
	public TurnNorthCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Execute the Command.
	 */
	@Override
	public String execute() {
		life.setDirection("North");
		return "Turn North!";
		
	}
	

}
