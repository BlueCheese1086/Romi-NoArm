// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;

import frc.robot.subsystems.Drivetrain.Commands.Autonomous.Autonomous;
import frc.robot.subsystems.Drivetrain.Commands.TeleOp.ArcadeDrive;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.OnBoardIO.OnBoardIO;
import frc.robot.subsystems.OnBoardIO.OnBoardIO.ChannelMode;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods other than scheduler calls. This being the case, the structure of the robot should be declared here.
 */
public class RobotContainer {
  // Creates the various subsystems for the robot.
  private final Drivetrain drivetrain = new Drivetrain();
  private final OnBoardIO onboardIO = new OnBoardIO(ChannelMode.INPUT, ChannelMode.INPUT);

  // Creates the controller that drives the robot. (I made a class for a Bluetooth SNES Controller.)
  //Buy them here: https://www.amazon.com/Controller-iNNEXT-Compatible-Raspberry-Rechargeable/dp/B07XM5FR1L/
  private final SNESController snesController = new SNESController(0);

  // NOTE: The I/O pin functionality of the 5 exposed I/O pins depends on the hardware "overlay"
  // that is specified when launching the wpilib-ws server on the Romi raspberry pi.
  // Your subsystem configuration should take any overlays into account

  /** The container for the robot. Contains subsystems, IO devices, and commands. */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.
   * Buttons can be created by instantiating a {@link GenericHID}
   * or one of its subclasses such as {@link Joystick},
   * and then passing it to a {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    // Example of how to use the onboard IO
    Trigger aButton = new Trigger(onboardIO::getButtonAPressed);
    Trigger bButton = new Trigger(onboardIO::getButtonBPressed);
    Trigger cButton = new Trigger(onboardIO::getButtonCPressed);
    aButton.onTrue(new PrintCommand("Button A Pressed"));
    aButton.onFalse(new PrintCommand("Button A Released"));
    bButton.onTrue(new PrintCommand("Button B Pressed"));
    bButton.onFalse(new PrintCommand("Button B Released"));
    cButton.onTrue(new PrintCommand("Button C Pressed"));
    cButton.onFalse(new PrintCommand("Button C Released"));
  }

  /**
   * Passes the autonomous command to the {@link Robot} class.
   *
   * @return The command to run in autonomous.
   */
  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain);
  }

  /**
   * Passes the teleop command to the {@link Robot} class.
   *
   * @return The command to run in teleop.
   */
  public Command getTeleopCommand() {
    return new ArcadeDrive(drivetrain, () -> -snesController.getRawAxis(1), () -> -snesController.getRawAxis(0));
  }
}