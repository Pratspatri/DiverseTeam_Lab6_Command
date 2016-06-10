package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 * New @author : Prathyusha Akshintala
 * Previous files @author : Sameer Kumar Kotra
 */
public class TestCell
{
	
	/**
	 * New tests for Singleton Pattern
	 * Updating existing test to check for no weapons.
	 * Test the initialization of the Cell.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		// LifeForm will be null when new Cell is created.
		assertNull(cell.getLifeForm());
		assertNull(cell.getWeapon(1));
		assertNull(cell.getWeapon(2));
	}
	
	/**
	 * Test to add weapon to a cell.
	 */
	@Test
	public void addWeapon()
	{
		Cell cell = new Cell();
		Weapon w1 = new PlasmaCannon();
		Weapon w2 = new Pistol();
		Weapon w3 = new ChainGun();
		
		/**
		 * Case 1 : Add when there is no weapon
		 */
		assertTrue(cell.addWeapon(w1, 1));
		/**
		 * Case 2 : Add another weapon to cell
		 */
		assertTrue(cell.addWeapon(w2, 2));
		/**
		 * Case 3 : Cannot add more than 2 weapons
		 */
		assertFalse(cell.addWeapon(w3, 1));
		
		assertEquals (w1, cell.getWeapon(1));
		assertEquals (w2, cell.getWeapon(2));
		
		assertFalse(cell.addWeapon(w3, 3));	// Adding after the range - border case
		assertFalse(cell.addWeapon(w3, -3));	// Adding after the range - border case
	}
	/**
	 * Test to remove weapon.
	 */
	@Test
	public void removeWeapon()
	{
		Cell cell = new Cell();
		Weapon w1 = new PlasmaCannon();
		Weapon w2 = new Pistol();
		
		cell.addWeapon(w1, 1);					// First add weapon 1
		cell.addWeapon(w2, 2);					// Add weapon 2
		assertEquals(w1,cell.removeWeapon(1));	// Check if the weapon at position 1 is weapon1
		assertEquals(w2,cell.removeWeapon(2));	// Check if the weapon at position 2 is weapon2
		assertNull(cell.removeWeapon(2));		// Check if we can remove a weapon when there is none.
		assertNull(cell.getWeapon(1));			// Check if there is no weapon after removing
		
		assertNull(cell.getWeapon(4));			// Border case - outside range
		assertNull(cell.getWeapon(-4));			// Border case - outside range
	}
	
	/**
	 * Old tests from Lab 1 - Strategy Pattern
	 * Test the setting of LifeFrom in the Cell.
	 */
	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());

		// The cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}

	/**
	 * Test the removing of LifeFrom from the Cell.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);

		// LifeForm is present so it should return the LifeForm
		assertEquals(bob, cell.removeLifeForm());

		// LifeForm is removed so it should return null
		assertNull(cell.removeLifeForm());
	}

}