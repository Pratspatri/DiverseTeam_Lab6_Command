package ui.command;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Invoker implements ActionListener
{

	private JFrame frame;
	Command reloadCm;
	Command AcquireCm ; 
	Command MoveCm ;
	Command DropCm ;
	Command TurnEastCm ;
	Command TurnSouthCm ; 
	Command TurnNourthCm ; 
	Command TurnWestCm ; 
	Command AttackCm ; 
	JButton reload ; 
	JButton acquire ; 
	JButton turn ; 
	JButton move ; 
	JButton drop ; 
	JButton east ; 
	JButton north ; 
	JButton west ; 
	JButton south ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Invoker window = new Invoker();
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Invoker() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 629, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		reload = new JButton("Reload");
		panel.add(reload);
		reload.addActionListener(this);
		
		acquire = new JButton("Acquire");
		panel.add(acquire);
		acquire.addActionListener(this);
		
	    turn = new JButton("Turn");
		panel.add(turn);
		turn.addActionListener(this);
		
		move = new JButton("Move");
		panel.add(move);
		move.addActionListener(this);
		
		drop = new JButton("Drop");
		panel.add(drop);
		drop.addActionListener(this);
		
		east = new JButton("East");
		frame.getContentPane().add(east, BorderLayout.EAST);
		east.addActionListener(this);
		
		north = new JButton("North");
		frame.getContentPane().add(north, BorderLayout.NORTH);
		north.addActionListener(this);
		
		west = new JButton("West");
		frame.getContentPane().add(west, BorderLayout.WEST);
		west.addActionListener(this);
		
		south = new JButton("South");
		frame.getContentPane().add(south, BorderLayout.CENTER);
		south.addActionListener(this);
	}
	
	/**
	 * Set Methods to set Commands 
	 * @author Saad
	 */
	
	public void setRelaod(Command reload)
	{
		reloadCm = reload ; 
	}
	public void setAcquire(Command aquire)
	{
		AcquireCm = aquire ; 
	}
	public void setDrop(Command drop)
	{
		DropCm = drop ; 
	}
	public void setTurnEast(Command east)
	{
		TurnEastCm = east ; 
	}
	public void setTurnWest(Command west)
	{
		TurnWestCm = west ; 
	}
	public void setTurnNorth(Command north)
	{
		TurnNourthCm = north ; 
	}
	public void setTurnSouth(Command south)
	{
		TurnSouthCm = south ; 
	}
	public void setMove(Command move)
	{
		MoveCm = move ; 
	}
	public void setAttack(Command attack)
	{
		AttackCm = attack ; 
	}
	
    /**
     * Action Listener to handle each action for buttons 
     * @author Saad
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()== reload)
		{
			reloadCm.execute();
		}
		else if(event.getSource()== acquire)
		{
			AcquireCm.execute();
		}
		else if(event.getSource()== move)
		{
			MoveCm.execute();
		}
		else if(event.getSource()== drop)
		{
			DropCm.execute();
		}
		else if(event.getSource()== east)
		{
			TurnEastCm.execute();
		}
		else if(event.getSource()== west)
		{
			TurnWestCm.execute();
		}
		else if(event.getSource()== south)
		{
			TurnSouthCm.execute();
		}
		else if(event.getSource()== north)
		{
			TurnNourthCm.execute();
		}
		
		
	}
}
