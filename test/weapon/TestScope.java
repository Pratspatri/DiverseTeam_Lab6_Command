package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

/**
 * The test cases for the Scope class.
 * @author Sameer Kumar Kotra
 */
public class TestScope
{

	/**
	 * Tests the weapon with only one scope attachment.
	 * @throws AttachmentException
	 */
	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new Pistol();
		Scope scope = new Scope(weapon);
		assertEquals(12, scope.fire(10));
	}

	/**
	 * Tests the weapon with all types of attachment combinations.
	 * @throws AttachmentException
	 */
	@Test
	public void testMultipleAttachment() throws AttachmentException
	{
		Weapon weapon;

		// Scope + Scope
		weapon = new Pistol();
		Scope scope = new Scope(weapon);
		Scope scope2 = new Scope(scope);

		assertEquals(19, scope2.fire(10));
		assertEquals(0, scope2.fire(30));

		// Stabilizer + Scope
		weapon = new Pistol();
		Stabilizer stabilizer = new Stabilizer(weapon);
		scope = new Scope(stabilizer);

		assertEquals(16, scope.fire(10));
		assertEquals(0, scope.fire(30));

		// PowerBoster + Scope.
		weapon = new Pistol();
		PowerBooster booster = new PowerBooster(weapon);
		scope = new Scope(booster);

		assertEquals(24, scope.fire(10));
		assertEquals(0, scope.fire(30));

	}

	/**
	 * Tests the maximum number of attachments to a weapon.
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
