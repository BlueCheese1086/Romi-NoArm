// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Specs;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class TurnDegrees extends CommandBase {
  private final Drivetrain drivetrain;
  private final double speed;
  private final double degrees;

  /**
   * Creates a new TurnDegrees command. This command will turn your robot a desired number of degrees at a desired speed.
   *
   * @param drivetrain The subsystem this command will run on.
   * @param speed The speed which the robot will drive.
   * @param degrees The number of degrees the robot will turn.
   */
  public TurnDegrees(Drivetrain drivetrain, double speed, double degrees) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.degrees = degrees;
    addRequirements(drivetrain);
  }

  /** Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
    drivetrain.resetEncoders();
  }

  /** Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    drivetrain.arcadeDrive(0, speed);
  }

  /** Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  /** Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return drivetrain.getAverageDistanceInch() >= (Specs.InchPerDegree * degrees);
  }
}