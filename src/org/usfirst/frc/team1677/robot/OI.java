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
		
		// Dead zone
		if(left_x <= 0.1) {
			left_x = 0.0;
		}
		if(left_x <= -0.1) {
			left_x = 0.0;
		}
		
		return left_x;
	}
	
	public static double getLeft_y() {
		left_y = Driver.getRawAxis(2);
		
		// Dead zone
		if(left_y <= 0.1) {
			left_y = 0;
		}
		if(left_y <= -0.1) {
			left_y = 0;
		}
		
		return left_y;
	}
		
	public static double getRight_x() {
		right_x = Driver.getRawAxis(4);
		
		// Dead zone
		if(right_x <= 0.1) {
			right_x = 0;
		}
		if(right_x <= -0.1) {
			right_x = 0;
		}
		
		return right_x;
	}
	
	public static double getRight_y() {
		right_y = Driver.getRawAxis(5);
	
		// Dead zone
		if(right_y <= 0.1) {
			right_y = 0;
		}
		if(right_y <= -0.1) {
			right_y = 0;
		}
		
		return right_y;
	}

	// For Debouce/Toggle functionality
	private static boolean a_status = false;
	private static boolean b_status = false;
	private static boolean x_status = false;
	private static boolean y_status = false;
	
	public static boolean getAToggle() {
		if( a_status == Driver.getRawButton(1)) {
			return a_status;
		}
		else {
			a_status = Driver.getRawButton(1);
		}
		return a_status;
		
	}
	
	public static boolean getBToggle() {
		if( b_status == Driver.getRawButton(2)) {
			return b_status;
		}
		else {
			b_status = Driver.getRawButton(2);
		}
		return b_status;
		
	}
	
	public static boolean getXToggle() {
		if( x_status == Driver.getRawButton(3)) {
			return x_status;
		}
		else {
			x_status = Driver.getRawButton(3);
		}
		return x_status;
		
	}
	
	public static boolean getYToggle() {
		if( y_status == Driver.getRawButton(4)) {
			return y_status;
		}
		else {
			y_status = Driver.getRawButton(4);
		}
		return y_status;
		
	}
	
	// Button Commands
	public static boolean getAButton() {
		a_status = Driver.getRawButton(1);
		return a_status;
		
	}
	
	public static boolean getBButton() {
		b_status = Driver.getRawButton(2);
		return b_status;
	}
	
	public static boolean getXButton() {
		x_status = Driver.getRawButton(3);
		return x_status;
	}
	
	public static boolean getYButton() {
		y_status = Driver.getRawButton(4);
		return y_status;
	}

}

