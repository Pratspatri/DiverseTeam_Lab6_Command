package ui.command;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Invoker 
{

	private JFrame frame;

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
		
		JButton reload = new JButton("Reload");
		panel.add(reload);
		
		JButton acquire = new JButton("Acquire");
		panel.add(acquire);
		
		JButton turn = new JButton("Turn");
		panel.add(turn);
		
		JButton move = new JButton("Move");
		panel.add(move);
		
		JButton drop = new JButton("Drop");
		panel.add(drop);
		
		JButton newButton = new JButton("East");
		frame.getContentPane().add(newButton, BorderLayout.EAST);
		
		JButton north = new JButton("North");
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		JButton west = new JButton("West");
		frame.getContentPane().add(west, BorderLayout.WEST);
		
		JButton south = new JButton("South");
		frame.getContentPane().add(south, BorderLayout.CENTER);
	}
}
