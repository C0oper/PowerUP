package org.usfirst.frc.team1677.robot;

public class RobotMap {
	public static final int LeftMaster = 0;
	public static final int RightMaster = 1;
	
	/*
	 * Remember that these ports are assigned via the 
	 * way you plug them in.
	 * 
	 * IE 
	 * driver port 0 would be the first thing you plug in
	 * 
	 */
	public static final int DriverPort = 0;
	public static final int CoDriverPort = 1;
	
	public static final int LeftEncoder_One = 0;
	public static final int LeftEncoder_Two = 1;

	public static final int EncoderInch = 76;

	/*
	 * PID Values
	 * Remember to check the Pid_Controller.class or Pid_Example.class
	 * for deeper understanding of what these values do.
	 * 
	 * Resources For PID
	 * https://en.wikipedia.org/wiki/PID_controller
	 * https://en.wikipedia.org/wiki/Open-loop_controller
	 * 
	 * To Tune PID I would suggest you specifically look at this section
	 * https://en.wikipedia.org/wiki/PID_controller#Loop_tuning
	 * 							and
	 * https://en.wikipedia.org/wiki/PID_controller#Overview_of_methods
	 * 
	 * Visual Representation of what P, I and, D
	 * https://upload.wikimedia.org/wikipedia/commons/3/33/PID_Compensation_Animated.gif
	 * 
	 */
	public static final double P = 0.5;
	public static final double I = 0.1;
	public static final double D = 0.0;
	
	
	
}
