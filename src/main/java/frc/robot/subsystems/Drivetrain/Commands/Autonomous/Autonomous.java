// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class Autonomous extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run.
   */
  public Autonomous(Drivetrain drivetrain) {
    addCommands(
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(-1, 180, drivetrain),
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(1, 180, drivetrain)
    );
  }
}