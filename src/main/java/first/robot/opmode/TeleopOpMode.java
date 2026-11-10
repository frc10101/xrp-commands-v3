package first.robot.opmode;

import org.wpilib.command3.Command;
import org.wpilib.command3.button.CommandGamepad;
import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.opmode.Teleop;

import first.robot.Robot;

@Teleop
public class TeleopOpMode extends PeriodicOpMode {
    private final Robot mRobot;
    private final CommandGamepad mGamepad = new CommandGamepad(0);

    public TeleopOpMode(Robot robot) {
        mRobot = robot;

        mRobot.xrpDrivetrain.setDefaultCommand(
            Command.requiring(mRobot.xrpDrivetrain)
            .executing(coroutine -> mRobot.xrpDrivetrain.arcadeDrive(-mGamepad.getLeftY(), -mGamepad.getRightX()))
            .named("Arcade Drive")
        );
    }
}
