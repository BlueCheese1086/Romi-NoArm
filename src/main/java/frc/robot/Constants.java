// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * <ul>
 *     <li> RobotMap
 *     <ul>
 *         <li> ABUTTON
 *         <li> ARMSERVO
 *         <li> BBUTTON
 *         <li> CBUTTON
 *         <li> GREENLED
 *         <li> GRIPPERSERVO
 *         <li> LEFTAENCODER
 *         <li> LEFTBENCODER
 *         <li> LEFTMOTOR
 *         <li> REDLED
 *         <li> RIGHTAENCODER
 *         <li> RIGHTBENCODER
 *         <li> RIGHTMOTOR
 *         <li> WRISTSERVO
 *         <li> YELLOWLED
 *     </ul>
 *     <li> Motors
 *     <ul>
 *         <li> MAX_TURN
 *         <li> MAX_SPEED
 *         <li> DEADBAND
 *         <li> INCREMENT
 *     </ul>
 *     <li> Specs
 *     <ul>
 *         <li> CountsPerRevolution
 *         <li> WheelDiameterInch
 *     </ul>
 *     <li> Encoders
 *     <ul>
 *         <li> DistPerPulse
 *     </ul>
 * </ul>
 */
public final class Constants {
    public final class RobotMap {
        public static final int ABUTTON = 0;
        public static final int ARMSERVO = 2;
        public static final int BBUTTON = 1;
        public static final int CBUTTON = 2;
        public static final int GREENLED = 1;
        public static final int GRIPPERSERVO = 3;
        public static final int LEFTAENCODER = 4;
        public static final int LEFTBENCODER = 5;
        public static final int LEFTMOTOR = 0;
        public static final int REDLED = 2;
        public static final int RIGHTAENCODER = 6;
        public static final int RIGHTBENCODER = 7;
        public static final int RIGHTMOTOR = 1;
        public static final int WRISTSERVO = 4;
        public static final int YELLOWLED = 3;
    }

    public final class Motors {
        public static final double MAX_TURN = 0.5;
        public static final double MAX_SPEED = 0.5;
        public static final double DEADBAND = 0.2;
        public static final double INCREMENT = 2;
    }

    public final class Specs {
        private static final double CountsPerRevolution = 1440.0;
        private static final double WheelDiameterInch = 2.75591;
    }

    public final class Encoders {
        public static final double DistPerPulse = (Math.PI * Specs.WheelDiameterInch) / Specs.CountsPerRevolution;
    }
}