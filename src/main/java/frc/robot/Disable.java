// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Disable extends CommandBase {
  /**
   * Creates a new Disable. This command will disable the robot.
   */
  public Disable() {}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    try {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_F5);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_F5);
    } catch (AWTException e) {}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
