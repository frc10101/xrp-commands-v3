package first.robot.opmode;

import org.wpilib.opmode.Autonomous;
import org.wpilib.opmode.PeriodicOpMode;

import first.robot.Robot;

@Autonomous
public class AutoOpMode extends PeriodicOpMode {
    private final Robot mRobot;

    public AutoOpMode(Robot robot) {
        mRobot = robot;
    }
}
