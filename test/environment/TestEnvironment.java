package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.After;
import org.junit.Test;

import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * The test cases for the Environment class. New tests @author - Malak Bassam
 * Previous existing tests @author : Prathyusha Akshintala
 */
public class TestEnvironment {
	/**
	 * Reset the static variable
	 */
	@After
	public void after() 
	{
		Environment.resetInstance();
	}

	/**
	 * Tests getNumberOfRow() and getNumberOfCol()
	 * @author Jixiang Lu
	 */
	@Test
	public void testGetNumberOfRowAndCol()
	{
		Environment env = Environment.getWorldInstance();
		assertEquals(8,env.getNumberOfRow());
		assertEquals(8,env.getNumberOfCol());
	}
	/**
	 * test moveTemp() method as reference.
	 */
	@Test
	public void testMoveTemp()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm human = new MockLifeForm("Bob",40);
		env.addLifeForm(1, 1, human);
		
		//move north
		human.setDirection("north");
		human.setMaxSpeed(1);
		boolean isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(0, 1));
		assertTrue(isMoved);
		
		//move ease
		human.setDirection("east");
		isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(0, 2));
		assertTrue(isMoved);
		
		//move west
		human.setDirection("west");
		isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(0, 1));
		assertTrue(isMoved);
		
		//move south
		human.setDirection("south");
		isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(1, 1));
		assertTrue(isMoved);
		
		//speed =3;
		human.setMaxSpeed(3);
		isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(4, 1));
		assertTrue(isMoved);
		
		//there is a another LifeFom in the way. The LifeForm will pass though it.
		LifeForm human2 = new MockLifeForm("Luck",40);
		env.addLifeForm(2, 1, human2);
		human.setDirection("north");
		isMoved =env.moveTemp(human.getRowTrack(), human.getColTrack());
		assertEquals(human,env.getLifeForm(1, 1));
		assertTrue(isMoved);
		
	}
	
	/**
	 * Test Human Moves correctly North without obstacles Test Human Moves
	 * correctly North with obstacles
	 */
	@Test
	public void testMoveNorthHuman() 
	{
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
		Human human5 = new Human("fred", 40, 10);
		assertTrue(env.addLifeForm(3, 0, human3));
		assertTrue(env.addLifeForm(4, 0, human4));
		assertTrue(env.addLifeForm(5, 0, human5));
		env.move(human4);
		assertEquals(4, human4.getRowTrack());
		assertEquals(0, human4.getColTrack());

	}

	/**
	 * Test Alien Moves correctly East without obstacles Test Alien Moves
	 * correctly East with obstacles
	 */
	@Test
	public void testMoveEastAlien() 
	{
		Environment env = Environment.getWorldInstance();
		Alien a1 = new Alien("Bob", 40);
		Alien a22 = new Alien("Fred", 60);
		Alien a3 = new Alien("Lez", 40);
		// There is no obstacles ,so can move
		assertTrue(env.addLifeForm(4, 1, a1));
		a1.setDirection("East");
		env.move(a1);
		assertEquals(4, a1.getRowTrack());
		assertEquals(3, a1.getColTrack());
		assertNull(env.getLifeForm(4, 1));
		// there is an obstacle which is not all cells are full, can move just
		// one cell
		assertTrue(env.addLifeForm(4, 1, a22));
		a22.setDirection("East");
		env.move(a22);
		assertEquals(4, a22.getRowTrack());
		assertEquals(2, a22.getColTrack());
		assertNull(env.getLifeForm(4, 0));
		// there is obstacle which all cells are full, cannot move
		assertTrue(env.addLifeForm(4, 1, a3));
		a3.setDirection("East");
		env.move(a3);
		assertEquals(4, a3.getRowTrack());
		assertEquals(1, a3.getColTrack());
	}

	/**
	 * Test Human Moves correctly South without obstacles Test Human Moves
	 * correctly South with obstacles
	 */
	@Test
	public void testMoveSouthHuman() 
	{
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
		human3.setDirection("South");
		env.move(human3);
		assertEquals(4, human3.getRowTrack());
		assertEquals(3, human3.getColTrack());
		assertNull(env.getLifeForm(1, 3));
	}

	/**
	 * Test Alien Moves correctly West without obstacles Test Alien Moves
	 * correctly West with obstacles
	 */
	@Test
	public void testMoveWestAlien() 
	{
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
	public void testMoveNorthAlien() 
	{
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
	public void testMoveEastHuman() 
	{
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
	public void testMoveSouthAlien() 
	{
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
	public void testMoveWestHuman() 
	{
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

	/**
	 * @author - Prathyusha Akshintala Test the initialization of the
	 *         Environment.
	 */
	@Test
	public void testInitialization() 
	{
		Environment environ1 = Environment.getWorldInstance();

		// Life form will be null for a newly created Environment.
		assertNull(environ1.getLifeForm(0, 0));
		assertNull(environ1.getLifeForm(1, 1));

		Environment environ2 = Environment.getWorldInstance();
		assertEquals(environ1, environ2);
	}

	/**
	 * Test getWeapon() method.
	 * 
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
		assertEquals(w1, env.getWeapon(0, 0, 1));
		assertEquals(w2, env.getWeapon(0, 0, 2));
	}

	/**
	 * @author - Prathyusha Akshintala Tests to add weapon from a given location
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
		assertFalse(environ1.addWeapon(9, 8, w1, 1));
		assertFalse(environ1.addWeapon(8, 9, w2, 2));
		assertFalse(environ1.addWeapon(9, 9, w1, 1));
	}

	/**
	 * @author - Prathyusha Akshintala Tests to remove weapon from a given
	 *         location
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
		assertEquals(w1, environ1.removeWeapon(1, 2, 1));
		assertEquals(w2, environ1.removeWeapon(1, 2, 2));
		// Border Cases - outside the range
		assertNull(environ1.removeWeapon(9, 8, 1));
		assertNull(environ1.removeWeapon(8, 9, 2));
		assertNull(environ1.removeWeapon(9, 9, 1));
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
	 * Old tests Test the setting of LifeFrom in the Environment.
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

		// Can not add at location 9,0 as rows exceed size
		boolean success = environment.addLifeForm(9, 0, bob);
		assertFalse(success);

		// Can not add at location 0,9 as column exceed size
		success = environment.addLifeForm(0, 9, bob);
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
		// Life form is not added at location 1,4 so it should fail.
		assertNull(environment.removeLifeForm(1, 1));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(1, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 1));
		// Life form is added do it should work.
		 assertEquals(bob, environment.removeLifeForm(1, 2));
	}

	/**
	 * @author - Prathyusha Akshintala Reset environment method is used for
	 *         other tests.
	 */
	public static void resetEnvironment()
	{
		Environment.resetInstance();
	}

}
