// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

public class DriveDistance extends CommandBase {
  private final Drivetrain drivetrain;
  private final double speed;
  private final double distance;

  /**
   * Creates a new DriveDistance command. This command will drive your your robot for a desired number of inches at a desired speed.
   *
   * @param drivetrain The subsystem this command will run on.
   * @param speed The speed which the robot will drive.
   * @param distance The number of inches the robot will drive.
   * 
   */
  public DriveDistance(Drivetrain drivetrain, double speed, double distance) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.distance = distance;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
    drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.getAverageDistanceInch()) >= distance;
  }
}