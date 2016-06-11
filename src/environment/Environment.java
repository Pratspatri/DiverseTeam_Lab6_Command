package environment;

import weapon.Weapon;
import lifeform.LifeForm;

/**
 * This class consists members and functions related to Environment. New
 * methods @author - Malak Bassam Previous existing file @author : Prathyusha
 * Akshintala
 */
public class Environment 
{

	private Cell cells[][];
	private static Environment theWorld;

	/**
	 * @author - Prathyusha Akshintala Create an instance of Environment which
	 *         has the given number of rows and Columns to store Cells - Since
	 *         this is Singleton pattern we make the constructor private
	 * @param row:
	 *            Number of rows
	 * @param col
	 *            :Number of columns.
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
	 * 
	 * @return the LifeForm at specified location.
	 */
	public LifeForm getLifeForm(int row, int col) 
	{
		if (row < cells.length && col < cells[row].length) 
		{
			return cells[row][col].getLifeForm();
		} else {
			return null;
		}
	}

	/**
	 * Modified existing method - @author - Prathyusha Akshintala Adds the
	 * LifeForm to the Cell at cells[row][col]. Will not add if the row and
	 * column are invalid or if LifeForm already in the Cell.
	 * 
	 * @param row:
	 *            Row at which LifieForm to be added.
	 * @param col:
	 *            column at which LifieForm to be added.
	 * @param entity:
	 *            LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row < cells.length && col < cells[row].length) 
		{
			entity.setLocaleXY(row, col);
			return cells[row][col].addLifeForm(entity);
		} else 
		{
			return false;
		}
	}

	/**
	 * Modified existing method - @author - Malak Bassam Removes the LifeForm at
	 * the cells[row][col].
	 * 
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm(int row, int col) 
	{
		if (row < cells.length && col < cells[row].length)
		{
			LifeForm temp = cells[row][col].removeLifeForm();
			if (temp != null) {
				temp.removeLocaleXY();
			}
			return temp;
		} else 
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
			theWorld = new Environment(8, 8);
		}
		return theWorld;
	}

	/**
	 * @author - Prathyusha Akshintala To reset the instance - needed to clear
	 *         information from the Singleton Environment
	 */
	public static void resetInstance() 
	{
		theWorld = null;
	}

	/**
	 * @author - Prathyusha Akshintala Method to add a weapon at the given
	 *         location at a particular postion (either 1 or 2).
	 */
	public boolean addWeapon(int row, int col, Weapon weapon, int position) 
	{
		if (row < cells.length && col < cells[row].length) {
			return cells[row][col].addWeapon(weapon, position);
		} else 
		{
			return false;
		}
	}

	/**
	 * @author - Prathyusha Akshintala Method to remove a weapon at the given
	 *         location from a position.
	 */
	public Weapon removeWeapon(int row, int col, int position) 
	{
		if (row < cells.length && col < cells[row].length) 
		{
			return (cells[row][col].removeWeapon(position));
		} else 
		{
			return null;
		}
	}
	/**
	 * @author - Prathyusha Akshintala Method to get a weapon at the given
	 *         location from a position.
	 */
	/*
	 * public Weapon getWeapon(int row, int col, int position) { if (row <
	 * cells.length && col < cells[row].length) { return
	 * (cells[row][col].getWeapon(position)); } else { return null; } }
	 */

	/**
	 * @author - Prathyusha Akshintala Method to get distance between two
	 *         LifeForms.
	 */
	public int getDistance(LifeForm lifeform1, LifeForm lifeform2) 
	{
		if (lifeform1.getRowTrack() != -1 && lifeform1.getColTrack() != -1 && lifeform2.getRowTrack() != -1
				&& lifeform2.getColTrack() != -1)
		{
			double temp = Math.pow((lifeform2.getRowTrack() - lifeform1.getRowTrack()), 2);
			temp += Math.pow((lifeform2.getColTrack() - lifeform1.getColTrack()), 2);
			temp = Math.sqrt(temp);
			temp *= 5;
			return (int) temp;
		}
		return -1;
	}

	/**
	 * Gets the Weapon[postion] at cell[row][col]. If there is no Weapon, return
	 * null.
	 * 
	 * @author Jixiang Lu
	 * @param row
	 *            the row of the Cells
	 * @param col
	 *            the column of the Cells
	 * @param position
	 *            the position of Weapon in the Cell
	 * @return the Weapon[positon] at this Cell, otherwise return null
	 */
	public Weapon getWeapon(int row, int col, int position) 
	{
		try
		{
			return cells[row][col].getWeapon(position);
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return null;
		}
	}

	/**
	 * Gets the number of row.
	 * 
	 * @author Jixiang Lu
	 * @return the number of row
	 */
	public int getNumberOfRow()
	{
		return cells.length;
	}
	
	/**
	 * Gets the number of column.
	 * 
	 * @author Jixiang Lu
	 * @return the number of column 
	 */
	public int getNumberOfCol()
	{
		return cells[0].length;
	}

	/**
	 * Used as reference for Malak only.---Jixiang Lu
	 * If you want to delete this method, please let me know.
	 * And I will change my moveCommand class. If you think it is good,
	 * please add @author forYourName in this method
	 * @param life
	 * @return
	 */
	public boolean moveTemp(int row, int col)
	{
		LifeForm movedLife = cells[row][col].getLifeForm(); 
		if(movedLife!=null)
		{
			
			if(movedLife.getDirection().compareToIgnoreCase("North")==0)
			{
				
				int currentRow =row;
				int aboveRow = currentRow-1;
				for(int i = 0; i<movedLife.getMaxSpeed();i++)
				{
					if(aboveRow>=0&&cells[aboveRow][col].getLifeForm()==null)
					{
						removeLifeForm(currentRow,col);
						addLifeForm(aboveRow,col,movedLife);
						currentRow = aboveRow;
					}
					aboveRow -= 1;
				}
				return !(currentRow == row);
			}
			else if(movedLife.getDirection().compareToIgnoreCase("South")==0)
			{
				int currentRow =row;
				int underRow = currentRow+1;
				for(int i = 0; i<movedLife.getMaxSpeed();i++)
				{
					if(underRow>=0&&cells[underRow][col].getLifeForm()==null)
					{
						removeLifeForm(currentRow,col);
						addLifeForm(underRow,col,movedLife);
						currentRow = underRow;
					}
					underRow += 1;
				}
				return !(currentRow == row);
			}
			else if(movedLife.getDirection().compareToIgnoreCase("East")==0)
			{
				int currentCol =col;
				int rightCol = currentCol+1;
				for(int i = 0; i<movedLife.getMaxSpeed();i++)
				{
					if(rightCol>=0&&cells[row][rightCol].getLifeForm()==null)
					{
						removeLifeForm(row,currentCol);
						addLifeForm(row,rightCol,movedLife);
						currentCol = rightCol;
					}
					rightCol += 1;
				}
				return !(currentCol == col);
			}
			else if(movedLife.getDirection().compareToIgnoreCase("West")==0)
			{
				int currentCol =col;
				int leftCol = currentCol-1;
				for(int i = 0; i<movedLife.getMaxSpeed();i++)
				{
					if(leftCol>=0&&cells[row][leftCol].getLifeForm()==null)
					{
						removeLifeForm(row,currentCol);
						addLifeForm(row,leftCol,movedLife);
						currentCol = leftCol;
					}
					leftCol -= 1;
				}
				return !(currentCol == col);
			}
			else
			{
				return false;
			}
		}
		else
			return false;
		
	}
	


	/**
	 * @author Malak Bassam Search for lifeform Return the life form if it
	 *         exists Return Null if does not exist
	 */
	public int[] getLocation(LifeForm a) 
	{
		int[] location = null;
		outerloop: for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) {
				if (cells[i][j].getLifeForm() == a) 
				{
					location = new int[2];
					location[0] = i;
					location[1] = j;
					break outerloop;
				}
			} // inner loop
		} // outer loop

		return location;
	}

	/**
	 * Move the lifeform to different direction North,East,South,and West, based
	 * on the direction of the lifeform Human moves 3 clels per the round,
	 * whereas Alien moves 2 cells per the round
	 */
	public void move(LifeForm life) 
	{
		int[] location = getLocation(life);
		int sum = 0, temp = 0, i, width = 8, high = 8;
		if (location != null) {
			if (life.getDirection().compareToIgnoreCase("North") == 0 && (location[0] >= 1)) 
			{ // Alien
				temp = location[0];
				if (life.getMaxSpeed() == 2)
				{
					sum = location[0] - 2;
					if (sum < width && sum < 0) 
					{
						sum += Math.abs(sum);
						location[0] = sum;
					} else {
						location[0] = sum;
					}
					if (cells[location[0]][location[1]].getLifeForm() == null) 
					{

						removeLifeForm(temp, location[1]);
						addLifeForm(location[0], location[1], life);
					} else {
						for (i = 1; i < width && i <= temp; i++) 
						{
							if (cells[location[0] + i][location[1]].getLifeForm() == null)
							{
								removeLifeForm(temp, location[1]);
								addLifeForm(location[0] + i, location[1], life);

								break;
							}

						} // end for
					} // end else

				} // end Alien
				else {
					if (life.getMaxSpeed() == 3) 
					{
						sum = location[0] - 3;
						if (sum < width && sum < 0) 
						{
							sum += Math.abs(sum);
							location[0] = sum;
						} else 
						{
							location[0] = sum;
						}
						if (cells[location[0]][location[1]].getLifeForm() == null) 
						{
							removeLifeForm(temp, location[1]);
							addLifeForm(location[0], location[1], life);

						} else 
						{
							for (i = 1; i < width && i <= temp; i++) 
							{

								if (getLifeForm(location[0] + i, location[1]) == null) {
									removeLifeForm(temp, location[1]);
									addLifeForm(location[0] + i, location[1], life);
									break;
								}

							} // end for

						} // end else
					} // end Human
				}
			} // end North if
			if (life.getDirection().compareToIgnoreCase("East") == 0 && (location[1] < high)) 
			{ // Alien
				temp = life.getColTrack();
				if (life.getMaxSpeed() == 2)
				{
					sum = location[1] + 2;
					if (sum >= high) 
					{
						sum = high - 1;
						location[1] = sum;
					} else {
						location[1] = sum;
					}
					if (cells[location[0]][location[1]].getLifeForm() == null) 
					{
						removeLifeForm(location[0], temp);
						addLifeForm(location[0], location[1], life);

					} else {
						for (i = 1; i < high && i <= temp; i++) 
						{
							if (cells[location[0]][location[1] - i].getLifeForm() == null) 
							{
								removeLifeForm(location[0], temp);
								addLifeForm(location[0], location[1] - i, life);

								break;
							}

						} // end for
					} // end else

				} // end Alien
				else if (life.getMaxSpeed() == 3) 
				{
					sum = location[1] + 3;
					if (sum >= high) 
					{
						sum = high - 1;
						location[1] = sum;
					} else 
					{
						location[1] = sum;
					}
					if (cells[location[0]][location[1]].getLifeForm() == null) 
					{
						removeLifeForm(location[0], temp);
						addLifeForm(location[0], location[1], life);

					} else {

						for (i = 1; i < high && i <= location[1]; i++)
						{
							if (cells[location[0]][location[1] - i].getLifeForm() == null) {
								removeLifeForm(location[0], temp);
								addLifeForm(location[0], location[1] - i, life);
								break;
							}

						} // end for

					} // end else
				} // end Human
			}
		} // end East if
		if (life.getDirection().compareToIgnoreCase("South") == 0 && (location[0] < width))
		{ // Alien
			temp = location[0];
			if (life.getMaxSpeed() == 2)
			{
				sum = location[0] + 2;
				if (sum > width)
				{
					sum = width - 1;
					location[0] = sum;
				} else 
				{
					location[0] = sum;
				}
				if (cells[location[0]][location[1]].getLifeForm() == null) 
				{
					removeLifeForm(temp, location[1]);
					addLifeForm(location[0], location[1], life);

				} else 
				{
					for (i = 1; i < width && i <= temp; i++) 
					{
						if (cells[location[0] - i][location[1]].getLifeForm() == null) 
						{
							removeLifeForm(temp, location[1]);
							addLifeForm(location[0] - i, location[1], life);

							break;
						}

					} // end for

				} // end else
			} // end Alien
			else {
				if (life.getMaxSpeed() == 3) 
				{
					sum = location[0] + 3;
					if (sum > width)
					{
						sum = width - 1;
						location[0] = sum;
					} else 
					{
						location[0] = sum;
					}
					if (cells[location[0]][location[1]].getLifeForm() == null) 
					{
						removeLifeForm(temp, location[1]);
						addLifeForm(location[0], location[1], life);

					} else 
					{
						for (i = 1; i < width && i <= temp; i++) 
						{

							if (cells[location[0] - i][location[1]].getLifeForm() == null)
							{
								removeLifeForm(temp, location[1]);
								addLifeForm(location[0] - i, location[1], life);

								break;
							}
						} // end for
					} // end else
				} // end Human
			} // if not alien
		} // end South if
		if (life.getDirection().compareToIgnoreCase("West") == 0 && (location[1] >= 1)) 
		{ // Alien
			temp = location[1];
			if (life.getMaxSpeed() == 2) 
			{
				sum = location[1] - 2;
				if (sum < width && sum < 0) 
				{
					sum += Math.abs(sum);
					location[1] = sum;
				} else 
				{
					location[1] = sum;
				}
				if (cells[location[0]][location[1]].getLifeForm() == null)
				{

					removeLifeForm(location[0], temp);
					addLifeForm(location[0], location[1], life);
				} else
				{
					for (i = 1; i < width && i <= temp; i++)
					{
						if (cells[location[0]][location[1] + i].getLifeForm() == null)
						{
							removeLifeForm(location[0], temp);
							addLifeForm(location[0], location[1] + i, life);

							break;
						}
					} // end for
				} // end else
			} // end Alien
			else if (life.getMaxSpeed() == 3) 
			{
				sum = location[1] - 3;
				if (sum < width && sum < 0) 
				{
					sum += Math.abs(sum);
					location[1] = sum;
				} else {
					location[1] = sum;
				}
				if (cells[location[0]][location[1]].getLifeForm() == null)
				{
					removeLifeForm(location[0], temp);
					addLifeForm(location[0], location[1], life);

				} else 
				{
					for (i = 1; i < width && i <= temp; i++)
					{
						if (getLifeForm(location[0], location[1] + i) == null)
						{
							removeLifeForm(location[0], temp);
							addLifeForm(location[0], location[1] + i, life);
							break;
						}
					} // end for

				} // end else

			} // not alien
		} // end West if
	}// end null condition
}