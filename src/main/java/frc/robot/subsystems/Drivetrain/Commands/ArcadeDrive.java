// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

public class ArcadeDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private final Supplier<Double> xaxisSpeedSupplier;
  private final Supplier<Double> zaxisRotateSupplier;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to the speed suppliers.
   *
   * @param drivetrain The subsystem this command will run on.
   * @param xaxisSpeedSupplier Lambda supplier of forward/backward speed.
   * @param zaxisRotateSupplier Lambda supplier of rotational speed.
   */
  public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xaxisSpeedSupplier, Supplier<Double> zaxisRotateSupplier) {
    this.drivetrain = drivetrain;
    this.xaxisSpeedSupplier = xaxisSpeedSupplier;
    this.zaxisRotateSupplier = zaxisRotateSupplier;
    addRequirements(drivetrain);
  }

  /** Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    drivetrain.arcadeDrive(xaxisSpeedSupplier.get(), zaxisRotateSupplier.get());
  }

  /** Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}