// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import static org.wpilib.units.Units.Inches;
import static org.wpilib.units.Units.Millimeters;

import org.wpilib.units.measure.Distance;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * The XRP has the left and right motors set to
     * channels 0 and 1 respectively
     */
    public static final class Motors {
        public static final int LEFT_MOTOR = 0;
        public static final int RIGHT_MOTOR = 1;
    }

    /**
     * The XRP has onboard encoders that are hardcoded
     * to use DIO pins 4/5 and 6/7 for the left and right
     */
    public static final class Encoders {
        public static final int LEFT_A = 4;
        public static final int LEFT_B = 5;
        public static final int RIGHT_A = 6;
        public static final int RIGHT_B = 7;
    }

    public static final class DriveTrain {
        private static final double GEAR_RATIO = (30.0 / 14.0) * (28.0 / 16.0) * (36.0 / 9.0) * (26.0 / 8.0); // 48.75:1
        private static final double COUNTS_PER_MOTOR_SHAFT_REV = 12.0;
        private static final double COUNTS_PER_REVOLUTION = COUNTS_PER_MOTOR_SHAFT_REV * GEAR_RATIO; // 585.0
        private static final Distance WHEEL_DIAMETER = Millimeters.of(60);
        public static final Distance DISTANCE_PER_PULSE = Inches.of((Math.PI * WHEEL_DIAMETER.in(Inches)) / COUNTS_PER_REVOLUTION);
    }
}
