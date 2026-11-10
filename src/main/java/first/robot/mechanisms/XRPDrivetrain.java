// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.mechanisms;

import static org.wpilib.units.Units.Inches;

import org.wpilib.command3.Mechanism;
import org.wpilib.drive.DifferentialDrive;
import org.wpilib.hardware.rotation.Encoder;
import org.wpilib.xrp.XRPMotor;

import first.robot.Constants.DriveTrain;
import first.robot.Constants.Encoders;
import first.robot.Constants.Motors;

public class XRPDrivetrain implements Mechanism {
  private final XRPMotor leftMotor = new XRPMotor(Motors.LEFT_MOTOR);
  private final XRPMotor rightMotor = new XRPMotor(Motors.RIGHT_MOTOR);

  private final Encoder leftEncoder = new Encoder(Encoders.LEFT_A, Encoders.LEFT_B);
  private final Encoder rightEncoder = new Encoder(Encoders.RIGHT_A, Encoders.RIGHT_B);

  // Set up the differential drive controller
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor::setThrottle, rightMotor::setThrottle);

  /** Creates a new XRPDrivetrain. */
  public XRPDrivetrain() {
    // Use inches as unit for encoder distances
    leftEncoder.setDistancePerPulse(DriveTrain.DISTANCE_PER_PULSE.in(Inches));
    rightEncoder.setDistancePerPulse(DriveTrain.DISTANCE_PER_PULSE.in(Inches));
    resetEncoders();

    // Invert right side since motor is flipped
    leftMotor.setInverted(false);
    rightMotor.setInverted(true);
  }

  public void arcadeDrive(double xaxisVelocity, double zaxisRotate) {
    diffDrive.arcadeDrive(xaxisVelocity, zaxisRotate);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }
}
