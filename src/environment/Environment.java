/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package environment;

import weapon.Weapon;
import exceptions.MyNewException;
import lifeform.LifeForm;

/**
 * To store a grid of cell instance in array two dimensional
 */
public class Environment 
{
	/**
	 * Singleton Pattern
	 */
	private static Environment theWorld;
	int width, high;
	Cell[][] Cells;

	/**
	 * Private Constructor
	 */
	private Environment(int row, int col) 
	{
		width = row;
		high = col;
		Cells = new Cell[width][high];
		for (int i = 0; i < width; i++) 
		{
			for (int j = 0; j < high; j++) 
			{
				Cells[i][j] = new Cell();
			}
		}
	}

	/**
	 * Create Environment World and return the object
	 */
	public static Environment getWorldInstance()
	{
		if (theWorld == null)
			theWorld = new Environment(5, 5);
		return theWorld;
	}

	/**
	 * Reset the static value, it will be useful in tests
	 */
	static void resetInstance() 
	{
		theWorld = null;
	}

	/**
	 * Add weapon in specific cell Be sure adding a new weapon will be in valid
	 * location
	 */
	public boolean addWeaopn(int row, int col, Weapon weapon) 
	{
		if ((row >= 0 && row < width) && (col >= 0 && col < high))
		{
			Cells[row][col].setWeapon(weapon);
			return true;
		}

		else 
		{
			return false;
		}
	}

	/**
	 * Remove the weapon from specific location
	 */
	public Weapon removeWapon(int row, int col, Weapon weapon)
	{
		if ((row >= 0 && row < width) && (col >= 0 && col < high)) 
		{
			weapon = Cells[row][col].removeWeapon(weapon);
			Cells[row][col] = null;
			return weapon;
		}
		return null;
	}

	/**
	 * Calculate the distance between the lifeforms if the lifeforms in the same
	 * column or same row, get the difference between them and multipleby 5
	 * Otherwise a^2 + b^2=c^2
	 */
	public int getDistance(LifeForm a, LifeForm b) throws MyNewException 
	{
		int result = 0;

		int[] alocation = getLocation(a);
		int[] blocation = getLocation(b);

		int i = 0;
		if (blocation == null || alocation == null) 
		{
			throw new MyNewException("One Of LifeForm does not exist");
		} else
		{
			if (alocation[i] == blocation[i])
			{
				result = 5 * (Math.abs(alocation[i + 1] - blocation[i + 1]));
			}

			else if (alocation[i + 1] == blocation[i + 1]) 
			{
				result = 5 * (Math.abs(alocation[i] - blocation[i]));
			} else
				result = (int) Math.sqrt(Math.pow(Math.abs(alocation[i] - blocation[i]) * 5, 2)
						+ Math.pow(Math.abs(alocation[i + 1] - blocation[i + 1]) * 5, 2));
		}
		return result;
	}

	/**
	 * Search for lifeform Return the life form if it exists Return Null if does
	 * not exist
	 */
	public int[] getLocation(LifeForm a)
	{
		int[] location = null;
		outerloop: for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < high; j++) 
			{
				if (Cells[i][j].getLifeForm() == a)
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
	 * Tries to add the Cell to the Environment. Will not add if the row and col
	 * are invalid or if a LifeForm is already in that Cell. @ return true if
	 * successfully added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row < Cells.length && col < Cells[row].length)
		{
			entity.setLocaleXY(row,col);
			return Cells[row][col].addLifeForm(entity);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Tries to remove the Cell from the Environment.
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if (row < Cells.length && col < Cells[row].length)
		{
			LifeForm temp = Cells[row][col].removeLifeForm();
			if (temp != null)
			{
				temp=null;
			}
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Return lifeform
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if (row < Cells.length && col < Cells[row].length)
		{
			return Cells[row][col].getLifeForm();
		}
		else
		{
			return null;
		}
	}
	/**
	 * Move the lifeform to different direction North,East,South,and West, based
	 * on the direction of the lifeform 
	 * Human moves 3 clels per the round, whereas Alien moves 2 cells per the round
	 */
	public void move(LifeForm life)
	{
		int[] location = getLocation(life);
		int sum=0,temp=0,i;
		if(location != null)
		{
			if(life.getDirection().compareToIgnoreCase("North")== 0 &&(location[0]>=1))
			{       //Alien
				     temp=location[0];
			    	if(life.getMaxSpeed()==2)
			    	{
			    		sum=location[0]-2;
			    		if(sum < width && sum<0)
			    		{
			    			sum+=Math.abs(sum);
			    			 location[0]=sum;
			    		}
			    		else 
			    			{
			    			 location[0]=sum;
			    			}
			    		if(Cells[location[0]][location[1]].getLifeForm() == null)
			    		{   
			    			addLifeForm(location[0],location[1],life);
			    			removeLifeForm(temp,location[1]);
			    		}
 			    		else 
 			    		{
			    			for( i=1;i<width && i<=temp;i++)
 				    		{
 				    			if(Cells[location[0]+i][location[1]].getLifeForm()== null)
 				    			{   
 				    				addLifeForm(location[0]+i,location[1],life);
 				    				removeLifeForm(temp,location[1]);
 					    			break;
 				    			}
 				    				
 				    		}//end for
			    		}//end else
			    		
			    		
			    	}//end Alien
			    	else
			    	{
			    		if(life.getMaxSpeed()==3)
				    	{
				    		sum=location[0]-3;
				    		if(sum < width && sum<0)
				    		{
				    			sum+=Math.abs(sum);
				    			 location[0]=sum;
				    		}
				    		else 
				    			{
				    			 location[0]=sum;
				    			}
				    		if(Cells[location[0]][location[1]].getLifeForm() == null)
				    		{   
				    			addLifeForm(location[0],location[1],life);
				    			removeLifeForm(temp,location[1]);
				    		}
	 			    		else 
	 			    		{
				    			for(i=1;i<=width;i++)
	 				    		{ 
	 				    		   
	 				    			if(getLifeForm(location[0]+i,location[1])== null)
	 				    			{   
	 				    				
	 					    			break;
	 				    			}
	 				    				
	 				    		}//end for
				    			addLifeForm(location[0]+i,location[1],life);
				    				removeLifeForm(temp,location[1]);
				    		}//end else
				    	}//end Human
			    	}
			}// end North if
			if(life.getDirection().compareToIgnoreCase("East")== 0 &&(location[1]<high))
			{       //Alien
				temp=life.getColTrack();
			    	if(life.getMaxSpeed()==2)
			    	{
			    		sum=location[1]+2;
			    		if(sum >= high)
			    		{  
			    			sum=high-1;
			    			location[1]=sum;
			    		}
			    		else 
			    			{
			    			 location[1]=sum;
			    			}
			    		if(Cells[location[0]][location[1]].getLifeForm() == null)
			    		{   
			    			addLifeForm(location[0],location[1],life);
			    			removeLifeForm(location[0],temp);
			    		}
 			    		else 
 			    		{
			    			for(i=1;i< high && i<=temp;i++)
 				    		{
 				    			if(Cells[location[0]][location[1]-i].getLifeForm()== null)
 				    			{   
 				    				addLifeForm(location[0],location[1]-i,life);
 				    				removeLifeForm(location[0],temp);
 					    			break;
 				    			}
 				    				
 				    		}//end for
			    		}//end else
			    		
			    		
			    	}//end Alien
			    	else if(life.getMaxSpeed()==3)
			    	{  
				    		sum=location[1]+3;
				    		if(sum >= high)
				    		{  
				    			sum=high-1;
				    			location[1]=sum;
				    		}
				    		else 
				    			{
				    			 location[1]=sum;
				    			}
				    		if(Cells[location[0]][location[1]].getLifeForm() == null)
				    		{  
				    			addLifeForm(location[0],location[1],life);
				    			removeLifeForm(location[0],temp);
				    		}
	 			    		else 
	 			    		{
			    			 
				    			for(i=1;i< high && i<=location[1] ;i++)
	 				    		{ 
	 				    			if(Cells[location[0]][location[1]-i].getLifeForm()== null)
	 				    			{     
	 				    				
	 					    			break;
	 				    			}
	 				    				
	 				    		}//end for
				    			    addLifeForm(location[0],location[1]-i,life);
				    				removeLifeForm(location[0],temp);
				    		}//end else				    		
				    	}//end Human
			    	}
			}// end East if
			if(life.getDirection().compareToIgnoreCase("South")== 0 &&(location[0]<width))
			{       //Alien
				     temp=location[0];
			    	if(life.getMaxSpeed()==2)
			    	{
			    		sum=location[0]+2;
			    		if(sum > width )
			    		{
			    			sum=width-1;
			    			 location[0]=sum;
			    		}
			    		else 
			    			{
			    			 location[0]=sum;
			    			}
			    		if(Cells[location[0]][location[1]].getLifeForm() == null)
			    		{   
			    			addLifeForm(location[0],location[1],life);
			    			removeLifeForm(temp,location[1]);
			    		}
 			    		else 
 			    		{
			    			for(i=1;i<width && i<= temp;i++)
 				    		{
			    				
 				    			if(Cells[location[0]-i][location[1]].getLifeForm()== null)
 				    			{   
 				    				addLifeForm(location[0]-i,location[1],life);
 				    				removeLifeForm(temp,location[1]);
 					    			break;
 				    			}
 				    					
 				    		}//end for
			    		
			    		}//end else
			    	}//end Alien
			    	else 
			    	{
			    		if(life.getMaxSpeed()==3)
				    	{
				    		sum=location[0]+3;
				    		if(sum > width )
				    		{
				    			sum=width-1;
				    			 location[0]=sum;
				    		}
				    		else 
				    			{
				    			 location[0]=sum;
				    			}
				    		if(Cells[location[0]][location[1]].getLifeForm() == null)
				    		{   
				    			addLifeForm(location[0],location[1],life);
				    			removeLifeForm(temp,location[1]);
				    		}
	 			    		else 
	 			    		{
				    			for(i=1;i<width && i<= temp;i++)
	 				    		{
				    				
	 				    			if(Cells[location[0]-i][location[1]].getLifeForm()== null)
	 				    			{   
	 				    				addLifeForm(location[0]-i,location[1],life);
	 				    				removeLifeForm(temp,location[1]);
	 					    			break;
	 				    			}	
	 				    		}//end for
				    		}//end else
				    	}//end Human
			    	}//if not alien
			}// end South if
			if(life.getDirection().compareToIgnoreCase("West")== 0 &&(location[1]>=1))
			{       //Alien
				     temp=location[1];
			    	if(life.getMaxSpeed()==2)
			    	{
			    		sum=location[1]-2;
			    		if(sum < width && sum<0)
			    		{
			    			sum+=Math.abs(sum);
			    			 location[1]=sum;
			    		}
			    		else 
			    			{
			    			 location[1]=sum;
			    			}
			    		if(Cells[location[0]][location[1]].getLifeForm() == null)
			    		{   
			    			addLifeForm(location[0],location[1],life);
			    			removeLifeForm(location[0],temp);
			    		}
 			    		else 
 			    		{
			    			for(i=1;i<width && i<=temp;i++)
 				    		{
 				    			if(Cells[location[0]][location[1]+i].getLifeForm()== null)
 				    			{   
 				    				addLifeForm(location[0],location[1]+i,life);
 				    				removeLifeForm(location[0],temp);
 					    			break;
 				    			}	
 				    		}//end for
			    		}//end else
			    	}//end Alien
			    	else if(life.getMaxSpeed()==3)
			    	{   
				    		sum=location[1]-3;
				    		if(sum < width && sum<0)
				    		{
				    			sum+=Math.abs(sum);
				    			 location[1]=sum;
				    		}
				    		else 
				    			{
				    			 location[1]=sum;
				    			}
				    		if(Cells[location[0]][location[1]].getLifeForm() == null)
				    		{   
				    			addLifeForm(location[0],location[1],life);
				    			removeLifeForm(location[0],temp);
				    		}
	 			    		else 
	 			    		{
				    			for(i=1;i<width && i<=temp;i++)
	 				    		{
	 				    			if(getLifeForm(location[0],location[1]+i)== null)
	 				    			{   
	 				    			
	 					    			break;
	 				    			}	
	 				    		}//end for
				    			    
				    			    addLifeForm(location[0],location[1]+i,life);
				    				removeLifeForm(location[0],temp);
				    		}//end else
				    
			    	}//not alien
			}// end West if
		}// end null condition

} // end the class Environment
