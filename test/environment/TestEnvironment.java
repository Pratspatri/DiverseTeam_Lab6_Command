/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package environment;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import exceptions.MyNewException;

import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the Environment class
 */
public class TestEnvironment
{
	/**
	 * the Singleton or reinitialize the the Singleton Reset static variables
	 */
	@After
	public void after() 
	{
		Environment.resetInstance();
	}

	/**
	 * Test Human Moves correctly North without obstacles Test Human Moves
	 * correctly North with obstacles
	 */
	@Test
	public void testMoveNorthHuman() {
		Environment env = Environment.getWorldInstance();
		// move without obstacles
		Human human1 = new Human("Bob", 40, 10);
		assertTrue(env.addLifeForm(4, 0, human1));
		env.move(human1);
		assertEquals(1, human1.getRowTrack());
		assertEquals(0, human1.getColTrack());
		// can move just one cell because there is obstacles which is not all
		// cells are full
		Human human2 = new Human("fred", 40, 10);
		assertTrue(env.addLifeForm(4, 0, human2));
		env.move(human2);
		assertEquals(2, human2.getRowTrack());
		assertEquals(0, human2.getColTrack());
		assertNull(env.getLifeForm(4, 0));
		// cannot move there is obstacles which is all cells are full
		Human human3 = new Human("fred", 40, 10);
		Human human4 = new Human("fred", 40, 10);
		assertTrue(env.addLifeForm(3, 0, human3));
		assertTrue(env.addLifeForm(4, 0, human4));
		env.move(human4);
		assertEquals(4, human4.getRowTrack());
		assertEquals(0, human4.getColTrack());
	}

	/**
	 * Test Human Moves correctly South without obstacles Test Human Moves
	 * correctly South with obstacles
	 */
	@Test
	public void testMoveSouthHuman() {
		Environment env = Environment.getWorldInstance();
		Human human1 = new Human("fred", 40, 10);
		Human human2 = new Human("Bob", 40, 10);
		Human human3 = new Human("fred", 40, 10);
		Human human4 = new Human("bob", 40, 10);
		// There is no obstacles, so can move
		assertTrue(env.addLifeForm(0, 3, human1));
		human1.setDirection("South");
		env.move(human1);
		assertEquals(3, human1.getRowTrack());
		assertEquals(3, human1.getColTrack());
		assertNull(env.getLifeForm(0, 3));
		// There is obstacles which is all cells are full, cannot move
		assertTrue(env.addLifeForm(0, 3, human2));
		assertTrue(env.addLifeForm(1, 3, human3));
		assertTrue(env.addLifeForm(2, 3, human4));
		human2.setDirection("South");
		env.move(human2);
		assertEquals(0, human2.getRowTrack());
		assertEquals(3, human2.getColTrack());
		// There is obstacles which is not all cells are full, can move just one
		// cell
		env.move(human1);
		assertEquals(4, human1.getRowTrack());
		assertEquals(3, human1.getColTrack());
		assertNull(env.getLifeForm(3, 3));
	}

	/**
	 * Test Alien Moves correctly East without obstacles Test Alien Moves
	 * correctly East with obstacles
	 */
	@Test
	public void testMoveEastAlien() {
		Environment env = Environment.getWorldInstance();
		Alien a1 = new Alien("Bob", 40);
		Alien a2 = new Alien("Fred", 60);
		Alien a3 = new Alien("Lez", 40);
		;
		// There is no obstacles ,so can move
		assertTrue(env.addLifeForm(4, 1, a1));
		a1.setDirection("East");
		env.move(a1);
		assertEquals(4, a1.getRowTrack());
		assertEquals(3, a1.getColTrack());
		assertNull(env.getLifeForm(4, 1));
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		env.move(a1);
		assertEquals(4, a1.getRowTrack());
		assertEquals(4, a1.getColTrack());
		assertNull(env.getLifeForm(4, 3));
		assertTrue(env.addLifeForm(4, 2, a2));
		a2.setDirection("East");
		env.move(a2);
		assertEquals(4, a2.getRowTrack());
		assertEquals(3, a2.getColTrack());
		assertNull(env.getLifeForm(4, 2));
		// there is obstacle which all cells are full, cannot move
		assertTrue(env.addLifeForm(4, 2, a3));
		a3.setDirection("East");
		env.move(a3);
		assertEquals(4, a3.getRowTrack());
		assertEquals(2, a3.getColTrack());
	}

	/**
	 * Test Alien Moves correctly West without obstacles Test Alien Moves
	 * correctly West with obstacles
	 */
	@Test
	public void testMoveWestAlien() {
		Environment env = Environment.getWorldInstance();

		Alien a1 = new Alien("Bob", 40);
		Alien a2 = new Alien("Fred", 60);
		Alien a3 = new Alien("Lez", 40);
		Alien a4 = new Alien("Lez", 40);
		Alien a5 = new Alien("Lez", 40);
		// there is not obstacles,so can move
		assertTrue(env.addLifeForm(2, 2, a1));
		a1.setDirection("West");
		env.move(a1);
		assertEquals(2, a1.getRowTrack());
		assertEquals(0, a1.getColTrack());
		assertNull(env.getLifeForm(2, 2));
		/// there are obstacles which all cells are full, cannot move
		assertTrue(env.addLifeForm(2, 1, a2));
		assertTrue(env.addLifeForm(2, 2, a3));
		a3.setDirection("West");
		env.move(a3);
		assertEquals(2, a3.getRowTrack());
		assertEquals(2, a3.getColTrack());
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(0, 0, a4));
		assertTrue(env.addLifeForm(0, 2, a5));
		a5.setDirection("West");
		env.move(a5);
		assertEquals(0, a5.getRowTrack());
		assertEquals(1, a5.getColTrack());
		assertNull(env.getLifeForm(0, 2));
	}

	/**
	 * Test Alien Moves correctly North without obstacles Test Alien Moves
	 * correctly North with obstacles
	 */
	@Test
	public void testMoveNorthAlien() {
		Environment env = Environment.getWorldInstance();
		Alien a1 = new Alien("Bob", 40);
		Alien a2 = new Alien("Fred", 60);
		Alien a3 = new Alien("Lez", 40);
		Alien a4 = new Alien("Lez", 40);
		Alien a5 = new Alien("Lez", 40);
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(2, 0, a1));
		assertTrue(env.addLifeForm(4, 0, a2));
		env.move(a2);
		assertEquals(3, a2.getRowTrack());
		assertEquals(0, a2.getColTrack());
		// there is not obstacles,so can move
		assertTrue(env.addLifeForm(4, 1, a3));
		env.move(a3);
		assertEquals(2, a3.getRowTrack());
		assertEquals(1, a3.getColTrack());
		// there is an obstacle which is all cells are full, can move just one
		// cell
		assertTrue(env.addLifeForm(0, 1, a4));
		assertTrue(env.addLifeForm(1, 1, a5));
		env.move(a3);
		assertEquals(2, a3.getRowTrack());
		assertEquals(1, a3.getColTrack());
	}

	/**
	 * Test Human Moves correctly East without obstacles Test Human Moves
	 * correctly East with obstacles
	 */
	@Test
	public void testMoveEastHuman() {
		Environment env = Environment.getWorldInstance();
		Human human1 = new Human("fred", 40, 10);
		Human human2 = new Human("Bob", 40, 10);
		Human human3 = new Human("fred", 40, 10);
		Human human4 = new Human("bob", 40, 10);
		Human human5 = new Human("bob", 40, 10);
		// there is not obstacles,so can move
		assertTrue(env.addLifeForm(4, 0, human1));
		human1.setDirection("East");
		env.move(human1);
		assertEquals(4, human1.getRowTrack());
		assertEquals(3, human1.getColTrack());
		assertNull(env.getLifeForm(4, 0));
		// there is an obstacle which is all cells are full, can move just one
		// cell
		assertTrue(env.addLifeForm(3, 0, human3));
		assertTrue(env.addLifeForm(3, 1, human4));
		assertTrue(env.addLifeForm(3, 2, human5));
		human3.setDirection("East");
		env.move(human3);
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(4, 0, human2));
		human2.setDirection("East");
		env.move(human2);
		assertEquals(4, human2.getRowTrack());
		assertEquals(2, human2.getColTrack());
		assertNull(env.getLifeForm(4, 0));
	}

	/**
	 * Test Alien Moves correctly South without obstacles Test Alien Moves
	 * correctly South with obstacles
	 */
	@Test
	public void testMoveSouthAlien() {
		Environment env = Environment.getWorldInstance();
		Alien a1 = new Alien("Bob", 40);
		Alien a2 = new Alien("Fred", 60);
		Alien a3 = new Alien("Lez", 40);
		Alien a4 = new Alien("Lez", 40);
		// there is not obstacles,so can move
		assertTrue(env.addLifeForm(0, 3, a1));
		a1.setDirection("South");
		env.move(a1);
		assertEquals(2, a1.getRowTrack());
		assertEquals(3, a1.getColTrack());
		assertNull(env.getLifeForm(0, 3));
		// there is an obstacle which is all cells are full, can move just one
		// cell
		assertTrue(env.addLifeForm(0, 3, a2));
		assertTrue(env.addLifeForm(1, 3, a3));
		a2.setDirection("South");
		env.move(a2);
		assertEquals(0, a2.getRowTrack());
		assertEquals(3, a2.getColTrack());
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(4, 3, a4));
		a4.setDirection("South");
		env.move(a1);
		assertEquals(3, a1.getRowTrack());
		assertEquals(3, a1.getColTrack());
		assertNull(env.getLifeForm(2, 3));
	}

	/**
	 * Test Human Moves correctly West without obstacles Test Human Moves
	 * correctly West with obstacles
	 */
	@Test
	public void testMoveWestHuman() {
		Environment env = Environment.getWorldInstance();
		Human human1 = new Human("fred", 40, 10);
		Human human2 = new Human("Bob", 40, 10);
		Human human3 = new Human("fred", 40, 10);
		Human human4 = new Human("bob", 40, 10);
		Human human5 = new Human("bob", 40, 10);
		Human human6 = new Human("bob", 40, 10);
		// it is half full, can move just one cell
		assertTrue(env.addLifeForm(0, 0, human4));
		assertTrue(env.addLifeForm(0, 2, human5));
		assertTrue(env.addLifeForm(0, 3, human6));
		human6.setDirection("West");
		env.move(human6);
		assertEquals(0, human6.getRowTrack());
		assertEquals(1, human6.getColTrack());
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(2, 3, human1));
		human1.setDirection("West");
		env.move(human1);
		assertEquals(2, human1.getRowTrack());
		assertEquals(0, human1.getColTrack());
		assertNull(env.getLifeForm(2, 3));
		// there is an obstacle which is all cells are full, can move just one
		// cell
		assertTrue(env.addLifeForm(2, 1, human2));
		assertTrue(env.addLifeForm(2, 2, human3));
		env.move(human1);
		assertEquals(2, human1.getRowTrack());
		assertEquals(0, human1.getColTrack());
	}

	// Singleton Pattern
	/**
	 * Test Initialize be sure there is only one object from environment
	 */

	@Test
	public void testThereCanOlyOne() {
		Environment env1 = Environment.getWorldInstance();
		Environment env2 = Environment.getWorldInstance();
		assertEquals(env1, env2);
		assertTrue(env1 == env2);
	}

	/**
	 * Can add a weapon from specific location
	 */

	@Test
	public void testAddWeapon() {
		Environment env = Environment.getWorldInstance();
		Weapon weapon = new Pistol();

		// add cell to correct row and col in empty cell in Environment
		boolean success = env.addWeaopn(0, 0, weapon);
		assertTrue(success);
	}

	/**
	 * Can remove a weapon from specific location
	 */

	@Test
	public void testRemoveWeapon() {
		Environment env = Environment.getWorldInstance();
		Weapon weapon = new Pistol();
		env.addWeaopn(0, 0, weapon);
		Weapon w1 = env.removeWapon(0, 0, weapon);
		assertEquals(weapon, w1);
	}

	/**
	 * Test if add and remove will inside the border
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */

	@Test
	public void testBorderCases() throws ArrayIndexOutOfBoundsException {
		// add
		Environment env = Environment.getWorldInstance();
		Weapon weapon = new Pistol();
		boolean success = env.addWeaopn(7, 7, weapon);
		assertFalse(success);
		// remove
		assertNull(env.removeWapon(9, 1, weapon));
	}

	/**
	 * Test range along same row Test range along same column Test range not
	 * along same row or column
	 * 
	 * @throws MyNewException
	 *             if one of life form does not exist
	 */

	@Test(expected = MyNewException.class)
	public void testfind() throws MyNewException {
		Environment env = Environment.getWorldInstance();
		LifeForm entity1, entity2;
		entity1 = new MockLifeForm("bob", 40, 1);
		entity2 = new MockLifeForm("fred", 40, 1);
		// same row
		env.addLifeForm(0, 0, entity1);
		env.addLifeForm(0, 2, entity2);
		assertEquals(10, env.getDistance(entity1, entity2));
		// same col
		LifeForm entity4 = new MockLifeForm("fred", 40, 1);
		env.addLifeForm(1, 0, entity4);
		assertEquals(5, env.getDistance(entity1, entity4));
		// different row and col
		assertEquals(11, env.getDistance(entity2, entity4));
		// lifeForm does not exist, should be failure
		LifeForm entity8 = new MockLifeForm("fred", 40, 1);
		env.getDistance(entity1, entity8);
	}
	/**
	 * At initialization, the Environment should be empty and not contain a
	 * Cell.
	 */
	/*
	 * @Test public void testInitialization() { Environment env=new
	 * Environment(2,3); assertNull(env.Cells[0][0].getLifeForm()); } /** Checks
	 * to see if we add cell in Environment
	 */

	/*
	 * @Test public void TestSetCell() { LifeForm entity,entity1; entity = new
	 * MockLifeForm("bob", 40,1); entity1 = new MockLifeForm("fred", 40,1);
	 * Environment env=new Environment(2,3); // add cell to correct row and col
	 * in empty cell in Environment boolean success= env.addLifeForm(0, 0,
	 * entity); assertTrue(success); // add cell to correct row and col , but
	 * the cell has the same info. success= env.addLifeForm(0, 0, entity);
	 * assertFalse(success); // add cell to correct row and col , but the cell
	 * has the different info. success= env.addLifeForm(0, 0, entity1);
	 * assertTrue(success); //Border test // add cell to incorrect row and col
	 * success= env.addLifeForm(3,5, entity); assertFalse(success); }
	 */
	/**
	 * Checks to see if we delete the Cell from Environment
	 */
	/*
	 * @Test public void TestRemoveLifeForm() { // when remove cell from
	 * environment that is not empty LifeForm bob = new MockLifeForm("bob",
	 * 40,1); Environment env=new Environment(2,3); boolean success=
	 * env.addLifeForm(1, 0, bob); assertTrue(success); LifeForm
	 * entity=env.removeLifeForm(1,0); assertNull(env.Cells[1][0]);
	 * assertEquals(entity,bob);
	 * 
	 * // when remove cell from environment that is empty Environment env1=new
	 * Environment(2,3); LifeForm entity1=env1.removeLifeForm(1,0);
	 * assertNull(env.Cells[1][0]); assertEquals(entity1,null); }
	 */
}
