package ui;
/**
 * Game Display class for the Graphical User Interface(GUI)
 * @author - Prathyusha Akshintala
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GameDisplay 
{
	/**
	 * Creating new variables for frame, legend, map.
	 */
	private JFrame frame;
	private JPanel legend, map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		GameDisplay window = new GameDisplay();
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public GameDisplay() 
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
		frame.setBounds(100, 100, 821, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		addLegend();					// add legend details to the frame
		addMap();						// add map details to the frame
	}

	/**
	 * Map details with respect to adding layout, panels, frame and setting the size
	 */
	private void addMap() 
	{
		map = new JPanel();
		map.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(map, BorderLayout.CENTER);
		map.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		map.add(panel, BorderLayout.NORTH);
		
		JLabel lblMap = new JLabel("Map");
		panel.add(lblMap);
		
		JPanel Environment = new JPanel();
		map.add(Environment, BorderLayout.CENTER);
		Environment.setLayout(new GridLayout(1, 0, 0, 0));
		
	}
	
	/**
	 * Legend details with respect to adding the labels and the layout. 
	 * This is tells us what represents what in the map.
	 */
	private void addLegend() 
	{
	
		legend = new JPanel();
		legend.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(legend, BorderLayout.EAST);
		legend.setLayout(new GridLayout(18, 1, 4, 4));
		
		JLabel L1 = new JLabel(" Legend");
		legend.add(L1);
		
		JLabel L2 = new JLabel(" A = Alien");
		legend.add(L2);
		
		JLabel L3 = new JLabel(" H = Human");
		legend.add(L3);
		
		JLabel L4 = new JLabel(" P = Pistol");
		legend.add(L4);
		
		JLabel L5 = new JLabel(" PC = PlasmaCannon");
		legend.add(L5);
		
		JLabel L6 = new JLabel(" CG = ChainGun");
		legend.add(L6);
		
		JLabel L7 = new JLabel(" n = North");
		legend.add(L7);
		
		JLabel L8 = new JLabel(" e = East");
		legend.add(L8);
		
		JLabel L9 = new JLabel(" w = West");
		legend.add(L9);
		
		JLabel L10 = new JLabel(" s = South");
		legend.add(L10);
		
		JLabel L11 = new JLabel(" A|P = Alien with Pistol");
		legend.add(L11);
		
		JLabel L12 = new JLabel(" A|PC = Alien with PlasmaCannon");
		legend.add(L12);
		
		JLabel L13 = new JLabel(" A|CG = Alien with ChainGun");
		legend.add(L13);
		
		JLabel L14 = new JLabel(" H|P = Human with Pistol");
		legend.add(L14);
		
		JLabel L15 = new JLabel(" H|PC = Human with PlasmaCannon");
		legend.add(L15);
		
		JLabel L16 = new JLabel(" H|CG = Human with ChainGun");
		legend.add(L16);
		
	}
}
