// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.event.BooleanEvent;
import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * Handle input from SNES controllers connected to the Driver Station.
 *
 * <p>This class handles SNES input that comes from the Driver Station. Each time a value is
 * requested, the most recent value is returned. There is a single class instance for each controller
 * and the mapping of ports to hardware buttons depends on the code in the Driver Station.
 */
public class SNESController extends GenericHID {
    /** Represents a digital button on an SNESController. */
    public enum Button {  
        XButton(1),
        AButton(2),
        BButton(3),
        YButton(4),
        LeftBumper(5),
        RightBumper(6),
        SelectButton(9),
        StartButton(10);

        public final int value;

        Button(int value) {
            this.value = value;
        }

        /**
         * Get the human-friendly name of the button.
         *
         * @return The human-friendly name of the button.
         */
        @Override
        public String toString() {
            return this.name();
        }
    }

    /** Represents an axis on an SNESController. */
    public enum Axis {
        XAxis(0),
        YAxis(1);
        
        public final int value;

        Axis(int value) {
            this.value = value;
        }

        /**
         * Get the human-friendly name of the axis.
         *
         * @return The human-friendly name of the axis.
         */
        @Override
        public String toString() {
            return this.name();
        }
    }

    /**
     * Construct an instance of a controller.
     *
     * @param port The port index on the Driver Station that the controller is plugged into.
     */
    public SNESController(final int port) {
        super(port);

        HAL.report(tResourceType.kResourceType_Controller, port + 1);
    }

    /** Returns the value of the X axis. */
    public double getXAxis() {
        return getRawAxis(Axis.XAxis.value);
    }

    /** Returns the value of the Y axis. */
    public double getYAxis() {
        return getRawAxis(Axis.YAxis.value);
    }

    /** Returns the state of the left bumper (L button) on the controller. */
    public boolean getLeftBumper() {
        return getRawButton(Button.LeftBumper.value);
    }

    /** Returns the state of the right bumper (R button) on the controller. */
    public boolean getRightBumper() {
        return getRawButton(Button.RightBumper.value);
    }

    /** Returns whether the left bumper (L) was pressed since the last check. */
    public boolean getLeftBumperPressed() {
        return getRawButtonPressed(Button.LeftBumper.value);
    }

    /** Returns whether the right bumper (R) was pressed since the last check. */
    public boolean getRightBumperPressed() {
        return getRawButtonPressed(Button.RightBumper.value);
    }

    /** Returns whether the left bumper (L) was released since the last check. */
    public boolean getLeftBumperReleased() {
        return getRawButtonReleased(Button.LeftBumper.value);
    }

    /** Returns whether the right bumper (R) was released since the last check. */
    public boolean getRightBumperReleased() {
        return getRawButtonReleased(Button.RightBumper.value);
    }

    /**
     * Constructs an event instance around the left bumper's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the left bumper's digital signal attached to the given loop.
     */
    public BooleanEvent leftBumper(EventLoop loop) {
        return new BooleanEvent(loop, this::getLeftBumper);
    }

    /**
     * Constructs an event instance around the right bumper's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the right bumper's digital signal attached to the given loop.
     */
    public BooleanEvent rightBumper(EventLoop loop) {
        return new BooleanEvent(loop, this::getRightBumper);
    }

    /** Returns the state of the A button on the controller. */
    public boolean getAButton() {
        return getRawButton(Button.AButton.value);
    }

    /** Returns whether the A button was pressed since the last check. */
    public boolean getAButtonPressed() {
        return getRawButtonPressed(Button.AButton.value);
    }

    /** Returns whether the A button was released since the last check. */
    public boolean getAButtonReleased() {
        return getRawButtonReleased(Button.AButton.value);
    }

    /**
     * Constructs an event instance around the A button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the A button's digital signal attached to the given loop.
     */
    @SuppressWarnings("MethodName")
    public BooleanEvent a(EventLoop loop) {
        return new BooleanEvent(loop, this::getAButton);
    }

    /** Returns the state of the B button on the controller. */
    public boolean getBButton() {
        return getRawButton(Button.BButton.value);
    }

    /** Returns whether the B button was pressed since the last check. */
    public boolean getBButtonPressed() {
        return getRawButtonPressed(Button.BButton.value);
    }

    /** Returns whether the B button was released since the last check. */
    public boolean getBButtonReleased() {
        return getRawButtonReleased(Button.BButton.value);
    }

    /**
     * Constructs an event instance around the B button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the B button's digital signal attached to the given loop.
     */
    @SuppressWarnings("MethodName")
    public BooleanEvent b(EventLoop loop) {
        return new BooleanEvent(loop, this::getBButton);
    }

    /** Returns the state of the X button on the controller. */
    public boolean getXButton() {
        return getRawButton(Button.XButton.value);
    }

    /** Returns whether the X button was pressed since the last check. */
    public boolean getXButtonPressed() {
        return getRawButtonPressed(Button.XButton.value);
    }

    /** Returns whether the X button was released since the last check. */
    public boolean getXButtonReleased() {
        return getRawButtonReleased(Button.XButton.value);
    }

    /**
     * Constructs an event instance around the X button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the X button's digital signal attached to the given loop.
     */
    @SuppressWarnings("MethodName")
    public BooleanEvent x(EventLoop loop) {
        return new BooleanEvent(loop, this::getXButton);
    }

    /** Returns the state of the Y button on the controller. */
    public boolean getYButton() {
        return getRawButton(Button.YButton.value);
    }

    /** Returns whether the Y button was pressed since the last check. */
    public boolean getYButtonPressed() {
        return getRawButtonPressed(Button.YButton.value);
    }

    /** Returns whether the Y button was released since the last check. */
    public boolean getYButtonReleased() {
        return getRawButtonReleased(Button.YButton.value);
    }

    /**
     * Constructs an event instance around the Y button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the Y button's digital signal attached to the given loop.
     */
    @SuppressWarnings("MethodName")
    public BooleanEvent y(EventLoop loop) {
        return new BooleanEvent(loop, this::getYButton);
    }

    /** Returns the state of the select button on the controller. */
    public boolean getSelectButton() {
        return getRawButton(Button.SelectButton.value);
    }

    /** Returns whether the select button was pressed since the last check. */
    public boolean getSelectButtonPressed() {
        return getRawButtonPressed(Button.SelectButton.value);
    }

    /** Returns whether the select button was released since the last check. */
    public boolean getSelectButtonReleased() {
        return getRawButtonReleased(Button.SelectButton.value);
    }

    /**
     * Constructs an event instance around the select button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the select button's digital signal attached to the given loop.
     */
    public BooleanEvent select(EventLoop loop) {
        return new BooleanEvent(loop, this::getSelectButton);
    }

    /** Returns the state of the start button on the controller. */
    public boolean getStartButton() {
        return getRawButton(Button.StartButton.value);
    }

    /** Returns whether the start button was pressed since the last check. */
    public boolean getStartButtonPressed() {
        return getRawButtonPressed(Button.StartButton.value);
    }

    /** Returns whether the start button was released since the last check. */
    public boolean getStartButtonReleased() {
        return getRawButtonReleased(Button.StartButton.value);
    }

    /**
     * Constructs an event instance around the start button's digital signal.
     *
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the start button's digital signal attached to the given loop.
     */
    public BooleanEvent start(EventLoop loop) {
        return new BooleanEvent(loop, this::getStartButton);
    }
}