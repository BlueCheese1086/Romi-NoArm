// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private Command teleopCommand;

  /** This function is run when the robot is first started. */
  @Override
  public void robotInit() {
    // Creates our RobotContainer.
    RobotContainer robotContainer = new RobotContainer();

    // Gets commands from the RobotContainer class.
    autonomousCommand = robotContainer.getAutonomousCommand();
    teleopCommand = robotContainer.getTeleopCommand();
  }

  /** This function is called every 20 ms, no matter the mode. */
  @Override
  public void robotPeriodic() {
    // Runs the scheduler.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once when the autonomous mode is initially started. */
  @Override
  public void autonomousInit() {
    autonomousCommand.schedule();
  }

  /** This function is called once when the autonomous mode is exited. */
  @Override
  public void autonomousExit() {
    autonomousCommand.cancel();
  }

  /** This function is called once when the teleop mode is initially started. */
  @Override
  public void teleopInit() {
    teleopCommand.schedule();
  }

  /** This function is called once when the teleop mode is exited. */
  @Override
  public void teleopExit() {
    teleopCommand.cancel();
  }
}