package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

/**
 * The test cases for the PowerBooster class.
 * @author Prathyusha Akshintala.
 * @author Sameer Kumar Kotra
 */
public class TestPowerBooster
{

	/**
	 * Tests the weapon with only one PowerBooster attachment.
	 * @throws AttachmentException
	 */
	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new ChainGun();
		PowerBooster booster = new PowerBooster(weapon);
		assertEquals(9, booster.fire(10));
	}

	/**
	 * Tests the weapon with all types of attachment combinations.
	 * @throws AttachmentException
	 */
	@Test
	public void testMultipleAttachment() throws AttachmentException
	{
		Weapon weapon;

		// Scope + PowerBooster.
		weapon = new ChainGun();
		Scope scope = new Scope(weapon);
		PowerBooster booster = new PowerBooster(scope);

		assertEquals(15, booster.fire(10));
		assertEquals(0, booster.fire(35));

		// Stabilizer + PowerBooster.
		weapon = new ChainGun();
		Stabilizer stabilizer = new Stabilizer(weapon);
		booster = new PowerBooster(stabilizer);

		assertEquals(11, booster.fire(10));
		assertEquals(0, booster.fire(35));

		// PowerBooster +PowerBooster.
		weapon = new ChainGun();
		booster = new PowerBooster(weapon);
		PowerBooster booster2 = new PowerBooster(booster);

		assertEquals(17, booster2.fire(10));
		assertEquals(0, booster2.fire(35));
	}

	/**
	 * Tests the maximum number of attachments to a weapon.
	 * @throws AttachmentException
	 */
	@Test(expected = AttachmentException.class)
	public void testMaxAttachments() throws AttachmentException
	{
		Weapon weapon = new ChainGun();
		PowerBooster booster = new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		Scope scope = new Scope(stabilizer);
	}
}
