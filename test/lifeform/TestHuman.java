package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the Human class.
 * @author : Sameer Kumar Kotra
 */
public class TestHuman
{
	/**
	 * Test the default Strength of the Human.
	 */
	@Test
	public void testLifeStrength()
	{
		Human human = new Human("Bob", 40, 20);
		assertEquals(5, human.getAttachStrength());
	}

	/**
	 * Test the take Hit of Human.
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		Human human2 = new Human("Alice", 60, 15);

		lifeForm1.attack(human2);
		// Test when damage< armor
		assertEquals(60, human2.getCurrentLifePoints());

		lifeForm1 = new MockLifeForm("Bob", 40, 20);
		lifeForm1.attack(human2);
		// Test when damage>armor>0
		assertEquals(55, human2.getCurrentLifePoints());

		lifeForm1 = new MockLifeForm("Bob", 40, 15);
		lifeForm1.attack(human2);
		// Test when damage=armor
		assertEquals(55, human2.getCurrentLifePoints());

		lifeForm1 = new MockLifeForm("Bob", 40, 10);
		human2 = new Human("Alice", 60, 0);
		lifeForm1.attack(human2);
		// Test when armor points 0.
		assertEquals(50, human2.getCurrentLifePoints());

		lifeForm1 = new MockLifeForm("Bob", 40, 0);
		human2 = new Human("Alice", 60, 0);
		lifeForm1.attack(human2);
		// Test when damage is 0.
		assertEquals(60, human2.getCurrentLifePoints());

		lifeForm1 = new MockLifeForm("Bob", 40, 20);
		human2 = new Human("Alice", 10, 0);
		lifeForm1.attack(human2);
		// Test when the attack makes human dead.
		assertEquals(0, human2.getCurrentLifePoints());
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the Human.
	 */
	@Test
	public void testInitiization()
	{
		Human human = new Human("Bob", 40, 20);
		assertEquals(20, human.getArmPoints());

		human = new Human("Bob", 40, -20);
		// Can not create with negative armour points.
		assertEquals(0, human.getArmPoints());

	}

	/**
	 * Test the set Arm points of the Human.
	 */
	@Test
	public void testSetArmPoints()
	{
		Human human = new Human("Bob", 40, 30);

		human.setArmPoints(30);
		assertEquals(30, human.getArmPoints());

		// Can not set negative armour points.
		human.setArmPoints(-20);
		assertEquals(0, human.getArmPoints());
	}
}
