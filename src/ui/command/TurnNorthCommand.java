package ui.command;

import lifeform.LifeForm;

public class TurnNorthCommand implements Command 
{
	private LifeForm life;
	
	public TurnNorthCommand(LifeForm life)
	{
		this.life = life;
	}
	
	@Override
	public String execute() {
		life.setDirection("North");
		return "Turn North!";
		
	}
	

}
