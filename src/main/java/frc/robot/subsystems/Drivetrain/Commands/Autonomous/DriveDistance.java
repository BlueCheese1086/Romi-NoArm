// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

public class DriveDistance extends CommandBase {
  private final double speed;
  private final double distance;
  private final Drivetrain drive;

  /**
   * Creates a new DriveDistance command. This command will drive your your robot for a desired number of inches at a desired speed.
   *
   * @param speed The speed which the robot will drive.
   * @param distance The number of inches the robot will drive.
   * @param drive The drivetrain subsystem on which this command will run.
   */
  public DriveDistance(double speed, double distance, Drivetrain drive) {
    this.speed = speed;
    this.distance = distance;
    this.drive = drive;
    addRequirements(drive);
  }

  // This command is called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.arcadeDrive(0, 0);
    drive.resetEncoders();
  }

  // This command is called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(speed, 0);
  }

  // This command is called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // This command returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return Math.abs(drive.getAverageDistanceInch()) >= distance;
  }
}