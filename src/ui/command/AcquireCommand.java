package ui.command;

import lifeform.LifeForm;
import weapon.Weapon;
import environment.Environment;

/**
 * 
 * 
 * @author Jixiang Lu
 *
 */
public class AcquireCommand implements Command
{

	private LifeForm life;
	
	public AcquireCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * 
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

