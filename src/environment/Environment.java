package environment;

import weapon.Weapon;
import lifeform.LifeForm;

/**
 * This class consists members and functions related to Environment.
 * New methods @author - Prathyusha Akshintala
 * Previous existing file @author : Sameer Kumar Kotra
 */
public class Environment
{

	/**
	 * Array of Cell to store multiple Cells.
	 */
	private Cell cells[][];
	
	/**
	 * @author - Prathyusha Akshintala
	 * Static variable to store one and only instance of environment.
	 */
	private static Environment theWorld;

	/**
	 * @author - Prathyusha Akshintala
	 * Create an instance of Environment which has the given number of rows and
	 * Columns to store Cells - Since this is Singleton pattern we make the constructor private
	 * @param row: Number of rows
	 * @param col :Number of columns.
	 */
	private Environment(int row, int col)
	{
		cells = new Cell[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				cells[i][j] = new Cell();
			}
		}
	}
		
	/**
	 * Returns the Life form at cells[row][col].
	 * @return the LifeForm at specified location.
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return cells[row][col].getLifeForm();
		}
		else
		{
			return null;
		}
	}

	/**
	 * Modified existing method - @author - Prathyusha Akshintala
	 * Adds the LifeForm to the Cell at cells[row][col]. Will not add if the row
	 * and column are invalid or if LifeForm already in the Cell.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row < cells.length && col < cells[row].length)
		{
			entity.setLocaleXY(row,col);
			return cells[row][col].addLifeForm(entity);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Modified existing method - @author - Prathyusha Akshintala
	 * Removes the LifeForm at the cells[row][col].
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if (row < cells.length && col < cells[row].length)
		{
			LifeForm temp = cells[row][col].removeLifeForm();
			if (temp != null)
			{
				temp.removeLocaleXY(); 
			}
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @author - Prathyusha Akshintala
	 * @return - the instance of environment
	 */
	public static Environment getWorldInstance()
	{
		if (theWorld == null)
		{
			theWorld = new Environment (5,5);
		}
		return theWorld;
	}
	
	/**
	 * @author - Prathyusha Akshintala
	 * To reset the instance - needed to clear information from the Singleton Environment
	 */
	public static void resetInstance()
	{
		theWorld = null;
	}
	
	/**
	 * @author - Prathyusha Akshintala
	 * Method to add a weapon at the given location at a particular postion (either 1 or 2).
	 */
	public boolean addWeapon(int row, int col, Weapon weapon, int position)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return cells[row][col].addWeapon(weapon,position);
		}
		else
		{
			return false;
		}
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Method to remove a weapon at the given location from a position.
	 */
	public Weapon removeWeapon(int row, int col, int position)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return (cells[row][col].removeWeapon(position));
		}
		else
		{
			return null;
		}
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Method to get distance between two LifeForms.
	 */
	public int getDistance(LifeForm lifeform1, LifeForm lifeform2)
	{
		if (lifeform1.getRowTrack() != -1 && lifeform1.getColTrack() != -1 && lifeform2.getRowTrack() != -1 && lifeform2.getColTrack() != -1)
		{
			double temp = Math.pow((lifeform2.getRowTrack() - lifeform1.getRowTrack()), 2);
			temp += Math.pow((lifeform2.getColTrack() - lifeform1.getColTrack()), 2);
			temp = Math.sqrt(temp);
			temp *= 5;
			return (int) temp;
		}
		return -1;
	}
}