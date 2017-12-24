package org.usfirst.frc.team1677.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	private static Joystick Driver = new Joystick(0);
	private static final Button a_function = new JoystickButton(Driver, 1);
	private static final Button b_function = new JoystickButton(Driver, 2);
	private static final Button x_function = new JoystickButton(Driver, 3);
	private static final Button y_function = new JoystickButton(Driver, 4);
	private static final Button lb_function = new JoystickButton(Driver, 5);
	private static final Button rb_function = new JoystickButton(Driver, 6);
	private static final Button select_function = new JoystickButton(Driver, 7);
	private static final Button start_function = new JoystickButton(Driver, 8);

	
	/* Joy Stick Functions
	 *  - Negative Values - Forward
	 *  - Positive Values - Backwards
	 */
	private static double left_x = 0.0;
	private static double left_y = 0.0;
	private static double right_x = 0.0;
	private static double right_y = 0.0;
	private static double lt_axis = 0.0;
	private static double rt_axis = 0.0;
	
	public static double getLeft_x() {
		left_x = Driver.getRawAxis(1);
		return left_x;
	}
	
	public static double getLeft_y() {
		left_y = Driver.getRawAxis(2);
		return left_y;
	}
	
	public static double getRight_x() {
		right_x = Driver.getRawAxis(4);
		return right_x;
	}
	
	public static double getRight_y() {
		right_y = Driver.getRawAxis(5);
		return right_y;
	}
	
}

