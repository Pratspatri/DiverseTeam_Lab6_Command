package ui.command;

import lifeform.LifeForm;
import weapon.Weapon;
import environment.Environment;

/**
 * The class represents a Command. It is used to pick up a weapon, but only
 * if one exists in the Cell. If the LifeFor is already holding a weapon, it
 * will swap the old weapon for the new weapon. This command will try to get
 * the weapon in slot 1 first, and if there is no weapon in slot, it will try
 * to get the weapon in slot2.
 * 
 * @author Jixiang Lu
 *
 */
public class AcquireCommand implements Command
{

	private LifeForm life;
	
	/**
	 * Construct an AcquireCommand method with a LifeForm that will be manipulated.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public AcquireCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Executed this Command.
	 */
	@Override
	public String execute()
	{
		Environment env = Environment.getWorldInstance();
		Weapon wp1 = env.getWeapon(life.getRowTrack(), life.getColTrack(), 1);
		Weapon wp2 = env.getWeapon(life.getRowTrack(), life.getColTrack(), 2);
		if(life.getWeapon() == null)
		{
			if(wp1 != null)
			{
				life.pickUp(wp1);
				env.removeWeapon(life.getRowTrack(), life.getColTrack(), 1);
				return "Weapon has been picked up.";
			}
			else if(wp2 != null)
			{
				life.pickUp(wp2);
				env.removeWeapon(life.getRowTrack(), life.getColTrack(), 2);
				return "Weapon has been picked up.";
			}
			else
			{
				return "No Weapon can be picked up.";
			}
		}
		else
		{
			Weapon temp = life.getWeapon();
			if(wp1 != null)
			{
				life.dropWeapon();
				life.pickUp(wp1);
				env.removeWeapon(life.getRowTrack(), life.getColTrack(), 1);
				env.addWeapon(life.getRowTrack(), life.getColTrack(),temp, 1);
				return "Weapon has been picked up.";
			}
			else if(wp2 != null)
			{
				life.dropWeapon();
				life.pickUp(wp2);
				env.removeWeapon(life.getRowTrack(), life.getColTrack(), 2);
				env.addWeapon(life.getRowTrack(), life.getColTrack(), temp,1);
				return "Weapon has been picked up.";
			}
			else
			{
				return "No Weapon can be picked up.";
			}
		}
		
	}

}

