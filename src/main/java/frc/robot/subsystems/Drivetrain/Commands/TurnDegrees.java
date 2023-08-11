// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

public class TurnDegrees extends CommandBase {
  private final double speed;
  private final double degrees;
  private final Drivetrain drivetrain;

  /**
   * Creates a new TurnDegrees command. This command will turn the robot a desired number of degrees at a desired speed.
   *
   * @param speed The speed which the robot will drive.
   * @param degrees The number of degrees the robot will turn.
   * @param drivetrain The subsystem this command will run on.
   */
  public TurnDegrees(double speed, double degrees, Drivetrain drivetrain) {
    this.speed = speed;
    this.degrees = degrees;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  /** This function is called when the command is initially scheduled. */
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
    drivetrain.resetEncoders();
  }

  /** This function is called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    drivetrain.arcadeDrive(0, speed);
  }

  /** This function is called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  /** This function returns true when the command should end. */
  @Override
  public boolean isFinished() {
    // Need to convert distance travelled to degrees. The Standard Romi Chassis has a wheel placement diameter (149 mm) - width of the wheel (8 mm) = 141 mm, or 5.551 inches.
    double inchPerDegree = Math.PI * 5.551 / 360;
    // Compare distance travelled from start to distance based on degree turn.
    return drivetrain.getAverageDistanceInch() >= (inchPerDegree * degrees);
  }
}