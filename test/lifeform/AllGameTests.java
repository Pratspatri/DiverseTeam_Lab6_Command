package lifeform;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import ui.command.TestAcquireCommand;
import ui.command.TestAttackCommand;
import ui.command.TestDropCommand;
import ui.command.TestGameDisplay;
import ui.command.TestMoveCommand;
import ui.command.TestReloadCommand;
import ui.command.TestTurnEastCommand;
import ui.command.TestTurnNorthCommand;
import ui.command.TestTurnSouthCommand;
import ui.command.TestTurnWestCommand;
import weapon.TestAttachment;
import weapon.TestChainGun;
import weapon.TestGenericWeapon;
import weapon.TestPistol;
import weapon.TestPlasmaCannon;
import weapon.TestPowerBooster;
import weapon.TestScope;
import weapon.TestStabilizer;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;

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
		TestScope.class, TestStabilizer.class, TestDropCommand.class, TestReloadCommand.class,TestAcquireCommand.class,TestGameDisplay.class,
		TestAttackCommand.class, TestTurnEastCommand.class, TestTurnWestCommand.class, TestTurnNorthCommand.class,
		TestTurnSouthCommand.class,TestMoveCommand.class})
public class AllGameTests
{

}
