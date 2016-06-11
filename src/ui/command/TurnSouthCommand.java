package ui.command;

import lifeform.LifeForm;

public class TurnSouthCommand implements Command
{
private LifeForm life;
	
	public TurnSouthCommand(LifeForm life)
	{
		this.life = life;
	}
	
	@Override
	public String execute() {
		life.setDirection("South");
		return "Turn South!";
		
	}
}
