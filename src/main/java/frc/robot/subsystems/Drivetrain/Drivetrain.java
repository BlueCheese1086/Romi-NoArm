// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.Encoders;
import frc.robot.Constants.Motors;
import frc.robot.Constants.RobotMap;
import frc.robot.sensors.RomiGyro;

// Handles the main drivetrain of the romi.
public class Drivetrain extends SubsystemBase {
  // Makes the motors
  private final Spark leftMotor = new Spark(RobotMap.LEFTMOTOR);
  private final Spark rightMotor = new Spark(RobotMap.RIGHTMOTOR);

  // Makes the encoders
  private final Encoder leftEncoder = new Encoder(RobotMap.LEFTAENCODER, RobotMap.LEFTBENCODER);
  private final Encoder rightEncoder = new Encoder(RobotMap.RIGHTAENCODER, RobotMap.RIGHTBENCODER);

  // Makes a gyro
  private final RomiGyro gyro = new RomiGyro();

  // Makes an accelerometer
  private final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();

  /** Creates a new Drivetrain subsystem. */
  public Drivetrain() {
    // Inverts the right motor.
    rightMotor.setInverted(true);

    // Uses inches as unit for encoder distances
    leftEncoder.setDistancePerPulse(Encoders.DistPerPulse);
    rightEncoder.setDistancePerPulse(Encoders.DistPerPulse);
    resetEncoders();
  }

  /** Sets the speed of the motors. */
  public void arcadeDrive(double xAxisSpeed, double zAxisRotate) {
    // Applies a deadband to the inputs
    xAxisSpeed = (xAxisSpeed > Motors.DEADBAND || xAxisSpeed < -Motors.DEADBAND) ? xAxisSpeed : 0;
    zAxisRotate = (zAxisRotate > Motors.DEADBAND || zAxisRotate < -Motors.DEADBAND) ? zAxisRotate : 0;

    // Applies a limit to the turn speed
    zAxisRotate *= Motors.MAX_TURN;

    // Creates the saturated speeds of the motors
    double leftSpeed = xAxisSpeed - zAxisRotate;
    double rightSpeed = xAxisSpeed + zAxisRotate;

    // Finds the maximum possible value of throttle + turn along the vector that the joystick is pointing, and then desaturates the wheel speeds.
    double greaterInput = Math.max(Math.abs(xAxisSpeed), Math.abs(zAxisRotate));
    double lesserInput = Math.min(Math.abs(xAxisSpeed), Math.abs(zAxisRotate));
    if (greaterInput == 0.0) {
      leftSpeed = 0;
      rightSpeed = 0;
    } else {
      double saturatedInput = (greaterInput + lesserInput) / greaterInput;
      leftSpeed /= saturatedInput;
      rightSpeed /= saturatedInput;
    }

    // Sets the speed of the motors, applying any limitations to the overall speed of the robot.
    leftMotor.set(leftSpeed * Motors.MAX_SPEED);
    rightMotor.set(rightSpeed * Motors.MAX_SPEED);
  }

  /** Returns the number of times the left motor has fully rotated. */
  public int getLeftEncoderCount() {
    return leftEncoder.get();
  }

  /** Returns the number of times the right motor has fully rotated. */
  public int getRightEncoderCount() {
    return rightEncoder.get();
  }

  /** Returns the average number of times both motors have fully rotated. */
  public double getAverageEncoderCount() {
    return (getLeftEncoderCount() + getRightEncoderCount()) / 2.0;
  }

  /** Returns the distance traveled by the left motor in inches. */
  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  /** Returns the distance traveled by the right motor in inches. */
  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }

  /** Returns the average distance traveled by each motor in inches. */
  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  /** Returns the acceleration of the Romi along the X-axis in Gs. */
  public double getAccelX() {
    return accelerometer.getX();
  }

  /** Returns the acceleration of the Romi along the Y-axis in Gs. */
  public double getAccelY() {
    return accelerometer.getY();
  }

  /** Returns the acceleration of the Romi along the Z-axis in Gs. */
  public double getAccelZ() {
    return accelerometer.getZ();
  }

  /** Returns the current angle of the Romi around the X-axis in degrees. */
  public double getGyroAngleX() {
    return gyro.getAngleX();
  }

  /** Returns the current angle of the Romi around the Y-axis in degrees. */
  public double getGyroAngleY() {
    return gyro.getAngleY();
  }

  /** Returns the current angle of the Romi around the Z-axis in degrees. */
  public double getGyroAngleZ() {
    return gyro.getAngleZ();
  }

  /** Resets the gyro. */
  public void resetGyro() {
    gyro.reset();
  }

  /** Resets the encoders. */
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }
}