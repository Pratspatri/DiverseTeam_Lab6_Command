package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.AttachmentException;

/**
 * The test cases for the Attachment class.
 * @author Prathyusha Akshintala.
 */
public class TestAttachment
{

	/**
	 * Tests the maximum number of attachments added to the Weapon.
	 * @throws AttachmentException
	 */
	@Test(expected = AttachmentException.class)
	public void testInitilization() throws AttachmentException
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		Attachment attach = new MockAttachment(weapon);
		assertTrue(attach instanceof Weapon);
		assertEquals(weapon, attach.weapon);

		Attachment attach2 = new MockAttachment(attach);

		Attachment attch3 = new MockAttachment(attach2);
	}
}