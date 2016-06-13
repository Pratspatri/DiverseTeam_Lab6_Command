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

import weapon.Attachment;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;
import environment.Environment;

import java.awt.Color;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

public class GameDisplay 
{
	/**
	 * Creating new variables for frame, legend, map.
	 */
	private JFrame frame;
	private JPanel legend, map;
	private JLabel displayArray[][];
	private int row,col;
	private final String DEFAULTFORMAT="_|__|_|__|__|";		// to display this default string in the GUI   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		GameDisplay window = new GameDisplay();
		window.frame.setVisible(true);
	}

	/**
	 * Create the application. Setting the environment size to be (8,8)
	 */
	public GameDisplay() 
	{
		row=8;
		col=8;
		displayArray=new JLabel[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				displayArray[i][j]=new JLabel(DEFAULTFORMAT);
			}
		}
		initialize();
		/**
		 * Mock initialization check to just to see if everything needed is displayed correctly
		 */
		Environment env = Environment.getWorldInstance();
		LifeForm l1 = new Human("Bob",50,10);				// Creating Human 1
		LifeForm m1 = new Human("Mon",50,10);				// Creating Human 2
		env.addLifeForm(4, 4, l1);							// adding them to the environment
		env.addLifeForm(1, 2, m1);
		l1.setDirection("north");							// setting direction to human 1
		PlasmaCannon cannon = new PlasmaCannon();			
		l1.pickUp(cannon);									// assigning a weapon to human 1	
		Pistol pistol = new Pistol();						
		ChainGun gun = new ChainGun();
		env.addWeapon(4, 2, pistol, 1);						// adding weapons to positions in the cell
		env.addWeapon(4, 7, gun, 2);
		
		LifeForm A1 = new Alien("Jadoo",80);				// Creating Alien 1
		LifeForm C1 = new Alien("Chan",80);					// Creating Alien 2
		env.addLifeForm(7, 7, A1);							// adding them to the environment
		env.addLifeForm(2, 5, C1);
		Pistol p1 = new Pistol();
		A1.pickUp(p1);										// assigning weapon to alien 1
		PlasmaCannon pc = new PlasmaCannon();
		env.addWeapon(6, 5, pc, 1);							// adding weapon to position in a cell
		update();
	}
	/**
	 * Update method to get updates from Environment and display on the map
	 */
	public void update() 
	{
		Environment envin = Environment.getWorldInstance();
		LifeForm l1;
		Weapon w1;
		String dir;
		String temp="";
		for(int i=0; i<8; i++)									// considering the whole environment
		{
			for(int j=0; j<8; j++)
			{
				temp="";
				l1 = envin.getLifeForm(i, j);
				if(l1 != null)
				{
					if(l1 instanceof Human)						// if the lifeForm defined is an instance of Human
					{
						temp+="H|";								// creating the display string by first adding lifeForm
					}
					else if(l1 instanceof Alien)
					{
						temp+="A|";
					}
					w1 =getWeapon(l1.getWeapon());				// if lifeForm present, assigning a weapon to it
					if(w1 != null)
					{
						if(w1 instanceof Pistol)
						{
							temp+="P|";							// creating the display string further accordingly
						}
						else if(w1 instanceof PlasmaCannon)
						{
							temp+="PC|";
						}
						else if(w1 instanceof ChainGun)
						{
							temp+="CG|";
						}
					}
					else
					{
						temp+="__|";
					}
					/**
					 * get the direction and display the same
					 */
					dir = l1.getDirection();
					if(dir != null)
					{
						if(dir == "north")
						{
							temp+="n|";
						}
						else if(dir == "south")
						{
							temp+="s|";
						}
						else if(dir == "east")
						{
							temp+="e|";
						}
						else if(dir == "west")
						{
							temp+="w|";
						}
					}
					else
					{
						temp+="_|";
					}
					temp+="_|";
				}
				else
				{
					temp+="_|__|_|";
				}
				w1 =getWeapon(envin.getWeapon(i, j, 1));					// assigning weapons to their slots in cell
				if(w1 != null)
				{
					if(w1 instanceof Pistol)								// if the weapon is an instance of pistol
					{
						temp+="P|";											// adding to the display string
					}
					else if(w1 instanceof PlasmaCannon)
					{
						temp+="PC|";
					}
					else if(w1 instanceof ChainGun)
					{
						temp+="CG|";
					}
				}
				else
				{
					temp+="__|";
				}
				w1 =getWeapon(envin.getWeapon(i, j, 2));
				if(w1 != null)
				{
					if(w1 instanceof Pistol)
					{
						temp+="P|";
					}
					else if(w1 instanceof PlasmaCannon)
					{
						temp+="PC|";
					}
					else if(w1 instanceof ChainGun)
					{
						temp+="CG|";
					}
				}
				else
				{
					temp+="__|";
				}
				displayArray[i][j].setText(temp);			
			}
		}
	}

	private Weapon getWeapon(Weapon weapon) 					// making the wrapped weapon(weapon+attachment) to display only weapon
	{
		while(weapon instanceof Attachment)
		{
			weapon = ((Attachment)weapon).getWeapon();
		}
		return weapon;
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
		
		JLabel mapName = new JLabel("Map");
		panel.add(mapName);
		
		JPanel Environment = new JPanel();
		map.add(Environment, BorderLayout.CENTER);
		Environment.setLayout(new GridLayout(8, 8, 0, 0));
		LineBorder border=new LineBorder(new Color(0, 0, 0), 1, true);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				displayArray[i][j].setBorder(border);
				Environment.add(displayArray[i][j]);
			}
		}
		
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
