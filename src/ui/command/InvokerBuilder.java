package ui.command;

import lifeform.LifeForm;

public class InvokerBuilder {
	/**
	 * get Invoker method 
	 * @param life
	 * @return invoker 
	 * @author Saad
	 */
	
	public Invoker getInvoker(LifeForm life)
	{
		Invoker invoker = new Invoker();
		
		invoker.setRelaod(new ReloadCommand(life)); 
		invoker.setAcquire(new AcquireCommand(life));
		invoker.setDrop(new DropCommand(life));
		invoker.setTurnEast(new TurnEastCommand(life));
		invoker.setTurnNorth(new TurnNorthCommand(life));
		invoker.setTurnSouth(new TurnSouthCommand(life));
		invoker.setTurnWest(new TurnWestCommand(life)); 
		invoker.setMove(new MoveCommand(life));
		invoker.setAttack(new AttackCommand(life));
		return invoker ; 
	}

}
