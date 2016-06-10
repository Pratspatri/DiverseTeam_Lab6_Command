package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryException;
import gameplay.SimpleTimer;
import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;

/**
 * The test cases for the Alien class.
 * @author : Sameer Kumar Kotra
 */
public class TestAlien
{

	/**
	 * Test the default Strength of the Alien.
	 */
	@Test
	public void testLifeStrength()
	{
		Alien alien = new Alien("Bob", 40);
		assertEquals(10, alien.getAttachStrength());
	}

	/**
	 * Test set Recovery rate when >= 0.
	 * @throws RecoveryException
	 */
	@Test
	public void testSetRecoveryRate() throws RecoveryException
	{
		RecoveryBehavior rb = new RecoveryLinear(5);
		Alien alien = new Alien("Bob", 40, rb, 1);
		// Recovery rate 1.
		assertEquals(1, alien.getRecoveryRate());
		alien.setRecoveryRate(2);
		assertEquals(2, alien.getRecoveryRate());
		alien.setRecoveryRate(0);
		assertEquals(0, alien.getRecoveryRate());
	}

	/**
	 * Test the recovery rate at 0
	 * @throws RecoveryException
	 * @throws InterruptedException
	 */
	@Test
	public void testRecoveryRate() throws RecoveryException, InterruptedException
	{
		RecoveryBehavior rb = new RecoveryLinear(2);
		// Recovery rate 0.
		Alien alien = new Alien("Bob", 20, rb, 0);
		Human human = new Human("Alice", 30, 10);
		SimpleTimer st = new SimpleTimer(1000);
		st.addTimeObserver(alien);

		for (int x = 20; x >= 0; x = x - 5)
		{
			assertEquals(x, alien.getCurrentLifePoints());
			human.attack(alien);// Attacks alien reduces 5 points
			st.updateRound();
			st.timeChanged();
		}
	}

	/**
	 * Test the recovery when rate 2
	 * @throws RecoveryException
	 * @throws InterruptedException
	 */
	@Test
	public void testRecoveryRate1() throws RecoveryException, InterruptedException
	{
		RecoveryBehavior rb = new RecoveryLinear(2);
		// Recovery rate is 2.
		Alien alien = new Alien("Bob", 20, rb, 2);
		Human human = new Human("Alice", 30, 10);
		SimpleTimer st = new SimpleTimer(1000);
		int expectedPoints = alien.getCurrentLifePoints();
		st.addTimeObserver(alien);

		for (int x = 1; x <= 4; x++)
		{
			assertEquals(expectedPoints, alien.getCurrentLifePoints());
			human.attack(alien);// Attacks alien reduces 5 points
			if (x % 2 == 0)
				expectedPoints += 2;
			expectedPoints -= 5;
			st.updateRound();
			st.timeChanged();
		}
	}

	/**
	 * Test the recovery when rate 3
	 * @throws RecoveryException
	 * @throws InterruptedException
	 */
	@Test
	public void testRecoveryRate2() throws RecoveryException, InterruptedException
	{
		RecoveryBehavior rb = new RecoveryLinear(2);
		// Recovery rate is 3.
		Alien alien = new Alien("Bob", 20, rb, 3);
		Human human = new Human("Alice", 30, 10);
		SimpleTimer st = new SimpleTimer(1000);
		int expectedPoints = alien.getCurrentLifePoints();
		st.addTimeObserver(alien);

		for (int x = 1; x <= 4; x++)
		{
			assertEquals(expectedPoints, alien.getCurrentLifePoints());
			human.attack(alien);// Attacks alien reduces 5 points
			if (x % 3 == 0)
				expectedPoints += 2;
			expectedPoints -= 5;
			st.updateRound();
			st.timeChanged();
		}

	}

	/**
	 * Test remove observer.
	 * @throws RecoveryException
	 * @throws InterruptedException
	 */
	@Test
	public void testRemoveObserver() throws RecoveryException, InterruptedException
	{
		RecoveryBehavior rb = new RecoveryLinear(2);
		// Recovery rate is 2.
		Alien alien = new Alien("Bob", 23, rb, 2);
		Human human = new Human("Alice", 30, 10);
		SimpleTimer st = new SimpleTimer(1000);
		int expectedPoints = alien.getCurrentLifePoints();
		st.addTimeObserver(alien);

		for (int x = 1; x <= 2; x++)
		{
			assertEquals(expectedPoints, alien.getCurrentLifePoints());
			human.attack(alien);// Attacks alien reduces 5 points
			if (x % 2 == 0)
				expectedPoints += 2;
			expectedPoints -= 5;
			st.updateRound();
			st.timeChanged();
		}
		assertEquals(15, alien.getCurrentLifePoints());
		st.removeTimeObserver(alien);

		for (int x = 15; x >= 0; x = x - 5)
		{
			assertEquals(x, alien.getCurrentLifePoints());
			human.attack(alien);// Attacks alien reduces 5 points
			st.updateRound();
			st.timeChanged();
		}
	}

	/**
	 * Test constructor Recovery rate when <0.
	 * @throws RecoveryException
	 */
	@Test(expected = RecoveryException.class)
	public void testSetRecoveryRateException() throws RecoveryException
	{
		RecoveryBehavior rb = new RecoveryLinear(5);
		Alien alien = new Alien("Bob", 40, rb, -1);
	}

	/**
	 * Test set Recovery rate when <0.
	 * @throws RecoveryException
	 */
	@Test(expected = RecoveryException.class)
	public void testSetRecoveryRateException1() throws RecoveryException
	{
		RecoveryBehavior rb = new RecoveryLinear(5);
		Alien alien = new Alien("Bob", 40, rb, 1);
		alien.setRecoveryRate(-5);
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the Alien.
	 */
	@Test
	public void testInitiization()
	{
		Alien alien = new Alien("Bob", 40);
		assertEquals("Bob", alien.getName());
		assertEquals(40, alien.getCurrentLifePoints());

		alien = new Alien("Bob", -40);
		alien.recover();
		assertEquals(0, alien.getCurrentLifePoints());

		RecoveryBehavior rb = new RecoveryLinear(5);
		alien = new Alien("Bob", 40, rb);
		alien.takeHit(20);

		alien.recover();
		// Test with RecovaryLinear.
		assertEquals(25, alien.getCurrentLifePoints());
	}

	/**
	 * Test set current life points of Aliean.
	 */
	@Test
	public void testSetCurrentLifePoints()
	{
		Alien alien = new Alien("Bob", 40);

		alien.setCurrentLifePoints(30);
		assertEquals(30, alien.getCurrentLifePoints());

		alien.setCurrentLifePoints(-30);
		// Can not set negative values.
		assertEquals(0, alien.getCurrentLifePoints());

		alien.setCurrentLifePoints(50);
		// Can not set values more than the max life points in this case it is
		// 40.
		assertEquals(0, alien.getCurrentLifePoints());

	}

}
