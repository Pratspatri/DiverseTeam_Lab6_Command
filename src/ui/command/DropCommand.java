package ui.command;

import lifeform.LifeForm;
import weapon.Weapon;
import environment.Environment;

/**
 * The class represents a Command. It is used to drop the weapon the LifeForm is holding.
 * If there is no space for Weapon in the Cell, the LifeForm can't drop the Weapon.
 * 
 * @author Jixiang Lu
 *
 */
public class DropCommand implements Command
{
	private LifeForm life;
	
	/**
	 * Construct a DropCommand.
	 * 
	 * @param life the LifeForm can be manipulated by the Command.
	 */
	public DropCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Drops the Weapon which the LifeForm is holding. If there is no space for Weapon in the 
	 * Cell, the LifeForm can't drop the Weapon.
	 */
	@Override
	public String execute()
	{
		Environment env = Environment.getWorldInstance();
		Weapon slot1 = env. getWeapon(life.getRowTrack(), life.getColTrack() , 1);
		Weapon slot2 = env.getWeapon(life.getRowTrack() , life.getColTrack(), 2);
		if(slot1 != null&& slot2 !=null)
			return "Weapon cannot be dropped.";
		else
		{
			int position = (slot1 == null)?1:2;
			env.addWeapon(life.getRowTrack(), life.getColTrack(), life.getWeapon(),position);
			life.dropWeapon();
			return "Weapon has been dropped";
		}
	}

}