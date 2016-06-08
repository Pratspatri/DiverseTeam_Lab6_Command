package lifeform;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import weapon.TestAttachment;
import weapon.TestChainGun;
import weapon.TestGenericWeapon;
import weapon.TestPistol;
import weapon.TestPlasmaCannon;
import weapon.TestPowerBooster;
import weapon.TestScope;
import weapon.TestStabilizer;

/**
 * Test Suit contains all Test Classes.
 * New @author - Prathyusha Akshintala
 * Previous existing file @author Sameer Kumar Kotra
 */
@RunWith(Suite.class)
@SuiteClasses(
{ TestAlien.class, TestHuman.class, TestLifeForm.class, TestCell.class, TestEnvironment.class, TestSimpleTimer.class,
		TestRecoveryFractional.class, TestRecoveryLinear.class, TestRecoveryNone.class, TestAttachment.class,
		TestChainGun.class, TestGenericWeapon.class, TestPistol.class, TestPlasmaCannon.class, TestPowerBooster.class,
		TestScope.class, TestStabilizer.class })
public class AllGameTests
{

}
