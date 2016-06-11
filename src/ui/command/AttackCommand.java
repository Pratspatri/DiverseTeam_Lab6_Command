package ui.command;

import environment.Environment;
import lifeform.LifeForm;

/**
 * The class represents a Command. It is used to select LifeForm to attack in the
 * direction it is facing. The LifeForm should only fire its weapon if there is a
 * target and will always attack the closest target.
 * 
 * @author Jixiang Lu
 *
 */
public class AttackCommand implements Command
{
	private LifeForm life;
	
	/**
	 * Construct an AttackCommand with a life that is used to attack another LifeForm.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public AttackCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Execute the LifeForm to attack in the direction it is facing.
	 * The lifeForm should only fire its weapon if there is a target and
	 * will always attack the closest target.
	 */
	@Override
	public String execute()
	{
		Environment env = Environment.getWorldInstance();
		if(life.getDirection().compareToIgnoreCase("north")==0)
		{
			int attackRow = life.getRowTrack()-1; 
			
			for(int i =0; i< life.getAttachDistance();i++)
			{
				if(attackRow<0)
				{
					break;
				}
				else if( env.getLifeForm(attackRow, life.getColTrack()) != null)
				{ 
					life.attack(env.getLifeForm(attackRow, life.getColTrack()));
					return "Attack target!";
				}
				attackRow -= 1;
			}
			return "Can't attack!";
		}
		else if(life.getDirection().compareToIgnoreCase("South")==0)
		{
			int attackRow = life.getRowTrack()+1; 
			for(int i =0; i< life.getAttachDistance();i++)
			{
				if(attackRow>env.getNumberOfRow())
					break;
				else if(env.getLifeForm(attackRow, life.getColTrack()) != null)
				{ 
					life.attack(env.getLifeForm(attackRow, life.getColTrack()));
					return "Attack target!";
				}
				attackRow += 1;
			}
			return "Can't attack!";
		}
		else if(life.getDirection().compareToIgnoreCase("east")==0)
		{
			int attackCol = life.getColTrack()+1; 
			for(int i =0; i< life.getAttachDistance();i++)
			{
				if(attackCol>env.getNumberOfCol())
					break;
				if(env.getLifeForm(life.getColTrack(), attackCol) != null)
				{ 
					life.attack(env.getLifeForm(life.getColTrack(), attackCol));
					return "Attack target!";
				}
				attackCol += 1;
			}
			return "Can't attack!";
		}
		else if(life.getDirection().compareToIgnoreCase("west")==0)
		{
			int attackCol = life.getColTrack()-1; 
			for(int i =0; i< life.getAttachDistance();i++)
			{
				if(attackCol<0)
					break;
				if(env.getLifeForm(life.getColTrack(), attackCol) != null)
				{ 
					life.attack(env.getLifeForm(life.getColTrack(), attackCol));
					return "Attack target!";
				}
				attackCol -= 1;
			}
			return "Can't attack!";
		}
		else
		{
			return "Can't attack!";
		}
		
	}

}
