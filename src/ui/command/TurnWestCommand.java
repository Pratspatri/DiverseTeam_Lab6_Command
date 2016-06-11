package ui.command;

import lifeform.LifeForm;

public class TurnWestCommand implements Command
{
	private LifeForm life;
	
	public TurnWestCommand(LifeForm life)
	{
		this.life = life;
	}
	
	@Override
	public String execute() {
		life.setDirection("West");
		return "Turn West!";
		
	}
}
