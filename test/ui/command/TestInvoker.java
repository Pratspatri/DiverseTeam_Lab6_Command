package ui.command;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import weapon.MockGenericWeapon;
import weapon.Weapon;
import environment.Environment;

public class TestInvoker 
{
	@Test
	public void testButtonClick()
	{
		Environment env = Environment.getWorldInstance();
		LifeForm life = new MockLifeForm("Bob",60);
		env.addLifeForm(3, 3, life);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		life.setMaxSpeed(1);
		life.setDirection("North");
		
		//move north
		in.move.doClick();
		assertEquals(life,env.getLifeForm(2, 3));
		
		//pick up weapon
		Weapon wp = new MockGenericWeapon(50,12,5,5);
		env.addWeapon(2, 3, wp, 1);
		in.acquire.doClick();
		assertEquals(wp,life.getWeapon());
		assertNull(env.getWeapon(2, 3, 1));
		
		in.drop.doClick();
		assertNull(life.getWeapon());
		assertEquals(wp,env.getWeapon(2, 3, 1));
		
		
		
	}

}
