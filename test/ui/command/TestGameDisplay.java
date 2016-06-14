package ui.command;
/**
 * Class to test our GUI to check if everything is displayed correctly.
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import environment.Environment;

public class TestGameDisplay 
{

	@Test
	public void test() 
	{
		/*Environment env = Environment.getWorldInstance();
		LifeForm l1 = new Human("Bob",50,10);
		LifeForm m1 = new Human("Mon",50,10);
		env.addLifeForm(4, 4, l1);
		env.addLifeForm(1, 2, m1);
		l1.setDirection("north");
		PlasmaCannon cannon = new PlasmaCannon();
		l1.pickUp(cannon);
		Pistol pistol = new Pistol();
		ChainGun gun = new ChainGun();
		env.addWeapon(4, 2, pistol, 1);
		env.addWeapon(4, 7, gun, 2);
		
		LifeForm A1 = new Alien("Jadoo",80);
		LifeForm C1 = new Alien("Chan",80);
		env.addLifeForm(7, 7, A1);
		env.addLifeForm(2, 5, C1);
		Pistol p1 = new Pistol();
		A1.pickUp(p1);
		PlasmaCannon pc = new PlasmaCannon();
		env.addWeapon(6, 5, pc, 1);
		*/
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Human(1,2) and "
				+ "Alien(2,5)\nDoes it look right?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Human(4,4) with "
				+ "plasma cannon facing north which should look like H|PC|n|_|_|\nDoes it look right?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Alien(7,7) with "
				+ "pistol which should look like A|P|_|_|_|\nDoes it look right?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is pistol at (4,2) position"
				+ "1 displayed correctly in this manner - _|_|_|P|_|?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is chain gun at (4,7) position"
				+ "2 displayed correctly in this manner - _|_|_|_|CG|?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is plasma cannon at (6,5) position"
				+ "1 displayed correctly in this manner - _|_|_|PC|_|?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Map Legend displayes H = Human,"
				+ "A = Alien, P = Pistol, PC = Plasma Cannon, CG = Chain Gun\nDoes it look right?"));
	} 

}
