package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Environment class. 
 * New tests @author - Prathyusha Akshintala
 * Previous existing tests @author : Sameer Kumar Kotra
 */
public class TestEnvironment
{

	/**
	 * @author - Prathyusha Akshintala
	 * Test the initialization of the Environment.
	 */
	@Test
	public void testInitialization()
	{
		Environment environ1 = Environment.getWorldInstance();
		
		// Life form will be null for a newly created Environment.
		assertNull(environ1.getLifeForm(0, 0));
		assertNull(environ1.getLifeForm(1, 1));
		
		Environment environ2 = Environment.getWorldInstance();
		assertEquals (environ1, environ2);
	}
	
	/**
	 * @author - Prathyusha Akshintala
	 * Reset the instance after each Test.
	 */
	@After
	public void reset()
	{
		Environment.resetInstance();
	}

	/**
	 * @author - Prathyusha Akshintala
	 * Reset environment method is used for other tests.
	 */
	public static void resetEnvironment()
	{
		Environment.resetInstance();
	}
	
	/**
	 * Test getWeapon() method.
	 * @author Jixiang Lu.
	 */
	@Test
	public void testGetWeapon()
	{
		Environment env = Environment.getWorldInstance();
		Weapon w1 = new PlasmaCannon();
		Weapon w2 = new Pistol();
		env.addWeapon(0, 0, w1, 1);
		env.addWeapon(0, 0, w2, 2);
		assertEquals(w1,env.getWeapon(0, 0, 1));
		assertEquals(w2,env.getWeapon(0, 0, 2));
	}
	
	/**
	 * @author - Prathyusha Akshintala
	 * Tests to add weapon from a given location
	 */
	@Test
	public void addWeapon()
	{
		Environment environ1 = Environment.getWorldInstance();
		Weapon w1 = new PlasmaCannon();
		Weapon w2 = new Pistol();
		// Add weapons to the cell (1,2)
		assertTrue(environ1.addWeapon(1, 2, w1, 1));
		assertTrue(environ1.addWeapon(1, 2, w2, 2));
		// Border Cases - outside the range
		assertFalse(environ1.addWeapon(6, 5, w1, 1));
		assertFalse(environ1.addWeapon(5, 6, w2, 2));
		assertFalse(environ1.addWeapon(8, 8, w1, 1));
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Tests to remove weapon from a given location
	 */
	@Test
	public void removeWeapon()
	{
		Environment environ1 = Environment.getWorldInstance();
		Weapon w1 = new PlasmaCannon();
		Weapon w2 = new Pistol();
		// Add weapons to the cell (1,2)
		environ1.addWeapon(1, 2, w1, 1);
		environ1.addWeapon(1, 2, w2, 2);
		assertEquals(w1,environ1.removeWeapon(1, 2, 1));
		assertEquals(w2,environ1.removeWeapon(1, 2, 2));
		// Border Cases - outside the range
		assertNull(environ1.removeWeapon(6, 5, 1));
		assertNull(environ1.removeWeapon(5, 6, 2));
		assertNull(environ1.removeWeapon(8, 8, 1));
	}
	/**
	 * Tests the distance between the LifeForms.
	 */
	@Test
	public void testDistance()
	{
		Environment environ1 = Environment.getWorldInstance();
		LifeForm harry = new MockLifeForm("Harry", 35);
		LifeForm ron = new MockLifeForm("Ron", 38);
		LifeForm dobby = new MockLifeForm("Dobby", 50);
		environ1.addLifeForm(1, 0, harry);
		environ1.addLifeForm(1, 2, ron);
		environ1.addLifeForm(4, 2, dobby);

		// If the lifeforms are in the same row.	
		assertEquals(10, environ1.getDistance(harry, ron));
		// If the lifeforms are in the same column.
		assertEquals(15, environ1.getDistance(ron, dobby));
		// If the lifeforms are in different row and different column.
		assertEquals(18, environ1.getDistance(harry, dobby));

		environ1.removeLifeForm(1, 2);
		assertEquals(-1, environ1.getDistance(harry, ron));
		assertEquals(-1, environ1.getDistance(ron, dobby));
	}

	/**
	 * Old tests
	 * Test the setting of LifeFrom in the Environment.
	 */
	@Test
	public void testSetLifeForm()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);
		assertEquals(bob, environment.getLifeForm(1, 2));

		// The cell is not empty so this should fail.
		success = environment.addLifeForm(1, 2, bob);
		assertFalse(success);

		// The cell in empty we should get null
		assertNull(environment.getLifeForm(0, 0));

		// The cell location is invalid we should get null
		assertNull(environment.getLifeForm(0, 5));
	}

	/**
	 * Test the border conditions while adding the LifeFrom to Environment.
	 */
	@Test
	public void testBorderConditions()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// Can not add at location 2,0 as rows exceed size
		boolean success = environment.addLifeForm(6, 0, bob);
		assertFalse(success);

		// Can not add at location 0,2 as column exceed size
		success = environment.addLifeForm(0, 6, bob);
		assertFalse(success);

	}

	/**
	 * Test the removing of LifeFrom from the Environment.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);

		// Life form is added do it should work.
		assertEquals(bob, environment.removeLifeForm(1, 2));

		// Life form is not added at location 1,4 so it should fail.
		assertNull(environment.removeLifeForm(1, 1));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(1, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 1));

	}
}
