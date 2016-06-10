/**
 * Team Members:Malak BaSSAM
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 *  Tests the functionality provided by the LifeForm class   
 */
public class TestLifeForm 
{
	//Lab 6
	
	/**
	 * Test The default direction for any lifeform is North
	 */
	@Test
 	public void testDefaultDirection()
 	{
		LifeForm entity1 = new MockLifeForm("Bob", 40,5);
		assertEquals("North",entity1.getDirection());
 	}
	/**
	 * Test that could  direction for any lifeform 
	 */
	@Test
 	public void testChangeDirection()
 	{
		LifeForm entity1 = new MockLifeForm("Bob", 40,5);
		assertEquals("North",entity1.getDirection());
		entity1.setDirection("East");
		assertEquals("East",entity1.getDirection());
 	}
	@Test
 	public void testDefaultMaxSpeed()
 	{
		LifeForm entity1 = new MockLifeForm("Bob", 40,5);
		assertEquals(0,entity1.getMaxSpeed());
		entity1.setMaxSpeed(4);
		assertEquals(4,entity1.getMaxSpeed());
 	}
	
	
	/**
	 * Singleton Pattern
	 * Update decoder and observer pattern to use Environment to compute distance
	 */
	
//	@Test
//	public void testWeaponDamage() throws MyNewException
//	{
//		// test for pistol weapon
//		LifeForm entity1 = new MockLifeForm("Bob", 40,5);
//		LifeForm entity2 = new MockLifeForm("fred", 20,5);
//		 Environment.getWorldInstance().addLifeForm(0, 0, entity1);
//		 Environment.getWorldInstance().addLifeForm(0, 2, entity2);
//		Pistol pw = new Pistol();
//		//uses weapon for damage with ammo.
//		entity1.pickup(pw);
//		entity1.attack(entity2);
//		assertEquals(12,entity2.currentLifePoints);
//		assertEquals(9,pw.getActualAmmo(),.01);
//		//use attack strength for damage if weapon has no ammo.
//		pw.setActualAmmo(0);
//		entity1.attack(entity2);
//		assertEquals(12,entity2.currentLifePoints);
//		assertEquals(0,pw.getActualAmmo(),.01);
//	    // attacks strength does 0 damage if range >10 feet
//		entity1.attack(entity2); 
//		assertEquals(12,entity2.currentLifePoints);
//		assertEquals(0,pw.getActualAmmo(),.01);
//		//can reload
//		pw.setActualAmmo(0);
//		pw.relod();
//		assertEquals(pw.getMaxAmmo(),pw.getActualAmmo(),.01);
//		//test two different range
//		//out of range
//		LifeForm entity33 = new MockLifeForm("fred", 20,5);
//		 Environment.getWorldInstance().addLifeForm(4, 4, entity33);
//		entity1.attack(entity33);
//		assertEquals(20,entity33.currentLifePoints);
//		// test for  weapon Chain gun
//		LifeForm entity3 = new MockLifeForm("Bob", 40,5);
//		LifeForm entity4 = new MockLifeForm("fred", 20,5);
//		Environment.getWorldInstance().addLifeForm(0, 3, entity3);
//		 Environment.getWorldInstance().addLifeForm(1,3, entity4);
//		Chain_Gun cg=new Chain_Gun();		
//		//uses weapon for damage with ammo.
//		entity3.pickup(cg);
//		entity3.attack(entity4);
//		assertEquals(18,entity4.currentLifePoints);
//		assertEquals(39,cg.getActualAmmo(),.01);
//		//use attack strength for damage if weapon has no ammo.
//		cg.setActualAmmo(0);
//		entity3.attack(entity4);
//		assertEquals(13,entity4.currentLifePoints);
//		assertEquals(0,cg.getActualAmmo(),.01);
//	    // attacks strength does 0 damage if range >10 feet
//		entity3.attack(entity1);
//		assertEquals(40,entity1.currentLifePoints);
//		assertEquals(0,cg.getActualAmmo(),.01);
//		//can reload
//		cg.setActualAmmo(0);
//		cg.relod();
//		assertEquals(cg.getMaxAmmo(),cg.getActualAmmo(),.01);
//		// test for  weapon Plasma_Connon
//		LifeForm entity5 = new MockLifeForm("Bob", 40,5);
//		LifeForm entity6 = new MockLifeForm("fred", 100,5);
//		Environment.getWorldInstance().addLifeForm(2, 3, entity5);
//		 Environment.getWorldInstance().addLifeForm(3,3, entity6);
//		Plasma_Connon pc=new Plasma_Connon();		
//		//uses weapon for damage with ammo.
//		entity5.pickup(pc);
//		entity5.attack(entity6);
//		assertEquals(50,entity6.currentLifePoints);
//		assertEquals(3,pc.getActualAmmo(),.01);
//		//use attack strength for damage if weapon has no ammo.
//		((Plasma_Connon ) pc).setActualAmmo(0);
//		entity5.attack(entity6);
//		assertEquals(45,entity6.currentLifePoints);
//		assertEquals(0,pc.getActualAmmo(),.01);
//	    // attacks strength does 0 damage if range >10 feet
//		entity5.attack(entity1);
//		assertEquals(40,entity1.currentLifePoints);
//		//can reload
//		((Plasma_Connon ) pc).setActualAmmo(0);
//		pc.relod();
//		assertEquals(cg.getMaxAmmo(),cg.getActualAmmo(),.01);	
//	}
//	
//	/**
//	 * To check for attack when set new value to attack,
//	 *  and as default.
//	 * @throws MyNewException 
//	 */
//	@Test
//	public void testAttack() throws MyNewException
//	{    	
//		 LifeForm entity1 = new MockLifeForm("Bob", 40,5);
//		 LifeForm entity2 = new MockLifeForm("fred", 20,2);
//		 Environment.getWorldInstance().addLifeForm(1, 1, entity1);
//		 Environment.getWorldInstance().addLifeForm(3, 1, entity2);
//		 //getAttacksstrength
//		 assertEquals(5,entity1.getAttack());
//		 assertEquals(2,entity2.getAttack());
//		 
//		 //Attack method
//		 entity1.pickup(new Pistol());
//		 entity1.attack(entity2);
//		 assertEquals(12, entity2.getCurrentLifePoints());
//		
//		// A LifeForm with CurrentLifePoints=0 do not cause damage
//		 LifeForm entity3 = new MockLifeForm("Bob", 0,5);
//		 LifeForm entity4 = new MockLifeForm("fred", 20,2);
//		 Environment.getWorldInstance().addLifeForm(0, 1, entity3);
//		 Environment.getWorldInstance().addLifeForm(1,0, entity4);
//		 entity3.pickup(new Pistol());
//		 entity3.attack(entity4);
//		 assertEquals(20, entity4.getCurrentLifePoints());	 
//	}
//	//All these test bellow for decoder pattern
//	
//	/**
//	 * Test if life form can pick up and drop the weapon
//	 */
//	@Test
//	public void pickupAndRemoveWeapon()
//	{
//		LifeForm entity1 = new MockLifeForm("Bob", 40,5);
//		Pistol pw = new Pistol();
//		Pistol pw2 = new Pistol();
//		//can pickup a weapon
//		entity1.pickup(pw);
//		assertEquals(entity1.weapon,pw);
//		//cannot pickup another weapon
//		entity1.pickup(pw2);
//		assertEquals(entity1.weapon,pw);
//		//Drop a weapon
//		entity1.drop();
//		assertNull(entity1.weapon);
//	}
//	/**
//	 * Test damage for the lifeform either with weapon or not
//	 * @throws MyNewException 
//	 */
//
//	/**
//	 * can track passage of time. 
//	 */
//	@Test
//	public void testUpdateTime()
//	{
//		LifeForm entity1; 
//		entity1 = new MockLifeForm("Bob", 40,5);
//		entity1.updateTime(5);
//		assertEquals(5,entity1.time);
//	}
//	
//	//All these test bellow for Strategy Pattern
//
//  /**
//   * When a LifeForm is created, it should know its name and how   
//   * many life points it has.    
//   */      
//	@Test
//	public void testInitialization()  
//	 {  
//		LifeForm entity ; 
//		entity = new MockLifeForm("Bob", 40,5);  
//	    assertEquals("Bob", entity.getName());  
//	    assertEquals(40, entity.getCurrentLifePoints());
//	 } 
//	
//	/**
//	 * Test value of currentLifePoints after call takeHit method
//	 */
//	@Test
//	public void testtakehit() 
//	{
//		LifeForm entity ; 
//		entity = new MockLifeForm("Bob", 40,5);
//		//takeHit after the first attack when 
//		entity.takeHit(20);
//		assertEquals(20,entity.getCurrentLifePoints());
//		// takeHit when currentLP>0
//		entity.takeHit(5);
//		assertEquals(15,entity.getCurrentLifePoints());
//		// takeHit when currentLP=0
//		entity.takeHit(15);
//		assertEquals(0,entity.getCurrentLifePoints());
//		}
}


