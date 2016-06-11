package ui.command;

import lifeform.LifeForm;

public class TurnEastCommand implements Command
{
	private LifeForm life;
	
	public TurnEastCommand(LifeForm life)
	{
		this.life = life;
	}
	
	@Override
	public String execute() {
		life.setDirection("East");
		return "Turn East!";
		
	}
}
