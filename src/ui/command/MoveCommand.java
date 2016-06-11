package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class MoveCommand implements Command
{
	private LifeForm life;
	
	public MoveCommand(LifeForm life)
	{
		this.life = life;
	}

	@Override
	public String execute() 
	{
		Environment env = Environment.getWorldInstance();
		return (env.moveTemp(life.getRowTrack(), life.getColTrack()))?"Move!":"Can't move!";
	}
}
