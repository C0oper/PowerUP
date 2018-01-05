package org.usfirst.frc.team1677.robot.subsystems;

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
	
	
}
