package environment;

import weapon.Weapon;
import lifeform.LifeForm;

/**
 * This class consists members and functions related to Cell. Each Cell can hold
 * one life form.
 * New methods @author - Prathyusha Akshintala
 * Previous existing file @author : Sameer Kumar Kotra
 */

public class Cell
{
	/**
	 * LifeForm to store the LifeForm in the cell.
	 */
	private LifeForm entity;
	
	/**
	 * @author - Prathyusha Akshintala
	 * Weapons to store two weapons for a LifeForm.
	 */
	
	private Weapon weapon1, weapon2;

	/**
	 * Create an instance of Cell.
	 */
	public Cell()
	{
		entity = null;
	}

	/**
	 * Adds the LifeForm to the Cell. Will not add if LifeForm already in the
	 * Cell.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (this.entity == null)
		{
			this.entity = entity;
			return true;
		}
		return false;
	}

	/**
	 * Removes the LifeForm from the Cell.
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm()
	{
		if (entity != null)
		{
			LifeForm temp = entity;
			entity = null;
			return temp;
		}
		return null;
	}

	/**
	 * Returns the LifeForm in the Cell.
	 * @return LifeForm present in the Cell.
	 */
	public LifeForm getLifeForm()
	{
		return entity;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Method to get weapon with respect to the position given
	 * @param position
	 * @return
	 */
	public Weapon getWeapon(int position)
	{
		if (0 < position && position < 3)
		{
			if (position == 1)
			{
				return weapon1;
			}
			else if (position == 2)
			{
				return weapon2;
			}
			else
			{
				return null;
			}
		}
		return null;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Method to add weapon to the given position
	 * @param weapon
	 * @param position
	 * @return
	 */
	public boolean addWeapon(Weapon weapon, int position) 
	{
		if ( weapon1 == null && position == 1)
		{
			weapon1 = weapon;
			return true;
		}
		else if (weapon2 == null && position == 2)
		{
			weapon2 = weapon;
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Method to remove Weapon from the position
	 * @author - Prathyusha Akshintala
	 * @param position
	 * @return
	 */
	public Weapon removeWeapon(int position) 
	{
		if (weapon1 != null && position == 1)
		{
			Weapon temp = weapon1;
			weapon1 = null;
			return temp;
		}
		else if (weapon2 != null && position == 2)
		{
			Weapon tempo = weapon2;
			weapon2 = null;
			return tempo;
		}
		else
		{
			return null;
		}
	}
}