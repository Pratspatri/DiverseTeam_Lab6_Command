package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

/**
 * The test cases for the Stabilizer class.
 * @author Prathyusha Akshintala.
 */
public class TestStabilizer
{

	/**
	 * Tests the weapon with only one Stabilizer attachment.
	 * @throws AttachmentException
	 */
	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		Stabilizer stabilizer = new Stabilizer(weapon);
		assertEquals(62, stabilizer.fire(10));
	}

	/**
	 * Tests the weapon with all types of attachment combinations.
	 * @throws AttachmentException
	 */
	@Test
	public void testMultipleAttachment() throws AttachmentException
	{
		Weapon weapon;

		// Scope + Stabilizer.
		weapon = new PlasmaCannon();
		Scope scope = new Scope(weapon);
		Stabilizer stabilizer = new Stabilizer(scope);

		assertEquals(77, stabilizer.fire(15));
		weapon.updateTime(1);
		// distance is out of range
		assertEquals(0, stabilizer.fire(35));

		// Stabilizer +Stabilizer.
		weapon = new PlasmaCannon();
		stabilizer = new Stabilizer(weapon);
		Stabilizer stabilizer2 = new Stabilizer(stabilizer);

		assertEquals(77, stabilizer2.fire(15));
		weapon.updateTime(1); // update round
		assertEquals(0, stabilizer2.fire(35));	// distance out of max range

		// PowerBooster + Stabilizer.
		weapon = new PlasmaCannon();
		PowerBooster booster = new PowerBooster(weapon);
		stabilizer = new Stabilizer(booster);

		assertEquals(108, stabilizer.fire(15));
		weapon.updateTime(1);
		assertEquals(0, stabilizer.fire(35));

	}
	/**
	 * When more than 2 attachments are assigned, we get exception
	 * @throws AttachmentException
	 */
	@Test(expected = AttachmentException.class)
	public void testMaxAttachments() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		PowerBooster booster = new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		Scope scope = new Scope(stabilizer);
	}
}