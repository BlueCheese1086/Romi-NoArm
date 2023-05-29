// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.OnBoardIO;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

/**
 * <p> This class represents the onboard IO of the Romi robot. This includes the pushbuttons and LEDs. </p>
 * <ul>
 *     <li> DIO 0 
 *     <ul>
 *         <li> A Button - Input
 *     </ul>
 *     <li> DIO 1
 *     <ul>
 *         <li> B Button - Input
 *         <li> Green LED - Output
 *     </ul>
 *     <li> DIO 2
 *     <ul>
 *         <li> C Button - Input
 *         <li> Red LED - Output
 *     </ul>
 *     <li> DIO 3
 *     <ul>
 *         <li> Yellow LED - Output
 *     </ul>
 * </ul>
 */
public class OnBoardIO extends SubsystemBase {
  private final DigitalInput buttonA = new DigitalInput(RobotMap.ABUTTON);
  private final DigitalOutput yellowLed = new DigitalOutput(RobotMap.YELLOWLED);

  // DIO 1
  private DigitalInput buttonB;
  private DigitalOutput greenLed;

  // DIO 2
  private DigitalInput buttonC;
  private DigitalOutput redLed;

  private static final double MESSAGE_INTERVAL = 1.0;
  private double nextMessageTime;

  public enum ChannelMode {
    INPUT,
    OUTPUT
  }

  /**
   * Constructor for the OnBoardIO
   *
   * @param dio1 Mode for DIO 1 (input = Button B, output = green LED).
   * @param dio2 Mode for DIO 2 (input = Button C, output = red LED).
   */
  public OnBoardIO(ChannelMode dio1, ChannelMode dio2) {
    if (dio1 == ChannelMode.INPUT) {
      buttonB = new DigitalInput(RobotMap.BBUTTON);
    } else {
      greenLed = new DigitalOutput(RobotMap.GREENLED);
    }

    if (dio2 == ChannelMode.INPUT) {
      buttonC = new DigitalInput(RobotMap.CBUTTON);
    } else {
      redLed = new DigitalOutput(RobotMap.REDLED);
    }
  }

  /** Gets if the A button is pressed. */
  public boolean getButtonAPressed() {
    return buttonA.get();
  }

  /** Gets if the B button is pressed. */
  public boolean getButtonBPressed() {
    if (buttonB != null) {
      return buttonB.get();
    }

    double currentTime = Timer.getFPGATimestamp();
    if (currentTime > nextMessageTime) {
      DriverStation.reportError("Button B was not configured", true);
      nextMessageTime = currentTime + MESSAGE_INTERVAL;
    }
    return false;
  }

  /** Gets if the C button is pressed. */
  public boolean getButtonCPressed() {
    if (buttonC != null) {
      return buttonC.get();
    }

    double currentTime = Timer.getFPGATimestamp();
    if (currentTime > nextMessageTime) {
      DriverStation.reportError("Button C was not configured", true);
      nextMessageTime = currentTime + MESSAGE_INTERVAL;
    }
    return false;
  }

  /** Sets the green LED. */
  public void setGreenLed(boolean value) {
    if (greenLed != null) {
      greenLed.set(value);
    } else {
      double currentTime = Timer.getFPGATimestamp();
      if (currentTime > nextMessageTime) {
        DriverStation.reportError("Green LED was not configured", true);
        nextMessageTime = currentTime + MESSAGE_INTERVAL;
      }
    }
  }

  /** Sets the red LED. */
  public void setRedLed(boolean value) {
    if (redLed != null) {
      redLed.set(value);
    } else {
      double currentTime = Timer.getFPGATimestamp();
      if (currentTime > nextMessageTime) {
        DriverStation.reportError("Red LED was not configured", true);
        nextMessageTime = currentTime + MESSAGE_INTERVAL;
      }
    }
  }

  /** Sets the yellow LED. */
  public void setYellowLed(boolean value) {
    yellowLed.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
