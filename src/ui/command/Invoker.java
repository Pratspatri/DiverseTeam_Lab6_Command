package ui.command;

/**
 * Invoker Class for User Interface Command
 * @author Saad
 */

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Invoker implements ActionListener
{

	private JFrame frame;                // JFrame variables to make the frame    
	Command reloadCm;
	Command AcquireCm ;                   // Command variable to call Acquire Command 
	Command MoveCm ;                      // Command variable to call Move Command 
	Command DropCm ;                       // Command variable to call Drop Command 
	Command TurnEastCm ;                  // Command variable to call turn east  Command 
	Command TurnSouthCm ;                   // Command variable to call turn south  Command
	Command TurnNourthCm ;                   // Command variable to call turn north  Command
	Command TurnWestCm ;                       // Command variable to call turn west  Command
	Command AttackCm ;                       // Command variable to call turn attack  Command
	JButton reload ;                          //  Reload command button 
	JButton acquire ;                          // Acquire command button
	JButton attack ;                          // Attack command button
	JButton move ;                              // Move command button
	JButton drop ;                             // Drop command button
	JButton east ;                                 // Turn east command button
	JButton north ;                                // Turn north command button
	JButton west ;                               // Turn west command button
	JButton south ;                             //Turn south command button

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
		/**
		 * Create the panel and the buttons For Each command 
		 */
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		reload = new JButton("Reload");
		panel.add(reload);
		reload.addActionListener(this);
		
		acquire = new JButton("Acquire");
		panel.add(acquire);
		acquire.addActionListener(this); 
		
		attack = new JButton("Attack");
		panel.add(attack);
		attack.addActionListener(this);
		
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
	 * 
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
     * Action Listener method to do the action.When the button go clicked it should call the
     * execute method for the right command .We used (event.getSource()) to check when the right button
     * got clicked 
     * 
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()== reload)
		{
			//call execute method in reload Command 
			reloadCm.execute(); 
		}
		else if(event.getSource()== acquire)
		{
			//call execute method in Acquire Command 
			AcquireCm.execute();
		}
		else if(event.getSource()== move)
		{
			//call execute method in Move Command
			MoveCm.execute();
		}
		else if(event.getSource()== drop)
		{
			//call execute method in drop Command
			DropCm.execute();
		}
		else if(event.getSource()== east)
		{
			//call execute method in turn east Command
			TurnEastCm.execute();
		}
		else if(event.getSource()== west)
		{
			//call execute method in turn west Command
			TurnWestCm.execute();
		}
		else if(event.getSource()== south)
		{
			//call execute method in turn south Command
			TurnSouthCm.execute();
		}
		else if(event.getSource()== north) 
		{
			//call execute method in turn north Command
			TurnNourthCm.execute();
		}
		else if(event.getSource()== attack) 
		{
			//call execute method in attack Command
			AttackCm.execute();
		}
		
		
	}
}
