// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

import java.util.function.Supplier;

public class ArcadeDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private final Supplier<Double> xSpeedSupplier;
  private final Supplier<Double> zRotationSupplier;

  /**
   * Creates a new ArcadeDrive command. This command will drive your robot according to the speed suppliers.
   *
   * @param drivetrain The subsystem on which this command will run.
   * @param xSpeedSupplier Lambda supplier of forward/backward speed.
   * @param zRotationSupplier Lambda supplier of rotational speed.
   */
  public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
    this.drivetrain = drivetrain;
    this.xSpeedSupplier = xSpeedSupplier;
    this.zRotationSupplier = zRotationSupplier;
    addRequirements(drivetrain);
  }

  // This function is called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // This function is called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(xSpeedSupplier.get(), zRotationSupplier.get());
  }

  // This function is called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // This function returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}