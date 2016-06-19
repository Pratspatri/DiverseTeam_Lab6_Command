package ui.command;

import environment.Environment;
import lifeform.LifeForm;

/**
 * The class represents a Command. It will move the LifeForm maxSpeed spaces in the direction it
 * is facing using the movement rules of the Environment.
 * @author Jixiang Lu
 *
 */
public class MoveCommand implements Command
{
	private LifeForm life;
	
	/**
	 * Construct a move Command
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public MoveCommand(LifeForm life)
	{
		this.life = life;
	}

	/**
	 * Executes the MoveCommand base on the movement rules.
	 */
	@Override
	public String execute() 
	{
		Environment env = Environment.getWorldInstance();
		return (env.move(life.getRowTrack(), life.getColTrack()))?"Move!":"Can't move!";
	} 
}
