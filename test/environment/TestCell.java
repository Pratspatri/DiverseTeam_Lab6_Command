/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package environment;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

import static org.junit.Assert.*;

import org.junit.Test;

import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the Cell class
 */
public class TestCell 
{   
	//Singleton Pattern lab
	/**
	 * Test Initialize
	 */
	@Test
	public void testInitializationNoLifeforAndWeapon() 
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
		assertEquals(0, cell.getWeapon().size());
	}

	/**
	 * Test can remove and add two weapon
	 */
	@Test
	public void testAddandRemoveWeapon()
	{
		// set two weapon
		Cell cell = new Cell();
		Weapon pw1 = new Pistol();
		Weapon pw2 = new Pistol();
		cell.setWeapon(pw1);
		assertEquals(pw1, cell.getWeapon().get(0));
		cell.setWeapon(pw2);
		assertEquals(pw2, cell.getWeapon().get(1));
		assertEquals(2, cell.getWeapon().size());
		// remove
		cell.removeWeapon(pw1);
		assertEquals(1, cell.getWeapon().size());
		cell.removeWeapon(pw2);
		assertEquals(0, cell.getWeapon().size());
	}

	/**
	 * Test cannot place a weapon in a slot that already has a weapon
	 */
	@Test
	public void testCannotReplace() 
	{
		Cell cell = new Cell();
		Weapon pw1 = new Pistol();
		Weapon pw2 = new Pistol();
		Weapon pw3 = new Pistol();
		cell.setWeapon(pw1);
		cell.setWeapon(pw2);
		cell.setWeapon(pw3);
		assertEquals(pw1, cell.getWeapon().get(0));
		assertEquals(pw2, cell.getWeapon().get(1));
		assertEquals(2, cell.getWeapon().size());
	}

	/**
	 * At initialization, the Cell should be empty and not contain a LifeForm.
	 */

	@Test
	public void testInitialization() 
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	/**
	 * Checks to see if we change the LifeForm held by the Cell that getLifeForm
	 * properly responds to this change.
	 */

	@Test
	public void TestSetLifeForm() 
	{
		Cell cell = new Cell();
		LifeForm bob = new MockLifeForm("Bob", 40, 1);
		LifeForm fred = new MockLifeForm("Fred", 40, 1);
		// when add to empty cell
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		// when add to cell that is not empty and this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}

	/**
	 * Checks to see if we change the LifeForm held by the Cell that
	 */
	@Test
	public void TestRemoveLifeForm() 
	{

		LifeForm entityremove;
		LifeForm bob = new MockLifeForm("Bob", 40, 2);
		Cell cell = new Cell();
		// when remove cell that is not empty
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		entityremove = cell.removeLifeForm();
		assertNull(cell.getLifeForm());
		assertEquals(entityremove, bob);
		// when remove cell that is empty
		LifeForm entity_remove = cell.removeLifeForm();
		assertNull(cell.getLifeForm());
		assertEquals(null, entity_remove);
	}

}// end the TestCell class
