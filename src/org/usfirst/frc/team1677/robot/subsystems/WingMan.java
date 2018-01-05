package org.usfirst.frc.team1677.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class WingMan {
	private static final Joystick controller = new Joystick(0);
	
	private static final Button trigger = new JoystickButton(controller, 0);
	private static final Button left_top = new JoystickButton(controller, 1);
	private static final Button left_bottom = new JoystickButton(controller, 2);
	private static final Button right_top = new JoystickButton(controller, 3);
	private static final Button right_bottom = new JoystickButton(controller, 4); 
	
	private static final Button base_top = new JoystickButton(controller, 5);
	private static final Button base_bottom = new JoystickButton(controller, 6);
	
	private static double axis_x; // One
	private static double axis_y; // Zero
	
	private static boolean value_trigger;
	private static boolean value_left_top;
	private static boolean value_left_bottom;
	private static boolean value_right_top;
	private static boolean value_right_bottom;
	
	private static boolean value_base_top;
	private static boolean value_base_bottom;

	public double getX() {
		axis_x = controller.getRawAxis(1);
		return axis_x;
	}
	
	public double getY() {
		axis_y = controller.getRawAxis(0);
		return axis_y;
	}
	
	public boolean get_Trigger() {
		value_trigger = trigger.get();
		return value_trigger;
	}
	
	public boolean get_Left_Top() {
		value_left_top = left_top.get();
		return value_left_top;
	}
	
	public boolean get_Left_Bottom() {
		value_left_bottom = left_bottom.get();
		return value_left_bottom;
	}
	
	public boolean get_Right_Top() {
		value_right_top = right_top.get();
		return value_right_top;
	}
	
	public boolean get_Right_Bottom() {
		value_right_bottom = right_bottom.get();
		return value_right_bottom;
	}
	
	public boolean get_Base_Top() {
		value_base_top = base_top.get();
		return value_base_top;
	}
	
	public boolean get_Base_Bottom() {
		value_base_bottom = base_bottom.get();
		return value_base_bottom;
	}
	
	public void reset() {
		axis_x = 0.0;
		axis_y = 0.0;
	
		value_trigger = false;
		
		value_left_top = false;
		value_left_bottom = false;
		
		value_right_top = false;
		value_right_bottom = false;
		
		value_base_top = false;
		value_base_bottom = false;
	}

}
