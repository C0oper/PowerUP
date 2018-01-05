package org.usfirst.frc.team1677.robot.controller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class SideWinder {
	private static final Joystick controller = new Joystick(0);

	private static Button button_a = new JoystickButton(controller, 0);
	private static Button button_b = new JoystickButton(controller, 1);
	private static Button button_c = new JoystickButton(controller, 2);
	private static Button button_x = new JoystickButton(controller, 3);
	private static Button button_y = new JoystickButton(controller, 4);
	private static Button button_z = new JoystickButton(controller, 5);
	
	private static Button button_lt = new JoystickButton(controller, 6);
	private static Button button_rt = new JoystickButton(controller, 7);
	
	private static Button button_start = new JoystickButton(controller, 8);
	private static Button button_select = new JoystickButton(controller, 9);
	
	private double axis_x; // Axis 0
	private double axis_y; // Axis 1
	
	private Boolean value_button_a;
	private Boolean value_button_b;
	private Boolean value_button_c;
	private Boolean value_button_x;
	private Boolean value_button_y;
	private Boolean value_button_z;
	private Boolean value_button_lt;
	private Boolean value_button_rt;
	private Boolean value_button_start;
	private Boolean value_button_select;
	
	public double getX() {
		axis_x = controller.getRawAxis(0);
		return axis_x;
	}
	
	public double getY() {
		axis_y = controller.getRawAxis(1);
		return axis_y;
	}
	
	public boolean get_button_a() {
		value_button_a = button_a.get();
		return value_button_a;
	}
	
	public boolean get_button_b() {
		value_button_b = button_b.get();
		return value_button_b;
	}
	
	public boolean get_button_c() {
		value_button_c = button_c.get();
		return value_button_c;
	}
	
	public boolean get_button_x() {
		value_button_x = button_x.get();
		return value_button_x;
	}
	
	public boolean get_button_y() {
		value_button_y = button_y.get();
		return value_button_y;
	}
	
	public boolean get_button_z() {
		value_button_z = button_z.get();
		return value_button_z;
	}
	
	public boolean get_button_lt() {
		value_button_lt = button_lt.get();
		return value_button_lt;
	}
	
	public boolean get_button_rt() {
		value_button_rt = button_rt.get();
		return value_button_rt;
	}
	
	public boolean get_start() {
		value_button_start = button_start.get();
		return value_button_start;
	}
	
	public boolean get_select() {
		value_button_select = button_select.get();
		return value_button_select;
	}
	
	public void reset() {
		axis_x = 0.0;
		axis_y = 0.0;
		
		value_button_a = false;
		value_button_b = false;
		value_button_c = false;
		value_button_x = false;
		value_button_y = false;
		value_button_z = false;
		value_button_lt = false;
		value_button_rt = false;
		value_button_start = false;
		value_button_select = false;
	}
	
}
