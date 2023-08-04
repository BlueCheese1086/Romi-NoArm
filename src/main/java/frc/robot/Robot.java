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
  private RobotContainer robotContainer;

  /** This function is run when the robot is first started. */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.
    robotContainer = new RobotContainer();

    // Gets commands from the RobotContainer class.
    autonomousCommand = robotContainer.getAutonomousCommand();
    teleopCommand = robotContainer.getTeleopCommand();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters the Disabled mode. */
  @Override
  public void disabledInit() {
    // Cancels all scheduled commands.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Disabled mode. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once each time the robot enters the Autonomous mode. */
  @Override
  public void autonomousInit() {
    // Cancels all scheduled commands.
    CommandScheduler.getInstance().cancelAll();

    // Starts the autonomous command.
    autonomousCommand.schedule();
  }

  /** This function is called periodically during the Autonomous mode. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once each time the robot enters the Teleop mode. */
  @Override
  public void teleopInit() {
    // Cancels all scheduled commands.
    CommandScheduler.getInstance().cancelAll();

    // Starts the teleop command.
    teleopCommand.schedule();
  }

  /** This function is called periodically during the Teleop mode. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once each time the robot enters the Test mode. */
  @Override
  public void testInit() {
    // Cancels all scheduled commands.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Test mode. */
  @Override
  public void testPeriodic() {}
}